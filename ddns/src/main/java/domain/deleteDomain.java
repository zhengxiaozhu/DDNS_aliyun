package domain;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.DeleteDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.DeleteDomainRecordResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

public class deleteDomain {
	
	
	private String accessKeyId;
	private String accessSecret;
	private String RecordId;
	
    
   
   public deleteDomain(String accessKeyId,String accessSecret,String RecordId) {
	   
		this.accessKeyId=accessKeyId;
		this.RecordId=RecordId;
this.accessSecret=accessSecret;

   
   
   }
   
   
   
   
   public void delete() {
	   DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", this.accessKeyId, this.accessSecret);
       IAcsClient client = new DefaultAcsClient(profile);

       DeleteDomainRecordRequest request = new DeleteDomainRecordRequest();
       request.setRecordId(this.RecordId);

       try {
           DeleteDomainRecordResponse response = client.getAcsResponse(request);
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
	
