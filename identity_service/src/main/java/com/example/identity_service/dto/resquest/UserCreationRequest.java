package com.example.identity_service.dto.resquest;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

// tự có get set
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    String id;
    @Size(min = 3, message = "Username must be atless 3 characters")
    String username;
    @Size(min = 8, message = "Password must be atless 8 characters")
    String password;
    String fisrtName;
    String lastName;
    LocalDate dob;

}
