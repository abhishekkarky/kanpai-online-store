package com.system.kanpaionlinestore.pojo;

import com.system.kanpaionlinestore.entity.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private Integer id;
    @NotEmpty(message = "First Name can't be empty")
    private String FName;
    @NotEmpty(message = "Last Name can't be empty")
    private String LName;
    @NotEmpty(message = "E-mail can't be empty")
    private String email;
    @NotEmpty(message = "Password can't be empty")
    private String password;
    public UserPojo(User user) {
        this.id = user.getId();
        this.FName = user.getFName();
        this.LName = user.getLName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
