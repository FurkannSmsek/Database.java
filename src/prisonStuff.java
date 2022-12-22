import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class prisonStuff<photo> {
    private Connection con=null;
    private Statement statement = null;
    private PreparedStatement preparedStatement= null;
    private byte photo;


    public prisonStuff(){

        String url= "jdbc:mysql://"+ Database.host +":"+ Database.port +"/" + Database.db_name;



        try {
            con= DriverManager.getConnection(url,Database.user_name,Database.password);
            System.out.println("Bağlantı başarılı!");

        } catch (Exception e) {
            System.out.println("Baglanti başarısız!");
            e.printStackTrace();
        }
    }

    public boolean login(String username,String password){

        String query= "Select * From authorities where authorities_name= ? and authorities_password = ? ";

        Object[] loginDatas=new Object[2];
        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet rs=preparedStatement.executeQuery();

            if (rs.next()==false){
                return  false;
            }else {
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public int getLevel(String username,String password){
        int level=3;

        String queryLevel= "Select authorities_level From authorities where authorities_name= ? and authorities_password = ?";
        try {
            preparedStatement= con.prepareStatement(queryLevel);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet levelResult=preparedStatement.executeQuery();

            if (levelResult.next()==false){

                return level;
            }else {
                level=levelResult.getInt("authorities_level");

                return level;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                prisonStuff  stuff = new prisonStuff();


                LoginScreen loginScreen=new LoginScreen();
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                loginScreen.setVisible(true);
            }
        });





    }

    public void deletePrisoner(int id){
        String sorgu = "Delete from prisoner where idprisoner = ?";

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Silme Başarısız");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void addPrisoner(String name,String lastname,int height,int weight,String releaseDate,String TC,int age,int gender,int punishmentTime) {

        String sorgu = "Insert Into prisoner(prisoner_name,prisoner_surname,prisoner_height,prisoner_weight,prisoner_release_date,prisoner_TC,prisoner_age,prisoner_gender,prisoner_punishment_time) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            preparedStatement = con.prepareStatement(sorgu);


            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(3, height);
            preparedStatement.setInt(4, weight);
            preparedStatement.setString(5, releaseDate);
            preparedStatement.setString(6, TC);
            preparedStatement.setInt(7, age);
            boolean gender1;
            if (gender==1){
                gender1=true;
            }else {
                gender1=false;
            }
            preparedStatement.setBoolean(8,gender1 );
            preparedStatement.setInt(9, punishmentTime);

            preparedStatement.executeUpdate();





        } catch (SQLException ex) {
            System.out.println("Ekleme Başarısız!");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }






    }

    public void updatePrisoner(int id , String name, String lastname, int height, int weight, String releaseDate, String TC, int age, int gender, int punishmentTime, byte[] photo) {
        String sorgu =  "Update prison.prisoner set prisoner_name = ? , prisoner_surname = ? , prisoner_height = ? , prisoner_weight = ? , prisoner_release_date = ?, prisoner_TC = ? , prisoner_age = ? , prisoner_gender = ? , prisoner_punishment_time = ? ,prisoner_photo = ? where idprisoner = ?;";

        try {
            preparedStatement = con.prepareStatement(sorgu);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setInt(3, height);
            preparedStatement.setInt(4, weight);
            preparedStatement.setDate(5, java.sql.Date.valueOf(dtf.format(now)));
            preparedStatement.setString(6, TC);
            preparedStatement.setInt(7, age);


            preparedStatement.setInt(8,gender );
            preparedStatement.setInt(9, punishmentTime);
            preparedStatement.setBytes(10, photo);
            preparedStatement.setInt(11,id);
            System.out.println("_executeUpdate");
            preparedStatement.executeUpdate();
            System.out.println("executeUpdate");



        } catch (SQLException ex) {
            System.out.println("Update Başarısız");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Prisoner> getPrisoners(){

        ArrayList<Prisoner> data=new ArrayList<Prisoner>();

        try {
            statement = con.createStatement();

            String sorgu="Select * From prisoner";

            ResultSet rs=statement.executeQuery(sorgu);

            while (rs.next()){
                int id=rs.getInt("idprisoner");

                String name=rs.getString("prisoner_name");

                String surname=rs.getString("prisoner_surname");

                int height=rs.getInt("prisoner_height");

                int weight=rs.getInt("prisoner_weight");

                Date releaseDate= rs.getDate("prisoner_release_date");

                String TC=rs.getString("prisoner_TC");

                int age=rs.getInt("prisoner_age");

                int gender = rs.getInt("prisoner_gender");

                int punishmentTime=rs.getInt("prisoner_punishment_time");

                byte[] photo = rs.getBytes("prisoner_photo");

                data.add(new Prisoner(id,name,surname,height,weight,releaseDate,TC,age,gender,punishmentTime, photo));


            }
            return data;

        } catch (SQLException e) {
            System.out.println("Prisoner Veritabanına ulaşılamadı");
            return null;
        }



    }


    public void addGuard(String name,String lastname,String rank,int weight,int height,int age){

        String sorguGuard = "Insert Into guard(guard_name,guard_surname,guard_rank,guard_weight,guard_height,guard_age) VALUES(?,?,?,?,?,?)";

        try {
            preparedStatement=con.prepareStatement(sorguGuard);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, rank);
            preparedStatement.setInt(4, weight);
            preparedStatement.setInt(5, height);
            preparedStatement.setInt(6, age);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Guard ekleme fail");
            throw new RuntimeException(e);
        }


    }

    public  void updateGuard(int id,String name, String lastName,String rank,int weight, int height,int age){


        String guardsorgu =  "Update guard set guard_name = ? , guard_surname = ? , guard_rank = ? , guard_weight = ?, guard_height = ? , guard_age = ? where idguard = ?";

        try {
            preparedStatement=con.prepareStatement(guardsorgu);

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,rank);
            preparedStatement.setInt(4,weight);
            preparedStatement.setInt(5,height);
            preparedStatement.setInt(6,age);
            preparedStatement.setInt(7,id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update guard failed");
            throw new RuntimeException(e);
        }
    }

    public  void  deleteGuard(int id){
        String sorguGuardDelete = "Delete from guard where idguard = ?";

        try {
            preparedStatement = con.prepareStatement(sorguGuardDelete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Guard Silme Başarısız");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Guard> getGuards(){

        ArrayList<Guard> guard_data=new ArrayList<Guard>();

        try {
            statement = con.createStatement();

            String sorgu="Select * From guard";

            ResultSet rs=statement.executeQuery(sorgu);

            while (rs.next()){
                int id=rs.getInt("idguard");

                String name=rs.getString("guard_name");

                String surname=rs.getString("guard_surname");

                String rank=rs.getString("guard_rank");

                int weight=rs.getInt("guard_weight");

                int height=rs.getInt("guard_height");

                int age=rs.getInt("guard_age");



                guard_data.add(new Guard(id,name,surname,rank,weight,height,age));


            }
            return guard_data;

        } catch (SQLException e) {
            System.out.println("Guard Veritabanına ulaşılamadı");
            return null;
        }


    }


    public void addCell(int size,int capacity,int stuffCount,int prisonerCount){
        String sorguCell = "Insert Into cell(cell_size,cell_capacity,cell_stuff_count,cell_prisoner_count) VALUES(?,?,?,?)";


        try {
            preparedStatement= con.prepareStatement(sorguCell);

            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, capacity);
            preparedStatement.setInt(3, stuffCount);
            preparedStatement.setInt(4, prisonerCount);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Cell add başarısız");
            throw new RuntimeException(e);
        }
    }

    public  void  updateCell(int id ,int size,int capacity,int stuffCount,int prisonerCount){

        String cellSorgu =  "Update cell set cell_size = ? , cell_capacity = ? , cell_stuff_count = ? , cell_prisoner_count = ?  where idcell = ?";

        try {
            preparedStatement=con.prepareStatement(cellSorgu);

            preparedStatement.setInt(1,size);
            preparedStatement.setInt(2,capacity);
            preparedStatement.setInt(3,stuffCount);
            preparedStatement.setInt(4,prisonerCount);
            preparedStatement.setInt(5,id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update Cell Failed");
            throw new RuntimeException(e);
        }


    }

    public void deleteCell(int id){
        String sorguCellDelete = "Delete from cell where idcell = ?";

        try {
            preparedStatement=con.prepareStatement(sorguCellDelete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cell Delete Failed");
            throw new RuntimeException(e);
        }

    }
    public ArrayList<Cell> getCells(){
        ArrayList<Cell> cellData=new ArrayList<Cell>();

        try {
            statement=con.createStatement();
            String Cellsorgu="Select * From cell";

            ResultSet rs=statement.executeQuery(Cellsorgu);

            while (rs.next()){

                int id=rs.getInt("idcell");
                int size=rs.getInt("cell_size");
                int capacity=rs.getInt("cell_capacity");
                int stuffCount=rs.getInt("cell_stuff_count");
                int prisonerCount=rs.getInt("cell_prisoner_count");

                cellData.add(new Cell(id,size,capacity,stuffCount,prisonerCount));

            }

            return cellData;


        } catch (SQLException e) {
            System.out.println("get Cell başarısız");
            return null;
        }

    }
    public void deleteEmployee(int id){
        String sorgu = "Delete from employee where idemployee = ?";

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Silme Başarısız");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void addEmployee(String name,String lastname,String department,String authority,String job) {

        String sorgu = "Insert Into employee(employee_name,employee_surname,employee_department,employee_authority,employee_job,employee_id) VALUES(?,?,?,?,?,?)";

        try {
            preparedStatement = con.prepareStatement(sorgu);


            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, department);
            preparedStatement.setString(4, authority);
            preparedStatement.setString(5, job);

            preparedStatement.executeUpdate();





        } catch (SQLException ex) {
            System.out.println("Ekleme Başarısız!");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }






    }

    public void updateEmployee(int id ,String name,String lastname,String department,String authority,String job) {
        String sorgu =  "Update employee set employee_name = ? , employee_surname = ? , employee_department = ? , employee_authority = ?, employee_job = ?  idemployee = ?";

        try {
            preparedStatement = con.prepareStatement(sorgu);


            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, department);
            preparedStatement.setString(4, authority);
            preparedStatement.setString(5, job);
            preparedStatement.setInt(6,id);

            preparedStatement.executeUpdate();



        } catch (SQLException ex) {
            System.out.println("Update Başarısız");
            Logger.getLogger(prisonStuff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Employee> getEmployees(){

        ArrayList<Employee> data=new ArrayList<Employee>();

        try {
            statement = con.createStatement();

            String sorgu="Select * From employee";

            ResultSet rs=statement.executeQuery(sorgu);

            while (rs.next()){
                int id=rs.getInt("idemployee");

                String name=rs.getString("employee_name");

                String surname=rs.getString("employee_surname");

                String department=rs.getString("employee_department");

                String authority=rs.getString("employee_authority");

                String job= rs.getString("employee_job");

                data.add(new Employee(id,name,surname,department,authority,job));


            }
            return data;

        } catch (SQLException e) {
            System.out.println("Employee Veritabanına ulaşılamadı");
            return null;
        }



    }


    public void updatePrisoner(int id, String name, String lastname, int height, int weight, String releaseDate, String tc, int age, String gender, int punishmenttime, JPanel photo) {
    }
}
