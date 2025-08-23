import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        ArrayList<SubTask> subTaskArray = new ArrayList<>();
        Epic epic = new Epic("", "");
        Epic epic1 = new Epic("все подзадачи эпика", "");
        Epic epic2 = new Epic("все подзадачи эпика", "");
        TaskManager taskManager = new TaskManager();

        SubTask subTask1 = new SubTask("task0", "nontent");
        SubTask subTask2 = new SubTask("task-1", "nontent");
        subTaskArray.add(subTask1);
        subTaskArray.add(subTask2);
        Task task1 = new Task("task", "content");
        Task task2 = new Task("task2", "content");
        Task task3 = new Task("task3", "content", subTaskArray);
        Task task4 = new Task("task 6", "content 6", subTaskArray);
        epic1.tasks.add(task1);
        epic1.tasks.add(task2);
        epic1.tasks.add(task3);
        epic2.tasks.add(task3);
        epic2.tasks.add(task4);
        taskList.add(task2);

        System.out.println("Метод toString в случае класса Epic");
        System.out.println(epic1);
        System.out.println("Метод toString в случае класса SubTask");
        System.out.println(subTask1);
        System.out.println("Метод toString в случае класса Task");
        System.out.println(task1);
        //Добавляем объекты в поле Tasks нашего менеджера

        taskManager.setTask(task4, task4.subTasks);
        taskManager.setTask(epic1, epic1.tasks);
        taskManager.setTask(epic2, epic2.tasks);
        taskManager.setTask(subTask1);
        taskManager.setTask(epic);
        // при создании эпика в taskManager его задачи передаются в метод создания отдельно
        System.out.println("Вложенная задача в объекте epic, статус при создании");
        System.out.println(task1.getStatus());
        taskManager.statusUpdate(epic1.getTaskID());
        System.out.println("Эпик 1 изначальное состояние при создании");
        System.out.println(epic1.getStatus());

        // вручную меняем статусы задач
        taskManager.tasksByID.get(epic1.getTaskID()).tasks.getFirst().setStatus(TaskStatus.DONE);
        taskManager.tasksByID.get(epic2.getTaskID()).tasks.get(1).setStatus(TaskStatus.DONE);
        taskManager.tasksByID.get(epic1.getTaskID()).tasks.get(2).setStatus(TaskStatus.DONE);
        taskManager.statusUpdate(epic1.getTaskID());
        taskManager.statusUpdate(epic2.getTaskID()); // эта функция также вызывается в методе создания

        System.out.println("Эпик 1, статус IN_PROGRESS");
        System.out.println(taskManager.getTaskByID(epic1.getTaskID()).getStatus());
        System.out.println("Эпик 2, статус DONE");
        System.out.println(taskManager.getTaskByID(epic2.getTaskID()).getStatus());
        System.out.println("Вывод по типу, подзадачи:");
        taskManager.printTaskList(subTask1);
        System.out.println("Удаление по типу, эпики:");
        taskManager.clearTasks(epic);
        taskManager.printTaskList();
        System.out.println("Задачи:");
        taskManager.clearTasks(task1);
        taskManager.printTaskList();
        System.out.println("Подзадачи:");
        taskManager.clearTasks(subTask1);
        taskManager.printTaskList();
        System.out.println("(пусто)");
        System.out.println("Создаем задачи заново через аргументы createTask:");

        taskManager.createTask("task", "content");
        taskManager.createTask("task", "content", subTaskArray);
        taskManager.createEpic("task", "content");
        taskManager.createEpic("task", "content", taskList);

        taskManager.printTaskList();
    }
}