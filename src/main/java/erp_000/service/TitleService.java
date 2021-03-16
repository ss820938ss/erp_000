package erp_000.service;

import java.util.List;

import erp_000.dao.EmployeeDao;
import erp_000.dao.TitleDao;
import erp_000.dao.impl.EmployeeDaoImpl;
import erp_000.dao.impl.TitleDaoImpl;
import erp_000.dto.Employee;
import erp_000.dto.Title;

public class TitleService {
	private TitleDao dao = TitleDaoImpl.getInstance();
	private EmployeeDao empDao = EmployeeDaoImpl.getInstance();
	
	public List<Title> showTitles(){
		return dao.selectTitleByAll();
	}
	
	public void addTitle(Title title) {
		dao.insertTitle(title);
	}
	
	public void removeTitle(Title title) {
		dao.deleteTitle(title.gettNo());
	}
	
	public void modifyTitle(Title title) {
		dao.updateTitle(title);
	}
	
	public List<Employee> showEmployeeGroupByTitle(Title title){
		return empDao.selectEmployeeByTitle(title);
	}
}
