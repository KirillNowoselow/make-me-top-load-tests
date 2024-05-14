package requests

import io.gatling.http.Predef._
import io.gatling.core.Predef._

import javax.swing.plaf.basic.BasicBorders.MarginBorder

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

  def goToProfile = {
    exec{
      http("Profile")
        .get("api/v1/person-app/people/keeper-profile")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getPlanetsBySystemId = {
    exec {
      http("Get Planets By System Id")
        .get("api/v1/planet-app/systems/1/planets")
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

  def addSystem = {
    exec{
      http("Add System")
        .post("api/v1/galaxy-app/orbits/2/systems")
        .headers(authHeaders)
        .body(StringBody
        ("""
           |{
           |  "systemName": "System1",
           |  "systemPosition": 0,
           |  "description": "string"
           |}
           |""".stripMargin)
        ).asJson
        .check(
          status.is(201),
          bodyString.transform(_.toInt).saveAs("systemId"))
    }
  }

  def deleteSystem = {
    exec{
      http("Delete System")
        .delete("api/v1/galaxy-app/systems/${systemId}")
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

  def getGalaxies = {
    exec {
      http("Get All Galaxies")
        .get("api/v1/galaxy-app/galaxies")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getHomeWorkByHomeWorkId = {
    exec{
      http("Get HomeWork By HomeWork Id")
        .get("api/v1/homework-app/homeworks/1")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getHomeWorkByThemeId = {
    exec{
      http("Get HomeWork By Theme Id")
        .get("api/v1/homework-app/themes/1/homeworks")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }

  def getKeeperApprovedRequests = {
    exec {
      http("Get Keeper Approved Requests")
        .get("api/v1/course-registration-app/course-requests/rejections")
        .headers(authHeaders)
        .check(status.is(200))
    }
  }
}
