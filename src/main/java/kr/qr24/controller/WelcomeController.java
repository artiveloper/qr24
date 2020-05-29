package kr.qr24.controller;

import kr.qr24.domain.CustomUser;
import kr.qr24.dto.store.StoreListResponse;
import kr.qr24.dto.store.StoreResponseDto;
import kr.qr24.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    private final StoreService storeService;

    @GetMapping("/")
    public String welcome(@AuthenticationPrincipal CustomUser currentUser, Model model) {
        if (currentUser == null) {
            return "users/sign-in";
        }
        List<StoreListResponse> stores = storeService.getStores(currentUser.getId());
        model.addAttribute("stores", stores);
        return "index";
    }

}
