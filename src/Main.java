import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        ArrayList<SubTask> subTaskArray = new ArrayList<>();

        SubTask notTask = new SubTask("task0","nontent");
        SubTask notTask2 = new SubTask("task-1","nontent");
        subTaskArray.add(notTask);
        subTaskArray.add(notTask2);
        Task added = new Task("task", "content");
        Task added2 = new Task("task2", "content");
        Task added3 = new Task("task3", "content", subTaskArray);
        taskList.add(added3);
        taskList.add(added);
        taskList.add(added2);

        Epic theEpic = new Epic("все подзадачи эпика", "", taskList);
        TaskManager taskManager = new TaskManager();

        taskManager.setATask(theEpic, theEpic.getTaskID(), theEpic.tasks);
        taskManager.setATask(added3, added3.getTaskID());
        taskManager.printTaskLists();

        System.out.println(added.getStatus());
        System.out.println(taskList.getFirst().getStatus());
        System.out.println(taskManager.getTaskByID(theEpic.getTaskID()).getTaskByID(added.getTaskID()).getStatus());
        taskManager.printTaskLists();
        System.out.println(taskManager.getTaskByID(added3.getTaskID()).subTasks);
    }
}
