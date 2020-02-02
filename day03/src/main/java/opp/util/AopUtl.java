package opp.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("aopUtil")
@Aspect
public class AopUtl {

    @Pointcut("execution(* opp.serviceImpl.*.*(..))")
    private void pt(){}

    @Around("pt()")
    public Object aroundPoint(ProceedingJoinPoint pjp){
        Object result = null;
        try {
            MyBatisUtil.openSession();
            result = pjp.proceed();
            MyBatisUtil.getCurrentSession().commit();
        } catch (Throwable throwable) {
            MyBatisUtil.getCurrentSession().rollback();
            throwable.printStackTrace();
        }finally {
//            MyBatisUtil.release();
        }
        return result;
    }
}
