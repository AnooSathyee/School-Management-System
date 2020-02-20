package CoreJava.Models;

public class Attending {

	private int courseID;
	private String studentEmail;

	public Attending() {

	}

	public Attending(int courseID, String studentEmail) {
		this.courseID = courseID;
		this.studentEmail = studentEmail;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	// toString() method returns a string representation of the object
	public String toString() {
		return "Attending - courseId : " + courseID + "; studentEmail : " + studentEmail;
	}
}
