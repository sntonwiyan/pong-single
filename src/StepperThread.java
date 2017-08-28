import javafx.animation.AnimationTimer;
import javafx.scene.shape.Shape;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class StepperThread extends Thread {
	public void run(){
		new AnimationTimer(){
			Ball ball = (Ball) Playground.get(0);
			Ball ball2 = (Ball) Playground.get(1);
			Node paddle = Playground.get(2);
			Node top = Playground.get(3);
			Node left = Playground.get(4);
			Node right = Playground.get(5);
			Node bottom = Playground.get(6);
			Label score = (Label) Playground.get(7);
			
			public void handle(long t){
				ball.move();
				ball2.move();
				
				// Ball with paddle
				if (ball.getBoundsInParent().intersects(paddle.getBoundsInParent())) {
					ball.bounceY();
					Playground.increaseScore();
				}
				
				// Ball with top
				if (ball.getBoundsInParent().intersects(top.getBoundsInParent()))
					ball.bounceY();
				//Ball with left
				if (ball.getBoundsInParent().intersects(left.getBoundsInParent()))
					ball.bounceX();
				//ball with right
				if (ball.getBoundsInParent().intersects(right.getBoundsInParent()))
					ball.bounceX();
				//bottom
				if (ball.getBoundsInParent().intersects(bottom.getBoundsInParent())) {
					if (Playground.getScore() > Highscore.get())
						Highscore.set(Playground.getScore());
					
					Label gover = new Label("Game Over ");
					gover.relocate(430, 320);
					gover.setTextFill(Color.web("white"));
					Playground.items.getChildren().add(gover);
					Playground.add(gover);
					Playground.gover = true;
//						System.exit(0);
				}
				
				
				//Ball2
				
				// Ball with paddle
				if (ball2.getBoundsInParent().intersects(paddle.getBoundsInParent())) {
					ball2.bounceY();
					Playground.increaseScore();
				}
				
				// Ball with top
				if (ball2.getBoundsInParent().intersects(top.getBoundsInParent()))
					ball2.bounceY();
				//Ball with left
				if (ball2.getBoundsInParent().intersects(left.getBoundsInParent()))
					ball2.bounceX();
				//ball with right
				if (ball2.getBoundsInParent().intersects(right.getBoundsInParent()))
					ball2.bounceX();
				//bottom
				if (ball2.getBoundsInParent().intersects(bottom.getBoundsInParent())) {
					if (Playground.getScore() > Highscore.get())
						Highscore.set(Playground.getScore());
					
					Label gover = new Label("Game Over ");
					gover.relocate(430, 320);
					gover.setTextFill(Color.web("white"));
					Playground.items.getChildren().add(gover);
					Playground.add(gover);
					Playground.gover = true;
//						System.exit(0);
				}
			
				score.setText("Score: " + Playground.getScore());
			}
		}.start();
	}
	
}
