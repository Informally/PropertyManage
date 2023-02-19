package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Data.User;
import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ManageUserPayment extends PageUtils {

	public JFrame mngPayment;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUserPayment window = new ManageUserPayment();
					window.mngPayment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageUserPayment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mngPayment = new JFrame();
		mngPayment.setTitle("User Management");
		mngPayment.setBounds(100, 100, 871, 622);
		mngPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mngPayment.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("User Management");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		mngPayment.getContentPane().add(lblNewLabel);

		// UID
		JLabel lblUID = new JLabel("Debt ID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		mngPayment.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		mngPayment.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		mngPayment.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		mngPayment.getContentPane().add(txtName);

		// Debt
		JLabel lblDebt = new JLabel("Debt: ");
		lblDebt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDebt.setBounds(44, 123, 315, 42);
		mngPayment.getContentPane().add(lblDebt);

		JTextField txtDebt = new JTextField();
		txtDebt.setBounds(164, 123, 250, 42);
		txtDebt.setBackground(Color.gray);
		txtDebt.setEditable(false);
		mngPayment.getContentPane().add(txtDebt);

		// Payment
		JLabel lblPassword = new JLabel("Payment: ");
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPassword.setBounds(434, 123, 315, 42);
		mngPayment.getContentPane().add(lblPassword);

		JTextField txtPayment = new JTextField();
		txtPayment.setBounds(554, 123, 250, 42);
		mngPayment.getContentPane().add(txtPayment);

		// Detail
		JLabel lblDetail = new JLabel("Detail: ");
		lblDetail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDetail.setBounds(44, 173, 315, 42);
		mngPayment.getContentPane().add(lblDetail);

		JTextField txtDetail = new JTextField();
		txtDetail.setBounds(164, 173, 250, 42);
		mngPayment.getContentPane().add(txtDetail);

		// Role
		JLabel lblRole = new JLabel("Role: ");
		lblRole.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRole.setBounds(434, 173, 315, 42);
		mngPayment.getContentPane().add(lblRole);

		JTextField txtRole = new JTextField();
		txtRole.setBounds(554, 173, 250, 42);
		mngPayment.getContentPane().add(txtRole);

		// Date
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(44, 223, 315, 42);

		mngPayment.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(164, 223, 250, 42);
		txtDate.setBackground(Color.gray);
		txtDate.setEditable(false);
		mngPayment.getContentPane().add(txtDate);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		mngPayment.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("Debt.txt");
		String row[] = new String[5];
		String column[] = { "Id", "Name", "Detail", "Debt", "Role" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 323, 770, 100);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData.size(); i++) {
			row[0] = tblData.get(i).get(0);
			row[1] = tblData.get(i).get(1);
			row[2] = tblData.get(i).get(2);
			row[3] = tblData.get(i).get(3);
			row[4] = tblData.get(i).get(4);
			tableModel.addRow(row);

		}
		jTable.setModel(tableModel);

		ListSelectionModel select = jTable.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row = jTable.getSelectedRows();
				int columnNum = jTable.getColumnCount();

				if (row.length > 0) {
					txtUID.setText((String) jTable.getValueAt(row[0], 0));
					txtName.setText((String) jTable.getValueAt(row[0], 1));
					txtDetail.setText((String) jTable.getValueAt(row[0], 2));
					txtDebt.setText((String) jTable.getValueAt(row[0], 3));
					txtRole.setText((String) jTable.getValueAt(row[0], 4));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 323, 770, 100);
		mngPayment.getContentPane().add(scroll);
//		

		// Payment Display
		CRUD newCrud = new CRUD();
		tblData.clear();
		tblData = newCrud.read("Payment.txt");
		String rowPayment[] = new String[7];
		String columnPayment[] = { "Id", "Name", "Detail", "Payment", "Role", "Debt ID", "Date" };

		JTable jTablePayment = new JTable();
		jTablePayment.setBounds(44, 423, 770, 100);
		DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
		tableModelPayment.setColumnIdentifiers(columnPayment);
		jTablePayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable.setRowSelectionAllowed(false);
		System.out.print(tblData);

		for (int i = 0; i < tblData.size(); i++) {
			rowPayment[0] = tblData.get(i).get(0);
			rowPayment[1] = tblData.get(i).get(1);
			rowPayment[2] = tblData.get(i).get(2);
			rowPayment[3] = tblData.get(i).get(3);
			rowPayment[4] = tblData.get(i).get(4);
			rowPayment[5] = tblData.get(i).get(5);
			rowPayment[6] = tblData.get(i).get(6);
			tableModelPayment.addRow(rowPayment);

		}
		jTablePayment.setModel(tableModelPayment);

//		ListSelectionModel selectPayment = jTablePayment.getSelectionModel();
//		selectPayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		selectPayment.addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent e) {
//				int[] row = jTablePayment.getSelectedRows();
//				int columnNum = jTablePayment.getColumnCount();
//
//				if (row.length > 0) {
//					HashMap<Integer, String> debtDt = crud.read("Payment.txt",
//							(String) jTablePayment.getValueAt(row[0], 5), 5, "", 0);
//					txtUID.setText((String) jTablePayment.getValueAt(row[0], 0));
//					txtName.setText((String) jTablePayment.getValueAt(row[0], 1));
//					txtDetail.setText((String) jTablePayment.getValueAt(row[0], 2));
//					txtPayment.setText((String) jTablePayment.getValueAt(row[0], 3));
//					txtRole.setText((String) jTablePayment.getValueAt(row[0], 4));
//					txtDebt.setText(debtDt.get(3));
//				}
//
//			}
//		});
		JScrollPane scrollPayment = new JScrollPane(jTablePayment, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPayment.setBounds(44, 423, 770, 100);
		mngPayment.getContentPane().add(scrollPayment);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		mngPayment.getContentPane().add(calErrorText);

		// Add user Btn
		JButton addUserBtn = new JButton("Save User");
		addUserBtn.setBounds(44, 273, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String debtID = txtUID.getText().trim();
				String name = txtName.getText().trim();
				String detail = txtDetail.getText().trim();
				String role = txtRole.getText().trim();
				String debt = txtDebt.getText().trim();
				String payment = txtPayment.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String uid = uuid.toString();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				data.add(uid);
				data.add(name);
				data.add(detail);
				data.add(payment);
				data.add(role);
				data.add(debtID);
				data.add(dtf.format(now));

				crud.create("Payment.txt", data);
				// Update the debt value
				int totalDebt = Integer.parseInt(debt) - Integer.parseInt(payment);
				crud.update("Debt.txt", debtID, 0, "", 0, String.valueOf(totalDebt), 3, "", 0);

				// Clear text after update or add
				txtUID.setText("");
				txtName.setText("");
				txtDetail.setText("");
				txtDebt.setText("");
				txtPayment.setText("");
				txtRole.setText("");

				// Refresh the data in table
				tblData = crud.read("Debt.txt");
				DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
				tableModel.setColumnIdentifiers(column);
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();
				jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				for (int i = 0; i < tblData.size(); i++) {
					row[0] = tblData.get(i).get(0);
					row[1] = tblData.get(i).get(1);
					row[2] = tblData.get(i).get(2);
					row[3] = tblData.get(i).get(3);
					row[4] = tblData.get(i).get(4);
					tableModel.addRow(row);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jTable.updateUI();

				tblData = crud.read("Payment.txt");
				DefaultTableModel tableModelPayment = (DefaultTableModel) jTablePayment.getModel();
				tableModelPayment.setColumnIdentifiers(columnPayment);
				tableModelPayment.setColumnIdentifiers(column);
				tableModelPayment.getDataVector().removeAllElements();
				jTablePayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				System.out.print(tblData);
				for (int i = 0; i < tblData.size(); i++) {
					rowPayment[0] = tblData.get(i).get(0);
					rowPayment[1] = tblData.get(i).get(1);
					rowPayment[2] = tblData.get(i).get(2);
					rowPayment[3] = tblData.get(i).get(3);
					rowPayment[4] = tblData.get(i).get(4);
					rowPayment[5] = tblData.get(i).get(5);
					rowPayment[6] = tblData.get(i).get(6);
					tableModelPayment.addRow(rowPayment);

				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jTablePayment.updateUI();

			}
		});
		mngPayment.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountExecMenu acctmenu = new AccountExecMenu();
				setOriginalFrame(mngPayment);
				setTargetedFrame(acctmenu.aem);
				navigatePage();

			}
		});
		mngPayment.getContentPane().add(backBtn);

	}

}
