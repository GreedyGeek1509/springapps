package com.sriram.spring.controller;

import com.sriram.spring.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.sriram.spring.Constants.*;

@Slf4j
@Controller
public class EmployeeController {
    Map<Integer, Employee> employeeMap = new HashMap();

    @GetMapping(DUMMY_EMP)
    public @ResponseBody Employee getDummyEmployee() {
        log.info("Start getDummyEmployee");
        Employee emp = new Employee();
        emp.setId(9999);
        emp.setName("Dummy");
        emp.setCreatedDate(new Date());
        employeeMap.put(9999, emp);
        return emp;
    }


    @GetMapping(GET_EMP)
    public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
        log.info("Start getEmployee. ID="+empId);
        return employeeMap.get(empId);
    }

    @GetMapping(GET_ALL_EMP)
    public @ResponseBody List<Employee> getAllEmployees() {
        log.info("Start getAllEmployees.");
        List<Employee> emps = new ArrayList<Employee>();
        employeeMap.forEach((i, emp) -> emps.add(emp));
        return emps;
    }

    @PostMapping(CREATE_EMP)
    public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
        log.info("Start createEmployee.");
        emp.setCreatedDate(new Date());
        employeeMap.put(emp.getId(), emp);
        return emp;
    }

    @PutMapping(DELETE_EMP)
    public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
        log.info("Start deleteEmployee.");
        Employee emp = employeeMap.get(empId);
        employeeMap.remove(empId);
        return emp;
    }
}
