package edu.cecar.controladores;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExtraerDatoCVLACUnitTest {

    @Rule
    public GestionTestExtraerDatoCVLAC gestionTestExtraerDatoCVLAC = new GestionTestExtraerDatoCVLAC();

    @Test
    public void testDatosCVLAC() {

        // Se definen los datos de referencia con los que se probara el metodo extraerDatos.
        Investigador investigadorUno = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180");

        // Se define los datos esperados.

        String nombreInvetigadorUno = "Jhon Jaime Mendez Alandete";
        String nacionalidadInvestigadorUno = "Colombiana";
        String sexoInvestigadorUno = "Masculino";

        // Se comprueba o testea el valor esperado con el obtenido.

        assertEquals(nombreInvetigadorUno, investigadorUno.getNombres());
        assertEquals(nacionalidadInvestigadorUno, investigadorUno.getNacionalidad());
        assertEquals(sexoInvestigadorUno, investigadorUno.getSexo());

    }

}
