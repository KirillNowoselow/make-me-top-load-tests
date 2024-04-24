package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.Simulation._

import java.time.Duration
import scala.concurrent.duration._

class GalaxyServiceLoadTest extends Simulation{
  val httpConf = http.baseUrl(System.getProperty("galaxyUrl"))

  setUp(
    galaxyScen.inject(
    nothingFor(5 seconds),
    atOnceUsers(5),
    rampUsers(10) during (10 seconds)
  ).protocols(httpConf)
  )
}
