package com.alok.mytutorwebapp.service.map;

import com.alok.mytutorwebapp.model.Tutor;
import com.alok.mytutorwebapp.service.TutorService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
@Profile("map")
public class TutorMapServiceImpl extends AbstractMapService<Tutor, Long> implements TutorService {

    @Override
    public Set<Tutor> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void save(Tutor object) {
        super.save(object.getId(), object);
    }

    @Override
    public void delete(Tutor object) {
        super.delete(object);
    }

    @Override
    public Tutor findByID(Long id) {
        return super.findByID(id);
    }

    @Override
    public Tutor findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Tutor> findAllByLastNameLike(String lastName) {
        return null;
    }
}
