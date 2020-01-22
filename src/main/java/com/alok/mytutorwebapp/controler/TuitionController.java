package com.alok.mytutorwebapp.controler;

import com.alok.mytutorwebapp.model.Tuition;
import com.alok.mytutorwebapp.service.TuitionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class TuitionController {

    TuitionService tuitionService;

    public TuitionController(TuitionService tuitionService) {
        this.tuitionService = tuitionService;
    }

    @GetMapping("/tuition.html")
    public String showTuitionList(Model model) {
        Tuition tuition = new Tuition();
        model.addAttribute("tuition", tuitionService.findAll());
        return "tuition/tuitionList";
    }
}
