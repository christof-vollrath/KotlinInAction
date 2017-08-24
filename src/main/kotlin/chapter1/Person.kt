package chapter1

import kotlinx.html.stream.appendHTML
import kotlinx.html.table
import kotlinx.html.td
import kotlinx.html.tr
import java.io.Writer

data class Person(val name: String, val age: Int? = null)

fun renderPersonList(persons: Collection<Person>, writer: Writer) {
    writer.appendHTML().table {
        for (person in persons) {
            tr {
                td { +person.name }
                td { +(person.age?.toString() ?: "") }
            }
        }
    }
    writer.flush()
}

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", age = 29))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")

    val found = persons.find {it.name == "Alice" }
    println("Found: $found")

    renderPersonList(persons, System.out.writer())
}