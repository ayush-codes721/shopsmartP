package ShopSmart.Controllers;


import ShopSmart.dto.UserDTO;
import ShopSmart.request.LoginRequest;
import ShopSmart.request.SignupRequest;
import ShopSmart.response.TokenResponse;
import ShopSmart.ShopService.Auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    ResponseEntity<UserDTO> signup(@RequestBody SignupRequest signupRequest) {

        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(authService.login(loginRequest));
    }

}
