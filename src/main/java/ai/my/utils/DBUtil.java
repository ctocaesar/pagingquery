package ai.my.utils;
/**
 * Copyright (C), 2015-2019, XXX有限公司
 * Package : ai.my.utils
 * FileName: DBUtil
 * Author:   张伟
 * Date:     2019/8/18 11:00
 * Description: JDBC工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br>
 * 〈JDBC工具类〉
 *
 * @author 张伟
 * @create 2019/8/18
 * @since 1.0.0
 */
public class DBUtil {
    private DBUtil() {

    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
    }

    public static void close(Object... params) {
        for (Object obj : params) {
            if (obj != null) {
                Class clazz = obj.getClass();
                try {
                    Method method = clazz.getMethod("close");
                    method.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
