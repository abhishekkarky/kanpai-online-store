package com.system.kanpaionlinestore.pojo;

import com.system.kanpaionlinestore.entity.ProductGin;
import com.system.kanpaionlinestore.entity.ProductWhiskey;
import com.system.kanpaionlinestore.entity.User;
import jakarta.mail.Multipart;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductGinPojo {
    private Integer id;
    private Multipart product_photo;
    @NotEmpty(message = "Product Name can't be empty")
    private String product_name;
    @NotEmpty(message = "Product Quantity can't be empty")
    private String product_quantity;
    @NotEmpty(message = "Product Price can't be empty")
    private Integer product_price;

    public ProductGinPojo(ProductGin productGin) {
        this.id = productGin.getId();
        this.product_name = productGin.getProduct_name();
        this.product_quantity = productGin.getProduct_quantity();
        this.product_price = productGin.getProduct_price();
    }
}
