package spbstu.opp.course.annotation;

import spbstu.opp.course.helper.TextAreaLogger;

public class ExampleClass {

    private final TextAreaLogger logger;

    public ExampleClass(TextAreaLogger logger) {
        this.logger = logger;
    }

    @Repeat(2)
    public void helloPublic() {
        logger.log("Hello, Public!");
    }

    public void sum(int a, int b) {
        logger.log("sum=" + (a + b));
    }

    public void showYesNo(boolean isYes) {
        logger.log(isYes ? "yes" : "no");
    }

    protected void helloProtected() {
        logger.log("Hello, Protected!");
    }

    protected void mul(int a, int b) {
        logger.log("mul=" + (a * b));
    }

    @Repeat(5)
    protected void showOkCancel(boolean isOk) {
        logger.log(isOk ? "ok" : "cancel");
    }

    @Repeat(3)
    private void helloPrivate() {
        logger.log("Hello, Private!");
    }

    @Repeat(1)
    private void sub(double a, double b) {
        logger.log("sub=" + (a - b));
    }

    protected void showTF(boolean isT) {
        logger.log(isT ? "T" : "F");
    }

    @Repeat(3)
    private boolean hello(String name) {
        logger.log("Hello, " + name + "!");
        return true;
    }
}
