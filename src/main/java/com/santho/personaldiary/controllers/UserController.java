package com.santho.personaldiary.controllers;

import com.santho.personaldiary.dao.UserDAO;
import com.santho.personaldiary.dto.ChangePasswordDTO;
import com.santho.personaldiary.dto.UserDeleteDTO;
import com.santho.personaldiary.dto.UserSignUpDTO;
import com.santho.personaldiary.exceptions.UserAlreadyExistsException;
import com.santho.personaldiary.propeditors.SmallCasePropertyEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") UserSignUpDTO userSignUpDTO){
        return "registerUser";
    }

    @RequestMapping(path = "/processRegister", method = RequestMethod.POST)
    public String registerProcess(@Valid @ModelAttribute("user") UserSignUpDTO userSignUpDTO, BindingResult res, Model model){
        if(res.hasErrors()){
            model.addAttribute("passMisMatch","Password Doesn't Match");
            return "registerUser";
        }
        try {
            userDAO.saveUser(userSignUpDTO);
        }catch (UserAlreadyExistsException ex){
            System.out.println("Inside User Already Exists");
            model.addAttribute("userExists",ex.getMessage());
            return "registerUser";
        }
        return "redirect:../diary/";
    }

    @RequestMapping("/login")
    public String loginUser(@ModelAttribute("user") UserSignUpDTO userSignUpDTO){
        return "login";
    }

    @RequestMapping("/changepassword")
    public String changePassword(@ModelAttribute("passwordable") ChangePasswordDTO changePasswordDTO){
        return "changepassword";
    }

    @RequestMapping(path = "/processpassword", method = RequestMethod.POST)
    public String processPassword(@Valid @ModelAttribute("passwordable") ChangePasswordDTO changePasswordDTO, BindingResult res, Model model,Principal principal){
        if(res.hasErrors()){
            if(res.getFieldError() == null){
                model.addAttribute("passwordMisMatch", "Passwords don't match");
            }
            return "changepassword";
        }
        if(!userDAO.changePassword(changePasswordDTO, principal)){
            model.addAttribute("wrongPassword", "Old Password is Wrong");
            return "changepassword";
        }
        return "redirect:../diary/?passwordChanged";
    }

    @RequestMapping("/deleteuser")
    public String deleteUser(@ModelAttribute("deletor") UserDeleteDTO userDeleteDTO){
        return "deleteuser";
    }

    @RequestMapping(path = "/deleteprocess", method = RequestMethod.POST)
    public String deleteUserProcess(@Valid @ModelAttribute("deletor") UserDeleteDTO userDeleteDTO, BindingResult res, Principal principal){
        userDAO.deleteUser(principal);
        return "redirect:../logout";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, "email",new SmallCasePropertyEditor());
    }
}
