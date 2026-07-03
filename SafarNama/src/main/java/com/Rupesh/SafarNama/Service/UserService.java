package com.Rupesh.SafarNama.Service;

import com.Rupesh.SafarNama.DTO.LoginRequestDTO;
import com.Rupesh.SafarNama.DTO.LoginResponseDTO;
import com.Rupesh.SafarNama.Entity.User;
import com.Rupesh.SafarNama.Exception.BadRequestException;
import com.Rupesh.SafarNama.Repository.UserRepository;
import com.Rupesh.SafarNama.Security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponseDTO Login(LoginRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid Email"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid password");
        }
        String token = jwtUtil.generateToken(user);
        return new LoginResponseDTO(token);
        }
}
