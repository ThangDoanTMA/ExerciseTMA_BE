package com.example.ManagerEmployee.Controller;

import com.example.ManagerEmployee.Model.Employee;
import com.example.ManagerEmployee.Model.ResponseObject;
import com.example.ManagerEmployee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders ="*" )
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("employee/create")
    public String createEmployee(@RequestBody Employee employee){
        Employee insertEmployee = employeeRepository.insert(employee);
        return "Employee created " + insertEmployee.getName();
    }

    @PostMapping("employee/delete={id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeRepository.deleteById(id);
    }

    @GetMapping("/employee/list")
    public List<Employee> listEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<ResponseObject> findEmployee(@PathVariable String id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        return foundEmployee.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query employee success", foundEmployee)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "Can not find employee with id "+id, foundEmployee)
                );
    }

    @PutMapping("/employee/update={id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if(employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setName(employee.getName());
            _employee.setAddress(employee.getAddress());
            _employee.setSex(employee.getSex());
            _employee.setPhoneNumber(employee.getPhoneNumber());
            _employee.setStartDay(employee.getStartDay());
            _employee.setSalaryPerHour(employee.getSalaryPerHour());
            _employee.setWorking(employee.getWorking());
            _employee.setAdvances(employee.getAdvances());
            _employee.setAvatar(employee.getAvatar());
            _employee.setIdTeam(employee.getIdTeam());
            _employee.setAge(employee.getAge());

            return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
