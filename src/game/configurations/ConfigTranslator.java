package game.configurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class will talk to the config.txt file and get the data and input it into the Settings
 * class of the game
 */
public class ConfigTranslator {

    public ConfigTranslator() {
    }

    public static void readFile() {
        Properties prop = new Properties();

        String fileName = "src/game/configurations/MazeConfig.txt";
        try {
            FileInputStream fileInputStream =
                    new FileInputStream(fileName);
            prop.load(fileInputStream);
            String treasureAmount = prop.getProperty("MAX_TREASURE_PER_ROOM");
            Settings.MAX_TREASURE_PER_ROOM = Integer.parseInt(treasureAmount);

            String threatAmount = prop.getProperty("MAX_THREATS_PER_ROOM");
            Settings.MAX_THREATS_PER_ROOM = Integer.parseInt(threatAmount);

            String name = prop.getProperty("PLAYER_NAME");
            Settings.PLAYER_NAME = name;

            String wealth = prop.getProperty("TOTAL_WEALTH");
            Settings.TOTAL_WEALTH = Integer.parseInt(wealth);


        } catch (FileNotFoundException e) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            ex.printStackTrace();
        }
    }
}
