package eksamen;

import java.awt.print.Printable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Project{
	
	String name;
	List<Employee> projectEmployee;
	List<Activity> projectActivities;
	
	public Project(List<Employee> projectEmploye, List<Activity> projectActivities, String name){
		this.projectEmployee=projectEmploye;
		this.projectActivities=projectActivities;
		this.name=name;
	}

	public void createActivity(Date start, Date end, String description, String id){	
		Activity newActivity = new Activity(start, end, description, id);
		projectActivities.add(newActivity);
		
	}
	
	public void editActivity(Date newEndTime, Activity activity){
		activity.editEndDate(newEndTime);		
	}
	
	public Boolean assignActivity(List<Employee> employees, Activity activity){		
		Boolean success=false;
		int goodEmployees=0;
		for(int i=0; i<employees.size(); i++){
			if(!(employees.get(i).viewActivities().size()>20)){
				employees.get(i).addActivity(activity);
				goodEmployees++;
			}else{
				System.out.println(employees.get(i)+" could not be assigned");
			}
		}
		if(goodEmployees==employees.size()){
			success=true;
		}	
		return success;
	}
	
	public List<Activity> createReport(){
		List<Activity> finishedActivities = new ArrayList();
		for(int i=0; i<projectActivities.size(); i++){
			System.out.println(projectActivities.get(i).getDescription()+" " + projectActivities.get(i).getFinished());
		if(projectActivities.get(i).getFinished()){
			finishedActivities.add(projectActivities.get(i));
		}
		}
		return finishedActivities;
	}
	
	public List<Activity> viewEmployeeActivities(Employee e){
		return e.viewActivities();
	}
	
	public String viewActivity(Activity activity){
		return "Start: "+activity.getStartDate()+ " End: "+ activity.getEndDate()+ " Description: "+ activity.getDescription(); 
	}
	
	public void createProject(List<Activity> activities){
		projectActivities=activities;
	}
	
	public void addEmployee(Employee employee){
		projectEmployee.add(employee);
	}
	
}
