package com.cerner.beadledom.client.resteasy

import com.cerner.beadledom.client.BeadledomClientBuilder
import org.scalatest.{BeforeAndAfter, FunSpec, ShouldMatchers}

import scala.language.postfixOps

/**
  * @author John Leacox
  */
class BeadledomResteasyClientBuilderSpec extends FunSpec with ShouldMatchers with BeforeAndAfter {
  describe("BeadledomResteasyClientBuilder") {
    describe("ServiceLoader") {
      it("loads the resteasy builder implementation") {
        val builder = BeadledomResteasyClientBuilder.newBuilder()

        builder shouldBe a[BeadledomResteasyClientBuilder]
      }
    }

    describe("Client Configuration") {

      it("Default values") {
        val builder = BeadledomResteasyClientBuilder.newBuilder()
            .getBeadledomClientConfiguration

        builder.connectionPoolSize() should be(200)
        builder.maxPooledPerRouteSize() should be(100)
        builder.socketTimeoutMillis() should be(10000)
        builder.connectionTimeoutMillis() should be(10000)
        builder.ttlMillis() should be(1800000)
      }
    }
  }
}
