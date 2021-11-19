package packageVision88;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import net.proteanit.sql.DbUtils;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class Main_page extends JFrame implements ActionListener {

    JFrame frame = new JFrame();

    JTextField  tfsubtotal = new JTextField();
    JTextField  tfvat = new JTextField();
    JTextField  tftotal = new JTextField();
    JTextField  tfvalue = new JTextField();
    JTextField  tfchange = new JTextField();

    JTextField tf_p_sid = new JTextField();
    JTextField tf_p_sname = new JTextField();
    JTextField tf_p_sqty = new JTextField();
    JTextField tf_p_suprice = new JTextField();
    JTextField tf_p_stotal = new JTextField();

    TextArea txtbill = new TextArea();

    JButton buttonAdd = new JButton("ADD SALES");
    JButton buttonCalculate = new JButton("PRINT BILL");
    JButton buttonSearch = new JButton("SEARCH PRODUCT");
    JButton buttonQty = new JButton("Sub-total");
    JButton buttonDelete = new JButton("Delete");
    JButton buttonCust = new JButton("New Customer");

    final String[] columHeads = {"ID", "Product Name", "Unit Price", "Quantity", "Subtotal"};
    Object[][] data = {{"", "", "", "", ""}};

    JTable tablep = new JTable(data, columHeads) {
        public boolean isCellEditable(int data, int columHeads) {
            return false;
        }

    };

    public Main_page() {

        tablep.setPreferredScrollableViewportSize(new Dimension(820, 60));
        tablep.setFillsViewportHeight(true);

        //SCROLLPANE

        JScrollPane jsp = new JScrollPane(tablep);
        jsp.setBounds(330, 170, 650, 530);
        frame.add(jsp, BorderLayout.CENTER);

        ImageIcon image = new ImageIcon("Resources/Logopng_200px.png");
        ImageIcon imageBag = new ImageIcon("Resources/icons8-money-bag-40.png");
        ImageIcon imageTrolley = new ImageIcon("Resources/icons8-shopping-cart-48.png");
        ImageIcon imageLogout = new ImageIcon("Resources/icons8-shutdown-40.png");
        ImageIcon imageExit = new ImageIcon("Resources/icons8-exit-40.png");

        Border borderSales = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SALES", TitledBorder.CENTER, TitledBorder.TOP);
        Border borderReceipt = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "BILLING RECEIPT", TitledBorder.CENTER, TitledBorder.TOP);

        JLabel labelLogo = new JLabel();
        JLabel labelSubtitle1 = new JLabel();
        JLabel labelSubtitle2 = new JLabel();

        JLabel Product_sid = new JLabel();
        JLabel Product_sname = new JLabel();
        JLabel Product_sqty = new JLabel();
        JLabel Product_UPrice = new JLabel();
        JLabel Product_Stotal = new JLabel();

        JLabel subTotal = new JLabel();
        JLabel vat = new JLabel();
        JLabel total = new JLabel();
        JLabel value = new JLabel();
        JLabel change = new JLabel();

        JPanel panelleft = new JPanel();        //Creates Panel
        panelleft.setLayout(null);

        JPanel panelSales = new JPanel();
        panelSales.setLayout(null);
        panelSales.setBorder(borderSales);

        JPanel panelRight = new JPanel();
        panelRight.setLayout(null);
        panelRight.setBorder(borderReceipt);

        labelSubtitle1.setText("For all your Agricultural");
        labelSubtitle1.setFont(new Font("Arial", Font.ITALIC, 22));
        labelSubtitle1.setBounds(40, 230, 250, 30);
        labelSubtitle1.setForeground(new Color(250, 220, 113));

        labelSubtitle2.setText("needs");
        labelSubtitle2.setFont(new Font("Arial", Font.ITALIC, 22));
        labelSubtitle2.setBounds(120, 260, 250, 30);
        labelSubtitle2.setForeground(new Color(250, 220, 113));

        Product_sid.setText("Product ID: ");
        Product_sname.setText("Product Name: ");
        Product_sqty.setText("Qty: ");
        Product_UPrice.setText("Unit Price: ");
        Product_Stotal.setText("Sub-Total: ");

        subTotal.setText("Subtotal:");
        vat.setText("Vat: 15%");
        total.setText("Total:");
        value.setText("Amount:");
        change.setText("Cust change:");

        subTotal.setFont(new Font("Arial", Font.BOLD, 18));
        vat.setFont(new Font("Arial", Font.BOLD, 18));
        total.setFont(new Font("Arial", Font.BOLD, 18));
        value.setFont(new Font("Arial", Font.BOLD, 18));
        change.setFont(new Font("Arial", Font.BOLD, 18));

        tfsubtotal.setFont(new Font("Arial", Font.BOLD, 16));
        tfvat.setFont(new Font("Arial", Font.PLAIN, 16));
        tftotal.setFont(new Font("Arial", Font.BOLD, 16));
        tfvalue.setFont(new Font("Arial", Font.PLAIN, 16));
        tfchange.setFont(new Font("Arial", Font.PLAIN, 16));

        Product_sid.setFont(new Font("Arial", Font.BOLD, 18));
        Product_sname.setFont(new Font("Arial", Font.BOLD, 18));
        Product_sqty.setFont(new Font("Arial", Font.BOLD, 18));
        Product_UPrice.setFont(new Font("Arial", Font.BOLD, 18));
        Product_Stotal.setFont(new Font("Arial", Font.BOLD, 18));

        tf_p_sid.setFont(new Font("Arial", Font.PLAIN, 14));
        tf_p_sname.setFont(new Font("Arial", Font.PLAIN, 14));
        tf_p_suprice.setFont(new Font("Arial", Font.PLAIN, 14));
        tf_p_stotal.setFont(new Font("Arial", Font.PLAIN, 14));

        labelLogo.setBounds(50, 30, 200, 200);
        Product_sid.setBounds(10, 20, 150, 30);
        Product_sname.setBounds(130, 20, 150, 30);
        Product_UPrice.setBounds(300, 20, 150, 30);
        Product_sqty.setBounds(440, 20, 150, 30);
        Product_Stotal.setBounds(500, 20, 150, 30);

        tf_p_sid.setBounds(10, 60, 100, 30);
        tf_p_sname.setBounds(130, 60, 150, 30);
        tf_p_suprice.setBounds(300, 60, 120, 30);
        tf_p_sqty.setBounds(440, 60, 40, 30);
        tf_p_stotal.setBounds(500, 60, 130, 30);

        subTotal.setBounds(10, 30, 130, 30);
        vat.setBounds(10, 70, 130, 30);
        total.setBounds(10, 110, 130, 30);
        value.setBounds(10, 150, 130, 30);
        change.setBounds(10, 190, 130, 30);

        tfsubtotal.setBounds(140, 30, 170, 25);
        tfvat.setBounds(140, 70, 170, 25);
        tftotal.setBounds(140, 110, 170, 25);
        tfvalue.setBounds(140, 150, 170, 25);
        tfchange.setBounds(140, 190, 170, 25);

        txtbill.setBounds(990, 320, 340, 380);
        txtbill.setEnabled(false);

        tf_p_suprice.setEditable(false);
        tf_p_suprice.setBackground(Color.LIGHT_GRAY);
        tftotal.setBackground(new Color(250, 220, 113));
        tf_p_stotal.setEditable(false);
        tf_p_stotal.setBackground(new Color(250, 220, 113));
        tfsubtotal.setEditable(false);
        tfvat.setEditable(false);
        tftotal.setEditable(false);
        tfchange.setEditable(false);

        tfsubtotal.setBackground(Color.lightGray);
        tfvat.setBackground(Color.lightGray);
        tfsubtotal.setBackground(Color.lightGray);
        tfchange.setBackground(Color.lightGray);

        labelLogo.setIcon(image);

        JButton buttonInventory = new JButton("Inventory", imageTrolley);
        JButton buttonReport = new JButton("Sales Reports", imageBag);
        JButton buttonLogout = new JButton("Logout", imageLogout);
        JButton buttonExit = new JButton("Exit", imageExit);

        panelleft.setBounds(0, 0, 320, 750);
        panelSales.setBounds(330, 10, 650, 150);
        panelRight.setBounds(990, 10, 340, 300);

        buttonInventory.setBounds(50, 300, 200, 50);
        buttonReport.setBounds(50, 400, 200, 50);
        buttonLogout.setBounds(50, 500, 200, 50);
        buttonExit.setBounds(50, 600, 200, 50);
        buttonAdd.setBounds(500, 100, 130, 40);
        buttonSearch.setBounds(150, 100, 140, 40);
        buttonDelete.setBounds(300,100,80,40);
        buttonQty.setBounds(390, 100, 100, 40);
        buttonCust.setBounds(10, 100, 130, 40);
        buttonCalculate.setBounds(60, 240, 200, 40);    //BILL PRINT

        buttonInventory.setFont(new Font("Comic Sans", Font.BOLD, 16));
        buttonReport.setFont(new Font("Comic Sans", Font.BOLD, 16));
        buttonLogout.setFont(new Font("Comic Sans", Font.BOLD, 16));
        buttonExit.setFont(new Font("Comic Sans", Font.BOLD, 16));
        buttonAdd.setFont(new Font("Comic Sans", Font.BOLD, 16));
        buttonCalculate.setFont(new Font("Comic Sans", Font.BOLD, 14));
        buttonQty.setFont(new Font("Comic Sans", Font.BOLD, 14));
        buttonDelete.setFont(new Font("Comic Sans", Font.BOLD, 14));
        buttonCust.setFont(new Font("Comic Sans", Font.BOLD, 12));

        buttonInventory.setBorder(BorderFactory.createEtchedBorder());
        buttonReport.setBorder(BorderFactory.createEtchedBorder());
        buttonLogout.setBorder(BorderFactory.createEtchedBorder());
        buttonExit.setBorder(BorderFactory.createEtchedBorder());

        buttonInventory.setBackground(new Color(61, 196, 130));
        buttonReport.setBackground(new Color(61, 196, 130));
        buttonLogout.setBackground(new Color(61, 196, 130));
        buttonExit.setBackground(new Color(61, 196, 130));
        panelleft.setBackground(new Color(205, 155, 255));
        panelSales.setBackground(new Color(205, 155, 255));

        buttonExit.setForeground(Color.white);

        tf_p_sid.setFocusable(true);
        tf_p_sid.setBackground(new Color(250, 220, 113));
        buttonInventory.addActionListener(this);
        buttonInventory.setFocusable(false);
        buttonReport.setFocusable(false);
        buttonExit.setFocusable(false);
        buttonReport.addActionListener(this);
        buttonLogout.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonSearch.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonQty.addActionListener(this);
        buttonCust.addActionListener(this);
        buttonCust.setEnabled(false);
        buttonAdd.setEnabled(false);
        buttonQty.setEnabled(false);
        buttonDelete.addActionListener(this);
        buttonAdd.setBackground(Color.GRAY);
        buttonAdd.setForeground(Color.WHITE);

        tf_p_sid.setFocusable(true);

        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Welcome to Agri8 Retailers");
        frame.setIconImage(new ImageIcon("Resources/icon_iconpos.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1350, 750);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(202, 242, 241));

        //Screen Position
        frame.setLocationRelativeTo(null);

        frame.add(panelleft);
        frame.add(panelSales);
        frame.add(panelRight);
        frame.add(txtbill);
        panelRight.add(subTotal);
        panelRight.add(vat);
        panelRight.add(total);
        panelRight.add(value);
        panelRight.add(change);
        panelRight.add(tfsubtotal);
        panelRight.add(tfvat);
        panelRight.add(tftotal);
        panelRight.add(tfvalue);
        panelRight.add(tfchange);
        panelRight.add(buttonCalculate);
        panelSales.add(buttonSearch);
        panelSales.add(buttonAdd);
        panelSales.add(buttonQty);
        panelSales.add(Product_sid);
        panelSales.add(Product_sname);
        panelSales.add(Product_UPrice);
        panelSales.add(Product_sqty);
        panelSales.add(Product_Stotal);
        panelSales.add(buttonDelete);
        panelSales.add(tf_p_sid);
        panelSales.add(tf_p_sname);
        panelSales.add(tf_p_suprice);
        panelSales.add(tf_p_sqty);
        panelSales.add(tf_p_stotal);
        panelSales.add(buttonCust);
        panelleft.add(labelSubtitle1);
        panelleft.add(labelSubtitle2);
        panelleft.add(labelLogo);
        panelleft.add(buttonInventory);
        panelleft.add(buttonReport);
        panelleft.add(buttonLogout);
        panelleft.add(buttonExit);

        frame.setVisible(true);

        // Add an ActionListener to Search Products JButton
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String pcode = tf_p_sid.getText();
                writeBarcode();

                //Open Connection
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection
                    PreparedStatement pst = connection.prepareStatement("SELECT p_id, p_name, p_sell, p_barcode FROM inv_tbl WHERE p_id = ? OR p_barcode = ? ");
                    pst.setString(1, pcode);
                    pst.setString(2, pcode);
                    ResultSet rs = pst.executeQuery();

                    if (!rs.next()) {

                        JOptionPane.showMessageDialog(null, "Product not found!", "OUT OF STOCK", JOptionPane.DEFAULT_OPTION);

                    } else {

                        String pname = rs.getString("p_name");
                        tf_p_sname.setText(pname.trim());

                        String price = rs.getString("p_sell");
                        tf_p_suprice.setText(price.trim());

                        tf_p_sqty.requestFocus();
                        tf_p_sqty.setBackground((new Color(250, 220, 113)));
                        tf_p_sid.setBackground(Color.WHITE);

                        buttonQty.setEnabled(true);

                    }

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });

        // Add an ActionListener to SUB-TOTAL JButton
        buttonQty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String quantity = tf_p_sid.getText();

                if(quantity.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please add Quantity!");

                } else {

                    calqty();

                    buttonAdd.setEnabled(true);
                    buttonAdd.setBackground((new Color(250, 220, 113)));
                    buttonAdd.setForeground(Color.BLACK);
                }
            }
        });


        // Add an ActionListener to Add JButton
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String id = tf_p_sid.getText();
                String name = tf_p_sname.getText();
                String price = tf_p_suprice.getText();
                String qty = tf_p_sqty.getText();
                String subtotal = tf_p_stotal.getText();

                if (tf_p_sid.getText().trim().isEmpty() || (tf_p_sname.getText().trim().isEmpty() ||
                        (tf_p_suprice.getText().trim().isEmpty() || (tf_p_sqty.getText().trim().isEmpty() || (tf_p_stotal.getText().trim().isEmpty()))))) {

                    JOptionPane.showConfirmDialog(null, "Please enter all Fields!", "Error", JOptionPane.DEFAULT_OPTION);

                } else {

                    try {

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection

                        //Add records
                        PreparedStatement pst = connection.prepareStatement("INSERT INTO sales_report_tbl(p_id, p_name, p_uprice, p_qty, p_stotal)VALUES(?, ?, ?, ?, ?)");
                        pst.setString(1, id);
                        pst.setString(2, name);
                        pst.setString(3, price);
                        pst.setString(4, qty);
                        pst.setString(5, subtotal);

                        pst.executeUpdate();

                        //Add records
                        PreparedStatement pps = connection.prepareStatement("INSERT INTO s_report_tbl(s_id, s_name, s_uprice, s_qty, s_stotal)VALUES(?, ?, ?, ?, ?)");
                        pps.setString(1, id);
                        pps.setString(2, name);
                        pps.setString(3, price);
                        pps.setString(4, qty);
                        pps.setString(5, subtotal);

                        pps.executeUpdate();

                        showTable();

                        int sum = 0;

                        for (int i = 0; i < tablep.getRowCount(); i++) {

                            sum = sum + Integer.parseInt(tablep.getValueAt(i, 4).toString());

                            tfsubtotal.setText(Integer.toString(sum));
                            grandTotal();

                        }
                        tf_p_sid.setText("");
                        tf_p_sname.setText("");
                        tf_p_sqty.setText("");
                        tf_p_suprice.setText("");
                        tf_p_stotal.setText("");

                        tf_p_sid.setFocusable(true);
                        connection.close();

                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            }
        });

        // Add an ActionListener to DELETE JButton
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String id = tf_p_sid.getText();

                if(id.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please Enter Product code", "ERROR", JOptionPane.DEFAULT_OPTION);

                } else {

                    try {

                        //Establish / Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection

                        String query = "DELETE FROM sales_report_tbl WHERE p_id= ? ";

                        PreparedStatement stm = connection.prepareStatement(query);

                        stm.setString(1, tf_p_sid.getText());

                        stm.executeUpdate();
                        showTable();

                        JOptionPane.showMessageDialog(null, "Deleted Successfully", "SUCCESS", JOptionPane.DEFAULT_OPTION);

                        tf_p_sid.setText("");
                        tf_p_sname.setText("");
                        tf_p_suprice.setText("");
                        tf_p_sqty.setText("");
                        tf_p_stotal.setText("");

                        stm.close();
                        connection.close();

                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            }
        });

        // Add an ActionListener to Calculate JButton
        buttonCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

               BigTotal();
                bill();

                buttonSearch.setEnabled(false);
                buttonDelete.setEnabled(false);
                buttonQty.setEnabled(false);
                buttonAdd.setEnabled(false);
                buttonCalculate.setEnabled(false);
                buttonCust.setEnabled(true);

                try {

                    //Establish / Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection
                    Statement stm = connection.createStatement();

                    String query = "DELETE FROM sales_report_tbl";

                    stm.executeUpdate(query);

                    showTable();
                    stm.close();
                    connection.close();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }

            }
        });

        // Add an ActionListener to Calculate JButton
        buttonCust.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                buttonSearch.setEnabled(true);
                buttonDelete.setEnabled(true);
                buttonQty.setEnabled(true);
                buttonAdd.setEnabled(true);
                buttonCalculate.setEnabled(true);
                buttonCust.setEnabled(false);
                txtbill.setText("");
                tfsubtotal.setText("");
                tfvat.setText("");
                tftotal.setText("");
                tfvalue.setText("");
                tfchange.setText("");


            }
        });


        // Add an ActionListener to INVENTORY JButton
        buttonInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonInventory) {
                    frame.dispose();
                    new Stock_info();

                }
            }
        });

        // Add an ActionListener to Sales Report JButton
        buttonReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonReport) {
                    frame.dispose();
                    new Sales_reports();
                }
            }
        });


        // Add an ActionListener to LOGOUT JButton
        buttonLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonLogout) {
                    frame.dispose();
                    new start_up_page();
                }
            }
        });

        // Add an ActionListener to the Exit JButton
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                // Exit Button
                int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Select", JOptionPane.YES_NO_OPTION);

                if (exit == 0) System.exit(0);

            }
        });
    }


        @Override
        public void actionPerformed(ActionEvent e) {


        }

        public void calqty () {

                int qty = Integer.parseInt(tf_p_sqty.getText());
                int uprice = Integer.parseInt(tf_p_suprice.getText());

                String subtotal = String.valueOf(qty * uprice);
                tf_p_stotal.setText(subtotal);
            }

        public void grandTotal() {

             int subtotal = Integer.parseInt(tfsubtotal.getText());
             int tax = 15;

             int vatTotal = (subtotal * tax )/ 100;
            String taxTotal = String.valueOf(vatTotal);
            tfvat.setText(taxTotal);

            int vat = Integer.parseInt(tfvat.getText());
            int total = (subtotal + vat );

            String grandTotal = String.valueOf(total);
            tftotal.setText(grandTotal);

            }

        public void BigTotal() {

            int total = Integer.parseInt(tftotal.getText());
            int value = Integer.parseInt(tfvalue.getText());

            String change = String.valueOf(value - total);
            tfchange.setText(change);

        }

        public void bill() {

        String Subtotal = tfsubtotal.getText();
        String Vat = tfvat.getText();
        String Total = tftotal.getText();
        String Value = tfvalue.getText();
        String Change = tfchange.getText();

        txtbill.setEnabled(true);
        txtbill.append( "*************************************************** \n" +
                "\t***** AGRI8 SALES RECEIPT *****\n" +
                "\n*********************************************************\t" +
                "\n" +
                "\n*********************************************************\t" +
                "\n" +
                "\n Sub-Total:\t\t\t\t" + "R " + Subtotal + ".00" +
                "\n" +
                "\n Vat 15%:\t\t\t\t" + "R " + Vat + ".00" +
                "\n" +
                "\n Total:\t\t\t\t\t" + "R " + Total + ".00" +
                "\n" +
                "\n Amount:\t\t\t\t" + "R " + Value + ".00" +
                "\n" +
                "\n Change:\t\t\t\t" + "R "+ Change + ".00" +
                "\n" +
                "\n**********************************************************\t" +
                "\n\tThank you for shopping at AGRI8 Retailers\n");

        }

        public void writeBarcode() {

            String product_id = tf_p_sid.getText();
            try {

                InputStream barInputStream = new FileInputStream(product_id);
                BufferedImage barBufferedImage = ImageIO.read(barInputStream);
                LuminanceSource source = new BufferedImageLuminanceSource(barBufferedImage);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Reader reader = new MultiFormatReader();
                Result result = reader.decode(bitmap);
                tf_p_sid.setText(result.getText());


            } catch (IOException | NotFoundException | ChecksumException | FormatException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }
        }

        public void showTable() {

                try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection
                Statement stm = connection.createStatement();

                String tableQuery = "SELECT p_id, p_name, p_uprice, p_qty, p_stotal FROM sales_report_tbl";

                ResultSet rs = stm.executeQuery(tableQuery);

                tablep.setModel(DbUtils.resultSetToTableModel(rs));

                tablep.getColumn("p_id").setHeaderValue("ID");
                tablep.getColumn("p_name").setHeaderValue("Product Name");
                tablep.getColumn("p_uprice").setHeaderValue("Unit Price");
                tablep.getColumn("p_qty").setHeaderValue("Qty");
                tablep.getColumn("p_stotal").setHeaderValue("Sub-total");

                tablep.repaint();
                stm.close();
                rs.close();
                connection.close();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
            }
        }
}




