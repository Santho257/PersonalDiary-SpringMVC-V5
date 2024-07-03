package com.santho.personaldiary.controllers;

import com.santho.personaldiary.dto.Page;
import com.santho.personaldiary.propeditors.DatePropertyEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;


@Controller
@RequestMapping("/diary")
public class DairyController {
    @RequestMapping("/")
    public String dairy(Model model, Principal principal){
        model.addAttribute("user", principal.getName());
        return "diary";
    }

    @RequestMapping("/writepage")
    public String writePage(@ModelAttribute Page page){
        return "writepage";
    }
    @RequestMapping("/updatePage")
    public String updatePage(@Valid @ModelAttribute Page page, BindingResult res){
        if(res.hasErrors()) {
            return "diary";
        };
        return "page";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(LocalDate.class, "date", new DatePropertyEditor());
    }

}
