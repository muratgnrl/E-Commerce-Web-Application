package com.example.auth.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "STOKS")
public interface UserCallableApi {
}
