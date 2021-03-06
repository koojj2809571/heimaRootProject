package opp;

import opp.util.CommonUtil;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        final ActorImpl actor = new ActorImpl();

        Actor proxyActor = (Actor) Proxy.newProxyInstance(
                actor.getClass().getClassLoader(),
                actor.getClass().getInterfaces(),
                (proxy, method, arguments) -> {
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
        proxyActor.basicAct(20000);
        proxyActor.dangerAct(60000);
    }

}
