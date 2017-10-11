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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
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
import java.util.ArrayList;

/**
 * Created by mohammad on 5/3/2017.
 */

public class Num_Four extends Fragment implements View.OnClickListener {
    EditText num1,num2,num3,num4,num5,num6,num7,num8,ctext;
    ListView lsNews;
    String restult="";
    DBManager dbManager;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14;
    EditText  text17,text18,text19,text20,text21;
     Button dialogadd,chickbox_dialog_l,chickbox_dialog_t,chickbox_dialog_s,chickbox_dialog_m,chickbox_dialog_n,chickbox_dialog_o,chickbox_dialog_p,chickbox_dialog_q,chickbox_dialog_r;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.num_four, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dbManager=new DBManager(getActivity());
        chickbox_dialog_l=(Button)getActivity().findViewById(R.id.chickbox_dialog_l);
        chickbox_dialog_m=(Button)getActivity().findViewById(R.id.chickbox_dialog_m);
        chickbox_dialog_n=(Button)getActivity().findViewById(R.id.chickbox_dialog_n);
        chickbox_dialog_o=(Button)getActivity().findViewById(R.id.chickbox_dialog_o);
        chickbox_dialog_p=(Button)getActivity().findViewById(R.id.chickbox_dialog_p);
        chickbox_dialog_q=(Button)getActivity().findViewById(R.id.chickbox_dialog_q);
        chickbox_dialog_r=(Button)getActivity().findViewById(R.id.chickbox_dialog_r);
        chickbox_dialog_s=(Button)getActivity().findViewById(R.id.chickbox_dialog_s);
        chickbox_dialog_t=(Button)getActivity().findViewById(R.id.chickbox_dialog_t);
        dialogadd=(Button)getActivity().findViewById(R.id.dialogadd);


        text17 = (EditText)getActivity().findViewById(R.id.text17);
        text18 = (EditText)getActivity().findViewById(R.id.text18);
        text19 = (EditText)getActivity().findViewById(R.id.text19);
        text20 = (EditText)getActivity().findViewById(R.id.text20);
        text21 = (EditText)getActivity().findViewById(R.id.text21);

        text17.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text17"));
        text18.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text18"));
        text19.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text19"));
        text20.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text20"));
        text21.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text21"));


