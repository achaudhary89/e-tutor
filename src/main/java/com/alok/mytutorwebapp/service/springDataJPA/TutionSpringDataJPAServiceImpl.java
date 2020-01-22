package com.alok.mytutorwebapp.service.springDataJPA;

import com.alok.mytutorwebapp.model.Tuition;
import com.alok.mytutorwebapp.repository.TuitionRepository;
import com.alok.mytutorwebapp.service.TuitionService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class TutionSpringDataJPAServiceImpl implements TuitionService {

    TuitionRepository tuitionRepository;

    public TutionSpringDataJPAServiceImpl(TuitionRepository tuitionRepository){
        this.tuitionRepository = tuitionRepository;
    }

    @Override
    public Set<Tuition> findAll() {
        Set<Tuition> tuitions = new HashSet<>();
        Iterable<Tuition> iterator= tuitionRepository.findAll();
        Iterator<Tuition> iterator1 = iterator.iterator();
        while (iterator1.hasNext()){
            tuitions.add(iterator1.next());
        }
        return tuitions;
    }

    @Override
    public Tuition findByID(Long aLong) {
        return tuitionRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Tuition object) {
        tuitionRepository.delete(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        tuitionRepository.deleteById(aLong);
    }

    @Override
    public void save(Tuition object) {
        tuitionRepository.save(object);
    }
}
