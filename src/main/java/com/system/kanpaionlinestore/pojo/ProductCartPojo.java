package com.system.kanpaionlinestore.pojo;

import com.system.kanpaionlinestore.entity.ProductCart;
import com.system.kanpaionlinestore.service.ProductService;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartPojo {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer price;

    public ProductCartPojo(ProductCart productCart) {
        this.id = productCart.getId();
        this.name = productCart.getName();
        this.quantity = productCart.getQuantity();
        this.price = productCart.getPrice();
    }
}
