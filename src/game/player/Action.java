package game.player;

/**
 * This class defines which action the player uses to defeat a threat
 */
public class Action {

    private boolean sword = false;
    private boolean disarm = false;
    private boolean net = false;

    Action() {
    }

    public void useSword() {
        //defeat the Ork
        sword = true;

    }

    public void disarm() {
        //disarm the Bomb
        disarm = true;

    }

    public void useNet() {
        //defeat the Bat
        net = true;
    }

    boolean isSword() {
        return sword;
    }

    public void setSword(boolean sword) {
        this.sword = sword;
    }

    boolean isDisarm() {
        return disarm;
    }

    public void setDisarm(boolean disarm) {
        this.disarm = disarm;
    }

    boolean isNet() {
        return net;
    }

    public void setNet(boolean net) {
        this.net = net;
    }
}
