
// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/Work/angular-websocket-sample/play-scala-starter-example/conf/routes
// @DATE:Sun Nov 12 18:08:46 JST 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:16
package controllers.chat {

  // @LINE:16
  class ReverseChatController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def start(roomId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "chat/stream/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("roomId", roomId)))
    }
  
  }


}
