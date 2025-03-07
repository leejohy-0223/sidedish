package com.example.sidedish.network

import com.example.sidedish.data.OrderMenu
import com.example.sidedish.data.dto.Item
import com.example.sidedish.data.dto.JwtDTO
import com.example.sidedish.data.dto.MenuDetailDTO
import retrofit2.Response
import retrofit2.http.*

interface ApiClient {

    @GET("/items/{categoryId}")
    suspend fun getMenuList(
        @Header("Authorization") token: String,
        @Path("categoryId") category: Int
    ):Response<Item>

    @GET("/items/detail/{id}")
    suspend fun getProductDetail(
        @Header("Authorization") token: String,
        @Path("id") detailHash: Int
    ): Response<MenuDetailDTO>

    @GET("/login/oauth")
    suspend fun getJWT(
        @Query("code") code: String
    ): Response<JwtDTO>

    @POST("/order")
    suspend fun orderMenu(
        @Header("Authorization") token: String,
        @Body body: OrderMenu
    ): Response<Unit>
}
