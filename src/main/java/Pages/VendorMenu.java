package Pages;
import Pages.Login;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Data.User;
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

public class VendorMenu extends PageUtils {

	public JFrame vm;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorMenu window = new VendorMenu(null);
					window.vm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorMenu(String vendorName) {
		initialize(vendorName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String vendorName) {
		vm = new JFrame();
		vm.setTitle("Vendor Menu");
		vm.setBounds(100, 100, 500, 500);
		vm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vm.getContentPane().setLayout(null);
		

		JLabel lblNewLabel = new JLabel("Welcome, " + vendorName + " !");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		vm.getContentPane().add(lblNewLabel);


		//User Profile Button
		JButton profileBtn = new JButton("User Profile");
		profileBtn.setBounds(44, 93, 315, 42);
		profileBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		profileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorProfile vendorProfile = new VendorProfile(vendorName);
                                setOriginalFrame(vm);
				setTargetedFrame(vendorProfile.vp);
				navigatePage();
			}
		});
		vm.getContentPane().add(profileBtn);


		//Payment Button
		JButton paymentBtn = new JButton("Payment");
		paymentBtn.setBounds(44, 153, 315, 42);
		paymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		paymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorPayment vendorPayment = new VendorPayment(vendorName);
                                setOriginalFrame(vm);
				setTargetedFrame(vendorPayment.vp);
				navigatePage();
			}
		});
		vm.getContentPane().add(paymentBtn);

		// View Invoice/Statement Button
		JButton payHisBtn = new JButton("View Invoice/Statement");
		payHisBtn.setBounds(44, 213, 315, 42);
		payHisBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		payHisBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VendorInvoice vendorinvoice = new VendorInvoice(vendorName);
                                setOriginalFrame(vm);
				setTargetedFrame(vendorinvoice.vi);
				navigatePage();
                                

			}
		});
		vm.getContentPane().add(payHisBtn);
		
		// Complaint Button
		JButton complaintBtn = new JButton("Complaint");
		complaintBtn.setBounds(44, 273, 315, 42);
		complaintBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		complaintBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VendorComplaint vendorComplaint = new VendorComplaint(vendorName);
                setOriginalFrame(vm);
				setTargetedFrame(vendorComplaint.vc);
				navigatePage();

			}
		});
		vm.getContentPane().add(complaintBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 333, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
                                setOriginalFrame(vm);
				setTargetedFrame(loginpage.loginPage);
				navigatePage();

			}
		});
		vm.getContentPane().add(logOutBtn);



	}

}
