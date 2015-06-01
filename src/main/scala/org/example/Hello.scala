package org.example

import akka.actor._
import scala.language.postfixOps
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global


class MyOtherActor extends Actor {
  def receive = {
    case _ =>  {
      println("Hello again!")
      context.system.shutdown()
    }
  }
}

object MyOtherActor {
  trait Operation
  case object Hello extends Operation
}

class MyActor extends Actor {
  def receive = {
    case _ => {
      println("Hello!")

      val myOtherActor = context.actorOf(Props[MyOtherActor], "otherCreator")
      context.system.scheduler.schedule(1 second, 1 second, myOtherActor, Hello)
    }
  }
}

object MyActor {
  trait Operation
  case object Hello extends Operation
}

object Hello extends App {
  val system = ActorSystem("GreeterSystem")
  val hello = system.actorOf(Props[MyActor], "greeter")
  hello ! Hello
}
