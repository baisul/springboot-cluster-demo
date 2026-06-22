package org.example.controller;

import org.example.biz.BizUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private BizUser bizUser;
    // 从docker-compose中各个实例配置的instanceId来设置值
    @Value("${INSTANCE_ID:default-instance}")
    private String instanceId;

    @Value("${INSTANCE_NAME:Default Instance}")
    private String instanceName;

    @GetMapping(value = "getUserById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> getUserById(@PathVariable long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        response.put("instanceId", instanceId);
        response.put("instanceName", instanceName);
        var user = bizUser.getUserById(id);
        if (user != null) {
            response.put("user", user);
        }
        return response;
    }
}
