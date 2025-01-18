import javafx.animation.KeyFrame ;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
public class Digiclock extends Application {
 @Override
 public void start(Stage PrimaryStage) {
	 Text timeText= new Text();
	 timeText.setFont(Font.font("arial",50));
	 timeText.setFill(Color.DEEPSKYBLUE);
	 Text dateText=new Text();
	 dateText.setFont(Font.font("arial",30));
	 dateText.setFill(Color.LIGHTGREEN);
	 Text dayText=new Text();
	 dayText.setFont(Font.font("arial",30));
	 dayText.setFill(Color.ORANGE);
	 
	 VBox vbox=new VBox(10,timeText,dateText,dayText) ;
	 vbox.setAlignment(Pos.CENTER);
	 vbox.setStyle("-fx-background-color:black; -fx-padding:20;");
	 
	 Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(1),event->{
		 LocalDateTime now=LocalDateTime.now();
		 String time=now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		 timeText.setText(time);
		 String date=now.format(DateTimeFormatter.ofPattern("yyy-MM-dd"));
		 dateText.setText("date: "+date);
		 
		 DayOfWeek dayOfWeek= now.getDayOfWeek();
		 dayText.setText("Day: "+dayOfWeek.toString());
	 }));
	 timeline.setCycleCount(Timeline.INDEFINITE);
	 timeline.play();
	 Scene scene= new Scene(vbox,400,300);
	 PrimaryStage.setScene(scene);
	 PrimaryStage.setTitle("Digital Clock");
	 PrimaryStage.show();
 }

public static void main (String[] args) {
	launch(args);
}
}
