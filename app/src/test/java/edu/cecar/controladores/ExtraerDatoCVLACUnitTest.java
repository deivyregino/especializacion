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
        Investigador investigadorUno = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001376707");
        Investigador investigadorDos = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000787132");

        // Se define los datos esperados.

        String nombreInvetigadorUno = "Guillermo Carlos Hernández Hernández";

        String nombreInvetigadorDos = "Namuel Francisco Solórzano Peralta";

        // Se comprueba o testea el valor esperado con el obtenido.

        assertEquals(nombreInvetigadorUno, investigadorUno.getNombres());
        assertEquals(nombreInvetigadorDos, investigadorDos.getNombres());
    }

    @Test
    public void testDatosCVLACUno(){
        // Se obtienen los datos del investigador.
        Investigador investigadorTres = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000402478");

        // Se define los datos esperados.
        String nombreInvestigadorTres = "Luty Del Carmen Gomezcaceres Peréz";

        // Se comprueba el valor esperado con el obtenido.
        assertEquals(nombreInvestigadorTres, investigadorTres.getNombres());

    }
}
