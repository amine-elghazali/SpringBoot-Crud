package com.bootSpring.Springboot.service;

import com.bootSpring.Springboot.entity.Department;
import com.bootSpring.Springboot.entity.School;
import com.bootSpring.Springboot.repository.DepartmentRepository;
import com.bootSpring.Springboot.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<School> fetchSchoolList(){
        return schoolRepository.findAll();
    }

    @Override
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School fetchSchoolById(Long schoolId) {
        return schoolRepository.findById(schoolId).get();
    }

    @Override
    public void deleteSchoolById(Long schoolId) {
        schoolRepository.deleteById(schoolId);
    }

    @Override
    public School updateSchool(School school,Long schoolId) {
        School newSchool = schoolRepository.findById(schoolId).get();
        newSchool.setSchoolName(school.getSchoolName());
        schoolRepository.save(newSchool);
        return newSchool;
    }


}
