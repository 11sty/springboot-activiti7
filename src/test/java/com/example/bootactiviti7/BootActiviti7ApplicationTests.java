package com.example.bootactiviti7;

import com.example.bootactiviti7.util.SecurityUtil;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class BootActiviti7ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(BootActiviti7ApplicationTests.class);
    @Autowired
    private final ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private SecurityUtil securityUtil;

    @Test
    public void testActBoot() {
        System.out.println(taskRuntime);
    }

    @Test
    public void deployOneAct() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("processes/test2.bpmn20.xml")
                .name("测试第二条有网关流程")
                .deploy();

        System.out.println("流程部署id：" + deploy.getId());
        System.out.println("流程部署名称：" + deploy.getName());
    }

    /**
     * 查看流程定义
     */
    @Test
    public void contextLoads() {
        securityUtil.logInAs("tom");
        Page<ProcessDefinition> processDefinitionPage =
                processRuntime.processDefinitions(Pageable.of(0, 10));
        System.out.println("可用的流程定义数量：" + processDefinitionPage.getTotalItems());
        for (org.activiti.api.process.model.ProcessDefinition pd : processDefinitionPage.getContent()) {
            System.out.println("流程定义：" + pd);
        }
    }

    /**
     * 启动流程实例
     */
    @Test
    public void testStartProcess() {
        securityUtil.logInAs("system");
        ProcessInstance pi = processRuntime.start(ProcessPayloadBuilder.
                start().
                withProcessDefinitionId("myProcess:1:4cc8ba9d-d970-11eb-9b7c-005056c00008").
                build());
        System.out.println("流程实例ID：" + pi.getId());

        // 启动第二条流程实例
        ProcessInstance pi2 = processRuntime.start(ProcessPayloadBuilder.
                start().
                withProcessDefinitionId("myProcess:2:53c9297c-0092-11ec-9867-005056c00008").
                build());
        System.out.println("流程实例2ID：" + pi2.getId());

        /*processEngine.getRuntimeService()
         *//**第二个参数是businesskey:业务工单的主键,作为区分，一般流程名+id，当然如果id为uuid则无所谓 *//*
               .startProcessInstanceByKey*/
    }

    /**
     * *查询任务，并完成自己的任务
     **/
    @Test
    public void testTask() {
        securityUtil.logInAs("jack");
        Page<Task> taskPage = taskRuntime.tasks(Pageable.of(0, 10));
        if (taskPage.getTotalItems() > 0) {
            for (Task task : taskPage.getContent()) {
                taskRuntime.claim(TaskPayloadBuilder.
                        claim().
                        withTaskId(task.getId()).build());
                System.out.println("任务：" + task);
                taskRuntime.complete(TaskPayloadBuilder.
                        complete().
                        withTaskId(task.getId()).build());
            }
        }
        Page<Task> taskPage2 = taskRuntime.tasks(Pageable.of(0, 10));
        if (taskPage2.getTotalItems() > 0) {
            System.out.println("任务：" + taskPage2.getContent());
        }

    }

    @Test
    public void historyService() {
        HistoryService historyService = processEngine.getHistoryService();
        //        获取 actinst表的查询对象
        HistoricActivityInstanceQuery instanceQuery = historyService.createHistoricActivityInstanceQuery();
//        查询 actinst表，条件：根据 InstanceId 查询
//        instanceQuery.processInstanceId("2501");
//        查询 actinst表，条件：根据 DefinitionId 查询
        instanceQuery.processDefinitionId("myProcess:1:4cc8ba9d-d970-11eb-9b7c-005056c00008");
//        增加排序操作,orderByHistoricActivityInstanceStartTime 根据开始时间排序 asc 升序
        instanceQuery.orderByHistoricActivityInstanceStartTime().asc();
//        查询所有内容
        List<HistoricActivityInstance> activityInstanceList = instanceQuery.list();
//        输出
        for (HistoricActivityInstance hi : activityInstanceList) {
            System.out.println(hi.getActivityId());
            System.out.println(hi.getActivityName());
            System.out.println(hi.getProcessDefinitionId());
            System.out.println(hi.getStartTime());
            System.out.println(hi.getProcessInstanceId());
            System.out.println("<==========================>");
        }
    }

    // 结束用户任务
    @Test
    public void finishUserTask() {
        securityUtil.logInAs("tom");
//        创建TaskService
        TaskService taskService = processEngine.getTaskService();
//        根据流程key 和 任务负责人 查询任务
        List<org.activiti.engine.task.Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("myProcess") //流程Key
                //.taskAssignee("tom")//只查询该任务负责人的任务
                .list();
        for (org.activiti.engine.task.Task task : taskList) {
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
            System.out.println("TaskDefinitionKey：" + task.getTaskDefinitionKey());
        }
        //完成Tom的任务
        //System.out.println("完成Tom的任务");
        //taskService.complete(taskList.get(0).getId());
    }

    @Test
    public void testLog() {
    }

}
