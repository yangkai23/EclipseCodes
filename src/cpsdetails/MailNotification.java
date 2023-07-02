package cpsdetails;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailNotification {
	public static void sendMail(String body, String subject) {
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getDefaultInstance(properties);
		session.setDebug(true);
		Message message = new MimeMessage(session);
		try {
			MailDto mailDto = new MailDto();
			mailDto.setMailBody(body);
			mailDto.setSubject(subject);
			message.setSubject(mailDto.getSubject());
			message.setSentDate(new Date());
			message.setText(mailDto.getMailBody());

			Address fromAddress = new InternetAddress(mailDto.getSender());
			Address toAddress = new InternetAddress(mailDto.getRecipient());
			message.setFrom(fromAddress);
			message.setRecipient(RecipientType.TO, toAddress);
			Transport transport = session.getTransport();
			transport.connect(mailDto.getSender(), "xavvibzchmoljhca");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
