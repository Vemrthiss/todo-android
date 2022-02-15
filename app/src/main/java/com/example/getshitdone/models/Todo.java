package com.example.getshitdone.models;

import android.util.Log;

import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Todo {
    public static final String DEFAULT_NAME = "Default Task";
    private Date _dateCreated = new Date();
    private String _name;
    private Date _dueDate;
    private List<Date> _notificationsList = new ArrayList<Date>();

    public Todo() {
        this.setName(DEFAULT_NAME);
    }
    public Todo(String name, Date dueDate) {
        this.setName(name);
        this.setDueDate(dueDate);
    }
    public Todo(Map<String, Object> document) {
        for (String documentProperty: document.keySet()) {
            Object value = document.get(documentProperty);
            if (documentProperty.equals("name")) {
                String name = value.toString();
                this.setName(name);
            } else if (documentProperty.equals("dateCreated")) {
                Timestamp dateCreated = (Timestamp) value;
                this.setDueDate(dateCreated.toDate());
            }
        }
    }

    public Date getDateCreated() {
        return this._dateCreated;
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
                "_name='" + this.getName() + '\'' +
                ", _dateCreated=" + this.getDateCreated() +
                '}';
    }

    public Map<String, Object> getDocumentRepr() {
        Map<String, Object> document = new HashMap<>();
        document.put("name", this.getName());
        document.put("dateCreated", this.getDateCreated());
        return document;
    }
}