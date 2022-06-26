import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    Logger LOGGER;

    public Spy(Logger LOGGER) {
        this.LOGGER = LOGGER;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            String massage = ((MailMessage) mail).getMessage();
            if (mail.getFrom().contains("Austin Powers") || mail.getTo().contains("Austin Powers")) {
                LOGGER.log(Level.WARNING,
                        "Detected target mail correspondence: from " +
                                mail.getFrom() + " to " + mail.getTo() + " " + "\"" + massage + "\"");
            } else {
                LOGGER.log(Level.INFO, "Usual correspondence: from " + mail.getFrom() + " to " + mail.getTo());
            }
        }
        return mail;
    }
}
