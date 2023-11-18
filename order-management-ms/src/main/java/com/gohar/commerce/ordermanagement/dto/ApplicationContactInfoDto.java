package com.gohar.commerce.ordermanagement.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "orders")
public record ApplicationContactInfoDto (String message,Map<String, String> contactDetails,List<String> onCallSupport){

}