        chickbox_dialog_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_s, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();

                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);
                c7 = (CheckBox)promptView1.findViewById(R.id.c7);
                c8 = (CheckBox)promptView1.findViewById(R.id.c8);
                c9 = (CheckBox)promptView1.findViewById(R.id.c9);
                c10 = (CheckBox)promptView1.findViewById(R.id.c10);
                c11 = (CheckBox)promptView1.findViewById(R.id.c11);
                c12 = (CheckBox)promptView1.findViewById(R.id.c12);
                c13 = (CheckBox)promptView1.findViewById(R.id.c13);
                c14 = (CheckBox)promptView1.findViewById(R.id.c14);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c91"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c92"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c93"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c94"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c95"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c96"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c97"));
                c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c98"));
                c9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c99"));
                c10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c910"));
                c11.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c911"));
                c12.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c912"));
                c13.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c913"));
                c14.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c914"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c91",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c92",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c93",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c94",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c95",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c96",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c97",c7.isChecked());
                    }
                });

                c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c98",c8.isChecked());
                    }
                });
                c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c99",c9.isChecked());
                    }
                });

                c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c910",c10.isChecked());
                    }
                });

                c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c911",c11.isChecked());
                    }
                });

                c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c912",c12.isChecked());
                    }
                });

                c13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c913",c13.isChecked());
                    }
                });

                c14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c914",c14.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c9text"));

                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c9text",ctext.getText().toString());

                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" D.M ,";
                        }if (c2.isChecked()){
                            restult=restult+" HTN ,";
                        }if (c3.isChecked()){
                            restult=restult+" IHD ,";
                        }if (c4.isChecked()){
                            restult=restult+" CHF ,";
                        }if (c5.isChecked()){
                            restult=restult+" MI ,";
                        }if (c6.isChecked()){
                            restult=restult+" TIA ,";
                        }if (c7.isChecked()){
                            restult=restult+" CVA ,";
                        }if (c8.isChecked()){
                            restult=restult+" COPD ,";
                        }if (c9.isChecked()){
                            restult=restult+" Asthma ,";
                        }if (c10.isChecked()){
                            restult=restult+" Drug/ substance abuse ,";
                        }if (c11.isChecked()){
                            restult=restult+" Arrhythmia ,";
                        }if (c12.isChecked()){
                            restult=restult+" Cancer ,";
                        }if (c13.isChecked()){
                            restult=restult+" CABG/ PTCA ,";
                        }if (c14.isChecked()){
                            restult=restult+" Epilepsy ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog12",restult);

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


        chickbox_dialog_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_t, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);
                c7 = (CheckBox)promptView1.findViewById(R.id.c7);
                c8 = (CheckBox)promptView1.findViewById(R.id.c8);
                c9 = (CheckBox)promptView1.findViewById(R.id.c9);
                c10 = (CheckBox)promptView1.findViewById(R.id.c10);
                c11 = (CheckBox)promptView1.findViewById(R.id.c11);
                c12 = (CheckBox)promptView1.findViewById(R.id.c12);
                c13 = (CheckBox)promptView1.findViewById(R.id.c13);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c101"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c102"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c103"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c104"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c105"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c106"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c107"));
                c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c108"));
                c9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c109"));
                c10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1010"));
                c11.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1011"));
                c12.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1012"));
                c13.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1013"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c101",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c102",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c103",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c104",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c105",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c106",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c107",c7.isChecked());
                    }
                });

                c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c108",c8.isChecked());
                    }
                });
                c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c109",c9.isChecked());
                    }
                });

                c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1010",c10.isChecked());
                    }
                });

                c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1011",c11.isChecked());
                    }
                });

                c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1012",c12.isChecked());
                    }
                });

                c13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1013",c13.isChecked());
                    }
                });



                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c10text"));

                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c10text",ctext.getText().toString());

                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" Bronchodilators ,";
                        }if (c2.isChecked()){
                            restult=restult+" Antiagregante ,";
                        }if (c3.isChecked()){
                            restult=restult+" Ca⁺ blockers ,";
                        }if (c4.isChecked()){
                            restult=restult+" Antiarrhythmias ,";
                        }if (c5.isChecked()){
                            restult=restult+" Antipsychotic ,";
                        }if (c6.isChecked()){
                            restult=restult+" ACE/ARB ,";
                        }if (c7.isChecked()){
                            restult=restult+" Antidepressant ,";
                        }if (c8.isChecked()){
                            restult=restult+" Anticonvulsant ,";
                        }if (c9.isChecked()){
                            restult=restult+" Diuretics ,";
                        }if (c10.isChecked()){
                            restult=restult+" Anticoagulants ,";
                        }if (c11.isChecked()){
                            restult=restult+" β-blocker ,";
                        }if (c12.isChecked()){
                            restult=restult+" Nitrates ,";
                        }if (c13.isChecked()){
                            restult=restult+" Antihyperglycemics ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog13",restult);

                        alertD1.dismiss();
                    }
                });                 alertD1.setView(promptView1);
                alertD1.show();
            }
        });




        dialogadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.dialogadd, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                final String nothing = "-";
                num1 = (EditText)promptView1.findViewById(R.id.num1);
                num2 = (EditText)promptView1.findViewById(R.id.num2);
                num3 = (EditText)promptView1.findViewById(R.id.num3);
                num4 = (EditText)promptView1.findViewById(R.id.num4);
                num5 = (EditText)promptView1.findViewById(R.id.num5);
                num6 = (EditText)promptView1.findViewById(R.id.num6);
                num7 = (EditText)promptView1.findViewById(R.id.num7);
                num8 = (EditText)promptView1.findViewById(R.id.num8);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ContentValues values=new ContentValues();

                        if (num1.getText().toString().isEmpty() &&
                                num2.getText().toString().isEmpty() &&
                                num3.getText().toString().isEmpty() &&
                                num4.getText().toString().isEmpty() &&
                                num5.getText().toString().isEmpty() &&
                                num6.getText().toString().isEmpty() &&
                                num7.getText().toString().isEmpty() &&
                                num8.getText().toString().isEmpty()
                                ){ alertD1.dismiss();}
                        else {
                            if (num1.getText().toString().isEmpty())
                                values.put(DBManager.Col1, nothing);
                            else values.put(DBManager.Col1, num1.getText().toString());

                            if (num2.getText().toString().isEmpty())
                                values.put(DBManager.Col2, nothing);
                            else values.put(DBManager.Col2, num2.getText().toString());

                            if (num3.getText().toString().isEmpty())
                                values.put(DBManager.Col3, nothing);
                            else values.put(DBManager.Col3, num3.getText().toString());

                            if (num4.getText().toString().isEmpty())
                                values.put(DBManager.Col4, nothing);
                            else values.put(DBManager.Col4, num4.getText().toString());

                            if (num5.getText().toString().isEmpty())
                                values.put(DBManager.Col5, nothing);
                            else values.put(DBManager.Col5, num5.getText().toString());

                            if (num6.getText().toString().isEmpty())
                                values.put(DBManager.Col6, nothing);
                            else values.put(DBManager.Col6, num6.getText().toString());

                            if (num7.getText().toString().isEmpty())
                                values.put(DBManager.Col7, nothing);
                            else values.put(DBManager.Col7, num7.getText().toString());

                            if (num8.getText().toString().isEmpty())
                                values.put(DBManager.Col8, nothing);
                            else values.put(DBManager.Col8, num8.getText().toString());


                            dbManager.Insert(values);

                            alertD1.dismiss();
                        }
                    }
                });
                final Button show = (Button)promptView1.findViewById(R.id.show);
                show.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                        final View promptView = layoutInflater.inflate(R.layout.dialogaddshow, null);
                        final AlertDialog alertD = new AlertDialog.Builder(getActivity()).create();
                        final Button close = (Button)promptView.findViewById(R.id.close);
                        lsNews = (ListView) promptView.findViewById(R.id.list);
                        LoadElement();
                        close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertD.dismiss();
                            }
                        });
                        alertD.setView(promptView);
                        alertD.show();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });



        chickbox_dialog_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_l, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();

                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c111"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c112"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c113"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c114"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c115"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c111",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c112",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c113",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c114",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c115",c5.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c11text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c11text",ctext.getText().toString());

                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" Arrest ,";
                        }if (c2.isChecked()){
                            restult=restult+" ACS ,";
                        }if (c3.isChecked()){
                            restult=restult+" STEMI ,";
                        }if (c4.isChecked()){
                            restult=restult+" CHF ,";
                        }if (c5.isChecked()){
                            restult=restult+" PE ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog14",restult);


                        alertD1.dismiss();
                    }
                });

                alertD1.setView(promptView1);
                alertD1.show();
            }
        });



        chickbox_dialog_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_m, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);
                c7 = (CheckBox)promptView1.findViewById(R.id.c7);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c121"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c122"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c123"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c124"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c125"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c126"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c127"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c121",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c122",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c123",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c124",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c125",c5.isChecked());
                    }
                });
                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c126",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c127",c7.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c12text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c12text",ctext.getText().toString());


                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" Arrest ,";
                        }if (c2.isChecked()){
                            restult=restult+" failure ,";
                        }if (c3.isChecked()){
                            restult=restult+" Aspiration ,";
                        }if (c4.isChecked()){
                            restult=restult+" Chocking ,";
                        }if (c5.isChecked()){
                            restult=restult+" Asthma ,";
                        }if (c6.isChecked()){
                            restult=restult+" COPD ,";
                        }if (c7.isChecked()){
                            restult=restult+" Pneumonia ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog15",restult);


                        alertD1.dismiss();
                    }
                });

                alertD1.setView(promptView1);
                alertD1.show();
            }
        });



        chickbox_dialog_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_n, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c131"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c132"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c133"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c134"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c135"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c131",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c132",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c133",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c134",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c135",c5.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c13text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c13text",ctext.getText().toString());


                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" Seizure ,";
                        }if (c2.isChecked()){
                            restult=restult+" Coma ,";
                        }if (c3.isChecked()){
                            restult=restult+" Syncope ,";
                        }if (c4.isChecked()){
                            restult=restult+" C.V.A ,";
                        }if (c5.isChecked()){
                            restult=restult+" T.I.A ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog16",restult);


                        alertD1.dismiss();
                    }
                });

                alertD1.setView(promptView1);
                alertD1.show();
            }
        });



        chickbox_dialog_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_o, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c141"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c142"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c143"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c144"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c145"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c146"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c141",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c142",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c143",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c144",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c145",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c146",c6.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c14text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c14text",ctext.getText().toString());



                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" MVA (road accident) ,";
                        }if (c2.isChecked()){
                            restult=restult+" Fall ,";
                        }if (c3.isChecked()){
                            restult=restult+" Assault ,";
                        }if (c4.isChecked()){
                            restult=restult+" Burn ,";
                        }if (c5.isChecked()){
                            restult=restult+" Electricity ,";
                        }if (c6.isChecked()){
                            restult=restult+" Explosion ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog17",restult);


                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });



        chickbox_dialog_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_p, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);
                c7 = (CheckBox)promptView1.findViewById(R.id.c7);
                c8 = (CheckBox)promptView1.findViewById(R.id.c8);
                c9 = (CheckBox)promptView1.findViewById(R.id.c9);
                c10 = (CheckBox)promptView1.findViewById(R.id.c10);
                c11 = (CheckBox)promptView1.findViewById(R.id.c11);
                c12 = (CheckBox)promptView1.findViewById(R.id.c12);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c151"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c152"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c153"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c154"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c155"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c156"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c157"));
                c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c158"));
                c9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c159"));
                c10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1510"));
                c11.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1511"));
                c12.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1512"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c151",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c152",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c153",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c154",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c155",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c156",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c157",c7.isChecked());
                    }
                });

                c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c158",c8.isChecked());
                    }
                });

                c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c159",c9.isChecked());
                    }
                });
                c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1510",c10.isChecked());
                    }
                });

                c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1511",c11.isChecked());
                    }
                });

                c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1512",c12.isChecked());
                    }
                });

                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c15text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c15text",ctext.getText().toString());

                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" Head ,";
                        }if (c2.isChecked()){
                            restult=restult+" Face ,";
                        }if (c3.isChecked()){
                            restult=restult+" ENT ,";
                        }if (c4.isChecked()){
                            restult=restult+" Neck ,";
                        }if (c5.isChecked()){
                            restult=restult+" Spine ,";
                        }if (c6.isChecked()){
                            restult=restult+" Chest ,";
                        }if (c7.isChecked()){
                            restult=restult+" Upper Extrem ,";
                        }if (c8.isChecked()){
                            restult=restult+" Lower Extrem ,";
                        }if (c9.isChecked()){
                            restult=restult+" Abdomen ,";
                        }if (c10.isChecked()){
                            restult=restult+" Pelvis ,";
                        }if (c11.isChecked()){
                            restult=restult+" genital ,";
                        }if (c12.isChecked()){
                            restult=restult+" Multi system ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog18",restult);


                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });



        chickbox_dialog_q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_q, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);
                c7 = (CheckBox)promptView1.findViewById(R.id.c7);
                c8 = (CheckBox)promptView1.findViewById(R.id.c8);
                c9 = (CheckBox)promptView1.findViewById(R.id.c9);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c161"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c162"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c163"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c164"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c165"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c166"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c167"));
                c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c168"));
                c9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c169"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c161",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c162",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c163",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c164",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c165",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c166",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c167",c7.isChecked());
                    }
                });

                c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c168",c8.isChecked());
                    }
                });

                c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c169",c9.isChecked());
                    }
                });

                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c16text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c16text",ctext.getText().toString());

                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" Open FX ,";
                        }if (c2.isChecked()){
                            restult=restult+" Close FX ,";
                        }if (c3.isChecked()){
                            restult=restult+" Open injury ,";
                        }if (c4.isChecked()){
                            restult=restult+" With neuro Imp ,";
                        }if (c5.isChecked()){
                            restult=restult+" With resp. Imp ,";
                        }if (c6.isChecked()){
                            restult=restult+" With shock ,";
                        }if (c7.isChecked()){
                            restult=restult+" Sever multi ,";
                        }if (c8.isChecked()){
                            restult=restult+" Pneum/Hemo thorax ,";
                        }if (c9.isChecked()){
                            restult=restult+" Concussion ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog19",restult);


                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });



        chickbox_dialog_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_r, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);
                c7 = (CheckBox)promptView1.findViewById(R.id.c7);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c171"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c172"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c173"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c174"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c175"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c176"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c177"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c171",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c172",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c173",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c174",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c175",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c176",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c177",c7.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c17text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c17text",ctext.getText().toString());

                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" Delivery ,";
                        }if (c2.isChecked()){
                            restult=restult+" Poisoning ,";
                        }if (c3.isChecked()){
                            restult=restult+" Bite ,";
                        }if (c4.isChecked()){
                            restult=restult+" sting ,";
                        }if (c5.isChecked()){
                            restult=restult+" Drowning ,";
                        }if (c6.isChecked()){
                            restult=restult+" Suicide ,";
                        }if (c7.isChecked()){
                            restult=restult+" SIDS ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog20",restult);



                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });


