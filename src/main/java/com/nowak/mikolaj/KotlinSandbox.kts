import com.nowak.mikolaj.step_2_datastructures.Person

val person = Person(
    1,
    "Jon",
    "Smith",
    30,
    1000.0,
    emptyList(),
    emptyMap()
)

val person2 = Person(
    1,
    "Jon",
    "Smith",
    30,
    1000.0,
    emptyList(),
    emptyMap()
)

println(
    """Equals ${person == person2}
    |Reference ${person === person2}
    |Copy ${person == person.copy(lastName = "Nowak")}
""".trimMargin()
)

data class CustomPair(
    val key: String,
    val value: String
)

val (key, value) = CustomPair("key", "value")
    .also(::println)

println("$key, $value")