package erp_000.service;

import java.util.List;

import erp_000.dao.DepartmentDao;
import erp_000.dao.EmployeeDao;
import erp_000.dao.TitleDao;
import erp_000.dao.impl.DepartmentDaoImpl;
import erp_000.dao.impl.EmployeeDaoImpl;
import erp_000.dao.impl.TitleDaoImpl;
import erp_000.dto.Department;
import erp_000.dto.Employee;
import erp_000.dto.Title;

public class EmployeeService {
	private DepartmentDao deptDao = DepartmentDaoImpl.getInstance();
	private TitleDao titleDao = TitleDaoImpl.getInstance();
	private EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();
	
	public List<Department> showDeptList(){
		return deptDao.selectDepartmentByAll();
	}
	
	public List<Title> showTitleList(){
		return titleDao.selectTitleByAll();
	}
	
	public List<Employee> showEmployeeByDept(Department dept){
		return employeeDao.selectEmployeeByDept(dept);
	}
	
	public List<Employee> showEmployees(){
		return employeeDao.selectEmployeeByAll();
	}
	
	public void removeEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}
	
	public void modifyEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
	
	public void addEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}
}