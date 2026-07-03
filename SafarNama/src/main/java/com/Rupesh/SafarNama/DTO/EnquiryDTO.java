package com.Rupesh.SafarNama.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryDTO {

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    private String email;

    public @NotBlank(message = "phone is required") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "phone is required") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "name is required") String name) {
        this.name = name;
    }

    public @NotBlank(message = "email is required") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email is required") String email) {
        this.email = email;
    }

    public @NotBlank(message = "subject is required") String getSubject() {
        return subject;
    }

    public void setSubject(@NotBlank(message = "subject is required") String subject) {
        this.subject = subject;
    }

    public @NotBlank(message = "message is required") String getMessage() {
        return message;
    }

    public void setMessage(@NotBlank(message = "message is required") String message) {
        this.message = message;
    }

    @NotBlank(message = "phone is required")
    private String phone;

    @NotBlank(message = "subject is required")
    private String subject;

    @NotBlank(message = "message is required")
    private String message;
}
