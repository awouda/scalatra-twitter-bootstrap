package scalatrademo

import org.scalatra._
import scalate.{ScalateI18nSupport, ScalateSupport}
import com.jtm.routes.JTMBaseServlet

class AdminServlet extends JTMBaseServlet {

  before() {
    contentType = "text/html"
  }

  get("/main") {

    val admin = "alex"
    val lots = List(Lot(12, "mooi kavel", 12.23), Lot(23, "cd collectie", 34.88))
    scaml("/admin/index", ("admin", admin), ("lots", lots))

  }

  post("/post") {

    val posted = params("submission")

    scaml("/admin/posted", ("posted", posted))

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

