package requests

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object Request {
  private val authHeaders = Map(
    "Accept" -> "application/json",
    "Content-Type" -> "application/json",
    "Authorization" -> "Bearer ${accessToken}"
  )

  def getPlanetById = {
    exec {
      http("Get Planet By Id")
        .get("api/v1/planet-app/planets/1")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getPlanetsBySystem = {
    exec {
      http("Get Planets By System")
        .get("api/v1/planet-app/systems/planets")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getPlanets = {
    exec {
      http("Get All Planets")
        .get("api/v1/planet-app/planets")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }



  def getSystemsById = {
    exec {
      http("Get System By Id")
        .get("api/v1/galaxy-app/systems/1")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getSystemsByGalaxyId = {
    exec{
      http("Get System By Galaxy Id")
        .get("api/v1/galaxy-app/galaxies/1/systems")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getGalaxiesById = {
    exec {
      http("Get Galaxies By Id")
        .get("api/v1/galaxy-app/galaxies/1")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getGalaxiesBySystemId = {
    exec {
      http("Get Galaxies By System Id")
        .get("api/v1/galaxy-app/systems/1/galaxies")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getGalaxiesBySystem = {
    exec {
      http("Get Galaxies By System")
        .get("api/v1/galaxy-app/systems/galaxies")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getGalaxies = {
    exec {
      http("Get All Galaxies")
        .get("api/v1/galaxy-app/galaxies")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }



  def getHomeWorks = {
    exec{
      http("Get All HomeWorks")
        .get("api/v1/homework-app/homeworks")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }
}
