package erp_000.ui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import erp_000.dto.Employee;
import erp_000.dto.EmployeeDetail;
import erp_000.service.EmployeeDetailService;
import erp_000.service.EmployeeService;
import erp_000.ui.content.AbstractContentPanel;
import erp_000.ui.content.EmployeePanel;
import erp_000.ui.list.AbstractCustomTablePanel;
import erp_000.ui.list.EmployeeTablePanel;

@SuppressWarnings("serial")
public class EmployeeManagerUI extends AbstractManagerUI<Employee> {
	private EmployeeService service;
	private EmployeeDetailService detailService;
	
	public EmployeeManagerUI() {
		empListByTitleItem.setText(AbstractManagerUI.EMP_MENU);
	}
	
	@Override
	protected void setService() {
		service = new EmployeeService();
		detailService = new EmployeeDetailService();
	}

	@Override
	protected void tableLoadData() {
		((EmployeeTablePanel)pList).setService(service);
		pList.loadData();		
	}

	@Override
	protected AbstractContentPanel<Employee> createContentPanel() {
		EmployeePanel empPanel = new EmployeePanel();
		empPanel.setService(service);
		return empPanel;
	}

	@Override
	protected AbstractCustomTablePanel<Employee> createTablePanel() {
		return new EmployeeTablePanel();
	}

	@Override
	protected void actionPerformedMenuGubun() {
		Employee emp = pList.getItem();
		EmployeeDetail empDetail = detailService.selectEmployeeDetailByEmpNo(emp);

		//나중에 처리
		EmployeeDetailUI frame;
		if (empDetail == null) {
			frame = new EmployeeDetailUI(true, detailService);
		}else {
			frame = new EmployeeDetailUI(false, detailService);
			frame.setDetailItem(empDetail);
		}
		frame.setEmpNo(emp);
		frame.setVisible(true);
	}

	@Override
	protected void actionPerformedMenuUpdate() {
		Employee updateEmp = pList.getItem();
		pContent.setItem(updateEmp);
		btnAdd.setText("수정");			
	}

	@Override
	protected void actionPerformedMenuDelete() {
		Employee delEmp = pList.getItem();
		service.removeEmployee(delEmp);
		pList.loadData();
		JOptionPane.showMessageDialog(null, delEmp + "삭제 되었습니다.");				
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Employee updateEmp = pContent.getItem();
		service.modifyEmployee(updateEmp);
		pList.loadData();
		pContent.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, updateEmp.getEmpName() + "정보가 수정되었습니다.");				
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Employee empl = pContent.getItem();
		service.addEmployee(empl);
		pList.loadData();
		pContent.clearTf();
		JOptionPane.showMessageDialog(null, empl.getEmpName() + " 추가했습니다.");				
	}

}