package game.items;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Treasure extends Item {

    private int value;
    private int type;

    public Treasure() {
        super();
    }

    public Treasure(int id, double x, double y, int type) {
        super(id, x, y);
        createTypeOfCoin(type);
        this.value = value;
        getImage().relocate(x, y);
    }


    public void createTypeOfCoin(int type) {
        switch(type) {
            case 0 :
                createCopperTreasure();
                break;
            case 1 :
                createSilverTreasure();
                break;
            case 2 :
                createGoldTreasure();
        }
    }
    public void createGoldTreasure() {
        Circle circle = new Circle(20, Color.GOLD);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1.0);
        setImage(circle);
        setValue(30);
        setName("Gold");
    }

    public void createSilverTreasure() {
        Circle circle = new Circle(15, Color.SILVER);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1.0);
        setImage(circle);
        setValue(10);
        setName("Silver");
    }

    public void createCopperTreasure() {
        Circle circle = new Circle(10, Color.ROSYBROWN);
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

    public void setValue(int value) {
        this.value = value;
    }
}
