package com.tbitsglobal;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class Counties {

    private boolean accepted;

    public void viewReport() {
        if (true) {
            accepted = false;
        }
    }

    public boolean isAccepted() {
        return accepted;
    }

}
