package ObjectClass.Frame_2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ObjectClass.Enum.FrameStatic;
import ObjectClass.ch9_10.SalariedEmployee;
import ObjectClass3.Data.ReadSequentialFile;
import ObjectClass3.Data.WriteSequentialFile;

public class SalaryEmployeeFrame extends EmployeeFrame {

	private JLabel lblpayMonthPerYear;
	private JLabel lblsalary;
	private JTextField tfpayMonthPerYear;
	private JTextField tfsalary;

	ArrayList<SalariedEmployee> rd = new ArrayList<>();
	String[] strTitle = { "姓氏", "名字", "ID", "幾個月", "月薪" };
	String filename = "SalaryEmployeeFrame.data";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryEmployeeFrame frame = new SalaryEmployeeFrame();
					frame.setVisible(true);
					frame.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void changeUI(FrameStatic fs) {
		super.changeUI(fs);
		switch (fs) {
		case init:
			tfpayMonthPerYear.setText("");
			tfsalary.setText("");
			tfpayMonthPerYear.setEditable(false);
			tfsalary.setEditable(false);
			break;
		case btnNew:
			tfpayMonthPerYear.setText("");
			tfsalary.setText("");
			tfpayMonthPerYear.setEditable(true);
			tfsalary.setEditable(true);
			break;
		case withData:
			tfpayMonthPerYear.setEditable(false);
			tfsalary.setEditable(false);
			break;
		case btnUpdate:
			tfpayMonthPerYear.setEditable(true);
			tfsalary.setEditable(true);
			tfpayMonthPerYear.requestFocus();
			break;
		}
	}
	
	@Override
	public void init() {
		changeUI(FrameStatic.init);
	}
	
	private void showData(int i) {
		if (rd.size() > 0) {
			iPosition = i;
			tfFirstName.setText(rd.get(i).getFirstName());
			tfLastName.setText(rd.get(i).getLastName());
			tfID.setText(rd.get(i).getSocialSecurityNumber());
			tfpayMonthPerYear.setText(String.valueOf(rd.get(i).getPayMonthPerYear()));
			tfsalary.setText(String.valueOf(rd.get(i).getSalary()));
			lblContent.setText((i + 1) + "/" + rd.size());
		}
	}

