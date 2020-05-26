package kr.qr24.service;

import kr.qr24.domain.CustomUser;
import kr.qr24.domain.User;
import kr.qr24.dto.SignUpFormRequest;
import kr.qr24.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userByEmail = userRepository.findUserByEmail(email);
        User user = userByEmail.orElseThrow(() -> new UsernameNotFoundException(email));
        return new CustomUser(user);
    }

    @Transactional
    public Long signUp(SignUpFormRequest signUpFormRequest) {
        User user = signUpFormRequest.toUserEntity(passwordEncoder);
        user.generateEmailToken();
        userRepository.save(user);
        return user.getId();
    }

}
