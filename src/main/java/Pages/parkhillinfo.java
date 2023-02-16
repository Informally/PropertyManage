package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Handlers.CRUD;
import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.ImageIcon;

public class parkhillinfo {

	public JFrame info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parkhillinfo window = new parkhillinfo();
					window.info.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public parkhillinfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		info = new JFrame();
		info.setTitle("Parkhill Residences Info");
		info.setBounds(100, 100, 1400, 580);
		info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		info.getContentPane().setLayout(null);
                
                ImageIcon imageIcon = new ImageIcon("parkhill.jpg");
                JLabel parkhillimage = new JLabel(imageIcon);
                parkhillimage.setBounds(0, 0, 800, 546);
                info.getContentPane().add(parkhillimage);
                
        }
}
                
                
                

		
                               
	


