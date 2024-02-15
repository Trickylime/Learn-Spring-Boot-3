package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo("Jack", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo("Jack", "Learn DevOps",
                LocalDate.now().plusYears(2), false));
        todos.add(new Todo("Jack", "Learn Full Stack Development",
                LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description,
                        LocalDate targetDate, boolean isDone) {

        Todo todo = new Todo(username, description, targetDate, isDone);
        todos.add(todo);
    }
}
