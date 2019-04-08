package MAIN;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class tes {
	
	public  InputStream sss() {
		 	 InputStream in=this.getClass().getClassLoader().getResourceAsStream("config.properties");
return in;
		
	}
	
	 InputStream in=this.getClass().getClassLoader().getResourceAsStream("config.properties");

	
public static void main(String[] args) throws IOException {
	
	
	Properties properties = new Properties();  

	 properties.load(new tes().sss());
	  String password = properties.getProperty("AccessKeyId");
     System.out.println(password);
}
}