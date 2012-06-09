package com.gneoxsolutions.iosprovisioningcli

object Runner extends App {

}

trait SiteDriver {
  def listDevelopmentProfiles()
  def listDistributionProfiles()
}

class Runner {
  self: SiteDriver =>

  def << (commandString: String) {
    commandString match {
      case "list development profiles" => {
        listDevelopmentProfiles()
      }
      case "list distribution profiles" => {
        listDistributionProfiles()
      }
    }
  }
}