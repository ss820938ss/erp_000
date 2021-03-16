package erp_000.dao;

import java.util.List;

import erp_000.dao.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	Department selectDepartmentByNo(Department department);
	
	int insertDepartment(Department department);
	int updateDepartment(Department department);
	int deleteDepartment(int deptNo);
}