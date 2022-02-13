package com.example.getshitdone.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task {
    public static final String DEFAULT_NAME = "Default Task";
    private String _name;
    private Date _dueDate;
    private List<Date> _notificationsList = new ArrayList<Date>();

    public Task() {
        this.setName(DEFAULT_NAME);
    }
    public Task(String name, Date dueDate) {
        this.setName(name);
        this.setDueDate(dueDate);
    }

    public String getName() {
        return this._name;
    }
    public void setName(String newName) {
        this._name = newName;
    }

    public Date getDueDate() {
        return this._dueDate;
    }
    public void setDueDate(Date newDueDate) {
        this._dueDate = newDueDate;
    }

    public List<Date> getNotificationsList() {
        return this._notificationsList;
    }
    public void addNotification(Date notification) {
        this._notificationsList.add(notification);
    }
    public void removeNotification(Date notification) {
        this._notificationsList.remove(notification);
    }
    public void clearAllNotifications() {
        this._notificationsList.clear();
    }

    @Override
    public String toString() {
        return "Task{" +
                "_name='" + _name + '\'' +
                ", _dueDate=" + _dueDate +
                '}';
    }
}