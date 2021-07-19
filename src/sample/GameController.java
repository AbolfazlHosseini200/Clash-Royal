package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class GameController implements Initializable {
    int m = 3, s = 0, i = 0, elixirs = 0,j=0;
    String chosenCard;
    private ArrayList<String> deck = null, alternativeDeck = new ArrayList<String>();
    private ArrayList<CardXY> cardsInGame=new ArrayList<CardXY>();
    @FXML
    private Button game;
    @FXML
    private ProgressBar elixirBar;
    @FXML
    private Label elixirLabel, timeLabel, crownLabel;
    @FXML
    private ImageView gameDeck1, gameDeck2, gameDeck3, gameDeck4, gameDeck5;
    @FXML
    private Canvas canvas;
    @FXML
    public Pane mainPane, upPane, downPane;
    GraphicsContext gc;
    @FXML
    private ImageView chosenCardImage;
    private final Image babarImage = new Image("/barbarian_00000.png", 50, 50, false, false);
    private final Image wizardImage = new Image("/wizard_00000.png", 50, 50, false, false);
    private final Image pekaImage = new Image("/mini pekka_00000.png", 50, 50, false, false);
    private final Image infernoImage = new Image("/inferno_00000.png", 50, 50, false, false);
    private final Image giantImage = new Image("/giant_00000.png", 50, 50, false, false);
    private final Image arrowImage = new Image("/arrows_00000.png", 50, 50, false, false);
    private final Image archerImage = new Image("/archer_00000.png", 50, 50, false, false);
    private final Image valkyrieImage = new Image("/valkyrie_00000.png", 50, 50, false, false);
    private final Image rageImage = new Image("/rage_00000.png", 50, 50, false, false);
    private final Image canonImage = new Image("/canon_00000.png", 50, 50, false, false);
    private final Image fireBallImage = new Image("/fireball_00000.png", 50, 50, false, false);
    private final Image babyDragonImage = new Image("/baby dragon_00000.png", 50, 50, false, false);
    private final Image frame = new Image("/frame.png");
    private final Image babarImageBattle = new Image("/barbarian.png", 50, 50, false, false);
    private final Image wizardImageBattle = new Image("/wizard.png", 50, 50, false, false);
    private final Image pekaImageBattle = new Image("/mini pekka.png", 50, 50, false, false);
    private final Image infernoImageBattle = new Image("/inferno.png", 50, 50, false, false);
    private final Image giantImageBattle = new Image("/giant.png", 50, 50, false, false);
    private final Image archerImageBattle = new Image("/archer.png", 50, 50, false, false);
    private final Image valkyrieImageBattle = new Image("/valkyrie.png", 50, 50, false, false);
    private final Image canonImageBattle = new Image("/canon.png", 50, 50, false, false);
    private final Image fireBallImageBattle = new Image("/fireball.png", 50, 50, false, false);
    private final Image babyDragonImageBattle = new Image("/baby dragon.png", 50, 50, false, false);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = Controller.legends;
        gc = canvas.getGraphicsContext2D();
    }

    @FXML
    private void game(ActionEvent event) {
        for (int i = 0; i < 5; i++) {
            int n;
            n = new Random().nextInt(deck.size());
            alternativeDeck.add(deck.get(n));
            deck.remove(n);
        }
        gameDeck1.setImage(new Image(alternativeDeck.get(0)));
        gameDeck2.setImage(new Image(alternativeDeck.get(1)));
        gameDeck3.setImage(new Image(alternativeDeck.get(2)));
        gameDeck4.setImage(new Image(alternativeDeck.get(3)));
        gameDeck5.setImage(new Image(alternativeDeck.get(4)));
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                s--;
                if (m == 0)
                    i += 2;
                else
                    i++;
                if (i > 1 && elixirs > 9)
                    i = 0;
                if (i == 2 && elixirs < 10) {
                    i = 0;
                    elixirs++;
                    Platform.runLater(() -> elixirBar.setProgress((double) elixirs / 10));
                    Platform.runLater(() -> elixirLabel.setText(String.valueOf(elixirs)));
                }
                if (s < 0) {
                    m--;
                    s += 60;
                }
                if (s < 10)
                    Platform.runLater(() -> timeLabel.setText(m + ":0" + s));
                else
                    Platform.runLater(() -> timeLabel.setText(m + ":" + s));
                if (m == 0 && s == 0)
                    this.cancel();
            }
        };
        Timer t = new Timer();
        t.schedule(timerTask, 1000, 1000);
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 10000000000.0;
                gc.drawImage(new Image("/ground.png",653,400,false,false),0,0);
                for(int o=0;o<cardsInGame.size();o++)
                {

                    cardsInGame.get(o).x=cardsInGame.get(o).x+t/5;
                    gc.drawImage(new Image(cardsInGame.get(o).card,50,50,false,false),cardsInGame.get(o).x,cardsInGame.get(o).y);
                }

