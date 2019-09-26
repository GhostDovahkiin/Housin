package com.example.housin.rxjava;

import android.content.Context;
import android.widget.Toast;

import com.example.housin.dagger.DaggerUserServiceComponent;
import com.example.housin.dagger.UserServiceComponent;
import com.example.housin.model.ResponseGeral;
import com.example.housin.service.UserService;
import com.example.housin.view.ComunicadorEntreFragments;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class GameFacade {

    @Inject
    UserService userService;
    private Context context;
    private ComunicadorEntreFragments comunicadorEntreFragments;

    public GameFacade(Context context, ComunicadorEntreFragments comunicadorEntreFragments) {
        UserServiceComponent userServiceComponent = DaggerUserServiceComponent.builder().build();
        userServiceComponent.inject(this);
        this.context = context;
        this.comunicadorEntreFragments = comunicadorEntreFragments;
    }

    public void postGostoGamer(String username, boolean rpg, boolean moba, boolean mmorpg, boolean fps, boolean classicos, boolean terror, boolean corrida, boolean esportes) {
        String json = convertendoParaJson(rpg, moba, mmorpg, fps, classicos, terror, corrida, esportes);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);

        userService.postGostoGamer(username, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseGeral -> checandoStatus(responseGeral), throwable -> throwable.printStackTrace());
    }

    private String convertendoParaJson(boolean rpg, boolean moba, boolean mmorpg, boolean fps, boolean classicos, boolean terror, boolean corrida, boolean esportes) {
        return String.format("{ \"rpg\": %b, \"moba\": %b, \"mmorpg\": %b, \"fps\": %b, \"classicos\": %b, \"terror\": %b, \"corrida\": %b, \"esportes\": %b}",
                rpg, moba, mmorpg, fps, classicos, terror, corrida, esportes);
    }

    private void checandoStatus(ResponseGeral responseGeral) {

        if (responseGeral.getStatus() == 200) {
            comunicadorEntreFragments.voltandoParaActivity();
        } else {
            Toast.makeText(context, responseGeral.getResult(), Toast.LENGTH_LONG).show();
        }

    }
}
