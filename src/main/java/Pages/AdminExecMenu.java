package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class AdminExecMenu extends PageUtils{

	public JFrame Aem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminExecMenu window = new AdminExecMenu(null);
					window.Aem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminExecMenu(String adminName) {
		initialize(adminName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String adminName) {
		Aem = new JFrame();
		Aem.setTitle("Admin Executive Menu");
		Aem.setBounds(100, 100, 871, 622);
		Aem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Aem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Executive Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		Aem.getContentPane().add(lblNewLabel);
		
		// Unit Management Button
		JButton unitManagementBtn = new JButton("Unit Management");
		unitManagementBtn.setBounds(44, 93, 315, 42);
		unitManagementBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		unitManagementBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UnitManagement unitMgt = new UnitManagement(adminName);
                                setOriginalFrame(Aem);
				setTargetedFrame(unitMgt.unitMgtPage);
				navigatePage();
			}
		});
		Aem.getContentPane().add(unitManagementBtn);

		// Resident/Tenant Button
		JButton resTenBtn = new JButton("Resident/Tenant Management");
		resTenBtn.setBounds(44, 153, 315, 42);
		resTenBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		resTenBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResTenMgt restenmgt = new ResTenMgt(adminName);
                                setOriginalFrame(Aem);
				setTargetedFrame(restenmgt.ResTenMgtPage);
				navigatePage();

			}
		});
		Aem.getContentPane().add(resTenBtn);

		// Complaint Management Button
		JButton comBtn = new JButton("Complaint Management");
		comBtn.setBounds(44, 213, 315, 42);
		comBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		comBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				AdminExComplain AdCom = new AdminExComplain(adminName);
                                setOriginalFrame(Aem);
				setTargetedFrame(AdCom.aec);
				navigatePage();

			}
		});
		Aem.getContentPane().add(comBtn);
		
		// Employee Management Button
		JButton teamStructMgtBtn = new JButton("Employee Management");
		teamStructMgtBtn.setBounds(44, 273, 315, 42);
		teamStructMgtBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		teamStructMgtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeeMgt emMgt = new EmployeeMgt(adminName);
                                setOriginalFrame(Aem);
				setTargetedFrame(emMgt.EmMgtPage);
				navigatePage();

			}
		});
		Aem.getContentPane().add(teamStructMgtBtn);
                
                // Facility Management Button
		JButton facMgtBtn = new JButton("Facility Management");
		facMgtBtn.setBounds(44, 333, 315, 42);
		facMgtBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		facMgtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FacilityMgt facMgt = new FacilityMgt(adminName);
                                setOriginalFrame(Aem);
				setTargetedFrame(facMgt.FacMgtPage);
				navigatePage();

			}
		});
		Aem.getContentPane().add(facMgtBtn);
                
                // Facility Booking Management Button
		JButton facBookMgtBtn = new JButton("Facility Booking Management");
		facBookMgtBtn.setBounds(44, 393, 315, 42);
		facBookMgtBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		facBookMgtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminFacBooking adfacbook = new AdminFacBooking(adminName);
                                setOriginalFrame(Aem);
				setTargetedFrame(adfacbook.afb);
				navigatePage();
			}
		});
		Aem.getContentPane().add(facBookMgtBtn);
		
		
		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 453, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                                
                                Login loginpage = new Login();
                                setOriginalFrame(Aem);
				setTargetedFrame(loginpage.loginPage);
				navigatePage();
				

			}
		});
		Aem.getContentPane().add(logOutBtn);

	}

}
