package com.mobdev.hellocoordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Marco Picone (picone.m@gmail.com) 20/03/2020
 * Simple Activity and application to show how to use CoordinatorLayout, Snackbars and Floating
 * Action Buttons.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private CoordinatorLayout coordinatorLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.coordinatorLayout = (CoordinatorLayout)findViewById(R.id.myCoordinatorLayout);

        Button triggerButton = (Button)findViewById(R.id.triggerButton);
        triggerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackBar(coordinatorLayout);
            }
        });

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Floating Action Button Clicked !");
            }
        });
    }

    private void showSnackBar(View view){

        if(view == null)
            return;

        Snackbar mySnackbar = Snackbar.make(view, R.string.snackbarText,  Snackbar.LENGTH_LONG)
            .setAction(R.string.undo, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Snackbar action clicked !");
            }
        });
        mySnackbar.show();
    }
}
