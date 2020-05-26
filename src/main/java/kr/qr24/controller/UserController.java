package kr.qr24.controller;

import kr.qr24.dto.SignUpFormRequest;
import kr.qr24.service.UserService;
import kr.qr24.valid.SignUpFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SignUpFormValidator signUpFormValidator;

    @InitBinder("signUpFormRequest")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("/sign-in")
    public String signInPage() {
        return "users/sign-in";
    }

    @GetMapping("/sign-up")
    public String signUpPage(Model model) {
        model.addAttribute("signUpFormRequest", new SignUpFormRequest());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String doSignUp(@Valid SignUpFormRequest signUpFormRequest, Errors errors) {
        if (errors.hasErrors()) {
            return "users/sign-up";
        }
        userService.signUp(signUpFormRequest);
        return "redirect:/users/sign-in";
    }

}
