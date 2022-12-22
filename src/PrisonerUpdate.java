import javax.sql.rowset.serial.SerialBlob;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

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
    private JPanel photo;
    private JLabel lbl_img;
    String filename=null;
    byte [] prisoner_photo=null;




    public PrisonerUpdate(){

        add(Dışpanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Update");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        prisonerID.setText(Integer.toString(prisonerWiew.prisoner.getPrisonerID()));
        prisonerName.setText(prisonerWiew.prisoner.getPrisonerName());
        prisonerLastname.setText(prisonerWiew.prisoner.getPrisonerLastName());
        prisonerHeight.setText(Integer.toString(prisonerWiew.prisoner.getHeight()));
        prisonerWeight.setText( Integer.toString(prisonerWiew.prisoner.getWeight()));
        prisonerReleaseDate.setText(new SimpleDateFormat().format(prisonerWiew.prisoner.getReleaseDate()));
        prisonerTC.setText( prisonerWiew.prisoner.getTC());
        prisonerAge.setText(Integer.toString(prisonerWiew.prisoner.getAge()));
        byte[] byte_photo = prisonerWiew.prisoner.photo;
        ImageIcon imageIcon=new ImageIcon(new ImageIcon(byte_photo).getImage().getScaledInstance(300,240, Image.SCALE_SMOOTH));
        lbl_img.setIcon(imageIcon);


        if (prisonerWiew.prisoner.getGender() == 1){
            prisonerGender.setText("Male");
        }else {
            prisonerGender.setText("Female");}

        prisonerPunishmenttime.setText(Integer.toString(prisonerWiew.prisoner.getPunishmenTime()));

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
                byte[] photo = prisonerWiew.prisoner.photo;

                int gender1;
                if (gender.equals("Male")){
                    gender1=1;
                }else {
                    gender1=0;
                }

                JFileChooser chooser=new JFileChooser();
                chooser.showOpenDialog(null);
                File f=chooser.getSelectedFile();
                filename=f.getAbsolutePath();


                ImageIcon imageIcon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(300,240, Image.SCALE_SMOOTH));
                lbl_img.setIcon(imageIcon);


            try{
                File image=new File(filename);
                FileInputStream fis=new FileInputStream(image);
                ByteArrayOutputStream bos =new ByteArrayOutputStream();
                byte[] buf=new byte [1024];
                for (int readNum;(readNum=fis.read(buf))!=-1;){
                    bos.write(buf,0,readNum);
                }
                prisoner_photo= bos.toByteArray();
        }
        catch (Exception e1){
JOptionPane.showMessageDialog(null,e1);
        }
                stuff.updatePrisoner(ID,name,lastname,height,weight,releaseDate,TC,age,gender1,punishmenttime,prisoner_photo);
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
