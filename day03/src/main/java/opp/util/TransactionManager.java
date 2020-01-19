package opp.util;

public class TransactionManager {
    public static void beginTransaction(){
        HibernateUtil.getCurrentSession().beginTransaction();
    }

    public static void commit(){
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    public static void rollback(){
        HibernateUtil.getCurrentSession().getTransaction().rollback();
    }
}
