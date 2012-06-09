package com.gneoxsolutions.iosprovisioningcli

class RunnerTest extends org.specs2.mutable.Specification {
  "A Runner" should {
    var listDevelopmentProfilesHappened = false
    var listDistributionProfilesHappened = false
    var caughtDeviceName = ""
    var caughtDeviceUuid = ""
    var removedDeviceUuid = ""

    val runner = new Runner() with SiteDriver {
      def listDevelopmentProfiles() { listDevelopmentProfilesHappened = true }
      def listDistributionProfiles() { listDistributionProfilesHappened = true }
      def addNewDevice(deviceName: String, deviceUuid: String) { caughtDeviceName = deviceName; caughtDeviceUuid = deviceUuid }
      def removeDevice(deviceUuid: String) { removedDeviceUuid = deviceUuid }
    }

    "List development provisioning profiles" in {
      runner << "list development profiles"
      listDevelopmentProfilesHappened must beEqualTo(true)
    }

    "List distribution provisioning profiles" in {
      runner << "list distribution profiles"
      listDistributionProfilesHappened must beEqualTo(true)
    }

    "Add new device" in {
      runner << "add device a new phone abcdef1234567890"
      caughtDeviceName must beEqualTo("a new phone")
      caughtDeviceUuid must beEqualTo("abcdef1234567890")
    }
    "Remove device" in {
      runner << "remove device abcdef1234567890"
      removedDeviceUuid must beEqualTo("abcdef1234567890")
    }
  }
}
