package com.system.kanpaionlinestore.pojo;

import com.system.kanpaionlinestore.entity.ProductTobacco;
import com.system.kanpaionlinestore.entity.ProductWhiskey;
import com.system.kanpaionlinestore.entity.User;
import jakarta.mail.Multipart;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductTobaccoPojo {
    private Integer id;
    private MultipartFile product_photo;
    @NotEmpty(message = "Product Name can't be empty")
    private String product_name;
    @NotEmpty(message = "Product Quantity can't be empty")
    private String product_quantity;
    @NotEmpty(message = "Product Price can't be empty")
    private String product_price;

    public ProductTobaccoPojo(ProductTobacco productTobacco) {
        this.id = productTobacco.getId();
        this.product_name = productTobacco.getProduct_name();
        this.product_quantity = productTobacco.getProduct_quantity();
        this.product_price = productTobacco.getProduct_price();
    }
}
