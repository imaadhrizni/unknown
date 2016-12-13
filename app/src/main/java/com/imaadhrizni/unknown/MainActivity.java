package com.imaadhrizni.unknown;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.imaadhrizni.unknown.Fragments.Category1Fragment;
import com.imaadhrizni.unknown.Fragments.Category2Fragment;
import com.imaadhrizni.unknown.Fragments.DealsFragment;
import com.imaadhrizni.unknown.Fragments.OnFragmentInteractionListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View myInflatedView = LayoutInflater.from(this).inflate(R.layout.fragment_deals, null);
        t = (TextView) myInflatedView.findViewById(R.id.deals_fragment_hello);

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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            MenuItem item = navigationView.getMenu().getItem(0);
            onNavigationItemSelected(item);
        }
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
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_deals) {
            DealsFragment dealsFragment = DealsFragment.newInstance(null, null);
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragments, dealsFragment, dealsFragment.getTag()).commit();
        } else if (id == R.id.nav_category1) {
            Category1Fragment category1Fragment = Category1Fragment.newInstance(null, null);
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragments, category1Fragment, category1Fragment.getTag()).commit();
        } else if (id == R.id.nav_category2) {
            Category2Fragment category2Fragment = Category2Fragment.newInstance(null, null);
            fragmentManager.beginTransaction().replace(R.id.relative_layout_for_fragments, category2Fragment, category2Fragment.getTag()).commit();
        }
//        else if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String tag, Object data) {
        if (tag.equals("DEALS")) {
            Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();
        } else if (tag.equals("CATEGORY1")) {
            Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();
        } else if (tag.equals("CATEGORY2")) {
            Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();
        }
    }
}
