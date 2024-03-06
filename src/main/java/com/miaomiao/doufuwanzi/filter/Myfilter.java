package com.miaomiao.doufuwanzi.filter;

import com.miaomiao.doufuwanzi.business.RedisManageService;
import com.miaomiao.doufuwanzi.enums.ErrorCode;
import com.miaomiao.doufuwanzi.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "Filter", urlPatterns = {"/*"})
public class Myfilter implements Filter {

    private final List<String> ALLOWED_PATH_LIST = new ArrayList<>();

    @Autowired
    private RedisManageService redisManageService;

    @Override
    public void init(FilterConfig filterConfig) {
        // 初始化逻辑
        ALLOWED_PATH_LIST.add("/file/tmp/download");
        ALLOWED_PATH_LIST.add("/user/register");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 排除注册接口
        String path = httpServletRequest.getRequestURI();
        boolean allowedPath = checkAllowedPath(path);
        if (allowedPath) {
            chain.doFilter(request, response);
        } else {
            // 登录状态校验,重新设置时间
            String token = httpServletRequest.getHeader("token");
            String phone = httpServletRequest.getHeader("phone");
            if (token == null) {
                throw new BusinessException(ErrorCode.USER_NOT_LOGIN);
            }
            redisManageService.verifyLoginStatus(token, phone);
            redisManageService.expireLoginStatus(token, 7 * 24 * 60 * 60L);
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // 清理资源，在Filter生命周期结束时调用
    }

    /**
     * 检查是否允许访问
     *
     * @param path
     * @return
     */
    private boolean checkAllowedPath(String path) {
        for (String uri : ALLOWED_PATH_LIST) {
            boolean allowed = path.contains(uri);
            if (allowed) {
                return true;
            }
        }
        return false;
    }
}
