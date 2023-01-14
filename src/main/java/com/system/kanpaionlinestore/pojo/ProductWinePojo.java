package com.system.kanpaionlinestore.pojo;

import com.system.kanpaionlinestore.entity.ProductWhiskey;
import com.system.kanpaionlinestore.entity.ProductWine;
import com.system.kanpaionlinestore.entity.User;
import jakarta.mail.Multipart;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWinePojo {
    private Integer id;
    private Multipart product_photo;
    @NotEmpty(message = "Product Name can't be empty")
    private String product_name;
    @NotEmpty(message = "Product Quantity can't be empty")
    private String product_quantity;
    @NotEmpty(message = "Product Price can't be empty")
    private Integer product_price;

    public ProductWinePojo(ProductWine productWine) {
        this.id = productWine.getId();
        this.product_name = productWine.getProduct_name();
        this.product_quantity = productWine.getProduct_quantity();
        this.product_price = productWine.getProduct_price();
    }
}
