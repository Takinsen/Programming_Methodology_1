package Student;

public class CEDTStudent extends Student {
	private String TA = "AJ.Toe";

	public String getTA() {
		return TA;
	}

	public void setTA(String tA) {
		TA = tA;
	}
	
	@Override
	public String toString() {
		return this.name + " is CEDT!";
	}
}
