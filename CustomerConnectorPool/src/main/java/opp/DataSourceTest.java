package opp;

import opp.util.CommonUtil;

import java.sql.Connection;

public class DataSourceTest {
    public static void main(String[] args) {
        Connection connection = MyDataSource.getConnection();
        CommonUtil.printString(connection);
    }
}
