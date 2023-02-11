package Pages;

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

public class ResidentMenu {

	public JFrame rm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentMenu window = new ResidentMenu();
					window.rm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResidentMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rm = new JFrame();
		rm.setTitle("Resident Menu");
		rm.setBounds(100, 100, 871, 622);
		rm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Resident Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rm.getContentPane().add(lblNewLabel);
/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// User Profile Button
		JButton profileBtn = new JButton("User Profile");
		profileBtn.setBounds(44, 93, 315, 42);
		profileBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		profileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentProfile residentProfile = new ResidentProfile();
				
				residentProfile.rp.setVisible(true);
				rm.setVisible(false);
			}
		});
		rm.getContentPane().add(profileBtn);

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

		// User Booking Room Button
		JButton bookingBtn = new JButton("Booking Room");
		bookingBtn.setBounds(44, 153, 315, 42);
		bookingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		bookingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookingRoom bookingRoom = new BookingRoom();
				bookingRoom.br.setVisible(true);
				rm.setVisible(false);

			}
		});
		rm.getContentPane().add(bookingBtn);

		// User Payment Button
		JButton paymentBtn = new JButton("Payment");
		paymentBtn.setBounds(44, 213, 315, 42);
		paymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		paymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PaymentMenu paymentMenu = new PaymentMenu();
				paymentMenu.pm.setVisible(true);
				rm.setVisible(false);

			}
		});
		rm.getContentPane().add(paymentBtn);

		// Operation and budget planning Button
		JButton payHisBtn = new JButton("Payment History");
		payHisBtn.setBounds(44, 273, 315, 42);
		payHisBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		payHisBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResidentPaymentHistoryMenu residentPaymentHistoryMenu = new ResidentPaymentHistoryMenu();
				residentPaymentHistoryMenu.rphm.setVisible(true);
				rm.setVisible(false);

			}
		});
		rm.getContentPane().add(payHisBtn);
		
		// Operation and budget planning Button
		JButton facilityBtn = new JButton("Facility Booking");
		facilityBtn.setBounds(44, 333, 315, 42);
		facilityBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		facilityBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FacilityBooking facilityBooking = new FacilityBooking();
				facilityBooking.fb.setVisible(true);
				rm.setVisible(false);

			}
		});
		rm.getContentPane().add(facilityBtn);
		
		// Operation and budget planning Button
		JButton visitorPassBtn = new JButton("Visitor Pass");
		visitorPassBtn.setBounds(44, 393, 315, 42);
		visitorPassBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		visitorPassBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VendorComplaint vendorComplaint = new VendorComplaint();
				vendorComplaint.vc.setVisible(true);
				rm.setVisible(false);

			}
		});
		rm.getContentPane().add(visitorPassBtn);
		
		// Operation and budget planning Button
		JButton complaintBtn = new JButton("Complaint");
		complaintBtn.setBounds(44, 453, 315, 42);
		complaintBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		complaintBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VendorComplaint vendorComplaint = new VendorComplaint();
				vendorComplaint.vc.setVisible(true);
				rm.setVisible(false);

			}
		});
		rm.getContentPane().add(complaintBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 513, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
				loginpage.loginPage.setVisible(true);
				rm.setVisible(false);

			}
		});
		rm.getContentPane().add(logOutBtn);



	}

}
