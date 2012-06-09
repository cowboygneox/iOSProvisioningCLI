package com.gneoxsolutions.iosprovisioningcli

object Runner extends App {
  new Runner() with SiteDriver {
    def listDevelopmentProfiles() {
      println("Placeholder: list development profiles")
    }

    def listDistributionProfiles() {
      println("Placeholder: list distribution profiles")
    }

    def addNewDevice(deviceName: String, deviceUuid: String) {
      println("Placeholder: add device")
    }

    def removeDevice(deviceUuid: String) {
      println("Placeholder: remove device")
    }
  } << args
}

trait SiteDriver {
  def listDevelopmentProfiles()
  def listDistributionProfiles()
  def addNewDevice(deviceName: String, deviceUuid: String)
  def removeDevice(deviceUuid: String)
}

class Runner {
  self: SiteDriver =>

  def output(string: String) {
    println(string)
  }

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
      case Array("remove", "device", deviceUuid: String) => {
        removeDevice(deviceUuid)
      }
      case Array("add", "device", _*) => {
        val remainingArgs = args.slice(2, args.length)
        val deviceName = remainingArgs.slice(0, remainingArgs.length - 1).mkString(" ")
        val deviceUuid = remainingArgs(remainingArgs.length - 1)
        addNewDevice(deviceName, deviceUuid)
      }
      case _ => {
        output("Usage can be found at https://github.com/cowboygneox/iOSProvisioningCLI")
      }
    }
  }
}