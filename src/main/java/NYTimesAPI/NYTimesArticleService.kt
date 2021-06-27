package NYTimesAPI

import retrofit2.Response

interface NYTimesArticleService {
    fun getArticle(artist: String): NYTArticleData?
}

internal class NYTimesArticleServiceImpl(
    private val nyTimesApi: NYTimesAPIController,
    private val nyTimesApiToArticleDataResolver: NYTimesAPIToArticleDataResolver
): NYTimesArticleService {

    override fun getArticle(artist: String): NYTArticleData? {
        val callResponse = getArticleFromService(artist)
        return nyTimesApiToArticleDataResolver.getArticleFromExternalData(callResponse.body())
    }

    private fun getArticleFromService(artist: String): Response<String> {
        return nyTimesApi.getArtistInfo(artist).execute()
    }
}