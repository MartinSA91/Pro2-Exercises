import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import temperature.view.TemperatureViewController;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("TemperatureView.fxml"));
    Scene scene = new Scene(loader.load());

    TemperatureViewController controller = loader.getController();
    ObservableClock clock = new ObservableClock();
    clock.addPropertyChangeListener(controller);

    Thread clockThread = new Thread(clock);
    clockThread.setDaemon(true);
    clockThread.start();

    primaryStage.setScene(scene);
    primaryStage.setTitle("Temperature Converter");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

