/**
 * ID#111504873, Kevin Gabayan
 */
public class Planner {
	final int MAX_COURSES = 50;
	Course[] Planner = new Course[MAX_COURSES];
	/**
	 * @param MAX_COURSES
	 * The maximum number of courses the Planner can have.
	 * @param Planner
	 * Initializes the course array.
	 */

	/**
	 * This is a constructor for creating a new planner.
	 * <dt><b>Postconditions:</b><dd>
	 * This planner has been initialized to an empty list of courses.
	 */
	public Planner() {
	}
	/**
	 * This is a method for finding the number of courses currently in the list.
	 * <dt><b>Precondition:</b><dd>
	 * This Planner has been instantiated
	 * @return
	 * Returns the size of the planner.
	 */
	public int size() {
		int count = 0;
		for(int i = 0; i < MAX_COURSES; i++) {
			if(this.Planner[i] != null) { 
				count++;
			}
		}
		return count;
		}
	/**
	 * A method that adds a new course to a certain position on the list.
	 * @param newCourse
	 * The new course to add to the list.
	 * @param position
	 * The position (preference) of this course on the list.
	 * <dt><b>Preconditions:</b><dd>
	 * This Course has been instantiated and 1 <= position <= planner.size() + 1. The number of Course
	 * objects in this Planner is less than MAX_COURSES.
	 * <dt><b>Postconditions:</b><dd>
	 * The new Course is now listed in the correct preference, and all courses originally greater than or equal to the position
	 * are moved back one position.
	 * @throws IllegalArgumentException
	 * Indicates that position is not within the valid range.
	 * @throws FullPlannerException
	 * Indicates that there is no more room in the Planner to record an additional course.
	 */
	public void addCourse(Course newCourse, int position) throws IllegalArgumentException, FullPlannerException {
		int index = (position-1);
		if(position < 1 || this.size() + 1 < position)
			throw new IllegalArgumentException("Your position is not in the valid range!");
		else if (this.size() >= MAX_COURSES) 
			throw new FullPlannerException("There is no more room in the planner"
					+ " to record an additonal course!");
		Course temp = Planner[index];
		Course temp2;
		int presize = this.size();
		for(int i = index; i <= presize; i++) {
			if(i==index) {
				Planner[i] = newCourse;
			}
			else {
				temp2 = Planner[i];
				Planner[i] = temp;
				temp = temp2;
			}
		}
		}
	/**
	 * A method that adds a new course to the end of the list.
	 * @param newCourse
	 * The new course to add to the list.
	 */
	public void addCourse(Course newCourse) throws FullPlannerException {
		this.addCourse(newCourse, this.size() + 1);
		
	}
	/**
	 * This class creates the FullPlannerException necessary for the previous methods.
	 * @author Kevin Gabayan
	 *
	 */
	public class FullPlannerException extends Exception {
		public FullPlannerException(String message) {
			super(message);
	}
	}
	/**
	 * This method removes a Course from the Planner at the selected position.)
	 * @param position
	 * The position in the Planner where the Course will be removed from.
	 * @throws IllegalArgumentException
	 * Indicates that position is not in the valid range.
	 * <dt><b>Preconditions:</b><dd>
	 * This Planner has been instantiated and 1 <= position <= this.size()
	 * <dt><b>Postconditions: </b><dd>
	 * The Course at the desired position has been removed... all Courses
	 * greater than or equal to position are moved backwards one position.
	 */
	public void removeCourse(int position) throws IllegalArgumentException {
		int index = (position-1);
		if(index < 0 || this.size() < position) 
			throw new IllegalArgumentException("Your position is not in the valid range!");
		Course temp = Planner[index];
		Course temp2;
		for(int i = index; i <= this.size()-1;i++) {
			Planner[i] = Planner[i+1];
			}
		}
	/**
	 * This method retrieves a Course from the Planner.
	 * @param position
	 * The position of the Course to retrieve.
	 * <dt><b>Preconditions:</b><dd>
	 * The Planner object has been instantiated and 1 <= position <= this.size()
	 * @return
	 * Returns the Course at the specified position in this Planner object.
	 * @throws IllegalArgumentException
	 * Indicates that position is not within the valid range.
	 */
	public Course getCourse(int position) throws IllegalArgumentException {
		int index = position - 1;
		if(index <= 0 || this.size() + 1 > position)
			throw new IllegalArgumentException("Your position is not in the valid range!");
		return Planner[index];
	}
	/**
	 * Prints all Courses that are within the specified department/
	 * @param planner
	 * The list of courses to search in/
	 * @param department
	 * The 3 letter department code for a course.
	 * <dt><b>Preconditions:</b><dd>
	 * This Planner object has been instantiated.
	 * <dt><b>Postconditions:</b><dd>
	 * Displays a nearly formatted table of each course filtered from the
	 * Planner. Keep the preference numbers the same. 
	 */
	public static void filter(Planner planner, String department) {
		for(int i = 0; i < planner.size(); i++) {
			if(planner.Planner[i].getDepartment().equals(department)) {
				System.out.printf("%3d %-25s %10s %-4d      %02d %-24s\n", i+1, planner.Planner[i].getCourseName(),
				  planner.Planner[i].getDepartment(), planner.Planner[i].getCode(), planner.Planner[i].getSection(),
				  planner.Planner[i].getInstructor());
			}
		}
	}
	/**
	 * This method checks whether or not a certain Course is already on the list.
	 * @param course
	 * The course we are looking for.
	 * <dt><b>Preconditions:</b><dd>
	 * This Planner and Course has both been instantiated
	 * @return
	 * True if the Planner contains this Course, false otherwise
	 */
	public boolean exists(Course course) {
		for(int i = 0; i < this.size(); i++) {
			if(course.equals(this.Planner[i])) {
				return true;
			}
		}
		return false;
	}
	/**
	 * This method creates a copy of the Planner.
	 * <dt><b>Preconditions:</b><dd>
	 * This Planner object has been instantiated.
	 * @return
	 * A copy of this Planner object.
	 */
	public Object clone() {
		Planner clone = new Planner();
		for(int i = 0; i < this.size(); i++) {
			clone.Planner[i] = this.Planner[i]; 
		}
		return clone;
	}
	/**
	 * Prints a nearly formatted table of each item in the list with its position number.
	 * <dt><b>Preconditions:</b><dd>
	 * This Planner object has been instantiated.
	 * <dt><b>Postconditions:</b><dd>
	 * Displays a nearly formatted table of each course of each course from the Planner. 
	 */
	public void printAllCourses() {
		System.out.print(toString());
	}
	/**
	 * This method prints a String representation of the Planner object.
	 * @return
	 * The String representation of this Planner object.
	 */
	public String toString() {
		String string = "";
		for(int i = 0; i < this.size(); i++) {
			string += String.format("%3d %-25s %10s %-4d      %02d %-24s\n", i+1, this.Planner[i].getCourseName(),
					  this.Planner[i].getDepartment(), this.Planner[i].getCode(), this.Planner[i].getSection(),
					  this.Planner[i].getInstructor());
		}
		return string;
	}
}