package spbstu.opp.course.stratagy;

import spbstu.opp.course.helper.TextAreaLogger;

public class Hero {
    private final TextAreaLogger logger;
    private final String name;
    private HeroMovement movement;
    private String currentLocation;

    public Hero(TextAreaLogger logger, String name, String startLocation) {
        this.logger = logger;
        this.name = name;
        this.currentLocation = startLocation;
    }

    public String getHeroName() {
        return name;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String location) {
        currentLocation = location;
    }

    public void showMessage(String message) {
        logger.log(name + " " + message);
    }

    public void setMovement(HeroMovement movement) {
        this.movement = movement;
    }

    public void move(String to) {
        if (movement == null) {
            logger.log(name + " don't know how move :(");
            return;
        }

        movement.move(this, to);
        currentLocation = to;
    }

    public void showInfo() {
        StringBuilder infoBuilder = new StringBuilder();

        infoBuilder.append(name)
                   .append(" located at ")
                   .append(currentLocation);

        if (movement != null) {
            infoBuilder.append(" and he used for movement: ")
                       .append(movement);
        } else {
            infoBuilder.append(", but he don't know how move");
        }

        System.out.println(infoBuilder);
    }
}
