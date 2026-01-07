package com.example.studentmanagement.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequestDTO {
    @NotNull(message = "email is required ")
    @Email
    private String email;

    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "course is required")
    private String course;
}
