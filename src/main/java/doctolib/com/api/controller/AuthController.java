package doctolib.com.api.controller;

import doctolib.com.api.domain.user.AuthService;
import doctolib.com.api.domain.user.DataAuth;
import doctolib.com.api.domain.user.User;
import doctolib.com.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuth data) {
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = manager.authenticate(token);
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.newToken((User) authentication.getPrincipal()));
    }
}
