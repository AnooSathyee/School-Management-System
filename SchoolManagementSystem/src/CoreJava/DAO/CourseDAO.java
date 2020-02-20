package CoreJava.DAO;

import CoreJava.Models.Course;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is going to be used to query the database for the course’s information only. 
 */
public class CourseDAO {
	
	/**
	 * This method takes no parameter and returns every Course in the table
	 * @return courseList
	 */
	public List<Course> getAllCourses() {
		
		// Course is the type of object to be stored in List
		// Creating a list
		List<Course> courseList = new ArrayList<Course>();
		
		try {
			// Read the CSV file
			File file = new File("courses.csv");
			FileReader fReader = new FileReader(file); // Read content of the file
			BufferedReader bReader = new BufferedReader(fReader); // To read data line by line by readLine()

			String line = bReader.readLine();
			while (line != null) {
				String[] lineArr = line.split(","); // Split the content based on ","
				Course course = new Course(Integer.parseInt(lineArr[0]),
						lineArr[1], lineArr[2]); // using Integer.parseInt to take string as parameter
				courseList.add(course);
				line = bReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return courseList;
	}
}
