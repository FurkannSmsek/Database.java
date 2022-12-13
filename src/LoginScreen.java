import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.concurrent.TimeUnit;

public class LoginScreen extends  JFrame  {


    prisonStuff stuff =new prisonStuff();

    private JTextField UsernameField;
    private JPasswordField PasswordField;
    private JPanel DışPanel;
    private JButton enterButton;
    private JLabel messageText;
    private JLabel prisonControlPanel;
    private JPanel dışdışpanel;

    static int level=3;
    public LoginScreen(){
        add(dışdışpanel);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Prison Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                messageText.setText("");
                String username=  UsernameField.getText();
                String password= new String(PasswordField.getPassword());

                boolean loginSuccess=stuff.login(username,password);



                level=stuff.getLevel(username,password);
                if (loginSuccess==true && level==0){

                    messageText.setText("Login Successfull Your Authority Level Is: Warden!");



                    AuthorityScreen0 screen0 = new AuthorityScreen0();
                    setVisible(false);
                    screen0.setVisible(true);



                } else if (loginSuccess==true && level==1) {

                    messageText.setText("Login Successfull Your Authority Level Is: Guard!");

                    AuthorityScreen1 screen1 = new AuthorityScreen1();
                    setVisible(false);
                    screen1.setVisible(true);


                } else if (loginSuccess==true && level==2) {
                    messageText.setText("Login Successfull Your Authority Level Is: Personel!");


                    AuthorityScreen2 screen2 = new AuthorityScreen2();
                    setVisible(false);
                    screen2.setVisible(true);


                } else {
                    messageText.setText("Login Failed!");
                }

            }
        });


    }
}
