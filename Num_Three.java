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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

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


public class Num_Three extends Fragment implements View.OnClickListener {
    DBManager dbManager;
    Spinner secondSpinner;
    String restult="";
    EditText secondSpinnerText , text14,text15,text16,text17,text18,text19,text20,ctext;
    RadioGroup radioGroupr1,radioGroupr2,radioGroupr3,radioGroupr4,radioGroupr5;
    RadioButton r1,r2,r3,r4,r5,r6;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c23,c24,c25,c16,c17,c18,c19,c20,c21,c22,c26;
    Button chickbox_dialog_d,chickbox_dialog_e,chickbox_dialog_f,chickbox_dialog_g,chickbox_dialog_h,chickbox_dialog_i,chickbox_dialog_j,chickbox_dialog_k;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.num_three, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        chickbox_dialog_d=(Button)getActivity().findViewById(R.id.chickbox_dialog_d);
        chickbox_dialog_e=(Button)getActivity().findViewById(R.id.chickbox_dialog_e);
        chickbox_dialog_f=(Button)getActivity().findViewById(R.id.chickbox_dialog_f);
        chickbox_dialog_g=(Button)getActivity().findViewById(R.id.chickbox_dialog_g);
        chickbox_dialog_h=(Button)getActivity().findViewById(R.id.chickbox_dialog_h);
        chickbox_dialog_i=(Button)getActivity().findViewById(R.id.chickbox_dialog_i);
        chickbox_dialog_j=(Button)getActivity().findViewById(R.id.chickbox_dialog_j);
        chickbox_dialog_k=(Button)getActivity().findViewById(R.id.chickbox_dialog_k);

        chickbox_dialog_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_d, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();

                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);
                c7 = (CheckBox)promptView1.findViewById(R.id.c7);
                c8 = (CheckBox)promptView1.findViewById(R.id.c8);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c31"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c32"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c33"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c34"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c35"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c36"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c37"));
                c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c38"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c31",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c32",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c33",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c34",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c35",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c36",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c37",c7.isChecked());
                    }
                });

                c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c38",c8.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c3text"));

                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c3text",ctext.getText().toString());



                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" תקין ,";
                        }if (c2.isChecked()){
                            restult=restult+" לח ,";
                        }if (c3.isChecked()){
                            restult=restult+" יבש ,";
                        }if (c4.isChecked()){
                            restult=restult+" חם ,";
                        }if (c5.isChecked()){
                            restult=restult+" קר ,";
                        }if (c6.isChecked()){
                            restult=restult+" חוור ,";
                        }if (c7.isChecked()){
                            restult=restult+" כחלון  ,";
                        }if (c8.isChecked()){
                            restult=restult+" סמוק ,";
                        }

                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog4",restult);
                        alertD1.dismiss();
                    }
                });

                alertD1.setView(promptView1);
                alertD1.show();
            }
        });

        chickbox_dialog_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_e, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);
                r1 = (RadioButton) promptView1.findViewById(R.id.r1);
                r2 = (RadioButton)promptView1.findViewById(R.id.r2);
                r3 = (RadioButton)promptView1.findViewById(R.id.r3);
                r4 = (RadioButton)promptView1.findViewById(R.id.r4);
                r5 = (RadioButton)promptView1.findViewById(R.id.r5);
                r6 = (RadioButton)promptView1.findViewById(R.id.r6);

                r1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re1"));
                r2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re2"));
                r3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re3"));
                r4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re4"));
                r5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re5"));
                r6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re6"));


                radioGroupr1=(RadioGroup)promptView1.findViewById(R.id.radioGroupr1);
                radioGroupr1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"re1",r1.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"re2",r2.isChecked());
                    }
                });

                radioGroupr2=(RadioGroup)promptView1.findViewById(R.id.radioGroupr2);
                radioGroupr2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"re3",r3.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"re4",r4.isChecked());
                    }
                });


                radioGroupr3=(RadioGroup)promptView1.findViewById(R.id.radioGroupr3);
                radioGroupr3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"re5",r5.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"re6",r6.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"crtext"));


                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"crtext",ctext.getText().toString());

                        restult="";

