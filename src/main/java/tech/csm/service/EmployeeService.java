package tech.csm.service;

import java.util.List;

import tech.csm.model.Employee;

public interface EmployeeService {

	Employee saveEmp(Employee employee);

	List<Employee> getAllEmp();

	void deleteEmp(Integer empId);

	Employee getEmpById(Integer empId);

}
