package com.jtm.routes

import org.scalatra.{CookieSupport, ScalatraServlet}
import org.scalatra.scalate.{ScalateI18nSupport, ScalateSupport}


trait JTMBaseServlet extends ScalatraServlet with ScalateSupport with ScalateI18nSupport with CookieSupport
