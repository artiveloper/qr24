package kr.qr24.controller;

import kr.qr24.domain.CustomUser;
import kr.qr24.dto.qrcode.EditQrCodeForm;
import kr.qr24.dto.qrcode.QrCodeTypeResponseDto;
import kr.qr24.dto.qrcode.RegisterQrCodeFormRequest;
import kr.qr24.dto.qrcode.QrCodeResponseDto;
import kr.qr24.dto.VisitorFormRequest;
import kr.qr24.service.QrCodeService;
import kr.qr24.valid.RegisterQrCodeFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeService qrCodeService;
    private final RegisterQrCodeFormValidator registerQrCodeFormValidator;

    @InitBinder("registerQrCodeFormRequest")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(registerQrCodeFormValidator);
    }

    @GetMapping("/qrcodes/new")
    public String storeRegisterPage(Model model) {
        List<QrCodeTypeResponseDto> qrCodeTypes = qrCodeService.getQrCodeTypes();
        model.addAttribute("qrCodeTypes", qrCodeTypes);
        model.addAttribute("registerQrCodeFormRequest", new RegisterQrCodeFormRequest());
        return "qrcodes/register";
    }

    /*
        QR코드 정보 수정 페이지
     */
    @GetMapping("/qrcodes/{qrCodeId}/edit")
    public String editQrCodePage(@PathVariable Long qrCodeId, Model model) {
        EditQrCodeForm editQrCodeForm = qrCodeService.getQrCodeForEdit(qrCodeId);
        model.addAttribute("editQrCodeForm", editQrCodeForm);
        return "qrcodes/edit";
    }

    /*
        QR코드 정보 수정
     */
    @PostMapping("/qrcodes/{qrCodeId}/edit")
    public String editQrCode(@PathVariable Long qrCodeId, EditQrCodeForm editQrCodeForm, RedirectAttributes redirectAttributes) {
        Long updatedQrCodeId = qrCodeService.updateQrCode(qrCodeId, editQrCodeForm);
        redirectAttributes.addFlashAttribute("updated", true);
        return "redirect:/qrcodes/" + updatedQrCodeId + "/edit";
    }

    /*
        QR코드 프린트 페이지
     */
    @GetMapping("/qrcodes/{qrCodeId}/print")
    public String printQrCodePage(@PathVariable Long qrCodeId, Model model) {
        QrCodeResponseDto qrCode = qrCodeService.getQrCode(qrCodeId);
        model.addAttribute("qrCode", qrCode);
        return "qrcodes/print";
    }

    /*
        QR코드 등록
     */
    @PostMapping("/qrcodes")
    public String registerStore(
            @AuthenticationPrincipal CustomUser currentUser,
            @Valid RegisterQrCodeFormRequest registerQrCodeFormRequest,
            Errors errors,
            Model model
    ) {
        if (errors.hasErrors()) {
            List<QrCodeTypeResponseDto> qrCodeTypes = qrCodeService.getQrCodeTypes();
            model.addAttribute("qrCodeTypes", qrCodeTypes);
            return "qrcodes/register";
        }
        Long userId = currentUser.getId();
        qrCodeService.registerQrCode(userId, registerQrCodeFormRequest);
        return "redirect:/dashboard";
    }

    /*
        사용자가 QR코드를 스캔했을 때 보여지는 페이지
        - 핸드폰 번호만 입력하여 방문 내역을 남긴다.
     */
    @GetMapping("/qrcodes/{qrCodeId}/visit")
    public String visitStorePage(@PathVariable Long qrCodeId, Model model) {
        QrCodeResponseDto qrCode = qrCodeService.getQrCode(qrCodeId);
        model.addAttribute("visitorFormRequest", new VisitorFormRequest());
        model.addAttribute("qrCode", qrCode);
        return "qrcodes/visit";
    }

    /*
        사용자가 QR코드를 스캔하여 접속한 페이지에서 핸드폰번호를 입력했을 때, 방문 로그를 쌓는다.
     */
    @PostMapping("/qrcodes/{qrCodeId}/visit")
    public String visitStore(@Valid VisitorFormRequest visitorFormRequest, Errors errors) {
        if (errors.hasErrors()) {
            return "qrcodes/visit";
        }
        return "redirect:/qrcodes/visit-result";
    }

    @GetMapping("/qrcodes/visit-result")
    public String result() {
        return "qrcodes/visit-result";
    }

    /*
        QR코드 삭제
     */
    @DeleteMapping("/qrcodes/{qrCodeId}/delete")
    public String deleteQrCode(@AuthenticationPrincipal CustomUser currentUser, @PathVariable Long qrCodeId, RedirectAttributes redirectAttributes) {
        qrCodeService.deleteQrCode(currentUser.getId(), qrCodeId);
        redirectAttributes.addFlashAttribute("deleteMessage", true);
        return "redirect:/dashboard";
    }

}
