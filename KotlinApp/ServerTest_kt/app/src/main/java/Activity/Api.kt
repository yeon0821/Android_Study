package Activity

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("users/signup")
    fun signup(
        @Body request : Request
    ) : Call<Void>
}