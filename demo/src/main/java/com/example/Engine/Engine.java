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
                    if (inputParts.length >= 3) {
                        String[] inp = operation.split(" ", 3);
                        String taskDescription = inp[2];
                        if (taskDescription.startsWith("\"") && taskDescription.endsWith("\"")) {
                                taskDescription = taskDescription.substring(1, taskDescription.length() - 1);
                            }
                        System.out.println(taskDescription);
                        ct.addTask(taskDescription);
                    } else {
                        System.out.println("No task description provided.");
                    }
                    }

                case "delete" -> {
                    if(inputParts.length >= 3) {
                        try {
                            int id = Integer.parseInt(inputParts[2]);
                            String result = ct.deleteTask(id);
                            System.out.print(result);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a number.");
                        }
                    } else {
                        System.out.println("Please provide a TaskID for deletion.");
                    }
                    
                    }

                case "list" -> {
                    if(inputParts.length > 2) {
                        String showType = inputParts[2];
                        ct.listTasks(showType);
                    } else {
                        ct.listTasks("all");
                    }
                }

                case "update" -> {
                    if(inputParts.length >= 4) {
                        try {
                            String[] updateOperation = operation.split(" ", 4);
                            int id = Integer.parseInt(inputParts[2]);
                            String taskDescription = updateOperation[3];
                            if (taskDescription.startsWith("\"") && taskDescription.endsWith("\"")) {
                                taskDescription = taskDescription.substring(1, taskDescription.length() - 1);
                            }
                            ct.updateTask(id, taskDescription);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a number.");
                        }
                    } else {
                        System.out.println("Please provide the right TaskID and a description to update.");
                    }
                    
                    }
                
                case "mark-done" -> {
                    if(inputParts.length >= 3) {
                        try {
                            int id = Integer.parseInt(inputParts[2]);
                            ct.updateStatus("done", id);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a number.");
                        }
                    } else {
                        System.out.println("Please provide the right taskID.");
                    }
                    
                }

                case "mark-in-progress" -> {
                    if(inputParts.length >= 3 ) {
                        try {
                            int id = Integer.parseInt(inputParts[2]);
                            ct.updateStatus("in-progress", id);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a number.");
                        }
                    } else {
                        System.out.println("Please provide the right taskID.");
                    }
                }

                case "to-do" -> {
                    if(inputParts.length >= 3 ) {
                        try {
                            int id = Integer.parseInt(inputParts[2]);
                            ct.updateStatus("todo", id);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID. Please enter a number.");
                        }
                    } else {
                        System.out.println("Please provide the right taskID.");
                    }
                }

                default -> System.out.println("Invalid command.");
            }

            }
            scn.close();
        } catch (NumberFormatException e) {
            System.out.println("An unexpected number format occured..");
            e.printStackTrace();
        }
    }
    
}
