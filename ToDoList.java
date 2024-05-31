package DSA;
public class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTitle().equals(title)) {
                current.getTask().markCompleted();
                break;
            }
            current = current.getNext();
        }
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            Task task = current.getTask();
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + task.isCompleted());
            System.out.println("-----------------------------");
            current = current.getNext();
        }
    }


    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();


        toDoList.addToDo(new Task("Task 1", "Completing assignments and submit them on time"));
        toDoList.addToDo(new Task("Task 2", "prepare for final exams"));
        toDoList.addToDo(new Task("Task 3", "Review Class Projects"));
        toDoList.addToDo(new Task("Task 4", "Go for walk"));
        toDoList.addToDo(new Task("Task 5", "Go to sleep at 4:00"));

        toDoList.markToDoAsCompleted("Task 2");
        toDoList.viewToDoList();
    }
}