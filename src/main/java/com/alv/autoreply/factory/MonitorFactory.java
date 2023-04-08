package com.alv.autoreply.factory;

import com.alv.autoreply.model.TaskListItem;
import com.alv.autoreply.monitor.DefaultMonitor;
import com.alv.autoreply.monitor.Monitor;
import com.alv.autoreply.monitor.ZsxqMonitor;

/**
 * 监视者工厂
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public class MonitorFactory {

    /**
     * 创建监视者
     *
     * @param monitor
     * @param taskListItem
     * @return
     */
    public static Monitor createMonitor(String monitor, TaskListItem taskListItem) {
        switch (monitor) {
            case "zsxq":
                return new ZsxqMonitor(taskListItem);
            default:
                return new DefaultMonitor(taskListItem);
        }
    }
}
