package com.gohar.commerce.productcatalogue;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "products")
public record ApplicationContactInfoDto (String message,Map<String, String> contactDetails,List<String> onCallSupport){

}
