import javax.swing.*;

public class AuthorityScreen1 extends JFrame{
    private JPanel panel1;
    private JButton goButton;
    private JButton returnBackButton;
    private JTable table1;


    public AuthorityScreen1(){
        add(panel1);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Author Level: GUARD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
