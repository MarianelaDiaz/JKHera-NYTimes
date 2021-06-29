package NYTimesAPI

import NYTimesAPI.exceptions.APIException
import com.google.gson.Gson
import com.google.gson.JsonObject

interface NYTimesAPIToArticleDataResolver {
    fun getArticleFromExternalData(serviceData: String?): NYTArticleData?
}

internal class JsonToArticleDataResolver: NYTimesAPIToArticleDataResolver {
    override fun getArticleFromExternalData(serviceData: String?): NYTArticleData? =
        try {
            serviceData?.getResponse()?.let { item ->
                NYTArticleData(
                    description = item.getInfo(),
                    articleURL = item.getArticleURL(),
                    sourceLogoURL = API_SOURCE_URL
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


    companion object {
        const val API_SOURCE_URL =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVioI832nuYIXqzySD8cOXRZEcdlAj3KfxA62UEC4FhrHVe0f7oZXp3_mSFG7nIcUKhg&usqp=CAU"
    }
}

private fun JsonObject.getArticleURL(): String {
    this.checkDocs()
    var url = this["docs"].asJsonArray[0].asJsonObject["web_url"].toString()
    url = url.substring(1, url.length - 1)
    return url
}

private fun JsonObject.getInfo(): String {
    this.checkDocs()
    return this["docs"].asJsonArray[0].asJsonObject["abstract"].toString()
}

private fun JsonObject.checkDocs() {
    if (this["docs"].asJsonArray.size() <= 0 ||
        this["docs"].asJsonArray[0].asJsonObject["web_url"] == null ||
        this["docs"].asJsonArray[0].asJsonObject["abstract"] == null
    ) {
        throw APIException("Error de API")
    }


}