package com.example.amenoimi.easy_music_player;

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
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity implements  SurfaceHolder.Callback{

    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    private   Canvas canvas=new Canvas();
    private Thread mThread;
    private Paint mpaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceView.setZOrderOnTop(true);//处于顶层
        mSurfaceHolder.setFormat(PixelFormat.TRANSLUCENT);
        mSurfaceHolder.addCallback(this);


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
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

    }


    private Runnable r1=new Runnable () {

        public void run() {

            // TODO Auto-generated method stub

            while (true){
                try{
                    Thread.sleep(17);





                    canvas =  mSurfaceHolder.lockCanvas();
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR); //清楚掉上一次的画框。
                    //繪圖區
                    mpaint.setStrokeWidth(20f);

                    Matrix m = new Matrix();
                    mpaint.setColor(Color.parseColor("#FF1493"));
                    mpaint.setStyle(Paint.Style.FILL);//設置填滿
                    int n=50;
                    int w=canvas.getWidth()/n;
                    int tmp=rnd(500);
                    for(int i= 0;i<n;i++) {
                        mpaint.setColor(Color.rgb(rnd(255),rnd(255),rnd(255)));
                        canvas.drawLine(w*i, canvas.getHeight(), w*i, canvas.getHeight()-(tmp*(float)(Math.sin(rnd(360)))), mpaint);
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


                    mSurfaceHolder.unlockCanvasAndPost(canvas);



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

}