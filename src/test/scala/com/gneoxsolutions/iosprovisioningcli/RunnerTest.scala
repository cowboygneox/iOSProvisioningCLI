package com.gneoxsolutions.iosprovisioningcli

class RunnerTest extends org.specs2.mutable.Specification {
  "A Runner" should {
    var listDevelopmentProfilesHappened = false
    var listDistributionProfilesHappened = false

    val runner = new Runner() with SiteDriver {
      def listDevelopmentProfiles() { listDevelopmentProfilesHappened = true }
      def listDistributionProfiles() { listDistributionProfilesHappened = true }
    }

    "List development provisioning profiles" in {
      runner << "list development profiles"
      listDevelopmentProfilesHappened must beEqualTo(true)
    }

    "List distribution provisioning profiles" in {
      runner << "list distribution profiles"
      listDistributionProfilesHappened must beEqualTo(true)
    }
  }
}
