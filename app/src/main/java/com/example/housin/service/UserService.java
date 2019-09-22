package com.example.housin.service;

import com.example.housin.model.ResponseGeral;
import com.example.housin.model.UsuarioResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @GET("usarios/{username}/caracteristicas")
    Observable<UsuarioResponse> getUsuario(@Path("username") String username);


    @POST("usuarios/{username}/caracteristicas")
    Observable<ResponseGeral> postUsuario(@Path("username") String username, @Body RequestBody body);

}
