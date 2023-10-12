package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Employee;
import tech.csm.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee saveEmp(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmp() {
		return employeeRepo.findAll();
	}

	@Override
	public void deleteEmp(Integer empId) {
		employeeRepo.deleteById(empId);
	}

	@Override
	public Employee getEmpById(Integer empId) {
		return employeeRepo.findById(empId).get();
	}

}
