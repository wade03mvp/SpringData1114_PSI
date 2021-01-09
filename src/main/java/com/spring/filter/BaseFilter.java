package com.spring.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
public class BaseFilter extends HttpFilter {
    @Override
    public void init() throws ServletException {
        super.init();
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getFilterConfig().getServletContext());
    }
    
}
