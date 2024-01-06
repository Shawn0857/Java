package ObjectClass.Frame_2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ObjectClass.Enum.FrameStatic;
import ObjectClass.ch9_10.HourlyEmployee;
import ObjectClass3.Data.ReadSequentialFile;
import ObjectClass3.Data.WriteSequentialFile;
import piechart3d.PieChart3DDemo2;

public class HourlyEmployeeFrame extends EmployeeFrame {

	private JLabel lblWage;
	private JLabel lblHours;
	private JTextField tfWage;
	private JTextField tfHours;

	ArrayList<HourlyEmployee> rd = new ArrayList<>();
	String[] strTitle = { "姓氏", "名字", "ID", "月薪", "時數" };
	String filename = "HourlyEmployeeFrame.data";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HourlyEmployeeFrame frame = new HourlyEmployeeFrame();
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
			tfWage.setText("");
			tfHours.setText("");
			tfWage.setEditable(false);
			tfHours.setEditable(false);
			break;
		case btnNew:
			tfWage.setText("");
			tfHours.setText("");
			tfWage.setEditable(true);
			tfHours.setEditable(true);
			break;
		case withData:
			tfWage.setEditable(false);
			tfHours.setEditable(false);
			break;
		case btnUpdate:
			tfWage.setEditable(true);
			tfHours.setEditable(true);
			tfWage.requestFocus();
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
			tfWage.setText(String.valueOf(rd.get(i).getWage()));
			tfHours.setText(String.valueOf(rd.get(i).getHours()));
			lblContent.setText((i + 1) + "/" + rd.size());
		}
	}

	/**
	 * Create the frame.
	 */
	public HourlyEmployeeFrame() {
		super();
		setTitle("A109222010_HourlyEmployee");

		btnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HourlyEmployee e1 = fnValidate(tfFirstName.getText(), tfLastName.getText(), tfID.getText(),
						tfWage.getText(), tfHours.getText());
				if (e1 != null) {
					if (!btnAddUpdate) {// false 表示 add, true 表示 update
						rd.add(e1);
						JOptionPane.showMessageDialog(null, "add Success", "", JOptionPane.INFORMATION_MESSAGE);
						showData(rd.size() - 1);
					} else {
						rd.get(iPosition).setWage(e1.getWage());
						rd.get(iPosition).setHours(e1.getHours());
						JOptionPane.showMessageDialog(null, "Update Success", "", JOptionPane.INFORMATION_MESSAGE);
						showData(iPosition);
					}
					String[][] strvalue = new String[rd.size()][5];
					for (int i = 0; i < rd.size(); i++) {
						strvalue[i][0] = rd.get(i).getLastName();
						strvalue[i][1] = rd.get(i).getFirstName();
						strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
						strvalue[i][3] = String.valueOf(rd.get(i).getWage());
						strvalue[i][4] = String.valueOf(rd.get(i).getHours());
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
				if (rd.size() > 0) {
					if (iPosition >= rd.size())
						iPosition = rd.size() - 1;
					showData(iPosition);
					String[][] strvalue = new String[rd.size()][5];
					for (int i = 0; i < rd.size(); i++) {
						strvalue[i][0] = rd.get(i).getLastName();
						strvalue[i][1] = rd.get(i).getFirstName();
						strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
						strvalue[i][3] = String.valueOf(rd.get(i).getWage());
						strvalue[i][4] = String.valueOf(rd.get(i).getHours());
					}
					model.setDataVector(strvalue, strTitle);
					changeUI(FrameStatic.withData);
				} else {
					model.setDataVector(null, strTitle);
					changeUI(FrameStatic.init);
				}
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteSequentialFile<HourlyEmployee> wf = new WriteSequentialFile<HourlyEmployee>(filename);
				wf.fnWSF(rd);
			}
		});

		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadSequentialFile<HourlyEmployee> rf = new ReadSequentialFile<HourlyEmployee>(filename);

				try {
					rd = rf.getRSF();
					if (rd.size() == 0) {
						changeUI(FrameStatic.init);
					} else {
						changeUI(FrameStatic.withData);
						String[][] strvalue = new String[rd.size()][5];
						for (int i = 0; i < rd.size(); i++) {
							strvalue[i][0] = rd.get(i).getLastName();
							strvalue[i][1] = rd.get(i).getFirstName();
							strvalue[i][2] = rd.get(i).getSocialSecurityNumber();
							strvalue[i][3] = String.valueOf(rd.get(i).getWage());
							strvalue[i][4] = String.valueOf(rd.get(i).getHours());
						}
						model.setDataVector(strvalue, strTitle);
						showData(0);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		btnPieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String [] sName = {"aa" , "bb"};
		    	double [] dMoney = {100 , 500};*/
				String [] sName = new String[rd.size()];
		    	double [] dMoney = new double[rd.size()];
		    	for(int i = 0; i < rd.size(); i++) {
		    		sName[i] = rd.get(i).getLastName() + rd.get(i).getFirstName();
		    		dMoney[i] = rd.get(i).earnings();
		    	}
		    	PieChart3DDemo2 pie= new PieChart3DDemo2("HourlyEmployee",sName,dMoney);
		    	panelPieChart.removeAll();
		    	panelPieChart.add(pie);
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

		lblWage = new JLabel("時薪");
		lblWage.setToolTipText("時薪請輸入大於160的數字");
		lblWage.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblWage.setBounds(31, 182, 107, 45);
		panelData.add(lblWage);

		lblHours = new JLabel("時數");
		lblHours.setToolTipText("時數請輸入大於0的數字");
		lblHours.setFont(new Font("標楷體", Font.PLAIN, 20));
		lblHours.setBounds(31, 232, 107, 45);
		panelData.add(lblHours);

		tfWage = new JTextField();
		tfWage.setBounds(172, 192, 141, 21);
		panelData.add(tfWage);
		tfWage.setColumns(10);

		tfHours = new JTextField();
		tfHours.setBounds(172, 242, 141, 21);
		panelData.add(tfHours);
		tfHours.setColumns(10);
	}

	private HourlyEmployee fnValidate(String strFirstName, String strLastName, String strID, String strWage,
			String strHours) {
		HourlyEmployee he = null;
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

		Double dWage = 0.0;
		try {
			dWage = Double.parseDouble(strWage);
			if (dWage < 160) {
				lblWage.setForeground(Color.RED);
				retuString += lblWage.getToolTipText() + "\n";
			} else {
				lblWage.setForeground(Color.BLACK);
			}
		} catch (Exception e) {
			lblWage.setForeground(Color.RED);
			retuString += lblWage.getToolTipText() + "\n";
		}

		Double dHours = 0.0;
		try {
			dHours = Double.parseDouble(strHours);
			if (dHours < 0) {
				lblHours.setForeground(Color.RED);
				retuString += lblHours.getToolTipText() + "\n";
			} else {
				lblHours.setForeground(Color.BLACK);
			}
		} catch (Exception e) {
			lblHours.setForeground(Color.RED);
			retuString += lblHours.getToolTipText() + "\n";
		}

		if (retuString.equals("")) {
			he = new HourlyEmployee(strFirstName, strLastName, strID, dWage, dHours);
		} else {
			JOptionPane.showMessageDialog(null, retuString, "Input Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return he;
	}
}