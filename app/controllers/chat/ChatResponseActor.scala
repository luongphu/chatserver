package controllers.chat

import java.util.Calendar
import java.util.Date;
import java.text.SimpleDateFormat;

import akka.actor.{ Actor, ActorRef, PoisonPill, Props }
import domains.chat.{ Chat, Join, Leave, Talk }
import play.api.libs.json.Json

/**
 * Convert output Message to WebSocket output String.
 */
class ChatResponseActor(out: ActorRef, me: String) extends Actor {

  import ChatMessageConverters._

  /**
   * If you want to serialize to json, define json converter here.
   */
  override def receive: Receive = {
    case Talk(u, t, s, a) =>
      out ! Json.toJson(Chat(u, t, s, a))
    case Join(u) => {
      var now = Calendar.getInstance().getTime()
      var timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      var currentTime = timeFormat.format(now)
      out ! Json.toJson(Chat(u, "joined.", currentTime, "joined"))
    }
    case Leave(userId) => {
      var now = Calendar.getInstance().getTime()
      var timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      var currentTime = timeFormat.format(now)
      out ! Json.toJson(Chat(userId, "left.", currentTime, "left"))
      if (userId == me) {
        out ! PoisonPill
        self ! PoisonPill
      }
    }
  }

  override def postStop(): Unit = super.postStop()

}

object ChatResponseActor {
  def props(out: ActorRef, me: String): Props = Props(new ChatResponseActor(out, me))
}
