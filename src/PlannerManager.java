/**
 * ID#111504873, Kevin Gabayan
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class PlannerManager {
	/**
	 * This method generates the menu.
	 */
	public static void menuGeneration() {
		System.out.println("(A) Add Course");
		System.out.println("(G) Get Course");
		System.out.println("(R) Remove Course");
		System.out.println("(P) Print Courses in Planner");
		System.out.println("(F) Filter by Department Code");
		System.out.println("(L) Look For Course");
		System.out.println("(S) Size");
		System.out.println("(B) Backup");
		System.out.println("(PB) Print Courses in Backup");
		System.out.println("(RB) Revert to Backup");
		System.out.println("(Q) Quit");
		System.out.println();
		System.out.print("Enter a selection: ");
	}
	/**
	 * This method generates the table header when printing out courses in a tabular
	 * form.
	 */
	public static void tableHeader() {
		System.out.println("No. Course Name               Department Code "
				+ "Section Instructor");
		System.out.println("----------------------------------------"
				+ "---------------------------------------");
	}
	/**
	 * This is the main method for each of the options in the menu.
	 * @throws Planner.FullPlannerException
	 * Is thrown when the planner is full.
	 * @throws InputMismatchException
	 * Is thrown when you enter a value of the wrong type.
	 * @throws NullPointerException
	 * Is thrown when the position is invalid.
	 * @throws ArrayIndexOutOfBoundsException
	 * Is thrown when the position is invalid.
	 */
	public static void main(String[] args) throws Planner.FullPlannerException, InputMismatchException, NullPointerException, ArrayIndexOutOfBoundsException {
		Scanner input = new Scanner(System.in);
		menuGeneration();
		String selection = input.nextLine();
		System.out.println();
		Planner planner = new Planner();
		Planner cloned = new Planner();
		boolean end = false;
		while(end == false) {
			// Add Course
			if(selection.equals("A") || selection.equals("a")) {
				String coursename;
				String department;
				int courseCode;
				byte courseSection;
				String instructor;
				int position;
				try {
				System.out.print("Enter course name: ");
					coursename = input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.print("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter department: ");
					department = input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.print("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter course code: ");
					courseCode = input.nextInt();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
					input.nextLine();
					System.out.print("Enter course section: ");
					courseSection = input.nextByte();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
					input.nextLine();
					System.out.print("Enter instructor: ");
					instructor = input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
					System.out.print("Enter position: ");
					position = input.nextInt();
					input.nextLine();
					System.out.println();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				Course addCourse = new Course(coursename, department, courseCode, courseSection, instructor);
				try {
				if (planner.exists(addCourse)) {
					System.out.println("Course already exists!");
					System.out.println();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				if(position == planner.size() + 1) {
					planner.addCourse(addCourse); 
					if(courseSection < 10) {
						System.out.println(department + " " + courseCode + "." + "0" + courseSection + " successfuly added to planner."); }
					else
						System.out.println(department + " " + courseCode + "." + courseSection + " successfully added to planner.");
				}
				else {
					planner.addCourse(addCourse, position);
					if(position < 10) {
						System.out.println(department + " " + courseCode + "." + "0" + courseSection + " successfuly added to planner."); }
					else
						System.out.println(department + " " + courseCode + "." + courseSection + " successfully added to planner.");
					}
				System.out.println();
				}
				catch(Planner.FullPlannerException e) {
					System.out.println("Your planner is full! Returning to main menu.");
					System.out.println();
					menuGeneration();
					selection = input.nextLine();
					continue;
				}
				catch(IllegalArgumentException e) {
					System.out.println("Position invalid! Returning to main menu.");
					System.out.println();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
			}
			// Get Course
			else if(selection.equals("G") || selection.equals("g")) {
				int i;
				try {
				System.out.print("Enter position: ");
				i = input.nextInt(); // Let i = position
				System.out.println();
				input.nextLine(); 
				tableHeader();
				System.out.printf("%3d %-25s %10s %-4d      %02d %-24s\n", i, planner.Planner[i-1].getCourseName(),
						  planner.Planner[i-1].getDepartment(), planner.Planner[i-1].getCode(), planner.Planner[i-1].getSection(),
						  planner.Planner[i-1].getInstructor());
				System.out.println();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Error! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Error! Returning to main menu.");
					System.out.println();
					menuGeneration();
					selection = input.nextLine();
					continue;
				}
				catch(NullPointerException e) {
					System.out.println("Error! Returning to main menu.");
					System.out.println();
					menuGeneration();
					selection = input.nextLine();
					continue;
				}
			}
			// Remove Course
			else if(selection.equals("R") || selection.equals("r")) {
				int removeposition;
				try {
				System.out.print("Enter position: ");
				removeposition = input.nextInt();
				input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.print("Error! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				System.out.println();
				try {
				if(planner.Planner[removeposition-1].getSection() >= 10) {
					System.out.println(planner.Planner[removeposition-1].getDepartment() +
					  " " + planner.Planner[removeposition-1].getCode() + "." + planner.Planner[removeposition-1].getSection() +
					    " has been successfuly removed from the planner."); }
				else
					System.out.println(planner.Planner[removeposition-1].getDepartment() +
							  " " + planner.Planner[removeposition-1].getCode() + ".0" + planner.Planner[removeposition-1].getSection() +
							    " has been successfuly removed from the planner.");
				planner.removeCourse(removeposition);
				System.out.println(); }
				
				catch(NullPointerException e) {
					System.out.println("Invalid Position! Returning to main menu.");
					System.out.println();
					menuGeneration();
					selection = input.nextLine();
					continue;
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid Position! Returning to main menu.");
					System.out.println();
					menuGeneration();
					selection = input.nextLine();
					continue;
					}
				}
			// Print Courses in Planner
			else if(selection.equals("P") || selection.equals("p")) {
				System.out.println("Planner:");
				tableHeader();
				planner.printAllCourses();
				System.out.println();
			}
			// Filter by Department Code
			else if(selection.equals("F") || selection.equals("f")) {
				System.out.print("Enter department code: ");
				String filtercode = input.nextLine();
				tableHeader();
				Planner.filter(planner, filtercode);
				System.out.println();
			}
			// Look for Course
			else if(selection.equals("L") || selection.equals("l")) {
				String courseNameLook;
				String departmentLook;
				int courseCodeLook;
				byte courseSectionLook;
				String instructorLook;
				try {
				System.out.print("Enter course name: ");
				courseNameLook = input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter department: ");
				departmentLook = input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter course code: ");
				courseCodeLook = input.nextInt();
				input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter course section: ");
				courseSectionLook = input.nextByte();
				input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				try {
				System.out.print("Enter instructor: ");
				instructorLook = input.nextLine();
				System.out.println();
				}
				catch(InputMismatchException e) {
					System.out.println();
					System.out.println("Wrong type! Returning to main menu.");
					System.out.println();
					input.nextLine();
					menuGeneration();
					selection = input.nextLine();
					System.out.println();
					continue;
				}
				Course look = new Course(courseNameLook,departmentLook,courseCodeLook,courseSectionLook,instructorLook);
				if(planner.exists(look)) {
					for(int i = 0; i < planner.size(); i++) {
						if(planner.Planner[i].equals(look)) {
							if(i + 1 >= 10) {
								System.out.println(planner.Planner[i].getDepartment() +
								  " " + planner.Planner[i].getCode() + "." + planner.Planner[i].getSection() +
								    " is found in the planner at position " + (i+1) + ".");
								System.out.println(); }
							else
								System.out.println(planner.Planner[i].getDepartment() +
										  " " + planner.Planner[i].getCode() + ".0" + planner.Planner[i].getSection() +
										    " is found in the planner at position " + (i+1) + ".");
								System.out.println();}
						}
					}
				else {
					System.out.println("Planner does not exist!");
					System.out.println();
				}
				}
			// Size
			else if(selection.equals("S") || selection.equals("s")) {
				int size = planner.size();
				if(size == 1) {
					System.out.println("There is " + size + " course in the planner.");
					System.out.println();
				}
				else {
					System.out.println("There are " + size + " courses in the planner.");
				}
				System.out.println();
			}
			// Backup
			else if(selection.equals("B") || selection.equals("b")) {
				cloned = (Planner)planner.clone();
				System.out.println("Crated a backup of the current planner.");
				System.out.println();
			}
			// Print Courses in Backup
			else if(selection.equals("PB") || selection.equals("pb")) {
				System.out.println("Backup Planner:");
				tableHeader();
				cloned.printAllCourses();
				System.out.println();
			}
			// Revert to Backup
			else if(selection.equals("RB") || selection.equals("rb")) {
				planner = cloned;
				System.out.println("Planner successfully reverted to the backup copy.");
				System.out.println();
			}
			// Quit
			else if(selection.equals("Q") || selection.equals("q")) {
				System.out.println("Program terminating successfully...");
				end = true;
				continue;
			}
			else {
				System.out.println("Invalid command. Try again!");
				System.out.println();
			}
			menuGeneration();
			selection = input.nextLine();
			System.out.println();
			
	}
}
}
	