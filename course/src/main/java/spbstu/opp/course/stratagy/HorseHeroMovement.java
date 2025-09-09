package spbstu.opp.course.stratagy;

import javafx.fxml.FXML;
import spbstu.opp.course.helper.TextAreaLogger;

public class HorseHeroMovement implements HeroMovement {
    public static final String NAME = "Horse";

    @Override
    public void move(Hero hero, String to) {
        hero.showMessage("riding a horse from " + hero.getCurrentLocation() + " to " + to);
        hero.setCurrentLocation(to);
    }
}