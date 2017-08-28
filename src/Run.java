import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Run extends Application{

	public static void main(String[] args) {
		launch (args);
	}
	public void start (Stage stage){
//		System.out.println(Highscore.get());
		menu(stage);
		stage.show();
	}
	public void stop(){
		System.exit(0);
	}
	public void menu(Stage stage){
		ImageView start = new ImageView("sprites/start.png");
		ImageView stop = new ImageView("sprites/quit.png");
		
		start.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				startGame(stage);
			}
		});
		stop.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				stop();
			}
		});
		
		VBox items = new VBox(
			20,
			start,
			stop
		);
		items.setAlignment(Pos.CENTER);
		stage.setScene(
			new Scene(
				items,
				960,
				640,
				Color.web("black")
			)
		);
	}
	public void startGame (Stage stage) {
		Group items = new Group();
		
		Scene scene = new Scene(
			items,
			960,
			640,
			Color.web("black")
		);
		stage.setScene(scene);
		
		//Ball
		Ball ball = new Ball(
				450,
				300,
				30,
				30);
		ball.setFill(Color.web("blue"));
		items.getChildren().add(ball);
		Playground.add(ball); // 0
		ball.setVelocity(new double[] {3.5, 3.5});
		
		Ball ball2 = new Ball(
				450,
				300,
				30,
				30);
		ball2.setFill(Color.web("blue"));
		items.getChildren().add(ball2);
		Playground.add(ball2); // 0
		ball2.setVelocity(new double[] {2.5, 2.5});
		
		
		
		//paddle
		Rectangle paddle = new Rectangle(
				340,
				600,
				100,
				15);
		paddle.setFill(Color.web("lightgreen"));
		items.getChildren().add(paddle);
		Playground.add(paddle); // 1
		
		//top
		Rectangle top = new Rectangle(
				0,
				0,
				960,
				10);
		top.setFill(Color.web("lightblue"));
		items.getChildren().add(top);
		Playground.add(top); // 2
		
		//left
		Rectangle left = new Rectangle(
				0,
				0,
				10,
				640);
		left.setFill(Color.web("lightblue"));
		items.getChildren().add(left);
		Playground.add(left); // 3
		
		//right
		Rectangle right = new Rectangle(
				950,
				0,
				10,
				640);
		right.setFill(Color.web("lightblue"));
		items.getChildren().add(right);
		Playground.add(right); // 4
		//bottom
		Rectangle bottom = new Rectangle(
				0,
				640,
				960,
				10
				);
		bottom.setFill(Color.web("black"));
		items.getChildren().add(bottom);
		Playground.add(bottom); // 5
		
		// Score
		Label score = new Label("Score: 0");
		score.relocate(880, 15);
		score.setTextFill(Color.web("white"));
		items.getChildren().add(score);
		Playground.add(score); // 6
		
		// Highscore
		Label hscore = new Label("Highscore: " + Highscore.get());
		hscore.relocate(25, 15);
		hscore.setTextFill(Color.web("white"));
		items.getChildren().add(hscore);
		Playground.add(hscore); // 7
		
		Playground.items = items;
		
		new StepperThread().start();
		
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			public void handle (MouseEvent e) {
				if (!Playground.gover)
					paddle.relocate(e.getX(), paddle.getBoundsInParent().getMinY());
			}
		});
	}
}

	