	/**
	 * Create the frame.
	 */
	public SalaryEmployeeFrame() {
		super();
		setTitle("A109222010_SalaryEmployee");

		btnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalariedEmployee e1 = fnValidate(tfFirstName.getText(), tfLastName.getText(), tfID.getText(),
						tfpayMonthPerYear.getText(), tfsalary.getText());
				if (e1 != null) {
					if (!btnAddUpdate) {// false 表示 add, true 表示 update
						rd.add(e1);
						JOptionPane.showMessageDialog(null, "add Success", "", JOptionPane.INFORMATION_MESSAGE);
						showData(rd.size() - 1);
					} else {
						rd.get(iPosition).setPayMonthPerYear(e1.getPayMonthPerYear());
						rd.get(iPosition).setSalary(e1.getSalary());
						JOptionPane.showMessageDialog(null, "Update Success", "", JOptionPane.INFORMATION_MESSAGE);
						showData(iPosition);
					}
					String[][] strvalue = new String[rd.size()][5];
					for (int i = 0; i < rd.size(); i++) {
						strvalue[i][0] = rd.get(i).getLastName();
						strvalue[i][1] = rd.get(i).getFirstName();
						strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
						strvalue[i][3] = String.valueOf(rd.get(i).getPayMonthPerYear());
						strvalue[i][4] = String.valueOf(rd.get(i).getSalary());
					}
					model.setDataVector(strvalue, strTitle);
					changeUI(FrameStatic.withData);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rd.size() > 0) {
					changeUI(FrameStatic.withData);
					showData(iPosition);
				} else {
					changeUI(FrameStatic.init);
				}
			}
		});
		
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rd.remove(iPosition);
				if(rd.size()>0) {
					if(iPosition >= rd.size()) iPosition = rd.size()-1;
					showData(iPosition);
					String[][] strvalue = new String[rd.size()][5];
					for (int i = 0; i < rd.size(); i++) {
						strvalue[i][0] = rd.get(i).getLastName();
						strvalue[i][1] = rd.get(i).getFirstName();
						strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
						strvalue[i][3] = String.valueOf(rd.get(i).getPayMonthPerYear());
						strvalue[i][4] = String.valueOf(rd.get(i).getSalary());
					}
					model.setDataVector(strvalue, strTitle);
					changeUI(FrameStatic.withData);	
				}else {
					model.setDataVector(null, strTitle);
					changeUI(FrameStatic.init);	
				}
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteSequentialFile wf = new WriteSequentialFile(filename);
				wf.fnWSF(rd);
			}
		});
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadSequentialFile<SalariedEmployee> rf = new ReadSequentialFile<SalariedEmployee>(filename);
				try {
					rd = rf.getRSF();
					if(rd.size() == 0) {
						changeUI(FrameStatic.init);
					}else {
						changeUI(FrameStatic.withData);
						String[][] strvalue = new String[rd.size()][5];
						for (int i = 0; i < rd.size(); i++) {
							strvalue[i][0] = rd.get(i).getLastName();
							strvalue[i][1] = rd.get(i).getFirstName();
							strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
							strvalue[i][3] = String.valueOf(rd.get(i).getPayMonthPerYear());
							strvalue[i][4] = String.valueOf(rd.get(i).getSalary());
						}
						model.setDataVector(strvalue, strTitle);
						showData(0);
					}
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		btnFirstData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(0);
			}
		});

		btnPreData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (iPosition > 0)
					showData(iPosition - 1);
			}
		});

		btnNextData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (iPosition < rd.size() - 1)
					showData(iPosition + 1);
			}
		});

		btnLastData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData(rd.size() - 1);
			}
		});

		lblpayMonthPerYear = new JLabel("幾個月");
		lblpayMonthPerYear.setToolTipText("請輸入大於等於０的數字");
		lblpayMonthPerYear.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblpayMonthPerYear.setBounds(31, 180, 107, 45);
		panelData.add(lblpayMonthPerYear);

		lblsalary = new JLabel("月薪");
		lblsalary.setToolTipText("請輸入大於等於25600以上的數字");
		lblsalary.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblsalary.setBounds(31, 232, 107, 45);
		panelData.add(lblsalary);

		tfpayMonthPerYear = new JTextField();
		tfpayMonthPerYear.setBounds(172, 192, 141, 21);
		panelData.add(tfpayMonthPerYear);
		tfpayMonthPerYear.setColumns(10);

		tfsalary = new JTextField();
		tfsalary.setBounds(172, 242, 141, 21);
		panelData.add(tfsalary);
		tfsalary.setColumns(10);
	}

	private SalariedEmployee fnValidate(String strFirstName, String strLastName, String strID, String strMonthPerYear,
			String strsalary) {
		SalariedEmployee he = null;
		String retuString = "";
		if (strFirstName.length() == 0) {
			lblFirstName.setForeground(Color.RED);
			retuString += lblFirstName.getToolTipText() + "\n";
		} else {
			lblFirstName.setForeground(Color.BLACK);
		}
		if (strLastName.length() == 0) {
			lblLastName.setForeground(Color.RED);
			retuString += lblLastName.getToolTipText() + "\n";
		} else {
			lblLastName.setForeground(Color.BLACK);
		}
		if (strID.length() == 0) {
			lblID.setForeground(Color.RED);
			retuString += lblID.getToolTipText() + "\n";
		} else {
			lblID.setForeground(Color.BLACK);
		}

		Double dpayMonthPerYear = 0.0;
		try {
			dpayMonthPerYear = Double.parseDouble(strMonthPerYear);
			if (dpayMonthPerYear < ０) {
				lblpayMonthPerYear.setForeground(Color.RED);
				retuString += lblpayMonthPerYear.getToolTipText() + "\n";
			} else {
				lblpayMonthPerYear.setForeground(Color.BLACK);
			}
		} catch (Exception e) {
			lblpayMonthPerYear.setForeground(Color.RED);
			retuString += lblpayMonthPerYear.getToolTipText() + "\n";
		}

		Double dsalary = 0.0;
		try {
			dsalary = Double.parseDouble(strsalary);
			if (dsalary < 25600) {
				lblsalary.setForeground(Color.RED);
				retuString += lblsalary.getToolTipText() + "\n";
			} else {
				lblsalary.setForeground(Color.BLACK);
			}
		} catch (Exception e) {
			lblsalary.setForeground(Color.RED);
			retuString += lblsalary.getToolTipText() + "\n";
		}

		if (retuString.equals("")) {
			he = new SalariedEmployee(strFirstName, strLastName, strID, dpayMonthPerYear, dsalary);
		} else {
			JOptionPane.showMessageDialog(null, retuString, "Input Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return he;
	}
}
