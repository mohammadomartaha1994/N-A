package com.example.mohammad.nouran;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

public class DBManager {
    private SQLiteDatabase sqlDB;
    static final String DBName="Nouran";
    static final String TableName="firstSpinner";
    static final String TableNameOffline="Offline";
    static final String TableName3="num_six_list";

    static final String ColName="Name";
    static final String ColID="ID";

    static final String Col1="num1";
    static final String Col2="num2";
    static final String Col3="num3";
    static final String Col4="num4";
    static final String Col5="num5";
    static final String Col6="num6";
    static final String Col7="num7";
    static final String Col8="num8";
    static final String Col9="num9a";
    static final String Col10="num10a";
    static final String Col11="num11a";
    static final String Col12="num12a";
    static final String Col13="num13a";
    static final String Col14="num14a";
    static final String Col15="num15a";
    static final String Col16="num16a";
    static final String Col17="num17a";
    static final String Col18="num18a";
    static final String Col19="num19a";
    static final String Col20="num20a";
    static final String Col21="num21a";
    static final String Col22="num22a";
    static final String Col23="num23a";
    static final String Col24="num24a";
    static final String Col25="num25a";
    static final String Col26="num26a";
    static final String Col27="num27a";
    static final String Col28="num28a";
    static final String Col29="num29a";
    static final String Col30="num30a";
    static final String Col31="num31a";
    static final String Col32="num32a";
    static final String Col33="num33a";
    static final String Col34="num34a";
    static final String Col35="num35a";
    static final String Col36="num36a";
    static final String Col37="num37a";
    static final String Col38="num38a";
    static final String Col39="num39a";
    static final String Col40="num40a";
    static final String Col41="num41a";
    static final String Col42="num42a";
    static final String Col43="num43a";
    static final String Col44="num44a";
    static final String Col45="num45a";
    static final String Col46="num46a";
    static final String Col47="num47a";
    static final String Col48="num48a";
    static final String Col49="num49a";
    static final String Col50="num50a";
    static final String Col51="num51a";
    static final String Col52="num52a";
    static final String Col53="num53a";
    static final String Col54="num54a";
    static final String Col55="num55a";
    static final String Col56="num56a";
    static final String Col57="num57a";
    static final String Col58="num58a";
    static final String Col59="num59a";
    static final String Col60="num60a";
    static final String Col61="num61a";
    static final String Col62="num62a";
    static final String Col63="num63a";
    static final String Col64="num64a";
    static final String Col65="num65a";
    static final String Col66="num66a";
    static final String Col67="num67a";
    static final String Col68="num68a";
    static final String Col69="num69a";
    static final String Col70="num70a";
    static final String Col71="num71a";
    static final String Col72="num72a";
    static final String Col73="num73a";
    static final String Col74="num74a";
    static final String Col75="num75a";



    static final int DBVersion=12;


//    static final String CreateTable="CREATE TABLE IF NOT EXISTS " +
//            TableName+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
//            ColName+" TEXT );";
//
//    static final String CreateTable2="CREATE TABLE IF NOT EXISTS " +
//            TableName2+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
//            ColName+" TEXT );";
//
    static final String CreateTable="CREATE TABLE IF NOT EXISTS " +
            TableName+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
            Col1+" TEXT,"+
            Col2+" TEXT,"+
            Col3+" TEXT,"+
            Col4+" TEXT,"+
            Col5+" TEXT,"+
            Col6+" TEXT,"+
            Col7+" TEXT,"+
            Col8+" TEXT );";


    static final String CreateTableOffLine="CREATE TABLE IF NOT EXISTS " +
            TableNameOffline+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
            Col1+" TEXT, "+ Col2+" TEXT, "+ Col3+" TEXT,"+ Col4+" TEXT,"+ Col5+" TEXT,"+ Col6+" TEXT,"+ Col7+" TEXT,"+ Col8+" TEXT,"+ Col9+" TEXT,"+ Col10+" TEXT,"+
            Col11+" TEXT,"+ Col12+" TEXT,"+ Col13+" TEXT,"+ Col14+" TEXT,"+ Col15+" TEXT,"+ Col16+" TEXT,"+ Col17+" TEXT,"+ Col18+" TEXT,"+ Col19+" TEXT,"+ Col20+" TEXT,"+
            Col21+" TEXT,"+ Col22+" TEXT,"+ Col23+" TEXT,"+ Col24+" TEXT,"+ Col25+" TEXT,"+ Col26+" TEXT,"+ Col27+" TEXT,"+ Col28+" TEXT,"+ Col29+" TEXT,"+ Col30+" TEXT,"+
            Col31+" TEXT,"+ Col32+" TEXT,"+ Col33+" TEXT,"+ Col34+" TEXT,"+ Col35+" TEXT,"+ Col36+" TEXT,"+ Col37+" TEXT,"+ Col38+" TEXT,"+ Col39+" TEXT,"+ Col40+" TEXT,"+
            Col41+" TEXT,"+ Col42+" TEXT,"+ Col43+" TEXT,"+ Col44+" TEXT,"+ Col45+" TEXT,"+ Col46+" TEXT,"+ Col47+" TEXT,"+ Col48+" TEXT,"+ Col49+" TEXT,"+ Col50+" TEXT,"+
            Col51+" TEXT,"+ Col52+" TEXT,"+ Col53+" TEXT,"+ Col54+" TEXT,"+ Col55+" TEXT,"+ Col56+" TEXT,"+ Col57+" TEXT,"+ Col58+" TEXT,"+ Col59+" TEXT,"+ Col60+" TEXT,"+
            Col61+" TEXT,"+ Col62+" TEXT,"+ Col63+" TEXT,"+ Col64+" TEXT,"+ Col65+" TEXT,"+ Col66+" TEXT,"+ Col67+" TEXT,"+ Col68+" TEXT,"+ Col69+" TEXT,"+ Col70+" TEXT,"+
            Col71+" TEXT,"+ Col72+" TEXT,"+ Col73+" TEXT,"+ Col74+" TEXT,"+ Col75+" TEXT );";



