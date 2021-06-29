package NYTimesAPI

interface ArticleData {
    val description: String
    val source: Int
    val articleURL: String
    val isLocallyStored: Boolean
    val sourceLogoURL: String
}

data class NYTArticleData(
    override val description: String,
    override val source: Int = 1,
    override val articleURL: String,
    override val isLocallyStored: Boolean = false,
    override val sourceLogoURL: String = ""
): ArticleData

object EmptyCard: ArticleData {
    override val description: String = ""
    override val source: Int = 1
    override val articleURL: String = ""
    override val isLocallyStored: Boolean = false
    override val sourceLogoURL: String = ""
}