package p10_package;

public class StudentClass 
{
	public String name;
	public int studentID;
	public char gender;
	public double gpa;
	
	public StudentClass(String inName,
            int inStudentID,
            char inGender,
            double inGPA)
	{
		name = inName;
		studentID = inStudentID;
		gender = inGender;
		gpa = inGPA;
	}
	public StudentClass(StudentClass copied)
	{
		name = copied.name;
		studentID = copied.studentID;
		gender = copied.gender;
		gpa = copied.gpa;
	}
	public int compareTo(StudentClass other)
	{
		//Overrides Object compareTo with local
		//Returns number greater than zero if this object greater than other;
		return (int) (this.gpa - other.gpa);
		//returns number less than zero if this object less than other; 
		//returns zero if this object equal to other
		
	}
	public String toString()
	{
		return name + '/' + studentID + '/' + gender + '/' + gpa;
	}






	

}
