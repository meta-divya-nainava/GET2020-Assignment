package linkedList;

public class Employee {
	private Integer empId;
	private String name;
	private Integer age;
	private Integer salary;
	/**
	 * constructor to initialize Employee class. 
	 * @param empId
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(int empId, String name, int age, int salary)
	{
		this.empId=empId;
		this.name=name;
		this.age=age;
		this.salary=salary;
	}
	/**
	 * 
	 * @return empId
	 */
	public Integer getEmpId() {
		return empId;
	}
	/**
	 * 
	 * @return employee name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return employee age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 
	 * @return salary
	 */
	public Integer getSalary() {
		return salary;
	}
	@Override
	public int hashCode() {
		return this.empId.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Employee employee = (Employee)obj;
		return this.empId.equals(employee.empId);
	}

}
