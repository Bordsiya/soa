package com.example.backend;

import org.example.ejb.service.RestClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/backend");
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public Context context() throws NamingException {
		Properties jndiProps = new Properties();
		jndiProps.put("java.naming.factory.initial",
				"org.jboss.naming.remote.client.InitialContextFactory");
		jndiProps.put("jboss.naming.client.ejb.context", true);
		jndiProps.put("java.naming.provider.url",
				"http-remoting://localhost:8080");
		return new InitialContext(jndiProps);
	}

	@Bean
	public RestClientService restClientService(Context context)
			throws NamingException {

		return (RestClientService)
				context.lookup(this.getFullName(RestClientService.class));
	}

	private String getFullName(Class classType) {
		String moduleName = "ejb/";
		String beanName = classType.getSimpleName();
		String viewClassName = classType.getName();
		return moduleName + beanName + "!" + viewClassName;
	}
}
