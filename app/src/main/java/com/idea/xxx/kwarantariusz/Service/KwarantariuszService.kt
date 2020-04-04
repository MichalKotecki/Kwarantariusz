package com.idea.xxx.kwarantariusz.Service

import com.idea.xxx.kwarantariusz.DTO.LoginDtos.LoginDto
import com.idea.xxx.kwarantariusz.DTO.LoginDtos.RegisterDto
import com.idea.xxx.kwarantariusz.DTO.LoginDtos.UserDTO
import com.idea.xxx.kwarantariusz.DTO.MessageDto
import com.idea.xxx.kwarantariusz.DTO.OfferDtos.AddCommentDto
import com.idea.xxx.kwarantariusz.DTO.OfferDtos.CommentsDto
import com.idea.xxx.kwarantariusz.DTO.OfferDtos.OfferDto
import com.idea.xxx.kwarantariusz.DTO.OfferDtos.OffersDto
import com.idea.xxx.kwarantariusz.DTO.Order.OrdersListFromCityWithGivenIDDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface KwarantariuszApiService {

//    @Headers("Content-Type: application/json")
//    @GET("/admin/test")
//    suspend fun getUser(): UserDTO


    // TODO
    //https://quaranteerserver.000webhostapp.com/orders.php?id_c=172
    @GET("orders.php")
    fun getAllOrderFromCityWithGivenID(@Query(value ="id_c") city_id: Long):Call<OrdersListFromCityWithGivenIDDTO>

    @POST("login/logToApp")
    fun logToApp(@Body loginDto: LoginDto): Call<UserDTO>

    @POST("register/registerAccount")
    fun registerAccount(@Body registerDto: RegisterDto):  Call<MessageDto>

//    @GET("offer/getOfferBySubjectAndLevel")
//    fun getOfferBySubjectAndLevel(@Query(value ="subject")subject: String, @Query(value="level") level : String): Call<OffersDto>
//
//    @POST("offer/addComment")
//    fun addComment(@Body addCommentDto: AddCommentDto)
//
//    @GET("offer/getAllComments")
//    fun getAllComments(@Query (value = "id") ID_offer: Long):Call<CommentsDto>
//
//    @POST("offer/addOffer")
//    fun addOffer(@Body offerDto: OfferDto)


}