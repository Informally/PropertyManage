/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Alan
 */
public class SecurityGuardMenu {

	public JFrame sg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecurityGuardMenu window = new SecurityGuardMenu();
					window.sg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecurityGuardMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		sg = new JFrame();
		sg.setTitle("Security Guard Menu");
		sg.setBounds(100, 100, 871, 622);
		sg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sg.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Security Guard Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		sg.getContentPane().add(lblNewLabel);

		// Visitor Pass Button
		JButton visitorPassBtn = new JButton("Visitor Pass");
		visitorPassBtn.setBounds(44, 93, 315, 42);
		visitorPassBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		visitorPassBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecVisitorPass visitorPass = new SecVisitorPass();
				visitorPass.vp.setVisible(true);
				sg.setVisible(false);
			}
		});
		sg.getContentPane().add(visitorPassBtn);

		// Visitor Entry Button
		JButton visitorEntryBtn = new JButton("Visitor Entry");
		visitorEntryBtn.setBounds(44, 153, 315, 42);
		visitorEntryBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		visitorEntryBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecVisitorEntry visitorEntry = new SecVisitorEntry();
				visitorEntry.ve.setVisible(true);
				sg.setVisible(false);

			}
		});
		sg.getContentPane().add(visitorEntryBtn);

		// Checkpoint Check-in Button
		JButton checkpointBtn = new JButton("Checkpoint Check-in");
		checkpointBtn.setBounds(44, 213, 315, 42);
		checkpointBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		checkpointBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SecCheckpoint checkpoint = new SecCheckpoint();
				checkpoint.c.setVisible(true);
				sg.setVisible(false);

			}
		});
		sg.getContentPane().add(checkpointBtn);
		
		// Incident Button
		JButton incidentBtn = new JButton("Incident");
		incidentBtn.setBounds(44, 273, 315, 42);
		incidentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		incidentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SecIncident incident = new SecIncident();
				incident.inc.setVisible(true);
				sg.setVisible(false);

			}
		});
		sg.getContentPane().add(incidentBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 333, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
				loginpage.loginPage.setVisible(true);
				sg.setVisible(false);

			}
		});
		sg.getContentPane().add(logOutBtn);



	}

}
