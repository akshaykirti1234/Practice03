package tech.csm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tech.csm.model.Employee;
import tech.csm.service.EmployeeService;
import tech.csm.util.FileUpload;

@Controller
public class EmpController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("empList", employeeService.getAllEmp());
		return "jspPage";
	}

	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee employee, @RequestParam("photo") MultipartFile photo,
			RedirectAttributes redirectAttributes) {

		// set the photo path (Condition for Update Case)
		if (photo.isEmpty() || photo == null) {
			Employee e = employeeService.getEmpById(employee.getEmpId());
			employee.setEmpPhoto(e.getEmpPhoto());
		} else {
			employee.setEmpPhoto(FileUpload.uploadFile(photo));
		}

		Employee e = employeeService.saveEmp(employee);

		redirectAttributes.addFlashAttribute("msg", "Successfuly saved with id " + e.getEmpId());
		return "redirect:/";
	}

	@GetMapping("/deleteEmp")
	public String deleteEmp(@RequestParam("empId") Integer empId, RedirectAttributes redirectAttributes) {
		employeeService.deleteEmp(empId);
		redirectAttributes.addFlashAttribute("msg", "Deleted Successfully");
		return "redirect:/";
	}

	@GetMapping("/editEmp")
	public String editEmp(@RequestParam("empId") Integer empId, Model model) {
		Employee employee = employeeService.getEmpById(empId);
		model.addAttribute("empList", employeeService.getAllEmp());
		model.addAttribute("employee", employee);
		return "jspPage";
	}

}
