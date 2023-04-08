package com.alv.autoreply.job;

import com.alv.autoreply.answerer.Answerer;
import com.alv.autoreply.factory.AnswererFactory;
import com.alv.autoreply.factory.MonitorFactory;
import com.alv.autoreply.monitor.Monitor;
import com.alv.autoreply.model.TaskListItem;

/**
 * 任务中介（负责协调监控者和回答者，把参数传给他们）
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public class JobMediator implements Runnable {

    private final TaskListItem taskListItem;

    public JobMediator(TaskListItem taskListItem) {
        this.taskListItem = taskListItem;
    }

    @Override
    public void run() {
        // 根据配置选择 monitor 和 answerer
        Monitor monitor = MonitorFactory.createMonitor(taskListItem.getMonitor(), taskListItem);
        Answerer answerer = AnswererFactory.createAnswerer(taskListItem.getAnswerer());
        // 监控并回答
        monitor.onMonitor(answerer);
    }
}
