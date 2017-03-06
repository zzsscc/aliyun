package com.eshutech.biz.util.http;


import com.eshutech.biz.exception.ServiceException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.DefaultHttpAsyncClient;
import org.apache.http.nio.IOControl;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.client.methods.AsyncCharConsumer;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 请求接口类
 *
 * @author chenbinwei
 */
public abstract class HttpSyncRequest {
    private static final Logger logger          = LoggerFactory.getLogger(HttpSyncRequest.class);
    private static       int    DEFAULT_TIMEOUT = 10;

    public static String httpSyncDate(String url) throws ServiceException {
        return httpSyncDate(url, DEFAULT_TIMEOUT);
    }

    public static String httpSyncDate(String url, int timeout) throws ServiceException {
        String response = null;
        HttpAsyncClient httpClient = null;
        // 请求同步接口
        try {
            httpClient = new DefaultHttpAsyncClient();
            httpClient.start();
            Future<String> future = httpClient.execute(HttpAsyncMethods.createGet(url.trim()), new MyResponseConsumer(), null);
            response = future.get(timeout, TimeUnit.SECONDS);
            logger.info(" [HttpSyncRequest]:[url:{},response:{}]", url, response);
        } catch (TimeoutException ex) {
            logger.error("[HttpSyncRequest] request error;[url:{},error:{}].", url, "request time out");
            throw new ServiceException("501", "request time out");
        } catch (Exception e) {
            logger.error("[HttpSyncRequest] request error;[url:{},error:{}].", url, e.getMessage());
            throw new ServiceException("502", e.getMessage());
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.shutdown();
                } catch (InterruptedException e) {
                    throw new ServiceException("503", e.getMessage());
                }
            }
        }
        return response;
    }

    public static String httpSyncDate(final String url, int timeout, Map<String, String> header) throws ServiceException {
        String response = null;
        HttpAsyncClient httpClient = null;
        // 请求同步接口
        try {
            httpClient = new DefaultHttpAsyncClient();
            httpClient.start();
            HttpGet httpGet = new HttpGet(URI.create(url.trim()));
            if (header != null) {
                Iterator<String> keys = header.keySet().iterator();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    String value = header.get(key);
                    httpGet.setHeader(key, value);
                }
            }
            Future<HttpResponse> future = httpClient.execute(httpGet, null);
            HttpResponse httpResponse = future.get(timeout, TimeUnit.SECONDS);
            response = EntityUtils.toString(httpResponse.getEntity());
            logger.info(" [HttpSyncRequest]:[url:{},response:{}]", url, response);
        } catch (TimeoutException ex) {
            logger.error("[HttpSyncRequest] request error;[url:{},error:{}].", url, "request time out");
            throw new ServiceException("501", "request time out");
        } catch (Exception e) {
            logger.error("[HttpSyncRequest] request error;[url:{},error:{}].", url, e.getMessage());
            throw new ServiceException("502", e.getMessage());
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.shutdown();
                } catch (InterruptedException e) {
                    throw new ServiceException("503", e.getMessage());
                }
            }
        }
        return response;
    }

    static class MyResponseConsumer extends AsyncCharConsumer<String> {
        private String result;

        @Override
        protected void onResponseReceived(final HttpResponse response) {
            result = new String();
        }

        @Override
        protected void onCharReceived(final CharBuffer buf, final IOControl ioctrl) throws IOException {
            result = buf.toString();
        }

        @Override
        protected String buildResult(final HttpContext context) {
            return result;
        }
    }
}
