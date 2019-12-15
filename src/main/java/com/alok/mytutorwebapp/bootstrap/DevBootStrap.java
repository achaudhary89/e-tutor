package com.alok.mytutorwebapp.bootstrap;

import com.alok.mytutorwebapp.model.Tuition;
import com.alok.mytutorwebapp.model.Tutor;
import com.alok.mytutorwebapp.repository.TuitionRepository;
import com.alok.mytutorwebapp.repository.TutorRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private TuitionRepository tuitionRepository;
    private TutorRepository tutorRepository;

    public DevBootStrap(TuitionRepository tuitionRepository, TutorRepository tutorRepository){

        this.tuitionRepository = tuitionRepository;
        this.tutorRepository = tutorRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Tuition tuition = new Tuition("spring", "online","anywhere");
        Tutor tutor = new Tutor("ALOK" , "chaudhary", "99999999","test@gmail.com");
        tuition.getTutorSet().add(tutor);

        tutorRepository.save(tutor);
        tuitionRepository.save(tuition);

      /*  Tutor alok = new Tutor("ALOK123" , "chaudhary11", "99999999","test@gmail.com");
        Tuition java = new Tuition("java", "online","anywhere");
        Tuition sql = new Tuition("sql", "online","anywhere");
        alok.getTuitions().add(java);
        alok.getTuitions().add(sql);

        tuitionRepository.save(tuition);
        tutorRepository.save(alok);*/
    }
}
