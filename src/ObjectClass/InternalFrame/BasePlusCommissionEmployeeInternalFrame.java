package ObjectClass.InternalFrame;

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
import ObjectClass.ch9_10_2.BasePlusCommissionEmployee;
import ObjectClass3.Data.ReadSequentialFile;
import ObjectClass3.Data.WriteSequentialFile;

public class BasePlusCommissionEmployeeInternalFrame extends EmployeeInternalFrame {

	private JLabel lblgrossSales;
	private JLabel lblcommissionRate;
	private JLabel lblbaseSalary;
	private JTextField tfgrossSales;
	private JTextField tfcommissionRate;
	private JTextField tfbaseSalary;
	static String strFrameTitle = "A109222010_BasePlusCommission";

	ArrayList<BasePlusCommissionEmployee> rd = new ArrayList<>();
	String[] strTitle = { "姓氏", "名字", "ID", "銷售額度", "抽傭比例", "月底薪" };
	String filename = "BasePlusCommissionEmployeeFrame.data";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasePlusCommissionEmployeeInternalFrame frame = new BasePlusCommissionEmployeeInternalFrame();
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
			tfgrossSales.setText("");
			tfcommissionRate.setText("");
			tfbaseSalary.setText("");
			tfbaseSalary.setEditable(false);
			tfgrossSales.setEditable(false);
			tfcommissionRate.setEditable(false);
			break;
		case btnNew:
			tfgrossSales.setText("");
			tfcommissionRate.setText("");
			tfbaseSalary.setText("");
			tfbaseSalary.setEditable(true);
			tfgrossSales.setEditable(true);
			tfcommissionRate.setEditable(true);
			break;
		case withData:
			tfbaseSalary.setEditable(false);
			tfgrossSales.setEditable(false);
			tfcommissionRate.setEditable(false);
			break;
		case btnUpdate:
			tfbaseSalary.setEditable(true);
			tfgrossSales.setEditable(true);
			tfcommissionRate.setEditable(true);
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
			tfbaseSalary.setText(String.valueOf(rd.get(i).getBaseSalary()));
			tfgrossSales.setText(String.valueOf(rd.get(i).getGrossSales()));
			tfcommissionRate.setText(String.valueOf(rd.get(i).getCommissionRate()));
			lblContent.setText((i + 1) + "/" + rd.size());
		}
	}

	/**
	 * Create the frame.
	 */
	public BasePlusCommissionEmployeeInternalFrame() {
		super();
		setTitle(strFrameTitle);

		btnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasePlusCommissionEmployee e1 = fnValidate(tfFirstName.getText(), tfLastName.getText(), tfID.getText(),
						tfgrossSales.getText(), tfcommissionRate.getText(), tfbaseSalary.getText());
				if (e1 != null) {
					if (!btnAddUpdate) {// false 表示 add, true 表示 update
						rd.add(e1);
						JOptionPane.showMessageDialog(null, "add Success", "", JOptionPane.INFORMATION_MESSAGE);
						showData(rd.size() - 1);
					} else {
						rd.get(iPosition).setGrossSales(e1.getGrossSales());
						rd.get(iPosition).setCommissionRate(e1.getCommissionRate());
						rd.get(iPosition).setBaseSalary(e1.getBaseSalary());
						JOptionPane.showMessageDialog(null, "Update Success", "", JOptionPane.INFORMATION_MESSAGE);
						showData(iPosition);
					}
					String[][] strvalue = new String[rd.size()][6];
					for (int i = 0; i < rd.size(); i++) {
						strvalue[i][0] = rd.get(i).getLastName();
						strvalue[i][1] = rd.get(i).getFirstName();
						strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
						strvalue[i][3] = String.valueOf(rd.get(i).getGrossSales());
						strvalue[i][4] = String.valueOf(rd.get(i).getCommissionRate());
						strvalue[i][5] = String.valueOf(rd.get(i).getBaseSalary());
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
					String[][] strvalue = new String[rd.size()][6];
					for (int i = 0; i < rd.size(); i++) {
						strvalue[i][0] = rd.get(i).getLastName();
						strvalue[i][1] = rd.get(i).getFirstName();
						strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
						strvalue[i][3] = String.valueOf(rd.get(i).getGrossSales());
						strvalue[i][4] = String.valueOf(rd.get(i).getCommissionRate());
						strvalue[i][5] = String.valueOf(rd.get(i).getBaseSalary());
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
				WriteSequentialFile<BasePlusCommissionEmployee> wf = new WriteSequentialFile <BasePlusCommissionEmployee>(filename);
				wf.fnWSF(rd);
			}
		});
		
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadSequentialFile<BasePlusCommissionEmployee> rf = new ReadSequentialFile<BasePlusCommissionEmployee>(filename);
				try {
					rd = rf.getRSF();
					if(rd.size() == 0) {
						changeUI(FrameStatic.init);
					}else {
						changeUI(FrameStatic.withData);
						String[][] strvalue = new String[rd.size()][6];
						for (int i = 0; i < rd.size(); i++) {
							strvalue[i][0] = rd.get(i).getLastName();
							strvalue[i][1] = rd.get(i).getFirstName();
							strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
							strvalue[i][3] = String.valueOf(rd.get(i).getGrossSales());
							strvalue[i][4] = String.valueOf(rd.get(i).getCommissionRate());
							strvalue[i][5] = String.valueOf(rd.get(i).getBaseSalary());
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

		lblgrossSales = new JLabel("銷售額度");
		lblgrossSales.setToolTipText("請輸入大於等於0的數字");
		lblgrossSales.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblgrossSales.setBounds(31, 180, 107, 45);
		panelData.add(lblgrossSales);

		lblcommissionRate = new JLabel("抽傭比例");
		lblcommissionRate.setToolTipText("請輸入0~1的數字");
		lblcommissionRate.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblcommissionRate.setBounds(31, 232, 107, 45);
		panelData.add(lblcommissionRate);

		lblbaseSalary = new JLabel("月底薪");
		lblbaseSalary.setToolTipText("請輸入大於0的數字");
		lblbaseSalary.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblbaseSalary.setBounds(31, 284, 107, 45);
		panelData.add(lblbaseSalary);

		tfgrossSales = new JTextField();
		tfgrossSales.setBounds(172, 192, 141, 21);
		panelData.add(tfgrossSales);
		tfgrossSales.setColumns(10);

		tfcommissionRate = new JTextField();
		tfcommissionRate.setBounds(172, 242, 141, 21);
		panelData.add(tfcommissionRate);
		tfcommissionRate.setColumns(10);

		tfbaseSalary = new JTextField();
		tfbaseSalary.setBounds(172, 292, 141, 21);
		panelData.add(tfbaseSalary);
		tfbaseSalary.setColumns(10);
	}

	private BasePlusCommissionEmployee fnValidate(String strFirstName, String strLastName, String strID,
			String strgrossSales, String strcommissionRate, String strBaseSalary) {
		BasePlusCommissionEmployee he = null;
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

		Double dgrossSales = 0.0;
		try {
			dgrossSales = Double.parseDouble(strgrossSales);
			if (dgrossSales < 0) {
				lblgrossSales.setForeground(Color.RED);
				retuString += lblgrossSales.getToolTipText() + "\n";
			} else {
				lblgrossSales.setForeground(Color.BLACK);
			}
		} catch (Exception e) {
			lblgrossSales.setForeground(Color.RED);
			retuString += lblgrossSales.getToolTipText() + "\n";
		}

		Double dcommissionRate = 0.0;
		try {
			dcommissionRate = Double.parseDouble(strcommissionRate);
			if (0 > dcommissionRate || dcommissionRate > 1) {
				lblcommissionRate.setForeground(Color.RED);
				retuString += lblcommissionRate.getToolTipText() + "\n";
			} else {
				lblcommissionRate.setForeground(Color.BLACK);
			}
		} catch (Exception e) {
			lblcommissionRate.setForeground(Color.RED);
			retuString += lblcommissionRate.getToolTipText() + "\n";
		}
		Double dbasesalary = 0.0;
		try {
			dbasesalary = Double.parseDouble(strBaseSalary);
			if (dbasesalary < 0) {
				lblbaseSalary.setForeground(Color.RED);
				retuString += lblbaseSalary.getToolTipText() + "\n";
			} else {
				lblbaseSalary.setForeground(Color.BLACK);
			}
		} catch (Exception e) {
			lblbaseSalary.setForeground(Color.RED);
			retuString += lblbaseSalary.getToolTipText() + "\n";
		}

		if (retuString.equals("")) {
			he = new BasePlusCommissionEmployee(strFirstName, strLastName, strID, dgrossSales, dcommissionRate,
					dbasesalary);
		} else {
			JOptionPane.showMessageDialog(null, retuString, "Input Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return he;
	}

}
