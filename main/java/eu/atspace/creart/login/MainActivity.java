package eu.atspace.creart.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button per, dib;
    private Intent a;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); //Esconder la barrita de arriba
// setup buttons
        per = (Button) findViewById(R.id.miperfil_but);
       dib = (Button) findViewById(R.id.dibujar_but);
        text=(TextView)findViewById(R.id.logintext);
        // register listeners
        per.setOnClickListener(this);
        dib.setOnClickListener(this);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = sp.edit();
        String username = sp.getString("username", "");
        edit.apply();
        if(username.compareTo("")==0){
             a = new Intent(this, Login.class);
                text.setText("Login");
        }else{
            a = new Intent(this, Perfil.class);
            text.setText("Mi perfil");
        }

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.miperfil_but:

                startActivity(a);
                break;
            case R.id.dibujar_but:
                Intent i = new Intent(this, MainDibujar.class);
                startActivity(i);
                break;

            default:
                break;
        }
    }
}
