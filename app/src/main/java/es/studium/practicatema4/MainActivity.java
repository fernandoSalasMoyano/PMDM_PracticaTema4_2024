package es.studium.practicatema4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements OnDialogosListener, View.OnClickListener
{
    // Dialogos
    DialogoNombre dlgNombre;
    DialogoSexo dlgSexo;
    DialogoEspecie dlgEspecie;
    DialogoProfesion dlgProfesion;

    // Cadenas seleccionadas
    String nombre;
    String sexo;
    String especie;
    String profesion;

    // Boton reiniciar
    Button btnReiniciar;

    // TextViews
    TextView txtNombre;

    TextView txtVida;
    TextView txtMagia;
    TextView txtFuerza;
    TextView txtVelocidad;

    // Imagen
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dlgNombre = new DialogoNombre();
        dlgNombre.setCancelable(false);
        dlgNombre.show(getSupportFragmentManager(), "Dialogo Nombre");

        btnReiniciar = findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(this);

        txtNombre = findViewById(R.id.textViewNombre);
        txtVida = findViewById(R.id.textViewVida);
        txtMagia = findViewById(R.id.textViewMagia);
        txtFuerza = findViewById(R.id.textViewFuerza);
        txtVelocidad = findViewById(R.id.textViewVelocidad);

        imagen = findViewById(R.id.imagen);
    }


    @Override
    public void onNombreSet(String nombre)
    {
        this.nombre = nombre;

        dlgSexo = new DialogoSexo();
        dlgSexo.setCancelable(false);
        dlgSexo.show(getSupportFragmentManager(), "Dialogo Sexo");

    }

    @Override
    public void onSexoSet(String sexo)
    {
        this.sexo = sexo;

        dlgEspecie = new DialogoEspecie();
        dlgEspecie.setCancelable(false);
        dlgEspecie.show(getSupportFragmentManager(), "Dialogo Especie");
    }

    @Override
    public void onEspecieSet(String especie)
    {
        this.especie = especie;

        dlgProfesion = new DialogoProfesion();
        dlgProfesion.setCancelable(false);
        dlgProfesion.show(getSupportFragmentManager(), "Dialogo Profesión");
    }

    @Override
    public void onProfesionSet(String profesion)
    {
        this.profesion = profesion;
        comprobarOpciones();
    }

    private void comprobarOpciones()
    {

        Random random = new Random();
        int vida = random.nextInt(101);
        int magia = random.nextInt(11);
        int fuerza = random.nextInt(21);
        int velocidad = random.nextInt(6);

        txtNombre.setText(nombre.toUpperCase());
        txtVida.setText(getString(R.string.vida) + String.valueOf(vida));
        txtMagia.setText(getString(R.string.magia) + String.valueOf(magia));
        txtFuerza.setText(getString(R.string.fuerza) + String.valueOf(fuerza));
        txtVelocidad.setText(getString(R.string.velocidad) + String.valueOf(velocidad));



        // Solo se ejecuta si todos los valores están asignados
        if (nombre != null && sexo != null && especie != null && profesion != null)
        {
            // Humano
            if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_arquero)))
            {
                imagen.setImageResource(R.drawable.humano_arquera);

            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_arquero)))
            {
                imagen.setImageResource(R.drawable.mujer_arquera);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_guerrero)))
            {
                imagen.setImageResource(R.drawable.humano_guerrero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_guerrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_humano_mujer_guerrero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_mago)))
            {
                imagen.setImageResource(R.drawable.crea_un_humano_hombre_mago);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_mago)))
            {
                imagen.setImageResource(R.drawable.crea_un_humano_mujer_mago);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_herrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_humano_hombre_herrero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_herrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_humano_mujer_herrero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_minero)))
            {
                imagen.setImageResource(R.drawable.crea_un_humano_hombre_minero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_humano)) &&
                    profesion.equals(getString(R.string.rdb_minero)))
            {
                imagen.setImageResource(R.drawable.crea_un_humano_mujer_minero);
            }

            // Elfo
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_arquero)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_hombre_arquero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_arquero)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_mujer_arquero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_guerrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_hombre_guerrero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_guerrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_mujer_guerrero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_mago)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_mujer_mago);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_mago)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_hombre_mago);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_herrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_mujer_herrero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_herrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_hombre_herrero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_minero)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_hombre_minero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_elfo)) &&
                    profesion.equals(getString(R.string.rdb_minero)))
            {
                imagen.setImageResource(R.drawable.crea_un_elfo_mujer_minero);
            }

            // Enano
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_arquero)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_hombre_arquero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_arquero)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_mujer_arquero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_guerrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_hombre_guerreo);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_guerrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_mujer_guerrero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_mago)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_hombre_mago);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_mago)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_mujer_mago);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_herrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_hombre_herrero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_herrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_mujer_herrero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_minero)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_hombre_minero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_enano)) &&
                    profesion.equals(getString(R.string.rdb_minero)))
            {
                imagen.setImageResource(R.drawable.crea_un_enano_mujer_minero);
            }

            // Hobbit
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_arquero)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_hombre_arquero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_arquero)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_mujer_arquero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_guerrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_hombre_guerrero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_guerrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_mujer_guerrero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_mago)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_hombre_mago);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_mago)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_mujer_mago);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_herrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_hombre_herrero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_herrero)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_mujer_herrero);
            }
            else if (sexo.equals(getString(R.string.rdb_hombre)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_minero)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_hombre_minero);
            }
            else if (sexo.equals(getString(R.string.rdb_mujer)) &&
                    especie.equals(getString(R.string.rdb_hobbit)) &&
                    profesion.equals(getString(R.string.rdb_minero)))
            {
                imagen.setImageResource(R.drawable.crea_un_hobbit_mujer_minero);
            }

        }
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.btnReiniciar)
        {
            // Reiniciar todas las variables
            txtNombre.setText("");
            txtVida.setText("");
            txtMagia.setText("");
            txtVelocidad.setText("");
            txtFuerza.setText("");
            imagen.setImageResource(0);
            nombre = null;
            sexo = null;
            especie = null;
            profesion = null;

            // Reiniciar el proceso desde el primer diálogo
            dlgNombre = new DialogoNombre();
            dlgNombre.setCancelable(false);
            dlgNombre.show(getSupportFragmentManager(), "Dialogo Nombre");

            // Mostrar un mensaje al usuario
            Toast.makeText(this, R.string.reiniciado, Toast.LENGTH_SHORT).show();
        }
    }

}