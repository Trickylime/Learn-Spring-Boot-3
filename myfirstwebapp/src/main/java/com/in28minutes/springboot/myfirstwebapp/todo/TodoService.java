package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(todosCount++, "Jack", "Learn AWS1",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "Jack", "Learn DevOps1",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo(todosCount++, "Jack", "Learn Full Stack Development1",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {

        Predicate<? super Todo> predicate =
                todo -> todo.getUserName().equalsIgnoreCase(username);

        return todos.stream().filter(predicate).toList();
    }

    public Todo addTodo(String username, String description,
                        LocalDate targetDate, boolean isDone) {

        Todo todo = new Todo(todosCount++, username, description, targetDate, isDone);
        todos.add(todo);
        return todo;
    }

    public void deleteById(int id) {

        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateToDo(Todo todo) {
        System.out.println("Todo id = " + todo.getId());
        deleteById(todo.getId());
        todos.add(todo);
    }
}
