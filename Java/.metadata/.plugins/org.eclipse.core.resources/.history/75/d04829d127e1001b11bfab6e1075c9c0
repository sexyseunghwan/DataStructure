package com.test.algorithm;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	/** 메일 HOST **/
	private static final String HOST = "smtp.naver.com";
	/** 메일 PORT **/
	private static final String PORT = "587";
	/** 메일 ID **/
	private static final String MAIL_ID = "ssh9308@naver.com";
	/** 메일 PW **/
	private static final String MAIL_PW = "bm@170#125";
	
	public static void sendNotiMail(String subejct, String body) {
		try {
			InternetAddress[] receiverList = new InternetAddress[1];//수신인 몇명인지 정해줄것
			receiverList[0] = new InternetAddress("ssh9308@gmail.com");
			
			
			// SMTP 발송 Properties 설정
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", MailUtil.HOST);
			props.put("mail.smtp.port", MailUtil.PORT);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.trust", MailUtil.HOST);
			props.put("mail.smtp.auth", "true");
			
			// SMTP Session 생성
			Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(MailUtil.MAIL_ID, MailUtil.MAIL_PW);
				}
			});
			
			// Mail 조립
			Message mimeMessage = new MimeMessage(mailSession);
			mimeMessage.setFrom(new InternetAddress(MailUtil.MAIL_ID));
			mimeMessage.setRecipients(Message.RecipientType.TO, receiverList);
            		// 메일 제목
			mimeMessage.setSubject(subejct);
            		// 메일 본문 (.setText를 사용하면 단순 텍스트 전달 가능)
			mimeMessage.setContent(body, "text/html; charset=UTF-8");
			
			// Mail 발송
			Transport.send(mimeMessage);
			
		} catch(Exception e) {
			//Logger.getLogger(MailUtil.class).error("메일 발송 오류!!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		sendNotiMail("<div>제목</div>", "apple");
	}
}
