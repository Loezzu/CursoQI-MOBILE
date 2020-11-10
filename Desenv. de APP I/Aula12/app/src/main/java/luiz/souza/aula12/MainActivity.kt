package luiz.souza.aula12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import luiz.souza.aula12.model.Person

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var buttonOK: Button

    private lateinit var buttonScreen1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializer()


    buttonOK.setOnClickListener {
        var name = editTextName.text.toString()
        var age = editTextAge.text.toString().toInt()

        val person = Person(name, age)

        toast("${person.toString()}")
        toast("Numero randomico: ${person.generateRandomicNumber()}")
        toast("a sua idade em meses: ${person.calculateAgeInMonths()}")
    }

        buttonScreen1.setOnClickListener {
            val intent = Intent(this@MainActivity, Screen1::class.java)
            startActivity(intent)
        }

    }
    private fun toast(message: String){
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }

    private fun initializer() {
        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        buttonOK = findViewById(R.id.buttonOK)
        buttonScreen1 = findViewById(R.id.buttonScreen1)

    }

}