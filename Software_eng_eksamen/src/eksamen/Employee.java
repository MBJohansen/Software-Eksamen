package eksamen;

import java.sql.Date;
import java.util.List;

import javax.activity.ActivityCompletedException;

public class Employee {
	private boolean free = true;
	private List<Activity> activities;
	private List<Activity> allActivities;
	private Activity currentActivity;
	private String ID;
	private Project currentProject;
	private Boolean isProjectManager = false;
	
	public Employee(List<Activity> activities, String ID, Project currentProject){
		this.ID=ID;
		this.activities=activities;
		this.allActivities=activities;
		this.currentProject=currentProject;
		Platform.editEmployee(this);

	}
	
	public void makeManager(String projectName){
		isProjectManager=true;
		Project newProject = new Project(null, null,projectName);
		currentProject=newProject;
		Platform.editProjects(newProject);
	}
	
	public Project getProjectInChargeOf(){
		if(isProjectManager){
			return currentProject;
		}
		return null;
	}
	
	public void setActivity(List<Activity> activities){
		this.activities=activities;
		this.allActivities=activities;
		if(activities.equals(null)){
			
		}else{
		free=false;
		currentActivity=activities.get(0);
		}
	}
	
	public void addActivity(Activity activity){
		activities.add(activity);
		allActivities.add(activity);
		free=false;
	}
	
	
	public void SearchHelp(Activity activity){
		Platform.update();
		Platform.getAvailableEmployees().get(0).addActivity(activity);
	}
	
	/*public void RegisterTime(Activity activity, Date date, Boolean pastEvent){
		
	}*/
	
	public boolean Edit(Date start, Date end, Activity activity){
		for(int i =0; i<allActivities.size(); i++){
			if(allActivities.get(i).equals(activity)){
				allActivities.get(i).setStartDate(start);
				allActivities.get(i).setEndDate(end);
				return true;
			}
		}
		return false;
	}
	
	public List<Activity> viewActivities(){
		return activities;
	}
	
	public long getActiveTime(String activityID){
		for(int i = 0; i<allActivities.size();i++){
			if(allActivities.get(i).getID().equals(activityID)){
				return (allActivities.get(i).getEndDate().getTime()-allActivities.get(i).getStartDate().getTime())/3600000;
			}
		}
		return 0;
	}
	
	public String toString(){
		return ID;
	}
	
	public void endActivity(){
		currentActivity.setFinished();
		activities.remove(0);
		if(activities.size()>0){
		currentActivity = activities.get(0);
		}else{
			free=true;
			Platform.update();
		}
	}
	
	public boolean isFree(){
		return free;
	}

}
