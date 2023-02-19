package Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class parkhillinfo1 extends JFrame {

    public parkhillinfo1() {
        super("Parkhill Residences Info");

        setBounds(100, 100, 1400, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        ImageIcon imageIcon = new ImageIcon("parkhill.jpg");
        JLabel parkhillimage = new JLabel(imageIcon);
        parkhillimage.setBounds(0, 0, 800, 546);
        getContentPane().add(parkhillimage);

        JLabel lblTitle = new JLabel("Parkhill Residences - Bukit Jalil");
        lblTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
        lblTitle.setBounds(900, 80, 400, 42);
        getContentPane().add(lblTitle);

        JLabel lblEmail = new JLabel("Number of Floors: 68");
        lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        lblEmail.setBounds(900, 130, 315, 42);
        getContentPane().add(lblEmail);

        JLabel lblUnits = new JLabel("Number of Units: 1668");
        lblUnits.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        lblUnits.setBounds(900, 180, 315, 42);
        getContentPane().add(lblUnits);

        JLabel lblFac= new JLabel("Facilities: ");
        lblFac.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        lblFac.setBounds(900, 230, 315, 42);
        getContentPane().add(lblFac);

        JTextArea lblFacc = new JTextArea("Swimming Pool, Gym, Multipurpose Hall, Covered Parking, Club House, Playground, 24-hour Security");
        lblFacc.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lblFacc.setBounds(900, 280, 315, 42);
        lblFacc.setLineWrap(true);
        lblFacc.setWrapStyleWord(true);
        lblFacc.setEditable(false);
        getContentPane().add(lblFacc);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        lblLocation.setBounds(900, 330, 315, 42);
        getContentPane().add(lblLocation);

        JTextArea lblAdd = new JTextArea("Jln Jalil Perkasa 19, Bukit Jalil, 57000 Kuala Lumpur");
        lblAdd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        lblAdd.setBounds(900, 380, 315, 42);
        lblAdd.setLineWrap(true);
        lblAdd.setWrapStyleWord(true);
        lblAdd.setEditable(false);
        getContentPane().add(lblAdd);

        // back Button
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(950, 480, 150, 42);
        backBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        backBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Login lg = new Login();
                lg.loginPage.setVisible(true);
                dispose();
            }
        });
        getContentPane().add(backBtn);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    parkhillinfo1 window = new parkhillinfo1();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
    
           
