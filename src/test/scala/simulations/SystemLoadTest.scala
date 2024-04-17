package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.Simulation._

class SystemLoadTest extends Simulation{
  val httpConf = http.baseUrl("http://10.254.1.192:8101/")

  setUp(
    GetSustemsScen.inject(
      constantUsersPerSec(1) during 1
    ).protocols(httpConf)
  )
}
