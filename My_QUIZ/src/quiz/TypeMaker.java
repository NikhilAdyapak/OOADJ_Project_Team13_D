package quiz;

public class TypeMaker{
	public Question mcqone;
	public Question mcqtwo;
	
	public TypeMaker() {
		mcqone = new MCQOne();
		mcqtwo = new MCQTwo();
	}
	
	public void qone() {
		mcqone.qarray();
	}
	
	public void qtwo() {
		mcqtwo.qarray();
	}
}
	
