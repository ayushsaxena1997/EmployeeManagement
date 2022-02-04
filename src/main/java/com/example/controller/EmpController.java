package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @GetMapping("/addemp")
    public String addEmpForm(){
        return "add_emp";
    }
    @GetMapping("/")
    public String home(Model model){

        List<Employee> employeesList = service.getAllEmployees();
        model.addAttribute("employees", employeesList);
        return "index";
    }

    @PostMapping("/register")
    public String registerEmployee(@ModelAttribute Employee e, HttpSession session){
        System.out.println(e);
        service.addEmployee(e);
        session.setAttribute("msg", "Employee added successfully!!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String getEmployeeToEdit(@PathVariable int id, Model model){
        Employee e = service.getEmployeeById(id);
        model.addAttribute("emp", e);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee e, HttpSession session){
        service.addEmployee(e);
        session.setAttribute("msg", "Employee Details Updated Syccessfully!!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id, HttpSession session){
        service.deleteEmployee(id);
        session.setAttribute("msg", "Employee Details Deleted Successfully!!");
        return "redirect:/";
    }


}