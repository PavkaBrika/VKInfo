package com.example.vkinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showRes(View view) {
        EditText searchField = (EditText) findViewById(R.id.edttxt);
        TextView result = (TextView) findViewById(R.id.res);
        String name = searchField.getText().toString();
        if (name.length() == 0) {
            makeToast("Введите имя пользователя");
        }
        else {
            makeToast("Поиск");
            if (name.matches("[0-9]+")) {
                result.setText(makeLinkID(name));
            }
            else if (name.contains(" ") == true) {
                makeToast("Введите правильный");
            }
            else {
                result.setText(makeLinkUserName(name));
            }
        }
    }

    public void makeToast(String text) {
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public String makeLinkID(String id) {
        String link = "https://api.vk.com/method/users.get?user_id=" + id + "&v=5.131&access_token=efdf7579efdf7579efdf7579c9efa5a086eefdfefdf75798e3fe8c23e6c0c22111a1d56";
        return link;
    }

    public String makeLinkUserName(String id) {
        String link = "https://api.vk.com/method/utils.resolveScreenName?screen_name=" + id + "&v=5.131&access_token=efdf7579efdf7579efdf7579c9efa5a086eefdfefdf75798e3fe8c23e6c0c22111a1d56";
        return link;
    }
}