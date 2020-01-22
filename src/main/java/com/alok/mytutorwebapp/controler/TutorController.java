package com.alok.mytutorwebapp.controler;

import com.alok.mytutorwebapp.model.Tutor;
import com.alok.mytutorwebapp.service.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    @RequestMapping("/allTutors")
    public String getAllTutors(Model model){
        Set<Tutor> tutors = tutorService.findAll();
        model.addAttribute("allTutors", tutors);
        return "tutor/AllTutor";
    }

    @RequestMapping("/tutors/find")
    public String findTutors(Model model){
        model.addAttribute("tutor",new Tutor());
        return "tutor/findTutors";
    }

    @GetMapping("/tutors")
    public String processFindForm(Tutor tutor, BindingResult result, Model model){
        if (tutor.getLastName() == null) {
            tutor.setLastName(""); // empty string signifies broadest possible search
        }

        List<Tutor> results = tutorService.findAllByLastNameLike("%"+ tutor.getLastName() + "%");

        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "tutor/findTutors";
        } else if (results.size() == 1) {
            // 1 owner found
            tutor = results.get(0);
            return "redirect:/tutors/" + tutor.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "tutor/tutorList";
        }
    }

    @GetMapping("/tutors/new")
    public String initCreationForm(Model model) {
        Tutor tutor = new Tutor();
        model.addAttribute("tutor", tutor);
        return "tutor/createOrUpdateTutorForm";
    }

    @PostMapping("/tutors/new")
    public String processCreationForm(@Valid Tutor tutor, BindingResult result) {
        if (result.hasErrors()) {
            return "tutor/createOrUpdateTutorForm";
        } else {
            tutorService.save(tutor);
            return "redirect:/tutors/" + tutor.getId();
        }
    }

    @GetMapping("/tutors/{tutorId}")
    public String initUpdateOwnerForm(@PathVariable("tutorId") long tutorId, Model model) {
        Tutor tutor = tutorService.findByID(tutorId);
        model.addAttribute(tutor);
        return "tutor/createOrUpdateTutorForm";
    }

    @PostMapping("tutors/{tutorId}")
    public String processUpdateOwnerForm(@Valid Tutor tutor, BindingResult result, @PathVariable("tutorId") long tutorId) {
        if (result.hasErrors()) {
            return "tutor/createOrUpdateTutorForm";
        } else {
            tutor.setId(tutorId);
            tutorService.save(tutor);
            return "redirect:/tutors/{tutorId}";
        }
    }

    /*@GetMapping("/tutors/{tutorId}/edit")
    public ModelAndView showTutor(@PathVariable("tutorId") long tutorId) {
        ModelAndView mav = new ModelAndView("tutor/tutorDetails");
        Tutor tutor = tutorService.findByID(tutorId);
        *//*if(tutor == null){
            //throw new NotFoundException("tutor not found");
            handleNotFound();
        }*//*
        mav.addObject(tutor);
        return mav;
    }*/

   /* @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(){
        ModelAndView modelAndView   =   new ModelAndView();
        modelAndView.setViewName("/404Error");
        return modelAndView;
    }*/


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}
