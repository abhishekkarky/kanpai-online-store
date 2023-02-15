//package com.system.kanpaionlinestore.entity;
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "kos_carts")
//public class Cart {
//    @Id
//    @SequenceGenerator(name = "kos_carts_seq_gen", sequenceName = "kos_carts_id_seq", allocationSize = 1)
//    @GeneratedValue(generator = "kos_carts_seq_gen", strategy = GenerationType.SEQUENCE)
//    private Integer id;
//    @Column(name = "status",nullable = false)
//    private String status;
//    @OneToOne
//    @JoinColumn ( name ="user_id", nullable = false )
//    private User  user;
//
//}
