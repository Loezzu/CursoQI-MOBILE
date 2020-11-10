package luiz.souza.exviacepretrofit.service

import luiz.souza.exviacepretrofit.model.Zipcode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ZipcodeService {

    //http://viacep.com.br/ws/01001000/json/

    @GET("{zipcode}/json/")
    fun findAddressByZipcode(@Path("zipcode") zipcode: String) : Call<Zipcode>


    //http://viacep.com.br/ws/RS/Porto Alegre/Domingos/json/

    @GET("{state}/{city}/{address}/json/")
    fun findZipcodeByStateDistrictAndAddress(
        @Path("address") address: String,
        @Path("state") state: String,
        @Path("city") city: String) : Call<List<Zipcode>>



}