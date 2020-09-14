public class BreakDemo_1 {
	public static void main(String[] args) {
		a: for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("j=" + j);
				break a;
			}
			System.out.println("i=" + i);
		}
	}
}