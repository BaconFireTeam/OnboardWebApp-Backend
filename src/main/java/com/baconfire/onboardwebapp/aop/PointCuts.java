package com.baconfire.onboardwebapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {

    /**
     * A join point is in the web layer if the method is defined
     * in a type in the com.xyz.someapp.web package
     * under that.
     */
    @Pointcut("within(com.baconfire.onboardwebapp.controller.*)")
    public void inWebLayer() {}
}