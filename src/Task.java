import java.util.ArrayList;
import java.util.Objects;

public class Task {
    public final String name;
    private final String description;
    private TaskStatus status;
    public ArrayList<SubTask> subTasks = new ArrayList<>();
    public static int taskCounter = 0;
    private final int taskID;
    public ArrayList<Task> tasks = new ArrayList<>();

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = TaskStatus.NEW;
        this.taskID = taskCounter++;
    }

    public Task(String name, String description, ArrayList<SubTask> subTasks) {
        this.name = name;
        this.description = description;
        this.status = TaskStatus.NEW;
        this.taskID = taskCounter++;
        this.subTasks.addAll(subTasks);
    }

    public Task(String name, String description, int taskID, ArrayList<Task> tasks) {
        this.taskID = taskID;
        this.tasks = tasks;
        this.name = name;
        this.description = description;
    }

    public Task(String name, String description, int taskID) {
        this.name = name;
        this.description = description;
        this.taskID = taskID;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public int getTaskID() {
        return taskID;
    }

    @Override
    public boolean equals(Object task) {
        if (this == task) {
            return true; // проверяем адреса объектов
        }
        if (task == null) {
            return false; // проверяем ссылку на null
        }
        if (this.getClass() != task.getClass()) {
            return false;
        }
        Task task1 = (Task) task;
        if (this.getTaskID() == task1.getTaskID()) {
            return true;
        }
        return Objects.equals(name, task1.name) && Objects.equals(description, task1.description);
    }

    @Override
    public int hashCode() {
        int hash = 17; // объявляем и инициализируем переменную hash

        hash += name.hashCode();
        hash += 31 * description.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        String fullOutput = "Task";

        fullOutput += "{";
        fullOutput += "name='";
        fullOutput += name;
        fullOutput += "', ";
        fullOutput += "description.length='";
        fullOutput += description.length();
        fullOutput += "', status='";
        fullOutput = fullOutput + getStatus();
        fullOutput += "'";


        if (!subTasks.isEmpty()) {
            fullOutput += ", subTasks.size='";
            int size = 0;
            for (SubTask subTask : subTasks) {
                size++;
            }
            fullOutput += size;
            fullOutput += "'";
        }
        fullOutput += "}";
        return fullOutput;
    }

    public Task getTaskByID(int innerTaskID) {
        return null;
    }

}
