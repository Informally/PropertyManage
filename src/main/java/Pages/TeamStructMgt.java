package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import Data.User;
import Handlers.CRUD;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

public class TeamStructMgt {

	public JFrame teamStructMgt;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamStructMgt window = new TeamStructMgt();
					window.teamStructMgt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeamStructMgt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		teamStructMgt = new JFrame();
		teamStructMgt.setTitle("Team Structure Management");
		teamStructMgt.setBounds(100, 100, 871, 622);
		teamStructMgt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teamStructMgt.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Team Structure Management");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		teamStructMgt.getContentPane().add(lblNewLabel);

		// UID
		JLabel lblUID = new JLabel("UID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		teamStructMgt.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		teamStructMgt.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		teamStructMgt.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		teamStructMgt.getContentPane().add(txtName);

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(44, 123, 315, 42);
		teamStructMgt.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(164, 123, 250, 42);
		teamStructMgt.getContentPane().add(txtEmail);

		// Password
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPassword.setBounds(434, 123, 315, 42);
		teamStructMgt.getContentPane().add(lblPassword);

		JTextField txtPassword = new JTextField();
		txtPassword.setBounds(554, 123, 250, 42);
		teamStructMgt.getContentPane().add(txtPassword);

		// Age
		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAge.setBounds(44, 173, 315, 42);
		teamStructMgt.getContentPane().add(lblAge);

		JTextField txtAge = new JTextField();
		txtAge.setBounds(164, 173, 250, 42);
		teamStructMgt.getContentPane().add(txtAge);

		// Role
		JLabel lblRole = new JLabel("Role: ");
		lblRole.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRole.setBounds(434, 173, 315, 42);
		teamStructMgt.getContentPane().add(lblRole);

		JTextField txtRole = new JTextField();
		txtRole.setBounds(554, 173, 250, 42);
		teamStructMgt.getContentPane().add(txtRole);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		teamStructMgt.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("User.txt");
		String row[] = new String[6];
		String column[] = { "User Id", "Name", "Email", "Password", "Age", "Role" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 273, 770, 250);
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setColumnIdentifiers(column);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < tblData.size(); i++) {
			row[0] = tblData.get(i).get(0);
			row[1] = tblData.get(i).get(1);
			row[2] = tblData.get(i).get(2);
			row[3] = tblData.get(i).get(3);
			row[4] = tblData.get(i).get(4);
			row[5] = tblData.get(i).get(5);
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
					txtEmail.setText((String) jTable.getValueAt(row[0], 2));
					txtPassword.setText((String) jTable.getValueAt(row[0], 3));
					txtAge.setText((String) jTable.getValueAt(row[0], 4));
					txtRole.setText((String) jTable.getValueAt(row[0], 5));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 273, 770, 250);
		teamStructMgt.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		teamStructMgt.getContentPane().add(calErrorText);

		JTree jt = new JTree();

		// Show Structure Btn
		JButton showStructBtn = new JButton("View Structure");
		showStructBtn.setBounds(44, 530, 150, 42);
		showStructBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		showStructBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewStruct vs = new ViewStruct();
				vs.viewStruct.setVisible(true);
			}
		});
		teamStructMgt.getContentPane().add(showStructBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 223, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtName.setText("");
				txtAge.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				txtRole.setText("");
			}
		});
		teamStructMgt.getContentPane().add(clearBtn);

		// Add user Btn
		JButton addUserBtn = new JButton("Save User");
		addUserBtn.setBounds(44, 223, 150, 42);
		addUserBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addUserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String userId = txtUID.getText().trim();
				String name = txtName.getText().trim();
				String age = txtAge.getText().trim();
				String role = txtRole.getText().trim();
				String email = txtEmail.getText().trim();
				String password = txtPassword.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (userId.isEmpty()) { // this means new data is added
					String uid = uuid.toString();
					data.add(uid);
					data.add(name);
					data.add(email);
					data.add(password);
					data.add(age);
					data.add(role);

					crud.create("User.txt", data);

				} else { // this means update data
					data.add(userId);
					data.add(name);
					data.add(email);
					data.add(password);
					data.add(age);
					data.add(role);
					crud.updateRow("User.txt", userId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtName.setText("");
				txtAge.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				txtRole.setText("");

				// Refresh the data in table
				tblData = crud.read("User.txt");
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
					row[5] = tblData.get(i).get(5);
					tableModel.addRow(row);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jTable.updateUI();

			}
		});
		teamStructMgt.getContentPane().add(addUserBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingManagerMenu bmm = new BuildingManagerMenu();
				bmm.bmm.setVisible(true);
				teamStructMgt.setVisible(false);

			}
		});
		teamStructMgt.getContentPane().add(backBtn);

	}

}
