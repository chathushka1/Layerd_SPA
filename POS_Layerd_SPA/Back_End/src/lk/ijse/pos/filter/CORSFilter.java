package lk.ijse.pos.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CORS Filter Invoked");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res= (HttpServletResponse) servletResponse;
        HttpServletRequest req= (HttpServletRequest) servletRequest;

        System.out.println("CROS Filter Do Filter Invoked");

        String method=req.getMethod();

        //filterChain.doFilter(servletRequest,servletResponse);

        if (method.equals("OPTIONS")){
            //res.setStatus(200);
            res.addHeader("Access-Control-Allow-Origin","*");
            res.addHeader("Access-Control-Allow-Methods","PUT, DELETE");
            res.addHeader("Access-Control-Allow-Headers","content-type,auth");
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            res.addHeader("Access-Control-Allow-Origin","*");
            res.addHeader("Content-Type","application/json");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }


    @Override
    public void destroy() {
        System.out.println("CORS Filter Destroyed");

    }
}
