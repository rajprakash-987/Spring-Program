package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Ms")
public interface IBillingServiceClient {
	
	@GetMapping("/billingMs/billing-api/payment")
	public ResponseEntity<String> invokeBillingMSEndPoint();
}
