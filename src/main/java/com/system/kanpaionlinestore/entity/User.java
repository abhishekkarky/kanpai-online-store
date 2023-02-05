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
@Table(name = "kos_users", uniqueConstraints = {
        @UniqueConstraint(name = "kos_users_email", columnNames = "email")})
public class User implements UserDetails, UserInterface {
    @Id
    @SequenceGenerator(name = "kos_users_seq_gen", sequenceName = "kos_users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kos_users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "Full_Name")
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "OTP")
    private String OTP;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public String getOTP() {
        return this.OTP;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
