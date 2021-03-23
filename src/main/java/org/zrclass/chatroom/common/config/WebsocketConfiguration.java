package org.zrclass.chatroom.common.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.util.WebAppRootListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@Configuration
public class WebsocketConfiguration implements ServletContextInitializer{

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(WebAppRootListener.class);
        servletContext.setInitParameter("org.apache.tomcat.websocket.textBufferSize","5242880");//5M
        servletContext.setInitParameter("org.apache.tomcat.websocket.binaryBufferSize","1024000");
	}
}
