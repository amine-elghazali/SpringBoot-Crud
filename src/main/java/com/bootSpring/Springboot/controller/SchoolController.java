package com.bootSpring.Springboot.controller;

import com.bootSpring.Springboot.entity.School;
import com.bootSpring.Springboot.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/School")
    public List<School> fetchSchoolList(){
        return schoolService.fetchSchoolList();
    }

    @PostMapping("/School")
    public School saveSchool(@RequestBody School school){
        return schoolService.saveSchool(school);
    }


    @GetMapping("/School/{id}")
    public School fetchSchoolById(@PathVariable("id") Long schoolId){
        return schoolService.fetchSchoolById(schoolId);
    }

    @DeleteMapping("/School/{id}")
    public String deleteSchoolById(@PathVariable("id") Long schooId){
        schoolService.deleteSchoolById(schooId);
        return "School Deleted !";
    }

    @PutMapping("/School/{id}")
    public School updateSchool(@RequestBody School school,@PathVariable("id") Long schoolId){
        return schoolService.updateSchool(school,schoolId);
    }


}
