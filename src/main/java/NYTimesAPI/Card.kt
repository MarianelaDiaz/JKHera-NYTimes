package NYTimesAPI

//TODO: Eliminar artistName y isLocallyStored
interface Card {
    val artistName: String
    val description: String
    val source: Int
    val articleURL: String
    val isLocallyStored: Boolean
    val sourceLogoURL: String
}

data class CardImpl(
    override val artistName: String = "",
    override val description: String,
    override val source: Int = 1,
    override val articleURL: String,
    override val isLocallyStored: Boolean = false,
    override val sourceLogoURL: String = ""
): Card

object EmptyCard: Card {
    override val artistName: String = ""
    override val description: String = ""
    override val source: Int = 1
    override val articleURL: String = ""
    override val isLocallyStored: Boolean = false
    override val sourceLogoURL: String = ""
}