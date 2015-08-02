package co.jce.sena.ejemplo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void proyecto001( View v ) {

        Intent i = new Intent( this, Proyecto001Activity.class );
        startActivity( i );

    }

    public void proyecto002( View v ) {

        Intent i = new Intent( this, Proyecto002Activity.class );
        startActivity( i );

    }

    public void proyecto003( View v ) {

        Intent i = new Intent( this, Proyecto003Activity.class );
        startActivity( i );

    }

    public void proyecto004( View v ) {

        Intent i = new Intent( this, Proyecto004Activity.class );
        startActivity(i);

    }

    public void proyecto005( View v ) {

        Intent i = new Intent( this, Proyecto005Activity.class );
        startActivity(i);

    }

    public void proyecto006( View v ) {

        Intent i = new Intent( this, Proyecto006Activity.class );
        startActivity( i );

    }

}
