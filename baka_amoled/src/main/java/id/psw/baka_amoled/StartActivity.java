package id.psw.baka_amoled;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import id.psw.baka_amoled.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemSelectedListener;

public class StartActivity extends Activity {
    private int activeModeIndex = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Spinner spn = (Spinner)findViewById(R.id.spn_display_model);
        String[] types = getResources().getStringArray(R.array.screen_type);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, types);
        spn.setAdapter(adp);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> p, View v, int pos, long id){
                activeModeIndex = pos;
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> a){
                activeModeIndex = 0;
            }
        });
        Button btn = (Button) findViewById(R.id.spn_open);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                    Intent i = new Intent(StartActivity.this, ColorActivity.class);
                    i.putExtra("mode", activeModeIndex);
                    startActivity(i);
            }
        });
    }
}
