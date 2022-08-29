import Activity.Api
import java.net.URL

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiProvider {

    val BASE_URL = "http://10.156.147.161:8080"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

}