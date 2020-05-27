package kr.qr24.controller;

import kr.qr24.dto.RegisterStoreFormRequest;
import kr.qr24.dto.StoreResponseDto;
import kr.qr24.dto.VisitorFormRequest;
import kr.qr24.service.StoreService;
import kr.qr24.valid.RegisterStoreFormValidator;
import kr.qr24.valid.SignUpFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final RegisterStoreFormValidator registerStoreFormValidator;

    @InitBinder("registerStoreFormRequest")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(registerStoreFormValidator);
    }

    @GetMapping("/stores")
    public String storeRegisterPage(Model model) {
        model.addAttribute("registerStoreFormRequest", new RegisterStoreFormRequest());
        return "stores/register";
    }

    @GetMapping("/stores/{storeId}")
    public String storeDetailPage(@PathVariable Long storeId, Model model) {
        StoreResponseDto store = storeService.getStore(storeId);
        model.addAttribute("store", store);
        return "stores/detail";
    }

    @PostMapping("/stores")
    public String registerStore(@Valid RegisterStoreFormRequest registerStoreFormRequest, Errors errors) {
        System.out.println(registerStoreFormRequest);
        if(errors.hasErrors()){
            return "stores/register";
        }
        storeService.registerStore(registerStoreFormRequest);
        return "redirect:/";
    }

    /*
        사용자가 QR코드를 스캔했을 때 보여지는 페이지
        - 핸드폰 번호만 입력하여 방문 내역을 남긴다.
     */
    @GetMapping("/stores/{storeId}/visit")
    public String visitStorePage(@PathVariable Long storeId, Model model) {
        StoreResponseDto store = storeService.getStore(storeId);
        model.addAttribute("visitorFormRequest", new VisitorFormRequest());
        model.addAttribute("store", store);
        return "stores/visit";
    }
    
}
