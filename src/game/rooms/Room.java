package game.rooms;

import javafx.scene.canvas.Canvas;

public class Room {
    private int id;
    private Canvas canvas;
    private int positionX;
    private int positionY;
    private int door1Id;
    private int door2Id;
    private int door3Id;
    private int door4Id;
    private int numberOfThreats;
    private int numberOfTreasures;
    private boolean doorsLocked;

    public Room(int id, int positionX, int positionY) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getId() {
        return id;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getDoor1Id() {
        return door1Id;
    }

    public void setDoor1Id(int door1Id) {
        this.door1Id = door1Id;
    }

    public int getDoor2Id() {
        return door2Id;
    }

    public void setDoor2Id(int door2Id) {
        this.door2Id = door2Id;
    }

    public int getDoor3Id() {
        return door3Id;
    }

    public void setDoor3Id(int door3Id) {
        this.door3Id = door3Id;
    }

    public int getDoor4Id() {
        return door4Id;
    }

    public void setDoor4Id(int door4Id) {
        this.door4Id = door4Id;
    }

    public int getNumberOfThreats() {
        return numberOfThreats;
    }

    public void setNumberOfThreats(int numberOfThreats) {
        this.numberOfThreats = numberOfThreats;
    }

    public int getNumberOfTreasures() {
        return numberOfTreasures;
    }

    public void setNumberOfTreasures(int numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    public boolean isDoorsLocked() {
        return doorsLocked;
    }

    public void setDoorsLocked(boolean doorsLocked) {
        this.doorsLocked = doorsLocked;
    }
}
