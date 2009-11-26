package com.appspot.simplewebmailer.snippet

import _root_.scala.xml.NodeSeq
import _root_.net.liftweb.util.Helpers
import Helpers._
import net.liftweb.http.S

class MailForm {
  def send = {
    val to = S.param("to").openOr("")
    val subject = S.param("subject").openOr("")
    val content = S.param("content").openOr("")
    if (to == "redirect")
	    S.redirectTo("index")
  	<tt>{subject}</tt>
  }
}

