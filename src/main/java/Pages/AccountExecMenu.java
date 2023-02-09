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

public class AccountExecMenu {

	public JFrame aem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountExecMenu window = new AccountExecMenu();
					window.aem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountExecMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		aem = new JFrame();
		aem.setTitle("Building Manager Menu");
		aem.setBounds(100, 100, 871, 622);
		aem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aem.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Account Executive Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		aem.getContentPane().add(lblNewLabel);

		// Invoice Button
		JButton invoiceBtn = new JButton("Invoice Receipt");
		invoiceBtn.setBounds(44, 93, 315, 42);
		invoiceBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		invoiceBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewInvoice viewInvoice = new ViewInvoice();
				viewInvoice.viewInvoice.setVisible(true);
				aem.setVisible(false);
			}
		});
		aem.getContentPane().add(invoiceBtn);

		// User Payment Button
		JButton userPaymentBtn = new JButton("Manage user payment");
		userPaymentBtn.setBounds(44, 153, 315, 42);
		userPaymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		userPaymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ManageUserPayment mngPayment = new ManageUserPayment();
				mngPayment.mngPayment.setVisible(true);
				aem.setVisible(false);

			}
		});
		aem.getContentPane().add(userPaymentBtn);

		// Operation and budget planning Button
		JButton viewOutStandingBtn = new JButton("View outstanding fee");
		viewOutStandingBtn.setBounds(44, 213, 315, 42);
		viewOutStandingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		viewOutStandingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ViewOutStanding viewOutStanding = new ViewOutStanding();
				viewOutStanding.viewOutStanding.setVisible(true);
				aem.setVisible(false);

			}
		});
		aem.getContentPane().add(viewOutStandingBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 273, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
				loginpage.loginPage.setVisible(true);
				aem.setVisible(false);

			}
		});
		aem.getContentPane().add(logOutBtn);



	}

}
