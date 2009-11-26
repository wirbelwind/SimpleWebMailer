package com.appspot.simplewebmailer.snippet

import net.liftweb.http.S

class HelloForm {
  def who = {
    val action = S.param("whoField").openOr("")
    if (action == "redirect")
	    S.redirectTo("index")
  	<tt>{S.param("whoField").openOr("")}</tt>
  }
}
