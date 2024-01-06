package ObjectClass.Frame_2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ObjectClass.Enum.FrameStatic;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class EmployeeFrame extends JFrame {
	protected JButton btnPreData;
	protected JButton btnFirstData;
	protected Label lblContent;
	protected JButton btnNextData;
	protected JButton btnLastData;
	protected JTable tblData;
	protected JScrollPane scrollPane;
	protected JButton btnPieChart;
	protected JButton btnRead;
	protected JButton btnSave;
	protected JButton btnCancel;
	protected JButton btnUpdate;
	protected JButton btnDel;
	protected JButton btnSure;
	protected JButton btnAdd;
	protected JTextField tfID;
	protected JTextField tfFirstName;
	protected JTextField tfLastName;
	protected JLabel lblID;
	protected JLabel lblFirstName;
	protected JLabel lblLastName;
	protected JPanel panelData;	
	
	protected JPanel panelPieChart;
	
	protected JTabbedPane tabbedPane;
	protected JPanel contentPane;
	protected DefaultTableModel model = new DefaultTableModel();
	protected boolean btnAddUpdate = false; // false 表示 add, true 表示 update
	protected int iPosition = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					EmployeeFrame frame = new EmployeeFrame();
//					frame.setVisible(true);
//					frame.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void init() {
		changeUI(FrameStatic.init);
	}

	public void changeUI(FrameStatic fs) {
		switch (fs) {
		case init:
			fnBtnControl(true, false, false, false, false, false, true, false, false, false, false, false);
			tfFirstName.setText("");
			tfLastName.setText("");
			tfID.setText("");
			tfFirstName.setEditable(false);
			tfLastName.setEditable(false);
			tfID.setEditable(false);
			tfLastName.requestFocus();
			lblContent.setText("0/0");
			break;
		case btnNew:
			fnBtnControl(false, false, true, true, false, false, false,
					false, false, false, false, false);
			tfFirstName.setText("");
			tfLastName.setText("");
			tfID.setText("");
			tfFirstName.setEditable(true);
			tfLastName.setEditable(true);
			tfID.setEditable(true);
			tfLastName.requestFocus();
			break;
		case withData:
			fnBtnControl(true, true, false, false, true, true, true,
					true, true, true, true, true);
			tfFirstName.setEditable(false);
			tfLastName.setEditable(false);
			tfID.setEditable(false);
			break;
		case btnUpdate:
			fnBtnControl(false, false, true, true, false, false, false,
					false, false, false, false, false);
			tfFirstName.setEditable(false);
			tfLastName.setEditable(false);
			tfID.setEditable(false);
			break;
		}
	}

	public void fnBtnControl(boolean boolAdd, boolean boolUpdate, boolean boolSure, boolean boolCancel, boolean boolDel,
			boolean boolSave, boolean boolRead, boolean boolPieChart, boolean boolFirstData, boolean boolPreData,
			boolean boolNextData, boolean boolLastData) {
		btnAdd.setEnabled(boolAdd);
		btnUpdate.setEnabled(boolUpdate);
		btnSure.setEnabled(boolSure);
		btnCancel.setEnabled(boolCancel);
		btnDel.setEnabled(boolDel);
		btnSave.setEnabled(boolSave);
		btnRead.setEnabled(boolRead);
		btnPieChart.setEnabled(boolPieChart);
		btnFirstData.setEnabled(boolFirstData);
		btnPreData.setEnabled(boolPreData);
		btnNextData.setEnabled(boolNextData);
		btnLastData.setEnabled(boolLastData);
	}

	/**
	 * Create the frame.
	 */
	public EmployeeFrame() {
		setTitle("A109222010_Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 715, 687);
		contentPane.add(tabbedPane);

		panelData = new JPanel();
		panelData.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Data", null, panelData, null);
		panelData.setLayout(null);

		lblLastName = new JLabel("姓氏");
		lblLastName.setToolTipText("姓氏不可以是空白");
		lblLastName.setBounds(31, 17, 68, 45);
		lblLastName.setFont(new Font("標楷體", Font.PLAIN, 20));
		panelData.add(lblLastName);

		lblFirstName = new JLabel("名字");
		lblFirstName.setToolTipText("名字不可以是空白");
		lblFirstName.setBounds(31, 72, 68, 45);
		lblFirstName.setFont(new Font("標楷體", Font.PLAIN, 20));
		panelData.add(lblFirstName);

		lblID = new JLabel("身分證字號");
		lblID.setToolTipText("身分證字號不可以是空白");
		lblID.setBounds(31, 127, 107, 45);
		lblID.setFont(new Font("標楷體", Font.PLAIN, 20));
		panelData.add(lblID);

		tfLastName = new JTextField();
		tfLastName.setBounds(170, 30, 143, 21);
		panelData.add(tfLastName);
		tfLastName.setColumns(10);

		tfFirstName = new JTextField();
		tfFirstName.setBounds(172, 85, 141, 21);
		panelData.add(tfFirstName);
		tfFirstName.setColumns(10);

		tfID = new JTextField();
		tfID.setBounds(172, 140, 141, 21);
		panelData.add(tfID);
		tfID.setColumns(10);

		btnAdd = new JButton("新增");
		btnAdd.setBounds(373, 30, 132, 34);
		btnAdd.setFont(new Font("新細明體", Font.PLAIN, 20));
		panelData.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddUpdate = false; // false 表示 add, true 表示 update
				changeUI(FrameStatic.btnNew);
			}
		});

		btnSure = new JButton("確認");
		btnSure.setBounds(373, 92, 132, 34);
		btnSure.setFont(new Font("新細明體", Font.PLAIN, 20));
		panelData.add(btnSure);

		btnDel = new JButton("刪除");
		btnDel.setBounds(373, 147, 274, 34);
		btnDel.setFont(new Font("新細明體", Font.PLAIN, 20));
		panelData.add(btnDel);

		btnUpdate = new JButton("修改");
		btnUpdate.setBounds(515, 30, 132, 34);
		btnUpdate.setFont(new Font("新細明體", Font.PLAIN, 20));
		panelData.add(btnUpdate);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddUpdate = true; // false 表示 add, true 表示 update
				changeUI(FrameStatic.btnUpdate);
			}
		});

		btnCancel = new JButton("取消");
		btnCancel.setBounds(515, 91, 132, 34);
		btnCancel.setFont(new Font("新細明體", Font.PLAIN, 20));
		panelData.add(btnCancel);

		btnSave = new JButton("存檔");
		btnSave.setBounds(373, 202, 132, 34);
		btnSave.setFont(new Font("新細明體", Font.PLAIN, 20));
		panelData.add(btnSave);

		btnRead = new JButton("讀檔");
		btnRead.setBounds(515, 202, 132, 34);
		btnRead.setFont(new Font("新細明體", Font.PLAIN, 20));
		panelData.add(btnRead);

		btnPieChart = new JButton("PieChart");
		btnPieChart.setBounds(373, 250, 274, 34);
		btnPieChart.setFont(new Font("新細明體", Font.PLAIN, 20));
		panelData.add(btnPieChart);

		JTable tblData = new JTable();
		tblData.setBounds(31, 404, 641, 173);
		tblData.setModel(model);

		scrollPane = new JScrollPane(tblData);
		scrollPane.setBounds(31, 404, 641, 173);
		panelData.add(scrollPane);

		btnLastData = new JButton(">|");
		btnLastData.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnLastData.setBounds(483, 608, 83, 33);
		panelData.add(btnLastData);

		btnNextData = new JButton(">");
		btnNextData.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNextData.setBounds(392, 608, 83, 33);
		panelData.add(btnNextData);

		lblContent = new Label("0/0");
		lblContent.setAlignment(Label.CENTER);
		lblContent.setBounds(306, 608, 80, 33);
		panelData.add(lblContent);

		btnPreData = new JButton("<");
		btnPreData.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnPreData.setBounds(217, 608, 83, 33);
		panelData.add(btnPreData);

		btnFirstData = new JButton("|<");
		btnFirstData.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnFirstData.setBounds(124, 608, 83, 33);
		panelData.add(btnFirstData);

		panelPieChart = new JPanel();
		tabbedPane.addTab("PieChar", null, panelPieChart, null);
		//panelPieChart.setLayout(null);
	}
}
