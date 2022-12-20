public class Employee {
    private int employeeID;
    private String employeeName,employeeLastName,department,authority,job;

    public Employee(int employeeID,String employeeName, String employeeLastName, String department, String authority, String job ) {
        this.employeeID = employeeID;
        this.department=department;
        this.authority = authority;
        this.job = job;
        this.employeeName = employeeName;
        this.employeeLastName = employeeLastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}

