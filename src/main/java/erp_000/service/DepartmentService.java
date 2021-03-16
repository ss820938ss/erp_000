package erp_000.service;

import java.util.List;

import erp_000.dao.DepartmentDao;
import erp_000.dao.EmployeeDao;
import erp_000.dao.impl.DepartmentDaoImpl;
import erp_000.dao.impl.EmployeeDaoImpl;
import erp_000.dto.Department;
import erp_000.dto.Employee;

public class DepartmentService {
	private DepartmentDao dao = DepartmentDaoImpl.getInstance();
	private EmployeeDao empDao = EmployeeDaoImpl.getInstance();
	
	public List<Department> showDeptList(){
		return dao.selectDepartmentByAll();
	}
	
	public void addDepartment(Department dept) {
		dao.insertDepartment(dept);
	}
	
	public void removeDepartment(Department dept) {
		dao.deleteDepartment(dept.getDeptNo());
	}
	
	public void modifyDepartment(Department dept) {
		dao.updateDepartment(dept);
	}
	
	public List<Employee> showEmployeeGroupByDepartment(Department dept){
		return empDao.selectEmployeeByDept(dept);
	}
}
