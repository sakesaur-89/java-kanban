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
        fullOutput = fullOutput.substring(0, fullOutput.length() - 1);
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
}
