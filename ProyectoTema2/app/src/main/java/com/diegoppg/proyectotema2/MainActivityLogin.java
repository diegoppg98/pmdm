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








        ActivityResultLauncher<Intent> launcherFoto = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if(result.getResultCode() == Activity.RESULT_OK)  {

                        }
                    }
                });




        ActivityResultLauncher<Intent> launcherFoto2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        if (photoUri != null) {
                            // Mostrar la foto tomada en el ImageView
                            imageViewFoto.setImageURI(photoUri);
                            Toast.makeText(this, "📸 Foto capturada correctamente", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "❌ Operación cancelada", Toast.LENGTH_SHORT).show();
                    }
                }
        );













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
            //Alarma
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Alarma")
                    .putExtra(AlarmClock.EXTRA_HOUR, 20)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 30);

            startActivity(intent);

            //<uses-permission android:name="com.android.alarm.permission.SET_ALARM" />

            if (intent.resolveActivity(getPackageManager()) != null) {
*/
            //Calendar


            //Camera

/*
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.CAMERA},
                        100
                );
            }


            try {
                File photoFile = new File(getExternalFilesDir(null), "photo.jpg");

                // Usar FileProvider para crear la URI
                photoUri = FileProvider.getUriForFile(
                        this,
                        getPackageName() + ".fileprovider",
                        photoFile
                );

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


                launcherFoto2.launch(intent);


            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al abrir la cámara", Toast.LENGTH_SHORT).show();
            }

*/



            //<uses-permission android:name="android.permission.CAMERA" />
















/*
            //Toast toast = Toast.makeText(this, "Boton clicado", Toast.LENGTH_LONG);
            //toast.show();
            String msg = editTextUsuario.getText() + " : " + editTextPass.getText();

            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();


            //Pasar de una actividad a otra
            Intent intent = new Intent(this, ActivityProfile.class);

            String user = editTextUsuario.getText().toString();
            String pass = editTextPass.getText().toString();


            if(user.equals(USER) && pass.equals(PASS)){
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
            }

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