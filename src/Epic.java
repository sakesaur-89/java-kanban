import java.util.ArrayList;

public class Epic extends Task {
    public ArrayList<Task> tasks = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
    }

    public Epic(String name, String description, ArrayList<Task> tasks) {
        super(name, description);
        this.tasks.addAll(tasks);
    }

    @Override
    public String toString() {
        String fullOutput = super.toString();
        fullOutput = fullOutput.substring(4, fullOutput.length() - 1);
        fullOutput = "Epic" + fullOutput;
        fullOutput += ", tasks.size='";
        int size = 0;
        for (Task task : tasks) {
            size++;
        }
        fullOutput += size;
        fullOutput += "'";
        fullOutput += "}";
        return fullOutput;
    }

    @Override
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

    public void completeTask(int taskID) {
        Task target = getTaskByID(taskID);
        if (target != null) {
            target.setStatus(TaskStatus.DONE);
        }
    }
}
