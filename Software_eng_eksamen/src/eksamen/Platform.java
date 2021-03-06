package eksamen;

import java.util.ArrayList;
import java.util.List;

public abstract class Platform {
	//private List<ProjectManager> projectManagers;
	private static List<Employee> employees = new ArrayList ();
	private static List<Employee> availableEmployees = new ArrayList ();
	private static List<Project> projects = new ArrayList ();
	
	/*public List<ProjectManager> getProjectManagers(){
		return projectManagers;
	}*/
	
	public static List<Employee> getEmployees(){
		return employees;
	}
	
	public static List<Employee> getAvailableEmployees(){
		return availableEmployees;
	}
	
	public static List<Project> getProjects(){
		return projects;
	}
	
	/*public void editProjectManagers(ProjectManager projectManager){
		Boolean found = false;
		for(int i=0; i<projectManagers.size(); i++){
			if(projectManagers.get(i).equals(projectManager)){
				projectManagers.remove(i);
				found=true;
			}
		}
		if(found==false){
				projectManagers.add(projectManager);
		}
	}*/
	
	public static void editEmployee(Employee employee){
		Boolean found = false;
		for(int i=0; i<employees.size(); i++){
			if(employees.get(i).equals(employee)){
				employees.remove(i);
				found=true;
			}
		}
		if(found==false){
				employees.add(employee);
		}
	}
	
	public static void editProjects(Project project){
		Boolean found = false;
		for(int i=0; i<projects.size(); i++){
			if(projects.get(i).equals(project)){
				projects.remove(i);
				found=true;
			}
		}
		if(found==false){
				projects.add(project);
		}
	}
	
	/*public static void editAvailableEmployee(Employee availableEmployee){
		Boolean found = false;
		for(int i=0; i<availableEmployees.size(); i++){
			if(availableEmployees.get(i).equals(availableEmployee)){
				availableEmployees.remove(i);
				found=true;
			}
		}
		if(found==false){
			availableEmployees.add(availableEmployee);
		}
	}*/
	
	public static void update(){
		availableEmployees.clear();
		for(int i=0; i<employees.size(); i++){
			if(employees.get(i).isFree()){
				availableEmployees.add(employees.get(i));
			}
		}
	}
}
