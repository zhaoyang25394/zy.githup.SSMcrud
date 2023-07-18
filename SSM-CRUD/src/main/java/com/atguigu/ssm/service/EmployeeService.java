package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

public interface EmployeeService {
    PageInfo<Employee> getEmployeePage(Integer pageNum);
    int save(Employee employee);

    int deleteEmp(int empId);

    Employee getEmployeeById(int empId);

    int updateEmployee(Employee employee);

}
