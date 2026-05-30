package uber.desafio.core;

public interface EmailSenderUsecase {

    void sendEmail(String to, String subject, String body);

}
