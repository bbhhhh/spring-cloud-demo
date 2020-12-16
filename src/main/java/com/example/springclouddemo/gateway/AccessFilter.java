package com.example.springclouddemo.gateway;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Project: spring-eureka-server
 * @Author : haihuab
 * @Date : 2020/12/11 10:32
 * @Description: TODO
 */

public class AccessFilter extends ZuulFilter {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {} ", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("not found parameter token from request");
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("not found parameter token from request");
            ctx.getResponse().setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
            ctx.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            logger.info("check token ok");
        }
        return null;
    }
}
