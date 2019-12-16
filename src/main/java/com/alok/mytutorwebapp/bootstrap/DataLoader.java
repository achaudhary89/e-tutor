package com.alok.mytutorwebapp.bootstrap;

import com.alok.mytutorwebapp.model.Tuition;
import com.alok.mytutorwebapp.model.Tutor;
import com.alok.mytutorwebapp.service.TuitionService;
import com.alok.mytutorwebapp.service.TutorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TutorService tutorService;
    private final TuitionService tuitionService;

    public DataLoader(TutorService tutorService, TuitionService tuitionService) {
        this.tutorService = tutorService;
        this.tuitionService = tuitionService;
    }

    @Override
    public void run(String... args) throws Exception {
        Tutor tutor1    =   new Tutor();
        tutor1.setId(2l);
        tutor1.setFirstName("rohan");
        tutor1.setLastName("Singh");
        tutor1.setEmail("rohan@gmail.com");
        tutor1.setMobileNumber("345533333");

        tutorService.save(tutor1);

        Tutor tutor2    =   new Tutor();
        tutor2.setId(3l);
        tutor1.setFirstName("nolan");
        tutor1.setLastName("christopher");
        tutor1.setEmail("nolan@gmail.com");
        tutor1.setMobileNumber("74747474");

        tutorService.save(tutor2);

        Tuition tuition  = new Tuition();
        tuition.setId(2l);
        tuition.setLocation("washington");
        tuition.setTuitionSubject("math");
        tuition.setMode("online");

        tuitionService.save(tuition);

    }
}
