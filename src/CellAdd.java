import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellAdd extends  JFrame {
    private JPanel Dışpanel;
    private JTextField cellSize;
    private JTextField cellCapacity;
    private JTextField cellStuffCount;
    private JTextField cellPrisonerCount;
    private JButton addButton;
    private JButton returnBackButton;
    private JLabel messageLabel;
    prisonStuff stuff =new prisonStuff();
    public CellAdd(){

        add(Dışpanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Add");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellView cellView =new cellView();
                setVisible(false);
                cellView.setVisible(true);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("");

                int size= Integer.parseInt(cellSize.getText());
                int capacity= Integer.parseInt(cellCapacity.getText());
                int stuffCount=Integer.parseInt(cellStuffCount.getText());
                int prisonerCount=Integer.parseInt(cellPrisonerCount.getText());


                stuff.addCell(size,capacity,stuffCount,prisonerCount);

                messageLabel.setText("Adding was successfull!");
            }
        });
    }
}
