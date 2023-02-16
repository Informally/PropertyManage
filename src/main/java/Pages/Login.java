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

public class Login {

	public JFrame loginPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginPage = new JFrame();
		loginPage.setTitle("Login");
		loginPage.setBounds(100, 100, 871, 700);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Property Management System (PMS) Login");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 27));
		lblNewLabel.setBounds(34, 11, 665, 81);
		loginPage.getContentPane().add(lblNewLabel);
                
                JLabel lblNewLabel1 = new JLabel("(Building Manager, Account/Admin/Building Executive, Vendor)");
		lblNewLabel1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblNewLabel1.setBounds(34, 50, 665, 81);
		loginPage.getContentPane().add(lblNewLabel1);

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(204, 133, 315, 42);
		loginPage.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(304, 133, 250, 42);
		loginPage.getContentPane().add(txtEmail);

		// Password
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPassword.setBounds(204, 183, 315, 42);
		loginPage.getContentPane().add(lblPassword);

		JTextField txtPassword = new JTextField();
		txtPassword.setBounds(304, 183, 250, 42);
		loginPage.getContentPane().add(txtPassword);
                
                        
                //Resident/tenant login button
                JLabel lblResTen = new JLabel("Resident/Tenant Login: ");
		lblResTen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblResTen.setBounds(475, 350, 315, 42);
		loginPage.getContentPane().add(lblResTen);
                
		JButton resBtn = new JButton("Resident/Tenant Login");
		resBtn.setBounds(450, 400, 250, 42);
		resBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		resBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResTenLogin rtl = new ResTenLogin();
				rtl.restenlog.setVisible(true);
				loginPage.setVisible(false);
                                //change page function to verification login page

			}
		});
		loginPage.getContentPane().add(resBtn);
                
                //Security Guard Login Button
                JLabel lblSec = new JLabel("Security Guard Login: ");
		lblSec.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblSec.setBounds(200, 350, 315, 42);
		loginPage.getContentPane().add(lblSec);
                
		JButton secBtn = new JButton("Security Guard Login");
		secBtn.setBounds(175, 400, 250, 42);
		secBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		secBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecLogin sl = new SecLogin();
				sl.seclog.setVisible(true);
				loginPage.setVisible(false);
                                //change pages to verification page

			}
		});
		loginPage.getContentPane().add(secBtn);
                
                //Visitor  Button
                JLabel lblVisitor = new JLabel("If you are a visitor, click here to view your visitor pass");
		lblVisitor.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblVisitor.setBounds(200, 450, 450, 42);
		loginPage.getContentPane().add(lblVisitor);
                
		JButton visitorBtn = new JButton("View Visitor Pass");
		visitorBtn.setBounds(175, 500, 250, 42);
		visitorBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		visitorBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisitorViewPass viewpass = new VisitorViewPass();
				viewpass.vvp.setVisible(true);
				loginPage.setVisible(false);
                                //change pages to verification page

			}
		});
		loginPage.getContentPane().add(visitorBtn);
                
                //Parkhill Info  Button
                
		JButton infoBtn = new JButton("View Parkhill Residence Information");
		infoBtn.setBounds(175, 570, 350, 42);
		infoBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		infoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parkhillinfo pi = new parkhillinfo();
				pi.info.setVisible(true);
				loginPage.setVisible(false);
                                //change pages to verification page

			}
		});
		loginPage.getContentPane().add(infoBtn);
                
		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(334, 293, 150, 42);
		errorText.setVisible(false);
		loginPage.getContentPane().add(errorText);

		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(304, 253, 250, 42);
		loginBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CRUD crud = new CRUD();
				HashMap<Integer, String> data = crud.read("User.txt", txtEmail.getText().trim(), 2, txtPassword.getText().trim(), 3);

				if (data.size() == 0) {
					errorText.setText("Login Fail");
					errorText.setVisible(true);
					return;
				}
				
				String role = data.get(5);
				if(role.equals("Building Manager"))
				{
					BuildingManagerMenu bmm = new BuildingManagerMenu();

					bmm.bmm.setVisible(true);
					loginPage.setVisible(false);

				} else if(role.equals("Account Executive"))
				{
					AccountExecMenu aem = new AccountExecMenu();

					aem.aem.setVisible(true);
					loginPage.setVisible(false);

				}else if(role.equals("Admin Executive"))
				{
					AdminExecMenu Aem = new AdminExecMenu();

					Aem.Aem.setVisible(true);
					loginPage.setVisible(false);

				} else if(role.equals("Building Executive"))
				{
					BuildingExecMenu Bem = new BuildingExecMenu();

					Bem.buildExec.setVisible(true);
					loginPage.setVisible(false);

				}else if(role.equals("Vendor"))
				{
					VendorMenu vm = new VendorMenu();

					vm.vm.setVisible(true);
					loginPage.setVisible(false);

				}
                               
			}
		});
		loginPage.getContentPane().add(loginBtn);

	}

}
