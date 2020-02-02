package opp.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory factory;
    private static SqlSession session;
    private static InputStream inputStream;

    static {
        try {
            inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
            session = factory.openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openSession(){
        try {
            inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        return factory.openSession();
    }

    public static SqlSession getCurrentSession(){
        if (session == null){
            session = openSession();
        }
        return session;
    }

    public static void release(){
        if (session != null){
            session.close();
        }
        if (inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
