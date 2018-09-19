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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.xml.stream.Location;
import java.sql.Timestamp;

@Controller
@RequestMapping("pain")
public class PainController {

    @Autowired
    private PainDao painDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("pains", painDao.findAll());
        model.addAttribute("title", "List of Pain Entries");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return "pain/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddPainEntryForm(Model model) {
        model.addAttribute("title", "Add Pain Entry");
        model.addAttribute(new Pain());
        return "pain/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPainEntryForm(@ModelAttribute @Valid Pain newPain,
                                       Errors errors,
                                       Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Pain Entry");
            return "pain/add";
        }

        painDao.save(newPain);
        return "redirect:";

    }

}
