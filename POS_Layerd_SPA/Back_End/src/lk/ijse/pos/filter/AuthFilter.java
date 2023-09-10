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
        System.out.println("Auth Filter Invoke");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        System.out.println("Auth Filter Do Filter Invoked");

        String auth = req.getHeader("Auth");

        if (req.getMethod().equals("OPTIONS")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (auth != null && auth.equals("user=admin,pass=admin")) {
                //forward the request to the requested servlet
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //otherwise send a json object that the clint is not allowed
                //to access the service
                res.addHeader("Content-Type", "application/json");
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                JsonObject jsonObject = ResponseUtil.getJson("Auth-Error", "You are not Authenticated to use this Service.!");
                res.getWriter().print(jsonObject);
            }
            //}

        }
    }

    @Override
    public void destroy() {

    }
}
