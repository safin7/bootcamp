package InClassWork;
import java.util.Scanner;
import java.util.Vector;

class TODOItem {
    private String task;
    private boolean completed;

    public TODOItem(String task) {
        this.task = task;
        this.completed = false;
    }

    public void MarkAsCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[X] " : "[ ] ") + task;
    }
}

class TODOList {
    private Vector<TODOItem> items;

    public TODOList() {
        items = new Vector<>();
    }

    public void addItem(String task) {
        TODOItem newItem = new TODOItem(task);
        items.add(newItem);
    }

    public void synchronizedRemove(int index) {
        synchronized (items) {
            if (index >= 0 && index < items.size()) {
                items.remove(index);
            } else {
                System.out.println("Invalid index");
            }
        }
    }

    public void MarkAsCompleted(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).MarkAsCompleted();
        } else {
            System.out.println("Invalid index");
        }
    }

    public void displayList() {
        if (items.isEmpty()) {
            System.out.println("TODO List is empty");
        } else {
            System.out.println("TODO List: ");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }
        }
    }
}

 class prac2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TODOList todoList = new TODOList();

        System.out.println("MY LIST");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add an item");
            System.out.println("2. Mark as completed");
            System.out.println("3. Remove an item");
            System.out.println("4. Display the list");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the rest of the line

            switch (option) {
                case 1:
                    System.out.println("Enter the task to add: ");
                    String task = scanner.nextLine();
                    todoList.addItem(task);
                    break;
                case 2:
                    System.out.println("Enter the index of the item to mark as completed: ");
                    int index = scanner.nextInt() - 1;
                    todoList.MarkAsCompleted(index);
                    scanner.nextLine(); // Consume the rest of the line
                    break;
                case 3:
                    System.out.println("Enter the index of the item to remove: ");
                    int removeIndex = scanner.nextInt();
                    todoList.synchronizedRemove(removeIndex);
                    scanner.nextLine(); // Consume the rest of the line
                    break;
                case 4:
                    todoList.displayList();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
