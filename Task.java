package TaskManager;
import java.util.*;
public class Task {
  private String title;
  private String description;
  private boolean completed;
  private static int nextTaskId = 1001;
  private int taskId;
  public Task(String title,String description) {
	  this.title=title;
	  this.description=description;
	  this.completed=false;
	  this.taskId = nextTaskId++;
	  
	  
  }
  public int getTaskId() {
	  return taskId;
  }
  public String getTitle() {
	  return title;	 
}
  public String getDescription() {
	  return description;
}
  public boolean isCompleted() {
	  return completed;
}
  public void setTitle(String title) {
	  this.title=title;
}
  public void setDescription(String description) {
	  this.description=description;
}
  public void setCompleted(boolean completed) {
	  this.completed=completed;
}
  public  void displaytasks() {
	  System.out.println("Id: "+ getTaskId());
	  System.out.println("Title: "+ getTitle());
	  System.out.println("Description: "+ getDescription());
	  System.out.println("Completed:" + isCompleted());
	

}
}
