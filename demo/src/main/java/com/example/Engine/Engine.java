package com.example.Engine;

import java.util.Scanner;

import com.example.controller.controller;



public class Engine {
    public Engine() {}

    public void start() {
        controller ct = new controller();
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a command: ");

        try {
            while (true) {
                System.out.println();
                String operation = scn.nextLine();

                if(operation.equals("exit")) {
                    break;
                }

                String[] inputParts = operation.split(" ");
            String command = inputParts[1];
            
            switch (command) {
                case "add" -> {
                    if (inputParts.length > 1) {
                        String[] inp = operation.split(" ", 3);
                        String taskDescription = inp[2];
                        System.out.println(taskDescription);
                        ct.addTask(taskDescription);
                    } else {
                        System.out.println("No task description provided.");
                    }
                    }

                case "delete" -> {
                    int id = Integer.parseInt(inputParts[2]);
                    String result = ct.deleteTask(id);
                    System.out.print(result);
                    }

                case "list" -> {
                    if(inputParts.length > 2) {
                        String showType = inputParts[2];
                        System.out.println(ct.listTasks(showType));
                    } else {
                        System.out.println(ct.listTasks("all"));
                    }
                    
                    // if(inputParts.length > 1) {
                    //     String showType = inputParts[2];
                    //     // System.out.println(showType);

                    // } else {
                    //     System.out.println(ct.listTasks());
                    // }
                }

                case "update" -> {
                    String[] updateOperation = operation.split(" ", 4);
                    String taskDescription = updateOperation[3];
                        int id = Integer.parseInt(inputParts[2]);
                        ct.updateTask(id, taskDescription);
                    }
                
                case "mark-done" -> {
                    int id = Integer.parseInt(inputParts[2]);
                    ct.updateStatus("done", id);
                }

                case "mark-in-progress" -> {
                    int id = Integer.parseInt(inputParts[2]);
                    ct.updateStatus("in-progress", id);
                }

                case "to-do" -> {
                    int id = Integer.parseInt(inputParts[2]);
                    ct.updateStatus("todo", id);
                }

                default -> System.out.println("Invalid command.");
            }
            }
            scn.close();
        } catch (NumberFormatException e) {
        }
    }
    
}
