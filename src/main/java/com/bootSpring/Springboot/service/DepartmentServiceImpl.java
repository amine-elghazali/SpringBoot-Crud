package com.bootSpring.Springboot.service;

import com.bootSpring.Springboot.entity.Department;
import com.bootSpring.Springboot.entity.School;
import com.bootSpring.Springboot.repository.DepartmentRepository;
import com.bootSpring.Springboot.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public Department saveDepartmentWithNewSchool(Department department) {
        schoolRepository.save(department.getSchool());
        return departmentRepository.save(department);
    }

    @Override
    public Department saveDepartment(Department department, Long schoolId) {
        School school = schoolRepository.findById(schoolId).get();
        department.setSchool(school);
        return departmentRepository.save(department);
    }


    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get(); // find By id will return the optional, so to get the id , we have to use " .get()  "
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Department department,Long departmentId) {

        // We can a validation if the element is not NULL , and != "", then we update , else we skip it

            Department depDB = departmentRepository.findById(departmentId).get();
            depDB.setDepartmentName( department.getDepartmentName() );
            depDB.setDepartmentAddress( department.getDepartmentAddress() );
            depDB.setDepartmentCode( department.getDepartmentCode() );

            departmentRepository.save(depDB);

            return depDB;
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
