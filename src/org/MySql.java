package org;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {

    //定义MySql驱动,数据库地址,数据库用户名 密码, 执行语句和数据库连接
    public String driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3306/cqupt?serverTimezone=UTC";
    public String user = "root";
    public String password = "kk123456";
    public Statement stmt = null;
    public Connection conn = null;

    //创建一个插入数据的方法
    public void datatoMySql(String insertSQl) {

        try {
            try {
                Class.forName(driver).newInstance();
            } catch (Exception e) {
                System.out.println("Unable to find the local driver");
                e.printStackTrace();
            }
            //创建连接
            conn = DriverManager.getConnection(url, user, password);
            //创建一个 Statement 对象来将 SQL 语句发送到数据库
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //执行SQL 插入语句
            stmt.executeUpdate(insertSQl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //执行完 停止执行语句
            stmt.close();
            //执行完关闭数据库连接
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
