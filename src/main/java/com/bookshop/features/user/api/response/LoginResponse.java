package com.bookshop.features.user.api.response;

import com.bookshop.core.security.JwtAuthenticationResponse;
import com.bookshop.features.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private Long id;
    private String email;
    private JwtAuthenticationResponse response;

    public static LoginResponse of(User user, JwtAuthenticationResponse jwtAuthenticationResponse) {
        return new LoginResponse(
                user.getId(),
                user.getEmail(),
                jwtAuthenticationResponse
        );
    }
}