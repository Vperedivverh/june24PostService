// Теперь рассмотрим классы, которые моделируют работу почтового сервиса:
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}
