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

public class BuildingExecMenu extends PageUtils{

	public JFrame buildExec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildingExecMenu window = new BuildingExecMenu(null);
					window.buildExec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuildingExecMenu(String buildingName) {
		initialize(buildingName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String buildingName) {
		buildExec = new JFrame();
		buildExec.setTitle("Building Executive Menu");
		buildExec.setBounds(100, 100, 450, 500);
		buildExec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set as non resizable
		buildExec.setResizable(false);
		buildExec.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Building Executive Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 11, 665, 81);
		buildExec.getContentPane().add(lblNewLabel);
		
		// Assign JOb / Tasks to Employee
		JButton asgnJobBtn = new JButton("Assign Job/Task");
		asgnJobBtn.setBounds(44, 93, 315, 42);
		asgnJobBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		asgnJobBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AssignJob asgnMGT = new AssignJob(buildingName);
                                setOriginalFrame(buildExec);
				setTargetedFrame(asgnMGT.AsgnJobPage);
				navigatePage();
			}
		});
		buildExec.getContentPane().add(asgnJobBtn);

		// View/Search/Update/Delete Job
		JButton jobBtn = new JButton("View/Search/Update/Delete Job");
		jobBtn.setBounds(44, 153, 315, 42);
		jobBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		jobBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AssignJob asgnMGT = new AssignJob(buildingName);
                                setOriginalFrame(buildExec);
				setTargetedFrame(asgnMGT.AsgnJobPage);
				navigatePage();
			}
		});
		buildExec.getContentPane().add(jobBtn);

		// View & Update complaints status
		JButton viewupcom = new JButton("View & Update complaints status");
		viewupcom.setBounds(44, 213, 315, 42);
		viewupcom.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		viewupcom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				BExecComplaints viewupcom = new BExecComplaints(buildingName);
                                setOriginalFrame(buildExec);
				setTargetedFrame(viewupcom.bec);
				navigatePage();

			}
		});
		buildExec.getContentPane().add(viewupcom);
		
		// Setup/View/Modify/Delete Patrolling Schedule & Checkpoints
		JButton patrolBtn = new JButton("Patrolling Schedule & Checkpoints");
		patrolBtn.setBounds(44, 273, 315, 42);
		patrolBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		patrolBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Security sec = new Security(buildingName);
                                setOriginalFrame(buildExec);
				setTargetedFrame(sec.SecPage);
				navigatePage();
				

			}
		});
		buildExec.getContentPane().add(patrolBtn);
                
                // View Reports (Patrolling, Complaints, Job)
		JButton viewReportBtn = new JButton("View Reports (Patrolling, Complaints, Job)");
		viewReportBtn.setBounds(44, 333, 315, 42);
		viewReportBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		viewReportBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewPCJReport viewRep = new ViewPCJReport(buildingName);
                                setOriginalFrame(buildExec);
				setTargetedFrame(viewRep.Report);
				navigatePage();

			}
		});
		buildExec.getContentPane().add(viewReportBtn);
		
		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 393, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
				setOriginalFrame(buildExec);
				setTargetedFrame(loginpage.loginPage);
				navigatePage();

			}
		});
		buildExec.getContentPane().add(logOutBtn);

	}

}
