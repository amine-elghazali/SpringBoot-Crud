package com.bootSpring.Springboot.controller;

import com.bootSpring.Springboot.entity.Department;
import com.bootSpring.Springboot.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/Departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside the fetchDepartmentById of the class DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/Departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){        // Mapping the "" with this {id}
        return departmentService.fetchDepartmentById(departmentId);
    }

    @PostMapping("/Departments")    // @Valid for validation , You can check Department entity to see :) ;)
    public Department saveDepartmentWithNewSchool(@Valid @RequestBody Department department ){  // Get the request body , and convert that JSON to the Department Object
        LOGGER.info("Inside the saveDepartment of the class DepartmentController");
        return departmentService.saveDepartmentWithNewSchool(department);
    }

    @PostMapping("/Department/add/{schoolId}")
    public Department saveDepartment(@RequestBody Department department,@PathVariable("schoolId") Long schoolId){
        return departmentService.saveDepartment(department,schoolId);
    }

    @DeleteMapping("/Departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable("departmentId") Long departmentId){        // Mapping the "" with this {departmentId}
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted !";
    }

    @PutMapping("/Departments/{id}")
    public Department updateDepartment(@RequestBody Department department,@PathVariable("id") Long departmentId ){   // For the Update , we need to get the department by id , and update that departement

        return departmentService.updateDepartment(department,departmentId);
    }


    @GetMapping("/Departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}





