package com.example.mohammad.nouran;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

public class Num_Tow extends Fragment implements View.OnClickListener {
    EditText text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,ctext;
    RadioButton r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25;
    String restult=" ";
    RadioGroup radioGroup,radioGroup2,GR1,GR2,GR3;
    Button chickbox_dialog_a,chickbox_dialog_b,chickbox_dialog_c;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.num_tow, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        chickbox_dialog_a= (Button)getActivity().findViewById(R.id.chickbox_dialog_a);
        chickbox_dialog_b= (Button)getActivity().findViewById(R.id.chickbox_dialog_b);
        chickbox_dialog_c= (Button)getActivity().findViewById(R.id.chickbox_dialog_c);





        text7=(EditText)getActivity().findViewById(R.id.text7);
        text8=(EditText)getActivity().findViewById(R.id.text8);
        text9=(EditText)getActivity().findViewById(R.id.text9);
        text10=(EditText)getActivity().findViewById(R.id.text10);
        text11=(EditText)getActivity().findViewById(R.id.text11);
        text12=(EditText)getActivity().findViewById(R.id.text12);
        text13=(EditText)getActivity().findViewById(R.id.text13);
        text14=(EditText)getActivity().findViewById(R.id.text14);
        text15=(EditText)getActivity().findViewById(R.id.text15);
        text16=(EditText)getActivity().findViewById(R.id.text16);

        text7.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text7"));
        text8.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text8"));
        text9.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text9"));
        text10.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text10"));
        text11.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text11"));
        text12.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text12"));
        text13.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text13"));
        text14.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text14"));
        text15.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text15"));
        text16.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text16"));

        r11=(RadioButton)getActivity().findViewById(R.id.r11);
        r12=(RadioButton)getActivity().findViewById(R.id.r12);
        r13=(RadioButton)getActivity().findViewById(R.id.r13);
        r14=(RadioButton)getActivity().findViewById(R.id.r14);
        r15=(RadioButton)getActivity().findViewById(R.id.r15);
        r16=(RadioButton)getActivity().findViewById(R.id.r16);
        r17=(RadioButton)getActivity().findViewById(R.id.r17);
        r18=(RadioButton)getActivity().findViewById(R.id.r18);
        r19=(RadioButton)getActivity().findViewById(R.id.r19);
        r20=(RadioButton)getActivity().findViewById(R.id.r20);
        r21=(RadioButton)getActivity().findViewById(R.id.r21);
        r22=(RadioButton)getActivity().findViewById(R.id.r22);
        r23=(RadioButton)getActivity().findViewById(R.id.r23);
        r24=(RadioButton)getActivity().findViewById(R.id.r24);
        r25=(RadioButton)getActivity().findViewById(R.id.r25);


        r11.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r11"));
        r12.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r12"));
        r13.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r13"));
        r14.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r14"));
        r15.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r15"));
        r16.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r16"));
        r17.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r17"));
        r18.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r18"));
        r19.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r19"));
        r20.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r20"));
        r21.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r21"));
        r22.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r22"));
        r23.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r23"));
        r24.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r24"));
        r25.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r25"));

        text14.setTextColor(Color.parseColor("#FFA39E9E"));


        text13.setTextColor(Color.parseColor("#FFA39E9E"));

        if (SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r17")){
            text13.setTextColor(Color.RED);
        }

