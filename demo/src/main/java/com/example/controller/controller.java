package com.example.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class controller {
    private final Map<Integer, task> obj = new HashMap<>();
    private final Set<String> hSet = new HashSet<>();
    private static final String FILE_NAME = "tasks.json";

    private int taskId = 0;

    public void addTask(String task){
        if(hSet.contains(task)) {
            System.out.print("Task already exists");
        } else {
            taskId++;
            task addTask = new task(task);
            addTask.setTaskID(taskId);
            addTask.setTaskDescription(task);
            obj.put(addTask.getTaskID(), addTask);
            saveTasksToFile();
            hSet.add(task);
            System.out.printf("Task added successfully! (ID: %d)",addTask.getTaskID());
        }           
    }

    public String deleteTask(int id) {
        if(!obj.containsKey(id)){
            return "Failure in deletion!";
        } else {
            task removedTask = obj.remove(id);
            saveTasksToFile();
            hSet.remove(removedTask.getTaskDescription());
            return "Deletion Success!";            
        }       
    }

    public void updateTask(int id, String val) {
        if(!obj.containsKey(id)) {
            System.out.printf("No task with task ID: %d exists!",id );
        } else {
            task updateTask = obj.get(id);

            hSet.remove(updateTask.getTaskDescription());
            hSet.add(val);

            updateTask.setTaskDescription(val);
            updateTask.setUpdatedAt(LocalTime.now());
            saveTasksToFile();
            System.out.printf("Task %d updated successfully! Updated @ %s%n",id,updateTask.getUpdatedAt());
        }
    }

    public void updateStatus(String status, int id) {
        if(!obj.containsKey(id)) {
            System.out.printf("No task with task ID: %d exists", id);
        } else {
            task setStatus = obj.get(id);
            setStatus.setStatus(status);
            setStatus.setUpdatedAt(LocalTime.now());
            saveTasksToFile();
        }
    }

    public void listTasks(String type){
        JSONObject tasksJSON = new JSONObject();
        if(obj.isEmpty()) {
            System.out.println("No tasks to show, add them!");
        } else if(type.equals("all")) {
            for(Map.Entry<Integer, task> e : obj.entrySet()) {
                tasksJSON.put(String.valueOf(e.getKey()), e.getValue().toJSONObject());
            }
        } else {
            for(Map.Entry<Integer, task> e : obj.entrySet()) {
                if(e.getValue().getStatus().equals(type)) {
                    tasksJSON.put(String.valueOf(e.getKey()), e.getValue().toJSONObject());
                }
            }
        }
        System.out.println(tasksJSON.toString(4));
    }

    public void saveTasksToFile() {
        JSONArray jsonArr = new JSONArray();

        for(task t: obj.values()) {
            jsonArr.put(t.toJSONObject());
        }
        
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(jsonArr.toString(4));
            file.flush();
            System.out.println("Tasks saved to: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error trying to save the file..");
        }
    }
}