//

                        if (r1.isChecked()){
                            restult=restult+" שווים ,";
                        }else if (r2.isChecked()){
                            restult=restult+" לא שווים ,";
                        }if (r3.isChecked()){
                            restult=restult+" מגיבים ,";
                        }else if (r4.isChecked()){
                            restult=restult+" לא מגיבים ,";
                        }if (r5.isChecked()){
                            restult=restult+" מורחבים ,";
                        }else if (r6.isChecked()){
                            restult=restult+" מכווצים ,";
                        }
//
                       restult = restult +""+ctext.getText().toString();
//
                       SharedPreferencesHelper.setSharePref(getActivity(),"dialog5",restult);
                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();

            }
        });

        chickbox_dialog_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_f, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();

                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c41"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c42"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c43"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c44"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c45"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c41",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c42",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c43",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c44",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c45",c5.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c4text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c4text",ctext.getText().toString());



                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" נקיות ,";
                        }if (c2.isChecked()){
                            restult=restult+" חרחורים לחים ,";
                        }if (c3.isChecked()){
                            restult=restult+" חרחורים יבשים ,";
                        }if (c4.isChecked()){
                            restult=restult+" צפצופים ,";
                        }if (c5.isChecked()){
                            restult=restult+" כניסת אוויר ויציאה (למלות) ,";
                        }

                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog6",restult);


                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();

            }
        });

        chickbox_dialog_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_g, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final Button close = (Button)promptView1.findViewById(R.id.close);

                r1 = (RadioButton) promptView1.findViewById(R.id.r1);
                r2 = (RadioButton)promptView1.findViewById(R.id.r2);
                r3 = (RadioButton)promptView1.findViewById(R.id.r3);
                r4 = (RadioButton)promptView1.findViewById(R.id.r4);

                r1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re7"));
                r2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re8"));
                r3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re9"));
                r4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"re10"));

                radioGroupr4=(RadioGroup)promptView1.findViewById(R.id.radioGroupr1);
                radioGroupr4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"re7",r1.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"re8",r2.isChecked());
                    }
                });

                radioGroupr5=(RadioGroup)promptView1.findViewById(R.id.radioGroupr2);
                radioGroupr5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"re9",r3.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"re10",r4.isChecked());
                    }
                });

                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"cgtext"));

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"cgtext",ctext.getText().toString());


                        if (r1.isChecked()){
                            restult=restult+" רכה ,";
                        }else if (r2.isChecked()){
                            restult=restult+" קשה  ,";
                        }if (r3.isChecked()){
                            restult=restult+" רגישה ,";
                        }else if (r4.isChecked()){
                            restult=restult+" לא רגישה ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog7",restult);


                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });

        chickbox_dialog_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_h, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();

                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c51"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c52"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c53"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c54"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c51",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c52",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c53",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c54",c4.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c5text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c5text",ctext.getText().toString());


                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" בצקת ריאות ,";
                        }if (c2.isChecked()){
                            restult=restult+" גודש ורידיבצוואר ,";
                        }if (c3.isChecked()){
                            restult=restult+" כבד מוגבל ,";
                        }if (c4.isChecked()){
                            restult=restult+" בצקת ברגל ,";
                        }

                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog8",restult);

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });

        chickbox_dialog_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_i, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();

                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c61"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c62"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c63"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c64"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c65"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c66"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c61",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c62",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c63",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c64",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c65",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c66",c6.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c6text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c6text",ctext.getText().toString());


                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" סדיר ,";
                        }if (c2.isChecked()){
                            restult=restult+" לא סדיר ,";
                        }if (c3.isChecked()){
                            restult=restult+" תקין ,";
                        }if (c4.isChecked()){
                            restult=restult+" לק תקין ,";
                        }if (c5.isChecked()){
                            restult=restult+" מהיר ,";
                        }if (c6.isChecked()){
                            restult=restult+" איטי ,";
                        }

                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog9",restult);
                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });

        chickbox_dialog_j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_j, null);
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
                c15 = (CheckBox)promptView1.findViewById(R.id.c15);
                c16 = (CheckBox)promptView1.findViewById(R.id.c16);
                c17 = (CheckBox)promptView1.findViewById(R.id.c17);
                c18 = (CheckBox)promptView1.findViewById(R.id.c18);
                c19 = (CheckBox)promptView1.findViewById(R.id.c19);
                c20 = (CheckBox)promptView1.findViewById(R.id.c20);
                c21 = (CheckBox)promptView1.findViewById(R.id.c21);
                c22 = (CheckBox)promptView1.findViewById(R.id.c22);
                c23 = (CheckBox)promptView1.findViewById(R.id.c23);
                c24 = (CheckBox)promptView1.findViewById(R.id.c24);
                c25 = (CheckBox)promptView1.findViewById(R.id.c25);
                c26 = (CheckBox)promptView1.findViewById(R.id.c26);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c71"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c72"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c73"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c74"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c75"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c76"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c77"));
                c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c78"));
                c9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c79"));
                c10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c710"));
                c11.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c711"));
                c12.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c712"));
                c13.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c713"));
                c14.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c714"));
                c15.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c715"));
                c16.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c716"));
                c17.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c717"));
                c18.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c718"));
                c19.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c719"));
                c20.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c720"));
                c21.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c721"));
                c22.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c722"));
                c23.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c723"));
                c24.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c724"));
                c25.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c725"));
                c26.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c726"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c71",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c72",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c73",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c74",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c75",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c76",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c77",c7.isChecked());
                    }
                });

                c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c78",c8.isChecked());
                    }
                });

                c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c79",c9.isChecked());
                    }
                });

                c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c710",c10.isChecked());
                    }
                });

                c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c711",c11.isChecked());
                    }
                });

                c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c712",c12.isChecked());
                    }
                });

                c13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c713",c13.isChecked());
                    }
                });

                c14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c714",c14.isChecked());
                    }
                });

                c15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c715",c15.isChecked());
                    }
                });

                c16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c716",c16.isChecked());
                    }
                });

                c17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c717",c17.isChecked());
                    }
                });

                c18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c718",c18.isChecked());
                    }
                });

                c19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c719",c19.isChecked());
                    }
                });

                c20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c720",c20.isChecked());
                    }
                });

                c21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c721",c21.isChecked());
                    }
                });

                c22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c722",c22.isChecked());
                    }
                });

                c23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c723",c23.isChecked());
                    }
                });

                c24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c724",c24.isChecked());
                    }
                });

                c25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c725",c25.isChecked());
                    }
                });
                c26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c726",c26.isChecked());
                    }
                });




                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c7text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c7text",ctext.getText().toString());


                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" NSR ,";
                        }if (c2.isChecked()){
                            restult=restult+" Sinus tachy ,";
                        }if (c3.isChecked()){
                            restult=restult+" Sinus brady ,";
                        }if (c4.isChecked()){
                            restult=restult+" ST changes ,";
                        }if (c5.isChecked()){
                            restult=restult+" T wave inverted ,";
                        }if (c6.isChecked()){
                            restult=restult+" STEMI ,";
                        }if (c7.isChecked()){
                            restult=restult+" Q wave ,";
                        }if (c8.isChecked()){
                            restult=restult+" Old M.I ,";
                        }if (c9.isChecked()){
                            restult=restult+" LBBB ,";
                        }if (c10.isChecked()){
                            restult=restult+" RBBB ,";
                        }if (c11.isChecked()){
                            restult=restult+" VPBs ,";
                        }if (c12.isChecked()){
                            restult=restult+" PACs ,";
                        }if (c13.isChecked()){
                            restult=restult+" A.fib ,";
                        }if (c14.isChecked()){
                            restult=restult+" A.flutter ,";
                        }if (c15.isChecked()){
                            restult=restult+" SVT ,";
                        }if (c16.isChecked()){
                            restult=restult+" V.fib ,";
                        }if (c17.isChecked()){
                            restult=restult+" V.tach ,";
                        }if (c18.isChecked()){
                            restult=restult+" 1° block ,";
                        }if (c19.isChecked()){
                            restult=restult+" 2° block I ,";
                        }if (c20.isChecked()){
                            restult=restult+" 2° block II ,";
                        }if (c21.isChecked()){
                            restult=restult+" 3° block ,";
                        }if (c22.isChecked()){
                            restult=restult+" Asystole ,";
                        }if (c23.isChecked()){
                            restult=restult+" PEA ,";
                        }if (c24.isChecked()){
                            restult=restult+" Pacemaker ,";
                        }if (c25.isChecked()){
                            restult=restult+" Idio vent ,";
                        }if (c26.isChecked()){
                            restult=restult+" WCT ,";
                        }

                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog10",restult);
                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });

        chickbox_dialog_k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_k, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();

                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c81"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c82"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c83"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c84"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c85"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c81",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c82",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c83",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c84",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c85",c5.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c8text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c8text",ctext.getText().toString());


                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" ללא שינוי ,";
                        }if (c2.isChecked()){
                            restult=restult+" שינוי איסכימי ,";
                        }if (c3.isChecked()){
                            restult=restult+" תקין ,";
                        }if (c4.isChecked()){
                            restult=restult+" לא תקין ,";
                        }if (c5.isChecked()){
                            restult=restult+" בגדר הנורמה ,";
                        }

                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog11",restult);
                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });



