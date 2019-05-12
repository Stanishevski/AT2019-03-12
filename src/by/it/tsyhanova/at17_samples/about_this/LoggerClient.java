package by.it.tsyhanova.at17_samples.about_this;

public class LoggerClient {

    public static void main(String[] args) {
        Logger loggerToFile=new Logger();
        System.out.println(loggerToFile);
        loggerToFile.setLastMessage("last2");
        System.out.println(loggerToFile);

        Logger loggerToConsole=new Logger("message1");
        System.out.println(loggerToConsole);
        loggerToConsole.setLastMessage("message2");
        System.out.println(loggerToConsole);

    }
}
