package edu.cecar.controladores;

import android.content.SyncStatusObserver;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class GestionTestExtraerDatoCVLAC extends TestWatcher {

    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("La prueba del metodo " + description.getClassName() + "ha fallado");

        System.out.println("El error presentado es: " + e.getMessage());

    }

    @Override
    protected void succeeded(Description description) {

        System.out.println("La prueba del medoto " + description.getClassName() + "ha sido exitosa");
    }
}
