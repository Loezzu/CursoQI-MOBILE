package luiz.souza.aula11

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var editname: EditText
    private lateinit var editname2: EditText
    private lateinit var textViewResposta: TextView
    private lateinit var editbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializer()

            editbutton.setOnClickListener {

            if (editname.text.toString().isEmpty() || editname2.text.toString().isEmpty()) {
                snack("Digite um nome válido")
                return@setOnClickListener
            }else {
                generateRandomNumber()
            }

            }
    }

    private fun generateRandomNumber() {
        var name: String = editname.text.toString()
        var name2: String = editname2.text.toString()

        vibrate()
        clearFields()
        var randomNumber = (0..100).shuffled().first()
        snack("Seu Nome: $name\nNome do Jogador (a): $name2")
        textViewResposta.text = "$name, Você é $randomNumber % parecido com o(a) $name2"

        if (randomNumber >=0 && randomNumber <30 ) {
            textView2.text = "Vishhh... não se parece nem um pouco"

        } else if (randomNumber >=30 && randomNumber <60) {
            textView2.text = "Até que se parece um pouco"

        } else if (randomNumber >=60 && randomNumber <90) {
            textView2.text = "Nossa, Parece bastante ein"

        } else if (randomNumber >=90 && randomNumber <=100) {
            textView2.text = "OMG !!! GEMEOS"
        }else {
            textView2.text = "error"
        }

    }

    private fun vibrate() {

        val pattern = longArrayOf(0, 200, 100, 300)

        val hardware = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            hardware.vibrate(VibrationEffect.createWaveform(pattern, -1))
        } else {
            hardware.vibrate(pattern, -1)

        }

    }

    private fun snack(message: String){
        val view = findViewById<View>(R.id.layout)
        Snackbar.make(view, message , Snackbar.LENGTH_LONG).show()
    }

    private fun clearFields() {
        editname.text = null
        editname2.text = null
    }

    private fun initializer() {
        editname = findViewById(R.id.name1)
        editname2 = findViewById(R.id.name2)
        textViewResposta = findViewById(R.id.textViewResposta)
        editbutton = findViewById(R.id.button1)
    }

}