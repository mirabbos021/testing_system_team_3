package com.company.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserDTO {
    private String fullName;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
}
