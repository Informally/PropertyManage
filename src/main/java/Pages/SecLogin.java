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

public class SecLogin extends PageUtils{

	public JFrame seclog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecLogin window = new SecLogin();
					window.seclog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		seclog = new JFrame();
		seclog.setTitle("Security Guard Login");
		seclog.setBounds(100, 100, 450, 350);
		seclog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set as non resizable
		seclog.setResizable(false);
		seclog.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("    Security Guard Login");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 27));
		lblNewLabel.setBounds(34, 6, 665, 81);
		seclog.getContentPane().add(lblNewLabel);
                

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(34, 73, 315, 42);
		seclog.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(154, 73, 250, 42);
		//round the corner of the text field
		txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		seclog.getContentPane().add(txtEmail);

		// Password
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPassword.setBounds(34, 133, 315, 42);
		seclog.getContentPane().add(lblPassword);

		JTextField txtPassword = new JTextField();
		txtPassword.setBounds(154, 133, 250, 42);
		seclog.getContentPane().add(txtPassword);
                
                
                //back Button
                
		JButton back = new JButton("Go Back");
		back.setBounds(150, 243, 150, 42);
		back.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login lp = new Login();
                                setOriginalFrame(seclog);
				setTargetedFrame(lp.loginPage);
				navigatePage();

			}
		});
		seclog.getContentPane().add(back);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(334, 293, 150, 42);
		errorText.setVisible(false);
		seclog.getContentPane().add(errorText);

		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(150, 193, 150, 42);
		loginBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CRUD crud = new CRUD();
				HashMap<Integer, String> data = crud.read("Employee.txt", txtEmail.getText().trim(), 2, txtPassword.getText().trim(), 3);

				if (data.size() == 0) {
					errorText.setText("Login Fail");
					errorText.setVisible(true);
					return;
				}
				
				String role = data.get(6);
				if(role.equals("Security Guard"))
				{
					String secname = data.get(1);
					SecurityGuardMenu sgm = new SecurityGuardMenu(secname);
                                        setOriginalFrame(seclog);
                                        setTargetedFrame(sgm.sg);
                                        navigatePage();
				}
                               
			}
		});
		seclog.getContentPane().add(loginBtn);

	}

}
