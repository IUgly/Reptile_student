package org.dao;

import org.utils.JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class namePointxhDao {
    public String namePointxh(String name){
        JDBC jdbc = new JDBC();
        jdbc.getConnection();

        String sql = "select xh from student where name = ?";
        List<Object> params = new ArrayList<Object>();
        params.add(name);
        try {
            return String.valueOf(jdbc.findSimpleResult(sql,params));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
