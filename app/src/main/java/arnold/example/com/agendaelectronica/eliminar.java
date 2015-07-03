package arnold.example.com.agendaelectronica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class eliminar extends ActionBarActivity {

    BaseDeDatos baseDeDatos;
    EditText elimina_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminar_activity);
        elimina_input = (EditText) findViewById(R.id.modificar_input);
        baseDeDatos = new BaseDeDatos(this, null, null, 1);
    }

    public void eliminar_clicked(View view){

        baseDeDatos.borrarPersona(Integer.parseInt(elimina_input.getText().toString()));
        confirmacion();


    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(elimina_input.getText());
        dlgAlert.setTitle("Se ha eliminado satisfactoriamente!!!");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

}
