package com.example.housin.service;

import com.example.housin.model.ResponseGeral;
import com.example.housin.model.UserAPI;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @GET("usarios/{username}/caracteristicas")
    Observable<UserAPI> getUsuario(@Path("username") String username);

    @POST("usuarios/{username}/caracteristicas")
    Observable<ResponseGeral> postUsuario(@Path("username") String username, @Field("sexo") String sexo, @Field("limpo") boolean limpo, @Field("organizado") boolean organizado, @Field("comportamento") String comportamento, @Field("responsavel") boolean responsavel, @Field("gostaAnimais") boolean gostaAnimais, @Field("fuma") boolean fuma, @Field("bebe") boolean bebe);
}
