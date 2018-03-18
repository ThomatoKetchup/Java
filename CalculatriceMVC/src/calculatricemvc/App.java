package calculatricemvc;

import calculatrice.Exceptions.ExceptionOperationExistante;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
private Calculatrice c;

    public App() {
        Model1 m1 = new Model1();
        c=m1.init();
    }

        
    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller(c);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
        loader.setController(controller);
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        App a = new App();
        launch(args);
    }
}
