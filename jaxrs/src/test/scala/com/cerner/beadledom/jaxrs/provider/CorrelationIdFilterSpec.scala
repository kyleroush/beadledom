package com.cerner.beadledom.jaxrs.provider

import org.scalatest._
import org.scalatest.mock.MockitoSugar
import org.slf4j.MDC

class CorrelationIdFilterSpec extends FunSpec with BeforeAndAfter with ShouldMatchers
with MockitoSugar with CorrelationIdFilterBehaviors {
  val defaultHeaderName = "Correlation-Id"
  val defaultMdcName = "Correlation-Id"

  after {
    MDC.clear()
  }

  val defaultFilter = new CorrelationIdFilter()
  val customFilter = new CorrelationIdFilter("customHeader", "customMdc")
  describe("CorrelationIdFilter") {
    describe("with default id names") {
      it should behave like correlationIdFilter(defaultFilter, defaultHeaderName, defaultMdcName)
    }

    describe("with custom id names") {
      it should behave like correlationIdFilter(customFilter, "customHeader", "customMdc")
    }
  }
}
