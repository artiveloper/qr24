package kr.qr24.domain;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collections;

@Getter
public class CustomUser extends org.springframework.security.core.userdetails.User {

    private Long id;
    private String email;
    private LocalDateTime createdAt;

    public CustomUser(User user) {
        super(user.getEmail(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        this.id = user.getId();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }

}
