package com.santho.personaldiary.dao;

import com.santho.personaldiary.collections.CustomUser;
import com.santho.personaldiary.dao.repos.UserRepository;
import com.santho.personaldiary.dto.ChangePasswordDTO;
import com.santho.personaldiary.dto.UserSignUpDTO;
import com.santho.personaldiary.exceptions.UserAlreadyExistsException;
import com.santho.personaldiary.helpers.ArrayToStringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Repository;

import java.security.Principal;

import static com.santho.personaldiary.helpers.ArrayToStringHelper.*;

@Repository
@ComponentScan("com.santho.personaldiary")
public class UserDaoImpl implements UserDAO {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private JdbcUserDetailsManager jdbcUserDetailsManager;

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(UserSignUpDTO userSignUpDTO) {
        /*String userSql = "INSERT INTO users VALUES(?, ?, ?)";
        String authSql = "INSERT INTO authorities VALUES(?, ?)";

        int a = jdbcTemplate.update(userSql, userSignUpDTO.getEmail(), ArrayToStringHelper.arrToString(userSignUpDTO.getPassword()), true);
        int b = jdbcTemplate.update(authSql, userSignUpDTO.getEmail(), "USER");*/

        if(userRepository.existsByEmailIgnoreCase(userSignUpDTO.getEmail())){
            throw new UserAlreadyExistsException("User Already Exists By Given Mail Id :: " + userSignUpDTO.getEmail());
        }

        String encoded = passwordEncoder.encode(arrToString(userSignUpDTO.getPassword()));

        CustomUser customUser = new CustomUser();
        customUser.setEmail(userSignUpDTO.getEmail());
        customUser.setPassword(encoded);
        customUser.setName(userSignUpDTO.getName());

        CustomUser user = userRepository.save(customUser);
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDetails.getUsername(),
                            arrToString(userSignUpDTO.getPassword())
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean changePassword(ChangePasswordDTO changePasswordDTO, Principal principal) {
        CustomUser userr= userRepository.findById(principal.getName()).get();
        String origPassword = userr.getPassword();
        String enteredPassword = arrToString(changePasswordDTO.getOldPassword());
        if(!passwordEncoder.matches(enteredPassword,origPassword)){
            throw new UnsupportedOperationException("The Old Password You Entered is Wrong...");
        }
        String newPassword = arrToString(changePasswordDTO.getPassword());
        userr.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(userr);
        return true;
    }

    @Override
    public void deleteUser(Principal principal) {
        userRepository.deleteById(principal.getName());
    }


}
