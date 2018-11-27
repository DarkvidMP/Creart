package eu.atspace.creart.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Perfil extends AppCompatActivity implements View.OnClickListener {
    ImageButton atras;
    Button cerrar;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String a = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().hide(); //Esconder la barrita de arriba
        TextView user;

        user = (TextView) findViewById(R.id.nomperfil);

         sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = sp.edit();
        a = sp.getString("username", "Beatriz");
        edit.apply();

        user.setText(a);
        atras = (ImageButton) findViewById(R.id.atrasbuton);
        cerrar=(Button)findViewById(R.id.cerrrarsesion) ;
        atras.setOnClickListener(this);
        cerrar.setOnClickListener(this);
    }
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.atrasbuton:
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.cerrrarsesion:
                    SharedPreferences.Editor edit = sp.edit();
                    edit.remove("username");
                    edit.commit();
                    Intent a = new Intent(this, MainActivity.class);
                    startActivity(a);
                    break;
                default:
                    break;
            }
        }



}
