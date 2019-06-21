package game.items;

import javafx.scene.shape.Shape;

public class Item {

    private int id;
    private String name;
    private Shape image;
    private double x;
    private double y;

    public Item() {
    }

    public Item(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Item(int id, String name, double x, double y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shape getImage() {
        return image;
    }

    public void setImage(Shape image) {
        this.image = image;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}