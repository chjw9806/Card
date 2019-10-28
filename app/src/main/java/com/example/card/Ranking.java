package com.example.card;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Ranking extends AppCompatActivity {
    double initTime;
    TextView tvE1, tvE2, tvE3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        setTitle("Ranking");

        tvE1 = (TextView) findViewById(R.id.tvE1);
        tvE2 = (TextView) findViewById(R.id.tvE2);
        tvE3 = (TextView) findViewById(R.id.tvE3);

        easyTime(Easy.time);
    }

    public void easyTime(String eTime){
        tvE1.setText("1등 " + eTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.rank, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itemRank) {
            Intent intent = new Intent(getApplicationContext(), Ranking.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime > 3000) {//처음 누른 상태
                Toast.makeText(getApplicationContext(), "홈 화면으로 돌아가려면 한 번 더 눌러주세요", Toast.LENGTH_SHORT).show();

                initTime = System.currentTimeMillis();
            } else {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        return false;
    }
}
