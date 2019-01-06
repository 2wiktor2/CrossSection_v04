package com.wiktor.crosssection_v04;

import android.content.DialogInterface;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.wiktor.crosssection_v04.adapters.MyPagerAdapter;

public class MainActivity extends AppCompatActivity {
    FragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.exit:
                finish();
                break;
            case R.id.reset:
                // todo написать код для кнопки reset
                break;
            case R.id.info:
                createInfoDialog();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createInfoDialog() {
        final AlertDialog.Builder dialogInfo = new AlertDialog.Builder(this);
        dialogInfo.setTitle("Инфо")
                .setMessage(R.string.text_for_Info)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = dialogInfo.create();
        alert.show();
    }
}
