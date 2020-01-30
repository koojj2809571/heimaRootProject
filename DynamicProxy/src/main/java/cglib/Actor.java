package cglib;

import opp.util.CommonUtil;

public class Actor {
    public void basicAct(float money) {
        CommonUtil.print("开始基本表演，收到演出费：" + money);
    }

    public void dangerAct(float money) {
        CommonUtil.print("开始危险表演，收到演出费：" + money);
    }
}
