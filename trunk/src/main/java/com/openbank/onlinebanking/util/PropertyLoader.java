package com.openbank.onlinebanking.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertyLoader  {

	private static Logger log = LoggerFactory.getLogger(PropertyLoader.class);
	
	public static String tomcatFolder;
	public static String projectFolder;

	static {
		PropertyLoader.init();
		tomcatFolder = System.getProperty("tomcatFolder").trim();
		projectFolder = System.getProperty("projectFolder").trim();
	}
	
	public static void init() {
		try{
			PropertyLoader p = new PropertyLoader();
			p.getPropertiesFromClasspath("application.properties");
		} catch (IOException e) {
			log.error("Error loading the properties {}", e);
		}
    }	
	

    
    
	private  Properties getPropertiesFromClasspath(String propFileName) throws IOException {
	    
	    Properties props = new Properties();
	    InputStream inputStream = this.getClass().getClassLoader()
	        .getResourceAsStream(propFileName);

	    if (inputStream == null) {
	        throw new FileNotFoundException("property file '" + propFileName
	            + "' not found in the classpath");
	    }

	    props.load(inputStream);
	    System.setProperties(props);
	    return props;
	}

}
