package dougherty.project1_tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.EditText;

import java.text.*;

public class MainActivity extends AppCompatActivity implements OnEditorActionListener{

    // define the widgets
    private EditText fahrenheitET;
    private TextView celsiusTV;

    // define the instance variables
    private String fahrenheitString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fahrenheitET = (EditText) findViewById(R.id.fahrenheitET);
        celsiusTV = (TextView) findViewById(R.id.celsiusTV);

        fahrenheitET.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        if(actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {

            convertTemp();

        }

        return false;
    }

    private void convertTemp() {

        // get Fahrenheit from user
        fahrenheitString = fahrenheitET.getText().toString();
        double fahrenheit;

        if(fahrenheitString.equals("")) {

            fahrenheit = 0.0;
        }
        else {

            fahrenheit = Double.parseDouble(fahrenheitString);
        }

        // convert temperature from Fahrenheit to Celsius
        double celsius = (fahrenheit - 32) * 5/9;

        // display the temperature in Celsius
        DecimalFormat degree = new DecimalFormat("0.0");
        celsiusTV.setText(degree.format(celsius));

    }

}
