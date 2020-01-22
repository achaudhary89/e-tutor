package com.alok.mytutorwebapp.service;

import com.alok.mytutorwebapp.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TutorService extends BaseService<Tutor, Long> {

    Tutor findByLastName(String lastName);

    List<Tutor> findAllByLastNameLike(String lastName);
}
