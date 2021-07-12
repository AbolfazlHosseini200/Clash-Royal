package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.net.URL;
import java.util.Date;

public class Main extends Application {
    @FXML
    private ImageView imageView;
    static Scene signUpScene;
    static Scene signInScene;
    static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Socket socket =new Socket("localhost",8585);
        stage=primaryStage;
        Listener listener=new Listener(new DataInputStream(socket.getInputStream()), new DataOutputStream(socket.getOutputStream()));
        URL url = getClass().getResource("FirstPage.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root=loader.load();
        signInScene=new Scene(root, 650, 400);
        URL urlConnecting = getClass().getResource("connecting.fxml");
        FXMLLoader loaderConnecting = new FXMLLoader(urlConnecting);
        Parent rootConnecting=loaderConnecting.load();
        Scene connectingScene=new Scene(rootConnecting, 650, 400);
        primaryStage.setScene(connectingScene);
        primaryStage.show();
        primaryStage.setScene(signInScene);
        primaryStage.setTitle("SignIn");
        URL urlSignUp = getClass().getResource("SignUp.fxml");
        FXMLLoader loaderSignUp = new FXMLLoader(urlSignUp);
        Parent rootSignUp=loaderSignUp.load();
        signUpScene=new Scene(rootSignUp, 650, 400);

    }

    public static void changeSceneToSignUp()
    {
        stage.setScene(signUpScene);
    }
    public static void changeSceneToSignIn()
    {
        stage.setScene(signInScene);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
