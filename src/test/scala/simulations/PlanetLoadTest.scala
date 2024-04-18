package simulations
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import scenarios.Simulation._

class PlanetLoadTest extends Simulation{
  val httpConf = http.baseUrl("http://10.254.1.192:8102/")

  setUp(
    planetScen.inject(
      constantUsersPerSec(1) during 1
    ).protocols(httpConf)
  )
}
