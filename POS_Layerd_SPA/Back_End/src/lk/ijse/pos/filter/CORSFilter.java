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
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletRequest;
        System.out.println("CORS Filter do Filter Invoked");

        String method = request.getMethod();
        filterChain.doFilter(servletRequest, servletResponse);

        if (method.equals("OPTIONS")){
            response.addHeader("Access-Control-Allow-Origin","*");
            response.addHeader("Access-Control-Allow-Methods","PUT, DELETE");
            response.addHeader("Access-Control-Allow-Headers","content-type,auth");
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            response.addHeader("Access-Control-Allow-Origin","*");
            response.addHeader("Content-Type","application/json");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("CORS Filter Destroyed");

    }
}
