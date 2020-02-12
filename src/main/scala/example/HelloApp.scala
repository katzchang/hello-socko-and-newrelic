package example

import java.util.Date

import akka.actor._
import org.mashupbots.socko.events._
import org.mashupbots.socko.routes._
import org.mashupbots.socko.webserver._

object HelloApp {
      //
      // STEP #1 - Define Actors and Start Akka
      // See `HelloHandler`
      //
      val actorSystem = ActorSystem("HelloExampleActorSystem")

      //
      // STEP #2 - Define Routes
      // Dispatch all HTTP GET events to a newly instanced `HelloHandler` actor for processing.
      // `HelloHandler` will `stop()` itself after processing each request.
      //
      val routes = Routes({
        case GET(request) => {
          actorSystem.actorOf(Props[HelloHandler]) ! request
        }
      })

      //
      // STEP #3 - Start and Stop Socko Web Server
      //
      def main(args: Array[String]) {
        val webServer = new WebServer(WebServerConfig(), routes, actorSystem)
        webServer.start()

        Runtime.getRuntime.addShutdownHook(new Thread {
          override def run { webServer.stop() }
        })

        System.out.println("Open your browser and navigate to http://localhost:8888")
      }
    }

    /**
     * Hello processor writes a greeting and stops.
     */
    class HelloHandler extends Actor {
      def receive = {
        case event: HttpRequestEvent =>
          event.response.write("Hello from Socko (" + new Date().toString + ")")
          context.stop(self)
      }
    }

