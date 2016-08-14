package org.sf.samples.bootstrap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.sf.samples.config.ViewConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(ViewConfiguration.class);
		ctx.setServletContext(servletContext);
		
		Dynamic dynamic = servletContext.addServlet("dispatcher-servlet", new DispatcherServlet(ctx));
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
	}

}