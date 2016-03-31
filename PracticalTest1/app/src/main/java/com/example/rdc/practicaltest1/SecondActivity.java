package com.example.rdc.practicaltest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements Button.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.Ok_act2:
                    setResult(RESULT_OK, new Intent());
                    finish();
                    break;
                case R.id.Cancel_act2:
                    setResult(RESULT_CANCELED, new Intent());
                    finish();
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView summ_text = (TextView)findViewById(R.id.SUM_activity2);
        Intent intent = getIntent();

        if(intent != null){
            String sum = intent.getStringExtra("number_of_clicks");
            if(sum != null)
                summ_text.setText(sum);
        }

        Button b_cancel , b_ok;
        b_cancel = (Button)findViewById(R.id.Cancel_act2);
        b_ok     = (Button)findViewById(R.id.Ok_act2);

        b_cancel.setOnClickListener(buttonClickListener);
        b_ok.setOnClickListener(buttonClickListener);

    }
}
