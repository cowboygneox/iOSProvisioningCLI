package com.gneoxsolutions.iosprovisioningcli

object Runner extends App {

}

trait SiteDriver {
  def listDevelopmentProfiles()
}

class Runner {
  self: SiteDriver =>

  def << (commandString: String) {
    listDevelopmentProfiles()
  }
}