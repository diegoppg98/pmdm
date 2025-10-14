package com.diegoppg.proyectotema2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;

public class MainActivityLogin extends AppCompatActivity {

    final String USER="admin";
    final String PASS="12345";
    Uri photoUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Acceder a elementos del layout
        Button botonLogin = findViewById(R.id.buttonLogin);
        EditText editTextUsuario = findViewById(R.id.editTextUsuario);
        EditText editTextPass = findViewById(R.id.editTextPass);
        ImageView imageViewFoto = findViewById(R.id.imageViewLogin);



        // 1. Lambda
        botonLogin.setOnClickListener(v -> {
            //Pasar de una actividad a otra
            Intent intent = new Intent(this, ActivityProfile.class);

            String user = editTextUsuario.getText().toString();
            String pass = editTextPass.getText().toString();

            //Pasar datos a la actividad perfil
            intent.putExtra("username", user);
            intent.putExtra("password", pass);

            if(user.equals(USER) && pass.equals(PASS)){
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
            }


















/*
            //Toast toast = Toast.makeText(this, "Boton clicado", Toast.LENGTH_LONG);
            //toast.show();
            String msg = editTextUsuario.getText() + " : " + editTextPass.getText();

            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();




*/

        });


        /*
        //2. Sobrescribiendo listener
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Prueba", "Boton clicado");
            }
        });

        //3. Creando listener
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Prueba", "Boton clicado");
            }
        };

        botonLogin.setOnClickListener(listener);
*/



/*
        //Ejemplo de lambda
        ArrayList<String> paises = new ArrayList<String>(Arrays.asList
                ("España", "Francia", "Alemania", "Italia", "Portugal"));

        for(String pais : paises){
            Log.d("Prueba", pais);
        }

        paises.forEach(pais -> Log.d("Prueba", pais));
*/

    }

    /* Otra manera de hacerlo
    public void botonClicado(View view) {
        Log.d("Prueba", "Boton clicado");
    }
     */
}