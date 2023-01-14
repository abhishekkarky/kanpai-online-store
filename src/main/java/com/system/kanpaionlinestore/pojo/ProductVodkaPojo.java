package com.system.kanpaionlinestore.pojo;

import com.system.kanpaionlinestore.entity.ProductVodka;
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
public class ProductVodkaPojo {
    private Integer id;
    private MultipartFile product_photo;
    @NotEmpty(message = "Product Name can't be empty")
    private String product_name;
    @NotEmpty(message = "Product Quantity can't be empty")
    private String product_quantity;
    @NotEmpty(message = "Product Price can't be empty")
    private String product_price;

    public ProductVodkaPojo (ProductVodka productVodka) {
        this.id = productVodka.getId();
        this.product_name = productVodka.getProduct_name();
        this.product_quantity = productVodka.getProduct_quantity();
        this.product_price = productVodka.getProduct_price();
    }
}
