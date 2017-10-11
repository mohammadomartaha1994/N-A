package com.example.mohammad.nouran;

import android.app.AlertDialog;
import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mohammad on 5/3/2017.
 */

public class Num_Five extends Fragment implements View.OnClickListener {
    EditText text22,text23,text24,text25,text26,text27,text28,text29;
    RadioButton r31,r32,r33,r34,r35,r26,r27,r28,r29,r30,r36,r37,r38,r39,r40,r41,r42;
    RadioGroup GR1,GR2,GR3,GR4;
    TextView total,Fcount,Scount,Tcount;
    int x=0,y=0,z=0,xyz=0;

//    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
//    Button time4e;
//    TimePicker Stime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.num_five, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        total = (TextView)getActivity().findViewById(R.id.total);
        Fcount = (TextView)getActivity().findViewById(R.id.Fcount);
        Scount = (TextView)getActivity().findViewById(R.id.Scount);
        Tcount = (TextView)getActivity().findViewById(R.id.Tcount);

        text22 = (EditText)getActivity().findViewById(R.id.text22);
        text23 = (EditText)getActivity().findViewById(R.id.text23);
        text24 = (EditText)getActivity().findViewById(R.id.text24);
        text25 = (EditText)getActivity().findViewById(R.id.text25);
        text26 = (EditText)getActivity().findViewById(R.id.text26);
        text27 = (EditText)getActivity().findViewById(R.id.text27);
        text28 = (EditText)getActivity().findViewById(R.id.text28);

        r26=(RadioButton)getActivity().findViewById(R.id.r26);
        r27=(RadioButton)getActivity().findViewById(R.id.r27);
        r28=(RadioButton)getActivity().findViewById(R.id.r28);
        r29=(RadioButton)getActivity().findViewById(R.id.r29);
        r30=(RadioButton)getActivity().findViewById(R.id.r30);
        r31=(RadioButton)getActivity().findViewById(R.id.r31);
        r32=(RadioButton)getActivity().findViewById(R.id.r32);
        r33=(RadioButton)getActivity().findViewById(R.id.r33);
        r34=(RadioButton)getActivity().findViewById(R.id.r34);
        r35=(RadioButton)getActivity().findViewById(R.id.r35);
        r36=(RadioButton)getActivity().findViewById(R.id.r36);
        r37=(RadioButton)getActivity().findViewById(R.id.r37);
        r38=(RadioButton)getActivity().findViewById(R.id.r38);
        r39=(RadioButton)getActivity().findViewById(R.id.r39);
        r40=(RadioButton)getActivity().findViewById(R.id.r40);
        r41=(RadioButton)getActivity().findViewById(R.id.r41);
        r42=(RadioButton)getActivity().findViewById(R.id.r42);

        r26.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r26"));
        r27.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r27"));
        r28.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r28"));
        r29.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r29"));
        r30.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r30"));
        r31.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r31"));
        r32.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r32"));
        r33.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r33"));
        r34.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r34"));
        r35.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r35"));
        r36.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r36"));
        r37.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r37"));
        r38.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r38"));
        r39.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r39"));
        r40.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r40"));
        r41.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r41"));
        r42.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r42"));

        text22.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text22"));
        text23.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text23"));
        text24.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text24"));
        text25.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text25"));
        text26.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text26"));
        text27.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text27"));
        text28.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text28"));


        if (SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r26")){
            text27.setTextColor(Color.RED);
            text28.setTextColor(Color.RED);
        }
        else {
            text27.setTextColor(Color.parseColor("#FFA39E9E"));
            text28.setTextColor(Color.parseColor("#FFA39E9E"));
        }

        if (r28.isChecked())
        {x=4;}
        else if (r29.isChecked())
        {x=3;}
        else if (r30.isChecked())
        {x=2;}
        else if (r31.isChecked())
        {x=1;}

        Fcount.setText("Score = "+x+"/4");

        if (r32.isChecked())
        {y=5;}
        else if (r33.isChecked())
        {y=4;}
        else if (r34.isChecked())
        {y=3;}
        else if (r35.isChecked())
        {y=2;}
        else if (r36.isChecked())
        {y=1;}

        Scount.setText("Score  = "+y+"/5");


        if (r37.isChecked())
        {z=6;}
        else if (r38.isChecked())
        {z=5;}
        else if (r39.isChecked())
        {z=4;}
        else if (r40.isChecked())
        {z=3;}
        else if (r41.isChecked())
        {z=2;}
        else if (r42.isChecked())
        {z=1;}

        Tcount.setText("Score  = "+z+"/6");

        xyz=x+y+z;


