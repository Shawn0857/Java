package ObjectClass.ch8;

import javax.swing.JLabel;

public class MyJLabel extends JLabel {
	String hiddenText;
	public MyJLabel(String s) {
		super(s); //丟給繼承的那個(JLabel)
	}
}
