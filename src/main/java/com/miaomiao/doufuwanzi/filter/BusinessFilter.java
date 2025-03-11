package com.miaomiao.doufuwanzi.filter;

import com.alibaba.fastjson.JSONObject;
import com.miaomiao.doufuwanzi.business.RedisManageService;
import com.miaomiao.doufuwanzi.enums.RedisExpire;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author shangziyan
 * @description
 * @createDate 2025/3/11 15:11
 */
@WebFilter(filterName = "BaseFilter", urlPatterns = {"/doufu-wanzi/business/*"})
public class BusinessFilter implements Filter {

    @Resource
    private RedisManageService redisManageService;

    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        try {
            String key = httpServletRequest.getHeader("token");
            redisManageService.expireLoginStatus(key, RedisExpire.LOGIN_TOKEN);
            chain.doFilter(request, response); // 继续过滤链
        } catch (Exception e) {
            filterError(500, "Internal Server Error", httpServletResponse);
        }
    }

    private void filterError(int code, String msg, HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("message", msg);
        result.put("success", false);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}