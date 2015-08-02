package co.jce.sena.ejemplo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jce on 2/08/15.
 */
public class Proyecto003Activity extends AppCompatActivity {

    //-> Atributos (Campos)
    private EditText entrada1, entrada2;
    private TextView salida;
    private RadioButton opcionSuma, opcionResta;
    private Button boton;

    //-> Atributos (Variables)
    private int valor1, valor2;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super .onCreate( savedInstanceState );
        setContentView( R .layout .activity_proyecto003 );

        //-> Busca para acceder a cada campo del "Activity" haciendo un TypeCast según corresponda.
        entrada1 = (EditText) findViewById( R .id .et_Valor1 );
        entrada2 = ( EditText ) findViewById( R .id .et_Valor2 );
        opcionSuma = ( RadioButton ) findViewById( R .id .rb_Suma );
        opcionResta = ( RadioButton ) findViewById( R. id .rb_Resta );
        salida = (TextView) findViewById( R .id .tv_Resultado );
        boton = ( Button ) findViewById( R. id .btn_Calcular );

        // Manejador de Eventos para el botón Cálcular
        boton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar(null);
            }
        });

    }

    public void iniciar( View v ) {

        //-> Valida cada campo de entrada del formulario.
        valor1 = validar(entrada1, "El primer campo se encuentra vacio");
        valor2 = validar(entrada2, "El segundo campo se encuentra vacio");

        if( valor1 != -1 && valor2 != -1 ) {

            if( opcionSuma .isChecked() ) {
                salida .setText( valor1 + " + " + valor2 + " = " + sumar(valor1, valor2) );
            }
            else if( opcionResta .isChecked() ) {
                salida .setText( valor1 + " - " + valor2 + " = " + restar(valor1, valor2) );
            }
            else {
                Toast.makeText( Proyecto003Activity.this, "No has seleccionado una operación", Toast.LENGTH_SHORT ) .show();
                return;
            }

            //-> Asigna el valor de la suma como un "String" al respectivo campo "TextView" en la vista.
            Toast.makeText( Proyecto003Activity.this, "El cálculo se ha realizado con éxito", Toast.LENGTH_SHORT ) .show();

        }
        else {
            salida .setText("");
        }

        entrada1 .setText( "" );
        entrada2 .setText( "" );
        opcionSuma .setChecked( false );
        opcionResta .setChecked( false );

    }

    private int validar( EditText valor, String mensaje ) {

        // Valida que el campo sea diferente de vacio.
        if( valor .getText() .toString() .length() == 0 ) {
            Toast.makeText( Proyecto003Activity .this, mensaje, Toast.LENGTH_SHORT ) .show();
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

}
