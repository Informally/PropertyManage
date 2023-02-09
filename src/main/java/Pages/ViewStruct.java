package Pages;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

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

public class ViewStruct {

	public JFrame viewStruct;
	public CRUD crud = new CRUD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStruct window = new ViewStruct();
					window.viewStruct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewStruct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		viewStruct = new JFrame();
		viewStruct.setTitle("View Structure");
		viewStruct.setBounds(100, 100, 871, 622);
		viewStruct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewStruct.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("View Structure");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 37));
		lblNewLabel.setBounds(34, 11, 665, 81);
		viewStruct.getContentPane().add(lblNewLabel);


		ArrayList<ArrayList<String>> tblData = crud.read("User.txt");
		DefaultMutableTreeNode bm = new DefaultMutableTreeNode("Building Manager");
		DefaultMutableTreeNode acctExe = new DefaultMutableTreeNode("Account Executive");
		DefaultMutableTreeNode admin = new DefaultMutableTreeNode("Admin Executive");
		DefaultMutableTreeNode be = new DefaultMutableTreeNode("Building Executive");
		DefaultMutableTreeNode oth = new DefaultMutableTreeNode("Others");
		bm.add(be);
		be.add(acctExe);
		acctExe.add(admin);
		admin.add(oth);

		for (ArrayList<String> row : tblData) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(row.get(1));

			switch (row.get(5)) {
			case "Building Manager":

				bm.add(node);
				break;
			case "Building Executive":
				be.add(node);

				break;
			case "Account Executive":
				acctExe.add(node);

				break;
			case "Admin Executive":
				admin.add(node);
				break;
			default:
				oth.add(node);

			}


		}
		
		JTree jt = new JTree(bm);
		jt.setBounds(44, 130, 770, 450);
		viewStruct.getContentPane().add(jt);
		
		// back Button
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(700, 11, 150, 42);
		backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TeamStructMgt struct = new TeamStructMgt();
				struct.teamStructMgt.setVisible(true);
				viewStruct.setVisible(false);

			}
		});
		viewStruct.getContentPane().add(backBtn);

		


	}

}
