package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.Simulation._

import java.time.Duration

class GalaxyServiceLoadTest extends Simulation{
  val httpConf = http.baseUrl("http://10.254.1.192:8101/")

  setUp(
    galaxyScen.inject(constantUsersPerSec(1).during(1))
    .protocols(httpConf)
  )
}
