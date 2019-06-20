package game.engine;

import game.configurations.Settings;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameInput {


        private Boolean escReleased = true;

        private Scene scene;

        public GameInput(Scene scene) {
            this.scene = scene;
        }

        public void addListeners() {
            scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
            scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);

        }

        public void removeListeners() {
            scene.removeEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
            scene.removeEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
        }

        /**
         * "Key Pressed" handler for all input events: register pressed key in the bitset
         */
        private EventHandler<KeyEvent> keyPressedEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // register key down

                if (event.getCode() == KeyCode.UP) {
                    Settings.getPLAYER().setMoveUp(true);
                }
                if (event.getCode() == KeyCode.DOWN) {
                    Settings.getPLAYER().setMoveDown(true);
                }
                if (event.getCode() == KeyCode.LEFT) {
                    Settings.getPLAYER().setMoveLeft(true);
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    Settings.getPLAYER().setMoveRight(true);
                }


                if ((event.getCode() == KeyCode.ESCAPE) && escReleased  && Settings.ESCPRESSED) {
                    escReleased = false;
                    Settings.ESCPRESSED = false;
                    System.out.println(Settings.ESCPRESSED);
                    return;
                }
                if ((event.getCode() == KeyCode.ESCAPE) && escReleased) {
                    escReleased = false;
                    Settings.ESCPRESSED = true;
                    System.out.println(Settings.ESCPRESSED);
                }
            }
        };

        /**
         * "Key Released" handler for all input events: unregister released key in the bitset
         */
        private EventHandler<KeyEvent> keyReleasedEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // register key up
                if (event.getCode() == KeyCode.UP) {
                    Settings.getPLAYER().setMoveUp(false);
                }
                if (event.getCode() == KeyCode.DOWN) {
                    Settings.getPLAYER().setMoveDown(false);
                }
                if (event.getCode() == KeyCode.LEFT) {
                    Settings.getPLAYER().setMoveLeft(false);
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    Settings.getPLAYER().setMoveRight(false);
                }

                if(event.getCode() == KeyCode.ESCAPE){
                    escReleased = true;
                }
            }
        };

        public Boolean getEscReleased() {
            return escReleased;
        }

        public void setEscReleased(Boolean escReleased) {
            this.escReleased = escReleased;
        }
}
