package com.alok.mytutorwebapp.controler;

import com.alok.mytutorwebapp.model.Tutor;
import com.alok.mytutorwebapp.service.TutorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class TutorController {

    TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    @RequestMapping("/allTutors")
    public String getAllTutors(Model model){
        Set<Tutor> tutors = tutorService.findAll();
        model.addAttribute("allTutors", tutors);
        return "tutor/AllTutor";
    }

}
