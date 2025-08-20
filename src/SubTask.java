import java.util.ArrayList;

public class SubTask extends Task {

    public SubTask(String name, String description) {
        super(name, description);
    }

    public SubTask(String name, String description, int taskID) {
        super(name, description, taskID);
    }

    @Override
    public String toString() {
        String fullOutput = super.toString();
        fullOutput = fullOutput.substring(4, fullOutput.length() - 1);
        fullOutput = "Subtask" + fullOutput;
        fullOutput += "}";
        return fullOutput;
    }


}
