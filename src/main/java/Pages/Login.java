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
		loginPage.setBounds(100, 100, 871, 622);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginPage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		loginPage.getContentPane().add(lblNewLabel);

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

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(334, 293, 150, 42);
		errorText.setVisible(false);
		loginPage.getContentPane().add(errorText);

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
