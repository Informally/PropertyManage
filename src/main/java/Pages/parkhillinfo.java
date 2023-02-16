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
                
                JLabel lblTitle = new JLabel("Parkhill Residences - Bukit Jalil");
		lblTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblTitle.setBounds(900, 80, 400, 42);
		info.getContentPane().add(lblTitle);
                
                JLabel lblEmail = new JLabel("Number of Floors: 68");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(900, 130, 315, 42);
		info.getContentPane().add(lblEmail);
                
                JLabel lblUnits = new JLabel("Number of Units: 1668");
		lblUnits.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUnits.setBounds(900, 180, 315, 42);
		info.getContentPane().add(lblUnits);
                
                JLabel lblFac= new JLabel("Facilities: ");
		lblFac.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblFac.setBounds(900, 230, 315, 42);
		info.getContentPane().add(lblFac);
                
                JTextArea lblFacc = new JTextArea("Swimming Pool, Gym, Multipurpose Hall, Covered Parking, Club House, Playground, 24-hour Security");
		lblFacc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblFacc.setBounds(900, 280, 315, 42);
                lblFacc.setLineWrap(true);
                lblFacc.setWrapStyleWord(true);
                lblFacc.setEditable(false);
		info.getContentPane().add(lblFacc);
                
                JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblLocation.setBounds(900, 330, 315, 42);
		info.getContentPane().add(lblLocation);
                
                JTextArea lblAdd = new JTextArea("Jln Jalil Perkasa 19, Bukit Jalil, 57000 Kuala Lumpur");
		lblAdd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblAdd.setBounds(900, 380, 315, 42);
                lblAdd.setLineWrap(true);
                lblAdd.setWrapStyleWord(true);
                lblAdd.setEditable(false);
		info.getContentPane().add(lblAdd);
                
        }
}
                
                
                

		
                               
	


