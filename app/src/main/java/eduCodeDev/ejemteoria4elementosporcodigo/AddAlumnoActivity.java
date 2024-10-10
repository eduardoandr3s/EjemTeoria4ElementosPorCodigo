package eduCodeDev.ejemteoria4elementosporcodigo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import eduCodeDev.ejemteoria4elementosporcodigo.databinding.ActivityAddAlumnoBinding;
import eduCodeDev.ejemteoria4elementosporcodigo.modelos.AlumnoModel;

public class AddAlumnoActivity extends AppCompatActivity {

    private ActivityAddAlumnoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddAlumnoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCancelarAddAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        binding.btnCrearAddAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlumnoModel alumno = crearAlumno();
                if (alumno != null){
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ALUMNO", alumno);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }else {

                    Toast.makeText(AddAlumnoActivity.this,"FALTAN DATOS",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private AlumnoModel crearAlumno() {

        if (binding.txtNombreAddAlumno.getText().toString().isEmpty()||
        binding.txtApellidosAddAlumno.getText().toString().isEmpty()){
            return null;
        }if (binding.spCiclosAddAlumno.getSelectedItemPosition() == 0){
            return null;
        }if (!binding.rbGrupoAAddAlumno.isChecked() &&
        !binding.rbGrupoBAddAlumno.isChecked() &&
        !binding.rbGrupoCAddAlumno.isChecked()){
            return null;
        }


        String ciclo = (String) binding.spCiclosAddAlumno.getSelectedItem();

        RadioButton rb = findViewById(binding.rgGrupoAddAlumno.getCheckedRadioButtonId());
        char grupo = rb.toString().charAt(0);
        AlumnoModel a = new AlumnoModel(binding.txtNombreAddAlumno.getText().toString(),binding.txtApellidosAddAlumno.getText().toString(),ciclo, grupo);
        return a;
    }
}