package NYTimesAPI

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object NYTimesModule {
    private const val NYT_API_URL = "https://api.nytimes.com/svc/search/v2/"
    private val NYTimesAPIToArticleDataResolver: NYTimesAPIToArticleDataResolver = JsonToArticleDataResolver()

    private fun initNYTimesAPI(): NYTimesAPIController {
        val retrofit = Retrofit.Builder()
            .baseUrl(NYT_API_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        return retrofit.create(NYTimesAPIController::class.java)
    }

    val nyTimesArticleService: NYTimesArticleService = NYTimesArticleServiceImpl(
        initNYTimesAPI(),
        NYTimesAPIToArticleDataResolver
    )
}