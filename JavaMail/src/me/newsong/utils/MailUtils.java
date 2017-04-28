package me.newsong.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class MailUtils {

	public static MimeMessage getMessage(String username, String password, String to, String subject) {
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp." + username.split("@")[1]);
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username.split("@")[0], password);
			}
		};
		// 得到连接
		Session session = Session.getInstance(prop, auth);
		// 创建邮件
		MimeMessage message = new MimeMessage(session);
		try {
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setFrom(new InternetAddress(username));
			message.setSubject(subject);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return message;
	}

	public static void send(String username, String password, String to, String subject, String content) {
		try {
			MimeMessage message = getMessage(username, password, to, subject);
			message.setContent(content, "text/html;charset=utf-8");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void send(String host, String username, String password, String from, String[] to, String subject,
			String content) {
		send(username, password, toString(to), subject, content);
	}

	private static String toString(String[] tos) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tos.length; ++i) {
			sb.append(tos[i]);
			if (i != tos.length - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	public static void sendWithAttachment(String username, String password, String to, String subject, String content,
			String filePath) {
		MimeMessage message = getMessage(username, password, to, subject);
		// 多部件的邮件：MimeMultiPart
		// 需要创建两个主体部件：一个是文本内容的，另一个是附件的
		// 主体部件为MimeBodyPart
		MimeMultipart list = new MimeMultipart();
		MimeBodyPart text = new MimeBodyPart();//文本
		MimeBodyPart attachment = new MimeBodyPart();//附件
		try {
			text.setContent(content, "text/html;charset=utf-8");
			File file = new File(filePath);
			if (!file.exists()) {
				throw new RuntimeException("文件 " + filePath + " 不存在");
			}
			attachment.attachFile(file);
			// 处理中文乱码问题
			attachment.setFileName(MimeUtility.encodeText(file.getName()));
			
			list.addBodyPart(text);
			list.addBodyPart(attachment);
			message.setContent(list);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void sendWithAttachment(String username, String password, String[] to, String subject, String content,
			String filePath){
		sendWithAttachment(username, password, toString(to), subject, content,filePath);
	}
	
	
	public static void main(String[] args) {
		MailUtils.sendWithAttachment("songxinjianzx@163.com", "201529sxj", "151070063@smail.nju.edu.cn", "呵呵哒", "噜噜噜", "E:/CentOS/虚拟机文件/喵.jpeg");
	}
}
