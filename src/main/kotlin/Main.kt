fun main() {
    val listOfArchives = ListOfArchives()
    val menu = Menu(mutableListOf<MenuOption>())

    println("Добро пожаловать в приложение")
    println("")

    menu.addOption("Добавить архив заметок") { listOfArchives.addArchive() }
    menu.addOption("Показать архивы заметок") { listOfArchives.viewArchives() }
    menu.addOption("Добавить заметку в архив") { listOfArchives.addNoteToArchive() }
    menu.addOption("Показать заметки в архиве") { listOfArchives.viewNotesInArchive() }

    while (true) {
        menu.print()
        val exit = menu.handleInput()
        if (exit) {
            break
        }
    }
}