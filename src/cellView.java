import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.ArrayList;

public class cellView extends JFrame{
    private JPanel Dışpanel;
    private JButton addButton;
    private JButton updateButton;
    private JButton returnBackButton;
    private JButton deleteButton;
    private JLabel messageLabel;
    private JTable cellTable;
    private JTextField searchText;
    static boolean celltableClicked=false;
    public static Object[] cellDatas= new Object[5];
    DefaultTableModel model;
    prisonStuff stuff= new prisonStuff();
    public cellView(){
        model = (DefaultTableModel) cellTable.getModel();
        add(Dışpanel);
        Dışpanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Guard Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CreateTable();
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
        cellTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                model = (DefaultTableModel) cellTable.getModel();
                int selected=cellTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("Select prisoner to update!");
                    }
                }else {

                    celltableClicked = true;

                    int ID= (int) model.getValueAt(selected, 0);
                    int size= (int) model.getValueAt(selected, 1);
                    int capacity= (int) model.getValueAt(selected, 2);
                    int stuffCount= (int) model.getValueAt(selected, 3);
                    int prisonerCount= (int) model.getValueAt(selected, 3);

                    cellDatas[0]=ID;
                    cellDatas[1]=size;
                    cellDatas[2]=capacity;
                    cellDatas[3]=stuffCount;
                    cellDatas[4]=prisonerCount;
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CellAdd cellAdd = new CellAdd();
                setVisible(false);
                cellAdd.setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (celltableClicked){
                    CellUpdate cellUpdate=new CellUpdate();
                    setVisible(false);
                    cellUpdate.setVisible(true);
                }else {

                    messageLabel.setText("First Selecet Cell Then Click Update!");
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
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText(" ");

                model = (DefaultTableModel) cellTable.getModel();
                int selected=cellTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    }
                    else {
                        messageLabel.setText("First select cell then click delete!");
                    }
                }else {

                    int id=(int)model.getValueAt(selected,0);

                    stuff.deleteCell(id);
                    CreateTable();

                    messageLabel.setText("Cell deleted succesfully!");


                }
            }
        });
    }

    public void  CreateTable(){
        String[] columnNames = {
                "ID",           //int
                "Size",         //int
                "Capacity",     //int
                "Stuff Count",  //int
                "Prisoner Count"//int

        };
        model.setColumnIdentifiers(columnNames);

        getCell();

    }
    public void dynamicSearc(String text){

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);

        cellTable.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(text));
    }

    public void getCell(){

        model.setRowCount(0);
        ArrayList<Cell> cells = new ArrayList<Cell>();
        cells=stuff.getCells();

        if (cells!=null){
            System.out.println("Bağlantı Başarılı");
            for (Cell cell : cells){
                Object[] add={cell.getCellId(),cell.getCellSize(),cell.getCellCapacity(),cell.getCellStuffCount(),cell.getCellPrisonerCount()};
                model.addRow(add);
            }
        }

    }
}
