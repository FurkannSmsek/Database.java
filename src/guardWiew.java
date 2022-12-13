import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.ArrayList;

public class guardWiew extends JFrame{
    private JPanel Dışpanel;
    private JPanel ustPanel;
    private JPanel tabloPanel;
    private JPanel searchPanel;
    private JPanel butonPanel;
    private JTable guardTable;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton returnBackButton;
    private JTextField searchText;
    private JLabel messageLabel;
    static boolean guradtableClicked=false;
    public static Object[] guardDatas= new Object[7];

    DefaultTableModel model;
    prisonStuff stuff= new prisonStuff();
    public  guardWiew(){
        model = (DefaultTableModel) guardTable.getModel();
        add(Dışpanel);
        Dışpanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Guard Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateTable();
        returnBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

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
        searchText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                String searh= searchText.getText();

                dynamicSearc(searh);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GuardAdd guardAdd=new GuardAdd();
                setVisible(false);
                guardAdd.setVisible(true);

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (guradtableClicked){
                    GuardUpdate guardUpdate = new GuardUpdate();
                    setVisible(false);
                    guardUpdate.setVisible(true);
                }else {

                    messageLabel.setText("First Selecet Guard Then Click Update!");
                }

            }
        });
        guardTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                model = (DefaultTableModel) guardTable.getModel();
                int selected=guardTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("Select prisoner to update!");
                    }
                }else {

                    guradtableClicked = true;

                    int ID= (int) model.getValueAt(selected, 0);
                    String name= (String) model.getValueAt(selected, 1);
                    String lastname= (String) model.getValueAt(selected, 2);
                    String rank= (String) model.getValueAt(selected, 3);
                    int weight= (int) model.getValueAt(selected, 4);
                    int height= (int) model.getValueAt(selected, 5);
                    int age= (int) model.getValueAt(selected, 6);

                    guardDatas[0]=ID;
                    guardDatas[1]=name;
                    guardDatas[2]=lastname;
                    guardDatas[3]=rank;
                    guardDatas[4]=weight;
                    guardDatas[5]=height;
                    guardDatas[6]=age;
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                messageLabel.setText("");

                model = (DefaultTableModel) guardTable.getModel();
                int selected=guardTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("First select guard then click delete!");
                    }
                }else {

                    int id=(int)model.getValueAt(selected,0);

                    stuff.deleteGuard(id);
                    CreateTable();

                    messageLabel.setText("Cell deleted succesfully!");


                }

            }
        });
    }

    public void CreateTable(){
        String[] columnNames = {
                "GuardID",      //int
                "First Name",   //String
                "Last Name",    //String
                "Rank",         //String
                "Weight",       //int
                "Height",       //int
                "Age"           //int

        };
        model.setColumnIdentifiers(columnNames);

        getGuard();
    }

    public void dynamicSearc(String text){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);

        guardTable.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(text));
    }

    public void getGuard(){

        model.setRowCount(0);
        ArrayList<Guard> guards=new ArrayList<Guard>();
        guards=stuff.getGuards();


        if(guards!=null){

            System.out.println("Bağlantı Başarılı");
            for (Guard guard: guards){
                Object[] add={guard.getGuardId(),guard.getGuardName(),guard.getGuardSurname(),
                guard.getGuardRank(),guard.getGuardWeight(),guard.getGuardHeight(),guard.getGuardAge()};

                model.addRow(add);
            }
        }

    }



}
