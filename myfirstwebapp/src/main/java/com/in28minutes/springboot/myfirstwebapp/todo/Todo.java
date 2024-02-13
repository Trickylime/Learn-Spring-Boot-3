package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

public class Todo {

    private static int idCounter = 1;
    private int id = idCounter++;
    private String userName;
    private String description;
    private LocalDate targetDate;
    private boolean isDone;

    public Todo(String userName, String description, LocalDate targetDate, boolean isDone) {
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + isDone +
                '}';
    }
}
