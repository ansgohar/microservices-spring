package com.gohar.commerce.userprofile.dto;

import java.util.Collection;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "OrderDto", description = "Schema to Order information")
public class OrderDto {

	@Schema(description = "Order Identified code")
	private Long orderid;
	@Schema(description = "User Identified code")
	private Long userId;
	@Schema(description = "Order Total Quantity")
	private Long qty;
	@Schema(description = "Order Discount Value")
	private Double discount;
	@Schema(description = "Order Total Price")
	private Double total;

	@Schema(description = "Collection of Order Item(es)")
	private Collection<OrderItemDto> orderItems;

}
