package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

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

public class ResidentMenu extends PageUtils{

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
		rm.setBounds(100, 100, 450, 580);
		rm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("    Resident Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rm.getContentPane().add(lblNewLabel);


                // View Profile Button
		JButton profileBtn = new JButton("Edit Profile");
		profileBtn.setBounds(44, 93, 315, 42);
		profileBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		profileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResViewProfile rvp = new ResViewProfile();
                                setOriginalFrame(rm);
				setTargetedFrame(rvp.resview);
				navigatePage();

			}
		});
		rm.getContentPane().add(profileBtn);

		// // Tenant Booking Room Button
		// JButton bookingBtn = new JButton("Tenant Booking");
		// bookingBtn.setBounds(44, 153, 315, 42);
		// bookingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		// bookingBtn.addActionListener(new ActionListener() {

		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		TenBookingRoom bookingRoom = new TenBookingRoom();
        //                         setOriginalFrame(rm);
		// 		setTargetedFrame(bookingRoom.br);
		// 		navigatePage();

		// 	}
		// });
		// rm.getContentPane().add(bookingBtn);

		// User Payment Button
		JButton paymentBtn = new JButton("Make Payment");
		paymentBtn.setBounds(44, 153, 315, 42);
		paymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		paymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResPaymentMenu paymentMenu = new ResPaymentMenu();
                                setOriginalFrame(rm);
				setTargetedFrame(paymentMenu.pm);
				navigatePage();

			}
		});
		rm.getContentPane().add(paymentBtn);

		// View invoice statement Button
		JButton payHisBtn = new JButton("View Invoice/Statement");
		payHisBtn.setBounds(44, 213, 315, 42);
		payHisBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		payHisBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResTenInvoiceStatement residentPaymentHistoryMenu = new ResTenInvoiceStatement();
                setOriginalFrame(rm);
				setTargetedFrame(residentPaymentHistoryMenu.rtis);
				navigatePage();

			}
		});
		rm.getContentPane().add(payHisBtn);
		
		// Facility Booking Button
		JButton facilityBtn = new JButton("Facility Booking");
		facilityBtn.setBounds(44, 273, 315, 42);
		facilityBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		facilityBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResFacilityBooking facilityBooking = new ResFacilityBooking();
                                setOriginalFrame(rm);
				setTargetedFrame(facilityBooking.fb);
				navigatePage();

			}
		});
		rm.getContentPane().add(facilityBtn);
		
		// Visitor Pass Button
		JButton visitorPassBtn = new JButton("Visitor Pass");
		visitorPassBtn.setBounds(44, 333, 315, 42);
		visitorPassBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		visitorPassBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResTenVisitorPass rtvp = new ResTenVisitorPass();
                                setOriginalFrame(rm);
				setTargetedFrame(rtvp.rtvp);
				navigatePage();

			}
		});
		rm.getContentPane().add(visitorPassBtn);
		
		// Resident / Tenant Complaint Button
		JButton complaintBtn = new JButton("Complaint");
		complaintBtn.setBounds(44, 393, 315, 42);
		complaintBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		complaintBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResidentComplaint residentComplaint = new ResidentComplaint();
                                setOriginalFrame(rm);
				setTargetedFrame(residentComplaint.rc);
				navigatePage();

			}
		});
		rm.getContentPane().add(complaintBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(44, 453, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login loginpage = new Login();
                                setOriginalFrame(rm);
				setTargetedFrame(loginpage.loginPage);
				navigatePage();
				

			}
		});
		rm.getContentPane().add(logOutBtn);



	}

}
