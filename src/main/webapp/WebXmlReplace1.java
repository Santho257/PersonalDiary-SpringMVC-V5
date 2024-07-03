package com.santho.configurations;

//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.ServletRe

public class WebXmlReplace1 implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

//        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(FrontConfig.class);

        DispatcherServlet ds = new DispatcherServlet(webApplicationContext);

//        ServletRegistration.Dynamic sr = servletContext.addServlet("ds", ds);
//
//        sr.setLoadOnStartup(1);
//        sr.addMapping("/");
    }
}
