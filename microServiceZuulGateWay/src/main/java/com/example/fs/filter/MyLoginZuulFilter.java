package com.example.fs.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义登录过滤器
 */
@Component
public class MyLoginZuulFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * filterType：返回字符串代表过滤器类型，返回值有：
     * pre: 在请求路由之前执行
     * route: 在请求路由时调用
     * error: 处理请求发生错误时调用
     * post: 请求路由之后调用，也就是在 route 和 error 过滤器之后调用
     *
     * @return
     */
    @Override
    public String filterType() {
        //请求路由前调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        //int 值来定义过滤器的执行顺序，数值越小优先级越高
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //该过滤器是否执行，true执行 false不执行
        return true;
    }

    /**
     * 当前过滤器的业务逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        //获取请求参数token的值
        String token = httpServletRequest.getParameter("token");
        if (token == null) {
            logger.warn("此操作需要先登录系统。。。");
            requestContext.setSendZuulResponse(false);//拒绝访问
            requestContext.setResponseStatusCode(200);//设置响应状态码
            try {
                requestContext.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