        total.setText("Total score  ="+xyz+"/15");
        GR1=(RadioGroup)getActivity().findViewById(R.id.GR1);
        GR1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r26",r26.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r27",r27.isChecked());
                if (r26.isChecked())
                {
                    text27.setTextColor(Color.RED);
                    text28.setTextColor(Color.RED);
                }
                else
                {
                    text27.setTextColor(Color.parseColor("#FFA39E9E"));
                    text28.setTextColor(Color.parseColor("#FFA39E9E"));
                }

            }
        });



        GR2=(RadioGroup)getActivity().findViewById(R.id.GR2);
        GR2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r28",r28.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r29",r29.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r30",r30.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r31",r31.isChecked());
                Scoure1();
                total();
            }
        });
        GR3=(RadioGroup)getActivity().findViewById(R.id.GR3);
        GR3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r32",r32.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r33",r33.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r34",r34.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r35",r35.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r36",r36.isChecked());
                Scoure2();
                total();
            }
        });
        GR4=(RadioGroup)getActivity().findViewById(R.id.GR4);
        GR4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r37",r37.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r38",r38.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r39",r39.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r40",r40.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r41",r41.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r42",r42.isChecked());
                Scoure3();
                total();
            }
        });











        Button button = (Button)getActivity().findViewById(R.id.num_five_to_num_six);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num_Six fragment = new Num_Six();
                final TextView num1 = (TextView)getActivity().findViewById(R.id.number5);
                final TextView num2 = (TextView)getActivity().findViewById(R.id.number6);
                if (Build.VERSION.SDK_INT >= 23) {
                    num2.setBackground(getActivity().getDrawable(R.drawable.shape_));
                    num2.setTextColor(Color.RED);
                    num1.setBackground(getActivity().getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                }
                else {
                    num2.setBackground(getResources().getDrawable(R.drawable.shape_));
                    num2.setTextColor(Color.RED);
                    num1.setBackground(getResources().getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                }


                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();
            }
        });
    }
    @Override
    public void onClick(View v) {

    }
    @Override
    public void onPause() {
        super.onPause();

        SharedPreferencesHelper.setSharePref(getActivity(),"text22",text22.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text23",text23.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text24",text24.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text25",text25.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text26",text26.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text27",text27.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text28",text28.getText().toString());


        if (r26.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r26_r27"," קיבל שוק "+"\n"+" מס\" שוקים "+" : "
                    +text27.getText().toString()+ " \n "+" ג'אולים "+" : "+text28.getText().toString());
        }
        else if (r27.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r26_r27","  לא קיבל שוק ");
        }



    }

    void Scoure1(){

        String name="";
        if (r28.isChecked())
        {x=4;
        name="4 spontaneous  ";}
        else if (r29.isChecked())
        {x=3;
            name="3 speech  ";}
        else if (r30.isChecked())
        {x=2;
            name="2 pain  ";}
        else if (r31.isChecked())
        {x=1;
            name="1 Does not open eyes  ";}

        Fcount.setText("Score = "+x+"/4");
        SharedPreferencesHelper.setSharePref(getActivity(),"scoure1","Score = "+x+"/4");
        SharedPreferencesHelper.setSharePref(getActivity(),"scoure1text",name);


    }

    void Scoure2(){
        String name="";
        if (r32.isChecked())
        {y=5;
            name="5 Oriented, converses normally   ";}
        else if (r33.isChecked())
        {y=4;
            name="4 Confused, disoriented   ";}
        else if (r34.isChecked())
        {y=3;
            name="3 Utters incoherent words  ";}
        else if (r35.isChecked())
        {y=2;
            name="2 incomprehensible sounds";}
        else if (r36.isChecked())
        {y=1;
            name="1 Makes no sounds";}
        SharedPreferencesHelper.setSharePref(getActivity(),"scoure2","Score  = "+y+"/5");
        SharedPreferencesHelper.setSharePref(getActivity(),"scoure2text",name);
        Scount.setText("Score  = "+y+"/5");
    }

    void Scoure3(){
        String name="";
        if (r37.isChecked())
        {z=6;
            name="6 moves spontaneously, Obeys commands";}
        else if (r38.isChecked())
        {z=5;
            name="5 Localizes to painful stimuli   ";}
        else if (r39.isChecked())
        {z=4;
            name="4 Flexion / Withdrawal to painful stimuli";}
        else if (r40.isChecked())
        {z=3;
            name="3 Abnormal flexion to painful stimuli (decorticate response)\n";}
        else if (r41.isChecked())
        {z=2;
            name="2 Extension to painful stimuli (decerebrate response)\n";}
        else if (r42.isChecked())
        {z=1;
            name="1 Makes no movements";}

        Tcount.setText("Score  = "+z+"/6");
        SharedPreferencesHelper.setSharePref(getActivity(),"scoure3text",name);
        SharedPreferencesHelper.setSharePref(getActivity(),"scoure3","Score  = "+z+"/6");
    }

    void total(){
        if (r28.isChecked())
        {x=4;}
        else if (r29.isChecked())
        {x=3;}
        else if (r30.isChecked())
        {x=2;}
        else if (r31.isChecked())
        {x=1;}

        if (r32.isChecked())
        {y=5;}
        else if (r33.isChecked())
        {y=4;}
        else if (r34.isChecked())
        {y=3;}
        else if (r35.isChecked())
        {y=2;}
        else if (r36.isChecked())
        {y=1;}

        if (r37.isChecked())
        {z=6;}
        else if (r38.isChecked())
        {z=5;}
        else if (r39.isChecked())
        {z=4;}
        else if (r40.isChecked())
        {z=3;}
        else if (r41.isChecked())
        {z=2;}
        else if (r42.isChecked())
        {z=1;}

        xyz=x+y+z;

        total.setText("Total score  ="+xyz+"/15");
        SharedPreferencesHelper.setSharePref(getActivity(),"totalscoure","Total score  ="+xyz+"/15");

    }



}



