package sample;
import javafx.application.Platform;
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
import java.sql.Time;
import java.util.*;

public class Controller implements Initializable{
    private String password,username;
    private DataOutputStream dataOutputStream=null;
    private DataInputStream dataInputStream=null;
    private int m=3,s=0;
    private static ArrayList<String> legends=new ArrayList<String>();
    private final Image babarImage=new Image("/barbarian_00000.png");
    private final Image wizardImage=new Image("/wizard_00000.png");
    private final Image pekaImage=new Image("/mini pekka_00000.png");
    private final Image infernoImage=new Image("/inferno_00000.png");
    private final Image giantImage=new Image("/giant_00000.png");
    private final Image arrowImage=new Image("/arrows_00000.png");
    private final Image archerImage=new Image("/archer_00000.png");
    private final Image valkyrieImage=new Image("/valkyrie_00000.png");
    private final Image rageImage=new Image("/rage_00000.png");
    private final Image canonImage=new Image("/canon_00000.png");
    private final Image fireBallImage=new Image("/fireball_00000.png");
    private final Image babyDragonImage=new Image("/baby dragon_00000.png");
    private final Image frame=new Image("/frame.png");
    private static Player player;
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
    private Button trainingBattle;
    @FXML
    private Button game;
    @FXML
    private PasswordField pass;
    @FXML
    private ProgressBar elixirBar;
    @FXML
    private Label elixirLabel,timeLabel,crownLabel;
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
    private ImageView gameDeck1,gameDeck2,gameDeck3,gameDeck4,gameDeck5;
    @FXML
    private ImageView addWizard,addValkyrie,addRage,addPeka,addGiant,addCanon,addArcher,addBarbarian,addFireBall,addBabyDragon,addArrow,addInferno;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void remove1(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
      if(!deck1.getImage().getUrl().equals(frame.getUrl()))
          legends.remove(deck1.getImage().getUrl());
      player.setDeck(legends);
      deck1.setImage(frame);
    }
    @FXML
    private void remove2(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if(!deck2.getImage().getUrl().equals(frame.getUrl()))
            legends.remove(deck2.getImage().getUrl());
        player.setDeck(legends);
        deck2.setImage(frame);
    }
    @FXML
    private void remove3(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if(!deck3.getImage().getUrl().equals(frame.getUrl()))
            legends.remove(deck3.getImage().getUrl());
        player.setDeck(legends);
        deck3.setImage(frame);
    }
    @FXML
    private void remove4(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if(!deck4.getImage().getUrl().equals(frame.getUrl()))
            legends.remove(deck4.getImage().getUrl());
        player.setDeck(legends);
        deck4.setImage(frame);
    }
    @FXML
    private void remove5(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if(!deck5.getImage().getUrl().equals(frame.getUrl()))
            legends.remove(deck5.getImage().getUrl());
        player.setDeck(legends);
        deck5.setImage(frame);
    }
    @FXML
    private void remove6(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if(!deck6.getImage().getUrl().equals(frame.getUrl()))
            legends.remove(deck6.getImage().getUrl());
        player.setDeck(legends);
        deck6.setImage(frame);
    }
    @FXML
    private void remove7(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if(!deck7.getImage().getUrl().equals(frame.getUrl()))
            legends.remove(deck7.getImage().getUrl());
        player.setDeck(legends);
        deck7.setImage(frame);
    }
    @FXML
    private void remove8(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        if(!deck8.getImage().getUrl().equals(frame.getUrl()))
            legends.remove(deck8.getImage().getUrl());
        player.setDeck(legends);
        deck8.setImage(frame);
    }
    @FXML
    private void addArcher(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(archerImage.getUrl()))
                hasBeenChosen=true;
            if(!hasBeenChosen) {
                if(legends.size()<8)
                {
                    legends.add(archerImage.getUrl());
                    player.setDeck(legends);
                }
                if (deck1.getImage().getUrl().equals(frame.getUrl())) {
                    deck1.setImage(archerImage);
                } else if (deck2.getImage().getUrl().equals(frame.getUrl())) {
                    deck2.setImage(archerImage);
                } else if (deck3.getImage().getUrl().equals(frame.getUrl())) {
                    deck3.setImage(archerImage);
                } else if (deck4.getImage().getUrl().equals(frame.getUrl())) {
                    deck4.setImage(archerImage);
                } else if (deck5.getImage().getUrl().equals(frame.getUrl())) {
                    deck5.setImage(archerImage);
                } else if (deck6.getImage().getUrl().equals(frame.getUrl())) {
                    deck6.setImage(archerImage);
                } else if (deck7.getImage().getUrl().equals(frame.getUrl())) {
                    deck7.setImage(archerImage);
                } else if (deck8.getImage().getUrl().equals(frame.getUrl())) {
                    deck8.setImage(archerImage);
                } else {
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("Warning");
                    stage.setMinWidth(250);
                    Label label = new Label();
                    label.setText("Your Deck Is Full!!");
                    Button button1 = new Button("Ok");
                    button1.setOnAction(event1 -> {
                        stage.close();
                    });
                    VBox layout = new VBox(10);
                    layout.getChildren().addAll(label, button1);
                    layout.setAlignment(Pos.CENTER);
                    Scene scene = new Scene(layout);
                    stage.setScene(scene);
                    stage.showAndWait();
                }
            }
            else {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("You Have Chosen This Legend Before");
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
    private void addWizard(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(wizardImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
            {
                legends.add(wizardImage.getUrl());
                player.setDeck(legends);
            }
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(wizardImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(wizardImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(wizardImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(wizardImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(wizardImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(wizardImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(wizardImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(wizardImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addRage(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(rageImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
            {
                legends.add(rageImage.getUrl());
            }
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(rageImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(rageImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(rageImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(rageImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(rageImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(rageImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(rageImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(rageImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addPeka(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(pekaImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
            {
                legends.add(pekaImage.getUrl());
            }
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(pekaImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(pekaImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(pekaImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(pekaImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(pekaImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(pekaImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(pekaImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(pekaImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addFireBall(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(fireBallImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
                legends.add(fireBallImage.getUrl()) ;
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(fireBallImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(fireBallImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(fireBallImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(fireBallImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(fireBallImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(fireBallImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(fireBallImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(fireBallImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addGiant(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(giantImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
                legends.add(giantImage.getUrl());
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(giantImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(giantImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(giantImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(giantImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(giantImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(giantImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(giantImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(giantImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addArrow(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(arrowImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
                legends.add(arrowImage.getUrl());
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(arrowImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(arrowImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(arrowImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(arrowImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(arrowImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(arrowImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(arrowImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(arrowImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addInferno(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(infernoImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
                legends.add(infernoImage.getUrl());
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(infernoImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(infernoImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(infernoImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(infernoImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(infernoImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(infernoImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(infernoImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(infernoImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addBarbarian(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(babarImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
                legends.add(babarImage.getUrl());
            player.setDeck(legends);
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
                            players.get(i).setDeck(legends);
                            return;
                        }
                }
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream out =null;
                out = new ObjectOutputStream (fos);
                out.writeObject(players);
                out.close();
                ois.close();
            }
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(babarImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {

                deck2.setImage(babarImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(babarImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(babarImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(babarImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(babarImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(babarImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(babarImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addBabyDragon(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(babyDragonImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
                legends.add(babyDragonImage.getUrl());
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(babyDragonImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(babyDragonImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(babyDragonImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(babyDragonImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(babyDragonImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(babyDragonImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(babyDragonImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(babyDragonImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addCanon(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(canonImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
                legends.add(canonImage.getUrl());
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(canonImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(canonImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(canonImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(canonImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(canonImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(canonImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(canonImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(canonImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
    private void addValkyrie(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        boolean hasBeenChosen=false;
        for (int i=0;i<legends.size();i++)
            if(legends.get(i).equals(valkyrieImage.getUrl()))
                hasBeenChosen=true;
        if(!hasBeenChosen)
        {
            if(legends.size()<8)
                legends.add(valkyrieImage.getUrl());
            player.setDeck(legends);
            if(deck1.getImage().getUrl().equals(frame.getUrl()))
            {
                deck1.setImage(valkyrieImage);
            }
            else if (deck2.getImage().getUrl().equals(frame.getUrl()))
            {
                deck2.setImage(valkyrieImage);
            }

            else if (deck3.getImage().getUrl().equals(frame.getUrl()))
            {
                deck3.setImage(valkyrieImage);
            }
            else if (deck4.getImage().getUrl().equals(frame.getUrl()))
            {
                deck4.setImage(valkyrieImage);
            }
            else if (deck5.getImage().getUrl().equals(frame.getUrl()))
            {
                deck5.setImage(valkyrieImage);
            }
            else if (deck6.getImage().getUrl().equals(frame.getUrl()))
            {
                deck6.setImage(valkyrieImage);
            }
            else if (deck7.getImage().getUrl().equals(frame.getUrl()))
            {
                deck7.setImage(valkyrieImage);
            }
            else if (deck8.getImage().getUrl().equals(frame.getUrl()))
            {
                deck8.setImage(valkyrieImage);
            }
            else
            {
                Stage stage=new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Warning");
                stage.setMinWidth(250);
                Label label=new Label();
                label.setText("Your Deck Is Full!!");
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
        else {
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Warning");
            stage.setMinWidth(250);
            Label label=new Label();
            label.setText("You Have Chosen This Legend Before");
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
                            player=players.get(i);
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
            ArrayList<String> deck=player.getDeck();
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
                    Player p=new Player(usernameSignUp.getText(),nameText.getText(),passwordSignUp.getText(),email.getText());
                    players.add(p);
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
    @FXML
    private void trainingBattle(ActionEvent event)
    {
        Main.changeSceneToGame();
    }

    @FXML
    private void game(ActionEvent event) throws InterruptedException {
        crownLabel.setText("0");
        elixirLabel.setText("0");
        timeLabel.setText("3:00");
        while(true){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    s--;
                if(s<0)
                {
                    m--;
                    s+=60;
                }
                if(s<10)
                    timeLabel.setText(m+":0"+s);
                else
                    timeLabel.setText(m+":"+s);
            }
            });
            Thread.sleep(1000);
        }
//        TimerTask timerTask=new TimerTask() {
//            @Override
//            public void run() {
//                s--;
//                if(s<0)
//                {
//                    m--;
//                    s+=60;
//                }
//                if(s<10)
//                    timeLabel.setText(m+":0"+s);
//                else
//                    timeLabel.setText(m+":"+s);
//                if(m==0 && s==0)
//                    this.cancel();
//            }
//        };
//        Timer t=new Timer();
//        t.schedule(timerTask,1000,1000);
    }


}
