package Dao;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class profitDao {
    public boolean isExist(String name,String com) {
        if (queryProfit(name,com) != null) return true;
        else return false;
    }
    public profit queryProfit(String time,String com)  {
        ResultSet rs = null;
        String sql="select * from profit where time=? and comName=?;";
        Object[] obj=new Object[]{time,com};
        rs= DBUtil.executeQuery(sql,obj);
        profit v = null;


        try {
            if (rs.next()) {
                String comName=rs.getString("comName");
                String times = rs.getString("time");
                double income = rs.getDouble("income");
                v = new profit(comName,times,income);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return v;

    }

    //获取所有数据的集合
    public ArrayList<profit> queryProfit2(String com,String time1,String time2)  {
        ResultSet rs = null;
        String sql="select * from profit where comName=? and time between ? and ?;";
        Object[] obj=new Object[]{com,time1,time2};
        rs= DBUtil.executeQuery(sql,obj);
        ArrayList<profit> vArray=new ArrayList<>();
        try {
            while (rs.next()) {
                String comName=rs.getString("comName");
                String times = rs.getString("time");
                double income = rs.getDouble("income");
                profit v = new profit(comName,times,income);
                vArray.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return vArray;

    }
    public boolean addProfit(profit v) {//成功返回true，否则返回false
        String sql = "INSERT into profit values(?,?,?);";
        Object[] obj = new Object[]{v.getComName(),v.getTime(),v.getIncome()};
        return DBUtil.executeUpdate(sql, obj);


    }
}
