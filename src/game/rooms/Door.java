package game.rooms;

public class Door {

    private int id;
    private boolean active;
    private Integer passageId;

    public Door(int id, boolean active, Integer passageId) {
        this.id = id;
        this.active = active;
        this.passageId = passageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getPassageId() {
        return passageId;
    }

    public void setPassageId(Integer passageId) {
        this.passageId = passageId;
    }
}
