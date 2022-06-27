package com.experiment.spring.spi.containerInitializer;

import org.springframework.web.SpringServletContainerInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author wuruohong
 * @date 2022-06-21 22:38
 */
public class MySpringInitialization extends SpringServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> webAppInitializerClasses, ServletContext servletContext) throws ServletException {
        servletContext.addServlet("spiServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.getWriter().write("hello");
            }
        }).addMapping("/hello");
    }
}
