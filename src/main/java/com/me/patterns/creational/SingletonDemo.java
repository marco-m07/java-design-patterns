/**
 * Goal:
 *     Ensures that a class has only 1 instance, providing a global access point to it.
 * Use cases:
 *     - For resources that are expensive to create.
 *     - Loggers.
 */


class Logger {

    // Singleton instance.
    private static final Logger INSTANCE = new Logger();
    private String level;

    // Define a private constructor.
    private Logger() {
        this.level = "INFO";
    }

    // Global access point to singleton instance.
    public static Logger getLogger() {
        return INSTANCE;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void log(String message) {
        System.out.println(this.getLevel() + " - " + message);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.setLevel("DEBUG");
        System.out.println("New logger level: " + logger.getLevel());
        Logger otherLogger = Logger.getLogger();
        boolean isTheSame = logger.equals(otherLogger);
        System.out.println("Are the two loggers the same? " + isTheSame);
        logger.log("test message");
    }
}

