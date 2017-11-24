package domains.chat

sealed trait ChatMessage

case class Join(userId: String) extends ChatMessage

case class Leave(userId: String) extends ChatMessage

case class Talk(userId: String, text: String, createAt: String, action: String) extends ChatMessage



