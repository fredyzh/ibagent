package com.stabletrader.v2.ibagent.dataservice;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertyEnvironmentAware implements EnvironmentAware {
	
	private Environment environment;

	@Override
	public void setEnvironment(Environment environment) {
		 this.environment = environment;
	}
	
	public  String getProperty(String key) {
	    return environment.getProperty(key);
	}

}
