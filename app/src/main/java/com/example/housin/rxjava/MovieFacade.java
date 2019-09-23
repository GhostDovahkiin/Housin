package com.example.housin.rxjava;

import android.content.Context;
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

public class MovieFacade {
    @Inject
    UserService userService;
    private Fragment fragment;
    private Context context;
    private ComunicadorEntreFragments comunicadorEntreFragments;

    public MovieFacade(Fragment fragment, Context context, ComunicadorEntreFragments comunicadorEntreFragments) {
        UserServiceComponent userServiceComponent = DaggerUserServiceComponent.builder().build();
        userServiceComponent.inject(this);
        this.fragment = fragment;
        this.context = context;
        this.comunicadorEntreFragments = comunicadorEntreFragments;
    }

    public void postGostoCinefilo(String username, boolean terror, boolean suspense, boolean comedia, boolean comediaRomantica, boolean romantico, boolean ficcao, boolean acao, boolean anime, boolean documentario, boolean drama, boolean policiais, boolean besteirolAmericano) {
        String json = convertendoParaJson(terror, suspense, comedia, comediaRomantica, romantico, ficcao, acao, anime, documentario, drama, policiais, besteirolAmericano);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);

        userService.postGostoCinefilo(username, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseGeral -> checandoStatus(responseGeral), throwable -> throwable.printStackTrace());
    }

    private String convertendoParaJson(boolean terror, boolean suspense, boolean comedia, boolean comediaRomantica, boolean romantico, boolean ficcao, boolean acao, boolean anime, boolean documentario, boolean drama, boolean policiais, boolean besteirolAmericano) {
        return String.format("{ \"terror\": %b, \"suspense\": %b, \"comedia\": %b, \"comediaRomantica\": %b, \"romantico\": %b, \"ficcaoCientifica\": %b, \"acao\": %b, \"anime\": %b, \"documentario\": %b, \"drama\": %b, \"policiais\": %b, \"besteirolAmericano\": %b}",
                terror, suspense, comedia, comediaRomantica, romantico, ficcao, acao, anime, documentario, drama, policiais, besteirolAmericano);
    }

    private void checandoStatus(ResponseGeral responseGeral) {

        if (responseGeral.getStatus() == 200) {
            comunicadorEntreFragments.passandoFragments(fragment);
        } else {
            Toast.makeText(context, responseGeral.getResult(), Toast.LENGTH_LONG).show();
        }

    }

    private void getGostoCinefilo() {
        //TODO
    }


}
