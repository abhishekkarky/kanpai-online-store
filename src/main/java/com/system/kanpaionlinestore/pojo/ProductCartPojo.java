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
    private String quantity;
    private String price;

    public ProductCartPojo(ProductCart productCart) {
        this.id = productCart.getId();
        this.name = productCart.getName();
        this.quantity = String.valueOf(productCart.getQuantity());
        this.price = String.valueOf(productCart.getPrice());
    }
}
