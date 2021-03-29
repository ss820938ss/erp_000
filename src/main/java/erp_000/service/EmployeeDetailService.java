package erp_000.service;

import erp_000.dao.EmployeeDetailDao;
import erp_000.dao.impl.EmployeeDetailDaoImpl;
import erp_000.dto.Employee;
import erp_000.dto.EmployeeDetail;

public class EmployeeDetailService {
	private EmployeeDetailDao empDetailDao = EmployeeDetailDaoImpl.getInstance();
	
	public EmployeeDetail selectEmployeeDetailByEmpNo(Employee employee) {
		return empDetailDao.selectEmployeeDetailByNo(employee);
	}
	
	public void addEmployeeDetail(EmployeeDetail empDetail) {
		empDetailDao.insertEmployeeDetail(empDetail);
	}
	
	public void modifyEmployeeDetail(EmployeeDetail empDetail) {
		empDetailDao.updateEmployeeDetail(empDetail);
	}
	
	public void removeEmployeeDetail(Employee employee) {
		empDetailDao.deleteEmployeeDetail(employee);
	}
	
}
