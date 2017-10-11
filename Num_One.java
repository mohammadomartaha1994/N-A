package com.example.mohammad.nouran;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammad on 5/3/2017.
 */

public class Num_One extends Fragment implements View.OnClickListener {
    Button date;
    DatePicker Exam_Date;
    Button time1,time2,time3,time4,time5,time6,time7;
    TimePicker Stime;
    RadioGroup radioGroup,radioGroup2,radioGroup3;
    EditText text1,text2,text3,text4,text5,text6;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.num_one, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        time1 = (Button)getActivity().findViewById(R.id.time1);
        time2 = (Button)getActivity().findViewById(R.id.time2);
        time3 = (Button)getActivity().findViewById(R.id.time3);
        time4 = (Button)getActivity().findViewById(R.id.time4);
        time5 = (Button)getActivity().findViewById(R.id.time5);
        time6 = (Button)getActivity().findViewById(R.id.time6);
        time7 = (Button)getActivity().findViewById(R.id.time7);

        r1=(RadioButton)getActivity().findViewById(R.id.r1);
        r2=(RadioButton)getActivity().findViewById(R.id.r2);
        r3=(RadioButton)getActivity().findViewById(R.id.r3);
        r4=(RadioButton)getActivity().findViewById(R.id.r4);
        r5=(RadioButton)getActivity().findViewById(R.id.r5);
        r6=(RadioButton)getActivity().findViewById(R.id.r6);
        r7=(RadioButton)getActivity().findViewById(R.id.r7);
        r8=(RadioButton)getActivity().findViewById(R.id.r8);
        r9=(RadioButton)getActivity().findViewById(R.id.r9);
        r10=(RadioButton)getActivity().findViewById(R.id.r10);

        text1=(EditText)getActivity().findViewById(R.id.text1);
        text2=(EditText)getActivity().findViewById(R.id.text2);
        text3=(EditText)getActivity().findViewById(R.id.text3);
        text4=(EditText)getActivity().findViewById(R.id.text4);
        text5=(EditText)getActivity().findViewById(R.id.text5);
        text6=(EditText)getActivity().findViewById(R.id.text6);
        text3.setTextColor(Color.parseColor("#FFA39E9E"));
        text4.setTextColor(Color.parseColor("#FFA39E9E"));
        text5.setTextColor(Color.parseColor("#FFA39E9E"));

        if (SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r8")){
            text3.setTextColor(Color.RED);
        }
        else if (SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r9")){
            text4.setTextColor(Color.RED);
        }
        else if (SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r10")){
            text5.setTextColor(Color.RED);
        }

        text1.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text1"));
        text2.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text2"));
        text3.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text3"));
        text4.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text4"));
        text5.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text5"));
        text6.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text6"));

        r1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r1"));
        r2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r2"));
        r3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r3"));
        r4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r4"));
        r5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r5"));
        r6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r6"));
        r7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r7"));
        r8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r8"));
        r9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r9"));
        r10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r10"));


