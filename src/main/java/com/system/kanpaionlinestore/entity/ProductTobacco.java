package com.system.kanpaionlinestore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_tobacco")
public class ProductTobacco {
    @Id
    @SequenceGenerator(name = "kos_user_seq_gen", sequenceName = "kos_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kos_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String product_photo;
    @Column(name = "productName", nullable = false)
    private String product_name;
    @Column(name = "productQuantity", nullable = false)
    private String product_quantity;
    @Column(name = "productPrice", nullable = false)
    private String product_price;
    @Transient
    private String imageBase64;
}
