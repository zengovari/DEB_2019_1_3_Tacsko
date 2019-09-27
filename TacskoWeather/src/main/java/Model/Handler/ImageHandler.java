package Model.Handler;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import lombok.extern.slf4j.Slf4j;

/**
 * This class handles the interaction with the images.
 */

@Slf4j
public class ImageHandler {
    private static Image clearImage = new Image(ImageHandler.class.getClassLoader().getResourceAsStream("img/clear.png"));
    private static Image stormImage = new Image(ImageHandler.class.getClassLoader().getResourceAsStream("img/storm.png"));
    private static Image rainImage = new Image(ImageHandler.class.getClassLoader().getResourceAsStream("img/rain.png"));
    private static Image fogImage = new Image(ImageHandler.class.getClassLoader().getResourceAsStream("img/fog.png"));
    private static Image fewCloudsImage = new Image(ImageHandler.class.getClassLoader().getResourceAsStream("img/fewClouds.png"));
    private static Image scatteredCloudsImage = new Image(ImageHandler.class.getClassLoader().getResourceAsStream("img/scatteredClouds.png"));
    private static Image brokenCloudsImage = new Image(ImageHandler.class.getClassLoader().getResourceAsStream("img/brokenClouds.png"));
    private static Image overcastCloudsImage = new Image(ImageHandler.class.getClassLoader().getResourceAsStream("img/overcastClouds.png"));


    /**
     * Selects the correct image according to the description.
     * @param description selects the correct image according to this.
     * @return the correct image if it exists, otherwise null.
     */

    private static Image selectCorrectImage (String description) {
        description = description.toLowerCase();
        Image correctImage = null;

        if (description.contains("clear") || description.contains("drizzle")) correctImage = clearImage;
        else if (description.contains("thunderstorm")) correctImage = stormImage;
        else if (description.contains("rain")) correctImage = rainImage;
        else if (description.contains("haze") || description.contains("fog") || description.contains("mist")) correctImage = fogImage;
        else if (description.contains("few")) correctImage = fewCloudsImage;
        else if (description.contains("scattered")) correctImage = scatteredCloudsImage;
        else if (description.contains("broken")) correctImage = brokenCloudsImage;
        else if (description.contains("overcast")) correctImage = overcastCloudsImage;

        if (correctImage == null) {
            log.error("Nincs ilyen kép");
        }

        return correctImage;

    }

    /**
     * Returns a background according to the given description.
     *
     * @param pane the name of the pane
     * @param description selects the correct image according to this, using {@link #selectCorrectImage(String)}
     * @return the created background
     */

    public static Background getBackgroundImage(AnchorPane pane, String description) {

        BackgroundSize backgroundSize = new BackgroundSize(pane.getWidth(), pane.getHeight(), false, false, true, true);
        return new Background(new BackgroundImage(selectCorrectImage(description), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize));
    }
}
