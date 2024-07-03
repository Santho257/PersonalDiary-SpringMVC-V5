package com.santho.personaldiary.dto;


public interface Passwordable {
    void setPassword(char[] password);
    void setRePassword(char[] rePassword);
    char[] getPassword();
    char[] getRePassword();

}
