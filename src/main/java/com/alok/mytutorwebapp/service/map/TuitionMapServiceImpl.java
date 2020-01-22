package com.alok.mytutorwebapp.service.map;

import com.alok.mytutorwebapp.model.Tuition;
import com.alok.mytutorwebapp.service.TuitionService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("map")
public class TuitionMapServiceImpl extends AbstractMapService<Tuition, Long> implements TuitionService {
    @Override
    public Set<Tuition> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void save(Tuition object) {
         super.save(object.getId(), object);
    }

    @Override
    public void delete(Tuition object) {
        super.delete(object);
    }

    @Override
    public Tuition findByID(Long id) {
        return super.findByID(id);
    }
}
