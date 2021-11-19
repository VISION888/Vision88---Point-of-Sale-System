package packageVision88;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class Sales_reports extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel panelSales = new JPanel();        //Creates Panel

    JLabel labelTitle = new JLabel();
    JLabel labelLogo = new JLabel();
    JTextField tf = new JTextField();

    JButton buttongen = new JButton("Generate Report");
    JButton buttonClose = new JButton("Close");

    public Sales_reports() {

        ImageIcon image = new ImageIcon("Resources/Logopng_200px.png");

        Border borderSales = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SALES REPORT", TitledBorder.CENTER, TitledBorder.TOP);

        panelSales.setLayout(null);
        panelSales.setBorder(borderSales);
        panelSales.setBounds(310, 90, 830, 590);

        JScrollPane scrollPane = new JScrollPane(panelSales, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(600, 500));

        labelLogo.setBounds(100, 0, 200, 200);
        labelLogo.setIcon(image);

        labelTitle.setText("Report Generator");
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 50));
        labelTitle.setBounds(350, -60, 400, 200);

        tf.setText("1");
        tf.setFont(new Font("Arial", Font.PLAIN, 16));
        tf.setBounds(770, 30, 30, 30);
        tf.setEditable(false);
        tf.setBackground(Color.lightGray);

        buttongen.setBounds(840, 20, 160, 40);
        buttongen.setFont(new Font("Comic Sans", Font.BOLD, 16));
        buttongen.addActionListener(this);

        buttonClose.setBounds(1030, 20, 100, 40);
        buttonClose.setFont(new Font("Comic Sans", Font.BOLD, 16));
        buttonClose.addActionListener(this);

        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Welcome to Agri8 Retailers");
        frame.setIconImage(new ImageIcon("Resources/icon_iconpos.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1300, 750);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(191, 173, 220));

        //Screen Position
        frame.setLocationRelativeTo(null);

        frame.add(panelSales);
        frame.add(labelTitle);
        frame.add(labelLogo);
        frame.add(buttongen);
        frame.add(buttonClose);
        frame.add(tf);

        frame.setVisible(true);

        // Add an ActionListener to GENERATE JButton
        buttongen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                loadReport();

            }
        });

        // Add an ActionListener to BACK JButton
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonClose) {
                    frame.dispose();
                    new Main_page();

                }
            }
        });
    }



    public void loadReport() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posdatabase", "root", "root"); //Creates a Connection

            HashMap a = new HashMap();
            a.put("id_s", tf.getText());

            panelSales.removeAll();
            panelSales.repaint();
            panelSales.revalidate();

            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Point of Sale system\\src\\packageVision88\\POSalesA4.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, a, connection);
            JRViewer v = new JRViewer(jprint);
            panelSales.setLayout(new BorderLayout());
            panelSales.add(v);

            connection.close();

        } catch (ClassNotFoundException | SQLException | HeadlessException | JRException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}



