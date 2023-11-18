package com.gohar.commerce.userprofile.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "OrderItemDto", description = "Schema to Order Item details")
public class OrderItemDto {

@Schema(description = "Order Item Identified code")
private Long orderItemId;
	@Schema(description = "Product Identified code")
	private Long productId;
	@Schema(description = "Product Quantity")
	private Long productQty;
	

}
