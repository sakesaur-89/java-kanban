
import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    public HashMap<Integer, Task> tasksByID = new HashMap<>();


    public void printTaskList() {
        for (int key : tasksByID.keySet()) {
            System.out.println(tasksByID.get(key));
        }
    }

    public void clearTasks() {
        tasksByID.clear();
    }

    public void clearTasks(Task taskSample) {
        ArrayList<Integer> toRemove = new ArrayList<>();
        for (int key : tasksByID.keySet()) {
            if (tasksByID.get(key).getClass() == taskSample.getClass()) {
                toRemove.add(key);
            }
        }
        for (Integer key : toRemove) {
            tasksByID.remove(key);
        }
    }


    public Task getTaskByID(int id) {
        return tasksByID.get(id);
    }

    public void printTaskList(Task taskSample) {
        for (int key : tasksByID.keySet()) {
            if (tasksByID.get(key).getClass() == taskSample.getClass()) {
                System.out.println(tasksByID.get(key));
            }
        }
    }


    public void setTask(Task task) {
        int taskID = task.getTaskID();
        this.tasksByID.put(taskID, task);
    }

    public void setTask(Epic epic, ArrayList<Task> tasks) {
        int taskID = epic.getTaskID();
        this.tasksByID.put(taskID, epic);
        if (epic.getClass() == Epic.class) {
            for (Task task : epic.tasks) {
                this.tasksByID.get(taskID).tasks.add(task);
            }
        }
        statusUpdate(taskID);
    }

    public void setTask(Task task, ArrayList<SubTask> subTasks) {
        int taskID = task.getTaskID();
        this.tasksByID.put(taskID, task);
        if (tasksByID.get(taskID).getClass() == Task.class) {
            tasksByID.get(taskID).subTasks.addAll(subTasks);
        }
    }

    public void createTask(String name, String description) {
        Task task = new Task(name, description);
        int taskID = task.getTaskID();
        this.tasksByID.put(taskID, task);
    }

    public void createTask(String name, String description, ArrayList<SubTask> subTasks) {
        Task task = new Task(name, description, subTasks);
        int taskID = task.getTaskID();
        this.tasksByID.put(taskID, task);
        if (tasksByID.get(taskID).getClass() == Task.class) {
            tasksByID.get(taskID).subTasks.addAll(subTasks);
        }
    }

    public void createEpic(String name, String description) {
        Epic epic = new Epic(name, description);
        int taskID = epic.getTaskID();
        this.tasksByID.put(taskID, epic);
    }

    public void createEpic(String name, String description, ArrayList<Task> tasks) {
        Epic epic = new Epic(name, description, tasks);
        int taskID = epic.getTaskID();
        this.tasksByID.put(taskID, epic);
        if (epic.getClass() == Epic.class) {
            for (Task task : epic.tasks) {
                this.tasksByID.get(taskID).tasks.add(task);
            }
        }
        statusUpdate(taskID);
    }

    public void statusUpdate(int taskID) {
        if ((tasksByID.get(taskID) != null) && (tasksByID.get(taskID).getClass() == Epic.class)) {
            boolean allTasksNew = true;
            for (Task task : tasksByID.get(taskID).tasks) {
                allTasksNew &= task.getStatus() == TaskStatus.NEW;
            }
            if (allTasksNew) {
                return;
            }
            boolean notAllTasksDone = false;
            for (Task task : tasksByID.get(taskID).tasks) {
                notAllTasksDone |= task.getStatus() == TaskStatus.NEW;
            }
            if (notAllTasksDone) {
                tasksByID.get(taskID).setStatus(TaskStatus.IN_PROGRESS);
            } else {
                tasksByID.get(taskID).setStatus(TaskStatus.DONE);
            }
        }
    }


}
