package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/weather.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("TacskóWeather");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}
