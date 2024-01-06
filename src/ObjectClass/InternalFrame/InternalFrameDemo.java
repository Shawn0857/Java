package ObjectClass.InternalFrame;
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import javax.swing.JInternalFrame;
import javax.print.attribute.standard.PrinterInfo;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import java.awt.event.*;
import java.beans.PropertyVetoException;
import java.awt.*;

/*
 * InternalFrameDemo.java requires:
 *   MyInternalFrame.java
 */
public class InternalFrameDemo extends JFrame
                               implements ActionListener {
    JDesktopPane desktop;

    public InternalFrameDemo() {
        super("A109222010 林廷瑋");

        //Make the big window be indented 50 pixels from each edge
        //of the screen.
        int inset = 90;
        //int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);

        //Set up the GUI.
        desktop = new JDesktopPane(); //a specialized layered pane
        setContentPane(desktop);
        setJMenuBar(createMenuBar());

        //Make dragging a little faster but perhaps uglier.
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //Set up the lone menu.
        JMenu menu = new JMenu("Employee");
        menu.setMnemonic(KeyEvent.VK_D); //鍵盤ALT + D
        menuBar.add(menu);
        
        
        /*menu = new JMenu("Employee");
        menuBar.add(menu);
        menu = new JMenu("Employee");
        menuBar.add(menu);
        menu = new JMenu("Employee");
        menuBar.add(menu);
        menu = new JMenu("Employee");
        menuBar.add(menu);*/
        
        
        //Set up the first menu item.
        JMenuItem menuItem = new JMenuItem("Hourly Employee");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_H, ActionEvent.ALT_MASK));
        menuItem.setActionCommand(HourlyEmployeeInternalFrame.strFrameTitle);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Salary Employee");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menuItem.setActionCommand(SalaryEmployeeInternalFrame.strFrameTitle);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Commission Employee");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.ALT_MASK));
        menuItem.setActionCommand(CommissionEmployeeInternalFrame.strFrameTitle);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem("BasePlusCommission Employee");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_B, ActionEvent.ALT_MASK));
        menuItem.setActionCommand(BasePlusCommissionEmployeeInternalFrame.strFrameTitle);
        menuItem.addActionListener(this);
        menu.add(menuItem);

        
        //Set up the second menu item.
        menuItem = new JMenuItem("Quit");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        menuItem.setActionCommand("quit");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return menuBar;
    }

    //React to menu selections.
    public void actionPerformed(ActionEvent e) {
    	if (HourlyEmployeeInternalFrame.strFrameTitle.equals(e.getActionCommand())) {
    	createFrame(HourlyEmployeeInternalFrame.strFrameTitle);
    	}else if(SalaryEmployeeInternalFrame.strFrameTitle.equals(e.getActionCommand())) {
        	createFrame(SalaryEmployeeInternalFrame.strFrameTitle);
        }else if(CommissionEmployeeInternalFrame.strFrameTitle.equals(e.getActionCommand())) {
        	createFrame(CommissionEmployeeInternalFrame.strFrameTitle);
        }else if(BasePlusCommissionEmployeeInternalFrame.strFrameTitle.equals(e.getActionCommand())) {
        	createFrame(BasePlusCommissionEmployeeInternalFrame.strFrameTitle);
        }else {
        	quit();
        }
    }

    //Create a new internal frame.
    protected void createFrame(String s) {
    	for(JInternalFrame jInternalFrame : desktop.getAllFrames()) {
    		//System.out.println(jInternalFrame.getTitle() + ", " + jInternalFrame.isSelected());
    		if(s.equals(jInternalFrame.getTitle())) {
    			try {
    				jInternalFrame.setSelected(true);
    			}catch (PropertyVetoException e) {
					e.printStackTrace();
				}
    			return;
    		}
    	}

    	EmployeeInternalFrame frame;
    	if(s.equals(HourlyEmployeeInternalFrame.strFrameTitle)) {
    		frame = new HourlyEmployeeInternalFrame();
    	}else if(s.equals(SalaryEmployeeInternalFrame.strFrameTitle)){
    		frame = new SalaryEmployeeInternalFrame();
		}else if(s.equals(CommissionEmployeeInternalFrame.strFrameTitle)){
    		frame = new CommissionEmployeeInternalFrame();
		}else {
    		frame = new BasePlusCommissionEmployeeInternalFrame();
		}
    	//HourlyEmployeeInternalFrame frame = new HourlyEmployeeInternalFrame();
    	/*switch (s) {
		case "Hourly Employee":
			frame = new HourlyEmployeeInternalFrame();
			break;
		case "Salary Employee":
			frame = new SalaryEmployeeInternalFrame();
			break;
		case "Commission Employee":
			frame = new CommissionEmployeeInternalFrame();
			break;
		case "BasePlusCommission Employee":
			frame = new BasePlusCommissionEmployeeInternalFrame();
			break;
		default:
			frame = new HourlyEmployeeInternalFrame();
		}*/
		
        frame.setVisible(true); //necessary as of 1.3
        frame.init();
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
    }

    //Quit the application.
    protected void quit() {
        System.exit(0);  //關掉程式
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        InternalFrameDemo frame = new InternalFrameDemo();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
