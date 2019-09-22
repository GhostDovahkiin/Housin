package com.example.housin.rxjava;

import android.widget.TextView;

import com.example.housin.dagger.DaggerUserServiceComponent;
import com.example.housin.dagger.UserServiceComponent;
import com.example.housin.model.UserAPI;
import com.example.housin.service.UserService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRx {

    TextView txtSexo;
    TextView txtResp;
    TextView txtOrg;
    TextView txtLimpo;
    TextView txtAnimais;
    TextView txtFuma;
    TextView txtComp;
    TextView txtBebe;


    @Inject
    UserService userService;

    public UserRx() {
        UserServiceComponent userServiceComponent = DaggerUserServiceComponent.builder().build();
        userServiceComponent.inject(this);
    }

    public void setTexts(TextView txtSexo, TextView txtResp, TextView txtOrg, TextView txtLimpo, TextView txtAnimais, TextView txtFuma, TextView txtComp, TextView txtBebe) {
        this.txtSexo = txtSexo;
        this.txtResp = txtResp;
        this.txtOrg = txtOrg;
        this.txtLimpo = txtLimpo;
        this.txtAnimais = txtAnimais;
        this.txtFuma = txtFuma;
        this.txtComp = txtComp;
        this.txtBebe = txtBebe;
    }

    public void bla(String username) {

        userService.getUsuario(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resultApi -> setting(resultApi.getUsuario()), throwable -> throwable.printStackTrace());
    }

    private void setting(UserAPI.Usuario usuario) {

        txtSexo.setText(usuario.getSexo());
        txtResp.setText(formatandoBooleans(usuario.getResponsavel()));
        txtOrg.setText(formatandoBooleans(usuario.getOrganizado()));
        txtLimpo.setText(formatandoBooleans(usuario.getLimpo()));


    }

    public String formatandoBooleans(boolean value) {
        if (value) {
            return "Yeaaaaaaaaah";
        }
        return "Noooooooooo";
    }

}
