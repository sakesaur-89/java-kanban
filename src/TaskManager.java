import java.util.ArrayList;

public class TaskManager {

    public ArrayList<Task> tasks = new ArrayList<>();
    public ArrayList<Epic> epics;

    public void printTaskLists() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void clearTasks() {
        tasks.clear();
        Task.taskCounter = 0;
    }

    public Task getTaskByID(int id) {
        Task buffer = null;
        for (Task task : tasks) {
            if (task.getTaskID() == id) {
                buffer = task;
                break;
            }
        }
        return buffer;
    }

    public void printTaskLists(Task taskSample) {
        for (Task task : tasks) {
            if (task.getClass() == taskSample.getClass()) {
                System.out.println(task);
            }
        }
    }

    public void clearTasks(Task taskSample) {
        tasks.removeIf(task -> task.getClass() == taskSample.getClass());
    }

    public void createTask(Task task) {
        tasks.add(task);
    }

    public void createTask(Epic epic, ArrayList<Task> tasks) {
        tasks.add(epic);
        for (Task task : tasks) {
            getTaskByID(epic.getTaskID()).tasks.add(task);
        }
    }

    public void setATask(Task task, int taskID) {
        removeTaskByID(taskID);
        tasks.add(task);
    }

    public void setATask(Epic epic, int taskID, ArrayList<Task> tasks) {
        removeTaskByID(taskID);
        this.tasks.add(epic);
        for (Task task : tasks) {
            getTaskByID(taskID).tasks.add(task);
        }
    }

    public void removeTaskByID(int taskID) {
        Task target = getTaskByID(taskID);
        if (target != null) {
            tasks.remove(target);
        }
    }

    public void completeTask(int taskID) {
        Task target = getTaskByID(taskID);
        if (target != null) {
            target.setStatus(TaskStatus.DONE);
        }
    }

    public void completeTaskOfEpic(int taskID, int innerTaskID) {
        Task target = getTaskByID(taskID);
        if (target != null) {
            Task innerTask = target.getTaskByID(innerTaskID);
            if (innerTask != null) {
                innerTask.setStatus(TaskStatus.DONE);
            }
        }
        if (target != null && target.getClass() == Epic.class) {
            boolean allSubTasksComplete = true;
            for (Task task : target.tasks) {
                allSubTasksComplete &= (task.getStatus() == TaskStatus.DONE);
            }
            if (allSubTasksComplete) {
                target.setStatus(TaskStatus.DONE); // статус объекта Epic
            } else {
                target.setStatus(TaskStatus.IN_PROGRESS); // статус объекта Epic
            }
        }
    }

}
