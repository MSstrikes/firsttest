package com.testforhome.david.floatingbtntest;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, com.testforhome.david.floatingbtntest.DialogFragment.showText{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        com.github.clans.fab.FloatingActionButton timerFloatingbt = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.gitbutton);
        com.github.clans.fab.FloatingActionButton timerFloatingbt2 = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.gitbutton2);
        FloatingActionButton timerFloatingbt3 = (FloatingActionButton)findViewById(R.id.gitbutton3);
        timerFloatingbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.testforhome.david.floatingbtntest.DialogFragment dialog = new com.testforhome.david.floatingbtntest.DialogFragment();
                dialog.show(getFragmentManager(),"DialogFragment");
            }
        });
        timerFloatingbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimerFragment timerDialog = new TimerFragment();
                timerDialog.show(getFragmentManager(),"TimerFragment");
            }
        });
        timerFloatingbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControlFragment controlFragment = new ControlFragment();
                controlFragment.show(getFragmentManager(),"ControlFragment");
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        }else if(id == R.id.action_about){
            Toast.makeText(MainActivity.this,"about",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(MainActivity.this,"Gallery",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showText(String text) {
        Toast.makeText(MainActivity.this,text,Toast.LENGTH_SHORT).show();
    }
}
