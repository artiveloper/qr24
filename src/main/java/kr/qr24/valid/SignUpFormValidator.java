package kr.qr24.valid;

import kr.qr24.dto.SignUpFormRequest;
import kr.qr24.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpFormValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(SignUpFormRequest.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SignUpFormRequest signUpFormRequest = (SignUpFormRequest) o;

        if (!signUpFormRequest.getSignUpAgreement()) {
            errors.rejectValue("signUpAgreement", "invalid.signUpAgreement", new Object[]{signUpFormRequest.getEmail()}, "회원가입 약관에 동의해주세요");
        }

        if (userRepository.existsUserByEmail(signUpFormRequest.getEmail())) {
            errors.rejectValue("email", "invalid.email", new Object[]{signUpFormRequest.getEmail()}, "이미 사용중인 이메일입니다");
        }

    }

}
