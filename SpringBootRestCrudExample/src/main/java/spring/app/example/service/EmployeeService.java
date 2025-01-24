package spring.app.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.app.example.beans.Employee;
import spring.app.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Employee updateEmployee(Long id, Employee employee) {
    	Employee existingProduct = employeeRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(employee.getName());
            existingProduct.setSalary(employee.getSalary());
            employeeRepository.save(existingProduct);
        }
        return existingProduct;
    }
    
    public void deleteEmployee(Long id) {
    	employeeRepository.deleteById(id);
    }
}
