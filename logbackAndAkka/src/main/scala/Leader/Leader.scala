package Leader


import akka.actor._
import Util.Logging

object Leader{
  def main(args:Array[String]) {
    val systemName="Akka-Paxos"
    val name = "leader"
    val leader = new Leader(name)
    leader.start(systemName)
  }
}

class Leader(val name:String) extends Logging{

  var leaderActor:ActorRef = _

  def start(systemName:String): Unit ={
    val system = ActorSystem(systemName)
    leaderActor = system.actorOf(Props(new LeaderActor),name = name)
    logInfo("start")

  }

  //leader的消息接口，负责首发消息
  class LeaderActor extends Actor {

    def receive = {
      case msg:String =>

    }
  }


}




