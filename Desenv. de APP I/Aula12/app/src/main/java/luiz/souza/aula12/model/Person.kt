package luiz.souza.aula12.model

class Person(var name: String, var age: Int) {


     fun calculateAgeInMonths() : Int {
        return this.age * 12
    }

    fun generateRandomicNumber() : Int {
        return (0..100).random()
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
}