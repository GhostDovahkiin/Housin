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

public class MusicalFacade {

    @Inject
    UserService userService;
    private Fragment fragment;
    private Context context;
    private ComunicadorEntreFragments comunicadorEntreFragments;

    public MusicalFacade(Fragment fragment, Context context, ComunicadorEntreFragments comunicadorEntreFragments) {
        UserServiceComponent userServiceComponent = DaggerUserServiceComponent.builder().build();
        userServiceComponent.inject(this);
        this.fragment = fragment;
        this.context = context;
        this.comunicadorEntreFragments = comunicadorEntreFragments;
    }

    public void postGostoMusical(String username, boolean pop, boolean rock, boolean bregaRecife, boolean funk, boolean pagode, boolean indie, boolean eletronica, boolean hipHop, boolean rap, boolean metal, boolean jazz, boolean folk, boolean rb, boolean forro, boolean classica) {
        String json = convertendoParaJson(pop, rock, bregaRecife, funk, pagode, indie, eletronica, hipHop, rap, metal, jazz, folk, rb, forro, classica);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), json);

        userService.postGostoMusical(username, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseGeral -> checandoStatus(responseGeral), throwable -> throwable.printStackTrace());
    }

    private String convertendoParaJson(boolean pop, boolean rock, boolean bregaRecife, boolean funk, boolean pagode, boolean indie, boolean eletronica, boolean hipHop, boolean rap, boolean metal, boolean jazz, boolean folk, boolean rb, boolean forro, boolean classica) {
        return String.format("{ \"pop\": %b, \"rock\": %b, \"bregaRecife\": %b, \"funk\": %b, \"pagode\": %b, \"indie\": %b, " +
                        "\"eletronica\": %b, \"hipHop\": %b, \"rap\": %b, \"metal\": %b, \"jazz\": %b, \"folk\": %b, \"rb\": %b, \"forro\": %b, \"classica\": %b}",
                pop, rock, bregaRecife, funk, pagode, indie, eletronica, hipHop, rap, metal, jazz, folk, rb, forro, classica);
    }

    private void checandoStatus(ResponseGeral responseGeral) {

        if (responseGeral.getStatus() == 200) {
            comunicadorEntreFragments.passandoFragments(fragment);
        } else {
            Toast.makeText(context, responseGeral.getResult(), Toast.LENGTH_LONG).show();
        }

        Log.i("response lala", responseGeral.getResult());
        Log.i("status lele", String.valueOf(responseGeral.getStatus() == 200));

    }

}
