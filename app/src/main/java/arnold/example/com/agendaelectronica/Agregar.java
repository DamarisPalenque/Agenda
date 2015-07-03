package arnold.example.com.agendaelectronica;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ARNOLD on 02/07/2015.
 */
public class Agregar extends ActionBarActivity {

    BaseDeDatos baseDeDatos;
    EditText nombre;
    EditText apellido;
    EditText telefono;
    EditText email;
    EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_activity);

        nombre = (EditText)findViewById(R.id.nombre_input);
        apellido = (EditText)findViewById(R.id.apellido_input);
        telefono = (EditText) findViewById(R.id.telefono_input);
        email = (EditText) findViewById(R.id.email_input);
        descripcion = (EditText) findViewById(R.id.descripcion_input);
        baseDeDatos = new BaseDeDatos(this, null, null, 1);
    }
    public void agregar_clicked(View view){

        Contacts persona = new Contacts(nombre.getText().toString(), apellido.getText().toString(), telefono.getText().toString(), email.getText().toString(), descripcion.getText().toString() );
        baseDeDatos.addPersona(persona);
        confirmacion();
        limpiarcampos();
    }

    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos(){

        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        email.setText("");
        descripcion.setText("");

    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("La operacion se realizo exitosamente!");
        dlgAlert.setTitle("Agregar Persona");
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