//        dbManager=new DBManager(getActivity());
//        secondSpinner = (Spinner)getActivity().findViewById(R.id.secondSpinner);
//        LoadElement();
//        secondSpinnerText = (EditText)getActivity().findViewById(R.id.secondSpinnerText);
//
//
//        secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"secondSpinner",position);
//                SharedPreferencesHelper.setSharePref(getActivity(),"secondSpinnertexttext",secondSpinner.getSelectedItem().toString());
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        secondSpinner.setSelection(SharedPreferencesHelper.getIntSharedPref(getActivity(),"secondSpinner"));
//
//
//        text14 = (EditText)getActivity().findViewById(R.id.text14);
//        text15 = (EditText)getActivity().findViewById(R.id.text15);
//        text16 = (EditText)getActivity().findViewById(R.id.text16);
//        text17 = (EditText)getActivity().findViewById(R.id.text17);
//        text18 = (EditText)getActivity().findViewById(R.id.text18);
//        text19 = (EditText)getActivity().findViewById(R.id.text19);
//        text20 = (EditText)getActivity().findViewById(R.id.text20);
//        text21 = (EditText)getActivity().findViewById(R.id.text21);
//
//
//        text14.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text14"));
//        text15.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text15"));
//        text16.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text16"));
//        text17.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text17"));
//        text18.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text18"));
//        text19.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text19"));
//        text20.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text20"));
//        text21.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text21"));
//        secondSpinnerText.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"secondSpinnerText"));
//
//
//        r18 = (RadioButton)getActivity().findViewById(R.id.r18);
//        r19 = (RadioButton)getActivity().findViewById(R.id.r19);
//        r20 = (RadioButton)getActivity().findViewById(R.id.r20);
//        r21 = (RadioButton)getActivity().findViewById(R.id.r21);
//
//
//        r18.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r18"));
//        r19.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r19"));
//        r20.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r20"));
//        r21.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r21"));
//
//
//        thRadio1=(RadioGroup)getActivity().findViewById(R.id.thRadio1);
//        thRadio2=(RadioGroup)getActivity().findViewById(R.id.thRadio2);
//
//        thRadio1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r18",r18.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r19",r19.isChecked());
//            }
//        });
//
//        thRadio2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                SharedPreferencesHelper.setSharePref(getActivity(),"r20",r20.isChecked());
//                SharedPreferencesHelper.setSharePref(getActivity(),"r21",r21.isChecked());
//            }
//        });
//
//
        Button button = (Button)getActivity().findViewById(R.id.num_three_to_num_four);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num_Four fragment = new Num_Four();
                final TextView num1 = (TextView)getActivity().findViewById(R.id.number3);
                final TextView num2 = (TextView)getActivity().findViewById(R.id.number4);
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
//                SharedPreferencesHelper.setSharePref(getActivity(),"text14",text14.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text15",text15.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text16",text16.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text17",text17.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text18",text18.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text19",text19.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text20",text20.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"text21",text21.getText().toString());
//                SharedPreferencesHelper.setSharePref(getActivity(),"secondSpinnerText",secondSpinnerText.getText().toString());

                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();


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
//        Cursor cursor = dbManager.queryS(null,null , null, DBManager.ColID);
//        if (cursor.moveToFirst()) {
//            do {
//                listnewsData.add(cursor.getString(cursor.getColumnIndex(DBManager.ColName)));
//            } while (cursor.moveToNext());
//        }
//        ArrayAdapter<String> adp1=new ArrayAdapter<String>(getActivity(),R.layout.spinner_item,listnewsData);
//        secondSpinner.setAdapter(adp1);
//    }


}