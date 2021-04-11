package com.company.BranchEason;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        int userOption = -1;
        List<Task> taskList = new ArrayList<>();

        while (userOption != 0) {
            System.out.println("Please choose an option");
            System.out.println("(1) add a task");
            System.out.println("(2) Remove a task");
            System.out.println("(3) update a task");
            System.out.println("(4) List all tasks");
            System.out.println("(5) List  all tasks of a certain priority");
            System.out.println("(0) exit");
            userOption = handleExceptionInt("Invalid option");
            switch (userOption) {
                case 0:
                    System.out.println("EXITING");
                    break;
                case 1:
                    addTask(taskList);
                    break;
                case 2:
                    removeTask(taskList);
                    break;
                case 3:
                    updateTask(taskList);
                    break;
                case 4:
                    listTask(taskList);
                    break;
                case 5:
                    listPriorityTask(taskList);
                    break;
                default:
                    System.out.println("This ins not an option, Please use one of the numbers provided");
                    break;
            }
        }
    }

    static  void addTask(List<Task> taskList){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the a task");
        String title= input.nextLine();
        System.out.println("Enter the task description");
        String description= input.nextLine();
        int priority= handleExceptionInt("Enter the tasks priority (0-5)","Invalid input");
        taskList.add(new Task(title, description, priority));
    }

    static  void  removeTask(List<Task> taskList){
        if(!taskList.isEmpty()) {
            int removeIndex = handleExceptionInt("enter the index of the task you want to remove", "Invalid input");
            taskList.remove(removeIndex);
        }else{
            System.out.println("the task list is empty");
        }
    }

    static void  updateTask(List<Task> taskList){
        if(!taskList.isEmpty()) {
            Scanner input= new Scanner(System.in);

            int setIndex = handleExceptionInt("Enter the index of the task you want to update", "Invalid input");
            System.out.println("Enter the a task");
            String title = input.nextLine();
            System.out.println("Enter the task description");
            String description = input.nextLine();
            int priority = handleExceptionInt("Enter the tasks priority (0-5)", "Invalid input");
            Task updatedTask= new Task(title, description, priority);
            taskList.set(setIndex, updatedTask);
        }else {
            System.out.println("the task list is empty");
        }
    }

    static void listTask(List<Task> taskList){
        if(taskList.size()>0){
            boolean taskFound=true;
            for(int i=0;i<taskList.size(); i++){
                Task task=taskList.get(i);
                System.out.println((i)+".\t Title: "+task.getTitle());
                System.out.println((i)+".\t Description: "+task.getDescription());
                System.out.println((i)+".\t Priority: "+task.getPriority());

            }
        }else
        { System.out.println("the task list is empty\n");
        }
    }

    static void listPriorityTask(List<Task> taskList){
        if (taskList.size()>0){
            int priority= handleExceptionInt("Please choose the priority","Invalid tasks");
            boolean taskFound=true;
            for(int i=0;i<taskList.size(); i++){
                Task task=taskList.get(i);
                if (task.getPriority()==priority){
                    System.out.println((i)+".\t Title: "+task.getTitle());
                    System.out.println((i)+".\t Description: "+task.getDescription());
                    System.out.println((i)+".\t Priority: "+task.getPriority());

                }else{
                    taskFound=false;
                }
            }if (taskFound){
                System.out.println("no tasks found in that priority\n");
            }else{
                System.out.println("The task list is empty");
            }
        }
    }

    static int handleExceptionInt(String message,String caughtException) {
        int userInput;
        while (true){
            Scanner input= new Scanner(System.in);
            System.out.println(message);
            try{
                userInput=input.nextInt();
                break;
            }catch(Exception e){
                System.out.println(caughtException);
            }
        }
        return userInput;
    }

    static int handleExceptionInt(String caughtException) {
        int userInput;
        while (true){
            Scanner input= new Scanner(System.in);
            try{
                userInput=input.nextInt();
                break;
            }catch(Exception e){
                System.out.println(caughtException);
            }
        }
        return userInput;
    }
}
