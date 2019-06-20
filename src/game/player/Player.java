package game.player;

import game.configurations.Settings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Player {

    private double x = 32; // TODO : set a random location in the starting Room
    private double y = 32;
    Shape playerImage;
    String playerName = Settings.PLAYER_NAME;
    private double playerMinX = 16;
    private double playerMaxX = Settings.SCENE_WIDTH - 48;
    private double playerMinY = 16;
    private double playerMaxY = Settings.SCENE_HEIGHT - 48;
    private boolean moveUp = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;

    public Player() {

//        String imageUrl = "file:///C:\\Users\\Joshua Roe\\IdeaProjects\\SynopticMaze\\src\\resources\\player.png";
//        imageView = new ImageView(new Image(imageUrl));
        playerImage = createPlayerImage();
        playerImage.relocate(x, y);

        // playfieldLayer.getChildren().add(imageView);

    }

    public Shape createPlayerImage() {
        Rectangle rect = new Rectangle(32, 32);
        rect.setFill(Color.GREEN);
        this.playerImage = rect;
        return playerImage;
    }

    public void move() {
        moveUp();
        moveDown();
        moveLeft();
        moveRight();
    }

    public void moveUp() {
        if (moveUp) {
            y -= 5;
            playerImage.relocate(x, y);
        }
    }

    public void moveDown() {
        if (moveDown) {
            y += 5;
            playerImage.relocate(x,y);
        }
    }

    public void moveLeft() {
        if (moveLeft) {
            x -= 5;
            playerImage.relocate( x, y);
        }
    }

    public void moveRight() {
        if (moveRight) {
            x += 5;
            playerImage.relocate(x, y);
        }
    }

    private void checkBounds() {

        //not being able to leave the window
        // vertical
        if (Double.compare(y, playerMaxY) < 0) {
            y = playerMinY;
        } else if (Double.compare(y, playerMaxY) > 0) {
            y = playerMaxY;
        }

        // horizontal
        if (Double.compare(x, playerMinX) < 0) {
            x = playerMinX;
        } else if (Double.compare(x, playerMaxX) > 0) {
            x = playerMaxX;
        }

    }

    public Shape getPlayerImage() {
        return playerImage;
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
}
