package kr.qr24.valid;

import kr.qr24.dto.RegisterStoreFormRequest;
import kr.qr24.dto.SignUpFormRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class RegisterStoreFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(RegisterStoreFormRequest.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // todo 등록된 사업자 등록증인지 확인.
    }

}
