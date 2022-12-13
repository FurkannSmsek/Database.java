import com.mysql.cj.protocol.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuardUpdate extends JFrame {
    private JPanel DışPanel;
    private JTextField idText;
    private JTextField nameText;
    private JTextField rankText;
    private JTextField weightText;
    private JTextField heightText;
    private JTextField ageText;
    private JButton updateButton;
    private JButton returnBackButton;
    private JTextField lastNameText;
    private JLabel messageLabel;

    prisonStuff stuff=new prisonStuff();

    public  GuardUpdate(){
        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Guard Update");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        idText.setText( guardWiew.guardDatas[0].toString());
        nameText.setText( guardWiew.guardDatas[1].toString());
        lastNameText.setText( guardWiew.guardDatas[2].toString());
        rankText.setText(guardWiew.guardDatas[3].toString());
        weightText.setText( guardWiew.guardDatas[4].toString());
        heightText.setText(guardWiew.guardDatas[5].toString());
        ageText.setText(guardWiew.guardDatas[6].toString());



        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                guardWiew guardWiew=new guardWiew();
                setVisible(false);
                guardWiew.setVisible(true);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                messageLabel.setText(" ");

                int ID= Integer.parseInt(idText.getText());
                String name= nameText.getText();
                String lastname=lastNameText.getText();
                String rank=rankText.getText();
                int weight= Integer.parseInt(weightText.getText());
                int height= Integer.parseInt(heightText.getText());
                int age= Integer.parseInt(ageText.getText());


                stuff.updateGuard(ID,name,lastname,rank,weight,height,age);



                messageLabel.setText("Update was successfull!");
            }
        });
    }
}
