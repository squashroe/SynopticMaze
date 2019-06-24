package game.player;

import game.configurations.Settings;
import game.items.Threat;
import game.items.Treasure;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private double x; // TODO : set a random location in the starting Room
    private double y;
    private int speed = 7;
    private Shape playerImage;
    private int imageSize = 32;
    private String playerName = Settings.PLAYER_NAME;
    private boolean moveUp = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private Action action;
    private Label nameLabel;
    private StackPane sp;


    public Player(double x, double y) {

//        String imageUrl = "file:///C:\\Users\\Joshua Roe\\IdeaProjects\\SynopticMaze\\src\\resources\\player.png";
//        imageView = new ImageView(new Image(imageUrl));
        playerImage = createPlayerImage();
        this.x = x;
        this.y = y;
        playerImage.relocate(x, y);
        action = new Action();
    }

    public Shape createPlayerImage() {
        Rectangle rect = new Rectangle(imageSize, imageSize);
        rect.setFill(Color.GREEN);
        this.playerImage = rect;
        return playerImage;
    }

    public void move() {
        moveUp();
        moveDown();
        moveLeft();
        moveRight();

        checkBounds();

    }

    public void spawnInRoom(int newDoorToSpawnAt) {
        switch (newDoorToSpawnAt) {
            case (0):
                System.out.println("moved to north door");
                setX(Settings.SCENE_WIDTH / 2);
                setY(50);
                break;
            case (1):
                setX(Settings.SCENE_WIDTH - 50);
                setY(Settings.SCENE_HEIGHT / 2);
                System.out.println("moved to east door");
                break;
            case (2):
                setX(Settings.SCENE_WIDTH / 2);
                setY(Settings.SCENE_HEIGHT - 50);
                System.out.println("moved to south door");
                break;
            case (3):
                setX(50);
                setY(Settings.SCENE_HEIGHT / 2);
                System.out.println("moved to west door");
                break;
        }
    }

    public void moveUp() {
        if (moveUp) {
            y -= speed;
            playerImage.relocate(x, y);
        }
    }

    public void moveDown() {
        if (moveDown) {
            y += speed;
            playerImage.relocate(x, y);
        }
    }

    public void moveLeft() {
        if (moveLeft) {
            x -= speed;
            playerImage.relocate(x, y);
        }
    }

    public void moveRight() {
        if (moveRight) {
            x += speed;
            playerImage.relocate(x, y);
        }
    }

    public void checkBounds() {

        /*
        using the number 7 here instead of 0 as my movement is 7.
        uaing 39 as thats the width of the player + 7 (movement).
         */
        //not being able to leave the window
        // vertical
        if (y < 7) {
            y = 7;
        }
        if (y > Settings.SCENE_HEIGHT - 39) {
            y = Settings.SCENE_HEIGHT - 39;
        }
        //horizontal
        if (x < 7) {
            x = 7;
        }
        if (x > Settings.SCENE_WIDTH - 39) {
            x = Settings.SCENE_HEIGHT - 39;
        }

    }

    public Shape getPlayerImage() {
        return playerImage;
    }

    public StackPane getsp() {
        Label nameLabel  = new Label(playerName, playerImage);
        StackPane r = new StackPane();
        r.getChildren().add(nameLabel);
        return r;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Action getAction() {
        return action;
    }

    public boolean collidesWith(Treasure treasure) {
        return (treasure.getX() + treasure.getRadius() >= x && treasure.getY() + treasure.getRadius() >= y &&
                treasure.getX() <= x + 40 && treasure.getY() <= y + 40);
    }

    public void collectTreasure(Treasure treasure) {
        if (!Settings.GAME_COMPLETE) {
            Settings.TOTAL_WEALTH += treasure.getValue();
        }
    }

    public void defeatThreats() {
        List<Threat> threatsToRemove = new ArrayList<>();
        for (Threat threat : Settings.threatsInCurrentRoom) {
            System.out.println(threat.getType());
            if (action.isSword() && (threat.getType() == 0)) {
                System.out.println("used action 0 here");
                threat.setDefeated(true);
                threat.getImage().relocate(9999, 9999);
                threatsToRemove.add(threat);
            }
            if (action.isDisarm() && (threat.getType() == 1)) {
                System.out.println("used action 1");
                threat.setDefeated(true);
                threat.getImage().relocate(9999, 9999);
                threatsToRemove.add(threat);
            }
            if (action.isNet() && (threat.getType() == 2)) {
                System.out.println("used action 2");
                threat.setDefeated(true);
                threat.getImage().relocate(9999, 9999);
                threatsToRemove.add(threat);
            }
        }
        Settings.threatsInCurrentRoom.removeAll(threatsToRemove);

        if (Settings.threatsInCurrentRoom.isEmpty()) {
            System.out.println("unlock all doors");
            Settings.doorsUnlocked = true;
        }
    }

}
