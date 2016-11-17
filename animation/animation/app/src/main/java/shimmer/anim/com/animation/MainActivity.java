package shimmer.anim.com.animation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import shimmer.anim.com.library.Shimmer;
import shimmer.anim.com.library.ShimmerTextView;


public class MainActivity extends ActionBarActivity {

    private ShimmerTextView tv;
    private Shimmer shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);

    }

    public void toggleAnimation(View target) {
            shimmer = new Shimmer();
            shimmer.start(tv);
    }
}
