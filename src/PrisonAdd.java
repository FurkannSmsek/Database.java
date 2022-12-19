import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrisonAdd extends JFrame{
    private  JTextField id;
    private JPanel Dışpanel;
    private JButton returnBackButton;
    private JButton addButton;
    private JTextField prisonerHeight;
    private JTextField prisonerWeight;
    private JTextField prisonerReleaseDate;
    private JTextField prisonerTC;
    private JTextField prisonerAge;
    private JTextField prisonerGender;
    private JTextField prisonerName;
    private JTextField prisonerLastName;
    private JTextField prisonerPunishmentTime;
    private JLabel message;

    prisonStuff stuff =new prisonStuff();

    public PrisonAdd(){

        add(Dışpanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Add");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                message.setText("");

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


                message.setText("Adding was successfull!");


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

