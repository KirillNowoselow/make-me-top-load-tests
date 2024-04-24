package simulations

import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scenarios.Simulation._
import config.Urls._
import scala.concurrent.duration._


class GalaxyServiceLoadTest extends Simulation{
  val cf: Config = ConfigFactory.load("application.conf")
  var httpConf: HttpProtocolBuilder = http.baseUrl(galaxyUrl)

  setUp(
    getAccessToken.inject(atOnceUsers(1)),
    galaxyScen.inject(
    nothingFor(5 seconds),
    atOnceUsers(5),
    rampUsers(10) during (10 seconds)
  ).protocols(httpConf)
  )
}
