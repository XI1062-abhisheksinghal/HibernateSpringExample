package com.atm.home.response;

import lombok.Data;

@Data
public class BeneficiaryResponse {
	
	
	String beneficiaryName;
	Integer accountNumber;
	String bankName;
	String ifscCode;

}
