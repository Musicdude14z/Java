
public class Person {
	
	private int age;
	private String firstName, lastName;
	private boolean isMale;
	
	public Person(String firstName, String lastName, int age, boolean isMale) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isMale = isMale;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public boolean getIsMale() {
		return isMale;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setIsMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder(firstName + ' ' + lastName + ", age = " + age);
		b.append(", " + (isMale ? "male" : "female"));
		return b.toString();
	}
	
}
