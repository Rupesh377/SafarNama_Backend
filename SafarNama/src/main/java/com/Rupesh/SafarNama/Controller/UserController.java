package com.Rupesh.SafarNama.Controller;

import com.Rupesh.SafarNama.DTO.LoginRequestDTO;
import com.Rupesh.SafarNama.DTO.LoginResponseDTO;
import com.Rupesh.SafarNama.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid  @RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(userService.Login(request));
    }
}
