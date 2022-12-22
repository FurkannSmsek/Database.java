import java.util.Date;

public class Prisoner {
    public byte[] photo;
    private int prisonerID,weight,height,age,gender,punishmenTime;
   private String prisonerName,prisonerLastName,TC;

   private Date releaseDate;

    public Prisoner(int prisonerID, String prisonerName, String prisonerLastName, int height, int weight, Date releaseDate, String TC, int age, int gender , int punishmenTime ) {
        this.prisonerID = prisonerID;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.punishmenTime = punishmenTime;
        this.prisonerName = prisonerName;
        this.prisonerLastName = prisonerLastName;
        this.gender = gender;
        this.TC = TC;
        this.releaseDate = releaseDate;
    }

    public Prisoner(int prisonerID, String prisonerName, String prisonerLastName, int height, int weight, Date releaseDate, String TC, int age, int gender , int punishmenTime, byte[] photo ) {
        this.prisonerID = prisonerID;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.punishmenTime = punishmenTime;
        this.prisonerName = prisonerName;
        this.prisonerLastName = prisonerLastName;
        this.gender = gender;
        this.TC = TC;
        this.releaseDate = releaseDate;
        this.photo = photo;
    }

    public int getPrisonerID() {
        return prisonerID;
    }

    public void setPrisonerID(int prisonerID) {
        this.prisonerID = prisonerID;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPunishmenTime() {
        return punishmenTime;
    }

    public void setPunishmenTime(int punishmenTime) {
        this.punishmenTime = punishmenTime;
    }

    public String getPrisonerName() {
        return prisonerName;
    }

    public void setPrisonerName(String prisonerName) {
        this.prisonerName = prisonerName;
    }

    public String getPrisonerLastName() {
        return prisonerLastName;
    }

    public void setPrisonerLastName(String prisonerLastName) {
        this.prisonerLastName = prisonerLastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte photo) {
        this.photo = new byte[1024];
    }
}


