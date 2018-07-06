package paintest.painttest.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public class RefreshFootView extends TextView implements SwipeRefreshTrigger,SwipeTrigger {


    public RefreshFootView(Context context) {
        super(context);
    }

    public RefreshFootView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshFootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onRefresh() {

        setText("正在加载数据中...");
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onSwipe(int i, boolean b) {
        setText("松开立即刷新");
    }




    @Override
    public void onRelease() {

    }

    @Override
    public void complete() {
        setText("刷新成功");
    }



    @Override
    public void onReset() {

    }
}
