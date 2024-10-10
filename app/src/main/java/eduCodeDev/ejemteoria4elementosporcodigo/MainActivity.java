package eduCodeDev.ejemteoria4elementosporcodigo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import eduCodeDev.ejemteoria4elementosporcodigo.databinding.ActivityMainBinding;
import eduCodeDev.ejemteoria4elementosporcodigo.modelos.AlumnoModel;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> addAlumnosLauncher;
    private ArrayList<AlumnoModel> listaAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        listaAlumnos= new ArrayList<>();
        inicializarLaunchers();


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                            addAlumnosLauncher.launch(new Intent(MainActivity.this, AddAlumnoActivity.class));
            }
        });
    }

    private void inicializarLaunchers() {
        addAlumnosLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                if (o.getResultCode()== RESULT_OK){
                    if (o.getData() != null && o.getData().getExtras() != null){
                        AlumnoModel alumno = (AlumnoModel) o.getData().getExtras().getSerializable("ALUMNO");

                       if (alumno != null){

                           listaAlumnos.add(alumno);
                           mostrarAlumnos();
                       }

                    }
                }


            }
        });

    }

    private void mostrarAlumnos() {

        binding.contentMain.contenedorMain.removeAllViews();

        for(AlumnoModel alumno : listaAlumnos){

            TextView txtAlumno = new TextView(MainActivity.this);
            txtAlumno.setText(alumno.toString());
            binding.contentMain.contenedorMain.addView(txtAlumno);
        }
    }


}