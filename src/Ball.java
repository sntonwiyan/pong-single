import javafx.scene.shape.*;

public class Ball extends Rectangle {
	private double[] velocity = {0, 0};
	
	public Ball (int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void setVelocity(double[] v){
		velocity = v;
	}
	
//	public double getX() {
//		return getBoundsInParent().getMinX();
//	}
//	
//	public double getY() {
//		return getBoundsInParent().getMinY();
//	}
	
	public void move(){
		//relocate(getX() + velocity[0], getY() + velocity[1]);
		setLayoutX(getLayoutX() + velocity[0]);
		setLayoutY(getLayoutY() + velocity[1]);
	}
	
	
	public void bounceY(){
		velocity[1] *= -1;
	}
	public void bounceX(){
		velocity[0] *= -1;
	}
}
