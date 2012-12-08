package scalatrademo

import org.scalatra._
import scalate.ScalateSupport

class JTMServlet extends ScalatraServlet with ScalateSupport {


  before() {
    contentType = "text/html"
  }





  get("/") {

    scaml("hello-scalate")
  }

  notFound {
    // remove content type in case it was set through an action
    contentType = null
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map {
      path =>
        contentType = "text/html"
        layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
}


case class Lot(id: Int, name: String, price: Double)