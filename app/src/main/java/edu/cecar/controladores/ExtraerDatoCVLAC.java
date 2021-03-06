package edu.cecar.controladores;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class ExtraerDatoCVLAC {



    private ExtraerDatoCVLAC(){

    }

    public static Investigador  getDatos(String url) {

        Investigador investigador = null;



        try {

            Document documentoHTML = Jsoup.connect(url).get();


            Element tablas = documentoHTML.select("table").get(1); //Se obtiene la primera tabla
            Element tablasInvestigacion = documentoHTML.select("table").get(7); //Se obtiene la sexta tabla

            Elements filasTabla = tablas.select("tr"); // Se obtienen las filas de la tabla
            Elements filaTablaInvestigacion = tablasInvestigacion.select("tr");//

            int filaNombre = 0;
            int filanacionalidad = 2;
            int filaSexo =3;

            if (filasTabla.size()>4){
                filaNombre =2;
                filanacionalidad=4;
                filaSexo=5;
            }

            String nombre = filasTabla.get(filaNombre).select("td").get(1).text();
            String nacionalidad = filasTabla.get(filanacionalidad).select("td").get(1).text();
            String sexo = filasTabla.get(filaSexo).select("td").get(1).text();

            ////

            int tamano = filaTablaInvestigacion.size();
            String existeInvestigacion = filaTablaInvestigacion.get(0).select("td").get(0).text();
            String investigaciones=filaTablaInvestigacion.get(0).select("td").get(0).text();


            ArrayList<String> arreglo = new ArrayList<>();

            for (int i = 0; i<tamano-1; i++) {


                arreglo.add(i,filaTablaInvestigacion.get(i).select("td").get(0).text());

                }



            if (existeInvestigacion=="Líneas de investigación"){
                investigador = new Investigador(nombre, nacionalidad, sexo, "No posee linea de investigacion",arreglo,true);

            }else {
                investigador = new Investigador(nombre, nacionalidad, sexo, investigaciones,arreglo,true);


            }





        } catch (IOException e) {

        }

        return investigador;

    }


}
