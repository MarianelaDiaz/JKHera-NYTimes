package NYTimesAPI

data class NYTArticleData(
    val description: String,
    val articleURL: String,
    val sourceLogoURL: String = ""
)