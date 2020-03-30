package employee;

public class Employee {
	private Integer empId;
	private String name;
	private String address;
	/**
	 * constructor to initialize variable
	 * @param empId
	 * @param name
	 * @param address
	 * @throws Exception
	 */
	
	public Employee(int empId, String name, String address) throws Exception {
		if(name == null || name.length() == 0) {
			throw new Exception("Null or empty name not allowed!");
		}
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	/**
	 * 
	 * @return empId
	 */
	public int getEmpId() {
		return this.empId;
	}
	/**
	 * 
	 * @return employee name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * 
	 * @return address
	 */
	public String getAddress() {
		return this.address;
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