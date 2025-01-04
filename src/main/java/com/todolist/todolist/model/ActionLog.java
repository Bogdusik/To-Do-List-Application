package com.todolist.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Entity
public class ActionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String actionName;
    private String taskDescription;  // Description of the task
    private boolean actionPerformed;
    private ZonedDateTime date;  // Use ZonedDateTime for UTC time

    public ActionLog() {}

    public ActionLog(String actionName, String taskDescription, boolean actionPerformed) {
        this.actionName = actionName;
        this.taskDescription = taskDescription;
        this.actionPerformed = actionPerformed;
        this.date = ZonedDateTime.now(ZoneOffset.UTC);  // Set the current UTC time
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean isActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(boolean actionPerformed) {
        this.actionPerformed = actionPerformed;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ActionLog{" +
                "id=" + id +
                ", actionName='" + actionName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", actionPerformed=" + actionPerformed +
                ", date=" + date +
                '}';
    }
}