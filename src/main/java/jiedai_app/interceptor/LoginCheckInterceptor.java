package jiedai_app.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jiedai_app.pojo.Result;
import jiedai_app.utils.JwtUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求url
        String url =request.getRequestURI().toString();
        System.out.println(url);
        //判断url中是否包含login
        if (url.contains("login")){
            return true;
        }
        //如果是OPTIONS请求的话 进行直接放行
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            System.out.println("OPTIONS请求放行");
            return true;
        }
        //获取token
        String jwt =request.getHeader("Token");
        System.out.println(jwt);
        //判断token是否存在
        if (!StringUtils.hasLength(jwt)){
            Result error =Result.error("NOT_LOGIN");
            ObjectMapper objectMapper = new ObjectMapper();
            String noLogin = objectMapper.writeValueAsString(error);
            response.getWriter().write(noLogin);
            System.out.println("XXX");
            return false;
        }
        //解析token
        try {
            JwtUtils.parseJwt(jwt);
        }catch (Exception e){
            e.printStackTrace();
            Result error =Result.error("NOT_LOGIN");
            ObjectMapper objectMapper = new ObjectMapper();
            String noLogin = objectMapper.writeValueAsString(error);
            response.getWriter().write(noLogin);
            System.out.println(123);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
