import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InputFrame extends JFrame {
    private JTextField clientIDField;
    private JTextField clientNameField;
    private JTextField companyTypeField;
    private JTextField stateField;
    private JButton enterButton;
    private JButton exitButton;
    private JPanel inputPanel;


    public InputFrame() {
        setTitle("Welcome");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setMainFrame() throws SQLException {
        InputFrame inputFrame = new InputFrame();
        inputFrame.setContentPane(inputPanel);
        inputFrame.setTitle("Input Entry");
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setVisible(true);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    inputQuery();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                inputFrame.dispose();
            }
        } );

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputFrame.dispose();
            }
        } );
    }

    public void inputQuery() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectinventory", "root", "rootWIN123!");

        Statement statement = connection.createStatement();

        statement.executeUpdate("INSERT INTO clients (clientID, clientName, companyType, state, numFiles)"
                + "VALUES ('11111', 'Test', 'Test', 'Test', '0')");

        connection.close();
        statement.close();
    }
}
