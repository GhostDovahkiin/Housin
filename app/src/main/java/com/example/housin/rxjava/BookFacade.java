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

public class BookFacade {
    @Inject
    UserService userService;
    private Fragment fragment;
    private Context context;
    private ComunicadorEntreFragments comunicadorEntreFragments;

    public BookFacade(Fragment fragment, Context context, ComunicadorEntreFragments comunicadorEntreFragments) {
        UserServiceComponent userServiceComponent = DaggerUserServiceComponent.builder().build();
        userServiceComponent.inject(this);

        this.comunicadorEntreFragments = comunicadorEntreFragments;

        this.fragment = fragment;
        this.context = context;
    }

    public void postGostoLiterario(String username, boolean terror, boolean quadrinhos, boolean manga, boolean romance, boolean ficcao, boolean religioso, boolean infanto, boolean fantasia, boolean academico) {
        String json = convertendoParaJson(terror, quadrinhos, manga, romance, ficcao, religioso, infanto, fantasia, academico);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);

        userService.postGostoLiterario(username, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseGeral -> checandoStatus(responseGeral), throwable -> throwable.printStackTrace());
    }

    private String convertendoParaJson(boolean terror, boolean quadrinhos, boolean manga, boolean romance, boolean ficcao, boolean religioso, boolean infanto, boolean fantasia, boolean academico) {
        return String.format("{ \"terror\": %b, \"quadrinhos\": %b, \"manga\": %b, \"romance\": %b, \"ficcaoCientifica\": %b, \"religioso\": %b, \"infantoJuvenil\": %b, \"fantasia\": %b, \"academico\": %b}",
                terror, quadrinhos, manga, romance, ficcao, religioso, infanto, fantasia, academico);
    }

    private void checandoStatus(ResponseGeral responseGeral) {

        if (responseGeral.getStatus() == 200) {
            comunicadorEntreFragments.passandoFragments(fragment);
        } else {
            Toast.makeText(context, responseGeral.getResult(), Toast.LENGTH_LONG).show();
        }

    }
}
