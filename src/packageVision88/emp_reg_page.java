package packageVision88;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class emp_reg_page extends JFrame implements ActionListener{




    public emp_reg_page(){

        JLabel labelH = new JLabel();
        JLabel labelID = new JLabel();
        JLabel labelName = new JLabel();
        JLabel labelLast = new JLabel();
        JLabel labelUser = new JLabel();
        JLabel labelPass = new JLabel();
        JLabel labelEmail = new JLabel();
        JLabel labelPhone = new JLabel();
        JLabel labelStreet = new JLabel();
        JLabel labelCity = new JLabel();
        JLabel labelPostal = new JLabel();
        JLabel labelDOB= new JLabel();
        JLabel labeldateformat = new JLabel();
        JLabel labelGender = new JLabel();

        TextField textID = new TextField();
        TextField textName= new TextField();
        TextField textLast = new TextField();
        TextField textUser= new TextField();
        TextField textPass = new TextField();
        TextField textEmail = new TextField();
        TextField textStreet = new TextField();
        TextField textCity = new TextField();
        JFormattedTextField textDOBN;

        JComboBox comboGender = new JComboBox();

        // Have a field to format a date in yyyy/mm/dd format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        textDOBN = new JFormattedTextField(dateFormatter);

        // Mask for phone spacing
        JFormattedTextField textformatPhone= null;
        try {
            MaskFormatter phonenr = new MaskFormatter("### ### ####");
            textformatPhone= new JFormattedTextField(phonenr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Mask for phone spacing
        JFormattedTextField textPostal= null;
        try {
            MaskFormatter postald = new MaskFormatter("####");
            textPostal= new JFormattedTextField(postald);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //email lower case
        textEmail.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int pos = textEmail.getCaretPosition();
                textEmail.setText(textEmail.getText().toLowerCase());
                textEmail.setCaretPosition(pos);
            }
        });

        ImageIcon imageTitle = new ImageIcon("Resources/icons8-name-tag-100.png");
        ImageIcon imageRegister = new ImageIcon("Resources/icons8-add-user-group-woman-man-40.png");
        ImageIcon imageClear = new ImageIcon("Resources/icons8-clear-formatting-48.png");
        ImageIcon imageClose = new ImageIcon("Resources/icons8-close-window-40.png");

        JButton buttonRegister = new JButton("Register", imageRegister);
        JButton buttonClear = new JButton("Clear", imageClear);
        JButton buttonClose = new JButton("Close", imageClose);

        labelH.setText("Employee signup Form");
        labelID.setText("Employee ID: ");
        labelName.setText("First Name: ");
        labelLast.setText("Last Name: ");
        labelUser.setText("Username: ");
        labelPass.setText("Password: ");
        labelEmail.setText("Email: ");
        labelPhone.setText("Phone Number: ");
        labelStreet.setText("Street Address: ");
        labelCity.setText("City: ");
        labelPostal.setText("Postal Code: ");
        labelDOB.setText("Date-of-Birth: ");
        labeldateformat.setText("yyyy/mm/dd");
        labelGender.setText("Gender: ");


        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));
        labelID.setFont(new Font("Arial", Font.BOLD, 18));
        labelName.setFont(new Font("Arial", Font.BOLD, 18));
        labelLast.setFont(new Font("Arial", Font.BOLD, 18));
        labelUser.setFont(new Font("Arial", Font.BOLD, 18));
        labelPass.setFont(new Font("Arial", Font.BOLD, 18));
        labelEmail.setFont(new Font("Arial", Font.BOLD, 18));
        labelPhone.setFont(new Font("Arial", Font.BOLD, 18));
        labelStreet.setFont(new Font("Arial", Font.BOLD, 18));
        labelCity.setFont(new Font("Arial", Font.BOLD, 18));
        labelPostal.setFont(new Font("Arial", Font.BOLD, 18));
        labelDOB.setFont(new Font("Arial", Font.BOLD, 18));
        labeldateformat.setFont(new Font("Arial", Font.BOLD, 14));
        labelGender.setFont(new Font("Arial", Font.BOLD, 18));

        labelH.setBounds(120,-40,1000,200);

        labelID.setBounds(120,83,130,200);
        labelName.setBounds(120,142,120,200);
        labelLast.setBounds(120,202,120,200);
        labelUser.setBounds(120,262,120,200);
        labelPass.setBounds(120,322,120,200);
        labelEmail.setBounds(120,382,120,200);

        textID.setBounds(260,170,300,25);
        textName.setBounds(260,230,290,25);
        textLast.setBounds(260,290,290,25);
        textUser.setBounds(260,350,290,25);
        textPass.setBounds(260,410,290,25);
        textEmail.setBounds(260,470,290,25);

        textID.setFont(new Font("Arial", Font.PLAIN, 18));
        textName.setFont(new Font("Arial", Font.PLAIN, 16));
        textLast.setFont(new Font("Arial", Font.PLAIN,16));
        textUser.setFont(new Font("Arial", Font.PLAIN, 16));
        textPass.setFont(new Font("Arial", Font.PLAIN, 16));
        textEmail.setFont(new Font("Arial", Font.PLAIN, 16));

        labelPhone.setBounds(620,83,150,200);
        labelStreet.setBounds(620,142,150,200);
        labelCity.setBounds(620,202,150,200);
        labelPostal.setBounds(620,262,150,200);
        labelDOB.setBounds(620,322,150,200);
        labeldateformat.setBounds(920,410,100,25);
        labelGender.setBounds(620,382,150,200);

        textformatPhone.setBounds(780,170,290,25);
        textStreet.setBounds(780,230,290,25);
        textCity.setBounds(780,290,290,25);
        textPostal.setBounds(780,350,290,25);
        textDOBN.setBounds(780,410,130,25);

        comboGender.addItem("");
        comboGender.addItem("Male");
        comboGender.addItem("Female");

        comboGender.setBounds(780,470,150,25);

        textformatPhone.setFont(new Font("Arial", Font.PLAIN, 16));
        textStreet.setFont(new Font("Arial", Font.PLAIN, 16));
        textCity.setFont(new Font("Arial", Font.PLAIN,16));
        textPostal.setFont(new Font("Arial", Font.PLAIN, 16));
        textDOBN.setFont(new Font("Arial", Font.PLAIN, 16));

        labelH.setIconTextGap(90);
        labelH.setIcon(imageTitle);

        buttonRegister.setFont(new Font("Arial", Font.BOLD, 16));
        buttonClear.setFont(new Font("Arial", Font.BOLD, 16));
        buttonClose.setFont(new Font("Arial", Font.BOLD, 16));

        buttonRegister.setBounds(800,550,160,70);
        buttonClear.setBounds(520,550,160,70);
        buttonClose.setBounds(260,550,160,70);

        buttonClear.addActionListener(this);
        buttonRegister.addActionListener(this);
        buttonClose.addActionListener(this);

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(205, 155, 255));


        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Hospital Management Program");
        frame.setIconImage(new ImageIcon("Resources/icon_hs.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1200, 700);
        frame.setResizable(false);

        //Screen Position
        frame.setLocationRelativeTo(null);

        frame.add(labelH);
        frame.add(labelID);
        frame.add(labelName);
        frame.add(labelLast);
        frame.add(labelUser);
        frame.add(labelPass);
        frame.add(labelEmail);
        frame.add(labelPhone);
        frame.add(labelStreet);
        frame.add(labelCity);
        frame.add(labelPostal);
        frame.add(labelDOB);
        frame.add(labeldateformat);
        frame.add(labelGender);

        frame.add(textID);
        frame.add(textName);
        frame.add(textLast);
        frame.add(textUser);
        frame.add(textPass);
        frame.add(textEmail);

        frame.add(textformatPhone);
        frame.add(textStreet);
        frame.add(textCity);
        frame.add(textPostal);
        frame.add(textDOBN);

        frame.add(comboGender);

        frame.add(buttonRegister);
        frame.add(buttonClear);
        frame.add(buttonClose);
        frame.setVisible(true);

        // Add an ActionListener to Employee  REGISTRATION JButton
        // Initialize connection insert / save Data to mySQL


        JFormattedTextField finaltextPostal= textPostal;
        JFormattedTextField finalTextDOBN = textDOBN;
        JFormattedTextField finalTextformatPhone = textformatPhone;

        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String emp_id = textID.getText();
                String fname = textName.getText();
                String lname = textLast.getText();
                String username = textUser.getText();
                String password = textPass.getText();
                String email = textEmail.getText();
                String phone = finalTextformatPhone.getText();
                String street = textStreet.getText();
                String city = textCity.getText();
                String postal = finaltextPostal.getText();
                String dob = finalTextDOBN.getText();
                String gender = (String) comboGender.getSelectedItem();


                if (textID.getText().trim().isEmpty() || textID.getText().trim().equals("Enter Employee ID") || 
                   (textID.getText().trim().equals("") || textID.getText().trim().equals("Enter First Name") ||
                   (textLast.getText().trim().equals("")) || textLast.getText().trim().equals("Enter Last Name") ||
                   (textUser.getText().trim().equals("")) || textUser.getText().trim().equals("Enter Username") ||
                   (textPass.getText().trim().equals("") || textPass.getText().trim().equals("Enter Password") ||
                   (textEmail.getText().trim().equals("") || textEmail.getText().trim().equals("Enter Email Address") ||
                   (finalTextformatPhone.getText().trim().equals("") || finalTextformatPhone.getText().trim().equals("Enter Phone number") ||
                   (textStreet.getText().trim().equals("") || textStreet.getText().trim().equals("Enter Street Address") ||
                   (textCity.getText().trim().equals("") || textCity.getText().trim().equals("Enter City") ||
                           (finaltextPostal.getText().trim().equals("") || finaltextPostal.getText().trim().equals("Enter Postal") ||
                   (finalTextDOBN.getText().trim().equals("") || finalTextDOBN.getText().trim().equals("Enter Date of Birth")))))))))) {

                    JOptionPane.showMessageDialog(null, "Please complete all fields", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else if (comboGender.getSelectedItem().toString().equals("")) {

                    JOptionPane.showConfirmDialog(null, "Please choose Gender!", "Error", JOptionPane.ERROR_MESSAGE);

                    // Check if user already registered
                } else {

                    try {

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection
                        Statement stm = connection.createStatement();

                        String selectQuery = ("SELECT emp_id, emp_username FROM emp_reg_tbl WHERE emp_id = '" + emp_id + "' AND emp_username = '" + username + "'");

                        ResultSet rs = stm.executeQuery(selectQuery);

                        if(rs.next()==true)

                        {
                            JOptionPane.showMessageDialog(null, "User already exists!", "ERROR", JOptionPane.DEFAULT_OPTION);

                        } else {
                            //Add records
                            String insertQuery = "INSERT INTO emp_reg_tbl(emp_id, emp_name, emp_surename, emp_username, emp_password, emp_email, emp_phone, emp_street, emp_city, emp_postal, emp_dob, emp_gender)" +
                                    "VALUES('" + textID.getText() + "', '" + textName.getText() + "', '" + textLast.getText() + "', '" + textUser.getText() + "', '" + textPass.getText() + "', '" +
                                    textEmail.getText() + "', '" + finalTextformatPhone.getText() + "', '" + textStreet.getText() + "', '" + textCity.getText() + "', '" + finaltextPostal.getText() + "', '" + finalTextDOBN.getText() + "', '" + comboGender.getSelectedItem() + "')";

                                stm.executeUpdate(insertQuery);
                                JOptionPane.showMessageDialog(null, "New User added successfully", "SUCCESS", JOptionPane.DEFAULT_OPTION);
                                frame.dispose();
                                new start_up_page();
                        }

                            connection.close();

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
        });

        // Add an ActionListener to CLEAR JButton
        JFormattedTextField finaltextPhone1 = finalTextformatPhone;
        JFormattedTextField finaltextPostal1 = textPostal;
        JFormattedTextField finalTextDOBN1 = textDOBN;
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                textID.setText("");
                textName.setText(" ");
                textLast.setText(" ");
                textUser.setText(" ");
                textPass.setText(" ");
                textEmail.setText(" ");
                finaltextPhone1.setText(" ");
                textStreet.setText(" ");
                textCity.setText(" ");
                finaltextPostal1.setText(" ");
                finalTextDOBN1.setText(" ");
                textID.setFocusable(true);
                comboGender.setSelectedIndex(0);

            }

        });

        // Add an ActionListener to CLOSE JButton
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == buttonClose) {
                    frame.dispose();
                    new start_up_page();
                }


            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
