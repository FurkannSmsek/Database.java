import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrisonerAdd extends JFrame{
    private JPanel DışPanel;
    private JButton addButton;
    private JButton returnBackButton;
    private JTextField prisonerName;
    private JTextField prisonerLastName;
    private JTextField prisonerHeight;
    private JTextField prisonerWeight;
    private JTextField prisonerReleaseDate;
    private JTextField prisonerTC;
    private JTextField prisonerAge;
    private JTextField prisonerGender;
    private JTextField prisonerPunishmentTime;
    private JLabel messageLabel;

    prisonStuff stuff =new prisonStuff();

    public PrisonerAdd(){

        add(DışPanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Add");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                messageLabel.setText("");

                String name= prisonerName.getText();
                String lastname=prisonerLastName.getText();
                int height= Integer.parseInt(prisonerHeight.getText());
                int weight= Integer.parseInt(prisonerWeight.getText());
                String releaseDate=prisonerReleaseDate.getText();
                String TC=prisonerTC.getText();
                int age= Integer.parseInt(prisonerAge.getText());
                int gender= Integer.parseInt(prisonerGender.getText());
                int punishmentTime= Integer.parseInt(prisonerPunishmentTime.getText());


                stuff.addPrisoner(name,lastname,height,weight,releaseDate,TC,age,gender,punishmentTime);


                messageLabel.setText("Adding was successfull!");


            }
        });
        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                prisonerWiew prisonerWiew= new prisonerWiew();
                prisonerWiew.setVisible(true);
            }
        });
    }
}
