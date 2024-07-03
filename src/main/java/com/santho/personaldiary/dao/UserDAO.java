package com.santho.personaldiary.dao;

import com.santho.personaldiary.dto.ChangePasswordDTO;
import com.santho.personaldiary.dto.UserSignUpDTO;

import java.security.Principal;

public interface UserDAO {
    void saveUser(UserSignUpDTO userSignUpDTO);
    boolean changePassword(ChangePasswordDTO changePasswordDTO,  Principal principal);
    void deleteUser(Principal principal);
}
