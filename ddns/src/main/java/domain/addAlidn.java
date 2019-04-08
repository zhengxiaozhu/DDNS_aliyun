package domain;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.AddDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.AddDomainRecordResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class addAlidn {

	private String ip;
	private String domain;
	private String AccessKeyId;
	private String AccessKeySecret;
	

    public addAlidn(String ip,String domain,String AccessKeyId, String AccessKeySecret) {
    	
    	this.ip=ip;
    	this.domain=domain;
    	this.AccessKeyId=AccessKeyId;
    	this.AccessKeySecret=AccessKeySecret;
    	
    }
    
    
    
    
    	public String setDomains() {
    	
    	String result = null;
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", this.AccessKeyId, this.AccessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        AddDomainRecordRequest request = new AddDomainRecordRequest();

        request.setValue(this.ip);
        request.setType("A");
        request.setRR("www");
        request.setDomainName(this.domain);

        try {
            AddDomainRecordResponse response = client.getAcsResponse(request);
            	result=  new Gson().toJson(response) ;
           
           
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            
        }
        
   	 JSONObject jsonObject = JSON.parseObject(result);
   	 String RecordId = jsonObject.getString("recordId");
        
        	return RecordId;

    }
    
    
}
