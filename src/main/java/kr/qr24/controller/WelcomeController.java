package kr.qr24.controller;

import kr.qr24.domain.CustomUser;
import kr.qr24.dto.qrcode.QrCodeListResponse;
import kr.qr24.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    private final QrCodeService QRCodeService;

    @GetMapping("/")
    public String welcome(@AuthenticationPrincipal CustomUser currentUser, Model model) {
        if (currentUser == null) {
            return "users/sign-in";
        }
        List<QrCodeListResponse> qrCodes = QRCodeService.getQrCodes(currentUser.getId());
        model.addAttribute("qrCodes", qrCodes);
        return "index";
    }

}
