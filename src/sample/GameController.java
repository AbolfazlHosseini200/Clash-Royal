package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.*;

public class GameController implements Initializable {
    int m = 3, s = 0, i = 0, elixirs = 0,j=0,jj=-1,jjj=0,crowns1=0,crowns2;

    String chosenCard;
    private ArrayList<String> deck = null, alternativeDeck = new ArrayList<String>();
    private ArrayList<String> enemyDeck=new ArrayList<String>();
    private ArrayList<String>enemyAlternative=new ArrayList<String>();
    private ArrayList<CardXY> cardsInGame=new ArrayList<CardXY>();
    private ArrayList<CardXY> enemyForce=new ArrayList<CardXY>();
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
    private final Image barbaru=new Image("/barbarU.png",50,50,false,false);
    private final Image barbard=new Image("/barbarD.png",50,50,false,false);
    private final Image wizardu=new Image("/wizardU.png",50,50,false,false);
    private final Image wizardd=new Image("/wizardD.png",50,50,false,false);
    private final Image miniu=new Image("/miniU.png",50,50,false,false);
    private final Image minid=new Image("/miniD.png",50,50,false,false);
    private final Image giantu=new Image("/giantU.png",50,50,false,false);
    private final Image giantd=new Image("/giantD.png",50,50,false,false);
    private final Image archeru=new Image("/archerU.png",50,50,false,false);
    private final Image archerd=new Image("/archerD.png",50,50,false,false);
    private final Image valku=new Image("/valkU.png",50,50,false,false);
    private final Image valkD=new Image("/valkD.png",50,50,false,false);
    private final Image dragonu=new Image("/dragonU.png",50,50,false,false);
    private final Image dragonD=new Image("/dragonD.png",50,50,false,false);
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
    private final Image fire = new Image("/fire.gif",50,50,false,false);
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
        enemyForce.add(new CardXY(new queenTower(null),null,null,480,25));
        enemyForce.add(new CardXY(new queenTower(null),null,null,480,280));
        enemyForce.add(new CardXY(new kingTower(null),null,null,550,150));
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
                j++;
                if(j>5000)
                    j=0;
            }
        };
        Timer t = new Timer();
        t.schedule(timerTask, 1000, 1000);
        final long startNanoTime = System.nanoTime();
        
        new AnimationTimer() {
            double  t = 0;
            public void handle(long currentNanoTime) {
                jj++;
                jjj++;
                if(m==2 && s<59)
                    t = (currentNanoTime - startNanoTime) / 10000000000.0;
                gc.drawImage(new Image("/ground.png",653,400,false,false),0,0);
                //army shooting
                for(int o=0;o<cardsInGame.size();o++)
                {
                    CardXY cards=null;
                    for(int oo=0;oo<enemyForce.size();oo++)
                    {

                        if(new Point2D(cardsInGame.get(o).x,cardsInGame.get(o).y).distance(new Point2D(enemyForce.get(oo).x,enemyForce.get(oo).y))<cardsInGame.get(o).card.rng)
                        {
                          cardsInGame.get(o).card.isInRange=true;
                          if(jjj<150)
                          {
                              enemyForce.get(oo).card.hp-=cardsInGame.get(o).card.dmg;
                              gc.drawImage(fire,enemyForce.get(oo).x,enemyForce.get(oo).y);
                          }
                          if(enemyForce.get(oo).card.hp<1)
                          {
                              cardsInGame.get(o).card.isInRange=false;
                              if(enemyForce.get(oo).card instanceof queenTower || enemyForce.get(oo).card instanceof kingTower)
                              {
                                  if(enemyForce.get(oo).card instanceof queenTower && enemyForce.get(oo).card.getUrl()==null)
                                  Platform.runLater(()->crownLabel.setText(String.valueOf(1+Integer.parseInt(crownLabel.getText()))));
                                  if(enemyForce.get(oo).card instanceof kingTower)
                                      Platform.runLater(()->crownLabel.setText("3"));
                                  if (Integer.parseInt(crownLabel.getText())==3 || (m==0&&s==0))
                                  {
                                      setWinner();
                                      stop();
                                  }
                              }
                              enemyForce.get(oo).card.url=fire.getUrl();
                          }
                        }
                    }
                }
                //army drawing
                for(int o=0;o<cardsInGame.size();o++)
                {
                    if(cardsInGame.get(o).card.isInRange||cardsInGame.get(o).card instanceof Rage||cardsInGame.get(o).card instanceof Arrow||cardsInGame.get(o).card instanceof Inferno||cardsInGame.get(o).card instanceof Canon||cardsInGame.get(o).card instanceof FireBall)
                    {

                    }
                    else if(cardsInGame.get(o).x<550)
                    {
                        double speed=((Troops)cardsInGame.get(o).card).speed;
                        if(cardsInGame.get(o).x<280||cardsInGame.get(o).x>310 &&(cardsInGame.get(o).y<260&&cardsInGame.get(o).y>250))
                    cardsInGame.get(o).x=cardsInGame.get(o).x+t*speed;
                    else {
                        if(cardsInGame.get(o).y>200 && cardsInGame.get(o).y<280)
                            cardsInGame.get(o).y=cardsInGame.get(o).y+t*speed;
                        else if(cardsInGame.get(o).y<200 && cardsInGame.get(o).y>30)
                            cardsInGame.get(o).y=cardsInGame.get(o).y-t*speed;
                        else
                            cardsInGame.get(o).x=cardsInGame.get(o).x+t*speed;
                    }}
                    else
                    {
                        double speed=((Troops)cardsInGame.get(o).card).speed;
                        if(cardsInGame.get(o).y<150)
                            cardsInGame.get(o).y=cardsInGame.get(o).y+t*speed;
                        else
                            cardsInGame.get(o).y=cardsInGame.get(o).y-t*speed;
                    }
                    if(jj<15)
                    gc.drawImage(new Image(cardsInGame.get(o).dPic,50,50,false,false),cardsInGame.get(o).x,cardsInGame.get(o).y);
                     else
                        gc.drawImage(new Image(cardsInGame.get(o).uPic,50,50,false,false),cardsInGame.get(o).x,cardsInGame.get(o).y);
                }
                //enemy drawing
                for(int o=0;o<enemyForce.size();o++)
                {
                    if(enemyForce.get(o).card.isInRange || enemyForce.get(o).card instanceof queenTower|| enemyForce.get(o).card instanceof kingTower|| enemyForce.get(o).card instanceof Arrow|| enemyForce.get(o).card instanceof Inferno|| enemyForce.get(o).card instanceof Canon|| enemyForce.get(o).card instanceof Rage)
                    {

                    }
                    else if(enemyForce.get(o).x<280||enemyForce.get(o).x>310 &&(enemyForce.get(o).y<260&&enemyForce.get(o).y>250))
                        enemyForce.get(o).x=enemyForce.get(o).x+t/5;
                    else {
                        if(enemyForce.get(o).y>200 && enemyForce.get(o).y<280)
                            enemyForce.get(o).y=enemyForce.get(o).y+t/5;
                        else if(enemyForce.get(o).y<200 && enemyForce.get(o).y>50)
                            enemyForce.get(o).y=cardsInGame.get(o).y-t/5;
                        else
                            enemyForce.get(o).x=enemyForce.get(o).x+t/5;
                    }
                    if(enemyForce.get(o).card.url!=null)
                    gc.drawImage(new Image(enemyForce.get(o).card.getUrl(),50,50,false,false),enemyForce.get(o).x,enemyForce.get(o).y);
                }
                if(jj>30)
                    jj=0;
                if(jjj>150)
                    jjj=0;
            }
        }.start();
    }

    private void setWinner() {
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
        if (chosenCard.equals(rageImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Rage(rageImage.getUrl()),rageImage.getUrl(),rageImage.getUrl(),x,y));
                chosenCardImage.setImage(frame);
                chosenCard=null;
            }
        } else if (chosenCard.equals(babarImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Barbarian(babarImageBattle.getUrl()),barbaru.getUrl(),barbard.getUrl(),x,y));
                cardsInGame.add(new CardXY(new Barbarian(babarImageBattle.getUrl()),barbaru.getUrl(),barbard.getUrl(),x+20,y+20));
                cardsInGame.add(new CardXY(new Barbarian(babarImageBattle.getUrl()),barbaru.getUrl(),barbard.getUrl(),x+20,y));
                cardsInGame.add(new CardXY(new Barbarian(babarImageBattle.getUrl()),barbaru.getUrl(),barbard.getUrl(),x,y+20));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(wizardImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Wizard(wizardImageBattle.getUrl()),wizardu.getUrl(),wizardd.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(infernoImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Inferno(infernoImageBattle.getUrl()),infernoImageBattle.getUrl(),infernoImageBattle.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(babyDragonImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new BabyDragon(babyDragonImageBattle.getUrl()),dragonu.getUrl(),dragonD.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(archerImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Archer(archerImageBattle.getUrl()),archerd.getUrl(),archeru.getUrl(),x,y));
                cardsInGame.add(new CardXY(new Archer(archerImageBattle.getUrl()),archerd.getUrl(),archeru.getUrl(),x+20,y+20));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(arrowImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Arrow(arrowImage.getUrl()),arrowImage.getUrl(),arrowImage.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(giantImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Giant(giantImageBattle.getUrl()),giantd.getUrl(),giantu.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(valkyrieImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Valkyrie(valkyrieImageBattle.getUrl()),valkD.getUrl(),valku.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(pekaImage.getUrl())&&chosenCard!=null) {

            {
                cardsInGame.add(new CardXY(new Peka(pekaImageBattle.getUrl()),minid.getUrl(),miniu.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(canonImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new Canon(canonImageBattle.getUrl()),canonImageBattle.getUrl(),canonImageBattle.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        } else if (chosenCard.equals(fireBallImage.getUrl())&&chosenCard!=null) {
            {
                cardsInGame.add(new CardXY(new FireBall(fireBallImageBattle.getUrl()),fireBallImageBattle.getUrl(),fireBallImageBattle.getUrl(),x,y));
                chosenCard=null;
                chosenCardImage.setImage(frame);
            }
        }
    }
}
