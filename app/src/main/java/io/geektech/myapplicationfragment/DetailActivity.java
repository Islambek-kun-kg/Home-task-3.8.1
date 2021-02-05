package io.geektech.myapplicationfragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DetailActivity extends AppCompatActivity {
    private String title, subTitle;
    private int imageView;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private TExtFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra("key");
            subTitle = intent.getStringExtra("keyDesc");
            imageView = intent.getIntExtra("keyImage", 1);
        }
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragment = TExtFragment.newInstance(title, subTitle, imageView);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_second, fragment);
        transaction.commit();
    }
}