//                if(0<=i && i<10 ) {
//                    gc.drawImage(giantImage, x, 275);
//                }if(i>=10 && i<=20 ){
//                gc.drawImage(babarImage, x, 275);
//            }
//                if(x<100)
//                    return;
//                i++;
//                if(i==20){
//                    i=0;
//                }
            }
        }.start();
    }

    @FXML
    public void gameDeck1(MouseEvent mouseEvent) {
        if (gameDeck1.getImage().getUrl().equals(archerImage.getUrl())) {
            if (elixirs > 2) {
                chosenCard = archerImage.getUrl();
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck1.setImage(gameDeck5.getImage());
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 3;
            }
        } else if (gameDeck1.getImage().getUrl().equals(arrowImage.getUrl())) {
            if (elixirs > 2) {
                chosenCard = arrowImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 3;
            }
        } else if (gameDeck1.getImage().getUrl().equals(babyDragonImage.getUrl())) {
            if (elixirs > 3) {
                chosenCard = babyDragonImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 4;
            }
        } else if (gameDeck1.getImage().getUrl().equals(babarImage.getUrl())) {
            if (elixirs > 5) {
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCard = babarImage.getUrl();
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 5;
            }
        } else if (gameDeck1.getImage().getUrl().equals(fireBallImage.getUrl())) {
            if (elixirs > 3) {
                chosenCard = fireBallImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 4;
            }
        } else if (gameDeck1.getImage().getUrl().equals(canonImage.getUrl())) {
            if (elixirs > 2) {
                chosenCard = canonImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 3;
            }
        } else if (gameDeck1.getImage().getUrl().equals(giantImage.getUrl())) {
            if (elixirs > 4) {
                chosenCard = giantImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 5;
            }
        } else if (gameDeck1.getImage().getUrl().equals(pekaImage.getUrl())) {
            if (elixirs > 3) {
                chosenCard = pekaImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 4;
            }
        } else if (gameDeck1.getImage().getUrl().equals(rageImage.getUrl())) {
            if (elixirs > 2) {
                chosenCard = rageImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 3;
            }
        } else if (gameDeck1.getImage().getUrl().equals(valkyrieImage.getUrl())) {
            if (elixirs > 3) {
                chosenCard = valkyrieImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 4;
            }
        } else if (gameDeck1.getImage().getUrl().equals(wizardImage.getUrl())) {
            if (elixirs > 4) {
                chosenCard = wizardImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 5;
            }
        } else if (gameDeck1.getImage().getUrl().equals(infernoImage.getUrl())) {
            if (elixirs > 4) {
                chosenCard = infernoImage.getUrl();
                gameDeck1.setImage(gameDeck5.getImage());
                chosenCardImage.setImage(new Image(chosenCard));
                alternativeDeck.remove(chosenCard);
                int n = new Random().nextInt(deck.size());
                deck.add(chosenCard);
                gameDeck5.setImage(new Image(deck.get(n)));
                alternativeDeck.add(gameDeck5.getImage().getUrl());
                deck.remove(n);
                elixirs -= 5;
            }
        }
    }

    @FXML
    public void gameDeck2(MouseEvent event) {
        if (gameDeck2.getImage().getUrl().equals(archerImage.getUrl()) && elixirs > 2) {
            chosenCard = archerImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck2.getImage().getUrl().equals(arrowImage.getUrl()) && elixirs > 2) {
            chosenCard = arrowImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck2.getImage().getUrl().equals(babyDragonImage.getUrl()) && elixirs > 3) {
            chosenCard = babyDragonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck2.getImage().getUrl().equals(babarImage.getUrl()) && elixirs > 4) {
            chosenCard = babarImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck2.getImage().getUrl().equals(fireBallImage.getUrl()) && elixirs > 3) {
            chosenCard = fireBallImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck2.getImage().getUrl().equals(canonImage.getUrl()) && elixirs > 2) {
            chosenCard = canonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck2.getImage().getUrl().equals(giantImage.getUrl()) && elixirs > 4) {
            chosenCard = giantImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck2.getImage().getUrl().equals(pekaImage.getUrl()) && elixirs > 3) {
            chosenCard = pekaImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck2.getImage().getUrl().equals(rageImage.getUrl()) && elixirs > 2) {
            chosenCard = rageImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck2.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck2.getImage().getUrl().equals(valkyrieImage.getUrl()) && elixirs > 3) {
            chosenCard = valkyrieImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck2.getImage().getUrl().equals(wizardImage.getUrl()) && elixirs > 4) {
            chosenCard = wizardImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck2.getImage().getUrl().equals(infernoImage.getUrl()) && elixirs > 4) {
            chosenCard = infernoImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck2.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        }
    }

    @FXML
    public void gameDeck3(MouseEvent actionEvent) {
        if (gameDeck3.getImage().getUrl().equals(archerImage.getUrl()) && elixirs > 2) {
            chosenCard = archerImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck3.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck3.getImage().getUrl().equals(arrowImage.getUrl()) && elixirs > 2) {
            chosenCard = arrowImage.getUrl();
            gameDeck3.setImage(gameDeck5.getImage());
            elixirs -= 3;
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
        } else if (gameDeck3.getImage().getUrl().equals(babyDragonImage.getUrl()) && elixirs > 3) {
            chosenCard = babyDragonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck3.getImage().getUrl().equals(babarImage.getUrl()) && elixirs > 4) {
            chosenCard = babarImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck3.getImage().getUrl().equals(fireBallImage.getUrl()) && elixirs > 3) {
            chosenCard = fireBallImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck3.getImage().getUrl().equals(canonImage.getUrl()) && elixirs > 2) {
            chosenCard = canonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck3.getImage().getUrl().equals(giantImage.getUrl()) && elixirs > 4) {
            chosenCard = giantImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck3.getImage().getUrl().equals(pekaImage.getUrl()) && elixirs > 3) {
            chosenCard = pekaImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck3.getImage().getUrl().equals(rageImage.getUrl()) && elixirs > 2) {
            chosenCard = rageImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck3.getImage().getUrl().equals(valkyrieImage.getUrl()) && elixirs > 3) {
            chosenCard = valkyrieImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck3.getImage().getUrl().equals(wizardImage.getUrl()) && elixirs > 4) {
            chosenCard = wizardImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck3.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck3.getImage().getUrl().equals(infernoImage.getUrl()) && elixirs > 4) {
            chosenCard = infernoImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            gameDeck3.setImage(gameDeck5.getImage());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        }
    }

    @FXML
    public void gameDeck4(MouseEvent event) {
        if (gameDeck4.getImage().getUrl().equals(archerImage.getUrl()) && elixirs > 2) {
            chosenCard = archerImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            gameDeck4.setImage(gameDeck5.getImage());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck4.getImage().getUrl().equals(arrowImage.getUrl()) && elixirs > 2) {
            chosenCard = arrowImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck4.getImage().getUrl().equals(babyDragonImage.getUrl()) && elixirs > 3) {
            chosenCard = babyDragonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            gameDeck4.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck4.getImage().getUrl().equals(babarImage.getUrl()) && elixirs > 4) {
            chosenCard = babarImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            gameDeck4.setImage(gameDeck5.getImage());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck4.getImage().getUrl().equals(fireBallImage.getUrl()) && elixirs > 3) {
            chosenCard = fireBallImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck4.getImage().getUrl().equals(canonImage.getUrl()) && elixirs > 2) {
            chosenCard = canonImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck4.getImage().getUrl().equals(giantImage.getUrl()) && elixirs > 4) {
            chosenCard = giantImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        } else if (gameDeck4.getImage().getUrl().equals(pekaImage.getUrl()) && elixirs > 3) {
            chosenCard = pekaImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck4.getImage().getUrl().equals(rageImage.getUrl()) && elixirs > 2) {
            chosenCard = rageImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 3;
        } else if (gameDeck4.getImage().getUrl().equals(valkyrieImage.getUrl()) && elixirs > 3) {
            chosenCard = valkyrieImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 4;
        } else if (gameDeck4.getImage().getUrl().equals(wizardImage.getUrl()) && elixirs > 4) {
            chosenCard = wizardImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            elixirs -= 5;
            gameDeck4.setImage(gameDeck5.getImage());
            alternativeDeck.remove(chosenCard);
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
        } else if (gameDeck4.getImage().getUrl().equals(infernoImage.getUrl()) && elixirs > 4) {
            chosenCard = infernoImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            alternativeDeck.remove(chosenCard);
            gameDeck4.setImage(gameDeck5.getImage());
            int n = new Random().nextInt(deck.size());
            deck.add(chosenCard);
            gameDeck5.setImage(new Image(deck.get(n)));
            alternativeDeck.add(gameDeck5.getImage().getUrl());
            deck.remove(n);
            elixirs -= 5;
        }
    }

    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    @FXML
    public void dropCardCrownDown(MouseEvent mouseEvent) {
    }

    @FXML
    public void dropCardCrownUp(MouseEvent mouseEvent) {
    }

    @FXML
    public void dropCard(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        if (chosenCard.equals(rageImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(rageImage.getUrl(),x,y));
            }
        } else if (chosenCard.equals(babarImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(babarImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(wizardImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(wizardImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(infernoImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(infernoImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(babyDragonImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(babyDragonImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(archerImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(archerImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(arrowImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(arrowImage.getUrl(),x,y));
            }
        } else if (chosenCard.equals(giantImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(giantImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(valkyrieImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(valkyrieImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(pekaImage.getUrl())) {

            {
                cardsInGame.add(new CardXY(pekaImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(canonImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(canonImageBattle.getUrl(),x,y));
            }
        } else if (chosenCard.equals(fireBallImage.getUrl())) {
            {
                cardsInGame.add(new CardXY(fireBallImageBattle.getUrl(),x,y));
            }
        }
    }
}
