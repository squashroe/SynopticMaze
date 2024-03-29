package game.rooms;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public class Room {
    private int id;
    private Canvas canvas;
    private Door doorNorth;
    private Door doorEast;
    private Door doorSouth;
    private Door doorWest;
    private boolean visited;

    public Room(int id, Door doorNorth, Door doorEast, Door doorSouth, Door doorWest) {
        this.id = id;
        this.doorNorth = doorNorth;
        this.doorEast = doorEast;
        this.doorSouth = doorSouth;
        this.doorWest = doorWest;
        visited = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Door getDoorNorth() {
        return doorNorth;
    }

    public void setDoorNorth(Door doorNorth) {
        this.doorNorth = doorNorth;
    }

    public Door getDoorEast() {
        return doorEast;
    }

    public void setDoorEast(Door doorEast) {
        this.doorEast = doorEast;
    }

    public Door getDoorSouth() {
        return doorSouth;
    }

    public void setDoorSouth(Door doorSouth) {
        this.doorSouth = doorSouth;
    }

    public Door getDoorWest() {
        return doorWest;
    }

    public void setDoorWest(Door doorWest) {
        this.doorWest = doorWest;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Door> getAllDoors() {
        ArrayList<Door> allDoors = new ArrayList<>();
        allDoors.add(getDoorNorth());
        allDoors.add(getDoorEast());
        allDoors.add(getDoorSouth());
        allDoors.add(getDoorWest());

        return allDoors;
    }
}
