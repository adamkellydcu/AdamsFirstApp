package com.example.adamkelly.adamsfirstapp;

//package com.tutorials.hp.mysqlinsert;

// THIS IS MY TEST CODE from gitbub 2
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import java.io.IOException;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;



        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;

        import java.net.InetAddress;
        import java.net.NetworkInterface;
        import java.net.SocketException;
        import java.net.UnknownHostException;
        import java.util.Collections;
        import java.util.List;

/*
1.OUR LAUNCHER ACTIVIT
2.INITIALIZE SOME UI STUFF
3.WE START SENDER ON BUTTON CLICK
 */
public class MainActivity extends AppCompatActivity {

    String urlAddress = "http://student.computing.dcu.ie/~kella256/phpcode.php";
    EditText nameTxt, posTxt, teamTxt, macTxt;
    Button saveBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //INITIALIZE UI FIELDS
        nameTxt = (EditText) findViewById(R.id.nameEditTxt);
        posTxt = (EditText) findViewById(R.id.posEditTxt);
        teamTxt = (EditText) findViewById(R.id.teamEditTxt);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        macTxt= (EditText)findViewById(R.id.macEditTxt);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //START ASYNC TASK
                com.example.adamkelly.adamsfirstapp.Sender s = new com.example.adamkelly.adamsfirstapp.Sender(MainActivity.this, urlAddress, nameTxt, posTxt, teamTxt, macTxt);
                s.execute();
            }
        });

        String macAddFromPhone=getMacAddr();
        String res2=macAddFromPhone.toString();
        Log.i("macaddress",res2);
        macTxt.setText(res2);

    }


    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    // res1.append(Integer.toHexString(b & 0xFF) + ":");
                    res1.append(String.format("%02X:",b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                //String res2=res1.toString();
                //Log.i("macaddress",res2);
                return res1.toString();



            }
        } catch (Exception ex) {
            //handle exception
        }
        return "";
    }


    //INITIALIZE UI FIELDS
    ////EditText nameTxt= (EditText) findViewById(R.id.nameEditTxt);

    //
    // nameTxt.setText(macAddFromPhone);
}













































/**
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final TextView adamtextview = (TextView) findViewById(R.id.adamtextview);

        Button btn = (Button) findViewById(R.id.btnDoMagic);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyApp", "This is a magic log message!");
                adamtextview.setText("This is the text appearing");
            }
        });

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
}
**/
