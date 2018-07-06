package paintest.painttest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import paintest.painttest.net.Constans;
import paintest.painttest.net.SbAdapter;

public class MainActivity extends AppCompatActivity {

/*    static boolean drawFlag = false;
   // private Button showBtn;
    private Button lineBtn,length_kuang,clear,send,setting;
   // private ImageView image;
    private DragView myDrawView;
    private Bitmap bimap;*/
    private SwipeToLoadLayout swipeToLoadLayout;
    private RecyclerView recyclerView;

    private SbAdapter adapter;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inntView();

       /* setting = (Button) findViewById(R.id.setting);
        lineBtn= (Button) findViewById(R.id.length_btn);
        lineBtn.setOnClickListener(this);
        clear= (Button) findViewById(R.id.clear);
        clear.setOnClickListener(this);
        myDrawView = (DragView) findViewById(R.id.drawView);
        length_kuang= (Button) findViewById(R.id.length_kuang);
        send = (Button) findViewById(R.id.send);
        length_kuang.setOnClickListener(this);
        send.setOnClickListener(this);
        setting.setOnClickListener(this);
        // 如果不用copy的方法，直接引用会对资源文件进行修改，而android是不允许在代码里修改res文件里的图片
        bimap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.touming).copy(Bitmap.Config.ARGB_8888, true);*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG","onRestart");
    }



    private void inntView() {
        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mList = new ArrayList<>();
        for(int i=0;i<5;i++){
            mList.add("");
        }

        adapter = new SbAdapter(this,mList);
        recyclerView.setAdapter(adapter);
        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }


/*

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(new Intent(this,TestActivity.class));
        this.finish();
    }
*/




  /*  @Override
    public void onClick(View view) {

        if (view == lineBtn) {

            // 传我们需要处理的bimap给画图类
            myDrawView.setBitmap(bimap,1);
            // 开始画图的标志
            MainActivity.drawFlag = true;

        }else if(view == length_kuang){

            // 开始画图的标志
            // 传我们需要处理的bimap给画图类
            myDrawView.setBitmap(bimap,2);
            MainActivity.drawFlag = true;
        }else if(view == send){


            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder =new NotificationCompat.Builder(this);

            Intent intent = new Intent(this, TestActivity.class);//将要跳转的界面
            builder.setAutoCancel(true);//点击后消失
            builder.setSmallIcon(R.mipmap.put);//设置通知栏消息标题的头像
            //builder.setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
            builder.setContentText("有客人来啦");//通知内容
            builder.setContentTitle("智能门铃");
            long[] pattern = {0, 100, 1000};
            builder.setVibrate(pattern);

            // 设置时间
            builder.setWhen(System.currentTimeMillis());
            builder.setShowWhen(true);


            Uri sound=Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bellring );
            builder.setSound(sound);

            //利用PendingIntent来包装我们的intent对象,使其延迟跳转
            PendingIntent intentPend = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            builder.setContentIntent(intentPend);

            Notification notification=builder.build();
            notificationManager.notify(0x101,notification); //发送通知

        }else if(view == setting){

            Intent i = new Intent();

            try{

                if (android.os.Build.VERSION.SDK_INT >= 11) {
                    //Honeycomb
                    i.setClassName("com.android.settings","com.android.settings.Settings$WifiSettingsActivity");
                } else {

                    //other versions
                    i.setClassName("com.android.settings","com.android.settings.wifi.WifiSettings");
                }

                startActivity(i);



            }catch (Exception e){

                Log.e("TAG", "跳转界面失败 e=" + e.toString());
            }


        }
    }
*/



}