//        text29 = (EditText)getActivity().findViewById(R.id.text29);
//        text30 = (EditText)getActivity().findViewById(R.id.text30);
//        text31 = (EditText)getActivity().findViewById(R.id.text31);
//        text32 = (EditText)getActivity().findViewById(R.id.text32);
//        text33 = (EditText)getActivity().findViewById(R.id.text33);
//        text34 = (EditText)getActivity().findViewById(R.id.text34);
//        text36 = (EditText)getActivity().findViewById(R.id.text36);
//        text37 = (EditText)getActivity().findViewById(R.id.text37);
//        text38 = (EditText)getActivity().findViewById(R.id.text38);
//
//        c1 = (CheckBox)getActivity().findViewById(R.id.c1);
//        c2 = (CheckBox)getActivity().findViewById(R.id.c2);
//        c3 = (CheckBox)getActivity().findViewById(R.id.c3);
//        c4 = (CheckBox)getActivity().findViewById(R.id.c4);
//        c5 = (CheckBox)getActivity().findViewById(R.id.c5);
//        c6 = (CheckBox)getActivity().findViewById(R.id.c6);
//        c7 = (CheckBox)getActivity().findViewById(R.id.c7);
//        c8 = (CheckBox)getActivity().findViewById(R.id.c8);
//        c9 = (CheckBox)getActivity().findViewById(R.id.c9);
//        c10 = (CheckBox)getActivity().findViewById(R.id.c10);
//        c11 = (CheckBox)getActivity().findViewById(R.id.c11);
//        c12 = (CheckBox)getActivity().findViewById(R.id.c12);
//        c13 = (CheckBox)getActivity().findViewById(R.id.c13);
//        c14 = (CheckBox)getActivity().findViewById(R.id.c14);
//        c15 = (CheckBox)getActivity().findViewById(R.id.c15);
//
//        c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1"));
//        c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c2"));
//        c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c3"));
//        c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c4"));
//        c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c5"));
//        c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c6"));
//        c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c7"));
//        c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c8"));
//        c9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c9"));
//        c10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c10"));
//        c11.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c11"));
//        c12.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c12"));
//        c13.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c13"));
//        c14.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c14"));
//        c15.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c15"));
//
//        time4e = (Button)getActivity().findViewById(R.id.time4e);
//
//        time4e.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
//                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
//                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
//                Button toTime = (Button) promptView1.findViewById(R.id.toTime);
//                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
//
//                int currentApiVersion = android.os.Build.VERSION.SDK_INT;
//                if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
//                    Stime.setHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour4e"));
//                    Stime.setMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin4e"));
//                } else {
//                    Stime.setCurrentHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour4e"));
//                    Stime.setCurrentMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin4e"));
//                }
//
//
//                toTime.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
//                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour4e",Stime.getHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin4e",Stime.getMinute());
//                        } else {
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour4e",Stime.getCurrentHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin4e",Stime.getCurrentMinute());
//                        }
//
//
//                        alertD1.dismiss();
//                    }
//                });
//                alertD1.setView(promptView1);
//                alertD1.show();
//            }
//        });
//
//        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c1",c1.isChecked());
//            }
//        });
//
//        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c2",c2.isChecked());
//            }
//        });
//
//        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c3",c3.isChecked());
//            }
//        });
//
//        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c4",c4.isChecked());
//            }
//        });
//
//        c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c5",c5.isChecked());
//            }
//        });
//
//        c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c6",c6.isChecked());
//            }
//        });
//
//        c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c7",c7.isChecked());
//            }
//        });
//
//        c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c8",c8.isChecked());
//            }
//        });
//
//        c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c9",c9.isChecked());
//            }
//        });
//
//        c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c10",c10.isChecked());
//            }
//        });
//
//        c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c11",c11.isChecked());
//            }
//        });
//
//        c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c12",c12.isChecked());
//            }
//        });
//
//        c13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c13",c13.isChecked());
//            }
//        });
//
//        c14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c14",c14.isChecked());
//            }
//        });
//
//        c15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"c15",c15.isChecked());
//            }
//        });
//
//
//        text29.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text29"));
//        text30.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text30"));
//        text31.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text31"));
//        text32.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text32"));
//        text33.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text33"));
//        text34.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text34"));
//        text36.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text36"));
//        text37.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text37"));
//        text38.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text38"));
//
//
//
//