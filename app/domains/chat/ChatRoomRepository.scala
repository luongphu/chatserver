package domains.chat

trait ChatRoomRepository {

  def chatRoom(roomId: String, userId: String): ChatRoom

}
