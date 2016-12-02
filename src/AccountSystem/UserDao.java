package AccountSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public UserDao() {

	}

	public static boolean insertUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		if (getUser(user.getStudentID()) == null) {
			try {
				conn = DBUtils.getConnection();
			
				String sql = "insert into userinfo(userType, studentID, password, userName) values(?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, user.getUserType());
				pstmt.setString(2, user.getStudentID());
				pstmt.setString(3, user.getPassword());
				pstmt.setString(4, user.getUserName());
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtils.closeStatement(pstmt);
				DBUtils.closeConnection(conn);
			}
			return true;
		} else
			return false;

	}

	public static User getUser(String studentID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {

			conn = DBUtils.getConnection();
			String sql = "select * from userinfo where studentID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						);
		/*		user.setSex(rs.getString("sex"));
				user.setUsername(rs.getString("username"));
				user.setUserID(rs.getString("userid"));
				user.setPhonenum(rs.getString("phonenum"));
				user.setEmail(rs.getString("email"));
				user.setPwd(rs.getString("pwd"));*/
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}

		return user;

	}

	public static void deleteUser(String studentID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "delete from userinfo where studentID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentID);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
	}

	public static void updateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();

			String sql = "update userinfo set userType=?, studentID=?, password=?, userName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUserType());
			pstmt.setString(2, user.getStudentID());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getUserName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtils.closeResultSet(rs);
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
	}

}

