import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AuthorityScreen1 extends JFrame{
    private JPanel panel1;
    private JButton goButton;
    private JButton returnBackButton;
    private JTable table1;
    private List<Prisoner> prisonerList = new ArrayList<Prisoner>();


    public AuthorityScreen1(){
        add(panel1);
        setSize(900,540);
        setLocation(500,200);
        setTitle("Author Level: GUARD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getPrisoner();
        CreateAuthorTable();
    }

    private void getPrisoner() {
        String url= "jdbc:mysql://"+ Database.host +":"+ Database.port +"/" + Database.db_name;


        String query = "SELECT * FROM prison.prisoner";

        try {
            Connection con = DriverManager.getConnection(url, Database.user_name, Database.password);
            System.out.println("Bağlantı başarılı!");
            Statement st = con.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("idprisoner");
                String firstName = rs.getString("prisoner_name");
                String lastName = rs.getString("prisoner_surname");
                int punishmentTime = rs.getInt("prisoner_punishment_time");
                Date releaseDate = rs.getDate("prisoner_release_date");
                int height = rs.getInt("prisoner_height");
                int weight = rs.getInt("prisoner_weight");
                String prisonerTc = rs.getString("prisoner_TC");
                int prisonerAge = rs.getInt("prisoner_age");
                int prisonerGender = rs.getInt("prisoner_gender");
                String strGender;

                if (prisonerGender == 0){
                    strGender = "Erkek";
                }else{
                    strGender = "Kız";
                }

                Prisoner x = new Prisoner(id,firstName,lastName,height,weight,releaseDate,prisonerTc,prisonerAge,prisonerGender,punishmentTime);
                prisonerList.add(x);

                // print the results
                System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", id, firstName, lastName, punishmentTime,
                        releaseDate, height, weight, prisonerTc, prisonerAge, strGender);
            }
            st.close();

        } catch (Exception e) {
            System.out.println("Baglanti başarısız!");
            e.printStackTrace();
        }
    }

    private void CreateAuthorTable(){

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        String[] columnNames = {
                "                                               PRISON'S DEPARTMANTS"
        };

        model.setColumnIdentifiers(columnNames);

        prisonerList.forEach((prisoner -> {
            model.setColumnIdentifiers(new String[]{"Ad Soyad"});
            model.addRow(new String[]{prisoner.getPrisonerName() + prisoner.getPrisonerLastName()});
        }));




    }


}
