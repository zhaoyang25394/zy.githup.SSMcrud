package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;

    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        PageHelper.startPage(pageNum,4);
        List<Employee> list = employeeMapper.getAllEmployee();
        PageInfo<Employee> page = new PageInfo<Employee>(list, 5);
        return page;
    }

    public int save(Employee employee) {
        int i = employeeMapper.save(employee);
        return i;

    }

    public int deleteEmp(int empId) {
        int delete = employeeMapper.delete(empId);
        return delete;
    }

    public Employee getEmployeeById(int empId) {
        return employeeMapper.getEmployeeById(empId);
    }

    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }


}
