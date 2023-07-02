package com.pucpr.alertaja.controlles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.view.Window;

import com.pucpr.alertaja.R;
import com.pucpr.alertaja.model.DataModel;
import com.pucpr.alertaja.model.Event;

public class EventDetails extends AppCompatActivity {
    EditText editText1,editText2,editText3,editText4;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        editText1 = findViewById(R.id.textView7);
        editText2 = findViewById(R.id.textView9);
        editText3 = findViewById(R.id.textView10);
        editText4 = findViewById(R.id.textView11);
    }

    @Override
    public void onBackPressed() {
    String name = editText1.getText().toString();
    String data = editText4.getText().toString();
    String local = editText3.getText().toString();
    String descricao = editText2.getText().toString();

    if(name.length() > 1 && data.length() > 1 && local.length() > 1 && descricao.length() > 1){
            DataModel.getInstance().addEvent(
                    new Event(name,data,local,descricao));
        finish();
    } else {
        AlertDialog.Builder builder = new AlertDialog.Builder(EventDetails.this);
        builder.setTitle(R.string.attention);
        builder.setMessage(R.string.empty_contact_alert_msg);

        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton(android.R.string.no, null);
        builder.create().show();
    }
    }
}