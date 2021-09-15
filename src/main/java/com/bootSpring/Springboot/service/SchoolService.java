package com.bootSpring.Springboot.service;

import com.bootSpring.Springboot.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SchoolService{
    public List<School> fetchSchoolList();

    public School saveSchool(School school);

    public School fetchSchoolById(Long schoolId);

    //public School saveSchool(School school,Long departmentId);

    void deleteSchoolById(Long schooId);

    public School updateSchool(School school,Long schoolId);
}
