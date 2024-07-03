package com.santho.personaldiary.dao;

import com.santho.personaldiary.collections.CustomUser;
import com.santho.personaldiary.dao.repos.UserRepository;
import com.santho.personaldiary.dto.ChangePasswordDTO;
import com.santho.personaldiary.dto.UserSignUpDTO;
import com.santho.personaldiary.helpers.ArrayToStringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.security.Principal;

@Repository
@ComponentScan("com.santho.personaldiary")
public class UserDaoImpl implements UserDAO {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private JdbcUserDetailsManager jdbcUserDetailsManager;

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(UserSignUpDTO userSignUpDTO) {
        /*String userSql = "INSERT INTO users VALUES(?, ?, ?)";
        String authSql = "INSERT INTO authorities VALUES(?, ?)";

        int a = jdbcTemplate.update(userSql, userSignUpDTO.getEmail(), ArrayToStringHelper.arrToString(userSignUpDTO.getPassword()), true);
        int b = jdbcTemplate.update(authSql, userSignUpDTO.getEmail(), "USER");
        System.out.println(a+"--"+b);*/

        String encoded = passwordEncoder.encode(ArrayToStringHelper.arrToString(userSignUpDTO.getPassword()));
        userSignUpDTO.setPassword(encoded.toCharArray());

        CustomUser customUser = new CustomUser();
        customUser.setEmail(userSignUpDTO.getEmail());
        customUser.setPassword(encoded);
        customUser.setName(userSignUpDTO.getName());

        UserDetails userDetails = User.withUsername(userSignUpDTO.getEmail()).password(encoded).authorities("USER").build();
//        jdbcUserDetailsManager.createUser(userDetails);
        CustomUser user = userRepository.save(customUser);
        System.out.println(user);
    }

    @Override
    public boolean changePassword(ChangePasswordDTO changePasswordDTO, Principal principal) {
        CustomUser userr= userRepository.findById(principal.getName()).get();
        String origPassword = userr.getPassword();
        String enteredPassword = ArrayToStringHelper.arrToString(changePasswordDTO.getOldPassword());

//        if(!passwordEncoder.matches(enteredPassword, origPassword)) {
//            return false;
//        }

        String newPassword = ArrayToStringHelper.arrToString(changePasswordDTO.getPassword());
        userr.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(userr);
        return true;
    }

    @Override
    public void deleteUser(Principal principal) {
        userRepository.deleteById(principal.getName());
    }


}
