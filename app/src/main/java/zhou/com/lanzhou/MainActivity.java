package zhou.com.lanzhou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zhou.com.lanzhou.service.XyftService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(getApplicationContext(),XyftService.class));
    }
}
