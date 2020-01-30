package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import opp.util.CommonUtil;

public class Client {

    public static void main(String[] args) {
        final Actor actor = new Actor();
        Actor cdlibActor = (Actor) Enhancer.create(actor.getClass(),
                (MethodInterceptor) (proxy, method, arguments, methodProxy) -> {
                    Object result = null;
                    float money = (float) arguments[0];
                    if (method.getName().equals("basicAct")) {
                        if (money > 10000) {
                            result = method.invoke(actor, money/2);
                        } else {
                            CommonUtil.print("基本演出钱不够");
                        }
                    }
                    if (method.getName().equals("dangerAct")) {
                        if (money > 50000) {
                            result = method.invoke(actor, money/2);
                        } else {
                            CommonUtil.print("危险演出钱不够");
                        }
                    }
                    return result;
                }
        );
        cdlibActor.basicAct(20000);
        cdlibActor.dangerAct(60000);
    }

}
