package ObjectClass.ch8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyLoan1 {

	private JFrame frame;
	private JTextField tfMoney;
	private JTextField tfRate;
	private JTextField tfMonths;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLoan1 window = new MyLoan1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyLoan1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8CB8\u6B3E\u91D1\u984D");
		lblNewLabel.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 22, 77, 41);
		frame.getContentPane().add(lblNewLabel);
		
		tfMoney = new JTextField();
		tfMoney.setText("1000000");
		tfMoney.setBounds(115, 21, 96, 43);
		frame.getContentPane().add(tfMoney);
		tfMoney.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8CB8\u6B3E\u5229\u7387");
		lblNewLabel_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(22, 93, 77, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfRate = new JTextField();
		tfRate.setText("0.014");
		tfRate.setColumns(10);
		tfRate.setBounds(115, 92, 96, 43);
		frame.getContentPane().add(tfRate);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u8CB8\u6B3E\u6708\u6578");
		lblNewLabel_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(237, 22, 77, 41);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tfMonths = new JTextField();
		tfMonths.setText("240");
		tfMonths.setColumns(10);
		tfMonths.setBounds(330, 21, 96, 43);
		frame.getContentPane().add(tfMonths);
		
		JButton btnCompute = new JButton("\u8A08\u7B97");
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double dMoney = Double.parseDouble(tfMoney.getText());
				double dMonths = Double.parseDouble(tfMonths.getText());
				double dRate = Double.parseDouble(tfRate.getText());
				double dMonthRate = dRate/12;
				//�C�����I�������B�������u�ٲv
				double dPayMonthRate = Math.pow((1+dMonthRate), dMonths)
						 * dMonthRate / (Math.pow((1+dMonthRate), dMonths) - 1);
				//�����C�����u�I�������B
				double dPayPerMonth = dMoney * dPayMonthRate;
				lblResult.setText("�C�����ٴڪ��B��:"+ String.format("%,.0f", dPayPerMonth));
				
			}
		});
		btnCompute.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		btnCompute.setBounds(237, 93, 189, 41);
		frame.getContentPane().add(btnCompute);
		
		lblResult = new JLabel("\u6BCF\u500B\u6708\u8981\u9084\u591A\u5C11\u9322");
		lblResult.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		lblResult.setBounds(22, 181, 189, 41);
		frame.getContentPane().add(lblResult);
	}
}
