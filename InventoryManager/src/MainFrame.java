import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JButton searchButton;
    private JButton insertButton;
    private JButton extraButton;
    private JTable table1;
    Connection connection;

    public MainFrame() {

        setTitle("Welcome");
        setSize(600,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        JPanel cards = new JPanel(new CardLayout());


        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible();

    }



    public void setMainFrame() throws SQLException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setContentPane(mainPanel);
        mainFrame.setTitle("Form Inventory");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectinventory", "root", "rootWIN123!");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from clients");
        ResultSetMetaData rsmd = resultSet.getMetaData();

        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        int cols = rsmd.getColumnCount();
        String[] colName = new String[cols];

        for(int i=0; i<cols; i++) {
            colName[i] = rsmd.getColumnName(i+1);
        }
        model.setColumnIdentifiers(colName);

        String clientID, clientName, companyType, state;
        int numFiles;
        while(resultSet.next()) {
            clientID = resultSet.getString(1);
            clientName = resultSet.getString(2);
            companyType = resultSet.getString(3);
            state = resultSet.getString(4);
            numFiles = resultSet.getInt(5);
            String[] row = {clientID, clientName, companyType, state, String.valueOf(numFiles)};
            model.addRow(row);
        }
        statement.close();
        connection.close();
    }




}




