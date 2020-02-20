package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is going to be used to query the database for Attending’s
 * information.
 */
public class AttendingDAO {

	/**
	 * This method reads the Attending.csv file and returns the data as a List
	 * 
	 * @return atteding List
	 */
	public List<Attending> getAttending() {

		// Attending is the type of object to be stored in List
		// Creating a list
		List<Attending> attendingList = new ArrayList<Attending>();

		try {
			// Read the CSV file
			File file = new File("attending.csv");
			FileReader fReader = new FileReader(file); // Read content of the file
			BufferedReader bReader = new BufferedReader(fReader); // To read data line by line by readLine()

			String line = bReader.readLine();
			while(line !=null) {
				String[] lineArr = line.split(",");
				Attending attending = new Attending(Integer.parseInt(lineArr[0]), lineArr[1]);
				attendingList.add(attending);
				line = bReader.readLine();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return attendingList;
	}

	/**
	 * This method takes a Student’s email and a Course ID. It checks if a
	 * Student with that Email is currently attending a Course with that ID. If
	 * the student is not attending that Course, add a new Attending object with
	 * the Student’s Email and Course ID to the List.
	 */
	public void registerStudentToCourse(List<Attending> attending, String studentEmail, int courseID) {

		boolean isAlreadyRegistered = false;

		// for each loop for iterating list
		for (Attending att : attending) {
			if (att.getStudentEmail().equals(studentEmail)&& att.getCourseID() == courseID) {
				// System.out.println("Student already registerd!");
				isAlreadyRegistered = true;
			}
		}

		if (isAlreadyRegistered != true) {
			attending.add(new Attending(courseID, studentEmail));
		}

		saveAttending(attending);
	}

	/**
	 * This method takes a Student’s Email as a parameter and would search the Attending List 
	 * for all the courses a student is registered to base on the Id. 
	 * Each of these is added to a new list of courses. This list of courses the student is 
	 */

	public List<Course> getStudentCourses(List<Course> courseList,List<Attending> attending, String studentEmail) {

		// Course is the type of object to be stored in List
		// Creating a list
		List<Course> studentCourseList = new ArrayList<Course>();

		// Get Attending list for student
		List<Attending> studentAttendingList = new ArrayList<Attending>();

		// For each student attending list get attending based on studentEmail
		for (Attending attend : attending) {
			if (attend.getStudentEmail().equals(studentEmail)) {
				studentAttendingList.add(attend);
				// System.out.println("Adding Attending... " + attend);
			}
		}

		// Get Course List of Attending
		// For each course in courseList
		// check the ID and the courseID
		for (Attending attend : studentAttendingList) {
			for (Course course : courseList) {
				if (course.getID() == attend.getCourseID()) {
					studentCourseList.add(course);
					// System.out.println("Adding Course... " + course);
				}
			}
		}
		return studentCourseList;
	}

	public void saveAttending(List<Attending> attending){

		File file = new File("attending.csv");
		FileWriter fWriter = null; // Java write file using Filewriter 
		BufferedWriter bWriter = null;

		try {
			fWriter = new FileWriter(file);
			bWriter = new BufferedWriter(fWriter);
			for (Attending attend : attending) {
				String line = attend.getCourseID() + "," + attend.getStudentEmail();
				bWriter.write(line);
				bWriter.newLine();
			}
			//System.out.println("Data updated in the file!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}