package Dao;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class fansAndIncomeDao {
        public ArrayList<fansAndIncome> queryFIAll(String index)  {//根据time查询nav是否存在，存在返回nav对象，不存在返回空
            ResultSet rs = null;
            String sql="select fansNUM,avg(income)as avi from (select * from profit where time=?) as T NATURAL join combin NATURAL join v where combin.Vname=v.name GROUP BY name;";
            Object[] obj=new Object[]{index};
            rs= DBUtil.executeQuery(sql,obj);
            ArrayList<fansAndIncome> list=new ArrayList<>();


            try {
                while (rs.next()) {
                    int fansNUM = rs.getInt("fansNUM");
                    double income = rs.getDouble("avi");
                    fansAndIncome v = new fansAndIncome(fansNUM,income);
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
