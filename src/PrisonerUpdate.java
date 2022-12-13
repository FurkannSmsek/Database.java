import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrisonerUpdate extends JFrame{

    private JTextField prisonerName;

    private JTextField prisonerHeight;
    private JTextField prisonerWeight;
    private JTextField prisonerReleaseDate;
    private JTextField prisonerTC;
    private JTextField prisonerAge;
    private JTextField prisonerGender;
    private JLabel messageLabel;
    private JTextField prisonerPunishmenttime;
    private JTextField prisonerID;

    prisonStuff stuff =new prisonStuff();
    private JPanel Dışpanel;
    private JButton updateButton;
    private JButton returnButton;
    private JTextField prisonerLastname;




    public PrisonerUpdate(){

        add(Dışpanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Update");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        prisonerID.setText( prisonerWiew.prisonerDatas[0].toString());
        prisonerName.setText((String)prisonerWiew.prisonerDatas[1]);
        prisonerLastname.setText((String) prisonerWiew.prisonerDatas[2]);
        prisonerHeight.setText(prisonerWiew.prisonerDatas[3].toString());
        prisonerWeight.setText( prisonerWiew.prisonerDatas[4].toString());
        prisonerReleaseDate.setText((String)prisonerWiew.prisonerDatas[5]);
        prisonerTC.setText((String) prisonerWiew.prisonerDatas[6]);
        prisonerAge.setText(prisonerWiew.prisonerDatas[7].toString());

        System.out.println(prisonerWiew.prisonerDatas[8].getClass());
        if (prisonerWiew.prisonerDatas[8].equals("1")){

            prisonerGender.setText("Male");
        }else {
            prisonerGender.setText("Female");}

        prisonerPunishmenttime.setText(prisonerWiew.prisonerDatas[9].toString());

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                messageLabel.setText("");



                int ID= Integer.parseInt(prisonerID.getText());
                String name= prisonerName.getText();
                String lastname=prisonerLastname.getText();
                int height= Integer.parseInt(prisonerHeight.getText());
                int weight= Integer.parseInt(prisonerWeight.getText());
                String releaseDate=prisonerReleaseDate.getText();
                String TC=prisonerTC.getText();
                int age= Integer.parseInt(prisonerAge.getText());
                String gender= (prisonerGender.getText());
                int punishmenttime= Integer.parseInt(prisonerPunishmenttime.getText());

             /*   System.out.println(ID);
                System.out.println(name);
                System.out.println(lastname);
                System.out.println(height);
                System.out.println(weight);
                System.out.println(releaseDate);
                System.out.println(TC);
                System.out.println(age);
                System.out.println(punishmenttime);
              */
                stuff.updatePrisoner(ID,name,lastname,height,weight,releaseDate,TC,age,gender,punishmenttime);


                messageLabel.setText("Update was successfull!");


            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                prisonerWiew prisonerWiew= new prisonerWiew();
                prisonerWiew.setVisible(true);
            }
        });
    }
}
