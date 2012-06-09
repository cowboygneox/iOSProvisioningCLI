package com.gneoxsolutions.iosprovisioningcli

class RunnerTest extends org.specs2.mutable.Specification {
  "A Runner" should {
    var listDevelopmentProfilesHappend = false

    val runner = new Runner() with SiteDriver {
      def listDevelopmentProfiles() {
        listDevelopmentProfilesHappend = true
      }
    }
    
    "List development provisioning profiles" in {
      runner << "list development profiles"
      listDevelopmentProfilesHappend must beEqualTo(true)
    }
  }
}
