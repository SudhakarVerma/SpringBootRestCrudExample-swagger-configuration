package spring.app.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.app.example.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
