package MAIN;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TimerTask;


import domain.addAlidn;
import domain.updateDomain;
import ip_query.ip;

public class ddns_factory  extends TimerTask {
	
	
	private String AccessKeyId;
	private String AccessKeySecret;
	
	private String recordIp=null;
	
	private String domain;
	private String recordId;
	
	
	ip IP=new ip();
	

	public void run() {
		
		
		
		
		Properties properties = new Properties();  
	 InputStream in=this.getClass().getClassLoader().getResourceAsStream("config.properties");

		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     
	     
	     
	     AccessKeyId = properties.getProperty("AccessKeyId");
	     System.out.println( AccessKeyId);
	     AccessKeySecret=properties.getProperty("AccessKeySecret");
	     System.out.println(AccessKeySecret);
	     domain=properties.getProperty("domain");
	     System.out.println(domain);
	     
	     
	  //···········································   
	     
	     
		
		if(recordIp==null) {
			
			
			recordIp=IP.getIP();
			
			addAlidn addalidns=new addAlidn(recordIp, domain, AccessKeyId, AccessKeySecret);
			
			recordId=addalidns.setDomains();
			System.out.println("初次运行域名绑定为"+recordIp);
			
		}else {
			
			String ip=IP.getIP();
			if(ip.equals(recordIp)) {
				System.out.println("Ip没有变化");
			}else {
				
				updateDomain updatedomain=new updateDomain(AccessKeyId,  AccessKeySecret, recordId, ip);
				updatedomain.update();
				ip=recordIp;
				System.out.println("IP改变进行了新的绑定，新的IP为"+recordIp);
				
				
				
			}
			
		}
		
		
		
	}

}
