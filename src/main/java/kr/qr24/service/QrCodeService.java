package kr.qr24.service;

import kr.qr24.domain.QrCodeType;
import kr.qr24.domain.QrCode;
import kr.qr24.domain.User;
import kr.qr24.dto.qrcode.*;
import kr.qr24.exception.CategoryNotFound;
import kr.qr24.exception.StoreNotFound;
import kr.qr24.exception.UserNotFound;
import kr.qr24.repository.qrcode.QrTypeRepository;
import kr.qr24.repository.UserRepository;
import kr.qr24.repository.qrcode.QrCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QrCodeService {

    private final QrCodeRepository qrCodeRepository;
    private final QrTypeRepository qrTypeRepository;
    private final UserRepository userRepository;

    public List<QrCodeTypeResponseDto> getQrCodeTypes() {
        return qrTypeRepository.findAll()
                .stream()
                .map(QrCodeTypeResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long registerQrCode(Long userId, RegisterQrCodeFormRequest registerQrCodeFormRequest) {
        QrCode QRCode = registerQrCodeFormRequest.toStoreEntity();
        Long qrCodeTypeId = registerQrCodeFormRequest.getQrCodeTypeId();

        User user = userRepository.findById(userId).orElseThrow(UserNotFound::new);
        QrCodeType qrCodeType = qrTypeRepository.findById(qrCodeTypeId).orElseThrow(CategoryNotFound::new);

        QRCode.setUser(user);
        QRCode.setQrCodeType(qrCodeType);

        qrCodeRepository.save(QRCode);
        return QRCode.getId();
    }

    public List<QrCodeListResponse> getQrCodes(Long userId) {
        return qrCodeRepository.findQrCodesByUserId(userId)
                .stream()
                .map(QrCodeListResponse::new)
                .collect(Collectors.toList());
    }

    public QrCodeResponseDto getQrCode(Long storeId) {
        QrCode QRCode = qrCodeRepository.findQrCodeWithType(storeId);
                //.orElseThrow(StoreNotFound::new);
        return new QrCodeResponseDto(QRCode);
    }

    public EditQrCodeForm getQrCodeForEdit(Long storeId) {
        QrCode QRCode = qrCodeRepository.findQrCodeWithType(storeId);
        return new EditQrCodeForm(QRCode);
    }

    @Transactional
    public Long updateQrCode(Long id, EditQrCodeForm editQrCodeForm) {
        QrCode qrCode = qrCodeRepository.findById(id).orElseThrow(StoreNotFound::new);
        qrCode.update(editQrCodeForm);
        return qrCode.getId();
    }

    @Transactional
    public void deleteQrCode(Long userId, Long qrCodeId) {
        qrCodeRepository.deleteQrCode(userId, qrCodeId);
    }

}
