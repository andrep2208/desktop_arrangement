package desktop_arrangement;
public class Main {

	public static void main(String[] args) {

		Arranger arranger = new Arranger();
		arranger.setPath("C:\\Users\\vpham\\Desktop");
		arranger.createFolder();
		arranger.reArrange();
		
	}

}
