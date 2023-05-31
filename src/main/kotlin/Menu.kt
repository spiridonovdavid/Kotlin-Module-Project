class Menu(val optionsList: MutableList<MenuOption>) {

    init {
        optionsList.add(MenuOption("Выход") { })
    }
    fun addOption(name: String, action: () -> Unit) {
        optionsList.add(MenuOption(name, action))
    }


    fun print() {

        for ((index, option) in optionsList.withIndex()) {
            println("$index. ${option.name}")
        }

    }

    fun handleInput(): Boolean {

        val input = readLine() ?: ""
        val choice = input.toIntOrNull()

        if (choice == null || choice !in 0 until optionsList.size) {
            println("Для выбора пункта меню, введите число от 0 до ${optionsList.size-1}.")

            return false
        }

        optionsList[choice].action()

        return optionsList[choice].name == "Выход"
    }

}