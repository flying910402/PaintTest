package paintest.painttest.net;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.io.UnsupportedEncodingException;
import java.util.List;

import paintest.painttest.R;

/**
 * Description:
 * Data：2018/6/28 0028-9:17
 * Author: flying
 */
public class SbAdapter extends RecyclerView.Adapter<SbAdapter.MyViewHolder> {

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;

    private Dialog Deletedialog,ShareDialog;
    private Bitmap bitmap;

    public SbAdapter(Context context, List<String> list){
        this.context = context ;
        this.list= list;
        this.inflater =LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_item,parent,false);
        MyViewHolder holder =new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_msg;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_msg = (TextView) itemView.findViewById(R.id.tv_msg);


        }
    }





}
