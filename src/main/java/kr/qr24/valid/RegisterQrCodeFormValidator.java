package kr.qr24.valid;

import kr.qr24.dto.qrcode.RegisterQrCodeFormRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class RegisterQrCodeFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(RegisterQrCodeFormRequest.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterQrCodeFormRequest registerQrCodeFormRequest = (RegisterQrCodeFormRequest) o;

        Long qrCodeTypeId = registerQrCodeFormRequest.getQrCodeTypeId();

        // 차량용 QR코드 일 경우, 차량 번호 확인
        if (qrCodeTypeId == 2) {
            if (registerQrCodeFormRequest.getCarNumber() == null) {
                errors.rejectValue("carNumber", "invalid.carNumber", new Object[]{registerQrCodeFormRequest.getCarNumber()}, "차량 번호를 입력해주세요");
            }
        }

        // todo 등록된 사업자 등록증인지 확인.
    }

}
