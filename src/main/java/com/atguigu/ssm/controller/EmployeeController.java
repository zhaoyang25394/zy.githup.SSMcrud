package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum")Integer pageNum, Model model){
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        model.addAttribute("page",page);
        return "employee_list";

    }


    @RequestMapping(value = "/employee",method = RequestMethod.POST)
//    public String ok(){
//        return "ok";
//    }
   public String save(Employee employee){
        int i = employeeService.save(employee);
        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE)
    public String empDelete(@PathVariable("empId") Integer empId){
        int i = employeeService.deleteEmp(empId);
        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.GET)
    public String goToUpdate(@PathVariable("empId")Integer empId, Model model){
        Employee employee = employeeService.getEmployeeById(empId);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String employeeUpdate(Employee employee){
        System.out.println("修改数据对象+"+employee);
        int i = employeeService.updateEmployee(employee);
        System.out.println("修改数据对象+"+i);
        return "redirect:/employee/page/1";
       }
//        public String ok(){
//        return "ok";
//    }
}
