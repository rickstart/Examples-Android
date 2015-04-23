package com.mobintum.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    String oper1="", oper2="";
    boolean flagOper=true;



    Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eigthBtn, nineBtn,zeroBtn,
    plusBtn, substractionBtn, divisionBtn, sumBtn, dotBtn, equalBtn, ceBtn, deleteBtn ;

    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText  = (TextView) findViewById(R.id.resultText);
        oneBtn = (Button) findViewById(R.id.oneBtn);
        twoBtn = (Button) findViewById(R.id.twoBtn);
        threeBtn = (Button) findViewById(R.id.threeBtn);
        fourBtn = (Button) findViewById(R.id.fourBtn);
        fiveBtn = (Button) findViewById(R.id.fiveBtn);
        sixBtn = (Button) findViewById(R.id.sixBtn);
        sevenBtn = (Button) findViewById(R.id.sevenBtn);
        eigthBtn = (Button) findViewById(R.id.eightBtn);
        nineBtn = (Button) findViewById(R.id.nineBtn);
        zeroBtn = (Button) findViewById(R.id.zeroBtn);
        sumBtn = (Button) findViewById(R.id.sumBtn);
        substractionBtn = (Button) findViewById(R.id.substractionBtn);
        plusBtn = (Button) findViewById(R.id.plusBtn);
        divisionBtn = (Button) findViewById(R.id.divisionBtn);
        dotBtn = (Button) findViewById(R.id.dotBtn);
        ceBtn = (Button) findViewById(R.id.ceBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        equalBtn = (Button) findViewById(R.id.equalBtn);

        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eigthBtn.setOnClickListener(this);
        nineBtn.setOnClickListener(this);
        zeroBtn.setOnClickListener(this);
        sumBtn.setOnClickListener(this);
        substractionBtn.setOnClickListener(this);
        plusBtn.setOnClickListener(this);
        divisionBtn.setOnClickListener(this);
        dotBtn.setOnClickListener(this);
        ceBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        equalBtn.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int sum=0;
        switch (v.getId()){

            case R.id.sumBtn:

                if (!resultText.getText().equals("")){

                    if(!oper1.equals("")){

                        oper2 = resultText.getText().toString();
                        
                        sum = Integer.valueOf(oper1) + Integer.valueOf(oper2);
                        resultText.setText(Integer.toString(sum));
                        oper1=resultText.getText().toString();
                        oper2="";
                        flagOper = false;

                    }else{
                        oper1 = resultText.getText().toString();
                        resultText.setText("");

                    }

                }


                break;

            case R.id.ceBtn:

                resultText.setText("");
                oper1="";
                oper2="";
                flagOper=true;
                break;

            case R.id.deleteBtn:
                if(resultText.getText().toString().length()>1) {
                    String aux = resultText.getText().toString();
                    aux = aux.substring(0, aux.length() - 1);
                    resultText.setText(aux);
                }

                break;


            default:
                if(flagOper) {
                    Button btnaux = (Button) findViewById(v.getId());
                    resultText.append(btnaux.getText());
                }else{

                    Button btnaux = (Button) findViewById(v.getId());
                    resultText.setText(btnaux.getText());
                    flagOper=true;
                }
                break;

        }



    }
}
