package com.alok.mytutorwebapp.service.springDataJPA;

import com.alok.mytutorwebapp.model.Tutor;
import com.alok.mytutorwebapp.repository.TutorRepository;
import com.alok.mytutorwebapp.service.TutorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class TutorSpringDataJPAServiceImpl implements TutorService {

    TutorRepository tutorRepository;

    public TutorSpringDataJPAServiceImpl(TutorRepository tutorRepository){
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Set<Tutor> findAll() {
        Set<Tutor> tutors = new HashSet<>();
        Iterable<Tutor> iterator= tutorRepository.findAll();
        Iterator<Tutor> iterator1 = iterator.iterator();
        while (iterator1.hasNext()){
            tutors.add(iterator1.next());
        }
        return tutors;
    }

    @Override
    public Tutor findByID(Long aLong) {
        return tutorRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Tutor object) {
        tutorRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        tutorRepository.deleteById(aLong);
    }

    @Override
    public void save(Tutor object) {
        tutorRepository.save(object);
    }

    @Override
    public Tutor findByLastName(String lastName) {
        return tutorRepository.findByLastName(lastName);
    }

    @Override
    public List<Tutor> findAllByLastNameLike(String lastName) {
        return tutorRepository.findAllByLastNameLike(lastName);
    }
}
