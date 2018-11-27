package eu.atspace.creart.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainDibujar extends AppCompatActivity  implements View.OnClickListener{

    private PaintView paintView;
    int mDefault;
    Button mbutton;
    ImageButton botona,botonz,botonv,botonr,botonn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujar);
        paintView = (PaintView) findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);
        mDefault = paintView.getColor();
        mbutton = (Button)findViewById(R.id.mascolores);
        mbutton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.normal:
                paintView.normal();
                return true;
            case R.id.emboss:
                paintView.emboss();
                return true;
            case R.id.blur:
                paintView.blur();
                return true;
            case R.id.clear:
                paintView.clear();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        int color = 0;

        switch (v.getId()){
            case R.id.colornegro:
                color = Color.BLACK;
                paintView.setColorillo(color);

                break;
            case R.id.coloramarillo:
                color = Color.YELLOW;
                paintView.setColorillo(color);

                break;
            case R.id.colorazul:
                color = Color.CYAN;
                paintView.setColorillo(color);
                break;
            case R.id.colorverde:
                color = Color.GREEN;
                paintView.setColorillo(color);
                break;
            case R.id.colorrojo:
                color = Color.RED;
                paintView.setColorillo(color);
                break;
            case R.id.mascolores:
                opencolorpick();
                break;


        }
    }
    public void opencolorpick(){
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefault, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                paintView.setColorillo(color);
            }
        });
        colorPicker.show();
    }
}