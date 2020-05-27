package kr.qr24.valid;

import kr.qr24.dto.VisitorFormRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class VisitFormValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(VisitorFormRequest.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // todo
        //  1. 핸드폰 번호 입력 확인
        //  2. 인증번호 확인
    }

}
