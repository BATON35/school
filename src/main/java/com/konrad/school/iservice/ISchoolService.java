package com.konrad.school.iservice;

import com.konrad.school.model.School;

import java.util.List;

public interface ISchoolService {
    List<School> findAll();

    void save(School school);

    School findSchoolById(int id);

    void delete(int id);
}
