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

public class ResTenLogin extends PageUtils{

	public JFrame restenlog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResTenLogin window = new ResTenLogin();
					window.restenlog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResTenLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		restenlog = new JFrame();
		restenlog.setTitle("Resident/Tenant Login");
		restenlog.setBounds(100, 100, 871, 622);
		restenlog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		restenlog.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Resident/Tenant Login");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 27));
		lblNewLabel.setBounds(34, 11, 665, 81);
		restenlog.getContentPane().add(lblNewLabel);
                

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(204, 133, 315, 42);
		restenlog.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(304, 133, 250, 42);
		restenlog.getContentPane().add(txtEmail);

		// Password
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPassword.setBounds(204, 183, 315, 42);
		restenlog.getContentPane().add(lblPassword);

		JTextField txtPassword = new JTextField();
		txtPassword.setBounds(304, 183, 250, 42);
		restenlog.getContentPane().add(txtPassword);
                
                
                //back Button
                
		JButton back = new JButton("Go Back");
		back.setBounds(404, 253, 250, 42);
		back.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login lp = new Login();
				setOriginalFrame(restenlog);
				setTargetedFrame(lp.loginPage);
				navigatePage();
                                

			}
		});
		restenlog.getContentPane().add(back);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(334, 293, 150, 42);
		errorText.setVisible(false);
		restenlog.getContentPane().add(errorText);

		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(224, 253, 150, 42);
		loginBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CRUD crud = new CRUD();
				HashMap<Integer, String> data = crud.read("ResTen.txt", txtEmail.getText().trim(), 2, txtPassword.getText().trim(), 3);

				if (data.size() == 0) {
					errorText.setText("Login Fail");
					errorText.setVisible(true);
					return;
				}
				
				String role = data.get(6);
				if(role.equals("Resident"))
				{
					ResidentMenu rm = new ResidentMenu();

					rm.rm.setVisible(true);
					restenlog.setVisible(false);

				}else if(role.equals("Tenant"))
				{
					ResidentMenu rm = new ResidentMenu();

					rm.rm.setVisible(true);
					restenlog.setVisible(false);

				}
                               
			}
		});
		restenlog.getContentPane().add(loginBtn);

	}

}
