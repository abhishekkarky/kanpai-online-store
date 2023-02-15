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
@Table(name = "kos_products_carts")
public class ProductCart {
    @Id
    @SequenceGenerator(name = "kos_products_cart_seq_gen", sequenceName = "kos_products_cart_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kos_products_cart_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "quantity",nullable = false)
    private Integer quantity;
    @Column(name = "price", nullable = false)
    private Integer price;
    @ManyToOne
    @JoinColumn ( name ="product_id", nullable = false )
    private Product product;
    @ManyToOne
    @JoinColumn ( name ="user_id", nullable = false )
    private User user;
}
