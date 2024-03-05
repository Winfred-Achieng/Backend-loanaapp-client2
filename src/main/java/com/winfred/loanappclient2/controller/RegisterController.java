package com.winfred.loanappclient2.controller;

import com.winfred.loanappclient2.model.RegistrationRequest;
import com.winfred.loanappclient2.model.UserResponse;
import com.winfred.loanappclient2.response.ApiResponse;
import com.winfred.loanappclient2.service.RegisterUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class RegisterController {

    private final RegisterUserService registerUserService;

    @GetMapping("/registeredUsers")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getRegisteredUsers() {
        try {
            List<RegistrationRequest> registeredUsers = registerUserService.getAllRegisteredUsers();

            List<UserResponse> userResponses = registeredUsers.stream()
                    .map(user -> new UserResponse(user.getId() ,user.getName(), user.getPhone(), user.getEmail()))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully retrieved registered users", userResponses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Failed to retrieve registered users", null));
        }
    }


}
