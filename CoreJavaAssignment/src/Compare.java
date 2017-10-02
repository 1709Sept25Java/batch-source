//Question 7
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Compare {
	

	public static void main(String[] args) {
		List<Employee> employee = new ArrayList<Employee>();
		Employee e1 = new Employee("Nancy","News",23);
		Employee e2 = new Employee("John","Mgt",33);
		
		employee.add(e1);
		employee.add(e2);
		
		Collections.sort(employee);
		Employee[] userEmp = {e1,e2};
		Arrays.sort(userEmp);
		
		for(Employee employee1 : userEmp) {
			System.out.println(employee1);
		}
	}

}
