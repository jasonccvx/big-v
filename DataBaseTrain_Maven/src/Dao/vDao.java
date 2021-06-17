package Dao;


import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class vDao {

    public boolean isExist(String name) {
        if (queryUser(name) != null) return true;
        else return false;
    }



    public boolean addBigV(bigV v) {//在大V不存在的前提下增加学生,成功返回true，否则返回false
        String sql="INSERT into v values(?,?);";
        Object[] obj=new Object[]{v.getName(),v.getFansNUM()};
        return DBUtil.executeUpdate(sql,obj);



    }



    public bigV queryUser(String Vname)  {//根据name查询大V是否存在，存在返回大V对象，不存在返回空
        ResultSet rs = null;
        String sql="select * from v where name=? ;";
        Object[] obj=new Object[]{Vname};
        rs= DBUtil.executeQuery(sql,obj);
        bigV v = null;


        try {
            if (rs.next()) {
                String name = rs.getString("name");
                int fansNUM = rs.getInt("fansNUM");
                v = new bigV(name,fansNUM);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return v;

    }

    public ArrayList<bigV> queryUserAll()  {//根据name查询大V是否存在，存在返回大V对象，不存在返回空
        ResultSet rs = null;
        String sql="select * from v;";
        rs= DBUtil.executeQuery2(sql);
        ArrayList<bigV> vArray=new ArrayList<>();
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                int fansNUM = rs.getInt("fansNUM");
                bigV v = new bigV(name,fansNUM);
                vArray.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return vArray;

    }
}
