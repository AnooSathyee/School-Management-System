package CoreJava.DAO;

import CoreJava.Models.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	/**
	 * This method reads the Students.csv file and returns the data as a List
	 */

	public List<Student> getStudents() {

		List<Student> studentList = new ArrayList<Student>();

		try {
			// Read the CSV file
			File file = new File("students.csv");
			FileReader fReader = new FileReader(file); // Read content of the file - each line
			BufferedReader bReader = new BufferedReader(fReader);

			// Read content of the file - each line
			if (bReader != null) {
				String line = bReader.readLine();
				while (line != null) {
					String[] lineArr = line.split(","); // Split the content
					// based on comma ","
					Student student = new Student(lineArr[0], lineArr[1],
							lineArr[2]); // create a student bean with the split
					// values
					studentList.add(student); // Add the bean or entity to studentList
					line = bReader.readLine();
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return studentList;// Return the List

	}

	/**
	 * This method takes a Student’s email as a String and the List of Students
	 * as an ArrayList and parses the List for a Student with that email and
	 * returns a Student Object.
	 * 
	 * @param studentList
	 * @param studentEmail
	 * @return student
	 */

	public Student getStudentByEmail(List<Student> studentList,
			String studentEmail) {
		Student student = null;

		// for each student in studentList
		for (Student tempStudent : studentList) {
			// check for each email and if email matches return student
			if (tempStudent.getEmail().equals(studentEmail)) {
				student = tempStudent;
			}
		}

		return student;
	}

	/**
	 * This method takes the List of Students and two other parameters: the
	 * first one is the user email and the second one is the password from the
	 * user input. Return whether or not a student was found
	 */

	public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass) {
		//System.out.println("validateUser :- (" + studentEmail + ", " + studentPass + ")");
		boolean validUser = false;

		// for each student in studentList
		for (Student tempStudent : studentList) {
			//System.out.println(tempStudent);
			// Check for each email and Password and return validUser
			if (tempStudent.getEmail().equals(studentEmail) && tempStudent.getPass().equals(studentPass)) {
				validUser = true;
			}
		}
		return validUser;

	}

}
