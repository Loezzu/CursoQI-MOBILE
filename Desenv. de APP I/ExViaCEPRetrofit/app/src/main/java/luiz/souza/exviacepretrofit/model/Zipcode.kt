package luiz.souza.exviacepretrofit.model

import com.google.gson.annotations.SerializedName

data class Zipcode(

    @SerializedName("bairro")
    val district: String,

    @SerializedName("cep")
    val zipcode: String,

    @SerializedName("complemento")
    val complement: String,

    @SerializedName("ddd")
    val countryCode: String,

//    @SerializedName("gia")
//    val gia: String,

//    @SerializedName("ibge")
//    val ibge: String,

    @SerializedName("localidade")
    val locale: String,

    @SerializedName("logradouro")
    val street: String,

    @SerializedName("uf")
    val state: String

) {

    override fun toString(): String {
        return "Zipcode(district='$district', zipcode='$zipcode', complement='$complement', countryCode='$countryCode', locale='$locale', street='$street', state='$state')"
    }
}