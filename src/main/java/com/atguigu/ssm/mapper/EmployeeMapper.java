package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> getAllEmployee();
    int save(Employee employee);

    int delete(int empId);

    Employee getEmployeeById(int empId);

    int updateEmployee(Employee employee);




}
