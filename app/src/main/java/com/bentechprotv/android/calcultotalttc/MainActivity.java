package com.bentechprotv.android.calcultotalttc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button _btnTTC, _btnVid;
    TextView _txtTVA, _txtTTC;
    EditText _edtHT, _edtTVA, _edtQte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnTTC = (Button) findViewById(R.id.btnTTC);
        _btnVid = (Button) findViewById(R.id.btnVid);
        _txtTVA = (TextView) findViewById(R.id.txtTVA);
        _txtTTC = (TextView) findViewById(R.id.txtTTC);
        _edtHT = (EditText) findViewById(R.id.edtHT);
        _edtTVA = (EditText) findViewById(R.id.edtTVA);
        _edtQte = (EditText) findViewById(R.id.edtQte);

        _txtTTC.setVisibility(View.INVISIBLE);

        _btnTTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (_edtHT.getText().toString().equals("")){
                   //version correcte
                    Toast.makeText(getApplicationContext(),R.string.edtHT_Vide, Toast.LENGTH_LONG).show();
                    //version erronée
                  //  Toast.makeText(getApplicationContext(),"test", Toast.LENGTH_LONG).show();
                    return;
                } else if (Float.valueOf(_edtHT.getText().toString())<0.0){
                    _edtHT.setText("0");
                }
                if (Float.valueOf(_edtTVA.getText().toString())<0.0){
                    _edtTVA.setText("0");
                }
                if (_edtQte.getText().toString().equals("")){
                    _edtQte.setText("1");
                }else if (Float.valueOf(_edtQte.getText().toString())<0.0){
                    _edtQte.setText("1");
                }

                Float mTVA, mTTC;
                // Total TTC = (montant HT + (montant HT * (taux tav/100))) * quantité
                //version correcte
                mTTC = (Float.parseFloat(_edtHT.getText().toString()) + Float.parseFloat(_edtHT.getText().toString()) * (Float.parseFloat(_edtTVA.getText().toString())/100)) * Integer.parseInt(_edtQte.getText().toString());
                //version erronée
                //mTTC = Float.parseFloat(_edtHT.getText().toString()) + Float.parseFloat(_edtHT.getText().toString()) * (Float.parseFloat(_edtTVA.getText().toString())/100) ;

                //arondir le résultat: 3 chiffres après la virgule
                DecimalFormat df = new DecimalFormat(("#.000"));
                _txtTTC.setText(df.format(mTTC));
                // Total TVA = (montant HT * (taux tav/100))* quantité
                mTVA =   Float.parseFloat(_edtHT.getText().toString()) * (Float.parseFloat(_edtTVA.getText().toString())/100) * Integer.parseInt(_edtQte.getText().toString());
                _txtTVA.setText(df.format(mTVA));
            }
        });
        _btnVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _txtTTC.setText("");
                _txtTVA.setText("");
                _edtTVA.setText("");
                _edtHT.setText("");
                _edtQte.setText("");

            }
        });

    }
}