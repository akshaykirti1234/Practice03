package tech.csm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_salary")
	private Double empSalary;

	@Column(name = "emp_mail")
	private String empMail;

	@Column(name = "emp_mobile")
	private String empMobile;

	@Column(name = "emp_photo")
	private String empPhoto;

	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "emp_dob")
	private Date empDob;

}
