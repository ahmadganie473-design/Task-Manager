package TaskManager;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class TaskManager {
	public static void saveTasks(ArrayList<Task> tasks) {
		try {
	        FileWriter writer = new FileWriter("tasks.txt");
	        for(Task t : tasks) {
	            writer.write(t.toFileString() + "\n");
	        }
	        writer.close();
		} catch(IOException e) {
	        System.out.println("Something went wrong saving the tasks.");
	        e.printStackTrace();
	    }
	}
	public static void loadTasks(ArrayList<Task> tasks) {
		try {
	        File file = new File("tasks.txt");
	        Scanner fileInput = new Scanner(file);
	        while(fileInput.hasNextLine()) {
	            String line = fileInput.nextLine();
	            String[] parts = line.split("\\|");
	            int taskId = Integer.parseInt(parts[0]);
	            String title = parts[1];
	            String description = parts[2];
	            boolean completed = Boolean.parseBoolean(parts[3]);
	            Task task = new Task(taskId, title, description, completed);
	            tasks.add(task);
	            }
	        fileInput.close();
		} catch(IOException e) {
	        System.out.println("Something went wrong loading the tasks.");
	    }
	}
	public static void main(String[] args) {
			   Scanner input = new Scanner(System.in);
	           ArrayList<Task> tasks = new ArrayList<>();
	           loadTasks(tasks);
	            for (int i = 0; i < 100; i++) {
                 int choice;
                   System.out.println("____Task Manager____");
	               System.out.println("\n1. Create New Task");
	               System.out.println("2. Look at Current Tasks");
	               System.out.println("3. Update Tasks");
	               System.out.println("4. Remove Task");
	               System.out.println("5. Exit Application");
	               System.out.print("__Enter Choice: ");
	               choice = input.nextInt();
	               input.nextLine();
	               if (choice < 1 || choice > 5) {
	            	   System.out.println("Invalid Choice");
	               }
	               if (choice == 1) {
	            	   System.out.println("__Add Task Selected__");
	            	   System.out.print("Task Title: ");
	                   String title = input.nextLine();
	                   if (title.isEmpty()) {
	                	   System.out.println("Invalid Title");
	                       continue;
	                   }
	                   System.out.print("Enter Description: ");
	                   String description = input.nextLine();
	                   if (description.isEmpty()) {
	                	   System.out.println("Invalid Description");
	                       continue;
	                   }
	                   Task task = new Task(title, description);
	                   tasks.add(task);
	                   saveTasks(tasks);
	                   System.out.println("Task Created!");
	               }

	               else if (choice == 2) {
	            	   System.out.println("Look at Current Tasks Selected");
	            	   if (tasks.isEmpty()) {
	            		   System.out.println("There are no tasks.");
	            	   } else {
	            		   for (Task t : tasks) {
	            			   t.displaytasks();
	                           System.out.println("--------------------");
	                       }
	                   }
	               }
	               else if (choice == 3) {
	            	   boolean found = false;
	            	   System.out.println("Update Task Selected");
	                   System.out.println("Search id of the Task you want to update:");
	                   int SearchId = input.nextInt();
	                   for (Task t : tasks) {
	                	   if (t.getTaskId() == SearchId) {
	                		   found = true;
	                           System.out.println("Enter New Completion Status (true/false): ");
	                           boolean NewisCompleted = input.nextBoolean();
	                           t.setCompleted(NewisCompleted);
	                           saveTasks(tasks);
	                           System.out.println("Status Updated!");
	                       }
	                   }
	                   if (!found) {
	                	   System.out.println("Task is not Found");
	                   }
	                   input.nextLine();
	               }
	               else if (choice == 4) {
	            	   System.out.println("Remove Task Selected");
	                   System.out.println("Enter id of Task You want to remove:");
	                   int removeID = input.nextInt();
	                   boolean found = false;
	                   Iterator<Task> iterator = tasks.iterator();
	                   while (iterator.hasNext()) {
	                	   Task t = iterator.next();
	                	   if (t.getTaskId() == removeID) {
	                		   iterator.remove();
	                		   found = true;
	                           System.out.println("Task Removed!");
	                       }
	                   }
	                   if (!found) {
	                	   saveTasks(tasks);
	                   }
	                   input.nextLine();
	               }
	               else if (choice == 5) {
	            	   System.out.println("Exit Selected");
	            	   break;
	               }
	           }
	            input.close();
	       }
	   }
	   

	
	

