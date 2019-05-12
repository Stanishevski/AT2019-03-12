package by.it.tsyhanova.at17_samples.about_this;

class Logger {

    private String lastMessage = "1111";

    Logger(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    Logger() {
        this("some default value");
    }

    void setLastMessage(String lastMessage) {
        if (lastMessage.length() > 5)
            this.lastMessage = lastMessage;
    }

    @Override
    public String toString() {
        return "Logger message = " + this.lastMessage;
    }
}
