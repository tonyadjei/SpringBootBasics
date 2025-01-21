package com.tonyadjei.springbootbasics.Exercise6;

import java.util.HashMap;

public final class TaskManager {
    public static HashMap<Integer, Task> tasks = new HashMap<>();

    public static Task addTask(Task.TaskRequest taskRequest) {
        if (taskRequest.getTitle() != null) {
            for (Task task: tasks.values()) {
                if (task.getTitle().equalsIgnoreCase(taskRequest.getTitle())) {
                    return null;
                }
            }
            Task task = new Task(taskRequest.getTitle());
            tasks.put(task.getId(), task);
            return task;
        }
        return null;
    }

    public static Task updateTask(int id, String title) {
        Task task = tasks.get(id);
        if (task != null) {
            if (!title.isEmpty()) {
                task.setTitle(title);
                return task;
            }
        }
        return null;
    }

    public static boolean deleteTask(int id) {
        Task task = tasks.get(id);
        if (task != null) {
            tasks.remove(id);
            return true;
        }
        return false;
    }
}
