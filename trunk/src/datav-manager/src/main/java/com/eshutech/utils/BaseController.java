package com.eshutech.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lajiao
 * @date: 2012-9-24
 */
public abstract class BaseController {

    /**
     * 直接跳转
     *
     * @param _req
     * @param _resp
     * @param url
     */
    public final static void forward(HttpServletRequest _req,
                                     HttpServletResponse _resp, String url) {
        try {
            _req.getRequestDispatcher(url).forward(_req, _resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接跳转
     *
     * @param _req
     * @param _resp
     * @param url
     */
    public final static void forward(HttpServletRequest _req,
                                     HttpServletResponse _resp, String url, Model model) {
        try {
            _req.setAttribute("model", model);
            _req.getRequestDispatcher(url).forward(_req, _resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重定向
     *
     * @param _resp
     * @param url
     */
    public final static void redirect(HttpServletResponse _resp, String url) {
        try {
            _resp.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接跳转
     *
     * @param jsp
     * @return
     */
    public final static String _forward(String jsp) {
        return jsp;
    }

    /**
     * 重定向
     *
     * @param path
     */
    public final static String _redirect(String path) {
        return "redirect:" + path;
    }

    /**
     * 跳转到错误页面
     *
     * @param _req
     * @param _resp
     * @param error
     */
    public final static void forwardError(HttpServletRequest _req,
                                          HttpServletResponse _resp, String error) {
        try {
            _req.setAttribute("error", "<!-错误信息提示：" + error + "  错误信息结束->");
            _req.getRequestDispatcher("/error.do").forward(_req, _resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出HTML-VM模板
     *
     * @param _resp
     * @throws java.io.IOException
     */
    public final static void html(HttpServletResponse _resp) {
        _resp.setContentType("text/html");
        _resp.setCharacterEncoding("utf-8");
    }

    public final static void echoHtml(HttpServletRequest _req,
                                      HttpServletResponse _resp, Model model, String tpl)
            throws IOException {
        html(_resp);
        model.addAttribute("request", _req);
        model.addAttribute("response", _resp);
        model.addAttribute("session", _req.getSession());
        model.addAttribute("cookie", _req.getCookies());

        echo(_resp, model, tpl);
    }

    public final static void echo(HttpServletResponse _resp, Model model,
                                  String tpl) throws IOException {
        json(_resp);
        _resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = _resp.getWriter();
        out.write(tpl);
        out.flush();
        out.close();
        return;
    }

    /**
     * 输出JSON
     *
     * @param _resp
     */
    public final static void json(HttpServletResponse _resp) {
        _resp.setContentType("application/json;charset=utf-8");
        _resp.setCharacterEncoding("utf-8");
    }

    public final static void echoJson(HttpServletResponse _resp, Model model,
                                      Object tpl) throws IOException {
        json(_resp);
        _resp.setHeader("Access-Control-Allow-Origin", "*");
        if (tpl != null) {
            _resp.getWriter().write(JSON.toJSONString(tpl));
        }
        _resp.flushBuffer();
    }

    /**
     * 输出javascript
     *
     * @param _resp
     * @throws java.io.IOException
     */
    public final static void javascript(HttpServletResponse _resp) {
        _resp.setContentType("application/x-javascript;charset=utf-8");
        _resp.setCharacterEncoding("utf-8");
    }

    public final static void echoJavascript(HttpServletResponse _resp,
                                            Model model, String tpl) throws IOException {
        javascript(_resp);
        if (null != tpl) {
            _resp.getWriter().write(tpl);
        }
        _resp.flushBuffer();
    }

    /**
     * 输出字符串
     *
     * @param _resp
     * @throws java.io.IOException
     */
    public final static void echoString(HttpServletResponse _resp, String con)
            throws IOException {
        PrintWriter out = _resp.getWriter();
        out.write(con);
        out.flush();
        out.close();
        return;
    }

    /**
     * 获取客户端IP
     *
     * @param request
     * @return
     */
    public final static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
