package NYTimesAPI

interface ArticleData {
    val artistName: String
    val description: String
    val source: Int
    val articleURL: String
    val isLocallyStored: Boolean
    val sourceLogoURL: String
}

data class NYTArticleData(
    override val artistName: String = "",
    override val description: String,
    override val source: Int = 1,
    override val articleURL: String,
    override val isLocallyStored: Boolean = false,
    override val sourceLogoURL: String = ""
): ArticleData

object EmptyCard: ArticleData {
    override val artistName: String = ""
    override val description: String = ""
    override val source: Int = 1
    override val articleURL: String = ""
    override val isLocallyStored: Boolean = false
    override val sourceLogoURL: String = ""
}