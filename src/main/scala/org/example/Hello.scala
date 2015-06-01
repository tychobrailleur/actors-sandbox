package org.example

import akka.actor._

class MyActor extends Actor {
  def receive = {
    case _ => {
      println("Hello!")
      context.system.shutdown()
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
