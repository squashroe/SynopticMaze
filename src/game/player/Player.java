package game.player;

import game.configurations.Settings;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Player {

    private double x; // TODO : set a random location in the starting Room
    private double y;
    private int speed = 7;
    Shape playerImage;
    String playerName = Settings.PLAYER_NAME;
    private double playerMinX = 7;
    private double playerMaxX = Settings.SCENE_WIDTH -39;
    private double playerMinY = 7;
    private double playerMaxY = Settings.SCENE_HEIGHT -39;
    private boolean moveUp = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;

    public Player(double x, double y) {

//        String imageUrl = "file:///C:\\Users\\Joshua Roe\\IdeaProjects\\SynopticMaze\\src\\resources\\player.png";
//        imageView = new ImageView(new Image(imageUrl));
        playerImage = createPlayerImage();
        this.x = x;
        this.y = y;
        playerImage.relocate(x, y);
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

        checkBounds();


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
            playerImage.relocate(x,y);
        }
    }

    public void moveLeft() {
        if (moveLeft) {
            x -= speed;
            playerImage.relocate( x, y);
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
        if(y < 7){
            y = 7;
        }
        if(y > Settings.SCENE_HEIGHT - 39){
            y = Settings.SCENE_HEIGHT -39;
        }
         //horizontal
      if(x < 7){
          x = 7;
      }
      if( x > Settings.SCENE_WIDTH - 39){
          x = Settings.SCENE_HEIGHT - 39;
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
