package AccountSystem;

/**
 * Created by minghua on 11/29/16.
 */

public class Account {
    public static final int TYPE_INCOME = 0;
    public static final int TYPE_OUTCOME = 1;

    private int id;
    private String accountName;
    private int type;
    private double amount;
    private String description;
    private String studentID;

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getStudentID() {
        return studentID;
    }

    public Account(int id, String accountName, int type, double amount, String description, String studentID) {
        this.id = id;
        this.accountName = accountName;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.studentID = studentID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
