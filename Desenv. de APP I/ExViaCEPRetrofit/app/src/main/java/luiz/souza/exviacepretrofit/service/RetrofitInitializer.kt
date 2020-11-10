package luiz.souza.exviacepretrofit.service

import com.google.gson.GsonBuilder
import luiz.souza.exviacepretrofit.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {


    var gson = GsonBuilder()
        .setDateFormat("yyy-MM-dd'T'HH:mm:ss")
        .create()

    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun zipcodeService() = retrofit.create(ZipcodeService::class.java)


}