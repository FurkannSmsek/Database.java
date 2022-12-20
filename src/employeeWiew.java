import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.ArrayList;
public class employeeWiew extends JFrame {
    private JPanel DışPanel;
    private JPanel ustpanel;
    private JPanel tablo;
    private JTable EmployeeTable;
    private JLabel Label;
    private JButton addButton;
    private JTextField SearchText;
    private JButton deleteButton;
    private JButton updateButton;
    private JLabel messageLabel;
    private JButton returnBackButton;


    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();



    public static Object[] employeeDatas= new Object[5];
    static boolean tableClicked=false;
    public employeeWiew() {

        model = (DefaultTableModel) EmployeeTable.getModel();
        add(DışPanel);
        DışPanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Employee Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateTable();
        SearchText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                String searh= SearchText.getText();

                dynamicSearc(searh);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrisonAdd prisonerAdd=new PrisonAdd();
                setVisible(false);
                prisonerAdd.setVisible(true);

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tableClicked){
                    EmployeeUpdate employeeUpdate = new EmployeeUpdate();
                    setVisible(false);
                    employeeUpdate.setVisible(true);
                }else {
                    messageLabel.setText("Select Employee Then Click Update Button!");
                }

            }
        });

        EmployeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                model = (DefaultTableModel) EmployeeTable.getModel();
                int selected=EmployeeTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("Select employee to update!");
                    }
                }else {

                    tableClicked = true;

                    int ID= (int) model.getValueAt(selected, 0);

                    String name= (String) model.getValueAt(selected, 1);

                    String lastname= (String) model.getValueAt(selected, 2);

                    String Department= (String) model.getValueAt(selected, 3);

                    String Authority= (String) model.getValueAt(selected, 4);

                    String Job= (String) model.getValueAt(selected, 5);

                    int gender=1;
                    if ( model.getValueAt(selected, 8).equals("Male")){
                        gender=1;

                    }else {
                        gender=0;
                    }

                    System.out.println(gender);
                    int jobtime= (int) model.getValueAt(selected, 9);


                    /*
                    System.out.println(ID);
                    System.out.println(name);
                    System.out.println(lastname);
                    System.out.println(department);
                    System.out.println(authority);
                    System.out.println(job);


 */
                    employeeDatas[0] =ID;
                    employeeDatas[1] =name;
                    employeeDatas[2] =lastname;
                    employeeDatas[3] =Department;
                    employeeDatas[4] =Authority;
                    employeeDatas[5] =Job;
                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                messageLabel.setText("");

                model = (DefaultTableModel) EmployeeTable.getModel();
                int selected=EmployeeTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("First select employee then click delete!");
                    }
                }else {

                    int id=(int)model.getValueAt(selected,0);

                    stuff.deleteEmployee(id);
                    CreateTable();

                    messageLabel.setText("Employee deleted succesfully!");


                }


            }
        });

        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (LoginScreen.level==0){
                    AuthorityScreen0 authorityScreen0=new AuthorityScreen0();
                    setVisible(false);
                    authorityScreen0.setVisible(true);
                } else if (LoginScreen.level==1) {
                    AuthorityScreen1 authorityScreen1= new AuthorityScreen1();
                    setVisible(false);
                    authorityScreen1.setVisible(true);
                } else if (LoginScreen.level==2) {
                    AuthorityScreen2 authorityScreen2 = new AuthorityScreen2();
                    setVisible(false);
                    authorityScreen2.setVisible(true);
                }
            }
        });
    }

    public void dynamicSearc(String text){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);

        EmployeeTable.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(text));
    }
    private void CreateTable(){

        String[] columnNames = {
                "EmployeeID",   //int
                "First Name",   //String
                "Last Name",    //String
                "Department",       //String
                "Authority",       //String
                "job",  //String

        };
        model.setColumnIdentifiers(columnNames);


        getEmployee();

    }
    public void getEmployee(){

        model.setRowCount(0);

        ArrayList<Employee> employees =new ArrayList<Employee>();

        employees=stuff.getEmployees();
        if (employees!=null){

            System.out.println("Bağlantı Başarılı!");
            for (Employee employee: employees){
                Object[]add={employee.getEmployeeID(),employee.getEmployeeName(),employee.getEmployeeLastName(),
                        employee.getDepartment(),employee.getAuthority(),employee.getJob()};


                model.addRow(add);

            }

        }




    }


}
