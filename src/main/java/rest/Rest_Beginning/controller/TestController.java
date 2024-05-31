package rest.Rest_Beginning.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rest.Rest_Beginning.dto.EmployeeDto;
import rest.Rest_Beginning.model.Employee;
import rest.Rest_Beginning.service.Services;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class TestController {
    @Autowired
   private Services service;

    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> display() throws Exception {
        List<Employee> employees = service.displayAll();
        if(employees.isEmpty()){
            return new ResponseEntity("There is no any Employees",HttpStatus.NOT_FOUND);
        }else {
            return ResponseEntity.of(Optional.of(employees));
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/employee/{Id}")
    public ResponseEntity<Employee> displayById(@PathVariable("Id")int id)throws Exception{
        Employee employee=service.displayById(id);
        if(employee!=null){
            return ResponseEntity.of(Optional.of(employee));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/employee")
    public void deleteAll() throws Exception {
        this.service.deleteAll();
    }
    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/employee/{Id}")
    public void deleteById(@PathVariable("Id")int id) throws Exception {
        this.service.deleteById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/employee")
    public ResponseEntity<List<Employee>> save(@RequestBody EmployeeDto employeeDto) throws Exception {
         this.service.save(this.modelMapper.map(employeeDto, Employee.class));
        return ResponseEntity.of(Optional.of(this.service.displayAll()));
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto) throws Exception {
        Employee update = this.service.update(id, this.modelMapper.map(employeeDto,Employee.class));

        return ResponseEntity.of(Optional.of(update));
    }


}
