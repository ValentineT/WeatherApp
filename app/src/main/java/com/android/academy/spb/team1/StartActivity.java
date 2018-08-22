package com.android.academy.spb.team1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {


    //меню====================================
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }*/

    //обработка нажатия пункта меню
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) showInputDialog();
        return true;
    }*/

    //=========================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(StartActivity.this)
                        .setTitle(R.string.pick_item)
                        //тут меню из массива 2 строк
                        .setItems(R.array.pick_city_items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                switch (which){

                                    case 0:
                                        //вызов MainActivity из StartActivity через intent, если выбран
                                        //пункт массива 1
                                        Intent intent = new Intent(StartActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        break;

                                    case 1:
                                        //вызвать меню ручного ввода если выбран пункт 2, после передать значение этого
                                        // поля(город) в MainActivity, вроде все просто, но я в рот ебал
                                        // пока хз как) оно уже еть тут
                                    {
                                        final AlertDialog d = new AlertDialog.Builder(StartActivity.this).create();
                                        //вызов диалого поля ввода города
                                        showInputDialog();}
                                        //нужна проверка нажатия кнопки ОК в диалоговом окне
                                        //если да то вывести мейнактивити с передачей туда города
                                        //


                               Toast.makeText(getApplicationContext(),"cityName"+"  Выбери город:",Toast.LENGTH_SHORT).show();


                                    //вызов MainActivity
                                    Intent intent2 = new Intent(StartActivity.this, MainActivity.class);
                                    startActivity(intent2);

                                break;
                              }
                         }
                        })
                        .show();
            }
        });
    }
    //показать диалог выбора города
    private void showInputDialog() {
        AlertDialog.Builder chooseCity = new AlertDialog.Builder(this);
        chooseCity.setIcon(R.mipmap.ic_launcher);
        chooseCity.setTitle(R.string.choose_city);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        chooseCity.setView(input);
        chooseCity.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String cityName = input.getText().toString();

            }
        });
        chooseCity.show();
    }
}
