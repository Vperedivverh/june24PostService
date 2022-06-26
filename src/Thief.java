public class Thief implements MailService {
    int minPrice;
    int counter = 0;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    int getStolenValue() {
        return counter;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package content = ((MailPackage) mail).getContent();
            if (content.getPrice() >= minPrice) {
                counter += content.getPrice();
                content = new Package("stones instead of ", 0);
                return new MailPackage(mail.getFrom(), mail.getTo(), content);
            } else return mail;

        } else {
            return mail;
        }
    }
}
