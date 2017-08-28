import java.util.ArrayList;
import javafx.scene.shape.Shape;
import javafx.scene.*;

public class Playground {
	private static ArrayList<Node> list = new ArrayList<Node>();
	private static int score = 0;
	public static Group items;
	public static boolean gover = false;
	
	public static void add(Node s) {
		list.add(s);
	}

	public static Node get(int i) {
		return list.get(i);
	}

	public static int getScore() {
		return score;
	}

	public static void increaseScore() {
		score += 5;
	}
	
	
}
