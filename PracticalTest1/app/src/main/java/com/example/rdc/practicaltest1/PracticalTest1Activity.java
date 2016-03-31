package com.example.rdc.practicaltest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class PracticalTest1Activity extends AppCompatActivity {
    private final static int SECOND_ACTIVITY_CODE = 1;
    protected void onSaveInstanceState(Bundle savedInstaceState){

        EditText left_text = (EditText)findViewById(R.id.leftText);
        EditText right_text = (EditText)findViewById(R.id.RightText);

        savedInstaceState.putString("leftCount", left_text.getText().toString());
        savedInstaceState.putString("rightCount", right_text.getText().toString());
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {

            EditText left_Text = (EditText)findViewById(R.id.leftText);
            EditText right_Text = (EditText)findViewById(R.id.RightText);

            switch (v.getId()){
                case R.id.Left_button:
                    left_Text.setText(String.valueOf(Integer.parseInt(left_Text.getText().toString())+1));
                    break;
                case R.id.Right_button:
                    right_Text.setText(String.valueOf(Integer.parseInt(right_Text.getText().toString())+1));
                    break;
                case R.id.go_to_activity2_button:
                    Intent intent = new Intent("android.intent.action.SecondActivity");
                    int sum = Integer.parseInt(left_Text.getText().toString()) +
                              Integer.parseInt(right_Text.getText().toString());
                    intent.putExtra("number_of_clicks",String.valueOf(sum));
                    startActivityForResult(intent, SECOND_ACTIVITY_CODE);
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test1);

        EditText left_Text = (EditText)findViewById(R.id.leftText);
        EditText right_Text = (EditText)findViewById(R.id.RightText);
        Button b1 = (Button)findViewById(R.id.Left_button);
        Button b2 = (Button)findViewById(R.id.Right_button);
        Button bAct2 = (Button)findViewById(R.id.go_to_activity2_button);

        left_Text.setText(String.valueOf(0));
        right_Text.setText(String.valueOf(0));

        b1.setOnClickListener(buttonClickListener);
        b2.setOnClickListener(buttonClickListener);
        bAct2.setOnClickListener(buttonClickListener);

    }

    @Override
    public void onActivityResult(int requstCode, int resultCode, Intent intent){
        Toast.makeText(this,"The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();

    }

    @Override
    protected  void onRestoreInstanceState(Bundle savedInstanceState){

        EditText left_Text = (EditText)findViewById(R.id.leftText);
        EditText right_Text = (EditText)findViewById(R.id.RightText);

        if (savedInstanceState != null){
            String leftCount  = savedInstanceState.getString("leftCount");
            String rightCount = savedInstanceState.getString("rightCount");
            if(leftCount != null)
                left_Text.setText(leftCount);
            else
                left_Text.setText(String.valueOf(0));

            if(rightCount != null)
                left_Text.setText(rightCount);
            else
                left_Text.setText(String.valueOf(0));

        }
        else{
            left_Text.setText(String.valueOf(0));
            right_Text.setText(String.valueOf(0));
        }
    }
}
