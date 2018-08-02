package com.konrad.school.servis;

import com.konrad.school.iservice.ISchoolService;
import com.konrad.school.model.School;
import com.konrad.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements ISchoolService {
    private SchoolRepository schoolRepository;

    @Autowired
    SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public void save(School school) {
        schoolRepository.save(school);
    }

    @Override
    public School findSchoolById(int id) {
        return schoolRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        schoolRepository.deleteById(id);
    }
}
