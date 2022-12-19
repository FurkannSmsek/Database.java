import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class AuthorityScreen0  extends JFrame{
    private JPanel panel1;
    private JButton goButton;
    private JButton returnBackButton;
    private JTable table1;
    private JLabel messageLabel;

    static boolean authoritytableClicked=false;
    static String tableRowName="";

    static boolean tableClicked=false;
    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();
    public AuthorityScreen0(){
        model = (DefaultTableModel)table1.getModel();
        add(panel1);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Author Level: WARDEN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CreateAuthorTable();


        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LoginScreen loginScreen=new LoginScreen();
                setVisible(false);
                loginScreen.setVisible(true);
            }
        });


        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                messageLabel.setText(" ");
                model = (DefaultTableModel) table1.getModel();
                int selected=table1.getSelectedRow();
                tableRowName="";
                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("Select table to go!");
                    }
                }else{
                    tableClicked = true;

                    tableRowName= model.getValueAt(selected,0).toString();


                }

            }
        });
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (tableRowName.equals("Authorities")){


                } else if (tableRowName.equals("Prisoners")) {

                    prisonerWiew prisonerWiew = new prisonerWiew();
                    setVisible(false);
                    prisonerWiew.setVisible(true);

                } else if (tableRowName.equals("Cells")) {

                    cellView cellView= new cellView();
                    setVisible(false);
                    cellView.setVisible(true);

                } else if (tableRowName.equals("Personels")) {

                } else if (tableRowName.equals("Food")) {

                } else if (tableRowName.equals("Expense")) {
                    
                } else if (tableRowName.equals("Guards")) {
                    guardWiew guardWiew = new guardWiew();
                    setVisible(false);
                    guardWiew.setVisible(true);

                } else {
                    messageLabel.setText("Select Table to Go!");
                }


            }
        });
    }





    private void CreateAuthorTable(){

        model = (DefaultTableModel) table1.getModel();
        String[] columnNames = {
                "                                               PRISON'S DEPARTMANTS"
        };
        String[] rawNames={
                "Authorities",
                "Prisoners",
                "Cells",
                "Guards",
                "Personels",
                "Food",
                "Expense"
        };

        model.setColumnIdentifiers(columnNames);
        for (int i=0;i<rawNames.length;i++){
            model.addRow(new String[]{rawNames[i]});
        }




}}
