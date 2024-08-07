package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.JOptionPane;

public class ChargePaymentResTen extends PageUtils {

	public JFrame chargepaymentrestenFrame;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChargePaymentResTen window = new ChargePaymentResTen();
					window.chargepaymentrestenFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChargePaymentResTen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		chargepaymentrestenFrame = new JFrame();
		chargepaymentrestenFrame.setTitle("Charge Payment to Resident/Tenant");
		chargepaymentrestenFrame.setBounds(100, 100, 871, 622);
		chargepaymentrestenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set as non resizable
		chargepaymentrestenFrame.setResizable(false);
		chargepaymentrestenFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Charge Payment to Resident/Tenant");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 5, 665, 81);
		chargepaymentrestenFrame.getContentPane().add(lblNewLabel);

		//  ID
		JLabel lblEMID = new JLabel("ID: ");
		lblEMID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEMID.setBounds(44, 73, 315, 42);
		chargepaymentrestenFrame.getContentPane().add(lblEMID);

		JTextField txtEMID = new JTextField("");
		txtEMID.setBounds(164, 73, 250, 42);
		txtEMID.setBackground(Color.lightGray);
		txtEMID.setEditable(false);
		chargepaymentrestenFrame.getContentPane().add(txtEMID);

		// Vendor Name
		JLabel lblName = new JLabel("Resident Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblName.setBounds(434, 73, 315, 42);
		chargepaymentrestenFrame.getContentPane().add(lblName);
        
        //JComboBox that lists all the vendors from user.txt
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setBounds(554, 73, 250, 42);
        // comboBox.setBackground(Color.lightGray);
        comboBox.setEditable(false);
        chargepaymentrestenFrame.getContentPane().add(comboBox);
        //get all the users from user.txt
        ArrayList<ArrayList<String>> users = crud.read("ResTen.txt");
        //add all users to the comboBox if position 6 in users is "Resident" or "Tenant"

        for (ArrayList<String> user : users) {
            if (user.get(6).equals("Resident") || user.get(6).equals("Tenant")) {
                comboBox.addItem(user.get(1));
            }
        }




		// Payment Details
		JLabel lblDetails = new JLabel("Detail: ");
		lblDetails.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDetails.setBounds(44, 123, 315, 42);
		chargepaymentrestenFrame.getContentPane().add(lblDetails);

        //JComboBox that lists the Utilities, Rental, and Services
        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setBounds(164, 123, 250, 42);
        // comboBox_1.setBackground(Color.lightGray);
        comboBox_1.setEditable(false);
        chargepaymentrestenFrame.getContentPane().add(comboBox_1);
        comboBox_1.addItem("Monthly Room Payment");
        comboBox_1.addItem("Other Services");


		// Amount
		JLabel lblAmt = new JLabel("Amount: ");
		lblAmt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAmt.setBounds(434, 123, 315, 42);
		chargepaymentrestenFrame.getContentPane().add(lblAmt);

		JTextField txtAmt = new JTextField();
		txtAmt.setBounds(554, 123, 250, 42);
		chargepaymentrestenFrame.getContentPane().add(txtAmt);

		// Date
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblDate.setBounds(44, 173, 315, 42);
		chargepaymentrestenFrame.getContentPane().add(lblDate);

		JTextField txtDate = new JTextField();
		txtDate.setBounds(164, 173, 250, 42);
		chargepaymentrestenFrame.getContentPane().add(txtDate);



		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		chargepaymentrestenFrame.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("ResTenPendingFee.txt");
		String row[] = new String[5];
		String column[] = { "ID", "Name", "Detail", "Amount", "Date"};

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


					txtEMID.setText((String) jTable.getValueAt(row[0], 0));
                    //set the selected name from the table to the comboBox
                    comboBox.setSelectedItem((String) jTable.getValueAt(row[0], 1));
                    comboBox_1.setSelectedItem((String) jTable.getValueAt(row[0], 2));
					txtAmt.setText((String) jTable.getValueAt(row[0], 3));
					txtDate.setText((String) jTable.getValueAt(row[0], 4));
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(44, 273, 770, 250);
		chargepaymentrestenFrame.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		chargepaymentrestenFrame.getContentPane().add(calErrorText);

		
		// Delete Btn
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(44, 530, 150, 42);
		deleteBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String emid = txtEMID.getText().trim();
				
				crud.delete("ResTenPendingFee.txt", emid, 0, "", 0);
				
				// Refresh the data in table
				tblData = crud.read("ResTenPendingFee.txt");
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

			}
		});
		chargepaymentrestenFrame.getContentPane().add(deleteBtn);

		// Clear Text field Btn
		JButton clearBtn = new JButton("Clear All");
		clearBtn.setBounds(254, 223, 150, 42);
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtEMID.setText("");
                //set comboBox to default
                comboBox.setSelectedIndex(-1);
				// txtName.setText("");
				comboBox_1.setSelectedIndex(-1);
				txtAmt.setText("");
				txtDate.setText("");
			}
		});
		chargepaymentrestenFrame.getContentPane().add(clearBtn);

		// Charge Payment Btn
		JButton chargeButton = new JButton("Charge Payment");
		chargeButton.setBounds(44, 223, 200, 42);
		chargeButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		chargeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String emid = txtEMID.getText().trim();
                String name = (String) comboBox.getSelectedItem();
                String detail = (String) comboBox_1.getSelectedItem();
				String amt = txtAmt.getText().trim();
				String date = txtDate.getText().trim();


				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (emid.isEmpty()) { // this means new data is added
                    String no = uuid.toString();
                    data.add(no);
                    data.add(name);
                    data.add(detail);
                    data.add(amt);
                    data.add(date);
                    
                    crud.create("ResTenPendingFee.txt", data);
                    
                } else { // this means update data
                    data.add(emid);
                    data.add(name);
                    data.add(detail);
                    data.add(amt);
                    data.add(date);

                    crud.updateRow("ResTenPendingFee.txt", emid, 0, "", 0, data);
                }
                                
         
				// Clear text after update or add
				txtEMID.setText("");
                //set comboBox to default
                comboBox.setSelectedIndex(-1);
                //ser comboBox_1 to default
                comboBox_1.setSelectedIndex(-1);
				txtAmt.setText("");
				txtDate.setText("");

				// Refresh the data in table
				tblData = crud.read("ResTenPendingFee.txt");
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

			}
		});
		chargepaymentrestenFrame.getContentPane().add(chargeButton);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountExecMenu Aem = new AccountExecMenu();
				setOriginalFrame(chargepaymentrestenFrame);
				setTargetedFrame(Aem.aem);
				navigatePage();

			}
		});
		chargepaymentrestenFrame.getContentPane().add(backBtn);


	}

}
