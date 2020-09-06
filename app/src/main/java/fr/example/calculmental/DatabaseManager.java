package com.example.prise_rdv;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface Api {



    @GET("api/api_reservation.php?action=recupListeReservation")
    Call<ReservationG> getReservation();


    @FormUrlEncoded
    @POST("api/api_reservation.php")

    Call<String> savePost(@Field("date") String date,
                          @Field("heure") String heure,
                          @Field("id_client") int id_client,
                          @Field("id_employe") int id_employe,
                          @Field("action") String action,
                          @Field("nom")String nom,
                          @Field("prenom") String prenom,
                          @Field("mail")String mail,
                          @Field("mobile")String mobile,
                          @Field("prestation") ArrayList<String> prestation);

    @GET("api/api_clients.php?action=recupListeClient")
    Call<ClientsG> getClient();


    @FormUrlEncoded
    @POST("api/api_clients.php")

    Call<ResponseBody> savePostClient(@Field("nom") String nom,
                                      @Field("prenom") String prenom,
                                      @Field("mail") String mail,
                                      @Field("mobile") String mobile,
                                      @Field("action") String action);


    @GET("api/api_prestation.php?action=recupListePrestation")
    Call<PrestationG> getPrestation();






}