    static class DatabaseHelperUser extends SQLiteOpenHelper{
        Context context;
        DatabaseHelperUser(Context context){
            super(context,DBName,null,DBVersion);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CreateTable);
            db.execSQL(CreateTableOffLine);
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'בחר'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'מחוסר ההקרה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'תאונת דרכים'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'נפילה מגובע'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'CVA  חשד ל'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'TIA  חשד ל'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'MI חשד ל'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'NEUMOTHORAX  חשד ל'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'HEMOTHORAX חשד ל'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'חשד ל אפנדציט'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'חשד ל אבן בכליות'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'PE חשד ל'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'חשד לשבר ב'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'בגיעת ראש'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'התעלפות'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'קוצר נשימה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'קשיי נשימה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'דימום'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'חתך'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'בריקה ב'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'טיפול יום'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'חולשה כללית'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'כאבים בחזה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'כאבים בבטן'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'כאבי גב'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'חבלה ב'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'אסטמה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'אפילפסיה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'העברת חולה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'העברת גופה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'לידה'); ");
//            db.execSQL(" INSERT INTO "+TableName+" VALUES ( null, 'אלרגיה'); ");
//
//
//
//
//
//            db.execSQL(CreateTable2);
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'בחר'); ");
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'הע\"כ'); ");
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'הה\"צ '); ");
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'שע\"צ '); ");
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'אלמוקאסד '); ");
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'אלמוטלע '); ");
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'הצרפתי שיח גראח'); ");
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'הצרפתי ירושלים  '); ");
//            db.execSQL(" INSERT INTO "+TableName2+" VALUES ( null, 'העיניים '); ");
//
//
//            db.execSQL(CreateTable3);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table IF EXISTS "+TableName);
            db.execSQL("Drop table IF EXISTS "+TableNameOffline);
         //   db.execSQL("Drop table IF EXISTS "+TableName3);
            onCreate(db);

        }
    }

    public DBManager(Context context){
        DatabaseHelperUser db=new DatabaseHelperUser(context);
        sqlDB = db.getWritableDatabase();
    }



    public long Insert(ContentValues values){
        long ID = sqlDB.insert(TableName,"",values);
        return ID;
    }
//
    public long InsertOffLine(ContentValues values){
        long ID = sqlDB.insert(TableNameOffline,"",values);
        return ID;
    }
//
//    public long InsertL(ContentValues values){
//        long ID = sqlDB.insert(TableName3,"",values);
//        return ID;
//    }



    public Cursor query(String[] Projection,String Selection, String[] SelectionArgs,String SortOrder){
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        qb.setTables(TableName);
        Cursor cursor=qb.query(sqlDB, Projection, Selection, SelectionArgs, null, null, SortOrder+" ASC");
        return cursor;
    }

    public Cursor queryOffLine(String[] Projection,String Selection, String[] SelectionArgs,String SortOrder){
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        qb.setTables(TableNameOffline);
        Cursor cursor=qb.query(sqlDB, Projection, Selection, SelectionArgs, null, null, SortOrder+" ASC");
        return cursor;
    }

//
//
//
//    public Cursor queryL(String[] Projection,String Selection, String[] SelectionArgs,String SortOrder){
//        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
//        qb.setTables(TableName3);
//        Cursor cursor=qb.query(sqlDB, Projection, Selection, SelectionArgs, null, null, SortOrder+" DESC");
//        return cursor;
//    }
//
//



    public int Delete(String Selection,String[] SelectionArgs){
        int count = sqlDB.delete(TableName, Selection, SelectionArgs);
        return count;
    }
    public int DeleteOffline(String Selection,String[] SelectionArgs){
        int count = sqlDB.delete(TableNameOffline, Selection, SelectionArgs);
        return count;
    }
//
//    public int DeleteL(String Selection,String[] SelectionArgs){
//        int count = sqlDB.delete(TableName3, Selection, SelectionArgs);
//        return count;
//    }
//
    public  int DeleteAll(){
        int count = sqlDB.delete(TableName, null, null);
        return count;
    }

    public  int Update(ContentValues values,String Selection,String[] SelectionArgs){
        int count=sqlDB.update(TableName,values,Selection,SelectionArgs);
        return count;

    }
//    public  int UpdateS(ContentValues values,String Selection,String[] SelectionArgs){
//        int count=sqlDB.update(TableName2,values,Selection,SelectionArgs);
//        return count;
//
//    }
//    public  int UpdateL(ContentValues values,String Selection,String[] SelectionArgs){
//        int count=sqlDB.update(TableName3,values,Selection,SelectionArgs);
//        return count;
//
//    }



}
