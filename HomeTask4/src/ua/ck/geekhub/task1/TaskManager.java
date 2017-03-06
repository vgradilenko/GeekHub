package ua.ck.geekhub.task1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public interface TaskManager {

    void add(LocalDateTime date, Task task);

    void remove(LocalDateTime date) throws NoSuchElementException;

    Set<String> getCategories();

    //For next 3 methods tasks should be sorted by date
    Map<String, List<Task>> getTasksByCategories(String... categories);

    List<Task> getTasksByCategory(String category);

    List<Task> getTasksForToday();
}

