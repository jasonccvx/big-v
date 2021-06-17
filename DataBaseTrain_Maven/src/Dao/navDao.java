package Dao;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class navDao {
    public boolean isExist(String name,String com) {
        if (queryNav(name,com) != null) return true;
        else return false;
    }
    public nav queryNav(String time,String com)  {//根据time查询nav是否存在，存在返回nav对象，不存在返回空
        ResultSet rs = null;
        String sql="select * from nav where time=? and comName=?;";
        Object[] obj=new Object[]{time,com};
        rs= DBUtil.executeQuery(sql,obj);
        nav v = null;


        try {
            if (rs.next()) {
                String comName=rs.getString("comName");
                String times = rs.getString("time");
                double navs = rs.getDouble("nav");
                double DailyIncrease = rs.getDouble("DailyIncrease");
                v = new nav(comName,times,navs,DailyIncrease);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return v;

    }

    public ArrayList<nav> queryNavAll(String com, String time1, String time2)  {//根据time查询nav是否存在，存在返回nav对象，不存在返回空
        ResultSet rs = null;
        String sql="select * from nav where comName=? and time between ? and ?;";
        Object[] obj=new Object[]{com,time1,time2};
        rs= DBUtil.executeQuery(sql,obj);
        ArrayList<nav> list=new ArrayList<>();


        try {
            while (rs.next()) {
                String comName=rs.getString("comName");
                String times = rs.getString("time");
                double navs = rs.getDouble("nav");
                double DailyIncrease = rs.getDouble("DailyIncrease");
                nav v = new nav(comName,times,navs,DailyIncrease);
                list.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return list;

    }
    public boolean addNav(nav v) {//成功返回true，否则返回false
        String sql = "INSERT into nav values(?,?,?,?);";
        Object[] obj = new Object[]{v.getComName(),v.getTime(),v.getNav(),v.getDailyIncrease()};
        return DBUtil.executeUpdate(sql, obj);


    }

}
