package controllers.chat

import akka.actor.{ Actor, ActorRef, PoisonPill, Props }
import domains.chat.{ Chat, Join, Leave, Talk }
import play.api.libs.json.JsValue

/**
 * Convert input String to chat Message object.
 */
class ChatRequestActor(out: ActorRef, userId: String) extends Actor {

  import ChatMessageConverters._

  override def receive: Receive = {
    case msg: JsValue =>
      val chat = msg.as[Chat]
      out ! Talk(chat.userId, chat.text, chat.createAt, chat.action)
  }

  override def preStart(): Unit = out ! Join(userId)

  override def postStop(): Unit = {
    out ! Leave(userId)
    out ! PoisonPill
  }
}

object ChatRequestActor {
  def props(out: ActorRef, userId: String): Props = Props(new ChatRequestActor(out, userId))
}
