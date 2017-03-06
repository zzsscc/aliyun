package com.eshutech.biz.util.http;

import com.alibaba.fastjson.JSON;
import com.eshutech.biz.exception.ServiceException;
import com.eshutech.biz.factory.log.LogInfo;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.nio.client.DefaultHttpAsyncClient;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author:Lajiao
 * @Date:2014年8月21日
 * @Time:下午12:42:13
 * @Description:请求基础类
 */
public class HttpPostRequest {
    public static final String DEFAULT_ENCODE            = "UTF-8";
    public static final String DEFAULT_HTTP_CONTENT_TYPE = "application/json;charset=UTF-8";

    public static String doPost(String url, String content) {
        HttpAsyncClient httpClient = null;
        String s = UUID.randomUUID().toString();
        String rid = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        try {
            LogInfo.BI("800001", rid, rid, "SdkRequest send:url:{}-content:{}", new Object[]{url, content});
            httpClient = new DefaultHttpAsyncClient();
            httpClient.start();
            HttpPost request = new HttpPost(url);
            request.setEntity(new ByteArrayEntity(content.getBytes(DEFAULT_ENCODE)));
            request.setHeader("Content-Type", DEFAULT_HTTP_CONTENT_TYPE);
            Future<HttpResponse> future = httpClient.execute(request, null);
            HttpResponse response = future.get(10, TimeUnit.SECONDS);
            String responseEntity = EntityUtils.toString(response.getEntity(), DEFAULT_ENCODE);
            LogInfo.BI("800002", rid, rid, "SdkRequest send:RESP:{}", new Object[]{responseEntity});
            return responseEntity;
        } catch (InterruptedException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send InterruptedException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (ExecutionException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send ExecutionException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (TimeoutException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send TimeoutException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send Exception:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String doPost(String url, String content, int time) {
        // 发送邮件
        HttpAsyncClient httpClient = null;
        String s = UUID.randomUUID().toString();
        String rid = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        try {
            LogInfo.BI("800001", rid, rid, "SdkRequest send:url:{}-content:{}", new Object[]{url, content});
            httpClient = new DefaultHttpAsyncClient();
            httpClient.start();
            HttpPost request = new HttpPost(url);

            request.setEntity(new ByteArrayEntity(content.getBytes(DEFAULT_ENCODE)));
            request.setHeader("Content-Type", DEFAULT_HTTP_CONTENT_TYPE);

            Future<HttpResponse> future = httpClient.execute(request, null);
            HttpResponse response = future.get(time, TimeUnit.SECONDS);
            String responseEntity = EntityUtils.toString(response.getEntity(), DEFAULT_ENCODE);
            LogInfo.BI("800002", rid, rid, "SdkRequest send:RESP:{}", new Object[]{responseEntity});
            return responseEntity;
        } catch (InterruptedException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send InterruptedException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (ExecutionException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send ExecutionException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (TimeoutException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send TimeoutException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send Exception:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String doPostKv(String url, List<NameValuePair> parameters, int time) {
        // 发送邮件
        HttpAsyncClient httpClient = null;
        String s = UUID.randomUUID().toString();
        String rid = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        try {
            LogInfo.BI("800001", rid, rid, "SdkRequest send:url:{}-content:{}", new Object[]{url, JSON.toJSONString(parameters)});
            httpClient = new DefaultHttpAsyncClient();
            httpClient.start();
            HttpPost request = new HttpPost(url);

            UrlEncodedFormEntity ent = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
            request.setEntity(ent);
            request.setHeader("Content-Type", DEFAULT_HTTP_CONTENT_TYPE);

            Future<HttpResponse> future = httpClient.execute(request, null);
            HttpResponse response = future.get(time, TimeUnit.SECONDS);
            String responseEntity = EntityUtils.toString(response.getEntity(), DEFAULT_ENCODE);
            LogInfo.BI("800002", rid, rid, "SdkRequest send:RESP:{}", new Object[]{responseEntity});
            return responseEntity;
        } catch (InterruptedException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send InterruptedException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (ExecutionException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send ExecutionException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (TimeoutException ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send TimeoutException:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            LogInfo.BI("800003", rid, rid, "SdkRequest send Exception:{}", new Object[]{ex.getMessage()});
            ex.printStackTrace();
            return null;
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * POST请求
     *
     * @param linkId
     * @param url
     * @param content
     * @param time
     * @return
     * @throws ServiceException
     */
    public static String httpPostKv(String linkId, String url, String content, int time) throws ServiceException {
        // 返回结果
        PrintWriter out = null;
        BufferedReader in = null;
        String responseString = null;
        try {
            LogInfo.BI("9001", "httpPostKv", linkId, "HttpPost send:url:{}-content:{}", new Object[]{url, content});
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection urlConnection = realUrl.openConnection();
            urlConnection.setConnectTimeout(time);
            urlConnection.setReadTimeout(time);
            // 设置通用的请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            // 发送POST请求必须设置如下两行
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(urlConnection.getOutputStream());
            // 发送请求参数
            out.print(content);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                responseString += line;
            }
            LogInfo.BI("9002", "httpPostKv", linkId, "HttpPost response:{}", new Object[]{responseString});
            return responseString;
        } catch (IOException e) {
            throw new ServiceException("9003", "IOException:" + e.getMessage());
        } catch (Exception e) {
            throw new ServiceException("9004", "IOException:" + e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServiceException("9005", "IOException:" + e.getMessage());
            }
        }
    }
}
