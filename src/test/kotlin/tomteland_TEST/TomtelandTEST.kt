package tomteland_TEST
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import tomteland.Tomteland

class TomtelandTEST {


    private val tl = Tomteland()

    private val uTomten = listOf(
        "Glader", "Butter", "Tröger", "Trötter", "Blyger", "Skumtomten",
        "Dammråttan", "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen"
    )

    private val uGlader = listOf("Tröger", "Trötter", "Blyger", "Skumtomten", "Dammråttan")
    private val uButter = listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen")
    private val uTrötter = listOf("Skumtomten", "Dammråttan")
    private val uSkumtomten = listOf("Dammråttan")
    private val uRäven = listOf("Gråsuggan", "Myran", "Bladlusen")
    private val uMyran = listOf("Bladlusen")

    @Test
    fun `getUnderlings returns correct underlings for Myran`() {
        val list = mutableListOf<String>()
        val underlings = tl.getUnderlings("Myran", list)
        assertEquals(uMyran, underlings)
    }

    @Test
    fun `getUnderlings returns correct underlings for Räven`() {
        val list = mutableListOf<String>()
        val underlings = tl.getUnderlings("Räven", list)
        assertEquals(uRäven, underlings)
    }

    @Test
    fun `getUnderlings returns correct underlings for Skumtomten`() {
        val list = mutableListOf<String>()
        val underlings = tl.getUnderlings("Skumtomten", list)
        assertEquals(uSkumtomten, underlings)
    }

    @Test
    fun `getUnderlings returns correct underlings for Trötter`() {
        val list = mutableListOf<String>()
        val underlings = tl.getUnderlings("Trötter", list)
        assertEquals(uTrötter, underlings)
    }

    @Test
    fun `getUnderlings returns correct underlings for Butter`() {
        val list = mutableListOf<String>()
        val underlings = tl.getUnderlings("Butter", list)
        assertEquals(uButter, underlings)
    }

    @Test
    fun `getUnderlings returns correct underlings for Glader`() {
        val list = mutableListOf<String>()
        val underlings = tl.getUnderlings("Glader", list)
        assertEquals(uGlader, underlings)
    }

    @Test
    fun `getUnderlings returns correct underlings for Tomten`() {
        val list = mutableListOf<String>()
        val underlings = tl.getUnderlings("Tomten", list)
        assertEquals(uTomten, underlings)
    }
}