/**
 * zhihuihu.github.io.
 * Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.huzhihui.flowable.api.test;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author huzhi
 * @version $ v 0.1 2020/4/9 21:32 huzhi Exp $$
 */
public class LeaveFlowable {

    @Test
    public void deploy(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.137.100:3306/spring_boot_flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("Root@123")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("请假.bpmn20.xml")
                .deploy();
    }

    @Test
    public void create(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.137.100:3306/spring_boot_flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("Root@123")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        Scanner scanner= new Scanner(System.in);

        System.out.println("你是谁?");
        String me = scanner.nextLine();

        System.out.println("主管是谁?");
        String zhuguan = scanner.nextLine();

        System.out.println("经理是谁?");
        String jingli = scanner.nextLine();


        RuntimeService runtimeService = processEngine.getRuntimeService();

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", me);
        variables.put("zhuguan", zhuguan);
        variables.put("jingli", jingli);
        variables.put("businessId","测试流程ID");
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("leave", variables);

    }

    public void zhuguanTask(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.137.100:3306/spring_boot_flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("Root@123")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        Scanner scanner= new Scanner(System.in);

        System.out.println("主管是谁?");
        String zhuguan = scanner.nextLine();

        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(zhuguan).list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }

        System.out.println("Which task would you like to complete?");
        int taskIndex = Integer.valueOf(scanner.nextLine());
        Task task = tasks.get(taskIndex - 1);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        System.out.println(processVariables.get("employee") + " 想 " +
                " 请假?" + "业务ID" + processVariables.get("businessId"));

        boolean approved = scanner.nextLine().toLowerCase().equals("y");
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", approved);
        taskService.complete(task.getId(), variables);

        System.out.println("主管审核了");
    }

    public void jingliTask(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.137.100:3306/spring_boot_flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("Root@123")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        Scanner scanner= new Scanner(System.in);

        System.out.println("经理是谁?");
        String jingli = scanner.nextLine();

        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(jingli).list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }

        System.out.println("Which task would you like to complete?");
        int taskIndex = Integer.valueOf(scanner.nextLine());
        Task task = tasks.get(taskIndex - 1);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        System.out.println(processVariables.get("employee") + " 想 " +
                " 请假?" + "业务ID" + processVariables.get("businessId"));

        boolean approved = scanner.nextLine().toLowerCase().equals("y");
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", approved);
        taskService.complete(task.getId(), variables);

        System.out.println("经理审核了");
    }


    public static void main(String[] args) {

        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.137.100:3306/spring_boot_flowable?characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("Root@123")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        /*Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("请假.bpmn20.xml")
                .deploy();*/

        Scanner scanner= new Scanner(System.in);

        System.out.println("你是谁?");
        String me = scanner.nextLine();

        System.out.println("主管是谁?");
        String zhuguan = scanner.nextLine();

        System.out.println("经理是谁?");
        String jingli = scanner.nextLine();


        RuntimeService runtimeService = processEngine.getRuntimeService();

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", me);
        variables.put("zhuguan", zhuguan);
        variables.put("jingli", jingli);
        variables.put("businessId","测试流程ID");
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("leave", variables);


        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(zhuguan).list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }

        System.out.println("Which task would you like to complete?");
        int taskIndex = Integer.valueOf(scanner.nextLine());
        Task task = tasks.get(taskIndex - 1);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        System.out.println(processVariables.get("employee") + " 想 " +
                 " 请假?" + "业务ID" + processVariables.get("businessId"));

        boolean approved = scanner.nextLine().toLowerCase().equals("y");
        variables = new HashMap<String, Object>();
        variables.put("approved", approved);
        taskService.complete(task.getId(), variables);

        System.out.println("主管审核了");

        tasks = taskService.createTaskQuery().taskAssignee(jingli).list();
        System.out.println("经理 " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }
        System.out.println("Which task would you like to complete?");
        taskIndex = Integer.valueOf(scanner.nextLine());
        task = tasks.get(taskIndex - 1);
        processVariables = taskService.getVariables(task.getId());
        System.out.println(processVariables.get("employee") + " 想 " +
                " 请假?" + "业务ID" + processVariables.get("businessId"));

        approved = scanner.nextLine().toLowerCase().equals("y");

        variables = new HashMap<String, Object>();
        variables.put("approved", approved);
        taskService.complete(task.getId(), variables);


        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId(processInstance.getId())
                        .finished()
                        .orderByHistoricActivityInstanceEndTime().asc()
                        .list();

        for (HistoricActivityInstance activity : activities) {
            System.out.println(activity.getActivityId() + " took "
                    + activity.getDurationInMillis() + " milliseconds");
        }
    }


}
