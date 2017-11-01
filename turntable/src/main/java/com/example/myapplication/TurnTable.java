package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/10/26.
 */

public class TurnTable extends View implements View.OnTouchListener {

    private Paint mPaint;
    private float downX;
    private float downY;
    private int position;
    public float mdegree = 0;//图片旋转角度，初始化为0

    private Matrix matrix = new Matrix();//用来旋转图片的矩阵

    public TurnTable(Context context) {
        this(context, null);
    }

    public TurnTable(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TurnTable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();

        setOnTouchListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mdegree!=0){
            switch (position) {
                case 1:
                    canvas.rotate(mdegree,500,500);
                    canvas.save();
                    mPaint.setStyle(Paint.Style.FILL);
                    mPaint.setColor(Color.BLACK);
                    canvas.drawCircle(500, 500, 350, mPaint);
                    mPaint.setColor(Color.BLUE);
                    canvas.drawCircle(500, 500, 250, mPaint);
                    mPaint.setColor(Color.YELLOW);
                    canvas.drawCircle(500, 500, 150, mPaint);
                    mPaint.setColor(Color.BLACK);
                    mPaint.setTextSize(50);
                    canvas.drawText("测试",500-50,500,mPaint);
                    mPaint.setColor(Color.WHITE);
                    mPaint.setTextSize(35);
                    drawOne(canvas,mdegree);
                    drawTwo(canvas,mdegree);
                    break;
                case 2:
                    canvas.rotate(mdegree,500,500);
                    canvas.save();

                    mPaint.setStyle(Paint.Style.FILL);
                    mPaint.setColor(Color.BLACK);
                    canvas.drawCircle(500, 500, 350, mPaint);
                    mPaint.setColor(Color.BLUE);
                    canvas.drawCircle(500, 500, 250, mPaint);
                    mPaint.setColor(Color.YELLOW);
                    canvas.drawCircle(500, 500, 150, mPaint);
                    mPaint.setColor(Color.BLACK);
                    mPaint.setTextSize(50);
                    canvas.drawText("测试",500-50,500,mPaint);
                    mPaint.setColor(Color.WHITE);
                    mPaint.setTextSize(35);
                    drawOne(canvas,mdegree);
                    drawTwo(canvas,mdegree);
                    break;
            }
        }else{
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(Color.BLACK);
            canvas.drawCircle(500, 500, 350, mPaint);
            mPaint.setColor(Color.BLUE);
            canvas.drawCircle(500, 500, 250, mPaint);
            mPaint.setColor(Color.YELLOW);
            canvas.drawCircle(500, 500, 150, mPaint);
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(50);
            canvas.drawText("测试",500-50,500,mPaint);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(35);
            drawOne(canvas, mdegree);
            drawTwo(canvas, mdegree);
        }



    }

    private void drawTwo(Canvas canvas, float mdegree) {
        if (mdegree == 0){
            for (int i = 0; i < 6; i++) {
                canvas.drawText("热菜"+i, 500, 500 - 250 + 75, mPaint);
                canvas.save();
                canvas.rotate(360 / 6, 500, 500);
            }
        }else{
            for (int i = 0; i < 6; i++) {
                canvas.drawText("热菜"+i, 500, 500 - 250 + 75, mPaint);
                canvas.save();
                canvas.rotate(360 / 6, 500, 500);
            }
            canvas.rotate(mdegree,500,500);
        }
    }

    private void drawOne(Canvas canvas, float mdegree) {
        if (mdegree == 0){
            for (int i = 0; i < 12; i++) {
                canvas.drawText("热菜"+i, 500 - 50, 500 - 350 + 75, mPaint);
                canvas.save();
                canvas.rotate(360 / 12, 500, 500);
            }
        }else{
            for (int i = 0; i < 12; i++) {
                canvas.drawText("热菜"+i, 500 - 50, 500 - 350 + 75, mPaint);
                canvas.save();
                canvas.rotate(360 / 12, 500, 500);
            }
            canvas.rotate(mdegree,500,500);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = motionEvent.getX();
                downY = motionEvent.getY();
                Point point = new Point((int) downX, (int) downY);
                position = JudgePosition(point);
                break;
            case MotionEvent.ACTION_MOVE:
                float moveX = motionEvent.getX();
                float moveY = motionEvent.getY();
                Point point1 = new Point((int) moveX, (int) moveY);
                mDegree(point1);
                invalidate();

//                rotate(mdegree);

                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }

    public void mDegree(Point cur) {
        //mDegree是图片旋转角度
        //获取触摸点和中心点分别在水平和竖直方向的距离
        float x = cur.x - 500;
        float y = cur.y - 500;
        //特殊情况，y=0
        if (y == 0) {
            if (x > 0) {

                mdegree = -90;
            } else if (x < 0) {
                mdegree = 90;
            }
        } else {
            //tan(x/y)换算出角度edge
            float edge = (float) (Math.atan(Math.abs(x / y)) / (Math.PI) * 180);

            if (x >= 0 && y > 0) {
                //触摸点在分析图的4位置
                mdegree = -edge;
            } else if (x > 0 && y < 0) {
                //触摸点在分析图的2位置
                mdegree = -180 + edge;
            } else if (x <= 0 && y < 0) {
                //触摸点在分析图的1位置
                mdegree = 180 - edge;
            } else if (x < 0 && y > 0) {
                //触摸点在分析图的3位置
                mdegree = edge;
            }
        }
    }


//    //用matrix矩阵旋转图片
//    public void rotate(float degree) {
//        //设置图片缩放比例，这里是1:1
//        matrix.setScale(1.0f, 1.0f);
//        //绕图片中心点进行旋转，旋转角度为degree
//        matrix.postRotate(degree, 500, 500);
//        //请求重绘
//        invalidate();
//    }

    private int JudgePosition(Point point) {
        double distance = Math.sqrt((point.x - 500) * (point.x - 500) + (point.y - 500) * (point.y - 500));
        if (distance > 150 && distance < 250) {
            //这是内层的圆
            return 1;
        } else if (distance > 250 && distance < 350) {
            //这是外层的圆
            return 2;
        }
        return 0;
    }
}
