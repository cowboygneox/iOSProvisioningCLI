package com.gneoxsolutions.iosprovisioningcli

object Runner extends App {

}

trait SiteDriver {
  def listDevelopmentProfiles()
  def listDistributionProfiles()
  def addNewDevice(deviceName: String, deviceUuid: String)
}

class Runner {
  self: SiteDriver =>

  def << (commandString: String) {
    self << commandString.split(" ")
  }

  def << (args: Array[String]) {
    args match {
      case Array("list", "development", "profiles") => {
        listDevelopmentProfiles()
      }
      case Array("list", "distribution", "profiles") => {
        listDistributionProfiles()
      }
      case Array("add", "device", _*) => {
        val remainingArgs = args.slice(2, args.length)
        val deviceName = remainingArgs.slice(0, remainingArgs.length - 1).mkString(" ")
        val deviceUuid = remainingArgs(remainingArgs.length - 1)
        addNewDevice(deviceName, deviceUuid)
      }
      case _ => {

      }
    }
  }
}