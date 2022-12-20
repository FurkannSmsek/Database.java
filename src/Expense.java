import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.ArrayList;

public class Expense extends JFrame{
    private JPanel Dışpanel;
    private JPanel ustpanel;
    private JPanel tablo;
    private JTable ExpenseTable;
    private JButton returnBackButton;
    private JTextField SearchText;
    private JLabel message;
    DefaultTableModel model;
    prisonStuff stuff=new prisonStuff();


    public static Object[] expenseDatas= new Object[10];
    static boolean tableClicked=false;
    public Expense() {


        model = (DefaultTableModel) ExpenseTable.getModel();
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
        ExpenseTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                model = (DefaultTableModel) ExpenseTable.getModel();
                int selected = ExpenseTable.getSelectedRow();

                if (selected == -1) {

                    if (model.getRowCount() == 0) {
                        message.setText("Empty Table");
                    } else {
                        message.setText("Select prisoner to update!");
                    }
                } else {

                    tableClicked = true;

                    int ID = (int) model.getValueAt(selected, 0);

                    String name = (String) model.getValueAt(selected, 1);

                    int cost = (int) model.getValueAt(selected, 2);

                    String type = (String) model.getValueAt(selected, 3);

                }
            }
        });
    }
        public void dynamicSearc(String text){
            TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);

            ExpenseTable.setRowSorter(tr);

            tr.setRowFilter(RowFilter.regexFilter(text));
        }
        private void CreateTable(){

            String[] columnNames = {
                    "ExpenseID",   //int
                    "Name",   //String
                    "Cost",    //int
                    "Type",       //String


            };
            model.setColumnIdentifiers(columnNames);






        }
    }


