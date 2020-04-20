/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author green
 */
public class webFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest fRequest = (HttpServletRequest) request;
            HttpServletResponse fResponse = (HttpServletResponse) response;
            //get the URI of the current site
            String URI = fRequest.getRequestURI();

            //check if the URI end with .jsp or not,
            if (URI.endsWith("error.jsp")) {
                //if it does , redirect to front controller
                fRequest.getRequestDispatcher("error.jsp").forward(request, response);
            } else if (URI.endsWith(".jsp")) {
                fResponse.sendRedirect("front");
            }else{
                chain.doFilter(request, response);
            }


        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    @Override
    public void destroy() {
    }

}
