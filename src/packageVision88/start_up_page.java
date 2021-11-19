package packageVision88;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class start_up_page extends JFrame implements ActionListener {

            
    
    public start_up_page() {

        JPanel panelS = new JPanel();
        panelS.setLayout(null);

        JLabel labelPOS = new JLabel();
        JLabel labelU = new JLabel();
        JLabel labelP = new JLabel();
        JLabel labelPanelS = new JLabel();
        JLabel labelsubtext = new JLabel();
        JLabel labelvisa = new JLabel();
        JLabel labeltrolley = new JLabel();
        JLabel labelcashr = new JLabel();
        JLabel labelcashb = new JLabel();
        JLabel labelmoney = new JLabel();

        ImageIcon imageTitle = new ImageIcon("Resources/signin_Title.png");
        ImageIcon imageStartup = new ImageIcon("Resources/Logopng_200px.png");
        ImageIcon imageVisa = new ImageIcon("Resources/icons8-visa-48.png");
        ImageIcon imagetrolley = new ImageIcon("Resources/icons8-shopping-cart-48.png");
        ImageIcon imagecashr = new ImageIcon("Resources/icons8-cash-register-48.png");
        ImageIcon imagecashb = new ImageIcon("Resources/icons8-money-bag-40.png");
        ImageIcon imagemoney = new ImageIcon("Resources/icons8-cash-48.png");

        // Borders
        Border borderpanel = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.WHITE);

        JTextField textFieldUser = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton buttonLogin = new JButton("Login");
        JButton buttonRegister = new JButton("Register");
        JButton buttonExit = new JButton("Exit");

        labelPOS.setText("Login in to our Store");
        labelU.setText("Username: ");
        labelP.setText("Password: ");
        labelPanelS.setText("AGRI8 Retail Store");
        labelsubtext.setText("For all your agricultural retail needs");

        labelPOS.setFont(new Font("Comic Sans", Font.BOLD, 42));
        labelPanelS.setFont(new Font("Comic Sans", Font.BOLD, 44));
        labelsubtext.setFont(new Font("Arial", Font.ITALIC, 22));
        labelU.setFont(new Font("Arial", Font.BOLD, 18));
        labelP.setFont(new Font("Arial", Font.BOLD, 18));

        labelPOS.setBounds(620,70,600,200);
        labelU.setBounds(650,250,120,200);
        labelP.setBounds(650,330,120,200);
        labelPanelS.setBounds(100,100,600,400);
        labelsubtext.setBounds(130,350,350,200);
        labelvisa.setBounds(740, 220, 100,100);
        labeltrolley.setBounds(820, 220, 100,100);
        labelcashr.setBounds(900, 220, 100,100);
        labelcashb.setBounds(980, 220, 100,100);
        labelmoney.setBounds(1040, 220, 100,100);

        labelPOS.setIconTextGap(10);
        labelPOS.setIcon(imageTitle);

        labelPanelS.setIconTextGap(10);
        labelPanelS.setIcon(imageStartup);
        labelPanelS.setHorizontalTextPosition(JLabel.CENTER);
        labelPanelS.setVerticalTextPosition(JLabel.TOP);

        labelvisa.setIcon(imageVisa);
        labelcashb.setIcon(imagecashb);
        labelcashr.setIcon(imagecashr);
        labelmoney.setIcon(imagemoney);
        labeltrolley.setIcon(imagetrolley);

        labelPanelS.setIconTextGap(10);

        textFieldUser.setBounds(750,335,310,25);
        passwordField.setBounds(750,415,310,25);

        textFieldUser.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));

        textFieldUser.setFocusable(true);

        buttonLogin.setFont(new Font("Arial", Font.BOLD, 22));
        buttonRegister.setFont(new Font("Arial", Font.BOLD, 22));
        buttonExit.setFont(new Font("Arial", Font.BOLD, 22));

        buttonLogin.setBounds(960,500,120,50);
        buttonRegister.setBounds(810,500,120,50);
        buttonExit.setBounds(650,500,120,50);

        buttonLogin.addActionListener(this);
        buttonRegister.addActionListener(this);
        buttonExit.addActionListener(this);

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(61, 196, 130));
        panelS.setBackground(new Color(205, 155, 255));
        buttonLogin.setContentAreaFilled(false);
        buttonLogin.setBorderPainted(false);
        buttonLogin.setForeground(Color.WHITE);
        buttonRegister.setContentAreaFilled(false);
        buttonRegister.setBorderPainted(false);
        buttonRegister.setForeground(Color.WHITE);
        buttonExit.setContentAreaFilled(false);
        buttonExit.setBorderPainted(false);
        buttonExit.setForeground(Color.WHITE);
        labelPOS.setForeground(Color.WHITE);
        labelPanelS.setForeground(Color.WHITE);
        labelsubtext.setForeground(new Color(250, 220, 113));

        panelS.setBounds(0, 0,600,710); // Set Panel Bounds
        panelS.setBorder(borderpanel);

        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Welcome to Agri8 Retailers");
        frame.setIconImage(new ImageIcon("Resources/icon_iconpos.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1200, 750);
        frame.setResizable(false);

        //Screen Position
        frame.setLocationRelativeTo(null);

        frame.add(labelPOS);
        frame.add(labelvisa);
        frame.add(labelmoney);
        frame.add(labelcashb);
        frame.add(labelcashr);
        frame.add(labeltrolley);
        frame.add(panelS);
        panelS.add(labelPanelS);
        panelS.add(labelsubtext);
        frame.add(labelU);
        frame.add(labelP);
        frame.add(textFieldUser);
        frame.add(passwordField);
        frame.add(buttonLogin);
        frame.add(buttonRegister);
        frame.add(buttonExit);
        frame.setVisible(true);

        // Add an ActionListener to DOCTOR'S LOGIN JButton
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String username = textFieldUser.getText();
                String password = String.valueOf(passwordField.getPassword());

                try {
                    //Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection

                    String query = "SELECT * FROM emp_reg_tbl WHERE emp_username = ? and emp_password = ?";
                    PreparedStatement statement = connection.prepareStatement(query);

                    statement.setString(1, username);
                    statement.setString(2, password);

                    ResultSet rs = statement.executeQuery();

                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null, "WELCOME TO AGRI8 Point of Sale system");
                        frame.dispose();
                        new Main_page();

                    } else {
                        JOptionPane.showMessageDialog(null, "Username / Password incorrect");

                        textFieldUser.setText("");
                        passwordField.setText("");

                        textFieldUser.requestFocus();


                    }

                    connection.close();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println("System got an error");
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });

        // Add an ActionListener to REGISTER JButton
        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == buttonRegister) {
                    frame.dispose();
                    new emp_reg_page();
                }
            }
        });

        // Add an ActionListener to CLOSE JButton
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                // Exit Button
                int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Select", JOptionPane.YES_NO_OPTION);

                if(exit == 0)System.exit(0);

            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

