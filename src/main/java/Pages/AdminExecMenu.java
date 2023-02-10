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

public class AdminExecMenu {

	public JFrame Aem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminExecMenu window = new AdminExecMenu();
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
	public AdminExecMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
				UnitManagement unitMgt = new UnitManagement();
				unitMgt.unitMgtPage.setVisible(true);
				Aem.setVisible(false);
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
				ResTenMgt restenmgt = new ResTenMgt();
				restenmgt.ResTenMgtPage.setVisible(true);
				Aem.setVisible(false);

			}
		});
		Aem.getContentPane().add(resTenBtn);

		// Complaint Management Button
		JButton optBgtBtn = new JButton("Complaint Management");
		optBgtBtn.setBounds(44, 213, 315, 42);
		optBgtBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		optBgtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				OperationBudgetPlanning optBgtPlan = new OperationBudgetPlanning();
				optBgtPlan.optBgtPlan.setVisible(true);
				Aem.setVisible(false);

			}
		});
		Aem.getContentPane().add(optBgtBtn);
		
		// Employee Management Button
		JButton teamStructMgtBtn = new JButton("Employee Management");
		teamStructMgtBtn.setBounds(44, 273, 315, 42);
		teamStructMgtBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		teamStructMgtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeeMgt emMgt = new EmployeeMgt();
				emMgt.EmMgtPage.setVisible(true);
				Aem.setVisible(false);

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
				FacilityMgt facMgt = new FacilityMgt();
				facMgt.FacMgtPage.setVisible(true);
				Aem.setVisible(false);

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
				TeamStructMgt teamStruct = new TeamStructMgt();
				teamStruct.teamStructMgt.setVisible(true);
				Aem.setVisible(false);

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
				loginpage.loginPage.setVisible(true);
				Aem.setVisible(false);

			}
		});
		Aem.getContentPane().add(logOutBtn);

	}

}