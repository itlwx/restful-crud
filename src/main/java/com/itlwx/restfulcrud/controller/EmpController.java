package com.itlwx.restfulcrud.controller;

import com.itlwx.restfulcrud.dao.DepartmentDao;
import com.itlwx.restfulcrud.dao.EmployeeDao;
import com.itlwx.restfulcrud.entities.Department;
import com.itlwx.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping(value="/emps")
    public String emps(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }

    @GetMapping(value="/emp")
    public String addPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping(value="/emp")
    public String add(Employee emp){
        employeeDao.save(emp);
        //重定向到列表页面
        return "redirect:/emps";
    }

    @GetMapping(value="/emp/{id}")
    public String editPage(@PathVariable Integer id, Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);

        /*添加页面与编辑页面二合一*/
        return "emp/add";
    }

    @PutMapping(value="/emp")
    public String edit(Employee emp){
        employeeDao.save(emp);
        return "redirect:/emps";
    }
}
