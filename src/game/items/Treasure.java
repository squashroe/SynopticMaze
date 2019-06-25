package game.items;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Treasure Class for the coins in the game
 */
public class Treasure extends Item {

    private int value;
    private int radius;

    public Treasure(int id, double x, double y, int type) {
        super(id, x, y);
        createTypeOfCoin(type);
        getImage().relocate(x, y);
    }


    private void createTypeOfCoin(int type) {
        switch (type) {
            case 0:
                createCopperTreasure();
                break;
            case 1:
                createSilverTreasure();
                break;
            case 2:
                createGoldTreasure();
        }
    }

    private void createGoldTreasure() {
        radius = 18;
        Circle circle = new Circle(radius, Color.GOLD);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1.0);
        setImage(circle);
        setValue(30);
        setName("Gold");
    }

    private void createSilverTreasure() {
        radius = 12;
        Circle circle = new Circle(radius, Color.SILVER);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1.0);
        setImage(circle);
        setValue(10);
        setName("Silver");
    }

    private void createCopperTreasure() {
        radius = 6;
        Circle circle = new Circle(radius, Color.ROSYBROWN);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1.0);
        setImage(circle);
        setValue(5);
        setName("Copper");
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Shape getImage() {
        return super.getImage();
    }

    @Override
    public void setImage(Shape image) {
        super.setImage(image);
    }

    public int getValue() {
        return value;
    }

    private void setValue(int value) {
        this.value = value;
    }

    public int getRadius() {
        return radius;
    }

}