        radioGroup=(RadioGroup)getActivity().findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r1",r1.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r2",r2.isChecked());
            }
        });



        radioGroup2=(RadioGroup)getActivity().findViewById(R.id.radioGroup2);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r3",r3.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r4",r4.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r5",r5.isChecked());
            }
        });




        radioGroup3=(RadioGroup)getActivity().findViewById(R.id.radioGroup3);
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                SharedPreferencesHelper.setSharePref(getActivity(),"r6",r6.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r7",r7.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r8",r8.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r9",r9.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r10",r10.isChecked());
                if (r8.isChecked())
                {
                 text3.setTextColor(Color.RED);
                }
                else
                {text3.setTextColor(Color.parseColor("#FFA39E9E"));}

                if (r9.isChecked()){
                    text4.setTextColor(Color.RED);}
                else
                {text4.setTextColor(Color.parseColor("#FFA39E9E"));}

                if (r10.isChecked()){
                    text5.setTextColor(Color.RED);}
                else {text5.setTextColor(Color.parseColor("#FFA39E9E"));}
            }
        });


        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                final TextView name = (TextView)promptView1.findViewById(R.id.name);
                name.setText("שעת קבלת הקריאה");
                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour1",Stime.getHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin1",Stime.getMinute());
                        } else {
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour1",Stime.getCurrentHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin1",Stime.getCurrentMinute());
                        }

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


        time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
                final TextView name = (TextView)promptView1.findViewById(R.id.name);
                name.setText("שעת יציאהלאירוע");

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour2",Stime.getHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin2",Stime.getMinute());
                        } else {
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour2",Stime.getCurrentHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin2",Stime.getCurrentMinute());
                        }

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


        time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
                final TextView name = (TextView)promptView1.findViewById(R.id.name);
                name.setText("שעת הגעה לאירוע");

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour3",Stime.getHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin3",Stime.getMinute());
                        } else {
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour3",Stime.getCurrentHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin3",Stime.getCurrentMinute());
                        }

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


        time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
                final TextView name = (TextView)promptView1.findViewById(R.id.name);
                name.setText("שעת יציאה מהאירוע");

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour4",Stime.getHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin4",Stime.getMinute());
                        } else {
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour4",Stime.getCurrentHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin4",Stime.getCurrentMinute());
                        }

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


        time5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
                final TextView name = (TextView)promptView1.findViewById(R.id.name);
                name.setText("שעת הגעה ליעד/ לביה\"ח");

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour5",Stime.getHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin5",Stime.getMinute());
                        } else {
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour5",Stime.getCurrentHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin5",Stime.getCurrentMinute());
                        }

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


        time6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
                final TextView name = (TextView)promptView1.findViewById(R.id.name);
                name.setText(" יעד פינוי ");

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour6",Stime.getHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin6",Stime.getMinute());
                        } else {
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour6",Stime.getCurrentHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin6",Stime.getCurrentMinute());

                        }

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


        time7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
                final TextView name = (TextView)promptView1.findViewById(R.id.name);
                name.setText(" איש צוות מקבל");

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
                             SharedPreferencesHelper.setSharePref(getActivity(),"timeHour7",Stime.getHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin7",Stime.getMinute());
                           // Toast.makeText(getActivity(),Stime.getHour()+":"+Stime.getMinute(),Toast.LENGTH_LONG).show();
                        } else {
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour7",Stime.getCurrentHour());
                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin7",Stime.getCurrentMinute());
                            //Toast.makeText(getActivity(),Stime.getCurrentHour()+":"+Stime.getCurrentMinute(),Toast.LENGTH_LONG).show();

                        }

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


        date = (Button)getActivity().findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                final View promptView = layoutInflater.inflate(R.layout.dialogdate, null);
                final AlertDialog alertD = new AlertDialog.Builder(getActivity()).create();
                Button Done = (Button) promptView.findViewById(R.id.toTime);
                Exam_Date =(DatePicker)promptView.findViewById(R.id.datePicker);

                Exam_Date.init(SharedPreferencesHelper.getIntYearSharedPref(getActivity(),"year"),
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"month"),
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"day"),null);

                Done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"day",Exam_Date.getDayOfMonth());
                        SharedPreferencesHelper.setSharePref(getActivity(),"month",Exam_Date.getMonth());
                        SharedPreferencesHelper.setSharePref(getActivity(),"year",Exam_Date.getYear());
                       alertD.dismiss();
                    }
                });
                alertD.setView(promptView);
                alertD.show();
            }
        });
//        text1=(EditText)getActivity().findViewById(R.id.text1);
//        text2=(EditText)getActivity().findViewById(R.id.text2);
//
//       ///
//       ///
//
//        text4=(EditText)getActivity().findViewById(R.id.text4);
//        text5=(EditText)getActivity().findViewById(R.id.text5);
//
//        text1.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text1"));
//        text2.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text2"));
//
//        ///
//        ///
//
//        text4.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text4"));
//        text5.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text5"));
//
//        r1=(RadioButton)getActivity().findViewById(R.id.r1);
//        r2=(RadioButton)getActivity().findViewById(R.id.r2);
//        r3=(RadioButton)getActivity().findViewById(R.id.r3);
//        r4=(RadioButton)getActivity().findViewById(R.id.r4);
//        r5=(RadioButton)getActivity().findViewById(R.id.r5);
//        r6=(RadioButton)getActivity().findViewById(R.id.r6);
//        r7=(RadioButton)getActivity().findViewById(R.id.r7);
//        r8=(RadioButton)getActivity().findViewById(R.id.r8);
//        r9=(RadioButton)getActivity().findViewById(R.id.r9);
//        r10=(RadioButton)getActivity().findViewById(R.id.r10);
//
//        r1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r1"));
//        r2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r2"));
//        r3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r3"));
//        r4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r4"));
//        r5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r5"));
//        r6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r6"));
//        r7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r7"));
//        r8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r8"));
//        r9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r9"));
//        r10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r10"));
//
//
//
//        radioGroup=(RadioGroup)getActivity().findViewById(R.id.firstRG);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r1",r1.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r2",r2.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r3",r3.isChecked());
//            }
//        });
//
//        radioGroup2=(RadioGroup)getActivity().findViewById(R.id.secGR);
//        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r4",r4.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r5",r5.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r6",r6.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r7",r7.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r8",r8.isChecked());
//            }
//        });
//
//        radioGroup3=(RadioGroup)getActivity().findViewById(R.id.thGR);
//        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r9",r9.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r10",r10.isChecked());
//            }
//        });
//
//        dbManager=new DBManager(getActivity());
//        firstSpinner = (Spinner)getActivity().findViewById(R.id.Spinner1);
//
//
//        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"firstSpinner",position);
//                SharedPreferencesHelper.setSharePref(getActivity(),"firstSpinnertexttext",firstSpinner.getSelectedItem().toString());
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//
//
//
//
//        LoadElement();
//
//        firstSpinner.setSelection(SharedPreferencesHelper.getIntSharedPref(getActivity(),"firstSpinner"));
//        time1 = (Button)getActivity().findViewById(R.id.time1);
//        time2 = (Button)getActivity().findViewById(R.id.time2);
//        time3e = (Button)getActivity().findViewById(R.id.time3e);
//
//        time1.setOnClickListener(new View.OnClickListener() {
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
//                    Stime.setHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour1"));
//                    Stime.setMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin1"));
//                } else {
//                    Stime.setCurrentHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour1"));
//                    Stime.setCurrentMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin1"));
//                }
//
//
//                toTime.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
//                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour1",Stime.getHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin1",Stime.getMinute());
//                        } else {
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour1",Stime.getCurrentHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin1",Stime.getCurrentMinute());
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
//        time2.setOnClickListener(new View.OnClickListener() {
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
//                    Stime.setHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour2"));
//                    Stime.setMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin2"));
//                } else {
//                    Stime.setCurrentHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour2"));
//                    Stime.setCurrentMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin2"));
//                }
//
//
//                toTime.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
//                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour2",Stime.getHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin2",Stime.getMinute());
//                        } else {
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour2",Stime.getCurrentHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin2",Stime.getCurrentMinute());
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
//
//        time3e.setOnClickListener(new View.OnClickListener() {
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
//                    Stime.setHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour3e"));
//                    Stime.setMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin3e"));
//                } else {
//                    Stime.setCurrentHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour3e"));
//                    Stime.setCurrentMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin3e"));
//                }
//
//
//                toTime.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
//                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour3e",Stime.getHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin3e",Stime.getMinute());
//                        } else {
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour3e",Stime.getCurrentHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin3e",Stime.getCurrentMinute());
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
//
//
//        firstSpinnerText = (EditText)getActivity().findViewById(R.id.text5);
        Button button = (Button)getActivity().findViewById(R.id.num_one_to_num_tow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Num_Tow fragment = new Num_Tow();
                final TextView num1 = (TextView)getActivity().findViewById(R.id.number1);
                final TextView num2 = (TextView)getActivity().findViewById(R.id.number2);
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

//

            }
        });


    }
    @Override
    public void onClick(View v) {
    }
