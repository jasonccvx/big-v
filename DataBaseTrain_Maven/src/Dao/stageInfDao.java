package Dao;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class stageInfDao {
    public boolean isExist(String name,String com) {
        if (queryStageInf(name,com) != null) return true;
        else return false;
    }
    public stageInf queryStageInf(String time,String com)  {
        ResultSet rs = null;
        String sql="select * from stageinf where timeQuantum=? and comName=?;";
        Object[] obj=new Object[]{time,com};
        rs= DBUtil.executeQuery(sql,obj);
        stageInf v = null;


        try {
            if (rs.next()) {
                String comName=rs.getString("comName");
                String timeQuantum = rs.getString("timeQuantum");
                double maxRec = rs.getDouble("maxRec");
                double SharpeRatio=rs.getDouble("SharpeRatio");
                double Volatility=rs.getDouble("Volatility");
                double firstHeavyProp=rs.getDouble("firstHeavyProp");
                double positiveProfitRate=rs.getDouble("positiveProfitRate");
                double profitRec=rs.getDouble("profitRec");
                double conScore=rs.getDouble("conScore");
                v = new stageInf(comName,timeQuantum,maxRec,SharpeRatio,Volatility,firstHeavyProp, positiveProfitRate,profitRec,conScore);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return v;

    }
    public boolean addstageInf(stageInf v) {//成功返回true，否则返回false
        String sql = "INSERT into stageinf values(?,?,?,?,?,?,?,?,?);";
        Object[] obj = new Object[]{v.getComName(),v.getTimeQuantum(),v.getMaxRec(),v.getSharpeRatio(),v.getVolatility(),v.getFirstHeavyProp(),v.getPositiveProfitRate(),v.getProfitRec(),v.getConScore()};
        return DBUtil.executeUpdate(sql, obj);


    }
}
