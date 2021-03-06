package eksamen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Test;

public class TestProject {
	
	@After
	public void doReset(){
		Platform.reset();
	}
	
	// Tests the creation of a project and assigning a projectmanager
	@Test
	public void testMakeManager() {
		Employee employee = new Employee(null, "INIT", null);
		
		assertFalse(employee.isProjectManager());
		
		assertEquals(0,Platform.getProjects().size());
		
		employee.makeManager("Project1");
		
		assertEquals(1,Platform.getProjects().size());
		
		assertTrue(employee.isProjectManager());
	}
	
	// Tests
	@Test
	public void testEndProject() {
		Employee employee = new Employee(null, "INIT", null);
		
		employee.makeManager("Project1");
		
		assertTrue(employee.getProjectInChargeOf().isActive());
		
		employee.endProject();
		
		assertFalse(Platform.getProject("Project1").isActive());
	}
	
//	// Tests the creation of an activity with an estimated time (begin and end date)
//	@Test
//	public void testCreateActivity() {
//		Employee employee = new Employee(null, "INIT", null);
//		
//	}
//	
//	// Tests the projectmanager assigning an activity
//	@Test
//	public void testAssignActivity() {
//		Employee employee = new Employee(null, "INIT", null);
//		
//	}
//	
//	// Tests the 
//	@Test
//	public void testEndActivity() {
//		Employee employee = new Employee(null, "INIT", null);
//		
//	}
//	
//	// Tests editing the used time on an activity
//	@Test
//	public void testEditActivityUsedTime() {
//		Employee employee = new Employee(null, "INIT", null);
//		
//	}
//	
//	// Tests editing the estimated time of an activity
//	@Test
//	public void testEditActivityEstimatedTime() {
//		Employee employee = new Employee(null, "INIT", null);
//		
//	}
//	
//	@Test
//	public void testViewActivity() {
//		Employee employee = new Employee(null, "INIT", null);
//		
//	}
//	
//	@Test
//	public void test() {
//		Employee employee = new Employee(null, "INIT", null);
//		
//	}
//	
//	@Test
//	public void test() {
//		Employee employee = new Employee(null, "INIT", null);
//		
//	}
}
