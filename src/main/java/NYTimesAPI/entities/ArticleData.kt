package NYTimesAPI

interface ArticleData {
    val description: String
    val articleURL: String
    val sourceLogoURL: String
}

data class NYTArticleData(
    override val description: String,
    override val articleURL: String,
    override val sourceLogoURL: String = ""
): ArticleData

object EmptyCard: ArticleData {
    override val description: String = ""
    override val articleURL: String = ""
    override val sourceLogoURL: String = ""
}