//        text22 = (EditText)getActivity().findViewById(R.id.text22);
//        text23 = (EditText)getActivity().findViewById(R.id.text23);
//        text24 = (EditText)getActivity().findViewById(R.id.text24);
//        text25 = (EditText)getActivity().findViewById(R.id.text25);
//        text26 = (EditText)getActivity().findViewById(R.id.text26);
//        text27 = (EditText)getActivity().findViewById(R.id.text27);
//        text28 = (EditText)getActivity().findViewById(R.id.text28);
//
//        text22.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text22"));
//        text23.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text23"));
//        text24.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text24"));
//        text25.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text25"));
//        text26.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text26"));
//        text27.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text27"));
//        text28.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text28"));
//
//        r22 = (RadioButton)getActivity().findViewById(R.id.r22);
//        r23 = (RadioButton)getActivity().findViewById(R.id.r23);
//        r24 = (RadioButton)getActivity().findViewById(R.id.r24);
//        r25 = (RadioButton)getActivity().findViewById(R.id.r25);
//        r26 = (RadioButton)getActivity().findViewById(R.id.r26);
//        r27 = (RadioButton)getActivity().findViewById(R.id.r27);
//        r28 = (RadioButton)getActivity().findViewById(R.id.r28);
//        r29 = (RadioButton)getActivity().findViewById(R.id.r29);
//        r30 = (RadioButton)getActivity().findViewById(R.id.r30);
//        r31 = (RadioButton)getActivity().findViewById(R.id.r31);
//        r32 = (RadioButton)getActivity().findViewById(R.id.r32);
//        r33 = (RadioButton)getActivity().findViewById(R.id.r33);
//        r34 = (RadioButton)getActivity().findViewById(R.id.r34);
//        r35 = (RadioButton)getActivity().findViewById(R.id.r35);
//        r36 = (RadioButton)getActivity().findViewById(R.id.r36);
//        r37 = (RadioButton)getActivity().findViewById(R.id.r37);
//
//        r22.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r22"));
//        r23.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r23"));
//        r24.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r24"));
//        r25.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r25"));
//        r26.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r26"));
//        r27.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r27"));
//        r28.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r28"));
//        r29.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r29"));
//        r30.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r30"));
//        r31.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r31"));
//        r32.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r32"));
//        r33.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r33"));
//        r34.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r34"));
//        r35.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r35"));
//        r36.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r36"));
//        r37.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r37"));
//
//        foRadio=(RadioGroup)getActivity().findViewById(R.id.foRadio);
//        foRadio1=(RadioGroup)getActivity().findViewById(R.id.foRadio1);
//        foRadio2=(RadioGroup)getActivity().findViewById(R.id.foRadio2);
//        foRadio3=(RadioGroup)getActivity().findViewById(R.id.foRadio3);
//        foRadio4=(RadioGroup)getActivity().findViewById(R.id.foRadio4);
//
//        foRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r22",r22.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r23",r23.isChecked());
//            }
//        });
//
//        foRadio1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r24",r24.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r25",r25.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r26",r26.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r27",r27.isChecked());
//            }
//        });
//
//        foRadio2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r28",r28.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r29",r29.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r30",r30.isChecked());
//            }
//        });
//
//
//        foRadio3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r31",r31.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r32",r32.isChecked());
//            }
//        });
//
//        foRadio4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r33",r33.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r34",r34.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r35",r35.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r36",r36.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r37",r37.isChecked());
//            }
//        });
//
//
//
//
//        time3 = (Button)getActivity().findViewById(R.id.time3);
//
//        time3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
//                final View promptView1 = layoutInflater1.inflate(R.layout.time_dialog, null);
//                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
//                Button toTime = (Button) promptView1.findViewById(R.id.toTime);
//                Stime = (TimePicker)promptView1.findViewById(R.id.timePicker);
//
//
//
//                int currentApiVersion = android.os.Build.VERSION.SDK_INT;
//                if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
//                    Stime.setHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour3"));
//                    Stime.setMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin3"));
//                } else {
//                    Stime.setCurrentHour(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeHour3"));
//                    Stime.setCurrentMinute(SharedPreferencesHelper.getIntSharedPref(getActivity(),"timeMin3"));
//                }
//
//                toTime.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
//                        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour3",Stime.getHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin3",Stime.getMinute());
//                        } else {
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeHour3",Stime.getCurrentHour());
//                            SharedPreferencesHelper.setSharePref(getActivity(),"timeMin3",Stime.getCurrentMinute());
//                        }
//
//                        alertD1.dismiss();
//                    }
//                });
//                alertD1.setView(promptView1);
//                alertD1.show();
//
//
//            }
//        });
//
//
//
//
        Button button = (Button)getActivity().findViewById(R.id.num_four_to_num_five);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num_Five fragment = new Num_Five();
                final TextView num1 = (TextView)getActivity().findViewById(R.id.number4);
                final TextView num2 = (TextView)getActivity().findViewById(R.id.number5);
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

