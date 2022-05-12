package com.example.testmoi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class settingActivity extends AppCompatActivity {

    TextView changeFont;
    Button btnFontStyle;

    private static final String SHARED_PREF_NAME="MyPref";
    private static final String KEY_FONT_STYLE="FontStyle";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    final String[] stylelist = new  String[]{"Normal","Bold","Italic","Bold Italic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        editor = sharedPreferences.edit();
        changeFont= findViewById(R.id.txt);
        btnFontStyle= findViewById(R.id.button);

        btnFontStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFontStyle();
            }
        });
        int intFontStyle=sharedPreferences.getInt(KEY_FONT_STYLE,0);

        if (intFontStyle==0){
            changeFont.setTypeface(null, Typeface.NORMAL);
        }  else if(intFontStyle==1){
            changeFont.setTypeface(changeFont.getTypeface(),Typeface.BOLD);
        }  else if(intFontStyle==2){
            changeFont.setTypeface(changeFont.getTypeface(),Typeface.ITALIC);
        }  else if(intFontStyle==3){
            changeFont.setTypeface(changeFont.getTypeface(),Typeface.BOLD_ITALIC);
        }
        btnFontStyle.setText(stylelist[intFontStyle]);

    }

    private void changeFontStyle() {
        final String[] stylelist = new  String[]{"Normal","Bold","Italic","Bold Italic"};
        AlertDialog.Builder builder = new AlertDialog.Builder(settingActivity.this);
        builder.setTitle("Change Font Style");
        builder.setItems(stylelist, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                if (position==0){
                    changeFont.setTypeface(null, Typeface.NORMAL);
                }  else if(position==1){
                    changeFont.setTypeface(changeFont.getTypeface(),Typeface.BOLD);
                }  else if(position==2){
                changeFont.setTypeface(changeFont.getTypeface(),Typeface.ITALIC);
                }  else if(position==3){
                changeFont.setTypeface(changeFont.getTypeface(),Typeface.BOLD_ITALIC);
                }
                btnFontStyle.setText(stylelist[position]);
                editor.putInt(KEY_FONT_STYLE,position);
                editor.apply();

            }
        });
        builder.show();

    }
}