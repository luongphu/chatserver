
// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/Work/angular-websocket-sample/play-scala-starter-example/conf/routes
// @DATE:Sun Nov 12 18:08:46 JST 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:16
package controllers.chat.javascript {

  // @LINE:16
  class ReverseChatController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def start: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.chat.ChatController.start",
      """
        function(roomId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chat/stream/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("roomId", roomId0))})
        }
      """
    )
  
  }


}
