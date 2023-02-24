package tomteland

class Tomteland {

    // Här skapar vi en hierarki av tomtar. Det är en Map där nyckeln är en tomte och värdet är en lista av tomtar som är underordnade.
    val hierarchy = createHierarchy()

    // Här skapar vi en funktion som skapar hierarkin. Vi använder en mutableMap för att kunna lägga till nya värden.
    // Lägger till nycklar och värden i vår map. Nyckeln är en tomte och värdet är en lista av tomtar som är underordnade.
    private fun createHierarchy(): Map<String, List<String>> {
        val map = mutableMapOf<String, List<String>>()
        map["Tomten"] = listOf("Glader", "Butter")
        map["Glader"] = listOf("Tröger", "Trötter", "Blyger")
        map["Butter"] = listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven")
        map["Trötter"] = listOf("Skumtomten")
        map["Skumtomten"] = listOf("Dammråttan")
        map["Räven"] = listOf("Gråsuggan", "Myran")
        map["Myran"] = listOf("Bladlusen")
        return map
    }

    // Här skapar vi en rekursiv funktion som tar en tomte som parameter och returnerar en lista med alla underordnade.
    // MutableList används för att kunna lägga till nya värden.
    // Metoden tar en tomte och en tom lista som parameter. Den tomma listan används för att lägga till alla underordnade.
    // En elvis operator används för att returnera en tom lista om det inte finns några underordnade.
    // Till sist används en forEach loop för att iterera över alla underordnade och för att kalla på funktionen igen för att hitta underordnade till underordnade.
    fun getUnderlings(currentName: String, result: MutableList<String> = mutableListOf()): List<String> {
        val underlings = hierarchy[currentName] ?: emptyList()
        result.addAll(underlings)
        underlings.forEach { underling ->
            getUnderlings(underling, result)
        }
        return result
    }
}

fun main() {

    val tomteland = Tomteland()

    do {
        println("Ange namnet på den tomte vars underordnade du vill söka efter:")
        val input = readLine()?.trim()

        // Kollar om input inte är null och om input finns i tomtehierarkin.
        // Om det är sant så anropas getUnderlings och skriver ut alla underordnade.
        // Om det är falskt så skrivs det ut ett felmeddelande.
        // $input används för att skriva ut värdet av input direkt i strängen istället för att använda + för att bygga ihop strängen.
        if (input != null && tomteland.hierarchy.containsKey(input)) {
            val underlings = tomteland.getUnderlings(input)
            println("Underordnade för $input:")
            underlings.forEach { underling ->
                println(underling)
            }
        } else {
            println("Felaktigt namn, försök igen.")
        }
        println("Vill du söka efter fler tomteunderordnade? (ja/nej)")
    } while (readLine()?.lowercase() == "ja")
}