        if (SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"r21")){
            text14.setTextColor(Color.RED);
        }


        radioGroup=(RadioGroup)getActivity().findViewById(R.id.forGR);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r11",r11.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r12",r12.isChecked());
            }
        });

        radioGroup2=(RadioGroup)getActivity().findViewById(R.id.fivGR);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r13",r13.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r14",r14.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r15",r15.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r16",r16.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r17",r17.isChecked());
                if (r17.isChecked()){
                    text13.setTextColor(Color.RED);}
                else {text13.setTextColor(Color.parseColor("#FFA39E9E"));}

            }
        });




        GR1=(RadioGroup)getActivity().findViewById(R.id.GR1);
        GR1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r18",r18.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r19",r19.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r20",r20.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r21",r21.isChecked());
                if (r21.isChecked()){
                    text14.setTextColor(Color.RED);}
                else {text14.setTextColor(Color.parseColor("#FFA39E9E"));}

            }
        });


        GR2=(RadioGroup)getActivity().findViewById(R.id.GR2);
        GR2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r22",r22.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r23",r23.isChecked());
            }
        });

        GR3=(RadioGroup)getActivity().findViewById(R.id.GR3);
        GR3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                SharedPreferencesHelper.setSharePref(getActivity(),"r24",r24.isChecked());
                SharedPreferencesHelper.setSharePref(getActivity(),"r25",r25.isChecked());
            }
        });




        chickbox_dialog_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_a, null);
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

                        c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c1"));
                        c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c2"));
                        c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c3"));
                        c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c4"));
                        c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c5"));
                        c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c6"));
                        c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c7"));
                        c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c8"));
                        c9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c9"));

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c1",c1.isChecked());
            }
        });

        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c2",c2.isChecked());
            }
        });

        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c3",c3.isChecked());
            }
        });

        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c4",c4.isChecked());
            }
        });

        c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c5",c5.isChecked());
            }
        });

        c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c6",c6.isChecked());
            }
        });

        c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c7",c7.isChecked());
            }
        });

        c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c8",c8.isChecked());
            }
        });

        c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"c9",c9.isChecked());
            }
        });

                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"ctext"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"ctext",ctext.getText().toString());
                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" ראש ,";
                        }if (c2.isChecked()){
                            restult=restult+" צוואר ,";
                        }if (c3.isChecked()){
                            restult=restult+" חזה ,";
                        }if (c4.isChecked()){
                            restult=restult+" בטן ,";
                        }if (c5.isChecked()){
                            restult=restult+" גב ,";
                        }if (c6.isChecked()){
                            restult=restult+" גפיים עליונות ,";
                        }if (c7.isChecked()){
                            restult=restult+" גפיים תחתונות ,";
                        }if (c8.isChecked()){
                            restult=restult+" אגן ,";
                        }if (c9.isChecked()){
                            restult=restult+" אזור גניטלי ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog1",restult);

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }


        });
        chickbox_dialog_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_b, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();

                c1 = (CheckBox)promptView1.findViewById(R.id.c1);
                c2 = (CheckBox)promptView1.findViewById(R.id.c2);
                c3 = (CheckBox)promptView1.findViewById(R.id.c3);
                c4 = (CheckBox)promptView1.findViewById(R.id.c4);
                c5 = (CheckBox)promptView1.findViewById(R.id.c5);
                c6 = (CheckBox)promptView1.findViewById(R.id.c6);
                c7 = (CheckBox)promptView1.findViewById(R.id.c7);
                c8 = (CheckBox)promptView1.findViewById(R.id.c8);

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c11"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c12"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c13"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c14"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c15"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c16"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c17"));
                c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c18"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c11",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c12",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c13",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c14",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c15",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c16",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c17",c7.isChecked());
                    }
                });

                c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c18",c8.isChecked());
                    }
                });


                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c1text"));




                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1text",ctext.getText().toString());

                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" חוסר הכרה ,";
                        }if (c2.isChecked()){
                            restult=restult+" התעלפות ,";
                        }if (c3.isChecked()){
                            restult=restult+" עוויתות/פרכוסים ,";
                        }if (c4.isChecked()){
                            restult=restult+" סחרחורת ,";
                        }if (c5.isChecked()){
                            restult=restult+" בלבול ,";
                        }if (c6.isChecked()){
                            restult=restult+" הפרעות בהתנהגות ,";
                        }if (c7.isChecked()){
                            restult=restult+" שיתוק ,";
                        }if (c8.isChecked()){
                            restult=restult+" חולשה פתאומית ,";
                        }
                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog2",restult);
                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }


        });
        chickbox_dialog_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.chickbox_dialog_c, null);
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

                c1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c21"));
                c2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c22"));
                c3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c23"));
                c4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c24"));
                c5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c25"));
                c6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c26"));
                c7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c27"));
                c8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c28"));
                c9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c29"));
                c10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c210"));
                c11.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c211"));
                c12.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"c212"));

                c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c21",c1.isChecked());
                    }
                });

                c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c22",c2.isChecked());
                    }
                });

                c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c23",c3.isChecked());
                    }
                });

                c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c24",c4.isChecked());
                    }
                });

                c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c25",c5.isChecked());
                    }
                });

                c6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c26",c6.isChecked());
                    }
                });

                c7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c27",c7.isChecked());
                    }
                });

                c8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c28",c8.isChecked());
                    }
                });

                c9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c29",c9.isChecked());
                    }
                });

                c10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c210",c10.isChecked());
                    }
                });

                c11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c211",c11.isChecked());
                    }
                });

                c12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c212",c12.isChecked());
                    }
                });

                ctext = (EditText)promptView1.findViewById(R.id.ctext);
                ctext.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"c2text"));


                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"c2text",ctext.getText().toString());


                        restult="";
                        if (c1.isChecked()){
                            restult=restult+" קוצר נשימה ,";
                        }if (c2.isChecked()){
                            restult=restult+" הקאות ,";
                        }if (c3.isChecked()){
                            restult=restult+" בחילות ,";
                        }if (c4.isChecked()){
                            restult=restult+" דפיקות לב ,";
                        }if (c5.isChecked()){
                            restult=restult+" חום ,";
                        }if (c6.isChecked()){
                            restult=restult+" צמרמורת ,";
                        }if (c7.isChecked()){
                            restult=restult+" פגיעה מבע\"ח  ,";
                        }if (c8.isChecked()){
                            restult=restult+" כוויות ,";
                        }if (c9.isChecked()){
                            restult=restult+" טביעה ,";
                        }if (c10.isChecked()){
                            restult=restult+" התחשמלות ,";
                        }if (c11.isChecked()){
                            restult=restult+" העברה ,";
                        }if (c12.isChecked()){
                            restult=restult+" לידה ,";
                        }

                        restult = restult +""+ctext.getText().toString();

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog3",restult);

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }


        });


        Button button = (Button)getActivity().findViewById(R.id.num_tow_to_num_three);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num_Three fragment = new Num_Three();
                final TextView num1 = (TextView)getActivity().findViewById(R.id.number2);
                final TextView num2 = (TextView)getActivity().findViewById(R.id.number3);
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

        SharedPreferencesHelper.setSharePref(getActivity(),"text7",text7.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text8",text8.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text9",text9.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text10",text10.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text11",text11.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text12",text12.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text13",text13.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text14",text14.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text15",text15.getText().toString());
        SharedPreferencesHelper.setSharePref(getActivity(),"text16",text16.getText().toString());

        if (r11.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r11_r12"," נ ");
        }
        else if (r12.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r11_r12"," ז ");
        }




        if (r13.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r13_r14_r15_16_17"," כללית ");
        }
        else if (r14.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r13_r14_r15_16_17"," לאומית ");
        }
        else if (r15.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r13_r14_r15_16_17"," מאוחדת ");
        }
        else if (r16.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r13_r14_r15_16_17"," מכבי ");
        }
        else if (r17.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r13_r14_r15_16_17"," אחר "+" : "+text13.getText().toString());
        }




        if (r18.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r18_r19_r20_r21","  סיבת הקריאה ");
        }
        else if (r19.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r18_r19_r20_r21","  תלונה עיקריתשל החולה ");
        }
        else if (r20.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r18_r19_r20_r21","  נפגע במקום ");
        }
        else if (r21.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r18_r19_r20_r21"," דיווחראשוני "+" : "+text14.getText().toString());
        }



        if (r22.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r22_r23","  רגילה ");
        }
        else if (r23.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r22_r23","  דחופה ");
        }


        if (r24.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r24_r25"," רגילה ");
        }
        else if (r25.isChecked()){
            SharedPreferencesHelper.setSharePref(getActivity(),"r24_r25","  דחופה ");
        }



    }

}