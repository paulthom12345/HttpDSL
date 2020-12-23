package net.devslash

import org.junit.Assert.assertEquals
import org.junit.Test

internal class UrlProvidersTest {
  @Test
  fun testBasicProvider() {
    val url = "http://example.com"
    val provider = getUrlProvider(
        getCall(url = url), requestDataFromList(listOf())
    )
    assertEquals(url, provider.get())
  }

  @Test
  fun testReplacement() {
    val provider = getUrlProvider(
        getCall(url = "http://!1!"),
        requestDataFromList(listOf("example.com"))
    )
    assertEquals("http://example.com", provider.get())
  }
}