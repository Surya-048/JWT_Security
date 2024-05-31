package rest.Rest_Beginning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.Rest_Beginning.dao.EmployeeRepo;
import rest.Rest_Beginning.model.Employee;

import java.util.List;
import java.util.Optional;

@Service
public class Services {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> displayAll() throws Exception{
        List<Employee> employees = this.employeeRepo.findAll();
        return employees;
    }

    public Employee displayById(int Id)throws Exception{
        Employee employee = null;
        employee = this.employeeRepo.findById(Id).get();
        return employee;
    }

    public void deleteAll()throws Exception{
        this.employeeRepo.deleteAll();
    }

    public void deleteById(int id)throws Exception{
        Employee employee1 = this.employeeRepo.findById(id).get();
        if(employee1 == null){
            throw new Exception("Not found any Employee with Id : " + id);
        }else{
            this.employeeRepo.deleteById(id);
        }
    }

    public Employee update(int id,Employee employee)throws Exception{
        Employee employee1 = null;
        if(this.employeeRepo.existsById(id)){
           employee.setId(id);
           employee1 = this.employeeRepo.save(employee);
        }else{
            throw new Exception("Not found any Employee with Id : " + id);
        }
        return employee1;
    }

    public void save(Employee employee)throws Exception{

        this.employeeRepo.save(employee);

    }
}
