package br.com.ppi.flutter.listbook.mycontacts

// Para testar um exemplo específico, descomente sua função main()
// e comente as outras funções main().
// Lembre-se também de descomentar quaisquer funções auxiliares que o exemplo principal utiliza.
// --- 🔹 Slide 6 a 10 – Função main() ---
/*
fun main() {
    val isUnit = println("Nosso primeiro exemplo usando a função main()")
    println(isUnit)
}
*/
// --- 🔹 Slide 12 – Expressões em Kotlin ---
/*
fun main() {
    val contacts = listOf("Joãozinho", "Paulinho", "Mariazinha")

    val status = if(contacts.isEmpty()) {
        "Agenda vazia ${contacts}"
    } else {
        "Você tem ${contacts.size} contatos"
    }

    println(status)
}
*/
// --- 🔹 Slide 12 (Iterando nomes da lista) ---
/*
fun main() {
    val contacts = listOf("Joãozinho", "Paulinho", "Mariazinha")

    if (contacts.isEmpty()) {
        println("Agenda vazia: $contacts")
    } else {
        println("Você tem ${contacts.size} contatos:")
        contacts.forEach { contact ->
            println("- $contact")
        }
    }
}
*/
// --- 🔹 Slide 14 – Retorno `Unit` ---
/*
fun main() {
    val isUnit = println() // println() sem argumentos imprime uma nova linha
    println(isUnit)
}
*/
// --- 🔹 Slide 17 – Parâmetros padrão ---
/*
fun main() {
    val contactsList = listOf("Joãozinho", "Paulinho", "Mariazinha")
    showContactsWithDefaults(contacts = contactsList)
    showContactsWithDefaults() // Chamando com todos os padrões
    showContactsWithDefaults(title = "Agenda Especial") // Mudando apenas o título
}

private fun showContactsWithDefaults(contacts: List<String> = emptyList(), title: String = "Minha Agenda") {
    println("=== $title ===")

    if(contacts.isEmpty()) {
        println("Nenhum contato encontrado.")
    } else {
        println("Você tem ${contacts.size} contatos:")
        for (contact in contacts) {
            println("- $contact")
        }
    }
}
*/
// --- 🔹 Slide 18 – Parâmetros obrigatórios ---
/*
fun main() {
    val contactList = listOf("Joãozinho", "Paulinho", "Mariazinha", "Chiquinha")
    showRequiredContacts(contactList, "Contatos pessoais")
}

fun showRequiredContacts(contacts: List<String>, title: String) {
    println("=== $title ===")

    if(contacts.isEmpty()) {
        println("Nenhum contato encontrado.")
    } else {
        println("Você tem ${contacts.size} contatos:")
        for (contact in contacts) {
            println("- $contact")
        }
    }
}
*/
// --- 🔹 Slide 19 – Obrigatórios + Opcionais ---
/*
fun main() {
    val contatos = listOf("Joãozinho", "Mariazinha", "Paulin", "Pedrão")
    showFilteredContacts(contatos, 'M')
    showFilteredContacts(contatos) // Sem filtro
}

fun showFilteredContacts(
    contacts: List<String>,
    filter: Char? = null // filter é opcional
) {
    val filtered = filter?.let { charToFilter -> // Renomeado 'word' para 'charToFilter' para clareza
        contacts.filter { it.startsWith(charToFilter, ignoreCase = true) }
    } ?: contacts

    if (filtered.isEmpty()) {
        println("Nenhum contato encontrado.")
    } else {
        println("Contatos encontrados:")
        filtered.forEach { println("- $it") }
    }
}
*/
// --- 🔹 Slide 20 – Argumentos nomeados ---
/*
fun main() {
    val contatos = listOf("Joãozin", "Mariazinha", "Juninho", "Kikinho")

    showContactsWithNamedParameters(
        showCount = false,
        contacts = contatos,
        title = "Contatos Sem Contagem"
    )

    showContactsWithNamedParameters(contacts = contatos) // Usando padrões para title e showCount
}

fun showContactsWithNamedParameters(
    contacts: List<String>,
    title: String = "Minha Agenda",
    showCount: Boolean = true
) {
    println("=== $title ===")

    if (showCount) {
        println("Você tem ${contacts.size} contatos.")
    }

    if (contacts.isEmpty()) {
        println("Lista vazia.")
    } else {
        // Corrigido para iterar sobre os contatos, não apenas imprimir o índice
        for ((index, contato) in contacts.withIndex()) {
            println("${index + 1} - $contato")
        }
    }
}
*/
// --- 🔹 Slide 22 – Funções de expressão única ---
/*
fun main() {
    println(compactReturn(5))
    println(defaultReturn(5))
}

fun defaultReturn(x: Int) : Int {
    return x * 2
}

fun compactReturn(x: Int): Int = x * 2
*/
// --- 🔹 Slide 24 – Lambdas ---
/*
fun main() {
    val contacts = listOf("Fabin", "Felipin", "Carlão")
    val showUpperCase = { name : String -> name.uppercase() } // Lambda

    for (contact in contacts) {
        println(showUpperCase(contact))
    }
}
*/
// --- 🔹 Slide 25 – Funções de ordem superior ---
/*
fun main() {
    val contacts = listOf("fabin", "felipin", "carlão")
    val toUpperCaseLambda = { name: String -> name.uppercase() }
    val toCamelCaseLambda = { name: String -> name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() } } // Melhoria para CamelCase

    println(processContact(contacts[0], toUpperCaseLambda))
    println(processContact(contacts[0], toCamelCaseLambda))
}

fun processContact(name: String, callback: (String) -> String): String {
    return callback(name)
}
*/
// --- 🔹 Slide 27 – Referência de Função ---
/*
fun main() {
    val contacts = listOf("Fabin", "Felipin", "Carlão")

    // A função processContacts agora está dentro da main, precisa ser movida para fora ou main não pode ser top-level
    // Vamos movê-la para fora para ser reutilizável
    // processContactsUsingReference(contacts, ::toUpperCaseDefined)
    // processContactsUsingReference(contacts, ::toCamelCaseDefined)

    // Para executar este, descomente as funções abaixo e a chamada acima
    // E comente/renomeie outras 'main'
     println(processContactsUsingReference(contacts, ::toUpperCaseDefined))
     println(processContactsUsingReference(contacts, ::toCamelCaseDefined))
}

// Funções auxiliares para o Slide 27
fun toUpperCaseDefined(name: String): String = name.uppercase()
fun toCamelCaseDefined(name: String): String = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() } // Melhoria

fun processContactsUsingReference(list: List<String>, callback: (String) -> String): List<String> {
    return list.map { callback(it) }
}
*/
// --- 🔹 Slide 29 a 31 – Filtros ---
/*
fun main() {
    val contacts = listOf("Ana", "Bruno", "Carlos", "Beatriz", "Amanda", "Caio")

    println("Contatos que começam com A:")
    println(filterContactsGeneric(contacts) { it.startsWith("A") })

    println("\nContatos com mais de 5 letras:")
    println(filterContactsGeneric(contacts) { it.length > 5 })

    println("\nContatos que terminam com 'o':")
    println(filterContactsGeneric(contacts) { it.endsWith("o") })
}

fun filterContactsGeneric(list: List<String>, condition: (String) -> Boolean): List<String> {
    return list.filter(condition)
}
*/
// --- 🔹 Slide 32 e 33 – Filtros Lazy ---
/*
fun main() {
    val contacts = listOf("Ana", "Bruno", "Carlos")

    val lazyFiltered = contacts.asSequence().filter {
        println("Filtrando: $it") // Para ver quando o filtro é aplicado
        it.startsWith("A")
    }

    println("Sequência criada, mas o filtro ainda não executou completamente.")
    // O filtro só é executado quando uma operação terminal é chamada, como toList() ou forEach.
    println("Resultado: ${lazyFiltered.toList()}") // Agora o filtro executa

    println("\nIterando sobre a sequência preguiçosa:")
    lazyFiltered.forEach { println("Item encontrado: $it") } // O filtro executa novamente
}
*/
// --- 🔹 Slide 35 – Map ---
/*
fun main() {
    val contacts = listOf("ana", "bruno", "carlos")

    val upperCaseContacts = contacts.map { it.uppercase() }
    println("Lista transformada: $upperCaseContacts")
}
*/
// --- 🔹 Slide 36 – Flatten ---
fun main() { // Exemplo para o Slide 36 - Descomentado para teste inicial
    val contactsGroups = listOf(
        listOf("Ana", "Bruno"),
        listOf("Carlos", "Diana"),
        listOf("Eduardo")
    )

    val allContacts = contactsGroups.flatten()
    println("Lista 'achatada': $allContacts")
}