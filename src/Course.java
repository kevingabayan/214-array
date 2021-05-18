/**
 * ID#111504873, Kevin Gabayan
 */
public class Course {
	private String courseName;
	private String department;
	private int code;
	private byte section;
	private String instructor;
	
	/**
	 * Course variables
	 * @param courseName
	 * The name of the course
	 * @param department
	 * The department of the course
	 * @param code
	 * The code of the course
	 * @param section
	 * The section of the course
	 * @param instructor
	 * The instructor of the course
	 */
	
	/**
	 * This is a constructor for creating a new course.
	 */
	public Course (String courseName, String department, int code, byte section, String
	  instructor) {
		this.courseName = courseName;
		this.department = department;
		this.code = code;
		this.section = section;
		this.instructor = instructor;
	}
	/**
	 * This method retrieves the course name.
	 * @return 
	 * The course name.
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * This method retrieves the course department.
	 * @return
	 * The course department.
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * This method retrieves the course code.
	 * @return
	 * The course code.
	 */
	public int getCode() {
		return code;
	}
	/**
	 * This method retrieves the course section.
	 * @return
	 * The course section.
	 */
	public byte getSection() {
		return section;
	}
	/**
	 * This method retrieves the course instructor.
	 * @return
	 * The course instructor.
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * This method sets the course name.
	 * @param newCourseName
	 * The string that will become the new course name.
	 */
	public void setCourseName(String newCourseName) {
		courseName = newCourseName;
	}
	/**
	 * This method sets the course department.
	 * @param newDepartment
	 * The string that will become the new department name.
	 */
	public void setDepartment(String newDepartment) {
		department = newDepartment;
	}
	/**
	 * This method sets the course code, and throws an exception when the code is negative.
	 * @param newCode
	 * The number that will be the new course code.
	 * @throws IllegalArgumentException
	 * Indicates that the code cannot be negative.
	 */
	public void setCode(int newCode) throws IllegalArgumentException {
		if(newCode >= 0)
			code = newCode;
		else
			throw new IllegalArgumentException("Code cannot be negative!");
	}
	/**
	 * This method sets the course section, and throws an exception when the section is negative.
	 * @param newSection
	 * The number that will be the new course section.
	 * @throws IllegalArgumentException
	 * Indicates that the section cannot be negative.
	 */
	public void setSection(byte newSection) throws IllegalArgumentException {
		if(newSection >= 0)
			section = newSection;
		else
			throw new IllegalArgumentException("Section cannot be negative!");
	}
	/**
	 * This method sets the course instructor.
	 * @param newInstructor
	 * The name of the new instructor.
	 */
	public void setInstructor(String newInstructor) {
		instructor = newInstructor;
	}
	/**
	 * This method makes a deep clone of the Course object.
	 * @return
	 * The clone of the Course.
	 */
	public Object clone() {
		Course c = new Course(this.courseName, this.department,
		  this.code, this.section , this.instructor);
		return c;
	}
	/**
	 * This method tests if one object is equal to the other.
	 * @param obj
	 * The object that is being compared to.
	 * @return
	 * Whether the object is equal to the one being compared to or not.    
	 */
	public boolean equals(Object obj) {
		boolean tf = false;
		if(this == obj)
			tf = true;
		else if ((obj instanceof Course)) {
			Course o = (Course)obj;
			if(o.getCourseName().equals(this.courseName) && o.getDepartment().equals(this.department) && o.getCode() == this.code
					&& o.getSection() == this.section && o.getInstructor().equals(this.instructor)) {
				tf = true;
			}
		}
		return tf;
	}
}


