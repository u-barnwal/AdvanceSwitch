package com.isolpro.advanceswitchlibrary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.isolpro.library.advanceswitch.AdvanceSwitch;

public class MainActivity extends AppCompatActivity {

  private AdvanceSwitch switchMain;
  private Button btnChangeSwitch;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    switchMain = findViewById(R.id.switchMain);
    btnChangeSwitch = findViewById(R.id.btnChangeSwitch);

    // + Adding listener to AdvanceSwitch
    switchMain.setOnCheckedChangeListener((buttonView, isChecked) ->
      Toast.makeText(this, "Listened to change!", Toast.LENGTH_SHORT).show()
    );

    // * Calling toggle() here will trigger the callback where toggleManually won't
    btnChangeSwitch.setOnClickListener(v -> switchMain.toggleManually());

    // btnChangeSwitch.setOnClickListener(v -> switchMain.setCheckedManually(true));
  }
}