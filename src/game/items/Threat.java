package game.items;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Threat extends Item {

    private int type;
    private boolean defeated;

    public Threat() {
        super();
    }

    public Threat(int id, double x, double y, int type) {
        super(id, x, y);
        createTypeOfThreat(type);
        getImage().relocate(x, y);
    }

    private void createTypeOfThreat(int type) {
        switch (type) {
            case 0:
                createOrkThreat();
                break;
            case 1:
                createBombThreat();
                break;
            case 2:
                createBatThreat();
        }
    }

    private void createOrkThreat() {
        Rectangle orkShape = new Rectangle(20, 40, Color.GREENYELLOW);
        orkShape.setStroke(Color.GREY);
        orkShape.setStrokeWidth(2.0);
        setImage(orkShape);
        setName("Ork");
    }

    private void createBombThreat() {
        Circle bombShape = new Circle(15, Color.BLACK);
        bombShape.setStroke(Color.GREY);
        bombShape.setStrokeWidth(1.0);
        setImage(bombShape);
        setName("Bomb");
    }

    private void createBatThreat() {
        Rectangle batShape = new Rectangle(40, 15, Color.DARKGRAY);
        batShape.setStroke(Color.GREY);
        batShape.setStrokeWidth(1.0);
        setImage(batShape);
        setName("Bat");
    }

    public Threat(int id, String name, double x, double y) {
        super(id, name, x, y);
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

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public void setX(double x) {
        super.setX(x);
    }

    @Override
    public double getY() {
        return super.getY();
    }

    @Override
    public void setY(double y) {
        super.setY(y);
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
    }

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }
}
