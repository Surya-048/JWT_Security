package rest.Rest_Beginning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.Rest_Beginning.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
