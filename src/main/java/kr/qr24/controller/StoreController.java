package kr.qr24.controller;

import kr.qr24.dto.RegisterStoreFormRequest;
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
    public String storeDetailPage(@PathVariable Long storeId) {
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

}
