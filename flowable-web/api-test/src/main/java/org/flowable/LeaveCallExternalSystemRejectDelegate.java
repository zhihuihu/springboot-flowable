/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author huzhi
 * @version $ v 0.1 2020/4/8 21:45 huzhi Exp $$
 */
public class LeaveCallExternalSystemRejectDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        String EventName = execution.getEventName();
        System.out.println("请假被驳回啦 "
                + execution.getVariable("employee") + EventName);
    }

}
