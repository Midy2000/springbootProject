/*package jiedai_app.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jiedai_app.pojo.Result;
import jiedai_app.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest) servletRequest;
        HttpServletResponse res =(HttpServletResponse) servletResponse;

        String url =req.getRequestURI().toString();
        System.out.println(url);
        if (url.contains("login")){
            chain.doFilter(req,res);
            return;
        }
        String jwt =req.getHeader("token");
        System.out.println(jwt);
        if (!StringUtils.hasLength(jwt)){
            log.info("请求头为空");
            Result error =Result.error("NOT_LOGIN");
            ObjectMapper objectMapper = new ObjectMapper();
            String noLogin = objectMapper.writeValueAsString(error);
            res.getWriter().write(noLogin);
            return;
        }
        try {
            JwtUtils.parseJwt(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败");
            Result error =Result.error("NOT_LOGIN");
            ObjectMapper objectMapper = new ObjectMapper();
            String noLogin = objectMapper.writeValueAsString(error);
            res.getWriter().write(noLogin);
            return;
        }
        log.info("令牌合法，放行");
        chain.doFilter(req,res);
    }
}
*/