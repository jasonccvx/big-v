package util;

import java.sql.*;

public class DBUtil {
    private static String URL = "jdbc:mysql://localhost:3306/bigv?useUnicode=true&characterEncoding=utf8";
    private static String use = "root";
    private static String pwd = "123456";
    public static Connection connection = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    public static  Connection createLink() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection=DriverManager.getConnection(URL,use,pwd);
        return connection;
    }
    public static void closeObject(Connection connection, Statement stmt, ResultSet rs) {
/*        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        /*if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
/*        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }

    //通用增删改
    public static boolean executeUpdate(String sql, Object[] param) {
        connection = null;
        pstmt = null;
        try {

            pstmt = createLink().prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            int count = -1;
            count = pstmt.executeUpdate();
            if (count > 0) {
                return true;

            } else {
                return false;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeObject(connection, pstmt, null);
        }
    }

    //通用查
    public static ResultSet executeQuery(String sql, Object[] param) {
        connection = null;
        pstmt = null;
        rs = null;

        try {
            pstmt = createLink().prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            rs = pstmt.executeQuery();
            return rs;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static ResultSet executeQuery2(String sql) {
        connection = null;
        pstmt = null;
        rs = null;

        try {
            pstmt = createLink().prepareStatement(sql);
            rs = pstmt.executeQuery();
            return rs;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
