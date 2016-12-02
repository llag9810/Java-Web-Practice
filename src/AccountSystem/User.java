package AccountSystem;

public class User {

	public static final int TYPE_USER = 0;
	public static final int TYPE_ADMIN = 1;

	private int userType;
	private String studentID;
	private String password;
	private String userName;

	public static int getTypeUser() {
		return TYPE_USER;
	}

	public static int getTypeAdmin() {
		return TYPE_ADMIN;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(int userType, String studentID, String password, String userName) {

		this.userType = userType;
		this.studentID = studentID;
		this.password = password;
		this.userName = userName;
	}

}
