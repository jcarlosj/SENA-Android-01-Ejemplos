package co.jce.sena.ejemplo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jce on 2/08/15.
 */
public class Proyecto002Activity extends AppCompatActivity {

    //-> Atributos (Campos)
    private EditText entrada1, entrada2;
    private TextView salida;
    private Button boton;

    //-> Atributos (Variables)
    private int valor1, valor2;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super .onCreate( savedInstanceState );
        setContentView( R .layout .activity_proyecto002 );

        //-> Busca para acceder a cada campo del "Activity" haciendo un TypeCast según corresponda.
        entrada1 = ( EditText ) findViewById( R .id .et_Valor1 );
        entrada2 = ( EditText ) findViewById( R .id .et_Valor2 );
        salida = ( TextView ) findViewById( R .id.tv_Resultado);
        boton = (Button) findViewById(R.id.btn_Suma);         //: Botón Suma

        // Manejador de Eventos para el botón Suma
        boton .setOnClickListener( new View .OnClickListener() {
            @Override
            public void onClick( View v ) {
                iniciar( null );
            }
        });

    }

    public void iniciar( View v ) {

        //-> Valida cada campo de entrada del formulario.
        valor1 = validar(entrada1, "El primer campo se encuentra vacio");
        valor2 = validar(entrada2, "El segundo campo se encuentra vacio");

        if( valor1 != -1 && valor2 != -1 ) {
            //-> Se asigna el valor de la suma como un "String" al respectivo campo "TextView" en la vista.
            salida .setText( valor1 + " + " + valor2 + " = " + sumar(valor1, valor2) );    //: Quito String .valueOf()

            Toast .makeText( Proyecto002Activity .this, "La suma se ha realizado con éxito", Toast .LENGTH_SHORT ) .show();
        }
        else {
            salida .setText( "" );
        }

        entrada1 .setText( "" );
        entrada2 .setText( "" );

    }

    private int validar( EditText valor, String mensaje ) {

        // Valida que el campo sea diferente de vacio.
        if( valor .getText() .toString() .length() == 0 ) {
            Toast .makeText( Proyecto002Activity .this, mensaje, Toast .LENGTH_SHORT ) .show();
            return -1;
        }
        else {
            //-> Obtiene el valor de cada uno de los campos, se realiza un parseo de cada valor según corresponda y lo retorna.
            return Integer .parseInt( valor .getText().toString() );
        }

    }

    private int sumar( int valor1, int valor2 ) {

        return ( valor1 + valor2 );

    }
}
