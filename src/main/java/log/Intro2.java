package log;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Intro2 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Intro2.class);
        logger.debug("Hello world.");

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(loggerContext);
    }
}
