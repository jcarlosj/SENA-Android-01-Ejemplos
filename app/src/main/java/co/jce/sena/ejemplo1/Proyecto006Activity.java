package co.jce.sena.ejemplo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by jce on 2/08/15.
 */
public class Proyecto006Activity extends AppCompatActivity {

    //-> Atributos (Componentes Activity)
    private TextView poblacion;
    private ListView paises;

    //-> Atributos (Variables)
    private String lista_paises[];
    private String lista_habitantes[];

    //-> Atributos (Especiales)
    ArrayAdapter <String> adaptador;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super .onCreate( savedInstanceState );
        setContentView( R .layout .activity_proyecto006 );

        //-> Acceder a los componentes del "Activity" haciendo un TypeCast según corresponda.
        poblacion = ( TextView ) findViewById( R .id .tv_Poblacion );
        paises = ( ListView ) findViewById( R .id .lv_Paises );

        //-> Vectores de datos a desplegar en el ListView
        lista_paises = new String[] { "Argentina", "Chile", "Payaguay", "Bolivia", "Perú", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay" };
        lista_habitantes = new String[] { "40000000", "17000000", "6500000", "10000000", "30000000", "14000000", "183000000","44000000", "29000000", "3500000" };

        //-> Construcción del ArrayAdapter (Adaptador)
        adaptador = new ArrayAdapter<String>( this, android .R .layout .simple_list_item_1, lista_paises );  //: Conectamos el Vector paises al adaptador.
        paises .setAdapter( adaptador );   //: Conectamos el adaptador al (Componente) ListView

        //-> Manejador de Eventos para el ListView
        paises .setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick( AdapterView<?> parent, View view, int position, long id ) {
                poblacion .setText( "Población " + paises .getItemAtPosition( position ) + " es " + lista_habitantes[ position ] );
            }
        });

    }

}
