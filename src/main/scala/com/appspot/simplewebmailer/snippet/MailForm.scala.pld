package com.appspot.simplewebmailer.snippet

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import _root_.scala.xml.NodeSeq
import _root_.net.liftweb.util.Helpers
import Helpers._
import net.liftweb.http.S

import java.util.Properties


class MailForm {
  def send : NodeSeq = {
    // S.param(String)がBoxインスタンスを返す。
    // BoxインスタンスはAnyみたいなObjectで空の場合のデフォルト値を指定(openOr)してとりだす
    // C# なら to = S.param("to") ?? ""  ですむのにねえ
    val to = S.param("to").openOr("") 
    val subject = S.param("subject").openOr("")
    val content = S.param("content").openOr("")
    if (to == "redirect")
	    S.redirectTo("index")
  	<tt>{subject}</tt>
  	
  	var props:Properties = new Properties();
 	var session:Session = Session.getDefaultInstance(props, null);
	var result = <tt>Failed</tt>;
  try {
         var msg:Message = new MimeMessage(session);
         
         //この辺のInternetAddressでInetAddressを使ってるYO!
         msg.setFrom(new InternetAddress("peridot.eos@gmail.com"));
         msg.setRecipient(Message.RecipientType.TO,
                          new InternetAddress(to));

         msg.setSubject(subject);
         msg.setText(content);
 
		 //ここでエラーがでる。
		 //InetAddressが制限されてるが、アクセスするのでエラー
         Transport.send(msg);
     	 result = <tt>Success:{to}</tt>;
  } catch {
         case e:java.lang.NoClassDefFoundError => result = <tt>No class</tt>
         case e:AddressException => result = <tt>{e.getMessage}</tt>; printf("Exp_A(%s)\n", e.getMessage)
         case e:MessagingException => result = <tt>{e.getMessage}</tt>; printf("Exp_B(%s)\n", e.getMessage)
         case e => result = <tt>{e.printStackTrace}</tt>; e.printStackTrace
  }
  return result;
  }

}

