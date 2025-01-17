package Student;

public class MySchool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("Aj.Pop");
		Student s2 = new CEDTStudent();
		Student s3 = new CPStudent();
		
		CEDTStudent s4 = (CEDTStudent) s2;
		CEDTStudent s5 = (CEDTStudent) s3;
	}

}
