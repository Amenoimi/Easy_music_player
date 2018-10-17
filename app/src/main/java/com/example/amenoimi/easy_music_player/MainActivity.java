package com.example.amenoimi.easy_music_player;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.amenoimi.easy_music_player.msg;

import java.io.IOError;
import java.io.IOException;


public class MainActivity extends AppCompatActivity implements  SurfaceHolder.Callback,View.OnClickListener,SeekBar.OnSeekBarChangeListener {

   private   Canvas canvas=new Canvas();
    private Thread mThread;
    private Paint mpaint;
    private  UI ui;
    private boolean ame_flag=false;
    private MediaPlayer  mediaPlayer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui=new UI(this);
        ui.mSurfaceView.setZOrderOnTop(true);//处于顶层
        ui.mSurfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
        ui.mSurfaceHolder.addCallback(this);
        ui.b1.setOnClickListener(this);
        ui.b2.setOnClickListener(this);
        ui.b3.setOnClickListener(this);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        ame_flag = true;
        //定义画笔
        mpaint = new Paint();
        mpaint.setColor(Color.BLUE);
        // mpaint.setAntiAlias(true);//去锯齿
        mpaint.setStyle(Paint.Style.STROKE);//空心
        // 设置paint的外框宽度
        mpaint.setStrokeWidth(20f);
        mThread = new Thread(r1);
        mThread.start();


    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        ame_flag = false;
    }


    private Runnable r1=new Runnable () {

        public void run() {

            // TODO Auto-generated method stub

            while (ame_flag){
                try{
                    Thread.sleep(17);


//                    ui.sb.setProgress(mediaPlayer. getCurrentPosition()+1);

//                    ui.sb.setProgress(10);
                    ui.sb.setMax(mediaPlayer.getDuration());
//                    ui.sb.setProgress(10);
                    ui.sb.setProgress(mediaPlayer. getCurrentPosition());

                    canvas =  ui.mSurfaceHolder.lockCanvas();
                    if(ame_flag) {
                        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR); //清楚掉上一次的画框。
                        //繪圖區
                        mpaint.setStrokeWidth(20f);

                        Matrix m = new Matrix();
                        mpaint.setColor(Color.parseColor("#FF1493"));
                        mpaint.setStyle(Paint.Style.FILL);//設置填滿
                        int n = 50;
                        int w = canvas.getWidth() / n;
                        int tmp = rnd(500);
                        for (int i = 0; i < n; i++) {
                            mpaint.setColor(Color.rgb(rnd(255), rnd(255), rnd(255)));
                            canvas.drawLine(w * i, canvas.getHeight(), w * i, canvas.getHeight() - (tmp * (float) (Math.sin(rnd(360)))), mpaint);
                        }




// 奇怪的圖形
//                    Bitmap img = BitmapFactory.decodeResource(MainActivity.this.getResources(),
//                            R.drawable.rect);
//
//
//                    int tmp=rnd(255);
//                    canvas.drawBitmap(bitmap_set(img,img.getWidth(),1+tmp,rnd(255),rnd(255),rnd(255),255,0),500,555-tmp,mpaint);
//
//
//                    tmp=rnd(255);
//                    canvas.drawBitmap(bitmap_set(img,img.getWidth(),1+tmp,rnd(255),rnd(255),rnd(255),255,45),555,610-tmp,mpaint);
//
//                    tmp=rnd(255);
//                    canvas.drawBitmap(bitmap_set(img,img.getWidth(),1+rnd(255),rnd(255),rnd(255),rnd(255),255,0),500,610,mpaint);
//
//
//                    tmp=rnd(255);
//                    canvas.drawBitmap(bitmap_set(img,img.getWidth(),1+rnd(255),rnd(255),rnd(255),rnd(255),255,135),555,555,mpaint);
//
//
//
//                    tmp=rnd(255);
//                    canvas.drawBitmap(bitmap_set(img,1+tmp,img.getHeight(),rnd(255),rnd(255),rnd(255),255,0),500-tmp,555,mpaint);
//
//                    tmp=rnd(255);
//                    canvas.drawBitmap(bitmap_set(img,1+tmp,img.getHeight(),rnd(255),rnd(255),rnd(255),255,-45),500-tmp,555,mpaint);
//
//                    tmp=rnd(255);
//                    canvas.drawBitmap(bitmap_set(img,1+tmp,img.getHeight(),rnd(255),rnd(255),rnd(255),255,0),555,555,mpaint);
//
//                    tmp=rnd(255);
//                    canvas.drawBitmap(bitmap_set(img,1+tmp,img.getHeight(),rnd(255),rnd(255),rnd(255),255,45),545-tmp,565-tmp,mpaint);

//圓形
//                    mpaint.setColor(Color.rgb(rnd(255),rnd(255),rnd(255)));
//                    canvas.drawCircle(555,1300,300,mpaint);
//                    int c=rnd(360);
//                    int n=20;
//                    int cc=360/n;x
//                    mpaint.setStrokeWidth(50f);
//                    for(int i= 0;i<n;i++) {
//                        tmp = rnd(100);
//                        int l=tmp;
//                        int t=tmp;
//                        if(Math.cos(cc*(i+1))<0)l=-l;
//                        if(Math.sin(cc*(i+1))<0)t=-t;
//                        canvas.drawLine(555, 1300, 555 + (float) (360 * Math.cos(cc*(i+1))) + l, 1300 + (float) (360 * Math.sin(cc*(i+1))) + t, mpaint);
//                    }


                        ui.mSurfaceHolder.unlockCanvasAndPost(canvas);
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    };

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {



            super.handleMessage(msg);
        }
    };



    public static Bitmap bitmap_set(Bitmap bmp, int w, int h,int r,int g,int b,int a,int angle) {
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] pixels = new int[width * height];
        bmp.getPixels(pixels, 0, width, 0, 0, width, height);
        int alpha = 0xFF << 24;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int grey = pixels[width * i + j];
                // 分離三原色
                alpha = ((grey & 0xFF000000) >> 24);
                int red = ((grey & 0x00FF0000) >> 16);
                int green = ((grey & 0x0000FF00) >> 8);
                int blue = (grey & 0x000000FF);
                red = r;
                blue = g;
                green = b;
                alpha=a;
                pixels[width * i + j] = alpha << 24 | red << 16 | green << 8
                        | blue;

            }
        }
        Bitmap newBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        newBmp.setPixels(pixels, 0, width, 0, 0, width, height);
        Bitmap resizeBmp = ThumbnailUtils.extractThumbnail(newBmp, w, h);

        Matrix matrix  = new Matrix();
        matrix.setRotate(angle);
        resizeBmp = Bitmap.createBitmap(resizeBmp,0,0,resizeBmp.getWidth(),resizeBmp.getHeight(),matrix,true);

        return resizeBmp;
    }

    public  int rnd(int r){
       return (int)(Math.random()* r);
    }


    @Override
public boolean onKeyDown(int keyCode, KeyEvent event) {


        // 判斷是否按下Back
      if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 是否要退出
          new msg().Show(this,"離開","");


      }
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            ame_flag=false;
        }
      return false;

}
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        // 有選擇檔案
        if ( resultCode == RESULT_OK )
        {
            // 取得檔案的 Uri
            Uri uri = data.getData();

            try {
                mediaPlayer.setDataSource(url_get.getMediaAbsolutePath(this,uri));
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.b1)mediaPlayer.start();
        if(v.getId()==R.id.b2)mediaPlayer.pause();
        if(v.getId()==R.id.b3){
            url_get.load(this);

        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mediaPlayer.seekTo(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
