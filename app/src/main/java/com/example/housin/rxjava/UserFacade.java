package com.example.housin.rxjava;

import android.util.Log;

import com.example.housin.dagger.DaggerUserServiceComponent;
import com.example.housin.dagger.UserServiceComponent;
import com.example.housin.model.ResponseGeral;
import com.example.housin.model.UserAPI;
import com.example.housin.service.UserService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class UserFacade {
    private static String postOK = " Usuário adicionado!";
    private static String postErro = "Usuário já existe!";
    boolean status;

    @Inject
    UserService userService;

    public UserFacade() {
        UserServiceComponent userServiceComponent = DaggerUserServiceComponent.builder().build();
        userServiceComponent.inject(this);
    }

    public void bla(String username) {

        /*userService.getUsuario(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultApi -> setting(resultApi.getUsuario()), throwable -> throwable.printStackTrace());*/
    }

    public boolean postUsuario(String username, String sexo, boolean limpo, boolean organizado, String comportamento, boolean responsavel, boolean gostaDeAnimais, boolean fuma, boolean bebe) {
        Log.i("post", sexo);
        String json = convertendoParaJson(sexo, limpo, organizado, comportamento, responsavel, gostaDeAnimais, fuma, bebe);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);

        userService.postUsuario(username, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseGeral -> checandoStatus(responseGeral), throwable -> throwable.printStackTrace());

        return status;

    }

    private void setting(UserAPI.Usuario usuario) {

    }

    private String convertendoParaJson(String sexo, boolean limpo, boolean organizado, String comportamento, boolean responsavel, boolean gostaDeAnimais, boolean fuma, boolean bebe) {
        return String.format("{ \"sexo\": \"%s\", \"limpo\": %b, \"organizado\": %b, \"comportamento\": \"%s\", \"responsavel\": %b, \"gostaAnimais\": %b, \"fuma\": %b, \"bebe\": %b}", sexo, limpo, organizado, comportamento, responsavel, gostaDeAnimais, fuma, bebe);
    }

    private void checandoStatus(ResponseGeral responseGeral) {
        Log.i("response lala", responseGeral.getResult());
        Log.i("status lele", String.valueOf(responseGeral.getStatus() == 200));
        this.status = responseGeral.getStatus() == 200;
    }

    public String formatandoBooleans(boolean value) {
        if (value) {
            return "Yeaaaaaaaaah";
        }
        return "Noooooooooo";
    }

}
