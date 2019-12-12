package com.alok.mytutorwebapp.controler;

import com.alok.mytutorwebapp.model.Tuition;
import com.alok.mytutorwebapp.model.Tutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    @RequestMapping("/getTutor")
    public List<Tutor> getAllTutor(){

        List<Tutor> tutors = new ArrayList<>();
        tutors.add(new Tutor("ALok", "Chaudhary","8787878", "abc@gmail.com"));
        return tutors;
    }

    @RequestMapping("/getTuition")
    public List<Tuition> getAllTution(){

        List<Tuition> tutions = new ArrayList<>();
        tutions.add(new Tuition("English","Online","Anywhere"));
        return tutions;
    }

    @RequestMapping("/limit")
    public String getLimitMessage(){
        return "Number of request breached for time frame";
    }


}
