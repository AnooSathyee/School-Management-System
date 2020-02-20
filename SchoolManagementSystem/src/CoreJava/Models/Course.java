package CoreJava.Models;

public class Course {
	
	private int courseID;
	private String courseName;
	private String instructor;
	
	// Default constructor
	
	public Course(){
		
	}
	
	// Parameterized constructor
	
	public Course(int courseID, String courseName, String instructor){
		this.courseID = courseID;
		this.courseName = courseName;
		this.instructor = instructor;
	}

    public void setID(int ID){
    	this.courseID = ID;
    }

    public int getID() {
    	return courseID;
    }

    public void setName(String name){
    	this.courseName = name;
    }

    public String getName(){
    	return courseName;
    }

    public void setInstructor(String instructor){
    	this.instructor = instructor;
    }

    public String getInstructor(){
    	return instructor;
    }
    
    public String toString(){
    	return "Course - ID : " + courseID + "; Name : " + courseName + "; Intructor : " + instructor;
    }

}
