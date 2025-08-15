import java.util.ArrayList;

public class SubTask extends Task {

    public SubTask(String name, String description) {
        super(name, description);
    }
    public SubTask(String name, String description, ArrayList<SubTask> creationSubTasks) {
        super(name, description, creationSubTasks);
    }
}
