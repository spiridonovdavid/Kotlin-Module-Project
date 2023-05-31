class ListOfArchives {
    private val archivesList = mutableListOf<NotesList>()

    fun addArchive() {

        println("Введите название для создания архива:")

        val name = readLine() ?: ""
        val archive = NotesList(name)

        archivesList.add(archive)

        println("Архив \"$name\" добавлен в список.")

    }

    fun viewArchives() {
        if (archivesList.isEmpty()) {
            println("Архивы не найдены")
        } else {
            println("Список архивов:")

            for (archive in archivesList) {
                println(archive.name)
            }
            println("**************************")
        }
    }

    fun viewNotesInArchive() {
        if (archivesList.isEmpty()) {
            println("Архивы не найдены")
            return
        }
        println("Выберите архив:")
        val archiveMenu = Menu(mutableListOf<MenuOption>())
        for (archive in archivesList) {
            archiveMenu.addOption(archive.name) { archive.viewNotes() }
        }

        while (true) {
            archiveMenu.print()
            val exit = archiveMenu.handleInput()
            if (exit) {
                return
            } else {
                println("Выход")
            }
        }
    }

    fun addNoteToArchive() {
        if (archivesList.isEmpty()) {
            println("Архивы не найдены")
            return
        }
        println("Выберите архив:")

        val archiveMenu = Menu(mutableListOf<MenuOption>())
        for ((index, archive) in archivesList.withIndex()) {
            val archiveName = "${index + 1}. ${archive.name}"
            archiveMenu.addOption(archiveName.removePrefix("${index + 1}. ")) { addNoteToArchive(archivesList[index]) }
        }

        archiveMenu.print()


        var exit = false
        while (!exit) {

            val choice = readLine()?.toIntOrNull()
            exit = choice == null || choice !in 1..archivesList.size

            if (!exit) {
                val selectedIndex = choice!!
                archiveMenu.optionsList[selectedIndex].action()
            }
        }
    }

    private fun addNoteToArchive(archive: NotesList) {
        archive.addNote()
    }

}