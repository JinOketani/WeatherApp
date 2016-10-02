package example.lightup.weatherapp;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_text;
    private Button button;
    private TextView text_view;
    private ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_text = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);
        text_view = (TextView) findViewById(R.id.text_view);
        list_view = (ListView) findViewById(R.id.list_view);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String place = edit_text.getText().toString();
        String location = getLocation(place);
        Toast.makeText(this, location, Toast.LENGTH_SHORT).show();

    }

    private String getLocation(String place){
        Geocoder geocoder = new Geocoder(this, Locale.JAPAN);
        try{
            List<Address> addressList = geocoder.getFromLocationName(place, 1);
            Address address = addressList.get(0);
            double lng = address.getLongitude();
            double lat = address.getLatitude();
            return lng + "," + lat;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
