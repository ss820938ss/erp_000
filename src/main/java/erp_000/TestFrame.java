package erp_000;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erp_000.dto.Employee;
import erp_000.dto.EmployeeDetail;
import erp_000.service.EmployeeDetailService;
import erp_000.service.EmployeeService;
import erp_000.ui.content.EmployeeDetailPanel;
import erp_000.ui.list.EmployeeTablePanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TestFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private EmployeeTablePanel pList;
	private EmployeeDetailPanel panel;
	private JPanel panel_1;
	private JButton btnGet;
	private JButton btnSet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestFrame() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		EmployeeService service = new EmployeeService();
		
		pList = new EmployeeTablePanel();
		pList.setService(service);
		pList.loadData();
		contentPane.add(pList);
		
		panel = new EmployeeDetailPanel();
		panel.setTfEmpno(new Employee(1003));
		
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		btnGet = new JButton("가져오기");
		btnGet.addActionListener(this);
		panel_1.add(btnGet);
		
		btnSet = new JButton("불러오기");
		btnSet.addActionListener(this);
		panel_1.add(btnSet);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSet) {
			actionPerformedBtnSet(e);
		}
		if (e.getSource() == btnGet) {
			actionPerformedBtnGet(e);
		}
	}
	protected void actionPerformedBtnGet(ActionEvent e) {
		EmployeeDetail employeeDetail = panel.getItem();
		JOptionPane.showMessageDialog(null, employeeDetail);
	}
	
	protected void actionPerformedBtnSet(ActionEvent e) {
		EmployeeDetailService service = new EmployeeDetailService();
		EmployeeDetail empDetail = service.selectEmployeeDetailByEmpNo(new Employee(1003));
		panel.setItem(empDetail);
	}
	
}