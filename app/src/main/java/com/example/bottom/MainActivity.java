package com.example.bottom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity implements ChipNavigationBar.OnItemSelectedListener {
ChipNavigationBar b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(ChipNavigationBar)findViewById(R.id.bottom);
        getSupportFragmentManager().beginTransaction().replace(R.id.f1,new BlankFragment()).commit();
        b.setOnItemSelectedListener(this);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public boolean onCreateOptionMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_bottom,menu);
        return true;
    }

    @Override
    public void onItemSelected(int i) {
        Fragment f=null;
        switch (i)
        {
            case R.id.home_section:
                f=new BlankFragment();
                break;
            case R.id.chat_section:
                f=new chat();
                break;
            case R.id.movie_section:
                f=new movie();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.f1,f).commit();

    }
}