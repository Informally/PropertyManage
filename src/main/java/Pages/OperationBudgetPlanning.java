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
import java.util.ArrayList;
import java.util.UUID;

public class OperationBudgetPlanning extends PageUtils {

	public JFrame optBgtPlan;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperationBudgetPlanning window = new OperationBudgetPlanning();
					window.optBgtPlan.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperationBudgetPlanning() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		optBgtPlan = new JFrame();
		optBgtPlan.setTitle("Operations and Budget Planning");
		optBgtPlan.setBounds(100, 100, 871, 622);
		optBgtPlan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		optBgtPlan.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Operations and Budget Planning");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		optBgtPlan.getContentPane().add(lblNewLabel);

		// UID
		JLabel lblUID = new JLabel("UID: ");
		lblUID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblUID.setBounds(44, 73, 315, 42);
		optBgtPlan.getContentPane().add(lblUID);

		JTextField txtUID = new JTextField("");
		txtUID.setBounds(164, 73, 250, 42);
		txtUID.setBackground(Color.gray);
		txtUID.setEditable(false);
		optBgtPlan.getContentPane().add(txtUID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		optBgtPlan.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		optBgtPlan.getContentPane().add(txtName);

		// Date
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(44, 123, 315, 42);
		optBgtPlan.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(164, 123, 250, 42);
		optBgtPlan.getContentPane().add(txtDate);

		// Priority
		JLabel lblPriority = new JLabel("Priority: ");
		lblPriority.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPriority.setBounds(434, 123, 315, 42);
		optBgtPlan.getContentPane().add(lblPriority);

		JTextField txtPriority = new JTextField();
		txtPriority.setBounds(554, 123, 250, 42);
		optBgtPlan.getContentPane().add(txtPriority);

		// Budget
		JLabel lblBudget = new JLabel("Budget: ");
		lblBudget.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblBudget.setBounds(44, 173, 315, 42);
		optBgtPlan.getContentPane().add(lblBudget);

		JTextField txtBudget = new JTextField();
		txtBudget.setBounds(164, 173, 250, 42);
		optBgtPlan.getContentPane().add(txtBudget);

		// Lead
		JLabel lblLead = new JLabel("Lead By: ");
		lblLead.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblLead.setBounds(434, 173, 315, 42);
		optBgtPlan.getContentPane().add(lblLead);

		JTextField txtLead = new JTextField();
		txtLead.setBounds(554, 173, 250, 42);
		optBgtPlan.getContentPane().add(txtLead);

		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		optBgtPlan.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("OptBgtPlan.txt");
		String row[] = new String[6];
		String column[] = { "UID", "Name", "Date", "Priority", "Budget", "Lead" };

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
					txtDate.setText((String) jTable.getValueAt(row[0], 2));
					txtPriority.setText((String) jTable.getValueAt(row[0], 3));
					txtBudget.setText((String) jTable.getValueAt(row[0], 4));
					txtLead.setText((String) jTable.getValueAt(row[0], 5));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 273, 770, 250);
		optBgtPlan.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		optBgtPlan.getContentPane().add(calErrorText);

		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(44, 530, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uid = txtUID.getText().trim();
				
				crud.delete("OptBgtPlan.txt", uid, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("OptBgtPlan.txt");
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
		optBgtPlan.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(204, 223, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUID.setText("");
				txtName.setText("");
				txtDate.setText("");
				txtPriority.setText("");
				txtBudget.setText("");
				txtLead.setText("");
			}
		});
		optBgtPlan.getContentPane().add(clearBtn);

		// Add operation budget Btn
		JButton addOptBgtBtn = new JButton("Save Event");
		addOptBgtBtn.setBounds(44, 223, 150, 42);
		addOptBgtBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addOptBgtBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String eventId = txtUID.getText().trim();
				String name = txtName.getText().trim();
				String date = txtDate.getText().trim();
				String priority = txtPriority.getText().trim();
				String budget = txtBudget.getText().trim();
				String lead = txtLead.getText().trim();

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (eventId.isEmpty()) { // this means new data is added
					String uid = uuid.toString();
					data.add(uid);
					data.add(name);
					data.add(date);
					data.add(priority);
					data.add(budget);
					data.add(lead);

					crud.create("OptBgtPlan.txt", data);

				} else { // this means update data
					data.add(eventId);
					data.add(name);
					data.add(date);
					data.add(priority);
					data.add(budget);
					data.add(lead);
					crud.updateRow("OptBgtPlan.txt", eventId, 0, "", 0, data);
				}

				// Clear text after update or add
				txtUID.setText("");
				txtName.setText("");
				txtDate.setText("");
				txtPriority.setText("");
				txtBudget.setText("");
				txtLead.setText("");

				// Refresh the data in table
				tblData = crud.read("OptBgtPlan.txt");
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
		optBgtPlan.getContentPane().add(addOptBgtBtn);
		
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuildingManagerMenu bmm = new BuildingManagerMenu();
				setOriginalFrame(optBgtPlan);
				setTargetedFrame(bmm.bmm);
				navigatePage();

			}
		});
		optBgtPlan.getContentPane().add(backBtn);


	}

}
