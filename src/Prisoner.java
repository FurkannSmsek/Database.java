public class Prisoner {
   private int prisonerID,weight,height,age,punishmenTime;
   private String prisonerName,prisonerLastName,gender,TC,releaseDate;

    public Prisoner(int prisonerID,String prisonerName, String prisonerLastName, int height, int weight, String releaseDate, String TC, int age,String gender ,int punishmenTime ) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}


