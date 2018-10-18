package org.apache.fineract.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionResponse {
	private String responseCode;
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd MMMM yyyy",locale = "en_GB",timezone ="Africa/Lagos")
	private Date tranDate;
	
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd MMMM yyyy",locale = "en_GB",timezone ="Africa/Lagos")
	private Date postedDate;
	
	private String postedFlag;
	private String tranId;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	public Date getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	public String getPostedFlag() {
		return postedFlag;
	}
	public void setPostedFlag(String postedFlag) {
		this.postedFlag = postedFlag;
	}
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	
	public TransactionResponse(String responseCode,Date tranDate,Date postedDate,String postedFlag,String tranId) {
		this.responseCode = responseCode;
        this.tranDate  = tranDate;
        this.postedDate  = postedDate;
        this.postedFlag   = postedFlag;
        this.tranId  = tranId;
		
	}

}
