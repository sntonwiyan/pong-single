import java.io.*;

public class Highscore {
	public static int get () {
		int highscore = 0;
		
		BufferedReader r = null;
		try {
			r = new BufferedReader(
					new FileReader("highscore.txt")
			);
			
			highscore = Integer.parseInt(r.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (r != null)
					r.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return highscore;
	}
	
	public static void set (int highscore) {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(
					new FileWriter("highscore.txt")
			);
			
			w.write("" + highscore);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (w != null)
					w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
