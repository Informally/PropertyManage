package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
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
import javax.swing.JComboBox;

public class VendorProfile extends PageUtils {

	public JFrame vp;
	CRUD crud = new CRUD();
	ArrayList<ArrayList<String>> tblData = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendorProfile window = new VendorProfile(null);
					window.vp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendorProfile(String vendorName) {
            
		initialize(vendorName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String vendorName) {
            //String search = JOptionPane.showInputDialog(null, "Enter your name:");
		vp = new JFrame();
		vp.setTitle("View & Update Profile");
		vp.setBounds(100, 100, 871, 622);
		vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vp.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View & Update Profile");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(34, 5, 665, 81);
		vp.getContentPane().add(lblNewLabel);

		// UID
		JLabel lblRTID = new JLabel("UID: ");
		lblRTID.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRTID.setBounds(44, 73, 315, 42);
		vp.getContentPane().add(lblRTID);

		JTextField txtRTID = new JTextField("");
		txtRTID.setBounds(164, 73, 250, 42);
		txtRTID.setBackground(Color.lightGray);
		txtRTID.setEditable(false);
		vp.getContentPane().add(txtRTID);

		// Name
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblName.setBounds(434, 73, 315, 42);
		vp.getContentPane().add(lblName);

		JTextField txtName = new JTextField();
		txtName.setBounds(554, 73, 250, 42);
		vp.getContentPane().add(txtName);

		// Email
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblEmail.setBounds(44, 123, 315, 42);
		vp.getContentPane().add(lblEmail);

		JTextField txtEmail = new JTextField();
		txtEmail.setBounds(164, 123, 250, 42);
		vp.getContentPane().add(txtEmail);
                
                // Password
                JLabel lblPwd = new JLabel("Password: ");
		lblPwd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPwd.setBounds(434, 123, 315, 42);
		vp.getContentPane().add(lblPwd);

		JTextField txtPwd = new JTextField();
		txtPwd.setBounds(554, 123, 250, 42);
		vp.getContentPane().add(txtPwd);
                
                // Age
		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblAge.setBounds(44, 173, 315, 42);
		vp.getContentPane().add(lblAge);

		JTextField txtAge = new JTextField();
		txtAge.setBounds(164, 173, 250, 42);
		vp.getContentPane().add(txtAge);

		// Role
		JLabel lblRole = new JLabel("Role: ");
		lblRole.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblRole.setBounds(434, 173, 315, 42);
		vp.getContentPane().add(lblRole);

		JTextField txtRole = new JTextField();
		txtRole.setBounds(554, 173, 250, 42);
                txtRole.setBackground(Color.lightGray);
		txtRole.setEditable(false);
		vp.getContentPane().add(txtRole);


		// Error text
		JLabel errorText = new JLabel();
		errorText.setForeground(Color.RED);
		errorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		errorText.setBounds(204, 223, 330, 42);
		errorText.setVisible(false);
		vp.getContentPane().add(errorText);

		// Result Display
		tblData = crud.read("User.txt");
		String row[] = new String[6];
		String column[] = { "User ID", "Name", "Email", "Password","Age", "Role" };

		JTable jTable = new JTable();
		jTable.setBounds(44, 273, 770, 75);
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
   
    
                        // Check if the row contains the search string
                        boolean match = false;
                        for (int j = 0; j < row.length; j++) {
                            if (row[j].toLowerCase().contains(vendorName.toLowerCase())) {
                            match = true;
                            break;
                    }
                }
    
                        // Add the row if it matches the search string
                        if (match) {
                            tableModel.addRow(row);
                            }
                    }
                
		jTable.setModel(tableModel);

		ListSelectionModel select = jTable.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		select.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int[] row = jTable.getSelectedRows();
				int columnNum = jTable.getColumnCount();

				if (row.length > 0) {
					txtRTID.setText((String) jTable.getValueAt(row[0], 0));
					txtName.setText((String) jTable.getValueAt(row[0], 1));
					txtEmail.setText((String) jTable.getValueAt(row[0], 2));
                                        txtPwd.setText((String) jTable.getValueAt(row[0], 3));
					txtAge.setText((String) jTable.getValueAt(row[0], 4));
					txtRole.setText((String) jTable.getValueAt(row[0], 5));
					
				}

			}
		});
		JScrollPane scroll = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(44, 273, 770, 75);
		vp.getContentPane().add(scroll);

		// Error text calculation
		JLabel calErrorText = new JLabel();
		calErrorText.setForeground(Color.RED);
		calErrorText.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		calErrorText.setBounds(204, 530, 330, 42);
		calErrorText.setVisible(false);
		vp.getContentPane().add(calErrorText);



		// Add Resident.Tenant Btn
		JButton addResTenBtn = new JButton("Save/Update");
		addResTenBtn.setBounds(44, 223, 150, 42);
		addResTenBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		addResTenBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				UUID uuid = UUID.randomUUID();

				String rtid = txtRTID.getText().trim();
				String name = txtName.getText().trim();
				String email = txtEmail.getText().trim();
                                String pwd = txtPwd.getText().trim();
				String age = txtAge.getText().trim();
				String role = txtRole.getText().trim();
                          
				

				ArrayList<String> data = new ArrayList<>();

				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (rtid.isEmpty()) { // this means new data is added
					String id = uuid.toString();
					data.add(id);
					data.add(name);
					data.add(email);
                                        data.add(pwd);
					data.add(age);
					data.add(role);
					

					crud.create("User.txt", data);

				} else { // this means update data
					data.add(rtid);
					data.add(name);
					data.add(email);
                                        data.add(pwd);
					data.add(age);
					data.add(role);
				
					crud.updateRow("User.txt", rtid, 0, "", 0, data);
				}

				// Clear text after update or add
				txtRTID.setText("");
				txtName.setText("");
				txtEmail.setText("");
                                txtPwd.setText("");
				txtAge.setText("");
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
                                
    
                                    // Check if the row contains the search string
                                    boolean match = false;
                                    for (int j = 0; j < row.length; j++) {
                                        if (row[j].toLowerCase().contains(vendorName.toLowerCase())) {
                                        match = true;
                                        break;
                                        }
                                   }
    
                        // Add the row if it matches the search string
                        if (match) {
                            tableModel.addRow(row);
                            }
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
		vp.getContentPane().add(addResTenBtn);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VendorMenu vm = new VendorMenu(vendorName);
                                setOriginalFrame(vp);
				setTargetedFrame(vm.vm);
				navigatePage();
			}
		});
		vp.getContentPane().add(backBtn);


	}

}
