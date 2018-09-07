package org.launchcode.paintracker.controllers;

import org.launchcode.paintracker.models.Pain;
import org.launchcode.paintracker.models.data.PainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("profile")
public class ProfileController {

    @Autowired
    private PainDao painDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String DisplayLoginForm(Model model) {
        model.addAttribute("title", "Register/Login");
        return "pain/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginnEntryForm(@ModelAttribute @Valid Pain newPain,
                                         Errors errors,
                                         Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Register/Login");
            return "pain/";
        }

        painDao.save(newPain);
        return "redirect:";
    }

    @RequestMapping(value = "profile")
    public String displayListofPainEntries(Model model) {
        model.addAttribute("pains", painDao.findAll());
        model.addAttribute("title", "My Profile");
        return "pain/profile";
    }
}

