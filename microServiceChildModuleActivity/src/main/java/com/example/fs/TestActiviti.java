package com.example.fs;

import org.activiti.engine.*;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class TestActiviti {


    @Test
    public void test()
    {
        //两种方式选择一种创建引擎方式：1。配置写在程序里，2。读对应的配置文件(配置文件其实就是xml里写bean的属性。这里就不举例了)
        //测试创建 activiti 引擎（创建流程）
        testCreateProcessEngine();
    }
    /**
     * 测试创建 activiti 引擎 （创建流程）
     */
    @Test
    public void testCreateProcessEngine() {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        cfg.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        cfg.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/fsactiviti?serverTimezone=GMT%2B8");
        cfg.setJdbcUsername("root");
        cfg.setJdbcPassword("123456");
        //配置建表策略
        cfg.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = cfg.buildProcessEngine();

        //发布流程
        RepositoryService repositoryService=processEngine.getRepositoryService();
        DeploymentBuilder builder=repositoryService.createDeployment();
        builder.addClasspathResource("LeaveWorkFlow.bpmn");
        builder.deploy();
        //启动流程
        RuntimeService runtimeService=processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey("myProcess_1");
        //查看流程任务
        TaskService taskService = processEngine.getTaskService();
        String assignee = "emp";
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            Task task = tasks.get(i);
        }
        for (Task task : tasks) {
            System.out.println("taskId:" + task.getId() +
                    ",taskName:" + task.getName() +
                    ",assignee:" + task.getAssignee() +
                    ",createTime:" + task.getCreateTime());
        }
    }
}