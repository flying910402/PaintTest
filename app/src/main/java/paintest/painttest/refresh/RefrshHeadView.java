package paintest.painttest.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

/**
 *自定义下拉刷新头布局
 * Created by Administrator on 2017/11/27 0027.
 */
public class RefrshHeadView extends TextView implements SwipeRefreshTrigger,SwipeTrigger {

    public RefrshHeadView(Context context) {
        super(context);
    }

    public RefrshHeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefrshHeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onRefresh() {

        setText("正在加载数据...");
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
