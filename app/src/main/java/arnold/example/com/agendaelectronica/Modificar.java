package arnold.example.com.agendaelectronica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Modificar extends ActionBarActivity {

    BaseDeDatos baseDeDatos;
    EditText nombre_input;
    EditText apellido_input;
    EditText telefono_input;
    EditText email_input;
    EditText descripcion_input;
    int idglobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Aqui se hace el retrieve de la base de datos tomando un valor que viene en el intent anterior

        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_activity);

        nombre_input = (EditText) findViewById(R.id.nombre_input);
        apellido_input = (EditText) findViewById(R.id.apellido_input);
        telefono_input = (EditText) findViewById(R.id.telefono_input);
        email_input = (EditText) findViewById(R.id.email_input);
        descripcion_input = (EditText) findViewById(R.id.descripcion_input);
        baseDeDatos = new BaseDeDatos(this, null, null, 1);
        Contacts persona = new Contacts();
        Intent i = getIntent(); // gets the previously created intent
        String stringid = i.getStringExtra("id_persona");
        int id = Integer.parseInt(stringid);
        Cursor c = baseDeDatos.personabyid(id);

    //Vuelve a rellenar los inputs con los valores del cursor
        nombre_input.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
        apellido_input.setText(c.getString(c.getColumnIndexOrThrow("apellido")));
        telefono_input.setText(c.getString(c.getColumnIndexOrThrow("telefono")));
        email_input.setText(c.getString(c.getColumnIndexOrThrow("email")));
        //descripcion_input.setText(c.getString(c.getColumnIndexOrThrow("descripcion")));
        idglobal = c.getInt(c.getColumnIndexOrThrow("_id"));

    }

    public void modificar_clicked(View view){

        Contacts contacts = new Contacts(nombre_input.getText().toString(), apellido_input.getText().toString(),  telefono_input.getText().toString(), email_input.getText().toString(), descripcion_input.getText().toString() );
        contacts.setId(idglobal);
        baseDeDatos.updatepersona(contacts);
        confirmacion();
        limpiarcampos();
        finish(); //Termina la actividad y vuelve al menu principal

        }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha modificado exitosamente!");
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

    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos(){

        nombre_input.setText("");
        apellido_input.setText("");
        telefono_input.setText("");
        email_input.setText("");
        descripcion_input.setText("");

    }
}
