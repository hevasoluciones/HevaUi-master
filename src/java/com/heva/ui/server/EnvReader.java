package com.heva.ui.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class EnvReader {
	private Properties props = new Properties();

    public  EnvReader(){
        try {
            URL url = this.getClass().getResource("config.ini");
            FileInputStream pin = new FileInputStream(url.getFile());
            props.load(pin);
        } catch (IOException ex) {
        	System.out.println("Error leyendo config.ini");
        	throw new RuntimeException(ex);            
        }
   }
  
   public  String getProperty(String propertyName){
	   return props.getProperty(propertyName);
   }
   
   public String getEnvVar(String var){
	   String env_var = null;

       if( (env_var = System.getenv().get(var))==null){
           System.out.println("Error leyendo variable " + var);
           throw new RuntimeException("Missing environment variable " + var);
       }

       return env_var;
   }

}
