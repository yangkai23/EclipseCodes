package conceptual;

import java.util.Arrays;

public class Student {
	static int arraySize;
	static Student students[];
	int studentId;
	String studentName;
	String email;
	long mobileNumber;
	double gpa;
	{
		arraySize++;
	}

	public Student(int studentId, String studentName, String email, long mobileNumber, double gpa) {
		if (gpa < 0) {
			System.err.println("Gpa must be positive");
			return;
		}
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.gpa = gpa;
	}

	public Student(int studentId, String studentName, double gpa) {
		this.studentId = studentId;
		this.studentName = studentName;
		if (gpa < 0)
			return;
		this.gpa = gpa;
	}

	public Student(int studentId, String studentName, double gpa, String email) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		if (gpa < 0)
			return;
		this.gpa = gpa;
	}

	public Student(int studentId, String studentName, long mobileNumber, double gpa) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		if (gpa < 0)
			return;
		this.gpa = gpa;
	}

	public Student() {
	}

	@Override
	public String toString() {
		if (this.studentName == null)
			return "";
		String result = "\n" + "Student Details:\n-----------------------------------------------\n" + "Student ID : "
				+ this.studentId + "\n" + "Student Name : " + this.studentName + "\n" + "Student GPA : " + this.gpa
				+ "\n";
		if (this.email == null && this.mobileNumber == 0)
			return result;
		else if (this.email == null)
			return result + "Student Mobile : " + this.mobileNumber + "\n";
		else if (this.mobileNumber == 0)
			return result + "Student  Email ID : " + this.email + "\n";
		else
			return result + "Student Mobile : " + this.mobileNumber + "\n" + "Student  Email ID : " + this.email + "\n";

	}

	public static void findTopperByGpa() {
		System.out.print("Top Scorer :");
		Student resultStudent = new Student();
		for (Student student : students) {
			resultStudent = student.gpa > resultStudent.gpa ? student : resultStudent;
		}
		System.out.println(resultStudent
				+ "*****************************************************************************************************\n");
	}

	public static void findTopperByGpaAfterStandings() {
		System.out.println("Top Scorer :");
		System.out.println(students[0]
				+ "*****************************************************************************************************\n");

	}

	public static void getFailedStudents() {
		System.out.println("Failed Students :");
		int count = 0;
		for (Student student : students) {
			if (student.gpa < 5) {
				System.out.println(student);
				count++;
			}
		}
		if (count == 0) {
			System.out.println(
					"No failures\n*****************************************************************************************************\n");
			return;
		}
		System.out.println(
				"*****************************************************************************************************\n");
	}

	public static void printStandings() {
		System.out.println("Class Standings");
		// selection sort
		for (int i = 0; i < students.length; i++) {
			int max = i;
			for (int j = i + 1; j < students.length; j++) {
				if (students[j].gpa > students[max].gpa) {
					max = j;
				}
			}
			swapStudents(students, i, max);
		}
		for (int i = 0; i < students.length; i++) {
			if (students[i].gpa < 5)
				continue;
			System.out.println("Rank " + (i + 1) + " : \n" + "Student ID : " + students[i].studentId + "\n"
					+ "Student Name : " + students[i].studentName + "\nStudent GPA : " + students[i].gpa + "\n"
					+ "*****************************************************************************************************\n");
		}
	}

	public static void printStudentDetails() {
		Arrays.stream(students).forEach(student -> System.out.print(student));
	}

	public static void swapStudents(Student[] arr, int i, int j) {
		Student temp = students[i];
		students[i] = students[j];
		students[j] = temp;
	}

	public static void main(String[] args) {
		Student s1 = new Student(131, "Anirudh", "amirudhshanmukha2399@gmail.com", 9398538741L, 8.02);
		Student s2 = new Student(111, "Vishnu", 8.56);
		Student s3 = new Student(29, "Revanth", 9632587741L, 9.06);
		Student s4 = new Student(26, "Tarun", 6.24, "tarun@gmail.com");
		Student s5 = new Student(12, "Prahith", 9.44, "prahith@gmail.com");
		Student s6 = new Student(27, "Hrushi", 7.26);
		students = new Student[arraySize];
		printStudentDetails();
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		students[3] = s4;
		students[4] = s5;
		students[5] = s6;
//		findTopperByGpa();
//		getFailedStudents();
//		printStandings();
//		findTopperByGpaAfterStandings();
	}
}
