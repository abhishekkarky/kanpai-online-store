package com.system.kanpaionlinestore.pojo;

import com.system.kanpaionlinestore.entity.ProductTequila;
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
public class ProductTequilaPojo {
    private Integer id;
    private Multipart product_photo;
    @NotEmpty(message = "Product Name can't be empty")
    private String product_name;
    @NotEmpty(message = "Product Quantity can't be empty")
    private String product_quantity;
    @NotEmpty(message = "Product Price can't be empty")
    private Integer product_price;

    public ProductTequilaPojo(ProductTequila productTequila) {
        this.id = productTequila.getId();
        this.product_name = productTequila.getProduct_name();
        this.product_quantity = productTequila.getProduct_quantity();
        this.product_price = productTequila.getProduct_price();
    }
}
