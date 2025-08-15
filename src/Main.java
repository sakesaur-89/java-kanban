import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Task projectCreation = new Task("Этот проект", "Первый шаг - создать сами задания");
        ArrayList<SubTask> creationSubTasks = new ArrayList<>();
        SubTask coding = new SubTask("Написать код", "", creationSubTasks);
        SubTask planning = new SubTask("Проектировка","", creationSubTasks);
        creationSubTasks.add(coding);
        creationSubTasks.add(planning);
        Task projectCreationComplex = new Task("Разбиение", "Второй шаг, делить задания на малые подзадания",
                creationSubTasks);
        System.out.println(projectCreation);
        System.out.println(projectCreationComplex);
        ArrayList<Task> assignmentTasks = new ArrayList<>();
        assignmentTasks.add(projectCreation);
        assignmentTasks.add(projectCreationComplex);
        Epic epic = new Epic("задание","проверка работы приложения", assignmentTasks);
        System.out.println(epic);
        System.out.println(epic.tasks.size());
    }
}
