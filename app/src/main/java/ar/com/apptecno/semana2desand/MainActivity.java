package ar.com.apptecno.semana2desand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
//Para el refresh indicator
    SwipeRefreshLayout MiIndicator;
    ListView MyList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adFav();
        //No necesitamos instanciar el objeto, no necesito instanciarlo con new
        MiIndicator=(SwipeRefreshLayout) findViewById(R.id.MiIndicator);
        MyList= (ListView) findViewById(R.id.MyList);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        MyList.setAdapter(new ArrayAdapter(this,
                android.R.layout.activity_list_item,
                planetas));
    MiIndicator.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

        }
    });


    }
    public void refrescandoContenido(){
        MyList= (ListView) findViewById(R.id.MyList);
        String[] planetas = getResources().getStringArray(R.array.planetas);
        MyList.setAdapter(new ArrayAdapter(this,
                android.R.layout.activity_list_item,
                planetas));
        MiIndicator.setRefreshing(false);
    }
    public void adFav(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById((R.id.floatbtn));
        miFAB.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("StringFormatInvalid")
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(),getResources().getString(R.string.app_welcome),Toast.LENGTH_LONG).show();
                /*con getResources obtenemos recursos de java*/
                Snackbar.make(v, getResources().getString(R.string.app_welcome), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.app_select), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "Click en Snackbar"); //Se despliega el texto en logcat
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.color_prim))
                        .show();

            }
        });
    }


}