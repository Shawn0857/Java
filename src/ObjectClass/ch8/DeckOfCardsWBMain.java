package ObjectClass.ch8;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeckOfCardsWBMain {

	private JFrame frame;
	DeckOfCards deckOfCards = new DeckOfCards();
	int iState = 0; // 0表示還沒選，1表示第一張已經選，2
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeckOfCardsWBMain window = new DeckOfCardsWBMain();
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
	public DeckOfCardsWBMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("抽一張比大小");
		frame.setBounds(100, 100, 871, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border blackline = BorderFactory.createLineBorder(Color.BLACK);
		frame.getContentPane().setLayout(null);
	//	deckOdCards.shuff
		
		JLabel lblSecond = new JLabel("");
		lblSecond.setBounds(249, 179, 46, 81);
		lblSecond.setBackground(Color.GREEN);
		lblSecond.setOpaque(true);
		frame.getContentPane().add(lblSecond);
		
		JLabel lblFirst = new JLabel("");
		lblFirst.setBounds(178, 179, 46, 81);
		
		lblFirst.setOpaque(true);
		lblFirst.setBackground(Color.GREEN);
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblFirst);
		
		JLabel lblWhoWin = new JLabel("Who Win");
		lblWhoWin.setBounds(344, 179, 262, 74);
		lblWhoWin.setFont(new Font("新細明體", Font.PLAIN, 20));
		frame.getContentPane().add(lblWhoWin);
		
		JLabel label = new JLabel("New label");
		label.setBounds(178, 198, 46, 15);
		frame.getContentPane().add(label);
		
		for(int i = 0; i < 52; i++) {
			MyJLabel lblCard = new MyJLabel("");
			lblCard.hiddenText = deckOfCards.getCard(i).toString();
			//lblCard.setText(deckOfCards.getCard(i).toString());
			//lblCard.setFont(new Font("Arial", Font.PLAIN, 36));
			lblCard.setOpaque(true);
			lblCard.setBackground(Color.GREEN);
			lblCard.setBounds(10+i*15, 50, 46, 81);
			lblCard.setHorizontalAlignment(SwingConstants.CENTER);
			lblCard.setBorder(blackline);
			frame.getContentPane().add(lblCard);
			lblCard.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					JLabel myLable = (JLabel)e.getSource();
					Rectangle r = myLable.getBounds();
					r.y = r.y - 20;
					myLable.setBounds(r);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					JLabel myLable = (JLabel)e.getSource();
					Rectangle r = myLable.getBounds();
					r.y = r.y + 20;
					myLable.setBounds(r);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					//e.getSource();//最原始的物件	
					MyJLabel myLable = (MyJLabel)e.getSource();
					if(iState == 0) {
						lblFirst.setText(myLable.hiddenText);
						iState = 1;
					}else if(iState == 1) {
						lblSecond.setText(myLable.hiddenText);
						iState = 2;
						//取得結果
						compareWhoWin();
					}
				}
				private void compareWhoWin() {
					String f1 = lblFirst.getText().substring(0, 1);
					String f2 = lblFirst.getText().substring(1);
					String s1 = lblSecond.getText().substring(0, 1);
					String s2 = lblSecond.getText().substring(1);
					//"♠">"♥">"♦">"♣"
					int fsuit = Integer.parseInt(f1.replace("♠","4").replace("♥","3").replace("♦","2").replace("♣","1"));
					int ssuit = Integer.parseInt(s1.replace("♠","4").replace("♥","3").replace("♦","2").replace("♣","1"));
					if(fsuit > ssuit) {
						lblWhoWin.setText("First One Win!");
					}else if(fsuit < ssuit) {
						lblWhoWin.setText("Second One Win!");
					}else {
						int fface = Integer.parseInt(f2.replace("J","11").replace("Q","12").replace("K","13").replace("A","14"));
						int sface = Integer.parseInt(s2.replace("J","11").replace("Q","12").replace("K","13").replace("A","14"));
						if(fface > sface) lblWhoWin.setText("Second One Win!");
					}
				}
			});
		}
		
		
	}
}
