package NYTimesAPI

import com.google.gson.Gson
import com.google.gson.JsonObject

interface NYTimesAPIToArticleDataResolver {
    fun getArticleFromExternalData(serviceData: String?): CardImpl?
}

internal class JsonToArticleDataResolver: NYTimesAPIToArticleDataResolver {
    override fun getArticleFromExternalData(serviceData: String?): CardImpl? =
        try {
            serviceData?.getResponse()?.let { item ->
                CardImpl(
                    description = item.getInfo(),
                    articleURL = item.getArticleURL()
                )
            }
        } catch (e: Exception) {
            null
        }

    private fun String?.getResponse(): JsonObject {
        val jsonObject = Gson().fromJson(this, JsonObject::class.java)
        val response = jsonObject["response"].asJsonObject
        return response
    }
}

private fun JsonObject.getArticleURL(): String {
    var url = this["docs"].asJsonArray[0].asJsonObject["web_url"].toString()
    url = url.substring(1, url.length - 1)
    return url
}

private fun JsonObject.getInfo(): String {
    return this["docs"].asJsonArray[0].asJsonObject["abstract"].toString()
}