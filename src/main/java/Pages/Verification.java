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

public class Verification {

	public JFrame verify;
        private JTextField txtEmail;
        private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verification window = new Verification();
					window.verify.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Verification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		verify = new JFrame();
		verify.setTitle("Verification");
		verify.setBounds(100, 100, 700, 400);
		verify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		verify.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Verify Your Account");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 27));
		lblNewLabel.setBounds(34, 11, 665, 81);
		verify.getContentPane().add(lblNewLabel);
                
                JLabel lblNewLabel1 = new JLabel("Please enter your name and password to verify");
		lblNewLabel1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblNewLabel1.setBounds(34, 50, 665, 81);
		verify.getContentPane().add(lblNewLabel1);

		// Name
		JLabel lblEmail = new JLabel("Name: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(204, 133, 315, 42);
		verify.getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(304, 133, 250, 42);
		verify.getContentPane().add(txtEmail);

		// Password
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPassword.setBounds(204, 183, 315, 42);
		verify.getContentPane().add(lblPassword);

		txtPassword = new JTextField();
		txtPassword.setBounds(304, 183, 250, 42);
		verify.getContentPane().add(txtPassword);
                

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(334, 293, 150, 42);
		errorText.setVisible(false);
		verify.getContentPane().add(errorText);

		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(304, 253, 150, 42);
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
					verify.setVisible(false);

				} else if(role.equals("Account Executive"))
				{
					AccountExecMenu aem = new AccountExecMenu();

					aem.aem.setVisible(true);
					verify.setVisible(false);

				}
                               
			}
		});
		verify.getContentPane().add(loginBtn);

	}

}
