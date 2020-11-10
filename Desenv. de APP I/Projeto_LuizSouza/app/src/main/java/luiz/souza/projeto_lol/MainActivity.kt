package luiz.souza.projeto_lol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    lateinit var buttonAatrox: Button
    lateinit var buttonAkali: Button
    lateinit var buttonDiana: Button
    lateinit var buttonMordekaiser: Button
    lateinit var buttonOrianna: Button
    lateinit var buttonYasuo: Button
    lateinit var buttonYone: Button
    lateinit var buttonZed: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonAatrox = findViewById(R.id.aatrox)
        buttonAkali = findViewById(R.id.akali)
        buttonMordekaiser = findViewById(R.id.mordekaiser)
        buttonOrianna = findViewById(R.id.orianna)
        buttonYasuo = findViewById(R.id.yasuo)
        buttonYone = findViewById(R.id.yone)
        buttonDiana = findViewById(R.id.diana)
        buttonZed = findViewById(R.id.zed)

        buttonAatrox.setOnClickListener {
            Snackbar.make(it, "Aatrox", Snackbar.LENGTH_LONG).show()
        }

        buttonAatrox.setOnLongClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Aatrox")
            alert.setMessage(getText(R.string.aatrox_alert))
            alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.aatrox))
            alert.setNeutralButton("OK", null)
            alert.show()
            true
        }

        buttonAkali.setOnClickListener {
            Snackbar.make(it, "Akali", Snackbar.LENGTH_LONG).show()
        }

        buttonAkali.setOnLongClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Akali")
            alert.setMessage(getText(R.string.akali_alert))
            alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.akali))
            alert.setNeutralButton("OK", null)
            alert.show()
            true
        }

        buttonDiana.setOnClickListener {
            Snackbar.make(it, "Diana", Snackbar.LENGTH_LONG).show()
        }

        buttonDiana.setOnLongClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Diana")
            alert.setMessage(getText(R.string.diana_alert))
            alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.diana))
            alert.setNeutralButton("OK", null)
            alert.show()
            true
        }

        buttonMordekaiser.setOnClickListener {
            Snackbar.make(it, "Mordekaiser", Snackbar.LENGTH_LONG).show()
        }

        buttonMordekaiser.setOnLongClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Mordekaiser")
            alert.setMessage(getText(R.string.mordekaiser_alert))
            alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.mordekaiser))
            alert.setNeutralButton("OK", null)
            alert.show()
            true
        }

        buttonOrianna.setOnClickListener {
            Snackbar.make(it, "Orianna", Snackbar.LENGTH_LONG).show()
        }

        buttonOrianna.setOnLongClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Orianna")
            alert.setMessage(getText(R.string.orianna_alert))
            alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.orianna))
            alert.setNeutralButton("OK", null)
            alert.show()
            true
        }

        buttonYasuo.setOnClickListener {
            Snackbar.make(it, "Yasuo", Snackbar.LENGTH_LONG).show()
        }

        buttonYasuo.setOnLongClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Yasuo")
            alert.setMessage(getText(R.string.yasuo_alert))
            alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.yasuo))
            alert.setNeutralButton("OK", null)
            alert.show()
            true
        }

        buttonYone.setOnClickListener {
            Snackbar.make(it, "Yone", Snackbar.LENGTH_LONG).show()
        }

        buttonYone.setOnLongClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Yone")
            alert.setMessage(getText(R.string.yone_alert))
            alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.yone))
            alert.setNeutralButton("OK", null)
            alert.show()
            true
        }

        buttonZed.setOnClickListener {
            Snackbar.make(it, "Zed", Snackbar.LENGTH_LONG).show()
        }
        buttonZed.setOnLongClickListener {
            val alert = AlertDialog.Builder(this@MainActivity)
            alert.setTitle("Zed")
            alert.setMessage(getText(R.string.zed_alert))
            alert.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.zed))
            alert.setNeutralButton("OK", null)
            alert.show()
            true
        }


    }
}