package CoreJava.MainEntryPoint;

import java.util.ArrayList;
import java.util.List;

import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.CourseDAO;
import CoreJava.DAO.StudentDAO;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;

public class TestRunner {
	public static void main(String[] args) {
		// Test Your Code Here!

		// Tests for StudentDAO
		// To test the getStudents() 
		/*
		StudentDAO studentDAO = new StudentDAO();
		List<Student> studentList = studentDAO.getStudents();

		for (int i = 0; i < studentList.size(); i++) {
			Student student = (Student) studentList.get(i);
			System.out.println(student);
		}

		for (Student student : studentList) {
			System.out.println(student);
		}

		// To test the getStudentByEmail()
		Student student = studentDAO.getStudentByEmail(studentList,
				"joe@gmail.com");
		System.out.println(student);

		// To test the vaidateUser()
		System.out.println("validateUser: "
				+ studentDAO.validateUser(studentList, "joe@gmail.com",
						"jc2142"));

		 */


		/*	
		// To test the CourseDAO

		CourseDAO courseDAO = new CourseDAO();
		List<Course> courseList = courseDAO.getAllCourses();
		for (Course course : courseList) {
			System.out.println(course); 
		}

		 */
		// To test the AttendingDAO

		AttendingDAO attendingDAO = new AttendingDAO();
		/*
		List<Attending> attendingList = attendingDAO.getAttending();
		System.out.println(attendingList.size());
		System.out.println("<<< Before registering >>>");
		for(Attending attending : attendingList) {
			System.out.println(attending);
		}

		attendingDAO.registerStudentToCourse(attendingList, "tom@gmail.com", 2);

		System.out.println("<<< After registering >>>");
		for(Attending attend : attendingList) {
			System.out.println(attend);
		}

		CourseDAO courseDAO = new CourseDAO();
		System.out.println("<<< Student Courses List >>>");
		List<Course> studentCourseList = attendingDAO.getStudentCourses(courseDAO.getAllCourses(), attendingList, "joe@gmail.com");
		for(Course course : studentCourseList) {
			System.out.println(course);
		}
		*/
		
		/*
		List<Attending> newAttendingList = new ArrayList<Attending>();
		newAttendingList.add(new Attending(1, "anu@gmail.com"));
		newAttendingList.add(new Attending(2, "vaishu@gmail.com"));
		newAttendingList.add(new Attending(3, "anan@gmail.com"));
		newAttendingList.add(new Attending(4, "sathiya@gmail.com"));
		attendingDAO.saveAttending(newAttendingList);
		*/
		
		
	}

}

