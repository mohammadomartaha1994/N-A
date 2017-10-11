package com.example.mohammad.nouran;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by mohammad on 5/28/2017.
 */

public class Num_Six extends Fragment implements View.OnClickListener {
    EditText num1,num2,num3,num4,num5;
    DBManager dbManager;
    String restult="",lastrestult="";
    ListView list;
    private int PICK_IMAGE_REQUEST = 1;
    String InfoFromDatabase,InfoFromDatabase1,InfoFromDatabase3,InfoFromDatabase4,InfoFromDatabase5,InfoFromDatabase6,InfoFromDatabase7,InfoFromDatabase2;
    CheckBox Fc1,Fc2,Fc3,Fc4,Fc5,Fc6,Fc7,Fc8,Fc9,Fc10,cd1,cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10,cd11,cd12,cd13,cd14,cd15,cd16,cd17,cd18,cd19,cd20,cd21,cd22,cd23,cd24,cd25,cd26,cd27,cd28;
    EditText textd1,textd2,textd3,textd4,textd5,textd6,textd7,textd8,textd9,textd10,textd11,textd12,textd13,textd14,textd15,textd16,textd17,textd18,textd19,textd20,textd21,textd22,textd23,textd24,textd25,textd26,textd27,textd28;
    EditText text29 ;

    Button medicines ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.num_six, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text29=(EditText)getActivity().findViewById(R.id.text29);
        text29.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text29"));




        Fc1 = (CheckBox)getActivity().findViewById(R.id.Fc1);
        Fc2 = (CheckBox)getActivity().findViewById(R.id.Fc2);
        Fc3 = (CheckBox)getActivity().findViewById(R.id.Fc3);
        Fc4 = (CheckBox)getActivity().findViewById(R.id.Fc4);
        Fc5 = (CheckBox)getActivity().findViewById(R.id.Fc5);
        Fc6 = (CheckBox)getActivity().findViewById(R.id.Fc6);
        Fc7 = (CheckBox)getActivity().findViewById(R.id.Fc7);
        Fc8 = (CheckBox)getActivity().findViewById(R.id.Fc8);
        Fc9 = (CheckBox)getActivity().findViewById(R.id.Fc9);
        Fc10 = (CheckBox)getActivity().findViewById(R.id.Fc10);

