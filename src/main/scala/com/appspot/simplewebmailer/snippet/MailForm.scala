package com.appspot.simplewebmailer.snippet
import com.google.appengine.api.mail.MailService.Message
import com.google.appengine.api.mail.MailServiceFactory
import com.google.appengine.api.mail.MailService

import _root_.scala.xml.NodeSeq
import _root_.net.liftweb.util.Helpers
import Helpers._
import net.liftweb.http.S

import java.util.Properties
import java.lang.IllegalArgumentException
import java.io.IOException

class MailForm {
  def send : NodeSeq = {
    val to = S.param("to").openOr("") 
    val subject = S.param("subject").openOr("")
    val content = S.param("content").openOr("")
    if (to.length == 0)
      return Nil
    var result : NodeSeq = Nil
    val mes = new Message("peridot.eos@gmail.com", to, subject, content);
    val service = MailServiceFactory.getMailService();
    try {
      service.send(mes);
      result = <div class="success"><p> You succeed to send email.</p></div>
    }
    catch {
      case e : IllegalArgumentException =>
        result = <div class="error"><p>You failed to send email.</p></div>
      case e : IOException =>
        result = <div class="error"><p>You failed to send email.</p></div>
    }
    result
  }
}
