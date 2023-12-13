package com.example.WebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController {

    @RequestMapping("alien")
    public String alien(@RequestParam("name") String aname, @RequestParam("id") int aid, @RequestParam("language") String language, Model model) {
        Alien alien = new Alien();
        alien.setAid(aid);
        alien.setName(aname);
        alien.setLanguage(language);

        model.addAttribute("alien", alien);

        return "alien";

    }

    @RequestMapping("alienObject")
    public ModelAndView alienObject(Alien alien) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("alien", alien);

        mv.setViewName("alien");

        return mv;
    }

}
