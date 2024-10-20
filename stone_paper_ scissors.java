import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class StonePaperScissors extends Application {

    private Label resultLabel;
    private Random random;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stone Paper Scissors Game");

        random = new Random();
        resultLabel = new Label("Make your choice!");

        Button stoneButton = new Button("Stone");
        Button paperButton = new Button("Paper");
        Button scissorsButton = new Button("Scissors");

        stoneButton.setOnAction(event -> playGame("Stone"));
        paperButton.setOnAction(event -> playGame("Paper"));
        scissorsButton.setOnAction(event -> playGame("Scissors"));

        VBox vbox = new VBox(10, resultLabel, stoneButton, paperButton, scissorsButton);
        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void playGame(String playerChoice) {
        String[] choices = {"Stone", "Paper", "Scissors"};
        String computerChoice = choices[random.nextInt(3)];

        String result;
        if (playerChoice.equals(computerChoice)) {
            result = "It's a tie!";
        } else if ((playerChoice.equals("Stone") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Stone")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            result = "You win!";
        } else {
            result = "You lose!";
        }

        resultLabel.setText("Computer chose: " + computerChoice + "\n" + result);
    }
}
