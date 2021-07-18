package sample;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.*;

public class GameController implements Initializable {
    int m=3,s=0,i=0,elixirs=0;
    String chosenCard;
    private ArrayList<String> deck=null,alternativeDeck=new ArrayList<String>();
    @FXML
    private Button game;
    @FXML
    private ProgressBar elixirBar;
    @FXML
    private Label elixirLabel,timeLabel,crownLabel;
    @FXML
    private ImageView gameDeck1,gameDeck2,gameDeck3,gameDeck4,gameDeck5;
    @FXML
    private ImageView chosenCardImage;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    deck=Controller.legends;
    }
    @FXML
    private void game(ActionEvent event) {
        for(int i=0;i<5;i++)
        {
            int n;
            n=new Random().nextInt(deck.size());
            alternativeDeck.add(deck.get(n));
            deck.remove(n);
        }
        gameDeck1.setImage(new Image(alternativeDeck.get(0)));
        gameDeck2.setImage(new Image(alternativeDeck.get(1)));
        gameDeck3.setImage(new Image(alternativeDeck.get(2)));
        gameDeck4.setImage(new Image(alternativeDeck.get(3)));
        gameDeck5.setImage(new Image(alternativeDeck.get(4)));
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
        s--;
        if(m==0)
        i+=2;
        else
            i++;
        if(i==2 && elixirs<10)
        {
            i=0;
            elixirs++;
            Platform.runLater(()->elixirBar.setProgress((double)elixirs/10));
            Platform.runLater(()->elixirLabel.setText(String.valueOf(elixirs)));
        }
        if(s<0)
        {
            m--;
            s+=60;
        }
        if(s<10)
            Platform.runLater(()->timeLabel.setText(m+":0"+s));
        else
            Platform.runLater(()->timeLabel.setText(m+":"+s));
                if(m==0 && s==0)
                    this.cancel();
            }
        };
        Timer t=new Timer();
        t.schedule(timerTask,1000,1000);
    }
    @FXML
    public void gameDeck1(MouseEvent mouseEvent)
    {
        if(gameDeck1.getImage().getUrl().equals(archerImage.getUrl()))
        if(elixirs>2)
        {
            chosenCard=archerImage.getUrl();
            chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck1.getImage().getUrl().equals(arrowImage.getUrl()))
            if(elixirs>2)
        {
            chosenCard=arrowImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck1.getImage().getUrl().equals(babyDragonImage.getUrl()))
                if(elixirs>3)
        {
            chosenCard=babyDragonImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck1.getImage().getUrl().equals(babarImage.getUrl()))
                    if(elixirs>5)
        {
            chosenCard=babarImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck1.getImage().getUrl().equals(fireBallImage.getUrl()))
                        if(elixirs>3)
        {
            chosenCard=fireBallImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck1.getImage().getUrl().equals(canonImage.getUrl()))
                            if(elixirs>2)
        {
            chosenCard=canonImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck1.getImage().getUrl().equals(giantImage.getUrl()))
                                if(elixirs>4)
        {
            chosenCard=giantImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck1.getImage().getUrl().equals(pekaImage.getUrl()))
                                    if(elixirs>3)
        {
            chosenCard=pekaImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck1.getImage().getUrl().equals(rageImage.getUrl()))
                                        if(elixirs>2)
        {
            chosenCard=rageImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck1.getImage().getUrl().equals(valkyrieImage.getUrl()))
                                            if(elixirs>3)
        {
            chosenCard=valkyrieImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck1.getImage().getUrl().equals(wizardImage.getUrl()))
                                                if(elixirs>4)
        {
            chosenCard=wizardImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck1.getImage().getUrl().equals(infernoImage.getUrl()))
                                                    if(elixirs>4)
        {
            chosenCard=infernoImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
    }
    @FXML
    public void gameDeck2(MouseEvent event)
    {
        if(gameDeck2.getImage().getUrl().equals(archerImage.getUrl()) && elixirs>2)
        {
            chosenCard=archerImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck2.getImage().getUrl().equals(arrowImage.getUrl())&& elixirs>2)
        {
            chosenCard=arrowImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck2.getImage().getUrl().equals(babyDragonImage.getUrl())&& elixirs>3)
        {
            chosenCard=babyDragonImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck2.getImage().getUrl().equals(babarImage.getUrl())&& elixirs>4)
        {
            chosenCard=babarImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck2.getImage().getUrl().equals(fireBallImage.getUrl())&& elixirs>3)
        {
            chosenCard=fireBallImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck2.getImage().getUrl().equals(canonImage.getUrl())&& elixirs>2)
        {
            chosenCard=canonImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck2.getImage().getUrl().equals(giantImage.getUrl())&& elixirs>4)
        {
            chosenCard=giantImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck2.getImage().getUrl().equals(pekaImage.getUrl())&& elixirs>3)
        {
            chosenCard=pekaImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck2.getImage().getUrl().equals(rageImage.getUrl())&& elixirs>2)
        {
            chosenCard=rageImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck2.getImage().getUrl().equals(valkyrieImage.getUrl())&& elixirs>3)
        {
            chosenCard=valkyrieImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck2.getImage().getUrl().equals(wizardImage.getUrl())&& elixirs>4)
        {
            chosenCard=wizardImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck2.getImage().getUrl().equals(infernoImage.getUrl())&& elixirs>4)
        {
            chosenCard=infernoImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
    }
    @FXML
    public void gameDeck3(MouseEvent actionEvent)
    {
        if(gameDeck3.getImage().getUrl().equals(archerImage.getUrl())&& elixirs>2)
        {
            chosenCard=archerImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck3.getImage().getUrl().equals(arrowImage.getUrl())&& elixirs>2)
        {
            chosenCard=arrowImage.getUrl();
            elixirs-=3;chosenCardImage.setImage(new Image(chosenCard));
        }
        else if(gameDeck3.getImage().getUrl().equals(babyDragonImage.getUrl())&& elixirs>3)
        {
            chosenCard=babyDragonImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck3.getImage().getUrl().equals(babarImage.getUrl())&& elixirs>4)
        {
            chosenCard=babarImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck3.getImage().getUrl().equals(fireBallImage.getUrl())&& elixirs>3)
        {
            chosenCard=fireBallImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck3.getImage().getUrl().equals(canonImage.getUrl())&& elixirs>2)
        {
            chosenCard=canonImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck3.getImage().getUrl().equals(giantImage.getUrl())&& elixirs>4)
        {
            chosenCard=giantImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck3.getImage().getUrl().equals(pekaImage.getUrl())&& elixirs>3)
        {
            chosenCard=pekaImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck3.getImage().getUrl().equals(rageImage.getUrl())&& elixirs>2)
        {
            chosenCard=rageImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck3.getImage().getUrl().equals(valkyrieImage.getUrl())&& elixirs>3)
        {
            chosenCard=valkyrieImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck3.getImage().getUrl().equals(wizardImage.getUrl())&& elixirs>4)
        {
            chosenCard=wizardImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck3.getImage().getUrl().equals(infernoImage.getUrl())&& elixirs>4)
        {
            chosenCard=infernoImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
    }
    @FXML
    public void gameDeck4(MouseEvent event)
    {
        if(gameDeck4.getImage().getUrl().equals(archerImage.getUrl())&& elixirs>2)
        {
            chosenCard=archerImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck4.getImage().getUrl().equals(arrowImage.getUrl())&& elixirs>2)
        {
            chosenCard=arrowImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck4.getImage().getUrl().equals(babyDragonImage.getUrl())&& elixirs>3)
        {
            chosenCard=babyDragonImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck4.getImage().getUrl().equals(babarImage.getUrl())&& elixirs>4)
        {
            chosenCard=babarImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck4.getImage().getUrl().equals(fireBallImage.getUrl())&& elixirs>3)
        {
            chosenCard=fireBallImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck4.getImage().getUrl().equals(canonImage.getUrl())&& elixirs>2)
        {
            chosenCard=canonImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck4.getImage().getUrl().equals(giantImage.getUrl())&& elixirs>4)
        {
            chosenCard=giantImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck4.getImage().getUrl().equals(pekaImage.getUrl())&& elixirs>3)
        {
            chosenCard=pekaImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck4.getImage().getUrl().equals(rageImage.getUrl())&& elixirs>2)
        {
            chosenCard=rageImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=3;
        }
        else if(gameDeck4.getImage().getUrl().equals(valkyrieImage.getUrl())&& elixirs>3)
        {
            chosenCard=valkyrieImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=4;
        }
        else if(gameDeck4.getImage().getUrl().equals(wizardImage.getUrl())&& elixirs>4)
        {
            chosenCard=wizardImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
        else if(gameDeck4.getImage().getUrl().equals(infernoImage.getUrl())&& elixirs>4)
        {
            chosenCard=infernoImage.getUrl();chosenCardImage.setImage(new Image(chosenCard));
            elixirs-=5;
        }
    }
    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }
}
