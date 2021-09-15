package com.bootSpring.Springboot.service;

import com.bootSpring.Springboot.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartmentWithNewSchool(Department department);

    public Department saveDepartment(Department department, Long schoolId);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Department department,Long departmentId);

    public Department fetchDepartmentByName(String departmentName);

}
