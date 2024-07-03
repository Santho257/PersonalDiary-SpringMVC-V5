package com.santho.personaldiary.dto;

import com.santho.personaldiary.annotations.Password;
import com.santho.personaldiary.annotations.PasswordMatches;

@PasswordMatches
public class ChangePasswordDTO implements Passwordable{
    private char[] oldPassword;
    @Password(spl = 1, caps = 1, minLength = 6, maxLength = 25)
    private char[] password;
    private char[] rePassword;

    public char[] getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(char[] oldPassword) {
        this.oldPassword = oldPassword;
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
}
