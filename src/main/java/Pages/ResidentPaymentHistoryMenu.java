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

public class ResidentPaymentHistoryMenu extends PageUtils {

	public JFrame rphm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResidentPaymentHistoryMenu window = new ResidentPaymentHistoryMenu();
					window.rphm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResidentPaymentHistoryMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rphm = new JFrame();
		rphm.setTitle("Payment History Menu");
		rphm.setBounds(100, 100, 871, 622);
		rphm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rphm.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Payment History Menu");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		rphm.getContentPane().add(lblNewLabel);

		// Pending Fee Button
		JButton profileBtn = new JButton("Pending Fee");
		profileBtn.setBounds(44, 93, 315, 42);
		profileBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		profileBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentPendingFee residentPendingFee = new ResidentPendingFee();
				
				residentPendingFee.rpf.setVisible(true);
				rphm.setVisible(false);
			}
		});
		rphm.getContentPane().add(profileBtn);

		// Invoice & Statement Button
		JButton paymentBtn = new JButton("Invoice & Statement");
		paymentBtn.setBounds(44, 153, 315, 42);
		paymentBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		paymentBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResidentInvoiceStatement residentInvoiceStatement = new ResidentInvoiceStatement();
				residentInvoiceStatement.ris.setVisible(true);
				rphm.setVisible(false);

			}
		});
		rphm.getContentPane().add(paymentBtn);
		
		// Receipt Button
		JButton complaintBtn = new JButton("Receipt");
		complaintBtn.setBounds(44, 213, 315, 42);
		complaintBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		complaintBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResidentReceipt residentReceipt = new ResidentReceipt();
				residentReceipt.rr.setVisible(true);
				rphm.setVisible(false);

			}
		});
		rphm.getContentPane().add(complaintBtn);

		// Log Out Btn
		JButton logOutBtn = new JButton("Back");
		logOutBtn.setBounds(44, 273, 315, 42);
		logOutBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ResidentMenu rm = new ResidentMenu();
				setOriginalFrame(rphm);
				setTargetedFrame(rm.rm);
				navigatePage();

			}
		});
		rphm.getContentPane().add(logOutBtn);



	}

}
