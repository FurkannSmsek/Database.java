import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.ArrayList;

public class prisonerWiew extends  JFrame {

    private JPanel DışPanel;
    private JTable PrisonerTable;
    private JPanel ustpanel;
    private JPanel tablo;
    private JLabel Label;
    private JButton addButton;
    private JTextField SearchText;
    private JButton deleteButton;
    private JButton updateButton;
    private JLabel messageLabel;
    private JButton returnBackButton;


    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();


    public static Object[] prisonerDatas= new Object[10];
    static boolean tableClicked=false;
    public prisonerWiew() {


        model = (DefaultTableModel) PrisonerTable.getModel();
        add(DışPanel);
        DışPanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prisoner Table");
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
                PrisonerUpdate prisonerUpdate = new PrisonerUpdate();
                setVisible(false);
                prisonerUpdate.setVisible(true);
            }else {
                    messageLabel.setText("Select Prisoner Then Click Update Button!");
                }

            }
        });


        PrisonerTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                model = (DefaultTableModel) PrisonerTable.getModel();
                int selected=PrisonerTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("Select prisoner to update!");
                    }
                }else {

                    tableClicked = true;

                    int ID= (int) model.getValueAt(selected, 0);

                    String name= (String) model.getValueAt(selected, 1);

                    String lastname= (String) model.getValueAt(selected, 2);

                    int height= (int) model.getValueAt(selected, 3);

                    int weight= (int) model.getValueAt(selected, 4);

                    String releaseDate= (String) model.getValueAt(selected, 5);

                    String TC= (String) model.getValueAt(selected, 6);

                    int age= (int) model.getValueAt(selected, 7);

                    int gender=1;
                    if ( model.getValueAt(selected, 8).equals("Male")){
                        gender=1;

                    }else {
                        gender=0;
                    }

                    System.out.println(gender);
                    int punishmenttime= (int) model.getValueAt(selected, 9);



/*
                    System.out.println(ID);
                    System.out.println(name);
                    System.out.println(lastname);
                    System.out.println(height);
                    System.out.println(weight);
                    System.out.println(releaseDate);
                    System.out.println(TC);
                    System.out.println(age);
                    System.out.println(punishmenttime);

 */
                    prisonerDatas[0] =ID;
                    prisonerDatas[1] =name;
                    prisonerDatas[2] =lastname;
                    prisonerDatas[3] =height;
                    prisonerDatas[4] =weight;
                    prisonerDatas[5] =releaseDate;
                    prisonerDatas[6] =TC;
                    prisonerDatas[7] =age;
                    prisonerDatas[8] =gender;
                    prisonerDatas[9] =punishmenttime;


                }

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                messageLabel.setText("");

                model = (DefaultTableModel) PrisonerTable.getModel();
                int selected=PrisonerTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("First select prisoner then click delete!");
                    }
                }else {

                    int id=(int)model.getValueAt(selected,0);

                    stuff.deletePrisoner(id);
                    CreateTable();

                    messageLabel.setText("Prisoner deleted succesfully!");


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

        PrisonerTable.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(text));
    }

    private void CreateTable(){

        String[] columnNames = {
                "PrisonerID",   //int
                "First Name",   //String
                "Last Name",    //String
                "Height",       //int
                "Weight",       //int
                "ReleaseDate",  //String
                "TC",           //String
                "Age",          //int
                "Gender",        //String
                "Punishment Time"//String

        };
        model.setColumnIdentifiers(columnNames);


        getPrisoner();



    }

    public void getPrisoner(){

        model.setRowCount(0);

        ArrayList<Prisoner> prisoners =new ArrayList<Prisoner>();

        prisoners=stuff.getPrisoners();
        if (prisoners!=null){

            System.out.println("Bağlantı Başarılı!");
            for (Prisoner prisoner: prisoners){
                Object[]add={prisoner.getPrisonerID(),prisoner.getPrisonerName(),prisoner.getPrisonerLastName(),
                prisoner.getHeight(),prisoner.getWeight(),prisoner.getReleaseDate(),prisoner.getTC(),prisoner.getAge(),prisoner.getGender(),prisoner.getPunishmenTime()};


                model.addRow(add);

            }

        }




    }


}
