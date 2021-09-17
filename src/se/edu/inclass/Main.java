package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

        System.out.println("Printing deadlines");
        printDeadlines(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));
        printDataWithStreams(tasksData);
        printDeadlinesUsingStream(tasksData);

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlineesUsingStream(ArrayList<Task> tasks) {
        int count = 0;
        tasks.stream()
                .filter((t) -> t instanceof Deadline)
                .count();
        return count
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    private static void printDataWithStreams (ArrayList<Task> tasks) {
        System.out.println("Printing data using stream");
        tasks.stream()  //convert data to stream
                .forEach((System.out::println)); //terminal operator
    }

    public static void printDeadlinesUsingStream (ArrayList<Task> tasks) {
        System.out.println("Printing deadlines using stream");
        tasks.stream()
                .filter((t)-> t instanceof Deadline) //Filers using LAMBDA
                .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        ArrayList<Task> deadlinees = new ArrayList<>();
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }
}
