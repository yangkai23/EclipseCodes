package cpsdetails;

import java.io.Serializable;

public class MailDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subject;
	private String mailBody;
	private final String sender;
	private final String recipient;

	public MailDto() {
		this.subject = "";
		this.mailBody = "";
		this.sender = "amirudhshanmukha2399@gmail.com";
		this.recipient = "tallurishanmukha.anirudh@clarivate.com";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getSender() {
		return sender;
	}

	public String getRecipient() {
		return recipient;
	}

	@Override
	public String toString() {
		return "MailDto [subject=" + subject + ", mailBody=" + mailBody + ", sender=" + sender + ", recipient="
				+ recipient + "]";
	}

}
