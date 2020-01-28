package opp;

import opp.util.CommonUtil;

public class ActorImpl implements Actor{
    @Override
    public void basicAct(float money) {
        CommonUtil.print("开始基本表演，收到演出费：" + money);
    }

    @Override
    public void dangerAct(float money) {
        CommonUtil.print("开始危险表演，收到演出费：" + money);
    }
}
