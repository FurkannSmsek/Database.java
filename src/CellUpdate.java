import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellUpdate extends JFrame{
    private JPanel DışPanel;
    private JTextField idText;
    private JTextField sizeText;
    private JTextField capacityText;
    private JTextField stuffCountText;
    private JTextField prisonerCountText;
    private JButton updateButton;
    private JButton returnBackButton;
    private JLabel messageLabel;
    prisonStuff stuff=new prisonStuff();
    public CellUpdate(){
        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Cell Update");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idText.setText(cellView.cellDatas[0].toString());
        sizeText.setText(cellView.cellDatas[1].toString());
        capacityText.setText(cellView.cellDatas[2].toString());
        stuffCountText.setText(cellView.cellDatas[3].toString());
        prisonerCountText.setText(cellView.cellDatas[4].toString());


        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cellView cellView=new cellView();
                setVisible(false);
                cellView.setVisible(true);
            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                messageLabel.setText(" ");

                int ID= Integer.parseInt(idText.getText());
                int size= Integer.parseInt(sizeText.getText());
                int capacity= Integer.parseInt(capacityText.getText());
                int stuffCount= Integer.parseInt(stuffCountText.getText());
                int prisonerCount= Integer.parseInt(prisonerCountText.getText());

                stuff.updateCell(ID,size,capacity,stuffCount,prisonerCount);
                messageLabel.setText(" Update was successfull!");

            }
        });
    }
}
