public class UntrustworthyMailWorker implements MailService {
    RealMailService realMailService = new RealMailService();
    MailService[] unknowns;

    public UntrustworthyMailWorker(MailService[] unknowns) {
        this.unknowns = unknowns;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService unknown : unknowns) {
            mail = unknown.processMail(mail);
                    }
        return realMailService.processMail(mail);
    }
}
