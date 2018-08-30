package com.example.amenoimi.easy_music_player;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.example.amenoimi.easy_music_player.*;
public class msg {

    //三個按鈕的對話方塊展示

    public void Show(MainActivity main,String Title,String Message)

    {

        AlertDialog.Builder MyAlertDialog = new AlertDialog.Builder(main);

        MyAlertDialog.setTitle(Title);

        MyAlertDialog.setMessage(Message);

        //建立按下按鈕


        MyAlertDialog.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });


//        MyAlertDialog.setPositiveButton("取消",OkClick );

//        MyAlertDialog.setNeutralButton("中間按鈕",OkClick );

//        MyAlertDialog.setNegativeButton("離開",OkClick );

        MyAlertDialog.setNegativeButton("離開", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                System.exit(0);
            }
        });

        MyAlertDialog.show();

    }
}
