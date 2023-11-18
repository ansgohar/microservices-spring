package com.gohar.commerce.userprofile.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "users")
public record ApplicationContactInfoDto (String message,Map<String, String> contactDetails,List<String> onCallSupport){

}
