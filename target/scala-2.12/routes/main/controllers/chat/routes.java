
// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/Work/angular-websocket-sample/play-scala-starter-example/conf/routes
// @DATE:Sun Nov 12 18:08:46 JST 2017

package controllers.chat;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.chat.ReverseChatController ChatController = new controllers.chat.ReverseChatController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.chat.javascript.ReverseChatController ChatController = new controllers.chat.javascript.ReverseChatController(RoutesPrefix.byNamePrefix());
  }

}
