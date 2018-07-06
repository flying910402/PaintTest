package paintest.painttest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Description:
 * Data：2018/4/12 0012-11:06
 * Author: flying
 */
public class DragView extends TextView {

    private float beginX = 0, beginY = 0, endX = 0, endY = 0;
    private int eventFlag = 0;// 触屏事件点击
    private Canvas canvasSelf;// 用于保存所画图像的画布
    private Bitmap bimap;// 用于保存所画图像的图画

    private int flag=0;

    public void setBitmap(Bitmap b,int flag) {
        bimap = b;
        canvasSelf = new Canvas(bimap);
        this.flag=flag;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

       /* if (MainActivity.drawFlag) {

            if(flag ==1){
              //  clear();
                Paint paint = new Paint();
                *//** 设置画笔 *//*
                paint.setColor(Color.BLUE);

                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);

                // 把之前画出来保存后的图再画出来
                canvas.drawBitmap(bimap, 0, 0, null);
                // 画中间长得线段
                canvas.drawLine(beginX, beginY, endX, endY, paint);
                if (eventFlag == MotionEvent.ACTION_UP) {
                    // 这里将直线画到canvasself上，它就保存在了bimap这张图上
                    canvasSelf.drawLine(beginX, beginY, endX, endY, paint);
                }
            }else{
              //  clear();
                Paint paint = new Paint();
                *//** 设置画笔 *//*
                paint.setColor(Color.BLUE);
                paint.setStyle(Paint.Style.STROKE);
                paint.setAntiAlias(true);

                // 把之前画出来保存后的图再画出来
                canvas.drawBitmap(bimap, 0, 0, null);

                // 画中间长得线段
                canvas.drawRect(beginX, beginY, endX, endY, paint);
                if (eventFlag == MotionEvent.ACTION_UP) {
                    // 这里将直线画到canvasself上，它就保存在了bimap这张图上
                    canvasSelf.drawRect(beginX, beginY, endX, endY, paint);
                }
            }
        }*/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        endX = event.getX();
        endY = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                eventFlag = MotionEvent.ACTION_DOWN;
                beginX = endX;
                beginY = endY;

                Log.e("TAG","beginX:"+beginX);
                Log.e("TAG","beginY:"+beginY);

                invalidate();

                break;
            case MotionEvent.ACTION_MOVE:
                eventFlag = MotionEvent.ACTION_MOVE;
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                eventFlag = MotionEvent.ACTION_UP;
                Log.e("TAG","endX:"+endX);
                Log.e("TAG","endY:"+endY);
                invalidate();
                break;
        }

        return true;
    }

    /**
     * 在XML中使用自定义View必须要使用含AttributeSet变量参数的构造函数
     * @param context
     * @param attrs
     */
    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public DragView(Context context) {
        super(context);
    }

   /* public void clear() {
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        if(canvasSelf !=null ){
            canvasSelf.drawPaint(paint);
        }

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

        invalidate();
    }*/
}
