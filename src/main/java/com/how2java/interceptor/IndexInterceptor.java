package com.how2java.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:Mr.wang
 * @date:2019/3/6 0006 下午 4:07
 * 配置拦截器
 * /**
 *      * 在业务处理器处理请求之前被调用
 *      * 如果返回false
 *      *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
 *      * 如果返回true
 *      *    执行下一个拦截器,直到所有的拦截器都执行完毕
 *      *    再执行被拦截的Controller
 *      *    然后进入拦截器链,
 *      *    从最后一个拦截器往回执行所有的postHandle()
 *      *    接着再从最后一个拦截器往回执行所有的afterCompletion()
 *      */
public class IndexInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle(), 在访问Controller之前被调用");
        return true;
    }
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle(), 在访问Controller之后，访问视图之前被调用,这里可以注入一个时间到modelAndView中，用于后续视图显示");
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("afterCompletion(), 在访问视图之后被调用");
    }

}