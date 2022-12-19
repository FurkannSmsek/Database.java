import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAdd extends JFrame {
    private JPanel DışPanel;
    private JLabel message;
    private JButton AddButton;
    private JButton returnBackButton;
    private JTextField employeeID;
    private JTextField employeeName;
    private JTextField employeeLastName;
    private JTextField employeeDepartment;
    private JTextField employeeAuthority;
    private JTextField employeeJob;
    prisonStuff stuff =new prisonStuff();

    public EmployeeAdd(){

        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Add");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                message.setText("");
                String ID= employeeID.getText();
                String name=employeeName.getText();
                String lastname=employeeLastName.getText();
                String department=employeeDepartment.getText();
                String authority=employeeAuthority.getText();
                String job=employeeJob.getText();


                stuff.addEmployee(name,lastname,department,authority,job);


                message.setText("Adding was successfull!");


            }
        });
        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                employeeWiew employeeWiew= new employeeWiew();
                employeeWiew.setVisible(true);
            }
        });
    }
}