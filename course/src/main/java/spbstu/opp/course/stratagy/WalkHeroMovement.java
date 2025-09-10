package spbstu.opp.course.stratagy;

import spbstu.opp.course.helper.TextAreaLogger;

public class WalkHeroMovement implements HeroMovement {
    public static final String NAME = "Walk";

    @Override
    public void move(Hero hero, String to) {
        hero.showMessage("waling from " + hero.getCurrentLocation() + " to " + to);
        hero.setCurrentLocation(to);
    }
}