//
//    List<String> listnewsData = new ArrayList<String>();
//    void LoadElement() {
//        listnewsData.clear();
//        Cursor cursor = dbManager.query(null,null , null, DBManager.ColID);
//        if (cursor.moveToFirst()) {
//            do {
//                listnewsData.add(cursor.getString(cursor.getColumnIndex(DBManager.ColName)));
//            } while (cursor.moveToNext());
//        }
//        ArrayAdapter<String> adp1=new ArrayAdapter<String>(getActivity(),R.layout.spinner_item,listnewsData);
//        firstSpinner.setAdapter(adp1);
//    }


    @Override
    public void onPause() {
        super.onPause();
        SharedPreferencesHelper.setSharePref(getActivity(),"text1",text1.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text2",text2.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text3",text3.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text4",text4.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text5",text5.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text6",text6.getText().toString());

        if (r1.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r1_r2"," נט\"ן ");
        }
        else if (r2.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r1_r2"," רגיל ");
        }


        if (r3.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r3_r4_r5"," ב ");
        }
        else if (r4.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r3_r4_r5"," ע ");
        }
        else if (r5.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r3_r4_r5"," ל ");
        }


        if (r6.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r6_r7_r8_r9_r10"," בית ");
        }
        else if (r7.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r6_r7_r8_r9_r10"," רחוב ");
        }
        else if (r8.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r6_r7_r8_r9_r10"," מתקן רפואי "+" : "+text3.getText().toString());
        }
        else if (r9.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r6_r7_r8_r9_r10","  בניין ציבורי  "+" : "+text4.getText().toString());
        }
        else if (r10.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r6_r7_r8_r9_r10","  מקום עבודה   "+" : "+text5.getText().toString());
        }

        SharedPreferencesHelper.setSharePref(getActivity(),"date"," "+
                SharedPreferencesHelper.getIntYearSharedPref(getActivity(),"year")+"-"+
                (SharedPreferencesHelper.getIntSharedPref(getActivity(),"month")+1)+"-"+
                SharedPreferencesHelper.getIntSharedPref(getActivity(),"day"));

        SharedPreferencesHelper.setSharePref(getActivity(),"TIME1",
                " שעת קבלת הקריאה : "+SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour1")+":"+
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin1"));


        SharedPreferencesHelper.setSharePref(getActivity(),"TIME2",
                " שעת יציאהלאירוע : "+SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour2")+":"+
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin2"));


        SharedPreferencesHelper.setSharePref(getActivity(),"TIME3",
                " שעת הגעה לאירוע : "+SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour3")+":"+
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin3"));


        SharedPreferencesHelper.setSharePref(getActivity(),"TIME4",
                " שעת יציאה מהאירוע : "+SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour4")+":"+
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin4"));


        SharedPreferencesHelper.setSharePref(getActivity(),"TIME5",
                "  שעת הגעה ליעד/ לביה\"ח : "+SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour5")+":"+
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin5"));


        SharedPreferencesHelper.setSharePref(getActivity(),"TIME6",
                " יעד פינוי : "+SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour6")+":"+
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin6"));


        SharedPreferencesHelper.setSharePref(getActivity(),"TIME7",
                " איש צוות מקבל : "+SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour7")+":"+
                        SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin7"));


    }


}
