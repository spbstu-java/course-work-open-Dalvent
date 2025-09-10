package spbstu.opp.course.stratagy;

import spbstu.opp.course.helper.TextAreaLogger;

public class FlyHeroMovement implements HeroMovement {
    public static final String NAME = "Fly";

    @Override
    public void move(Hero hero, String to) {
        hero.showMessage("flying from " + hero.getCurrentLocation() + " to " + to);
        hero.setCurrentLocation(to);
    }
}
