package Dao;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class volDao {
    public ArrayList<vol> queryVolAll(String index)  {//根据time查询nav是否存在，存在返回nav对象，不存在返回空
        ResultSet rs = null;
        String sql="select newMarketValue,Volatility from combin NATURAL join stageinf where timeQuantum=?;";
        Object[] obj=new Object[]{index};
        rs= DBUtil.executeQuery(sql,obj);
        ArrayList<vol> list=new ArrayList<>();


        try {
            while (rs.next()) {
                double  newMarketValue = rs.getDouble("newMarketValue");
                double Volatility = rs.getDouble("Volatility");
                vol v = new vol(newMarketValue,Volatility);
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
