package com.example.resister;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {
    public RegisterRepository registerRepository;

    public LoginController(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        Optional<Register> registerOfGivenName = registerRepository.findByName(loginRequest.name);
        if (registerOfGivenName.isEmpty()) {
            loginResponse.status = "FAILURE";
        } else {
            if (loginRequest.password.equalsIgnoreCase(registerOfGivenName.get().password)) {
                loginResponse.status = "SUCCESS";
            } else {
                loginResponse.status = "FAILURE";
            }
        }
        return loginResponse;
    }
}
