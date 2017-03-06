package ua.ck.geekhub.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Diary implements TaskManager {

    private Map<LocalDateTime, Task> tasksByDate;

    public Diary() {
        this.tasksByDate = new HashMap<>();
    }

    public Map<LocalDateTime, Task> getTasksByDate() {
        return tasksByDate;
    }

    @Override
    public void add(LocalDateTime date, Task task) {
        this.tasksByDate.put(date, task);
    }

    @Override
    public void remove(LocalDateTime date) throws NoSuchElementException {
        for (Map.Entry<LocalDateTime, Task> entry : tasksByDate.entrySet()) {
            if (entry.getKey().equals(date)) {
                System.out.println("removed " + entry.getValue());
                this.tasksByDate.remove(entry.getKey());
            } else {
                throw new NoSuchElementException("date not found");
            }
        }
    }

    @Override
    public Set<String> getCategories() {
        Set<String> categories = new HashSet<>();

        for (Map.Entry<LocalDateTime, Task> entry : tasksByDate.entrySet()) {
            categories.add(entry.getValue().getCategory());
        }

        return categories;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> tasksByCategories = new HashMap<>();

        for (String category : categories) {
            tasksByCategories.put(category, getTasksByCategory(category));
        }

        return tasksByCategories;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        Map<LocalDateTime, Task> sortedTasksByDate = new TreeMap<>(tasksByDate);
        List<Task> tasks = new ArrayList<>();

        for (Map.Entry<LocalDateTime, Task> entry : sortedTasksByDate.entrySet()) {
            if (entry.getValue().getCategory().equals(category)) {
                tasks.add(entry.getValue());
            }
        }

        return tasks;
    }

    @Override
    public List<Task> getTasksForToday() {
        Map<LocalDateTime, Task> sortedTasksByDate = new TreeMap<>(tasksByDate);
        List<Task> tasksForToday = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (Map.Entry<LocalDateTime, Task> entry : sortedTasksByDate.entrySet()) {
            if (entry.getKey().toLocalDate().equals(today)) {
                tasksForToday.add(entry.getValue());
            }
        }

        return tasksForToday;
    }
}
