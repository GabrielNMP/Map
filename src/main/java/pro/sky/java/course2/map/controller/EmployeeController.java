package pro.sky.java.course2.map.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.map.book.Employee;
import pro.sky.java.course2.map.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName){
        return employeeService.addEmployee(firstName,lastName);
    }
    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.deleteEmployee(firstName,lastName);
    }

    @GetMapping("/pass")
    public Employee passEmployee(@RequestParam String firstName,@RequestParam String lastName){
        return employeeService.passEmployee(firstName,lastName);
    }
    @GetMapping("/all")
    public Collection<Employee> finedAll(){
        return employeeService.finedAll();
    }
}
