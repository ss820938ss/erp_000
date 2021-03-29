package erp_000.dao;

import erp_000.dto.Employee;
import erp_000.dto.EmployeeDetail;

public interface EmployeeDetailDao {
	
	EmployeeDetail selectEmployeeDetailByNo(Employee employee);
	
	int insertEmployeeDetail(EmployeeDetail empDetail);
	int updateEmployeeDetail(EmployeeDetail empDetail);
	int deleteEmployeeDetail(Employee employee);

}