//
//                SharedPreferencesHelper.setSharePref(getActivity(),"text22",text22.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text23",text23.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text24",text24.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text25",text25.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text26",text26.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text27",text27.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text28",text28.getText().toString());


                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();
            }
        });
    }
    @Override
    public void onClick(View v) {

    }

    ArrayList<AdapterItems> listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;
    void LoadElement() {
        listnewsData.clear();
        Cursor cursor = dbManager.query(null, null, null, DBManager.ColID);
        if (cursor.moveToFirst()) {
            do {
                listnewsData.add(new AdapterItems(cursor.getString(cursor.getColumnIndex(DBManager.ColID)),
                        cursor.getString(cursor.getColumnIndex(DBManager.Col1)),
                        cursor.getString(cursor.getColumnIndex(DBManager.Col2)),
                        cursor.getString(cursor.getColumnIndex(DBManager.Col3)),
                        cursor.getString(cursor.getColumnIndex(DBManager.Col4)),
                        cursor.getString(cursor.getColumnIndex(DBManager.Col5)),
                        cursor.getString(cursor.getColumnIndex(DBManager.Col6)),
                        cursor.getString(cursor.getColumnIndex(DBManager.Col7)),
                        cursor.getString(cursor.getColumnIndex(DBManager.Col8))));
            } while (cursor.moveToNext());
        }
        myadapter = new MyCustomAdapter(listnewsData);
        lsNews.setAdapter(myadapter);
    }


    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listnewsDataAdpater ;
        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }
        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }
        @Override
        public String getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = LayoutInflater.from(getActivity());
            View myView = mInflater.inflate(R.layout.layout_ticket1, null);
            final   AdapterItems s = listnewsDataAdpater.get(position);
            TextView num1=(TextView)myView.findViewById(R.id.num1);
            num1.setText(s.num1);

            TextView num2=(TextView)myView.findViewById(R.id.num2);
            num2.setText(s.num2);

            TextView num3=(TextView)myView.findViewById(R.id.num3);
            num3.setText(s.num3);

            TextView num4=(TextView)myView.findViewById(R.id.num4);
            num4.setText(s.num4);

            TextView num5=(TextView)myView.findViewById(R.id.num5);
            num5.setText(s.num5);

            TextView num6=(TextView)myView.findViewById(R.id.num6);
            num6.setText(s.num6);

            TextView num7=(TextView)myView.findViewById(R.id.num7);
            num7.setText(s.num7);

            TextView num8=(TextView)myView.findViewById(R.id.num8);
            num8.setText(s.num8);

            return myView;
        }
    }


    @Override
    public void onPause() {
        super.onPause();

        SharedPreferencesHelper.setSharePref(getActivity(),"text17",text17.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text18",text18.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text19",text19.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text20",text20.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text21",text21.getText().toString());


    }

}