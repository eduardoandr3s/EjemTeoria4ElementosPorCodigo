package eduCodeDev.ejemteoria4elementosporcodigo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import eduCodeDev.ejemteoria4elementosporcodigo.databinding.ActivityAddAlumnoBinding;

public class AddAlumnoActivity extends AppCompatActivity {

    private ActivityAddAlumnoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddAlumnoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}