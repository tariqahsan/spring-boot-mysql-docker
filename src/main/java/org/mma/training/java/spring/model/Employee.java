package org.mma.training.java.spring.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "EMPLOYEE_ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "FULL_NAME")
	@Size(min = 3, max = 25)
	private String fullName;
	
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MGR_NAME")
	private String managerName;

	@Column(name = "SALARY")
	private BigDecimal salary;

	//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
	//	@JsonBackReference
	//	private Department department;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
	@JsonBackReference
	private Department department;

	public Employee() {}

	public Employee(Long id, @Size(min = 3, max = 25) String fullName,
			String email, String managerName, BigDecimal salary, Department department) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.managerName = managerName;
		this.salary = salary;
		this.department = department;
	}
	
	public Employee(@Size(min = 3, max = 25) String fullName,String email,
			String managerName, BigDecimal salary, Department department) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.managerName = managerName;
		this.salary = salary;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFirstName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName +  
				 ", managerName=" + managerName + ", salary=" + salary + ", department=" + department + "]";
	}

}
