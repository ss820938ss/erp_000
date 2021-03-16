package erp_000.dao;

import java.util.List;

import erp_000.dto.Department;
import erp_000.dto.Employee;
import erp_000.dto.Title;

public interface EmployeeDao {
	List<Employee> selectEmployeeByAll();
	Employee selectEmployeeByNo(Employee employee);
	
	int insertEmployee(Employee employee);
	int updateEmployee(Employee employee);
	int deleteEmployee(Employee employee);
	
	List<Employee> selectEmployeeByTitle(Title title);
	List<Employee> selectEmployeeByDept(Department dept);
}

