package com.alok.mytutorwebapp.repository;

import com.alok.mytutorwebapp.model.Tutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TutorRepository extends CrudRepository<Tutor, Long> {

    Tutor findByLastName(String lastName);

    List<Tutor> findAllByLastNameLike(String lastName);

}
