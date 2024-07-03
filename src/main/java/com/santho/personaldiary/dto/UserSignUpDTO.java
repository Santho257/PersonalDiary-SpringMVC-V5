package com.santho.personaldiary.dto;

import com.santho.personaldiary.annotations.Email;
import com.santho.personaldiary.annotations.Password;
import com.santho.personaldiary.annotations.PasswordMatches;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Arrays;

@PasswordMatches
public class UserSignUpDTO implements Passwordable{
   @NotBlank(message = "required")
   @Size(min = 3, max = 25)
    private String name;
    @NotBlank(message = "required")
    @Email
    private String email;
    @Password(spl = 1, caps = 1, minLength = 6, maxLength = 25)
    private char[] password;

    private char[] rePassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public char[] getPassword() {
        return password;
    }

    @Override
    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public char[] getRePassword() {
        return rePassword;
    }

    @Override
    public void setRePassword(char[] rePassword) {
        this.rePassword = rePassword;
    }

    @Override
    public String toString() {
        return "UserSignUpDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password=" + Arrays.toString(password) +
                ", rePassword=" + Arrays.toString(rePassword) +
                '}';
    }
}
