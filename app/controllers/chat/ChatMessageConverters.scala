package controllers.chat

import domains.chat.Chat
import play.api.libs.functional.syntax._
import play.api.libs.json._

object ChatMessageConverters {

  implicit val ChatMessageReads: Reads[Chat] = (
          (JsPath \ "userId").read[String] and
          (JsPath \ "text").read[String] and
          (JsPath \ "createAt").read[String] and
          (JsPath \ "action").read[String]
      ) (Chat)

  implicit val ChatMessageWrites: Writes[Chat] = (
          (JsPath \ "userId").write[String] and
          (JsPath \ "text").write[String] and
          (JsPath \ "createAt").write[String] and
          (JsPath \ "action").write[String]
      ) (unlift(Chat.unapply))

}
