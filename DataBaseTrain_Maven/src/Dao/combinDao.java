package Dao;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class combinDao {
    public boolean isExist(String com) {
        if (queryCombin(com) != null) return true;
        else return false;
    }
    public combin queryCombin(String com)  {
        ResultSet rs = null;
        String sql="select * from combin where comName=?;";
        Object[] obj=new Object[]{com};
        rs= DBUtil.executeQuery(sql,obj);
        combin v = null;

        try {
            if (rs.next()) {
                String comName=rs.getString("comName");
                String Vname = rs.getString("Vname");
                String type = rs.getString("type");
                double annuRate = rs.getDouble("annuRate");
                double dayIncrease = rs.getDouble("dayIncrease");
                double newNetWorth = rs.getDouble("newNetWorth");
                double newMarketValue = rs.getDouble("newMarketValue");
                String estabDay=rs.getString("estabDay");
                v = new combin(comName,Vname,type,annuRate,dayIncrease,newNetWorth,newMarketValue,estabDay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return v;

    }
    public ArrayList<combin> queryCombinAll()  {
        ResultSet rs = null;
        String sql="select * from combin;";
        rs= DBUtil.executeQuery2(sql);
        ArrayList<combin> com=new ArrayList<>();

        try {
            while (rs.next()) {
                String comName=rs.getString("comName");
                String Vname = rs.getString("Vname");
                String type = rs.getString("type");
                double annuRate = rs.getDouble("annuRate");
                double dayIncrease = rs.getDouble("dayIncrease");
                double newNetWorth = rs.getDouble("newNetWorth");
                double newMarketValue = rs.getDouble("newMarketValue");
                String estabDay=rs.getString("estabDay");
                combin v = new combin(comName,Vname,type,annuRate,dayIncrease,newNetWorth,newMarketValue,estabDay);
                com.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return com;

    }
    public boolean addCombin(combin v) {//成功返回true，否则返回false
        String sql = "INSERT into combin values(?,?,?,?,?,?,?,?);";
        Object[] obj = new Object[]{v.getComName(),v.getVname(),v.getType(),v.getAnnuRate(),v.getDayIncrease(),v.getNewNetWorth(),v.getNewMarketValue(),v.getEstabDay()};
        return DBUtil.executeUpdate(sql, obj);


    }

}
