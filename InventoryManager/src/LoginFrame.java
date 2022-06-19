import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

public class LoginFrame extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel loginPanel;

    Connection connection;


    public LoginFrame() {

        setContentPane(loginPanel);
        setTitle("Login");
        setSize(600,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Properties properties = new Properties();
                FileInputStream filein = null;
                MysqlDataSource dataSource = null;


                        try {
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectinventory", "root", "rootWIN123!");
                            System.out.println("Connected");
                            dispose();
                            MainFrame fakeFrame = new MainFrame();
                            connection.close();
                            fakeFrame.setMainFrame();

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                }



        });


    }


    public void setVisible() {
        setVisible(true);
    }


}
