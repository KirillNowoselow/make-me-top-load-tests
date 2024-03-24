package scenarios
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import requests.Request
import requests.Request._

object Simulation {
  def PlanetRequestScen = scenario("planetRequest")
    .feed(jsonFeed("logindatafile.json"))
    .exec(auth)
}
