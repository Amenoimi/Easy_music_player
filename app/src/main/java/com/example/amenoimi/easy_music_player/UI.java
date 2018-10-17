package com.example.amenoimi.easy_music_player;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.amenoimi.easy_music_player.*;

public class UI {
    public Button b1,b2,b3;
    public SurfaceView mSurfaceView;
    public SurfaceHolder mSurfaceHolder;
    public SeekBar sb;
    public TextView t1;
    UI(MainActivity main){
        b1=(Button) main.findViewById(R.id.b1);
        b2=(Button) main.findViewById(R.id.b2);
        b3=(Button) main.findViewById(R.id.b3);
        mSurfaceView = (SurfaceView)main. findViewById(R.id.surfaceView);
        mSurfaceHolder =  mSurfaceView.getHolder();
        sb=(SeekBar) main.findViewById(R.id.sb);
        t1=(TextView)main.findViewById(R.id.t1);
    }
}
