import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeUpdate extends JFrame {
    private JPanel Dışpanel;
    private JButton updateButton;
    private JButton returnButton;
    private JLabel messageLabel;
    private JTextField employeeID;
    private JTextField employeeName;
    private JTextField employeeLastName;
    private JTextField employeeDepartment;
    private JTextField employeeAuthority;
    private JTextField employeeJob;
    prisonStuff stuff =new prisonStuff();

    public EmployeeUpdate(){

        add(Dışpanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Update");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        employeeID.setText( employeeWiew.employeeDatas[0].toString());
        employeeName.setText((String)employeeWiew.employeeDatas[1]);
        employeeLastName.setText((String) employeeWiew.employeeDatas[2]);
       employeeDepartment.setText(employeeWiew.employeeDatas[3].toString());
        employeeAuthority.setText( employeeWiew.employeeDatas[4].toString());
        employeeJob.setText((String)employeeWiew.employeeDatas[5]);


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                messageLabel.setText("");



                int ID= Integer.parseInt(employeeID.getText());
                String name= employeeName.getText();
                String lastname=employeeLastName.getText();
                String department=employeeDepartment.getText();
                String authority=employeeAuthority.getText();
                String job= (employeeJob.getText());


             /*   System.out.println(ID);
                System.out.println(name);
                System.out.println(lastname);
                System.out.println(department);
                System.out.println(authority);
                System.out.println(job);
              */
                stuff.updateEmployee(ID,name,lastname,department,authority,job);


                messageLabel.setText("Update was successfull!");


            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                employeeWiew employeeWiew= new employeeWiew();
                employeeWiew.setVisible(true);
            }
        });
    }
}


