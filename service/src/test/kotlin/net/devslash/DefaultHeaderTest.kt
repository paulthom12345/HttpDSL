package net.devslash

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class DefaultHeaderTest {

  @Test
  fun testIfNoHeaderSetThenUserAgentExists() {
    val call = CallBuilder<Any?>("http://example.com").build()

    assertThat(
      call.headers,
      equalTo(
        mapOf<String, List<Any>>(
          "User-Agent" to listOf(
            StrHeaderValue("FetchDSL (Apache-HttpAsyncClient + Kotlin, ${Version.version})")
          )
        )
      )
    )
  }

  @Test
  fun testIfUserAgentSetItIsNotOverwritten() {
    val call = CallBuilder<Any?>("http://example.com").apply {
      headers = mapOf<String, List<Any>>("User-Agent" to listOf("OVERRIDE"))
    }.build()

    assertThat(
      call.headers,
      equalTo(mapOf<String, List<Any>>("User-Agent" to listOf(StrHeaderValue("OVERRIDE"))))
    )
  }
}
