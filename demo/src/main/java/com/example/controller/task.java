package com.example.controller;

import java.time.LocalTime;

import org.json.JSONObject;

public class task {

    private String taskDescription;
    private LocalTime createdAt;
    private LocalTime updatedAt;
    private int taskId;
    private String status;   



    public task(String taskdes) {
        this.taskDescription = taskdes;
        this.createdAt = LocalTime.now();
        this.updatedAt = null;
        this.status = "todo";
    }

    public void setTaskID(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskID() {
        return taskId;
    }
    public void setStatus(String task_status) {
        this.status = task_status;
    }
    
   
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription.trim();
    }

    public String getStatus() {
        return status;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public JSONObject toJSONObject() {
        JSONObject json = new JSONObject();
        json.put("description", this.taskDescription);
        json.put("created", this.createdAt.toString());
        if(this.updatedAt!=null) {
            json.put("updated", this.updatedAt.toString());
        } else {
            json.put("updated", JSONObject.NULL);
        }
        json.put("status", this.status);

        return json;
    }

}
