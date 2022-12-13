public class Guard {

    private int guardId,guardWeight,guardHeight,guardAge;
    private String guardName,guardSurname,guardRank;

    public Guard(int id,String name,String surname,String rank,int weight,int height,int age){

        this.guardId=id;
        this.guardName=name;
        this.guardSurname=surname;
        this.guardRank=rank;
        this.guardWeight=weight;
        this.guardHeight=height;
        this.guardAge=age;
    }


    public int getGuardId() {
        return guardId;
    }

    public void setGuardId(int guardId) {
        this.guardId = guardId;
    }

    public int getGuardWeight() {
        return guardWeight;
    }

    public void setGuardWeight(int guardWeight) {
        this.guardWeight = guardWeight;
    }

    public int getGuardHeight() {
        return guardHeight;
    }

    public void setGuardHeight(int guardHeight) {
        this.guardHeight = guardHeight;
    }

    public int getGuardAge() {
        return guardAge;
    }

    public void setGuardAge(int guardAge) {
        this.guardAge = guardAge;
    }

    public String getGuardName() {
        return guardName;
    }

    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }

    public String getGuardSurname() {
        return guardSurname;
    }

    public void setGuardSurname(String guardSurname) {
        this.guardSurname = guardSurname;
    }

    public String getGuardRank() {
        return guardRank;
    }

    public void setGuardRank(String guardRank) {
        this.guardRank = guardRank;
    }
}
