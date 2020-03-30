package com.baconfire.onboardwebapp.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Component
@Aspect
public class ResponseHeaderAspect {

    @After("com.baconfire.onboardwebapp.aop.PointCuts.inWebLayer()")
    public void addResponseAuthHeader() {
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            roles.append(authority.toString()).append(",");
        }

        if (httpServletResponse != null)
            httpServletResponse.addHeader("Roles", roles.substring(0, roles.length() - 1));
    }
}
