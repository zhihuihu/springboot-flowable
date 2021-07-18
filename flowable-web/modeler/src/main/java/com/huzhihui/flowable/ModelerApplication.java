/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.flowable;

import org.flowable.ui.modeler.conf.ApplicationConfiguration;
import org.flowable.ui.modeler.servlet.AppDispatcherServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author huzhi
 * @version $ v 0.1 2020/4/5 19:06 huzhi Exp $$
 */
@Import({
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class
})
@SpringBootApplication(scanBasePackages="com.huzhihui.flowable")
public class ModelerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelerApplication.class, args);
    }

}
