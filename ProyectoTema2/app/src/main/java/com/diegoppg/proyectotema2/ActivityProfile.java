package com.diegoppg.proyectotema2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Buscar elemento vista
        EditText usernameText = findViewById(R.id.editTextUsername);

        //Recuperar datos de la primera actividad
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        //Setear dato en editText
        usernameText.setText(username);
        Log.d("Pass", password);



        Button botonNavegador = findViewById(R.id.buttonNavegador);


        botonNavegador.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://unendo.es/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            //Intent intent = new Intent(Intent.ACTION_VIEW);
            //intent.setData(Uri.parse("https://unendo.es/"));

            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://unendo.es/"));

            startActivity(intent);
        });

        Button botonAlarma = findViewById(R.id.buttonAlarma);

        botonAlarma.setOnClickListener(view -> {

            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Recreo")
                    .putExtra(AlarmClock.EXTRA_HOUR, 11)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 15);

            startActivity(intent);
            /*
            //Comprobar si alguna aplicacion que puede realizar la accion
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "No se puede abrir la alarma", Toast.LENGTH_SHORT).show();
            }
            */

        });

        ImageView imageViewFoto = findViewById(R.id.imageViewProfile);

        //Crear intent result launcher para recibir foto capturada
        ActivityResultLauncher<Intent> launcherFoto = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //Dato recibido correctamente
                        imageViewFoto.setImageURI(result.getData().getData());
                        Toast.makeText(this, "📸 Foto capturada correctamente", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(this, "❌ Operación cancelada", Toast.LENGTH_SHORT).show();
                    }
                }
        );


        imageViewFoto.setOnClickListener(view -> {
            Intent misco = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            launcherFoto.launch(misco);
        });



    }
}






























