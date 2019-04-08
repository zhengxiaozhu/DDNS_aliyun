package domain;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class updateDomain {
	
	private String accessKeyId;
	private String accessSecret;
	private String RecordId;
	
   private String ip;
    
    
    
    public updateDomain(String accessKeyId,String accessSecret,String RecordId,String ip) {
    	this.accessKeyId=accessKeyId;
    	this.RecordId=RecordId;
    	this.accessSecret=accessSecret;
    	this.ip=ip;
    	
    	
	}
    
    
    
    
    public void update() {
    	
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", this.accessKeyId, this.accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        UpdateDomainRecordRequest request = new UpdateDomainRecordRequest();
        
        request.setRecordId(this.RecordId);
        request.setRR("www");
        request.setValue(this.ip);
        request.setType("A");

        try {
            UpdateDomainRecordResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    	
    }

}
