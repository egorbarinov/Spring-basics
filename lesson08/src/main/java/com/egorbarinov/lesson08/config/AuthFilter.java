package com.egorbarinov.lesson08.config;


import com.egorbarinov.lesson08.domain.User;
import com.egorbarinov.lesson08.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class AuthFilter implements Filter {

    private final UserInfo userInfo;
    private final UserService userService;

    public AuthFilter(UserInfo userInfo, UserService userService) {
        this.userInfo = userInfo;
        this.userService = userService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User authUser = userService.auth(username, password);
        if(authUser == null){
            ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        userInfo.setUser(authUser);

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
