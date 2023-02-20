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

public class ResPaymentMenu extends PageUtils {

	public JFrame pm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResPaymentMenu window = new ResPaymentMenu();
					window.pm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResPaymentMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pm = new JFrame();
		pm.setTitle("Payment Menu");
		pm.setBounds(100, 100, 871, 622);
		pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Payment Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		pm.getContentPane().add(lblNewLabel);

		// Booking Room Payment Button
		JButton profileBtn = new JButton("Tenant Booking Payment");
		profileBtn.setBounds(44, 93, 315, 42);
		profileBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		profileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TenRoomPayment roomPayment = new TenRoomPayment();
				roomPayment.rp.setVisible(true);
				pm.setVisible(false);
			}
		});
		pm.getContentPane().add(profileBtn);

		// Monthly Payment Button
		JButton paymentBtn = new JButton("Monthly Payment");
		paymentBtn.setBounds(44, 153, 315, 42);
		paymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		paymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TenMonthlyPayment monthlyPayment = new TenMonthlyPayment();
				monthlyPayment.mp.setVisible(true);
				pm.setVisible(false);

			}
		});
		pm.getContentPane().add(paymentBtn);
                
                // Facility Payment Button
		JButton facilitytBtn = new JButton("Facility Payment");
		facilitytBtn.setBounds(44, 213, 315, 42);
		facilitytBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		facilitytBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResFacilityPayment facilityPayment = new ResFacilityPayment();
				facilityPayment.fp.setVisible(true);
				pm.setVisible(false);

			}
		});
		pm.getContentPane().add(facilitytBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Back");
		logOutBtn.setBounds(44, 273, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResidentMenu rm = new ResidentMenu();
				setOriginalFrame(pm);
				setTargetedFrame(rm.rm);
				navigatePage();

			}
		});
		pm.getContentPane().add(logOutBtn);



	}

}
