package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created Vladimir Shekhavtsov.
 */
public class EmailSender {

    public void send(final String fromLogin, final String fromPassword, String toMail, String subject, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromLogin, fromPassword);
                    }
                });
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(fromLogin));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));

            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

