package com.example.housin.rxjava;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.housin.dagger.DaggerUserServiceComponent;
import com.example.housin.dagger.UserServiceComponent;
import com.example.housin.model.ResponseGeral;
import com.example.housin.service.UserService;
import com.example.housin.view.ComunicadorEntreFragments;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class UserFacade {
    private Fragment fragment;
    private Context context;
    private ComunicadorEntreFragments comunicadorEntreFragments;

    @Inject
    UserService userService;

    public UserFacade(Fragment fragment, Context context) {
        UserServiceComponent userServiceComponent = DaggerUserServiceComponent.builder().build();
        userServiceComponent.inject(this);
        this.fragment = fragment;
        this.context = context;

    }

    public void bla(String username) {

        /*userService.getUsuario(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultApi -> setting(resultApi.getUsuario()), throwable -> throwable.printStackTrace());*/
    }

    public void postUsuario(String username, String sexo, boolean limpo, boolean organizado, String comportamento, boolean responsavel, boolean gostaDeAnimais, boolean fuma, boolean bebe) {
        Log.i("post", sexo);
        String json = convertendoParaJson(sexo, limpo, organizado, comportamento, responsavel, gostaDeAnimais, fuma, bebe);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);

        userService.postUsuario(username, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseGeral -> checandoStatus(responseGeral), throwable -> throwable.printStackTrace());

    }

    private String convertendoParaJson(String sexo, boolean limpo, boolean organizado, String comportamento, boolean responsavel, boolean gostaDeAnimais, boolean fuma, boolean bebe) {
        return String.format("{ \"sexo\": \"%s\", \"limpo\": %b, \"organizado\": %b, \"comportamento\": \"%s\", \"responsavel\": %b, \"gostaAnimais\": %b, \"fuma\": %b, \"bebe\": %b}", sexo, limpo, organizado, comportamento, responsavel, gostaDeAnimais, fuma, bebe);
    }

    private void checandoStatus(ResponseGeral responseGeral) {

        if(responseGeral.getStatus() == 200) {
            comunicadorEntreFragments.passandoFragments(fragment);
        } else {
            Toast.makeText(context, responseGeral.getResult(), Toast.LENGTH_LONG).show();
        }
    }


}
