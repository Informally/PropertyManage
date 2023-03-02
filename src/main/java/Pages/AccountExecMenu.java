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

public class AccountExecMenu extends PageUtils {

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
		aem.setTitle("Account Executive Menu");
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
				setOriginalFrame(aem);
				setTargetedFrame(viewInvoice.viewInvoice);
				navigatePage();
			}
		});
		aem.getContentPane().add(invoiceBtn);

		// User Payment Button
		JButton userPaymentBtn = new JButton("Manage Resident/Tenant Payment");
		userPaymentBtn.setBounds(44, 153, 315, 42);
		userPaymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		userPaymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ManageUserPayment mngPayment = new ManageUserPayment();
				setOriginalFrame(aem);
				setTargetedFrame(mngPayment.mngPayment);
				navigatePage();

			}
		});
                aem.getContentPane().add(userPaymentBtn);
                
                // User Payment Button2
		JButton userPaymentBtn2 = new JButton("Manage Vendor Payment");
		userPaymentBtn2.setBounds(44, 213, 315, 42);
		userPaymentBtn2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		userPaymentBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ManageUserPayment2 mngPayment2 = new ManageUserPayment2();
				setOriginalFrame(aem);
				setTargetedFrame(mngPayment2.mngPayment2);
				navigatePage();

			}
		});
		aem.getContentPane().add(userPaymentBtn2);

		// Operation and budget planning Button
		JButton viewOutStandingBtn = new JButton("View outstanding fee Resident/Tenant");
		viewOutStandingBtn.setBounds(44, 273, 315, 42);
		viewOutStandingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		viewOutStandingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ViewOutStanding viewOutStanding = new ViewOutStanding();
				setOriginalFrame(aem);
				setTargetedFrame(viewOutStanding.viewOutStanding);
				navigatePage();

			}
		});
		aem.getContentPane().add(viewOutStandingBtn);
                
                // Operation and budget planning Button
		JButton viewOutStandingBtn2 = new JButton("View outstanding fee Vendor");
		viewOutStandingBtn2.setBounds(44, 333, 315, 42);
		viewOutStandingBtn2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		viewOutStandingBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ViewOutStanding2 viewOutStanding2 = new ViewOutStanding2();
				setOriginalFrame(aem);
				setTargetedFrame(viewOutStanding2.viewOutStanding2);
				navigatePage();

			}
		});
		aem.getContentPane().add(viewOutStandingBtn2);
                
        // Charge Payment
		JButton chargeBtn2 = new JButton("Charge Payment");
		chargeBtn2.setBounds(44, 393, 315, 42);
		chargeBtn2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		chargeBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ChargePayment chargeBtn2 = new ChargePayment();
				setOriginalFrame(aem);
				setTargetedFrame(chargeBtn2.chargepaymentFrame);
				navigatePage();

			}
		});
		aem.getContentPane().add(chargeBtn2);

		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 453, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
				setOriginalFrame(aem);
				setTargetedFrame(loginpage.loginPage);
				navigatePage();

			}
		});
		aem.getContentPane().add(logOutBtn);



	}

}
