class NotesList(val name: String) {
    private val notes = mutableListOf<String>()

    fun addNote() {
        println("Введите текст заметки:")
        val note = readLine() ?: ""

        notes.add(note)

        println("Заметка успешно добавлена в архив \"$name\"")
    }

    fun viewNotes() {

        if (notes.isEmpty()) {
            println("Список заметок пуст")
        } else {
            println("Список заметок в архиве \"$name\":")
            for (note in notes) {
                println(note)
            }
        }

    }


}