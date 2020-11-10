package luiz.souza.exviacepretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import luiz.souza.exviacepretrofit.model.Zipcode
import luiz.souza.exviacepretrofit.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        progressBar.visibility = View.INVISIBLE

        buttonFindZipcode.setOnClickListener {

            if (editTextZipcode.text.isEmpty()) {
                Toast.makeText(baseContext, "Digite um cep válido!", Toast.LENGTH_LONG).show()
            } else {
                progressBar.visibility = View.VISIBLE

                val zipcode = editTextZipcode.text.toString()
                val call = RetrofitInitializer().zipcodeService().findAddressByZipcode(zipcode)

                call.enqueue(object: Callback<Zipcode>{
                    override fun onFailure(call: Call<Zipcode>, t: Throwable) {
                        progressBar.visibility = View.INVISIBLE
                        Toast.makeText(baseContext, "erro! ${t.toString()}", Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Zipcode>, response: Response<Zipcode>) {
                        progressBar.visibility = View.INVISIBLE
                        Toast.makeText(baseContext, "http status: ${response.code()}", Toast.LENGTH_LONG).show()

                        if (response.isSuccessful){
                            val zipcode = response.body() as Zipcode
                            Toast.makeText(baseContext, "CEP: ${zipcode.toString()}", Toast.LENGTH_LONG).show()
                        }else {
                            Toast.makeText(baseContext, "erro, não foi sucesso!!", Toast.LENGTH_LONG).show()
                        }
                    }

                })


            }

        }


        buttonFindZipcodeByAddress.setOnClickListener {
                progressBar.visibility = View.VISIBLE


                val call = RetrofitInitializer().zipcodeService().findZipcodeByStateDistrictAndAddress("domingos", "RS ", "Porto Alegre")

                call.enqueue(object: Callback<List<Zipcode>>{
                    override fun onFailure(call: Call<List<Zipcode>>, t: Throwable) {
                        progressBar.visibility = View.INVISIBLE
                        Toast.makeText(baseContext, "erro! ${t.toString()}", Toast.LENGTH_LONG).show()

                    }

                    override fun onResponse(call: Call<List<Zipcode>>, response: Response<List<Zipcode>>) {
                        progressBar.visibility = View.INVISIBLE

                        if(response.isSuccessful) {

                            val zipcodes: List<Zipcode>? = response.body()

                            Toast.makeText(baseContext, "${response.code()}", Toast.LENGTH_LONG).show()

                            zipcodes?.let {
                                for (zipcode in zipcodes) {
                                    Toast.makeText(baseContext, "${zipcode.toString()}", Toast.LENGTH_LONG).show()
                                }
                            }
                        } else {
                            Toast.makeText(baseContext, "erro", Toast.LENGTH_LONG).show()
                        }
                    }
                })
        }

    }
}

//http://viacep.com.br/ws/01001000/json/
//viacep.com.br/ws/RS/Porto Alegre/Domingos/json/
