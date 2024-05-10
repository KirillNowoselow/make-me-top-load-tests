package simulations

import com.typesafe.config.{Config, ConfigFactory}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scenarios.Simulation._
import config.Urls._
import io.gatling.core.structure.PopulationBuilder

import scala.concurrent.duration._
import scala.language.postfixOps


class GalaxyServiceLoadTest extends Simulation{
  var httpConf = http.baseUrl(galaxyUrl)

  val stepConcurrentUserSnc: PopulationBuilder = galaxyScen.inject(
      incrementConcurrentUsers(addUsersPerStep)
        .times(stepCnt)
        .eachLevelLasting(stepTime seconds)
        .separatedByRampsLasting(stepRumpTime seconds)
        .startingFrom(addUsersPerStep))
    .protocols(httpConf)

  val startConcurrentUserSnc: PopulationBuilder = galaxyScen.inject(
      rampConcurrentUsers(1).to(addUsersPerStep).during(stepRumpTime seconds))
    .protocols(httpConf)

  val stabilityConcurrentUserSnc: PopulationBuilder = galaxyScen.inject(
      constantConcurrentUsers(stepCnt * addUsersPerStep)
        .during(stabilityStepTime seconds))
    .protocols(httpConf)


  setUp(
    getAccessToken.inject(atOnceUsers(1)),
    startConcurrentUserSnc,
    stepConcurrentUserSnc,
    stabilityConcurrentUserSnc
  )
}
