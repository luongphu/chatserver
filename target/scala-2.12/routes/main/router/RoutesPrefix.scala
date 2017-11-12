
// @GENERATOR:play-routes-compiler
// @SOURCE:/Volumes/Work/angular-websocket-sample/play-scala-starter-example/conf/routes
// @DATE:Sun Nov 12 18:08:46 JST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
