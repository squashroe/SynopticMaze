//package java.menus;
//
//import javafx.scene.Scene;
//import javafx.scene.input.KeyCode;
//
//public class MenuInputListener {
//
//    private Scene scene;
//    private int currentItem = 0;
//
//    public MenuInputListener( Scene scene) {
//        this.scene = scene;
//    }
//
//    public void addListener() {
//        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.UP) {
//                if (currentItem > 0) {
//                    //TODO get this working
//                    getMenuItem(currentItem).setActive(false);
//                    getMenuItem(--currentItem).setActive(true);
//                }
//            }
//
//            if (event.getCode() == KeyCode.DOWN) {
//                if (currentItem < menuBox.getChildren().size() - 1) {
//                    getMenuItem(currentItem).setActive(false);
//                    getMenuItem(++currentItem).setActive(true);
//                }
//            }
//
//            if (event.getCode() == KeyCode.ENTER) {
//                getMenuItem(currentItem).activate();
//            }
//        });
//    }
//
//    private MenuItem getMenuItem(int index) {
//        return (MenuItem) menuBox.getChildren().get(index);
//    }
//}
