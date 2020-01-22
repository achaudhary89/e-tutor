package com.alok.mytutorwebapp.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component
public class RateLimitingInterceptor implements HandlerInterceptor {
    Map<String, Optional<SimpleRateLimitor>> limitorMap =   new ConcurrentHashMap<>();
   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String url  =   request.getRequestURI();
            SimpleRateLimitor rateLimitor   =   getSimpleRateLimitorForRequest(url);
            boolean allow   =   rateLimitor.tryAcquire();
            if(!allow){
                System.out.println("NOT ALLOWED");
                response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
                response.sendRedirect("/limit");


            }


        return allow;
    }*/

    private  SimpleRateLimitor getSimpleRateLimitorForRequest(String url) {
        if(limitorMap.containsKey(url)){
            return limitorMap.get(url).get();
        }else{
            synchronized (url.intern()){
                if(limitorMap.containsKey(url)){
                    return limitorMap.get(url).get();
                }
                SimpleRateLimitor rateLimitor   =   SimpleRateLimitor.create(TimeUnit.MINUTES, 30);
                limitorMap.put(url, Optional.of(rateLimitor));
                return rateLimitor;
            }

        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      // if(HttpStatus.TOO_MANY_REQUESTS.value() == response.getStatus())
      //  response.sendRedirect("/limit");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
