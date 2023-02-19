package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GenReport extends PageUtils {

	public JFrame genReport;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenReport window = new GenReport();
					window.genReport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GenReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		genReport = new JFrame();
		genReport.setTitle("Generate Report");
		genReport.setBounds(100, 100, 871, 622);
		genReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		genReport.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Generate Report");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		genReport.getContentPane().add(lblNewLabel);

		// Report Type
		JLabel lblReportType = new JLabel("Report Type: ");
		lblReportType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblReportType.setBounds(44, 73, 315, 42);
		genReport.getContentPane().add(lblReportType);

		JComboBox<String> reportTypeOptions = new JComboBox<>();
		reportTypeOptions.setBounds(164, 73, 250, 42);
		reportTypeOptions.addItem("Payment Report");
		reportTypeOptions.addItem("User Report");
		reportTypeOptions.addItem("Debt Report");
		genReport.getContentPane().add(reportTypeOptions);

		// Result Display
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(44, 130, 770, 450);

		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 130, 770, 450);
		genReport.getContentPane().add(scroll);

		reportTypeOptions.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				switch ((String) reportTypeOptions.getSelectedItem()) {
				case "Payment Report":
					ArrayList<ArrayList<String>> paymentdata = crud.read("Payment.txt");

					String paymentreport = "<----- Payment Report ----->\n";

					for (ArrayList<String> row : paymentdata) {
						paymentreport += "\nPayment Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Detail: " + row.get(2) + "\n" + "Payment: RM" + row.get(3) + "\n" + "Role: " + row.get(4) + "\n"+ "Date: " + row.get(6) + "\n----------------------\n";


					}

					textArea.setText(paymentreport);
					break;
				case "User Report":
					ArrayList<ArrayList<String>> userdata = crud.read("User.txt");

					String userreport = "<----- User Report ----->\n";

					for (ArrayList<String> row : userdata) {
						userreport += "\nUser Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Email: "
								+ row.get(2) + "\n" + "Age: " + row.get(4) + "\n" + "Role: " + row.get(5)
								+ "\n----------------------\n";

					}

					textArea.setText(userreport);
					break;
				case "Debt Report":
					ArrayList<ArrayList<String>> debtdata = crud.read("Debt.txt");

					String debtreport = "<----- Outstanding fees Report ----->\n";

					for (ArrayList<String> row : debtdata) {
						debtreport += "\n Debt Id: " + row.get(0) + "\n" + "Name: " + row.get(1) + "\n" + "Detail: " + row.get(2) + "\n" + "Debt: RM" + row.get(3) + "\n" + "Role: " + row.get(4) + "\n----------------------\n";

					}

					textArea.setText(debtreport);
					break;
				}

			}
		});

		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingManagerMenu bmm = new BuildingManagerMenu();
				setOriginalFrame(genReport);
				setTargetedFrame(bmm.bmm);
				navigatePage();

			}
		});
		genReport.getContentPane().add(backBtn);

	}
}
