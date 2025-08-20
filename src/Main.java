import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Task added = new Task("task", "content");
        Task added2 = new Task("task2", "content");
        Task added3 = new Task("task3", "content");
        taskList.add(added);
        taskList.add(added2);
        Epic theEpic = new Epic("все подзадачи эпика", "", taskList);
        TaskManager tTaskManager = new TaskManager();
        tTaskManager.setATask(theEpic, theEpic.getTaskID(), theEpic.tasks);
        tTaskManager.setATask(added3, added3.getTaskID());
        tTaskManager.printTaskLists();
        System.out.println(added.getStatus());
        System.out.println(taskList.getFirst().getStatus());
        tTaskManager.completeTaskOfEpic(2,added.getTaskID());
        System.out.println(tTaskManager.getTaskByID(theEpic.getTaskID()).getTaskByID(added.getTaskID()).getStatus());
        System.out.println(tTaskManager.getTaskByID(2).getStatus());
        tTaskManager.removeTaskByID(added3.getTaskID());
        //tTaskManager.printTaskLists();
        tTaskManager.setATask(theEpic, added3.getTaskID());
        tTaskManager.printTaskLists();
    }
}
