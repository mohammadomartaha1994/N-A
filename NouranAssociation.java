package com.example.mohammad.nouran;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
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
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class NouranAssociation extends AppCompatActivity
       {
           private int PICK_IMAGE_REQUEST = 1;

           TextView id_number;
           DBManager dbManager;
           ImageButton email;
           changeIdThread c;
           Boolean isRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nouran_association);

        dbManager=new DBManager(this);

        if(isInternetConnected(getApplicationContext())){
            String url="http://kufermalik.com/Nouran/getID.php";
            new MyAsyncTaskgetNews().execute(url);
        }


        Num_One fragment = new Num_One();
        getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();

        final TextView num1 = (TextView)findViewById(R.id.number1);
        final TextView num2 = (TextView)findViewById(R.id.number2);
        final TextView num3 = (TextView)findViewById(R.id.number3);
        final TextView num4 = (TextView)findViewById(R.id.number4);
        final TextView num5 = (TextView)findViewById(R.id.number5);
        final TextView num6 = (TextView)findViewById(R.id.number6);
        email=(ImageButton)findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(NouranAssociation.this);
                final View promptView = layoutInflater.inflate(R.layout.email_edit, null);
                final AlertDialog alertD = new AlertDialog.Builder(NouranAssociation.this).create();
                final TextView editFrom = (TextView)promptView.findViewById(R.id.editFrom);
                editFrom.setText(SharedPreferencesHelper.getEmailSharedPref(NouranAssociation.this,"Email"));
                final EditText editTo = (EditText)promptView.findViewById(R.id.editTo);

                Button Done = (Button) promptView.findViewById(R.id.Done);

                Done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!editTo.getText().toString().isEmpty())
                        SharedPreferencesHelper.setSharePref(NouranAssociation.this,"Email",editTo.getText().toString());
                        alertD.dismiss();
                    }
                });
                alertD.setView(promptView);
                alertD.show();

            }
        });


        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    num1.setBackground(getDrawable(R.drawable.shape_));
                    num1.setTextColor(Color.RED);

                    num2.setBackground(getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));
                }
                else {
                    num1.setBackground(getResources().getDrawable(R.drawable.shape_));
                    num1.setTextColor(Color.RED);

                    num2.setBackground(getResources().getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getResources().getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getResources().getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getResources().getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getResources().getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));

                }

                Num_One fragment = new Num_One();
                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();

            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    num2.setBackground(getDrawable(R.drawable.shape_));
                    num2.setTextColor(Color.RED);

                    num1.setBackground(getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));

                }
                else {
                    num2.setBackground(getResources().getDrawable(R.drawable.shape_));
                    num2.setTextColor(Color.RED);

                    num1.setBackground(getResources().getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getResources().getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getResources().getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getResources().getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getResources().getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));


                }
                Num_Tow fragment = new Num_Tow();
                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();
            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    num3.setBackground(getDrawable(R.drawable.shape_));
                    num3.setTextColor(Color.RED);

                    num1.setBackground(getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num2.setBackground(getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));

                }
                else {
                    num3.setBackground(getResources().getDrawable(R.drawable.shape_));
                    num3.setTextColor(Color.RED);

                    num1.setBackground(getResources().getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num2.setBackground(getResources().getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getResources().getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getResources().getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getResources().getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));


                }
                Num_Three fragment = new Num_Three();
                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    num4.setBackground(getDrawable(R.drawable.shape_));
                    num4.setTextColor(Color.RED);

                    num1.setBackground(getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num2.setBackground(getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));
                }
                else {
                    num4.setBackground(getResources().getDrawable(R.drawable.shape_));
                    num4.setTextColor(Color.RED);


                    num1.setBackground(getResources().getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num2.setBackground(getResources().getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getResources().getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getResources().getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getResources().getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));


                }
                Num_Four fragment = new Num_Four();
                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    num5.setBackground(getDrawable(R.drawable.shape_));
                    num5.setTextColor(Color.RED);

                    num1.setBackground(getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num2.setBackground(getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));

                }
                else {
                    num5.setBackground(getResources().getDrawable(R.drawable.shape_));
                    num5.setTextColor(Color.RED);


                    num1.setBackground(getResources().getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num2.setBackground(getResources().getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getResources().getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getResources().getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num6.setBackground(getResources().getDrawable(R.drawable.shape));
                    num6.setTextColor(Color.parseColor("#F5F5F5"));


                }
                Num_Five fragment = new Num_Five();
                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();
            }
        });



        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    num6.setBackground(getDrawable(R.drawable.shape_));
                    num6.setTextColor(Color.RED);

                    num1.setBackground(getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num2.setBackground(getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));
                }
                else {
                    num6.setBackground(getResources().getDrawable(R.drawable.shape_));
                    num6.setTextColor(Color.RED);


                    num1.setBackground(getResources().getDrawable(R.drawable.shape));
                    num1.setTextColor(Color.parseColor("#F5F5F5"));
                    num2.setBackground(getResources().getDrawable(R.drawable.shape));
                    num2.setTextColor(Color.parseColor("#F5F5F5"));
                    num3.setBackground(getResources().getDrawable(R.drawable.shape));
                    num3.setTextColor(Color.parseColor("#F5F5F5"));
                    num4.setBackground(getResources().getDrawable(R.drawable.shape));
                    num4.setTextColor(Color.parseColor("#F5F5F5"));
                    num5.setBackground(getResources().getDrawable(R.drawable.shape));
                    num5.setTextColor(Color.parseColor("#F5F5F5"));

                }
                Num_Six fragment = new Num_Six();
                getFragmentManager().beginTransaction().replace(R.id.content_nouran_association, fragment).commit();
            }
        });



        id_number = (TextView)findViewById(R.id.id_number);
        id_number.setText("NO. "+SharedPreferencesHelper.getIntSharedPref(this,"AUTO_INCREMENT"));

        c = new changeIdThread();
        c.start();


        }

           @Override
           protected void onActivityResult(int requestCode, int resultCode, Intent data) {
               if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                   String realPath;
                   if (Build.VERSION.SDK_INT < 11)
                       realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, data.getData());
                   else if (Build.VERSION.SDK_INT < 19)
                       realPath = RealPathUtil.getRealPathFromURI_API11to18(this, data.getData());
                   else
                       realPath = RealPathUtil.getRealPathFromURI_API19(this, data.getData());

                   SharedPreferencesHelper.setSharePref(getApplicationContext(),"filePath",realPath);

               }
           }


           public class MyAsyncTaskgetNews extends AsyncTask<String, String, String> {
               @Override
               protected String  doInBackground(String... params) {
                   // TODO Auto-generated method stub
                   try {
                       String NewsData;
                       URL url = new URL(params[0]);
                       HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                       urlConnection.setConnectTimeout(7000);
                       try {
                           InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                           NewsData = ConvertInputToStringNoChange(in);
                           publishProgress(NewsData);
                       } finally {
                           urlConnection.disconnect();
                       }

                   }catch (Exception ex){}
                   return null;
               }
               protected void onProgressUpdate(String... progress) {
                   try {
                       JSONArray json=new JSONArray(progress[0]);
                       for(int i=0;i<json.length();i++) {
                           JSONObject user=json.getJSONObject(i);
                           SharedPreferencesHelper.setSharePref(getApplicationContext(),"AUTO_INCREMENT",user.getInt("AUTO_INCREMENT"));
                       }

                   } catch (Exception ex) {
                   }
               }
               protected void onPostExecute(String  result2){
               }
           }

           public static String ConvertInputToStringNoChange(InputStream inputStream) {

               BufferedReader bureader=new BufferedReader( new InputStreamReader(inputStream));
               String line ;
               String linereultcal="";

               try{
                   while((line=bureader.readLine())!=null) {

                       linereultcal+=line;

                   }
                   inputStream.close();


               }catch (Exception ex){}

               return linereultcal;
           }

           public static boolean isInternetConnected(Context context) {
               ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
               NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
               return activeNetwork != null && activeNetwork.isConnectedOrConnecting();}


           class changeIdThread extends Thread {

               @Override
               public void run(){
                   while (isRunning){

                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               if(isInternetConnected(getApplicationContext())){
                                   String url="http://kufermalik.com/Nouran/getID.php";
                                   new MyAsyncTaskgetNews().execute(url);
                                   LoadElement();
                               }
                               id_number.setText("NO. "+SharedPreferencesHelper.getIntSharedPref(NouranAssociation.this,"AUTO_INCREMENT"));
                           }
                       });
                       try {
                           Thread.sleep(20000);
                           Log.d("test"," changed successfully ");
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }

               }
           }

           void LoadElement() {
               Cursor cursor = dbManager.queryOffLine(null, null, null, DBManager.ColID);
               if (cursor.moveToFirst()) {
                   do {

                       final Response.Listener<String> responseListener = new Response.Listener<String>() {
                           @Override
                           public void onResponse(String response) {

//                               try {
////                                   JSONArray  jsonResponse = new JSONArray (response);
////                                   boolean success = jsonResponse.getBoolean("success");
//
//                               } catch (JSONException e) {
//                                   e.printStackTrace();
//
//                               }
                           }
                       };
                       AddIDreq AddIDreq = new AddIDreq(
                               cursor.getString(cursor.getColumnIndex(DBManager.Col1)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col2)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col3)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col4)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col5)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col6)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col7)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col8)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col9)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col10)),

                               cursor.getString(cursor.getColumnIndex(DBManager.Col11)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col12)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col13)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col14)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col15)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col16)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col17)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col18)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col19)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col20)),

                               cursor.getString(cursor.getColumnIndex(DBManager.Col21)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col22)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col23)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col24)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col25)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col26)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col27)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col28)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col29)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col30)),

                               cursor.getString(cursor.getColumnIndex(DBManager.Col31)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col32)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col33)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col34)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col35)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col36)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col37)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col38)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col39)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col40)),

                               cursor.getString(cursor.getColumnIndex(DBManager.Col41)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col42)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col43)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col44)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col45)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col46)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col47)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col48)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col49)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col50)),

                               cursor.getString(cursor.getColumnIndex(DBManager.Col51)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col52)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col53)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col54)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col55)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col56)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col57)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col58)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col59)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col60)),

                               cursor.getString(cursor.getColumnIndex(DBManager.Col61)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col62)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col63)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col64)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col65)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col66)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col67)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col68)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col69)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col70)),

                               cursor.getString(cursor.getColumnIndex(DBManager.Col71)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col72)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col73)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col74)),
                               cursor.getString(cursor.getColumnIndex(DBManager.Col75)),

                               responseListener);
                       RequestQueue queue = Volley.newRequestQueue(NouranAssociation.this);
                       queue.add(AddIDreq);

                     String[] SelectionArgs={cursor.getString(cursor.getColumnIndex(DBManager.ColID))};
                     dbManager.DeleteOffline("ID=?", SelectionArgs);

                       Log.d("found"," yes ");
                   } while (cursor.moveToNext());
               }
           }

       }

