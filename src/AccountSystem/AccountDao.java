package AccountSystem;

import org.omg.CORBA.PERSIST_STORE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    public AccountDao() {

    }

    public static boolean insertAccount(Account account) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstmt = null;
        if (getAccount(account.getId()) == null) {
            try {
                conn = DBUtils.getConnection();

                String sql = "insert into accountinfo(id, accountName, type, amount, description, studentID) values(?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, account.getId());
                pstmt.setString(2, account.getAccountName());
                pstmt.setInt(3, account.getType());
                pstmt.setDouble(4, account.getAmount());
                pstmt.setString(5, account.getDescription());
                pstmt.setString(6, account.getStudentID());
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

    public static Account getAccount(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Account account = null;
        try {

            conn = DBUtils.getConnection();
            String sql = "select * from accountinfo where id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                account = new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            DBUtils.closeResultSet(rs);
            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(conn);
        }

        return account;

    }

    public static void deleteAccount(int id) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();

            String sql = "delete from accountinfo where id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
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

    public static void updateAccount(Account account) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();

            String sql = "update accountinfo set id=?, accountName=?, type=?, amount=?, description=?, studentID=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, account.getId());
            pstmt.setString(2, account.getAccountName());
            pstmt.setInt(3, account.getType());
            pstmt.setDouble(4, account.getAmount());
            pstmt.setString(5, account.getDescription());
            pstmt.setString(6, account.getStudentID());
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

