package requests
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.core.feeder.{BatchableFeederBuilder, FeederBuilderBase}

import scala.reflect.internal.util.{BatchSourceFile, andFalse}


object Request {
  def jsonFeed(path: String):FeederBuilderBase[Any] = {
    val feeder = jsonFile(path)
    return feeder
  }

  private val authHeaders = Map(
    "Accept" -> "application/json",
    "Content-Type" -> "application/json",
    "Authorization" -> "Bearer ${accessToken}")

  def getPlanetById = {
    exec {
      http("Get Planet By Id")
        .get("api/v1/planet-app/planets/1/")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getSystems = {
    exec {
      http("Get Planet By Id")
        .get("api/v1/galaxy-app/systems/")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

}
