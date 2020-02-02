package opp;

import util.JDBCUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDataSource {
    private static List<Connection> pool = Collections.synchronizedList(new ArrayList<>());

    static {
        for (int i = 0; i < 10; i++){
            Connection connection = JDBCUtil.getConnection();
            pool.add(connection);
        }
    }

    public static Connection getConnection(){
        final Connection connection = pool.remove(0);
        Connection proxyConn = (Connection) Proxy.newProxyInstance(
                connection.getClass().getClassLoader(),
                connection.getClass().getInterfaces(),
                (obj, method, args) -> {
                    Object result = null;
                    if ("close".equals(method.getName())){
                        pool.add(connection);
                    }else {
                        result = method.invoke(connection,args);
                    }
                    return result;
                }
        );
        return proxyConn;
    }
}
