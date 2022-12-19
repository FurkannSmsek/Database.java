import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.ArrayList;

public class FoodView extends JFrame {
    private JPanel Dışpanel;
    private JPanel ustpanel;
    private JPanel tablo;
    private JTable FoodTable;
    private JButton returnBackButton;
    private JTextField SearchText;
    private JLabel messageLabel;

    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();


    public static Object[] expenseDatas= new Object[10];
    static boolean tableClicked=false;
    public FoodView() {


        model = (DefaultTableModel) FoodTable.getModel();
        add(Dışpanel);
        Dışpanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Food Table");
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
        FoodTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                model = (DefaultTableModel) FoodTable.getModel();
                int selected = FoodTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        messageLabel.setText("Empty Table");
                    } else {
                        messageLabel.setText("Select prisoner to update!");
                    }
                } else {

                    tableClicked = true;

                    int ID = (int) model.getValueAt(selected, 0);

                    String name = (String) model.getValueAt(selected, 1);

                    int cost = (int) model.getValueAt(selected, 2);

                    int count = (int) model.getValueAt(selected, 3);

                    int variety = (int) model.getValueAt(selected, 4);

                    int day = (int) model.getValueAt(selected, 5);

                }
            }
        });
    }
    public void dynamicSearc(String text){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);

        FoodTable.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(text));
    }
    private void CreateTable(){

        String[] columnNames = {
                "FoodID",   //int
                "Name",   //String
                "Cost",    //int
                "Count",       //int
                "Variety",       //int
                "Day",       //int


        };
        model.setColumnIdentifiers(columnNames);






    }
}
