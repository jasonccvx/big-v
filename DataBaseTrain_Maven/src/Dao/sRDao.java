package Dao;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class sRDao {
    public ArrayList<sR> querySRAll(String index)  {//根据time查询nav是否存在，存在返回nav对象，不存在返回空
        ResultSet rs = null;
        String sql="select newMarketValue,SharpeRatio from combin NATURAL join stageinf where timeQuantum=?;";
        Object[] obj=new Object[]{index};
        rs= DBUtil.executeQuery(sql,obj);
        ArrayList<sR> list=new ArrayList<>();


        try {
            while (rs.next()) {
                double  newMarketValue = rs.getDouble("newMarketValue");
                double SharpeRatio = rs.getDouble("SharpeRatio");
                sR v = new sR(newMarketValue,SharpeRatio);
                list.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeObject(DBUtil.connection, DBUtil.pstmt, DBUtil.rs);
        }
        return list;

    }
}
