package packageVision88;

import com.barcodelib.barcode.Linear;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Stock_info extends JFrame implements ActionListener{

    JFrame frame = new JFrame();
    JComboBox comboCategory = new JComboBox();
    JButton buttonBarcode = new JButton("Generate");
    JTextField tfID = new JTextField();
    JTextField tfBarcode = new JTextField();

    final String[] columHeads = {"ID", "Product Name", "Category", "Quantity", "Buy Price", "Sell Price", "Barcode"};
    Object[][] data = {{"", "", "", "", "", "", ""}};

    JTable tablep = new JTable(data, columHeads) {
        public boolean isCellEditable(int data, int columHeads) {
            return false;
        }
    };

    public Stock_info() {

        ImageIcon imageTitle = new ImageIcon("Resources/icons8-shopping-cart-48.png");

        JButton buttonAdd = new JButton("Add");
        JButton buttonUpdate = new JButton("Update");
        JButton buttonDelete = new JButton("Delete");
        JButton buttonClear = new JButton("Clear");
        JButton buttonBack = new JButton("Back");
        JButton buttonSearch = new JButton("Search");

        Border borderPatient = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PRODUCT INFORMATION", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSS = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SEARCH PRODUCT", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSearch = BorderFactory.createEtchedBorder();

        JPanel panelS = new JPanel();
        JPanel panelSS = new JPanel();
        JPanel panelBarcode = new JPanel();
        panelS.setLayout(null);
        panelSS.setLayout(null);
        panelBarcode.setLayout(null);

        JTextField textFieldSearch = new JTextField();
        JTextField textFieldPName = new JTextField();
        JTextField textFieldBarcode = new JTextField();
        JTextField textFieldProduct = new JTextField();
        JTextField textFieldQty = new JTextField();

        JTextField textFieldBuy = new JTextField();
        JTextField textFieldSell = new JTextField();

        tablep.setPreferredScrollableViewportSize(new Dimension(820, 60));
        tablep.setFillsViewportHeight(true);

        //SCROLLPANE

        JScrollPane jsp = new JScrollPane(tablep);
        jsp.setBounds(80, 300, 890, 260);
        panelS.add(jsp, BorderLayout.CENTER);

        JLabel labelSearch = new JLabel();
        JLabel labelor = new JLabel();
        JLabel labelProduct = new JLabel();
        JLabel labelName = new JLabel();
        JLabel labelBarcode = new JLabel();
        JLabel labelPName = new JLabel();
        JLabel labelCategory = new JLabel();
        JLabel labelBuy = new JLabel();
        JLabel labelSell = new JLabel();
        JLabel labelQty = new JLabel();
        JLabel labelBcode = new JLabel();
        JLabel labelBID = new JLabel();

        JLabel labelH = new JLabel();                                                        //Initialize Label

        labelH.setText("Inventory System");
        labelSearch.setText("Product ID: ");
        labelor.setText("AND");
        labelProduct.setText("Product Name: ");
        labelName.setText("Product Name: ");
        labelBarcode.setText("Product ID: ");
        labelBID.setText("Product ID:");
        labelBcode.setText("Generate Barcode:");
        labelPName.setText("Product Name:");
        labelCategory.setText("Category: ");
        labelBuy.setText("Buy Price: ");
        labelSell.setText("Sell Price: ");
        labelQty.setText("Quantity: ");

        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));                  //Header Font and Size
        labelSearch.setFont(new Font("Arial", Font.BOLD, 18));
        labelBarcode.setFont(new Font("Arial", Font.BOLD, 18));
        labelor.setFont(new Font("Arial", Font.BOLD, 18));
        labelProduct.setFont(new Font("Arial", Font.BOLD, 18));
        labelPName.setFont(new Font("Arial", Font.BOLD, 18));
        labelCategory.setFont(new Font("Arial", Font.BOLD, 18));
        labelBuy.setFont(new Font("Arial", Font.BOLD, 18));
        labelSell.setFont(new Font("Arial", Font.BOLD, 18));
        labelQty.setFont(new Font("Arial", Font.BOLD, 18));
        labelBID.setFont(new Font("Arial", Font.BOLD, 16));
        labelBcode.setFont(new Font("Arial", Font.BOLD, 16));

        textFieldSearch.setFont(new Font("Arial", Font.BOLD, 18));               //Search Product ID text area Font and Size
        textFieldPName.setFont(new Font("Arial", Font.BOLD, 18));
        textFieldBarcode.setFont(new Font("Arial", Font.BOLD, 18));               //Search Product ID text area Font and Size
        textFieldProduct.setFont(new Font("Arial", Font.BOLD, 18));
        textFieldBuy.setFont(new Font("Arial", Font.BOLD, 18));               //Search Product ID text area Font and Size
        textFieldSell.setFont(new Font("Arial", Font.BOLD, 18));
        comboCategory.setFont(new Font("Arial", Font.BOLD, 18));               //Search Product ID text area Font and Size
        textFieldQty.setFont(new Font("Arial", Font.BOLD, 18));
        tfID.setFont(new Font("Arial", Font.BOLD, 18));
        tfBarcode.setFont(new Font("Arial", Font.BOLD, 18));

        tablep.setFont(new Font("Arial", Font.PLAIN, 12));

        labelH.setBounds(300, -50, 1000, 200);                                //Set Header Bounds
        panelS.setBounds(50, 100, 1050, 600);                                  //Set Panel Bounds
        panelSS.setBounds(70, 30, 910, 60);
        panelBarcode.setBounds(220,240,630,50);
        panelBarcode.setBackground(new Color(205, 155, 255));
        panelSS.setBackground(new Color(205, 155, 255));
        panelSS.setBorder(borderSS);
        panelBarcode.setBorder(borderSearch);

        labelSearch.setBounds(20, 18, 150, 25);
        labelor.setBounds(360, 15, 250, 30);
        labelProduct.setBounds(430, 15, 250, 30);

        labelBarcode.setBounds(80, 120, 200, 30);
        labelPName.setBounds(80, 160, 200, 30);
        labelCategory.setBounds(80, 200, 200, 30);

        textFieldBarcode.setBounds(220, 120, 200, 25);
        textFieldProduct.setBounds(220, 160, 200, 25);
        comboCategory.setBounds(220, 200, 200, 25);


        labelQty.setBounds(540, 120, 200, 25);
        labelBuy.setBounds(540, 160, 200, 25);
        labelSell.setBounds(540, 200, 200, 25);

        textFieldQty.setBounds(650, 120, 200, 25);
        textFieldBuy.setBounds(650, 160, 200, 25);
        textFieldSell.setBounds(650, 200, 200, 25);

        labelBID.setBounds(10,10,150,25);
        tfID.setBounds(100,10,50,25);
        labelBcode.setBounds(160,10,200,25);
        tfBarcode.setBounds(310,10,180,25);

        textFieldSearch.setBounds(130, 13, 200, 25);
        textFieldPName.setBounds(570, 13, 200, 25);

        tablep.setBounds(100, 130, 820, 30);                                 //JTable

        panelS.setBorder(borderPatient);

        labelH.setIcon(imageTitle);
        labelH.setIconTextGap(30);

        comboCategory.addItem("");
        comboCategory.addItem("Animal Feeds");
        comboCategory.addItem("Animal Health");
        comboCategory.addItem("Clothing Goods");
        comboCategory.addItem("Construction Goods");
        comboCategory.addItem("Garden Goods");
        comboCategory.addItem("Hardware Goods");
        comboCategory.addItem("Miscellaneous");
        comboCategory.addItem("Painting Goods");

        buttonAdd.setFont(new Font("Arial", Font.BOLD, 18));
        buttonUpdate.setFont(new Font("Arial", Font.BOLD, 18));
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 18));
        buttonClear.setFont(new Font("Arial", Font.BOLD, 18));
        buttonBack.setFont(new Font("Arial", Font.BOLD, 18));
        buttonSearch.setFont(new Font("Arial", Font.BOLD, 16));
        buttonBarcode.setFont(new Font("Arial", Font.BOLD, 12));

        buttonSearch.setBounds(790, 10, 100, 40);
        buttonAdd.setBounds(1120, 110, 100, 50);
        buttonUpdate.setBounds(1120, 210, 100, 50);
        buttonDelete.setBounds(1120, 310, 100, 50);
        buttonClear.setBounds(1120, 410, 100, 50);
        buttonBack.setBounds(1120, 510, 100, 50);
        buttonBarcode.setBounds(500,10,110,30);

        buttonAdd.setFocusable(false);
        buttonBack.setFocusable(false);
        buttonUpdate.setFocusable(false);
        buttonDelete.setFocusable(false);
        buttonClear.setFocusable(false);

        buttonSearch.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonUpdate.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonClear.addActionListener(this);

        showTable();

        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Welcome to Agri8 Retailers");
        frame.setIconImage(new ImageIcon("Resources/icon_iconpos.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1250, 750);
        frame.setResizable(false);

        labelor.setForeground(Color.WHITE);
        frame.getContentPane().setBackground(new Color(61, 196, 130));

        //Screen Position
        frame.setLocationRelativeTo(null);

        panelSS.add(labelSearch);
        panelSS.add(labelor);
        panelSS.add(labelProduct);
        panelSS.add(textFieldSearch);                   //Inner Panel and components
        panelSS.add(textFieldPName);
        panelSS.add(buttonSearch);
        panelS.add(labelBarcode);
        panelS.add(labelPName);
        panelS.add(labelCategory);
        panelS.add(labelBuy);
        panelS.add(labelSell);
        panelS.add(labelQty);
        panelS.add(comboCategory);
        panelS.add(textFieldProduct);
        panelS.add(textFieldBarcode);
        panelS.add(textFieldQty);
        panelS.add(textFieldBuy);
        panelS.add(textFieldSell);
        panelBarcode.add(labelBID);
        panelBarcode.add(labelBcode);
        panelBarcode.add(tfID);
        panelBarcode.add(tfBarcode);
        panelBarcode.add(buttonBarcode);
        panelS.add(panelSS);
        panelS.add(panelBarcode);
        frame.add(panelS);
        frame.add(buttonAdd);
        frame.add(buttonBack);
        frame.add(buttonUpdate);
        frame.add(buttonDelete);
        frame.add(buttonClear);
        frame.add(labelH);
        frame.setVisible(true);

        // Add an ActionListener to SEARCH JButton
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String id_record = textFieldSearch.getText();
                String product = textFieldPName.getText();

                if (id_record.trim().isEmpty() && product.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please enter both Product ID and Product Name!", "ERROR", JOptionPane.DEFAULT_OPTION);

                } else {

                    try {

                        //Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection

                        String query = "SELECT * FROM inv_tbl WHERE p_id = ? AND p_name = ?";

                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, id_record);
                        statement.setString(2, product);

                        //Executing Query
                        ResultSet rs = statement.executeQuery();

                        if (rs.next()) {

                            String s = rs.getString(1);
                            String s1 = rs.getString(2);
                            String s2 = rs.getString(3);
                            String s3 = rs.getString(4);
                            String s4 = rs.getString(5);
                            String s5 = rs.getString(6);


                            textFieldBarcode.setText(s);
                            textFieldProduct.setText(s1);
                            comboCategory.setSelectedItem(s2);
                            textFieldQty.setText(s3);
                            textFieldBuy.setText(s4);
                            textFieldSell.setText(s5);


                            textFieldSearch.setEditable(false);
                            textFieldSearch.setFocusable(false);

                            textFieldPName.setEditable(false);
                            textFieldPName.setFocusable(false);

                            textFieldSearch.setBackground(Color.GRAY);
                            textFieldPName.setBackground(Color.GRAY);

                            textFieldSearch.setForeground(Color.WHITE);
                            textFieldPName.setForeground(Color.WHITE);

                            connection.close();

                        }

                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
        });


        // Add an ActionListener to ADD JButton
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                    String p_id = textFieldBarcode.getText();
                    String p_product = textFieldProduct.getText();
                    String p_category = (String) comboCategory.getSelectedItem();
                    String p_qty = textFieldQty.getText();
                    String p_buy = textFieldBuy.getText();
                    String p_sell = textFieldSell.getText();

                   if (comboCategory.getSelectedItem().toString().equals("") ||
                        (textFieldBarcode.getText().trim().isEmpty()) ||
                        (textFieldProduct.getText().trim().isEmpty()) ||
                        (textFieldQty.getText().trim().isEmpty()) ||
                        (textFieldBuy.getText().trim().isEmpty()) ||
                        (textFieldSell.getText().trim().isEmpty()))

                        JOptionPane.showConfirmDialog(null, "Please choose product Category!", "Error", JOptionPane.DEFAULT_OPTION);

                    {

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection
                            Statement stm = connection.createStatement();

                            String selectQuery = ("SELECT p_id, p_name, p_category FROM inv_tbl WHERE p_id = '" + p_id + "' AND p_name = '" + p_product + "'");

                            ResultSet rs = stm.executeQuery(selectQuery);

                            if (rs.next() == true) {
                                JOptionPane.showMessageDialog(null, "Product already listed!", "ERROR", JOptionPane.DEFAULT_OPTION);

                            } else {

                                //Add records
                               PreparedStatement pst  = connection.prepareStatement( "INSERT INTO inv_tbl(p_id, p_name, p_category, p_qty, p_buy, p_sell)VALUES(?, ?, ?, ?, ?, ?)");
                               pst.setString(1, p_id);
                               pst.setString(2, p_product);
                               pst.setString(3, p_category);
                               pst.setString(4, p_qty);
                               pst.setString(5, p_buy);
                               pst.setString(6, p_sell);

                                pst.executeUpdate();

                                textFieldBarcode.setText("");
                                textFieldProduct.setText("");
                                textFieldQty.setText("");
                                textFieldBuy.setText("");
                                textFieldSell.setText("");
                                comboCategory.setSelectedIndex(0);

                                JOptionPane.showMessageDialog(null, "New Product Added!", "SUCCESS", JOptionPane.DEFAULT_OPTION);
                                showTable();
                                textFieldBarcode.setFocusable(true);
                            }
                            connection.close();

                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                        }
                    }
                }
            });

        // Add an ActionListener to the UPDATE JButton
        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                try {
                    String id = textFieldSearch.getText();
                    String barcode = textFieldBarcode.getText();
                    String productName = textFieldProduct.getText();
                    String quantity = textFieldQty.getText();
                    String buy = textFieldBuy.getText();
                    String sell = textFieldSell.getText();
                    String category = (String) comboCategory.getSelectedItem();

                    //Establish / Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection

                    String query = "UPDATE inv_tbl SET " + "p_id ='" + barcode + "', p_name = '" + productName + "', p_qty = '" + quantity + "', p_buy = '" + buy + "', p_sell  = '"
                            + sell + "', p_category = '" + category + "'" + " WHERE p_id= '" + id + "'";

                    PreparedStatement statement = connection.prepareStatement(query);

                    statement.executeUpdate();

                    JOptionPane.showMessageDialog(null, " Product " + id + " was successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);

                    textFieldSearch.setEditable(false);
                    textFieldSearch.setFocusable(false);

                    textFieldSearch.setText("");
                    textFieldPName.setText("");
                    textFieldBarcode.setText("");
                    textFieldProduct.setText("");
                    textFieldQty.setText("");
                    textFieldBuy.setText("");
                    textFieldSell.setText("");
                    comboCategory.setSelectedIndex(0);

                    textFieldSearch.setBackground(Color.WHITE);
                    textFieldPName.setBackground(Color.WHITE);
                    textFieldSearch.setEditable(true);
                    textFieldPName.setEditable(true);
                    textFieldSearch.setFocusable(true);


                    connection.close();
                    showTable();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });


        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String product_id = textFieldSearch.getText();
                String product_name = textFieldPName.getText();

                if (product_id.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please enter Product ID delete!", "ERROR", JOptionPane.DEFAULT_OPTION);

                } else {

                    try {

                        //Establish / Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection

                        String query = "DELETE FROM inv_tbl WHERE p_id= ?  ";

                        PreparedStatement stm = connection.prepareStatement(query);

                        stm.setString(1, textFieldSearch.getText());

                        stm.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Deleted Successfully", "SUCCESS", JOptionPane.DEFAULT_OPTION);

                        textFieldBarcode.setText("");
                        textFieldProduct.setText("");
                        textFieldQty.setText("");
                        textFieldBuy.setText("");
                        textFieldSell.setText("");
                        comboCategory.setSelectedIndex(0);
                        showTable();
                        stm.close();
                        connection.close();

                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                //Establish / Open Connection


                textFieldBarcode.setText("");
                textFieldProduct.setText("");
                textFieldQty.setText("");
                textFieldBuy.setText("");
                textFieldSell.setText("");
                comboCategory.setSelectedIndex(0);

                }
            });

        // Add an ActionListener to BACK JButton
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonBack) {
                    frame.dispose();
                    new Main_page();

                }
            }
        });

        // Add an ActionListener to BACK JButton
        buttonBarcode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                try {

                    writeBarcode();

                } catch (Exception e) {

                    e.printStackTrace();
                }

            }
        });
    }




    public void writeBarcode() throws Exception {

        Linear barcode = new Linear();
        barcode.setType(Linear.CODE128B);
        barcode.setData(tfBarcode.getText());
        barcode.setI(11.0f);

        String fname = tfBarcode.getText();
        String id = tfID.getText();

        barcode.renderBarcode("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Point of Sale system\\Resources" + fname + ".png");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection

            String query = "UPDATE inv_tbl SET " + "p_barcode ='" + fname + "'" + " WHERE p_id= '" + id + "'";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Barcode Generated", "NEW BARCODE", JOptionPane.DEFAULT_OPTION);

        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

        }
    }

    public void showTable() {

        try {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection
        Statement stm = connection.createStatement();

        String tableQuery = "SELECT * FROM inv_tbl";

        ResultSet rs = stm.executeQuery(tableQuery);

        tablep.setModel(DbUtils.resultSetToTableModel(rs));

        tablep.getColumn("p_id").setHeaderValue("Barcode");
        tablep.getColumn("p_name").setHeaderValue("Product Name");
        tablep.getColumn("p_category").setHeaderValue("Category");
        tablep.getColumn("p_qty").setHeaderValue("Quantity");
        tablep.getColumn("p_buy").setHeaderValue("Bought Price");
        tablep.getColumn("p_sell").setHeaderValue("Sell Price");
        tablep.getColumn("p_barcode").setHeaderValue("Barcode");

        tablep.repaint();
        stm.close();
        rs.close();
        connection.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
