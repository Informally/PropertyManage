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

public class BuildingManagerMenu extends PageUtils {

	public JFrame bmm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildingManagerMenu window = new BuildingManagerMenu();
					window.bmm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuildingManagerMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bmm = new JFrame();
		bmm.setTitle("Building Manager Menu");
		bmm.setBounds(100, 100, 871, 622);
		bmm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set as non resizable
		bmm.setResizable(false);
		bmm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Building Manager Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		bmm.getContentPane().add(lblNewLabel);
		
		// User Management Button
		JButton userManagementBtn = new JButton("User Management");
		userManagementBtn.setBounds(44, 93, 315, 42);
		userManagementBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		userManagementBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserManagement userMgt = new UserManagement();
				setOriginalFrame(bmm);
				setTargetedFrame(userMgt.userMgtPage);
				navigatePage();
			}
		});
		bmm.getContentPane().add(userManagementBtn);

		// Generate Report Button
		JButton genReportBtn = new JButton("Generate Report");
		genReportBtn.setBounds(44, 153, 315, 42);
		genReportBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		genReportBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GenReport genReport = new GenReport();
				setOriginalFrame(bmm);
				setTargetedFrame(genReport.genReport);
				navigatePage();

			}
		});
		bmm.getContentPane().add(genReportBtn);

		// Operation and budget planning Button
		JButton optBgtBtn = new JButton("Operations and budget planning");
		optBgtBtn.setBounds(44, 213, 315, 42);
		optBgtBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		optBgtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				OperationBudgetPlanning optBgtPlan = new OperationBudgetPlanning();
				setOriginalFrame(bmm);
				setTargetedFrame(optBgtPlan.optBgtPlan);
				navigatePage();

			}
		});
		bmm.getContentPane().add(optBgtBtn);
		
		// Team Structure Management Button
		JButton teamStructMgtBtn = new JButton("Team Structure Management");
		teamStructMgtBtn.setBounds(44, 273, 315, 42);
		teamStructMgtBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		teamStructMgtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TeamStructMgt teamStruct = new TeamStructMgt();
				setOriginalFrame(bmm);
				setTargetedFrame(teamStruct.teamStructMgt);
				navigatePage();

			}
		});
		bmm.getContentPane().add(teamStructMgtBtn);
		
		
		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 333, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
				setOriginalFrame(bmm);
				setTargetedFrame(loginpage.loginPage);
				navigatePage();

			}
		});
		bmm.getContentPane().add(logOutBtn);

	}

}
