package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller{
    private String password,username;
    private Socket socket=new Socket("localhost",8585);
    private DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
    private DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
    @FXML
    private Button done;
    @FXML
    private Button signUp;
    @FXML
    private Button backToSignIn;
    @FXML
    private PasswordField pass;
    @FXML
    private TextArea name;
    @FXML
    private TextArea nameText;
    @FXML
    private TextArea usernameSignUp;
    @FXML
    private TextArea passwordSignUp;
    @FXML
    private TextArea email;

    public Controller() throws IOException {
    }

    @FXML
    public void check(ActionEvent event) throws IOException {
        if (pass.getText()!="" && name.getText()!="")
        {
            password=pass.getText();
            username=name.getText();
            dataOutputStream.writeUTF("check"+"#"+username+"#"+password);
        }
        else
        {
            Stage stage=new Stage();
            stage.setMinWidth(250);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            Label label=new Label();
            label.setText("You didn't fill password Or user name");
            Button button=new Button("Ok");
            button.setOnAction(e->{
                stage.close();
            });
            VBox layout=new VBox(10);
            layout.getChildren().addAll(label,button);
            layout.setAlignment(Pos.CENTER);
            Scene scene=new Scene(layout);
            stage.setScene(scene);
            stage.showAndWait();
        }
    }

    public static void enterMainMenu() {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setMinWidth(250);
            stage.setTitle("Congrats");
            Label label=new Label();
            label.setText("successfully Signed In");
            Button button=new Button("Ok");
            button.setOnAction(e->{
                stage.close();
            });
            VBox layout=new VBox(10);
            layout.getChildren().addAll(label,button);
            layout.setAlignment(Pos.CENTER);
            Scene scene=new Scene(layout);
            stage.setScene(scene);
            stage.showAndWait();

    }
    public static void userPassNotMatch()
    {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You didn't fill password or user name Correct");
            Button button=new Button("Ok");
            button.setOnAction(e->{
                stage.close();
            });
            VBox layout=new VBox(10);
            layout.getChildren().addAll(label,button);
            layout.setAlignment(Pos.CENTER);
            Scene scene=new Scene(layout);
            stage.setScene(scene);
            stage.showAndWait();
    }
    @FXML
    private void signUp(ActionEvent event)
    {
        Main.changeSceneToSignUp();
    }
    @FXML
    private void backToSignIn(ActionEvent event)
    {
        if(!passwordSignUp.getText().equals("") &&!passwordSignUp.getText().equals("")||!usernameSignUp.getText().equals("")||!email.getText().equals("")||!nameText.getText().equals(""))
        {
            //send info to server
            Main.changeSceneToSignIn();
        }
        else
        {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You didn't fill password or user name Correct");
            Button button1=new Button("Ok");
            button1.setOnAction(event1->{
                stage.close();
            });
            VBox layout=new VBox(10);
            layout.getChildren().addAll(label,button1);
            layout.setAlignment(Pos.CENTER);
            Scene scene=new Scene(layout);
            stage.setScene(scene);
            stage.showAndWait();
        }
    }
}
