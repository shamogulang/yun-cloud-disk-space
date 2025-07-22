package com.example.cloudspace.feign;

import com.example.cloudspace.feign.config.FeignConfiguration;
import com.example.cloudspace.model.AuthRequest;
import com.example.cloudspace.model.Result;
import com.example.cloudspace.model.UserAuthData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", url = "${user.auth:''}",configuration = FeignConfiguration.class)
public interface UserFeign {


    @PostMapping("/user/auth")
    Result<UserAuthData> auth(@RequestBody AuthRequest authRequest);

}