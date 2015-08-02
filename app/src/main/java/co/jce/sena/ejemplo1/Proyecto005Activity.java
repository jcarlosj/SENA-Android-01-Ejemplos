package co.jce.sena.ejemplo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jce on 2/08/15.
 */
public class Proyecto005Activity extends AppCompatActivity {

    //-> Atributos (Campos)
    private EditText entrada1, entrada2;
    private TextView salida;
    private Spinner spinner;

    //-> Atributos (Variables)
    private int valor1, valor2;
    private String operaciones[];
    private String resultado, signo;

    //-> Artributos (Especiales)
    private ArrayAdapter< String > adaptador;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super .onCreate( savedInstanceState );
        setContentView( R .layout .activity_proyecto005 );

        //-> Busca para acceder a cada campo del "Activity" haciendo un TypeCast según corresponda.
        entrada1 = (EditText) findViewById( R .id .et_Valor1 );
        entrada2 = ( EditText ) findViewById( R .id .et_Valor2 );
        spinner = ( Spinner ) findViewById( R. id .sp_Operaciones );
        salida = (TextView) findViewById( R .id .tv_Resultado );

        //-> Array > Adaptador > Spinner (Implementación del Spinner)
        operaciones = new String[] { "Seleccionar...", "Sumar", "Restar", "Multiplicar", "Dividir" };
        adaptador = new ArrayAdapter< String >( Proyecto005Activity.this, android.R.layout.simple_list_item_1, operaciones);
        spinner .setAdapter(adaptador);

    }

    public void iniciar( View v ) {

        //-> Valida cada campo de entrada del formulario.
        valor1 = validar( entrada1, "El primer campo se encuentra vacio" );
        valor2 = validar( entrada2, "El segundo campo se encuentra vacio" );

        if( valor1 != -1 && valor2 != -1 ) {

            if( spinner .getSelectedItem() .toString() .equals( "Sumar" ) ) {
                resultado = String .valueOf( sumar( valor1, valor2 ) );
                signo = " + ";
            }
            else if( spinner .getSelectedItem() .toString() .equals( "Restar" ) ) {
                resultado = String .valueOf( restar( valor1, valor2 ) );
                signo = " - ";
            }
            else if( spinner .getSelectedItem() .toString() .equals( "Multiplicar" ) ) {
                resultado = String .valueOf( multiplicar( valor1, valor2 ) );
                signo = " x ";
            }
            else if( spinner .getSelectedItem() .toString() .equals( "Dividir" ) ) {
                resultado = String .valueOf( dividir( valor1, valor2 ) );
                signo = " / ";
            }
            else {
                Toast .makeText( Proyecto005Activity.this, "No has seleccionado una operación", Toast .LENGTH_SHORT ) .show();
                return;
            }

            //-> Asigna el valor del calculo a un "String" al respectivo campo "TextView" en la vista.
            salida .setText( valor1 + signo + valor2 + " = " + resultado );
            Toast .makeText( Proyecto005Activity.this, "El cálculo se ha realizado con éxito", Toast .LENGTH_SHORT ) .show();

        }
        else {
            salida .setText("");
        }

        entrada1 .setText( "" );
        entrada2 .setText( "" );
        spinner .setSelection( 0, true );

    }

    private int validar( EditText valor, String mensaje ) {

        // Valida que el campo sea diferente de vacio.
        if( valor .getText() .toString() .length() == 0 ) {
            Toast.makeText( Proyecto005Activity.this, mensaje, Toast.LENGTH_SHORT ) .show();
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

    private int restar( int valor1, int valor2 ) {

        return ( valor1 - valor2 );

    }

    private int multiplicar( int valor1, int valor2 ) {

        return ( valor1 * valor2 );

    }

    private float dividir( int valor1, int valor2 ) {

        // TypeCast para forzar el tipo de entero a flotante
        float v1 = ( float ) valor1,
                v2 = ( float ) valor2;

        return ( v1 / v2 );

    }


}
