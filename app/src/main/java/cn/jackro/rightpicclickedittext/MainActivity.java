package cn.jackro.rightpicclickedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RightPicClickEditText.OnRightPicClickListener {

    @BindView(R.id.right_click_et)
    RightPicClickEditText mRightClickEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRightClickEt.setOnRightPicClickListener(this);
    }

    @Override
    public void rightPicClick(EditText editText) {
        Toast.makeText(this, "点击了搜索按钮", Toast.LENGTH_SHORT).show();
    }
}
