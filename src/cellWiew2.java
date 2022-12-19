import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cellWiew2 extends  JFrame{
    private JPanel DışPanel;
    private JTextField aTYPECELLFORTextField;
    private JTextField bTYPECELLFORTextField;
    private JTextField cTYPECELLFORTextField;
    private JTextField dTYPECELLFORTextField;
    private JButton CELLA11Button;
    private JButton returnBackButton;


    public cellWiew2(){
        add(DışPanel);
        DışPanel.setVisible(true);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Guard Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        returnBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (LoginScreen.level==0){
                    AuthorityScreen0 authorityScreen0=new AuthorityScreen0();
                    setVisible(false);
                    authorityScreen0.setVisible(true);
                } else if (LoginScreen.level==1) {
                    AuthorityScreen1 authorityScreen1= new AuthorityScreen1();
                    setVisible(false);
                    authorityScreen1.setVisible(true);
                } else if (LoginScreen.level==2) {
                    AuthorityScreen2 authorityScreen2 = new AuthorityScreen2();
                    setVisible(false);
                    authorityScreen2.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        cellWiew2 cellWiew2=new cellWiew2();
        cellWiew2.setVisible(true);
    }


}