        Fc1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc1"));
        Fc2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc2"));
        Fc3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc3"));
        Fc4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc4"));
        Fc5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc5"));
        Fc6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc6"));
        Fc7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc7"));
        Fc8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc8"));
        Fc9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc9"));
        Fc10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"Fc10"));

        Fc1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc1",Fc1.isChecked());
            }
        });

        Fc2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc2",Fc2.isChecked());
            }
        });

        Fc3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc3",Fc3.isChecked());
            }
        });

        Fc4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc4",Fc4.isChecked());
            }
        });

        Fc5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc5",Fc5.isChecked());
            }
        });

        Fc6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc6",Fc6.isChecked());
            }
        });

        Fc7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc7",Fc7.isChecked());
            }
        });

        Fc8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc8",Fc8.isChecked());
            }
        });
        Fc9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc9",Fc9.isChecked());
            }
        });

        Fc10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferencesHelper.setSharePref(getActivity(),"Fc10",Fc10.isChecked());
            }
        });


        medicines = (Button)getActivity().findViewById(R.id.medicines);
        medicines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.medicines_dialog, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                cd1 = (CheckBox)promptView1.findViewById(R.id.cd1);
                cd2 = (CheckBox)promptView1.findViewById(R.id.cd2);
                cd3 = (CheckBox)promptView1.findViewById(R.id.cd3);
                cd4 = (CheckBox)promptView1.findViewById(R.id.cd4);
                cd5 = (CheckBox)promptView1.findViewById(R.id.cd5);
                cd6 = (CheckBox)promptView1.findViewById(R.id.cd6);
                cd7 = (CheckBox)promptView1.findViewById(R.id.cd7);
                cd8 = (CheckBox)promptView1.findViewById(R.id.cd8);
                cd9 = (CheckBox)promptView1.findViewById(R.id.cd9);
                cd10 = (CheckBox)promptView1.findViewById(R.id.cd10);
                cd11 = (CheckBox)promptView1.findViewById(R.id.cd11);
                cd12 = (CheckBox)promptView1.findViewById(R.id.cd12);
                cd13 = (CheckBox)promptView1.findViewById(R.id.cd13);
                cd14 = (CheckBox)promptView1.findViewById(R.id.cd14);
                cd15 = (CheckBox)promptView1.findViewById(R.id.cd15);
                cd16 = (CheckBox)promptView1.findViewById(R.id.cd16);
                cd17 = (CheckBox)promptView1.findViewById(R.id.cd17);
                cd18 = (CheckBox)promptView1.findViewById(R.id.cd18);
                cd19 = (CheckBox)promptView1.findViewById(R.id.cd19);
                cd20 = (CheckBox)promptView1.findViewById(R.id.cd20);
                cd21 = (CheckBox)promptView1.findViewById(R.id.cd21);
                cd22 = (CheckBox)promptView1.findViewById(R.id.cd22);
                cd23 = (CheckBox)promptView1.findViewById(R.id.cd23);
                cd24 = (CheckBox)promptView1.findViewById(R.id.cd24);
                cd25 = (CheckBox)promptView1.findViewById(R.id.cd25);
                cd26 = (CheckBox)promptView1.findViewById(R.id.cd26);
                cd27 = (CheckBox)promptView1.findViewById(R.id.cd27);
                cd28 = (CheckBox)promptView1.findViewById(R.id.cd28);

                textd1 = (EditText) promptView1.findViewById(R.id.textd1);
                textd2 = (EditText) promptView1.findViewById(R.id.textd2);
                textd3 = (EditText) promptView1.findViewById(R.id.textd3);
                textd4 = (EditText) promptView1.findViewById(R.id.textd4);
                textd5 = (EditText) promptView1.findViewById(R.id.textd5);
                textd6 = (EditText) promptView1.findViewById(R.id.textd6);
                textd7 = (EditText) promptView1.findViewById(R.id.textd7);
                textd8 = (EditText) promptView1.findViewById(R.id.textd8);
                textd9 = (EditText) promptView1.findViewById(R.id.textd9);
                textd10 = (EditText) promptView1.findViewById(R.id.textd10);
                textd11 = (EditText) promptView1.findViewById(R.id.textd11);
                textd12 = (EditText) promptView1.findViewById(R.id.textd12);
                textd13 = (EditText) promptView1.findViewById(R.id.textd13);
                textd14 = (EditText) promptView1.findViewById(R.id.textd14);
                textd15 = (EditText) promptView1.findViewById(R.id.textd15);
                textd16 = (EditText) promptView1.findViewById(R.id.textd16);
                textd17 = (EditText) promptView1.findViewById(R.id.textd17);
                textd18 = (EditText) promptView1.findViewById(R.id.textd18);
                textd19 = (EditText) promptView1.findViewById(R.id.textd19);
                textd20 = (EditText) promptView1.findViewById(R.id.textd20);
                textd21 = (EditText) promptView1.findViewById(R.id.textd21);
                textd22 = (EditText) promptView1.findViewById(R.id.textd22);
                textd23 = (EditText) promptView1.findViewById(R.id.textd23);
                textd24 = (EditText) promptView1.findViewById(R.id.textd24);
                textd25 = (EditText) promptView1.findViewById(R.id.textd25);
                textd26 = (EditText) promptView1.findViewById(R.id.textd26);
                textd27 = (EditText) promptView1.findViewById(R.id.textd27);
                textd28 = (EditText) promptView1.findViewById(R.id.textd28);



                cd1.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd1"));
                cd2.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd2"));
                cd3.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd3"));
                cd4.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd4"));
                cd5.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd5"));
                cd6.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd6"));
                cd7.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd7"));
                cd8.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd8"));
                cd9.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd9"));
                cd10.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd10"));
                cd11.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd11"));
                cd12.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd12"));
                cd13.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd13"));
                cd14.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd14"));
                cd15.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd15"));
                cd16.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd16"));
                cd17.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd17"));
                cd18.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd18"));
                cd19.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd19"));
                cd20.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd20"));
                cd21.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd21"));
                cd22.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd22"));
                cd23.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd23"));
                cd24.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd24"));
                cd25.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd25"));
                cd26.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd26"));
                cd27.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd27"));
                cd28.setChecked(SharedPreferencesHelper.getBooleanSharedPref(getActivity(),"cd28"));

                textd1.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd1"));
                textd2.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd2"));
                textd3.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd3"));
                textd4.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd4"));
                textd5.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd5"));
                textd6.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd6"));
                textd7.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd7"));
                textd8.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd8"));
                textd9.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd9"));
                textd10.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd10"));
                textd11.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd11"));
                textd12.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd12"));
                textd13.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd13"));
                textd14.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd14"));
                textd15.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd15"));
                textd16.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd16"));
                textd17.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd17"));
                textd18.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd18"));
                textd19.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd19"));
                textd20.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd20"));
                textd21.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd21"));
                textd22.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd22"));
                textd23.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd23"));
                textd24.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd24"));
                textd25.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd25"));
                textd26.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd26"));
                textd27.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd27"));
                textd28.setText(SharedPreferencesHelper.getStringSharedPref(getActivity(),"textd28"));






                final Button close = (Button)promptView1.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd1",cd1.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd2",cd2.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd3",cd3.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd4",cd4.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd5",cd5.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd6",cd6.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd7",cd7.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd8",cd8.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd9",cd9.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd10",cd10.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd11",cd11.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd12",cd12.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd13",cd13.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd14",cd14.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd15",cd15.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd16",cd16.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd17",cd17.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd18",cd18.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd19",cd19.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd20",cd20.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd21",cd21.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd22",cd22.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd23",cd23.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd24",cd24.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd25",cd25.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd26",cd26.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd27",cd27.isChecked());
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd28",cd28.isChecked());


                        SharedPreferencesHelper.setSharePref(getActivity(),"textd1",textd1.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd2",textd2.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd3",textd3.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd4",textd4.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd5",textd5.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd6",textd6.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd7",textd7.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd8",textd8.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd9",textd9.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd10",textd10.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd11",textd11.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd12",textd12.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd13",textd13.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd14",textd14.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd15",textd15.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd16",textd16.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd17",textd17.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd18",textd18.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd19",textd19.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd20",textd20.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd21",textd21.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd22",textd22.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd23",textd23.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd24",textd24.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd25",textd25.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd26",textd26.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd27",textd27.getText().toString());
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd28",textd28.getText().toString());



                        restult="";
                        if (cd1.isChecked()){
                            restult=restult+" Adrenaline : "+textd1.getText().toString()+" \n ";
                        }if (cd2.isChecked()){
                            restult=restult+" Atropine : "+textd2.getText().toString()+" \n";
                        }if (cd3.isChecked()){
                            restult=restult+" Assival : "+textd3.getText().toString()+" \n";
                        }if (cd4.isChecked()){
                            restult=restult+" Amiodarone : "+textd4.getText().toString()+" \n";
                        }if (cd5.isChecked()){
                            restult=restult+" Calcium : "+textd5.getText().toString()+" \n";
                        }if (cd6.isChecked()){
                            restult=restult+" Dormicum : "+textd6.getText().toString()+" \n";
                        }if (cd7.isChecked()){
                            restult=restult+" Dextrose : "+textd7.getText().toString()+" \n";
                        }if (cd8.isChecked()){
                            restult=restult+" Dopamine : "+textd8.getText().toString()+" \n";
                        }if (cd9.isChecked()){
                            restult=restult+" Fuside : "+textd9.getText().toString()+" \n";
                        }if (cd10.isChecked()){
                            restult=restult+" Ikacor : "+textd10.getText().toString()+" \n";
                        } if (cd11.isChecked()){
                            restult=restult+" Lidocaine : "+textd11.getText().toString()+" \n";
                        }if (cd12.isChecked()){
                            restult=restult+" Morphine : "+textd12.getText().toString()+" \n";
                        }if (cd13.isChecked()){
                            restult=restult+" Bicarbonate : "+textd13.getText().toString()+" \n";
                        }if (cd14.isChecked()){
                            restult=restult+" Narcan : "+textd14.getText().toString()+" \n";
                        }if (cd15.isChecked()){
                            restult=restult+" Pramin : "+textd15.getText().toString()+" \n";
                        }if (cd16.isChecked()){
                            restult=restult+" Ketamin : "+textd16.getText().toString()+" \n";
                        }if (cd17.isChecked()){
                            restult=restult+" Aerovent : "+textd17.getText().toString()+" \n";
                        }if (cd18.isChecked()){
                            restult=restult+" Ventolin : "+textd18.getText().toString()+" \n";
                        }if (cd19.isChecked()){
                            restult=restult+" Isoket : "+textd19.getText().toString()+" \n";
                        }if (cd20.isChecked()){
                            restult=restult+" Acamol : "+textd20.getText().toString()+" \n";
                        } if (cd21.isChecked()){
                            restult=restult+" Aspirin : "+textd21.getText().toString()+" \n";
                        }if (cd22.isChecked()){
                            restult=restult+" Cordil : "+textd22.getText().toString()+" \n";
                        }if (cd23.isChecked()){
                            restult=restult+" Capoten : "+textd23.getText().toString()+" \n";
                        }if (cd24.isChecked()){
                            restult=restult+" Optalgin : "+textd24.getText().toString()+" \n";
                        }if (cd25.isChecked()){
                            restult=restult+" Magnezium : "+textd25.getText().toString()+" \n";
                        }if (cd26.isChecked()){
                            restult=restult+" Adenozine : "+textd26.getText().toString()+" \n";
                        }if (cd27.isChecked()){
                            restult=restult+" Heparin : "+textd27.getText().toString()+" \n";
                        }if (cd28.isChecked()){
                            restult=restult+" Solo-medrol : "+textd28.getText().toString()+" \n";
                        }

                        SharedPreferencesHelper.setSharePref(getActivity(),"dialog21",restult);

                        alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();
            }
        });
        dbManager=new DBManager(getActivity());
        Button done = (Button)getActivity().findViewById(R.id.Done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(getActivity());
                final View promptView1 = layoutInflater1.inflate(R.layout.dialogdone, null);
                final AlertDialog alertD1 = new AlertDialog.Builder(getActivity()).create();
                final ImageButton print = (ImageButton)promptView1.findViewById(R.id.print);
                final Button another = (Button)promptView1.findViewById(R.id.another);
                final Button send = (Button)promptView1.findViewById(R.id.send);
                final ImageButton Email = (ImageButton)promptView1.findViewById(R.id.email);


                lastrestult="";
                if (Fc1.isChecked()){
                    lastrestult=lastrestult+" IV ,";
                }if (Fc2.isChecked()){
                    lastrestult=lastrestult+" IM ,";
                }if (Fc3.isChecked()){
                    lastrestult=lastrestult+" SL ,";
                }if (Fc4.isChecked()){
                    lastrestult=lastrestult+" Chew ,";
                }if (Fc5.isChecked()){
                    lastrestult=lastrestult+" Inhal ,";
                }if (Fc6.isChecked()){
                    lastrestult=lastrestult+" ET ,";
                }if (Fc7.isChecked()){
                    lastrestult=lastrestult+" PO ,";
                }if (Fc8.isChecked()){
                    lastrestult=lastrestult+" SC ,";
                }if (Fc9.isChecked()){
                    lastrestult=lastrestult+" IO ,";
                }if (Fc10.isChecked()){
                    lastrestult=lastrestult+" PR ,";
                }

                Log.i("aa",lastrestult);



                Email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        composeEmail();
                    }
                });


                print.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doWebViewPrint();
                    }
                });

                another.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                                Num_Tow fragment = new Num_Tow();
                                final TextView num1 = (TextView)getActivity().findViewById(R.id.number6);
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

                        SharedPreferencesHelper.setSharePref(getActivity(),"r11",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r12",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r13",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r14",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r15",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r16",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r17",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r18",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r19",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r20",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r21",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r22",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r23",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r24",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r25",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re9",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re10",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"r26",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r27",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r28",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r29",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r30",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r31",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r32",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r33",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r34",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r35",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r36",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r37",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r38",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r39",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r40",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r41",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r42",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc9",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc10",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"cd1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd9",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd10",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd11",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd12",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd13",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd14",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd15",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd16",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd17",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd18",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd19",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd20",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd21",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd22",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd23",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd24",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd25",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd26",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd27",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd28",false);


                        SharedPreferencesHelper.setSharePref(getActivity(),"c1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c9",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c11",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c12",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c13",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c14",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c15",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c16",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c17",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c18",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c21",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c22",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c23",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c24",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c25",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c26",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c27",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c28",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c29",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c210",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c211",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c212",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c31",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c32",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c33",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c34",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c35",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c36",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c37",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c38",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c41",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c42",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c43",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c44",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c45",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c51",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c52",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c53",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c54",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c61",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c62",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c63",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c64",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c65",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c66",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c71",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c72",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c73",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c74",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c75",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c76",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c77",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c78",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c79",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c710",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c711",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c712",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c713",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c714",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c715",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c716",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c717",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c718",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c719",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c720",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c721",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c722",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c723",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c724",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c725",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c81",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c82",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c83",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c84",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c85",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c91",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c92",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c93",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c94",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c95",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c96",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c97",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c98",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c99",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c910",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c911",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c912",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c913",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c914",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c101",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c102",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c103",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c104",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c105",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c106",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c107",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c108",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c109",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1010",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1011",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1012",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1013",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c111",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c112",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c113",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c114",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c115",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c121",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c122",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c123",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c124",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c125",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c126",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c127",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c131",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c132",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c133",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c134",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c135",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c141",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c142",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c143",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c144",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c145",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c146",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c151",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c152",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c153",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c154",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c155",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c156",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c157",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c158",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c159",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1510",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1511",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1512",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c161",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c162",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c163",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c164",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c165",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c166",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c167",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c168",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c169",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c171",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c172",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c173",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c174",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c175",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c176",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c177",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"text7","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text8","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text9","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text10","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text11","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text12","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text13","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text14","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text15","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text16","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"ctext","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c2text","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"c3text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"crtext","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c4text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"cgtext","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c5text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c6text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c7text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c8text","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"text17","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text18","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text19","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text20","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text21","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c9text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c10text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c11text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c12text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c13text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c14text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c15text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c16text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c17text","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"text22","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text23","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text24","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text25","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text26","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text27","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text28","");


                        SharedPreferencesHelper.setSharePref(getActivity(),"text29","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"textd1","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd2","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd3","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd4","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd5","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd6","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd7","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd8","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd9","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd10","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd11","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd12","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd13","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd14","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd15","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd16","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd17","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd18","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd19","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd20","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd21","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd22","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd23","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd24","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd25","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd26","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd27","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd28","");


                        SharedPreferencesHelper.setSharePref(getActivity(),"scoure1","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"scoure2","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"scoure3","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"totalscoure","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r26_r27","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"r11_r12","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r13_r14_r15_16_17","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r18_r19_r20_r21","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r22_r23","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r24_r25","");


                        dbManager.DeleteAll();

                                alertD1.dismiss();
                    }
                });
                alertD1.setView(promptView1);
                alertD1.show();


                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Num_One fragment = new Num_One();
                        final TextView num1 = (TextView)getActivity().findViewById(R.id.number6);
                        final TextView num2 = (TextView)getActivity().findViewById(R.id.number1);
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

                        SharedPreferencesHelper.setSharePref(getActivity(),"r1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r9",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r10",false);


                        SharedPreferencesHelper.setSharePref(getActivity(),"r11",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r12",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r13",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r14",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r15",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r16",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r17",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r18",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r19",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r20",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r21",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r22",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r23",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r24",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r25",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re9",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"re10",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"r26",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r27",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r28",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r29",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r30",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r31",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r32",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r33",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r34",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r35",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r36",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r37",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r38",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r39",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r40",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r41",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"r42",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc9",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"Fc10",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"cd1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd9",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd10",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd11",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd12",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd13",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd14",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd15",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd16",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd17",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd18",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd19",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd20",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd21",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd22",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd23",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd24",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd25",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd26",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd27",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"cd28",false);


                        SharedPreferencesHelper.setSharePref(getActivity(),"c1",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c2",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c3",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c4",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c5",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c6",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c7",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c8",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c9",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c11",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c12",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c13",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c14",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c15",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c16",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c17",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c18",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c21",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c22",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c23",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c24",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c25",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c26",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c27",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c28",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c29",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c20",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c211",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c212",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c31",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c32",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c33",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c34",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c35",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c36",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c37",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c38",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c41",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c42",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c43",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c44",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c45",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c51",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c52",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c53",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c54",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c61",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c62",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c63",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c64",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c65",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c66",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c71",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c72",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c73",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c74",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c75",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c76",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c77",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c78",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c79",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c710",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c711",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c712",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c713",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c714",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c715",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c716",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c717",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c718",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c719",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c720",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c721",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c722",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c723",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c724",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c725",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c81",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c82",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c83",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c84",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c85",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c91",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c92",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c93",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c94",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c95",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c96",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c97",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c98",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c99",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c910",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c911",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c912",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c913",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c914",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c101",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c102",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c103",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c104",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c105",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c106",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c107",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c108",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c109",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1010",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1011",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1012",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1013",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c111",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c112",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c113",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c114",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c115",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c121",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c122",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c123",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c124",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c125",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c126",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c127",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c131",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c132",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c133",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c134",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c135",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c141",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c142",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c143",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c144",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c145",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c146",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c151",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c152",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c153",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c154",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c155",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c156",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c157",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c158",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c159",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1510",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1511",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1512",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c161",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c162",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c163",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c164",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c165",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c166",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c167",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c168",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c169",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"c171",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c172",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c173",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c174",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c175",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c176",false);
                        SharedPreferencesHelper.setSharePref(getActivity(),"c177",false);

                        SharedPreferencesHelper.setSharePref(getActivity(),"text1","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text2","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text3","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text4","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text5","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text6","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text7","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text8","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text9","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text10","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text11","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text12","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text13","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text14","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text15","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text16","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"ctext","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c1text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c2text","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"c3text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"crtext","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c4text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"cgtext","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c5text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c6text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c7text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c8text","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"text17","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text18","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text19","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text20","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text21","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c9text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c10text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c11text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c12text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c13text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c14text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c15text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c16text","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"c17text","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"text22","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text23","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text24","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text25","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text26","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text27","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"text28","");


                        SharedPreferencesHelper.setSharePref(getActivity(),"text29","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"textd1","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd2","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd3","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd4","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd5","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd6","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd7","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd8","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd9","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd10","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd11","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd12","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd13","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd14","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd15","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd16","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd17","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd18","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd19","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd20","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd21","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd22","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd23","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd24","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd25","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd26","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd27","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"textd28","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"scoure1","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"scoure2","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"scoure3","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"totalscoure","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r26_r27","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"r11_r12","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r13_r14_r15_16_17","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r18_r19_r20_r21","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r22_r23","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r24_r25","");

                        SharedPreferencesHelper.setSharePref(getActivity(),"r1_r2","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r3_r4_r5","");
                        SharedPreferencesHelper.setSharePref(getActivity(),"r6_r7_r8_r9_r10","");


                        dbManager.DeleteAll();
                        alertD1.dismiss();


//
//
//
//                        if(SharedPreferencesHelper.getStringSharedPref(getActivity(),"text5").isEmpty()){
//
//                        }
//                        else{
//                            ContentValues values = new ContentValues();
//                            values.put(DBManager.ColName,SharedPreferencesHelper.getStringSharedPref(getActivity(),"text5"));
//                            dbManager.Insert(values);
//                        }
//
//                        if(SharedPreferencesHelper.getStringSharedPref(getActivity(),"secondSpinnerText").isEmpty()){
//
//                        }
//                        else{
//                            ContentValues values = new ContentValues();
//                            values.put(DBManager.ColName,SharedPreferencesHelper.getStringSharedPref(getActivity(),"secondSpinnerText"));
//                            dbManager.InsertS(values);
//                        }

                    }
                });
            }
        });
        LoadElement();
    }
    @Override
    public void onClick(View v) {}
    @Override
    public void onPause() {
        super.onPause();
    }

    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{SharedPreferencesHelper.getEmailSharedPref(getActivity(),"Email")});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Nouran Association");
        String filepath = SharedPreferencesHelper.getStringSharedPref(getActivity(),"filePath");
        if (!filepath.isEmpty()){
            File myFile = new File(filepath.toString());
            intent.putExtra(Intent.EXTRA_STREAM, Uri.parse( "file://"+filepath.toString()));
            Log.d("aa",filepath);
            Log.d("aa",myFile.getAbsolutePath());
        }
        intent.putExtra(Intent.EXTRA_TEXT,


                " טופס טיפול בחולה/נפגע באמבולנס : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r1_r2")+"\n\n" +
                        " תאריך : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"date")+"\n\n" +
                        " משמרת : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r3_r4_r5")+"\n\n" +
                        " קוד רכב : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text1")+"\n\n" +

                        " מס\\\" קבלה / התחיבות : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text2")+"\n\n" +
                        " שעת קבלת הקריאה : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME1")+"\n\n" +
                        " שעת יציאהלאירוע : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME2")+"\n\n" +
                        " שעת הגעה לאירוע : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME3")+"\n\n" +
                        " שעת יציאה מהאירוע : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME4")+"\n\n" +
                        " שעת הגעה ליעד/ לביה\\\"ח : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME5")+"\n\n" +
                        " יעד פינוי : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME6")+"\n\n" +
                        " איש צוות מקבל : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME7")+"\n\n" +
                        " מקום האירוע : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r6_r7_r8_r9_r10")+"\n\n" +
                        " כתובת  האירוע : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text6")+"\n\n" +
                        " שם החולה/ הנפגע : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text7")+"\n\n" +
                        " ת.ז : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text8")+"\n\n" +
                        " גיל : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text9")+"\n\n" +
                        " מין : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r11_r12")+"\n\n" +
                        " כתובת מגורים : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text10")+"\n\n" +
                        " מספר טלפון : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text11")+"\n\n" +


                        " מספר נייד : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text12")+"\n\n" +
                        " קופ\\\"ח  : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r13_r14_r15_16_17")+"\n\n" +
                        " "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r18_r19_r20_r21")+"\n\n" +
                        "כאבים ב  : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog1")+"\n\n" +

                        " תלונה נוירולוגיה : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog2")+"\n\n" +
                        " ארוע והפרעות אחרות : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog3")+"\n\n" +
                        " רגישות ידועה לתרופות/ אחרים : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text15")+"\n\n" +

                        " אופן הנסיעה לאירוע : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r22_r23")+"\n\n" +
                        " אופן הנסיעה מהאירוע לביה\\\"ח : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r24_r25")+"\n\n" +
                        " מספר רכבים המעורבים בתאונה : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text16")+"\n\n" +
                        " עור ומילוי קפילארי : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog4")+"\n\n" +
                        " אישונים : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog5")+"\n\n" +
                        " ריאות : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog6")+"\n\n" +
                        " בטן : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog7")+"\n\n" +
                        " סימני אי ספיקה : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog8")+"\n\n" +
                        " קצב הלב : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog9")+"\n\n" +
                        " א.ק.ג : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog10")+"\n\n" +
                        "א.ק.ג בהשבאה לקודם : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog11")+"\n\n" +

                        " Cardiac : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog14")+"\n\n" +
                        " Respiratory : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog15")+"\n\n" +
                        " Neurologic : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog16")+"\n\n" +
                        " Trauma : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog17")+"\n\n" +
                        " Location of injury : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog18")+"\n\n" +
                        " Type of injury : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog19")+"\n\n" +
                        " Other : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog20")+"\n\n\n\n" +

                        " זמן : "+InfoFromDatabase7+"\n\n" +
                        " לחץ דם : "+InfoFromDatabase6+"\n\n" +
                        " דופק : "+InfoFromDatabase5+"\n\n" +
                        " סטורציה : "+InfoFromDatabase4+"\n\n" +
                        " חום : "+InfoFromDatabase3+"\n\n" +
                        " קצב נשימה : "+InfoFromDatabase2+"\n\n" +
                        " סוכר בדם : "+InfoFromDatabase1+"\n\n" +
                        " ETCO2 : "+InfoFromDatabase+"\n\n\n\n" +


                        " שמות אנשי הצוות:רופא : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text17")+"\n\n" +
                        " פראמדיק : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text18")+"\n\n" +
                        " נהג : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text19")+"\n\n" +
                        " חובש/חובש בכיר : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text20")+"\n\n" +
                        " משתלם : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text21")+"\n\n" +
                        " הרגלים ומחלות עבר ידועות : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog12")+"\n\n" +
                        " שימוש קבוע בתרופות : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog13")+"\n\n" +
                        " שוקים : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r26_r27")+"\n\n" +
                        "מס\\\" נסיונות להכנסת אינטובציה(ET tube) : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text26")+"\n\n" +
                        " מס\\\" נסיונות להכנסת עירויים(IV) : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text25")+"\n\n" +
                        " מס\\\" עירויים(IV) שהוכנסו : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text24")+"\n\n" +
                        " מס\" Big(IO) שהוכנסו  : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text23")+"\n\n" +

                        " מס\\\" נסיונות להכנסת Big(IO) : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text22")+"\n\n" +
                        " motor response : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure3text")+" "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure3")+"\n\n"  +
                        " verbal response : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure2text")+" "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure2")+"\n\n" +
                        " Eye opening : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure1text")+" "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure1")+"\n\n"  +
                        "  "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"totalscoure")+"\n\n" +

                        " הערות/ בדיקה גופנית וטיפולים : "+text29.getText().toString()+"\n\n" +
                        " ציין מינון התרופה / ודרך מתן/ \\n\" +\n" +
                        "           וכמה פעמים ניתנה\\n : "+lastrestult+"\n\n"
        );
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

        if(isInternetConnected(getActivity())){

            final Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }
                }
            };
            AddIDreq AddIDreq = new AddIDreq(SharedPreferencesHelper.getStringSharedPref(getActivity(),"r1_r2"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"date"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"r3_r4_r5"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text1"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text2"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME1"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME2"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME3"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME4"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME5"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME6"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME7"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"r6_r7_r8_r9_r10"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text6"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text7"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text8"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text9"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"r11_r12"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text10"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text11"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text12"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"r13_r14_r15_16_17"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"r18_r19_r20_r21"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog1"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog2"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog3"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text15"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"r22_r23"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"r24_r25"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text16"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog4"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog5"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog6"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog7"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog8"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog9"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog10"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog11"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog14"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog15"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog16"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog17"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog18"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog19"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog20"),
                    InfoFromDatabase7,
                    InfoFromDatabase6,
                    InfoFromDatabase5,
                    InfoFromDatabase4,
                    InfoFromDatabase3,
                    InfoFromDatabase2,
                    InfoFromDatabase1,
                    InfoFromDatabase,
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text17"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text18"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text19"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text20"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text21"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog12"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog13"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"r26_r27"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text26"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text25"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text24"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text23"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"text22"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure3text"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure3"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure2text"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure2"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure1text"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure1"),
                    SharedPreferencesHelper.getStringSharedPref(getActivity(),"totalscoure"),
                    text29.getText().toString(),
                    lastrestult,
                    responseListener);
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            queue.add(AddIDreq);


        }
        else {

            ContentValues values=new ContentValues();
            values.put(DBManager.Col1, SharedPreferencesHelper.getStringSharedPref(getActivity(),"r1_r2"));
            values.put(DBManager.Col2, SharedPreferencesHelper.getStringSharedPref(getActivity(),"date"));
            values.put(DBManager.Col3, SharedPreferencesHelper.getStringSharedPref(getActivity(),"r3_r4_r5"));
            values.put(DBManager.Col4, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text1"));
            values.put(DBManager.Col5, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text2"));
            values.put(DBManager.Col6, SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME1"));
            values.put(DBManager.Col7, SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME2"));
            values.put(DBManager.Col8, SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME3"));
            values.put(DBManager.Col9, SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME4"));
            values.put(DBManager.Col10, SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME5"));

            values.put(DBManager.Col11, SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME6"));
            values.put(DBManager.Col12, SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME7"));
            values.put(DBManager.Col13, SharedPreferencesHelper.getStringSharedPref(getActivity(),"r6_r7_r8_r9_r10"));
            values.put(DBManager.Col14, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text6"));
            values.put(DBManager.Col15, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text7"));
            values.put(DBManager.Col16, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text8"));
            values.put(DBManager.Col17, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text9"));
            values.put(DBManager.Col18, SharedPreferencesHelper.getStringSharedPref(getActivity(),"r11_r12"));
            values.put(DBManager.Col19, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text10"));
            values.put(DBManager.Col20, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text11"));

            values.put(DBManager.Col21, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text12"));
            values.put(DBManager.Col22, SharedPreferencesHelper.getStringSharedPref(getActivity(),"r13_r14_r15_16_17"));
            values.put(DBManager.Col23, SharedPreferencesHelper.getStringSharedPref(getActivity(),"r18_r19_r20_r21"));
            values.put(DBManager.Col24, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog1"));
            values.put(DBManager.Col25, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog2"));
            values.put(DBManager.Col26, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog3"));
            values.put(DBManager.Col27, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text15"));
            values.put(DBManager.Col28, SharedPreferencesHelper.getStringSharedPref(getActivity(),"r22_r23"));
            values.put(DBManager.Col29, SharedPreferencesHelper.getStringSharedPref(getActivity(),"r24_r25"));
            values.put(DBManager.Col30, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text16"));

            values.put(DBManager.Col31, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog4"));
            values.put(DBManager.Col32, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog5"));
            values.put(DBManager.Col33, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog6"));
            values.put(DBManager.Col34, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog7"));
            values.put(DBManager.Col35, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog8"));
            values.put(DBManager.Col36, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog9"));
            values.put(DBManager.Col37, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog10"));
            values.put(DBManager.Col38, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog11"));
            values.put(DBManager.Col39, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog14"));
            values.put(DBManager.Col40, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog15"));

            values.put(DBManager.Col41, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog16"));
            values.put(DBManager.Col42, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog17"));
            values.put(DBManager.Col43, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog18"));
            values.put(DBManager.Col44, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog19"));
            values.put(DBManager.Col45, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog20"));
            values.put(DBManager.Col46, InfoFromDatabase7);
            values.put(DBManager.Col47, InfoFromDatabase6);
            values.put(DBManager.Col48, InfoFromDatabase5);
            values.put(DBManager.Col49, InfoFromDatabase4);
            values.put(DBManager.Col50, InfoFromDatabase3);

            values.put(DBManager.Col51, InfoFromDatabase2);
            values.put(DBManager.Col52, InfoFromDatabase1);
            values.put(DBManager.Col53, InfoFromDatabase);
            values.put(DBManager.Col54, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text17"));
            values.put(DBManager.Col55, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text18"));
            values.put(DBManager.Col56, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text19"));
            values.put(DBManager.Col57, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text20"));
            values.put(DBManager.Col58, SharedPreferencesHelper.getStringSharedPref(getActivity(),"text21"));
            values.put(DBManager.Col59, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog12"));
            values.put(DBManager.Col60, SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog13"));

            values.put(DBManager.Col61,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"r26_r27"));
            values.put(DBManager.Col62,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"text26"));
            values.put(DBManager.Col63,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"text25"));
            values.put(DBManager.Col64,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"text24"));
            values.put(DBManager.Col65,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"text23"));
            values.put(DBManager.Col66,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"text22"));
            values.put(DBManager.Col67,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure3text"));
            values.put(DBManager.Col68,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure3"));
            values.put(DBManager.Col69,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure2text"));
            values.put(DBManager.Col70,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure2"));

            values.put(DBManager.Col71,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure1text"));
            values.put(DBManager.Col72,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure1"));
            values.put(DBManager.Col73,  SharedPreferencesHelper.getStringSharedPref(getActivity(),"totalscoure"));
            values.put(DBManager.Col74,  text29.getText().toString());
            values.put(DBManager.Col75,  lastrestult);

            Long h =dbManager.InsertOffLine(values);
            Log.d("h",h+"");
        }


    }

    private void createWebPrintJob(WebView webView) {

        // Get a PrintManager instance
        PrintManager printManager = (PrintManager) getActivity()
                .getSystemService(Context.PRINT_SERVICE);
        PrintDocumentAdapter printAdapter;
        Log.i("first",1+"");
        // Get a print adapter instance
        int currentApiVersion = Build.VERSION.SDK_INT;
        if (currentApiVersion > Build.VERSION_CODES.LOLLIPOP){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                printAdapter = webView.createPrintDocumentAdapter("Nouran");
            }
            else
                printAdapter = webView.createPrintDocumentAdapter();

        } else {
             printAdapter = webView.createPrintDocumentAdapter();
        }
        Log.i("first",2+"");

        // Create a print job with name and adapter instance
        String jobName = getString(R.string.app_name) + " Document";
        PrintJob printJob = printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());
        Log.i("first",3+"");

        // Save the job object for later status checking
        //mPrintJobs.add(printJob);
    }

    private void doWebViewPrint() {
        WebView webView = new WebView(getActivity());
        Log.i("first",4+"");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                createWebPrintJob(view);
            }
        });


        String htmlDocument = "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body dir=\"rtl\" >\n" +
                "<center><h3 ><center dir=\"ltr\">Nuran –charitable association (R”A)</center>\n" +
                "<p>\n" +
                "נוראן עמותה למתן עזרה במצבי מצוקה והדרכה קהילתית ורווחת הקהילה (ע\"ר)\n" +
                "אמבולנס נוראן\n" +
                " <p>\n" +
                "טופס טיפול בחולה/נפגע באמבולנס ("+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r1_r2")+")  מס\" <p>                  No. 111111\n" +
                "<hr>\n" +
                "</h3></center>\n" +
                "\n" +
                "\n" +
                "<table style=\"width:100%;padding:10px; align:right;\"  DIR=\"RTL\">\n" +
                "<tr>\n" +
                "    <td>תאריך: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"date")+"</td>\n" +
                "    <td>משמרת: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r3_r4_r5")+"</td> \n" +
                "    <td>קוד רכב: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text1")+"</td>\n" +
                "    <td>מס\" קבלה / התחיבות: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text2")+"</td>\n" +
                "  </tr>\n" +
                "  </table>\n" +
                "  <hr>\n" +
                "  \n" +
                "<table style=\"width:75%;padding:10px; align:right;\"  DIR=\"RTL\">\n" +
                "  <tr>\n" +
                "    <td>שעת קבלת הקריאה: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME1")+"</td>\n" +
                "    <td>שעת יציאהלאירוע: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME2")+"</td> \n" +
                "    <td>שעת הגעה לאירוע: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME3")+"</td>\n" +
                "    <td>שעת יציאה מהאירוע: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME4")+"</td>\n" +
                "  </tr> \n" +
                "  <tr>\n" +
                "    <td>שעת הגעה ליעד/ לביה\"ח: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME5")+"</td>\n" +
                "    <td>יעד פינוי: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME6")+"</td>\n" +
                "    <td>איש צוות מקבל: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"TIME7")+"</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "<hr style=\"width:75%; float:right;\" DIR=\"RTL\">\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:75%;padding:10px; align:right;\" DIR=\"RTL\">\n" +
                "\n" +
                "  <tr>\n" +
                "    <td>מקום האירוע: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r6_r7_r8_r9_r10")+"</td>\n" +
                "    <td>כתובת  האירוע: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text6")+"</td>    \n" +
                "  </tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "<hr style=\"width:75%; float:right;\" DIR=\"RTL\">\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:75%;padding:10px; align:right;\"  DIR=\"RTL\">\n" +
                "  <tr>\n" +
                "    <td>פרטי החולה / הנפגע</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>שם החולה/ הנפגע: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text7")+"</td>\n" +
                "    <td>ת.ז: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text8")+"</td> \n" +
                "    <td>גיל: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text9")+"</td>\n" +
                "    <td>מין: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r11_r12")+"</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>כתובת מגורים : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text10")+"</td>\n" +
                "  </tr>\n" +
                "  <tr>  \n" +
                "    <td>מספר טלפון: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text11")+"</td>\n" +
                "    <td>מספר נייד : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text12")+"</td> \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>קופ\"ח : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r13_r14_r15_16_17")+"</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "<hr>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" border=\"1\" DIR=\"RTL\">\n" +
                "  <tr>\n" +
                "    <td>"+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r18_r19_r20_r21")+"</td>\n" +
                "    <td>כאבים ב: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog1")+"</td>    \n" +
                "    <td>תלונה נוירולוגיה: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog2")+"</td>\n" +
                "    <td>ארוע והפרעות אחרות: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog3")+"</td>    \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>רגישות ידועה לתרופות/ אחרים: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text15")+"</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>אופן הנסיעה לאירוע:  "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r22_r23")+"</td>\n" +
                "    <td>אופן הנסיעה מהאירוע לביה\"ח: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r24_r25")+"</td>    \n" +
                "    <td> מספר רכבים המעורבים בתאונה: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text16")+"</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" border=\"1\" DIR=\"RTL\">\n" +
                "<tr>\n" +
                "    בדיקה גופנית\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>עור ומילוי קפילארי : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog4")+"</td>\n" +
                "    <td>אישונים: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog5")+"</td>    \n" +
                "    <td>ריאות: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog6")+"</td>\n" +
                "    <td>בטן: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog7")+"</td>    \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>סימני אי ספיקה: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog8")+"</td>\n" +
                "    <td>קצב הלב: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog9")+"</td>    \n" +
                "    <td>א.ק.ג: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog10")+"</td>\n" +
                "    <td>א.ק.ג בהשבאה לקודם: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog11")+"</td>    \n" +
                "  </tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" border=\"1\" DIR=\"LTR\">\n" +
                "<tr>\n" +
                "    ממצאיםשל החולה/ נפגע במקום\n" +
                "  </tr>\n" +
                "  <tr >\n" +
                "    <td>Cardiac: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog14")+"</td>\n" +
                "    <td>Respiratory: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog15")+"</td>    \n" +
                "    <td>Neurologic: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog16")+"</td>\n" +
                "       <td>Trauma: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog17")+"</td> \n" +
                "  </tr>\n" +
                "  <tr >\n" +
                "    <td>Location of injury: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog18")+"</td>\n" +
                "    <td>Type of injury: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog19")+"</td>    \n" +
                "    <td>Other: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog20")+"</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\"border=\"1\" DIR=\"RTL\">\n" +
                "  <tr >  \n" +
                "    <center>סימנים חיוניים</center>\n" +
                "  </tr>\n" +
                "  <tr >\n" +
                "  <td><center> זמן </center></td>\n" +
                "   <td><center> לחץ דם </center></td>\n" +
                "    <td><center> דופק </center></td>\n" +
                "\t <td><center> סטורציה </center></td>\n" +
                "\t  <td><center> חום </center></td>\n" +
                "\t   <td><center> קצב נשימה </center></td>\n" +
                "\t    <td><center> סוכר בדם </center></td>\n" +
                "    <td><center> ETCO2 </center></td> \n" +
                "  </tr>\n" +
                "  <tr >\n" +
                "    <td><center> "+InfoFromDatabase7+" </center></td>\n" +
                "    <td><center> "+InfoFromDatabase6+" </center></td>\n" +
                "    <td><center> "+InfoFromDatabase5+" </center></td>\n" +
                "    <td><center> "+InfoFromDatabase4+" </center></td>\n" +
                "    <td><center> "+InfoFromDatabase3+" </center></td>\n" +
                "    <td><center> "+InfoFromDatabase2+" </center></td>\n" +
                "    <td><center> "+InfoFromDatabase1+" </center></td>\n" +
                "    <td><center> "+InfoFromDatabase+" </center></td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" DIR=\"RTL\">\n" +
                "  <tr >\n" +
                "    <td> שמות אנשי הצוות:רופא: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text17")+"</td>\n" +
                "    <td> פראמדיק: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text18")+"</td>\n" +
                "    <td> נהג: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text19")+"</td>\n" +
                "  </tr>\n" +
                "  <tr >\n" +
                "    <td> חובש/חובש בכיר: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text20")+"</td>\n" +
                "    <td> משתלם: "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text21")+"</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\"  DIR=\"RTL\">\n" +
                "  <tr >\n" +
                "    <td> רקע רפואי/ תרופתי </td>\n" +
                "  </tr>\n" +
                "  <tr >\n" +
                "    <td> הרגלים ומחלות עבר ידועות : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog12")+"</td>\n" +
                "  </tr>\n" +
                "  <tr >\n" +
                "    <td>שימוש קבוע בתרופות : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog13")+"</td>   \n" +
                "  </tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "<div style=\"margin-top:5px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" DIR=\"RTL\">\n" +
                "  <tr >\n" +
                "    <td> Isolation type / בידוד :</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "\n" +
                "<div >\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" border=1 DIR=\"RTL\">\n" +
                "  <tr >\n" +
                "     <center>רקע רפואי/ תרופתי</center> \n" +
                "  </tr>\n" +
                "  <tr >\n" +
                " \n" +
                " <td> שוקים  : "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"r26_r27")+"</td> \n" +
                " \n" +
                " \n" +
                "    <td> מס\" נסיונות להכנסת אינטובציה(ET tube) </td>\n" +
                "\t <td>"+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text26")+"</td>   \n" +
                "    <td> מס\" נסיונות להכנסת עירויים(IV)</td>\n" +
                "\t <td>"+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text25")+"</td>   \n" +
                "    <td> מס\" עירויים(IV) שהוכנסו </td>\n" +
                "\t <td>"+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text24")+"</td>   \n" +
                "    <td> מס\" Big(IO) שהוכנסו </td>\n" +
                "\t <td>"+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text23")+"</td>   \n" +
                "    <td> מס\" נסיונות להכנסת Big(IO) </td>\n" +
                "\t <td>"+SharedPreferencesHelper.getStringSharedPref(getActivity(),"text22")+"</td>  \n" +
                "\t \n" +
                "  </tr>\n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "</table>\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div >\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" border=1 DIR=\"RTL\">\n" +
                "  <tr DIR=\"LTR\" >\n" +
                "    <center ><font DIR=\"LTR\" >Glasgow coma scale (GCS) </font></center> \n" +
                "  </tr>\n" +
                "  \n" +
                "  \n" +
                "  <tr >\n" +
                "\t<td><center> motor response </center></td>\n" +
                "    <td><center> verbal response </center></td>\n" +
                "    <td><center> Eye opening </center></td>\n" +
                "  </tr>\n" +
                "  \n" +
                "  <tr >\n" +
                "\t<td><center> "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure3text")+" </center></td>\n" +
                "    <td><center> "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure2text")+" </center></td>\n" +
                "    <td><center> "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure1text")+" </center></td>\n" +
                "  </tr>\n" +
                "  \n" +
                "  <tr >\n" +
                "\t<td><center> "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure3")+" </center></td>\n" +
                "    <td><center> "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure2")+" </center></td>\n" +
                "    <td><center> "+SharedPreferencesHelper.getStringSharedPref(getActivity(),"scoure1")+" </center></td>\n" +
                "  </tr>\n" +
                " \n" +
                "  \n" +
                "</table>\n" +
                "     <center>"+SharedPreferencesHelper.getStringSharedPref(getActivity(),"totalscoure")+"</center> \n" +
                "\n" +
                "</div>\n" +
                "<hr>\n" +
                "\n" +
                "<div style=\"margin-top:30px;\">\n" +
                "<table style=\"width:66%;padding:10px; align:right;float:right;\" border=\"1\" DIR=\"RTL\">\n" +
                "\n" +
                "  <tr><td>הערות/ בדיקה גופנית וטיפולים :  "+text29.getText().toString()+"</td></tr> \n" +
                "</table>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:30px;\">\n" +
                "<table style=\"width:33%;padding:10px; align:right;float:right;\" border=\"1\" DIR=\"RTL\">\n" +
                "  \n" +
                "  \n" +
                "  <tr><td>ציין מינון התרופה / ודרך מתן/ \n" +
                " וכמה פעמים ניתנה\n" +
                " : \n "+lastrestult+"</td></tr>\n" +
                "  \n" +
                "  \n" +
                "  <tr><td>  \n" +
                " <font DIR=\"LTR\"style=\"float:left;\" >"+SharedPreferencesHelper.getStringSharedPref(getActivity(),"dialog21")+"</font>\n" +
                " </td></tr>\n" +
                "\n" +
                "  \n" +
                "</table>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:30px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" border=1  DIR=\"RTL\">\n" +
                "\n" +
                "  <tr>\n" +
                "    <td>הצהרה: הוסבר לי ע\"י הצוות שעלי להתפנות לבית חולים ואני מסרב לכך.שם: _______________\n" +
                "    ת\"ז: ___________\n" +
                "    חתימה: ______</td>\n" +
                "  </tr>\n" +
                "  \n" +
                "</table>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div style=\"margin-top:30px;\">\n" +
                "<table style=\"width:100%;padding:10px; align:right;\" border=1  DIR=\"RTL\">\n" +
                "\n" +
                "  <tr>\n" +
                "    <td>רופא:____________________________   מס\" רישיון:___________\n" +
                "<p>\n" +
                "חתימהחותמת </td>\n" +
                " \n" +
                "    <td>פראמדיק:____________________________   מס\" רישיון:___________\n" +
                "<p>\n" +
                "חתימהחותמת </td>\n" +
                "  </tr>\n" +
                "  \n" +
                "</table>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";



        Log.i("first",5+"");
        webView.loadDataWithBaseURL(null, htmlDocument, "text/HTML", "UTF-8", null);
    }

    ArrayList<AdapterItems> listnewsData = new ArrayList<AdapterItems>();

    void LoadElement() {
        listnewsData.clear();
        InfoFromDatabase="";
        InfoFromDatabase1="";
        InfoFromDatabase2="";
        InfoFromDatabase3="";
        InfoFromDatabase4="";
        InfoFromDatabase5="";
        InfoFromDatabase6="";
        InfoFromDatabase7="";
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

                InfoFromDatabase=InfoFromDatabase+" "+cursor.getString(cursor.getColumnIndex(DBManager.Col1)) +"\n ";
                InfoFromDatabase1=InfoFromDatabase1+" "+cursor.getString(cursor.getColumnIndex(DBManager.Col2)) +"\n ";
                InfoFromDatabase2=InfoFromDatabase2+" "+cursor.getString(cursor.getColumnIndex(DBManager.Col3)) +"\n  ";
                InfoFromDatabase3=InfoFromDatabase3+" "+cursor.getString(cursor.getColumnIndex(DBManager.Col4)) +"\n ";
                InfoFromDatabase4=InfoFromDatabase4+" "+cursor.getString(cursor.getColumnIndex(DBManager.Col5)) +"\n ";
                InfoFromDatabase5=InfoFromDatabase5+" "+cursor.getString(cursor.getColumnIndex(DBManager.Col6)) +"\n ";
                InfoFromDatabase6=InfoFromDatabase6+" "+cursor.getString(cursor.getColumnIndex(DBManager.Col7)) +"\n ";
                InfoFromDatabase7=InfoFromDatabase7+" "+cursor.getString(cursor.getColumnIndex(DBManager.Col8)) +"\n ";


            } while (cursor.moveToNext());
        }
    }

    public static boolean isInternetConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();}



}

