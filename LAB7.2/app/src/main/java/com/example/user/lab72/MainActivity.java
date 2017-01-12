package com.example.user.lab72;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    protected Button gamble,next1,pan,hor,din,ele;
    protected SeekBar dino_seekBar, panda_seekBar,horse_seekBar,eleph_seekBar;
    protected EditText dollar2;
    int dino_count = 0,panda_count = 0,horse_count=0,eleph_count=0,dollar=100000,gdollar=0,a=0,b=0,c=0,d=0,e=0;
    protected TextView money;
    Intent i= new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        gamble =(Button)findViewById(R.id.gamble);
        next1 =(Button)findViewById(R.id.next1);
        din =(Button)findViewById(R.id.din);
        pan =(Button)findViewById(R.id.pan);
        hor =(Button)findViewById(R.id.lit);
        ele =(Button)findViewById(R.id.ele);
        dino_seekBar = (SeekBar) findViewById(R.id.dino_seekBar);
        panda_seekBar = (SeekBar) findViewById(R.id.panda_seekBar);
        horse_seekBar = (SeekBar) findViewById(R.id.horse_seekBar);
        eleph_seekBar = (SeekBar) findViewById(R.id.eleph_seekBar);
        money =(TextView)findViewById(R.id.money);
        dollar2 =(EditText)findViewById(R.id.dollar2);
        gamble.setEnabled(false);
        gamble.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                try {
                    gdollar = Integer.parseInt(dollar2.getText().toString());
                } catch (Exception error) {
                    gdollar= 0;
                }
                if(gdollar>dollar&&dollar!=0) {
                    Toast.makeText(MainActivity.this, "賭資超過剩餘的錢", Toast.LENGTH_SHORT).show();
                }
                else if(dollar ==0){

                        Toast.makeText(MainActivity.this, "很抱歉你破產了", Toast.LENGTH_SHORT).show();
                        i.setClass(MainActivity.this, home.class);
                        startActivity(i);
                }
                else{
                e=0;
                Toast.makeText(MainActivity.this, "開始", Toast.LENGTH_LONG).show();
                 runThread_dino();


                 runThread_panda();
                 runThread_horse();
                 runThread_eleph();
                }
            }
        });

        din.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               a=1;
                Toast.makeText(MainActivity.this, "選擇了恐龍", Toast.LENGTH_SHORT).show();
                buttondisable();
            }
        });
        pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=1;


                Toast.makeText(MainActivity.this, "選擇了熊貓", Toast.LENGTH_SHORT).show();
                buttondisable();
            }
        });
        ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=1;
                Toast.makeText(MainActivity.this, "選擇了大象", Toast.LENGTH_SHORT).show();
                buttondisable();
            }
        });
        hor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=1;
                Toast.makeText(MainActivity.this, "選擇了小馬", Toast.LENGTH_SHORT).show();
                buttondisable();
            }


        });
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              i.setClass(MainActivity.this, home.class);
               startActivity(i);
            }
        });
    }
    public void buttonenable(){
        din.setEnabled(true);
        pan.setEnabled(true);
        ele.setEnabled(true);
        hor.setEnabled(true);
        gamble.setEnabled(false);
        a=0;
        b=0;
        c=0;
        d=0;


    }
    public void buttondisable(){
        din.setEnabled(false);
        pan.setEnabled(false);
        ele.setEnabled(false);
        hor.setEnabled(false);
        gamble.setEnabled(true);
    }
    private void runThread_horse() {
        horse_count = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (horse_count <= 100 ) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    horse_count += (int) (Math.random() * 3);


                    Message msg = new Message();
                    msg.what = 3;
                    mHandler.sendMessage(msg);
                }
            }
        }).start();
    }
    private void runThread_panda() {
        panda_count = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (panda_count <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    panda_count += (int) (Math.random() * 3);
                    Message msg = new Message();
                    msg.what = 2;
                    mHandler.sendMessage(msg);


                }
            }
        }).start();
    }
    private void runThread_eleph() {
        eleph_count = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (eleph_count <= 100 ) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    eleph_count += (int) (Math.random() * 3);
                    Message msg = new Message();
                    msg.what = 4;
                    mHandler.sendMessage(msg);


                }
            }
        }).start();
    }
    private void runThread_dino() {
        dino_count = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (dino_count <= 100) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dino_count += (int) (Math.random() * 3);
                    Message msg = new Message();
                    msg.what = 1;


                    mHandler.sendMessage(msg);
                }
            }
        }).start();
    }
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    dino_seekBar.setProgress(dino_count);
                    break;
                case 2:
                    panda_seekBar.setProgress(panda_count);
                    break;
                case 3:
                    horse_seekBar.setProgress(horse_count);
                    break;
                case 4:


                    eleph_seekBar.setProgress(eleph_count);
                    break;
            }
                if (dino_count >= 100 && panda_count < 100 && horse_count < 100 & horse_count < 100 && e==0 ) {
                    e=1;
                    if(a==1&& b==0&&c==0&&d==0) {
                        Toast.makeText(MainActivity.this, "恐龍獲勝,恭喜賭對了,賺"+(gdollar*0.5), Toast.LENGTH_SHORT).show();
                        money.setText("剩餘的錢:"+(dollar+(gdollar*0.5)));
                        dollar = dollar+(gdollar*1/2);
                        buttonenable();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "恐龍獲勝,很抱歉失敗,賠"+gdollar, Toast.LENGTH_SHORT).show();
                        money.setText("剩餘的錢:"+(dollar-gdollar));
                        dollar = dollar-gdollar;
                        buttonenable();
                    }
                } else if (panda_count >= 100 && dino_count < 100 & horse_count < 100 & eleph_count < 100 && e==0) {


                    e=1;
                    if(a==0 && b==1&& c==0 && d==0) {
                        Toast.makeText(MainActivity.this, "熊貓獲勝,恭喜賭對了,賺"+(gdollar*0.5), Toast.LENGTH_SHORT).show();
                        money.setText("剩餘的錢:"+(dollar+(gdollar*0.5)));
                        dollar = dollar+(gdollar*1/2);
                        buttonenable();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "熊貓獲勝,很抱歉失敗,賠"+gdollar, Toast.LENGTH_SHORT).show();
                        money.setText("剩餘的錢:"+(dollar-gdollar));
                        dollar = dollar-gdollar;
                        buttonenable();
                    }
                }
                    else if (horse_count >= 100 && panda_count < 100  && dino_count < 100 & eleph_count < 100 && e==0) {
                    e=1;
                    if(a==0&& b==0&&c==0&&d==1) {
                        Toast.makeText(MainActivity.this, "小馬獲勝,恭喜賭對了,賺"+(gdollar*0.5), Toast.LENGTH_SHORT).show();


                        money.setText("剩餘的錢:"+(dollar+(gdollar*0.5)));
                        dollar = dollar+(gdollar*1/2);
                        buttonenable();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "小馬獲勝,很抱歉失敗,賠"+gdollar, Toast.LENGTH_SHORT).show();
                        money.setText("剩餘的錢:"+(dollar-gdollar));
                        dollar = dollar-gdollar;
                        buttonenable();
                    }
                }
                    else if (eleph_count >= 100 && panda_count < 100 && horse_count < 100 & dino_count < 100 && e==0) {
                    e=1;
                    if(a==0&& b==0&&c==1&&d==0) {
                        Toast.makeText(MainActivity.this, "大象獲勝,恭喜賭對了,賺"+(gdollar*0.5), Toast.LENGTH_SHORT).show();
                        money.setText("剩餘的錢:"+(dollar+(gdollar*0.5)));
                        dollar = dollar+(gdollar*1/2);
                        buttonenable();
                    }
                    else
                        e=1;
                    {
                        Toast.makeText(MainActivity.this, "大象獲勝,很抱歉失敗,賠"+gdollar, Toast.LENGTH_SHORT).show();
                        money.setText("剩餘的錢:"+(dollar-gdollar));
                        dollar = dollar-gdollar;
                        buttonenable();
                    }
                }

            }
    };
}
