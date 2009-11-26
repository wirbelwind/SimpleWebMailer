package bootstrap.liftweb

import _root_.net.liftweb.common._
import _root_.net.liftweb.util._
import _root_.net.liftweb.http._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._

/**
  * A class that's instantiated early and run.  It allows the application
  * to modify lift's environment
  */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("com.appspot.simplewebmailer")

    // Build SiteMap
    val entries = List(
		Menu(Loc("Home", List("index"), "Home")),
		Menu(Loc("Test", List("test"), "Test Page")),
		Menu(Loc("form", List("hellform"), "Form")),
		)
    LiftRules.setSiteMap(SiteMap(entries:_*))
  }
}

