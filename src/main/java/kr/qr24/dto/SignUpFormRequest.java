package kr.qr24.dto;

import kr.qr24.domain.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class SignUpFormRequest {

    @Email(message = "이메일을 다시 확인해주세요")
    @NotBlank(message = "이메일을 다시 확인해주세요")
    private String email;

    @NotBlank(message = "비밀번호를 다시 확인해주세요")
    @Length(min = 8, max = 50, message = "비밀번호는 최소 8글자에서 최대 50글자까지만 허용됩니다")
    private String password;

    private Boolean signUpAgreement;

    public User toUserEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(this.email)
                .password(passwordEncoder.encode(this.password))
                .createdAt(LocalDateTime.now())
                .emailVerified(false)
                .build();
    }

}
