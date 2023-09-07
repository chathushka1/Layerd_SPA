package lk.ijse.pos.filter;

import lk.ijse.pos.util.ResponseUtil;

import javax.json.JsonObject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AUth filter Invoked");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.println("Auth filter do filter Invoked");

        String auth = request.getHeader("Auth");

        if(request.getMethod().equals("OPTION")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            if (auth != null && auth.equals("user=admin,pass=admin")){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                response.addHeader("Content-Type","application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                JsonObject jsonObject = ResponseUtil.getJson("Auth-Error","You are not Authentic to use this Service.!");
                response.getWriter().print(jsonObject);
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("Auth filter destroy");
    }
}
