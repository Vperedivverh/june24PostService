public  class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            Package content = ((MailPackage) mail).getContent();
            if (content.getContent().contains("weapons") || content.getContent().contains("banned substance")) {
                throw new IllegalPackageException();
            }
            if (content.getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }

        return mail;
    }

}

