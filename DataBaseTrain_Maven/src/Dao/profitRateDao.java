package Dao;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class profitRateDao {
    public boolean isExist(String time,String com) {
        if (queryProfitRate(time,com) != null) return true;
        else return false;
    }
    public profitRate queryProfitRate(String time,String com)  {
        ResultSet rs = null;
        String sql="select * from profitrate where time=? and comName=?;";
        Object[] obj=new Object[]{time,com};
        rs= DBUtil.executeQuery(sql,obj);
        profitRate v = null;


        try {
            if (rs.next()) {
                String comName=rs.getString("comName");
                String times = rs.getString("time");
                double realIncrease = rs.getDouble("realIncrease");
                double referIncrease = rs.getDouble("referIncrease");
                v = new profitRate(comName,times,realIncrease,referIncrease);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return v;

    }

    public ArrayList<profitRate> queryProfitRateAll(String com,String time1,String time2)  {
        ResultSet rs = null;
        String sql="select * from profitrate where comName=? and time between ? and ?;";
        Object[] obj=new Object[]{com,time1,time2};
        rs= DBUtil.executeQuery(sql,obj);
        ArrayList<profitRate>prArray=new ArrayList<>();


        try {
            while (rs.next()) {
                String comName=rs.getString("comName");
                String times = rs.getString("time");
                double realIncrease = rs.getDouble("realIncrease");
                double referIncrease = rs.getDouble("referIncrease");
                profitRate v = new profitRate(comName,times,realIncrease,referIncrease);
                prArray.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return prArray;

    }
    public boolean addProfitRate(profitRate v) {//成功返回true，否则返回false
        String sql = "INSERT into profitrate values(?,?,?,?);";
        Object[] obj = new Object[]{v.getComName(),v.getTime(),v.getRealIncrease(),v.getReferIncrease()};
        return DBUtil.executeUpdate(sql, obj);


    }
}
