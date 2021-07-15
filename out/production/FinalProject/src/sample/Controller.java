package sample;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller{
    private String password,username;
    private DataOutputStream dataOutputStream=null;
    private DataInputStream dataInputStream=null;
    private final Image pekaImage=new Image("/mini%20pekka_00000.png");
    private final Image babarImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\barbarian_00000.png");
    private final Image wizardImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\wizard_00000.png");
    private final Image infernoImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\inferno_00000.png");
    private final Image giantImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\giant_00000.png");
    private final Image arrowImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\arrows_00000.png");
    private final Image archerImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\archer_00000.png");
    private final Image valkyrieImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\valkyrie_00000.png");
    private final Image rageImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\rage_00000.png");
    private final Image canonImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\canon_00000.png");
    private final Image fireBallImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\fireball_00000.png");
    private final Image babyDragonImage=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\baby%20dragon_00000.png");
    private final Image frame=new Image("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\frame.png");
    @FXML
    private Button done;
    @FXML
    private Button doneSignUp;
    @FXML
    private Button signUpPrev;
    @FXML
    private Button signUp;
    @FXML
    private Button backToSignIn;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField name;
    @FXML
    private TextField nameText;
    @FXML
    private TextField usernameSignUp;
    @FXML
    private TextField passwordSignUp;
    @FXML
    private TextField passwordSignUpConfirm;
    @FXML
    private TextField email;
    @FXML
    private ImageView deck1,deck2,deck3,deck4,deck5,deck6,deck7,deck8;
    @FXML
    private ImageView addWizard,addValkyrie,addRage,addPeka,addGiant,addCanon,addArcher,addBarbarian,addFireBall,addBabyDragon,addArrow,addInferno;
    @FXML
    private void remove1(MouseEvent mouseEvent)
    {
      deck1.setImage(null);
    }
    @FXML
    private void remove2(MouseEvent mouseEvent)
    {
     deck2.setImage(null);
    }
    @FXML
    private void remove3(MouseEvent mouseEvent)
    {
        deck3.setImage(null);
    }
    @FXML
    private void remove4(MouseEvent mouseEvent)
    {
      deck4.setImage(null);
    }
    @FXML
    private void remove5(MouseEvent mouseEvent)
    {
      deck5.setImage(null);
    }
    @FXML
    private void remove6(MouseEvent mouseEvent)
    {
     deck6.setImage(null);
    }
    @FXML
    private void remove7(MouseEvent mouseEvent)
    {
          deck7.setImage(null);
    }
    @FXML
    private void remove8(MouseEvent mouseEvent)
    {
       deck8.setImage(null);
    }
    @FXML
    private void addArcher(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addWizard(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addRage(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addPeka(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addFireBall(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addGiant(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addArrow(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addInferno(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addBarbarian(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addBabyDragon(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addCanon(MouseEvent mouseEvent)
    {

    }
    @FXML
    private void addValkyrie(MouseEvent mouseEvent)
    {

    }
    @FXML
    public void check(ActionEvent event) throws IOException, ClassNotFoundException {
        if (pass.getText() != "" && name.getText() != "") {
            password = pass.getText();
            username = name.getText();
        } else {
            Stage stage = new Stage();
            stage.setMinWidth(250);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            Label label = new Label();
            label.setText("You didn't fill password Or user name");
            Button button = new Button("Ok");
            button.setOnAction(e -> {
                stage.close();
            });
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.showAndWait();
        }
        ArrayList<Player> players = new ArrayList<Player>();
        String filename = "C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\data.bin";
        File file = new File(filename);
        if (file.exists()) {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream(file));
            boolean cont = true;
            players=(ArrayList<Player>)ois.readObject();

                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getUser().equals(username))
                        if (players.get(i).getPass().equals(password)) {
                            Controller.enterMainMenu();
                            return;
                        }
                }

            }
            Stage stage = new Stage();
            stage.setMinWidth(250);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            Label label = new Label();
            label.setText("You didn't fill password Or user name correct");
            Button button = new Button("Ok");
            button.setOnAction(e -> {
                stage.close();
            });
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.showAndWait();
        }

    public static void enterMainMenu(){

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
        Main.changeSceneToMainMenu();

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
    private void ForgotPass(ActionEvent event)
    {

    }
    @FXML
    private void backToSignIn(ActionEvent event) throws IOException, ClassNotFoundException {
        if(!passwordSignUp.getText().equals("")||!usernameSignUp.getText().equals("")||!email.getText().equals("")||!nameText.getText().equals(""))
            if(passwordSignUp.getText().equals(passwordSignUpConfirm.getText()))
        {
            File file=new File("C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\data.bin");
            String filename = "C:\\Users\\AmirHossein\\Desktop\\Coding Stuff\\Clash Royal\\FinalProject\\src\\data.bin";
            ArrayList<Player> players=new ArrayList<Player>();
            if (file.exists()) {
                ObjectInputStream ois = null;
                ois = new ObjectInputStream(new FileInputStream(file));
                boolean cont = true;
                players = (ArrayList<Player>) ois.readObject();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream out =null;
                out = new ObjectOutputStream (fos);
                boolean a=true;
                if(!passwordSignUp.getText().equals(passwordSignUpConfirm.getText()))
                {
                    a=false;
                    out.close();
                    Stage stage=new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Warning");
                    stage.setMinWidth(250);
                    Label label=new Label();
                    label.setText("You Dint Repeat Your Password Correctly");
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
                    out.close();
                }
                if(a)
                for (int i=0;i<players.size();i++)
                {
                    System.out.println(players.get(i).getUser());
                    if(players.get(i).getUser().equals(usernameSignUp.getText()))
                    {
                        a=false;
                        out.close();
                        Stage stage=new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Warning");
                        stage.setMinWidth(250);
                        Label label=new Label();
                        label.setText("This username has been chosen before!!!");
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
                if(a)
                {
                    players.add(new Player(usernameSignUp.getText(),nameText.getText(),passwordSignUp.getText(),email.getText()));
                    out.writeObject(players);
                }

            out.close();
            fos.close();
            Main.changeSceneToSignIn();
        }
        else
        {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You didn't fill a field correct");
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
    @FXML
    private void signUpPrev(ActionEvent event)
    {
        Main.changeSceneToSignIn();
    }
}
