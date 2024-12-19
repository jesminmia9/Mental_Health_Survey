package forms_activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.icddrb.mental_health_survey.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Common.Connection;
import Common.Global;
import Utility.MySharedPreferences;
import forms_datamodel.Member_DataModel;


public class Member_list extends AppCompatActivity {
    boolean networkAvailable=false;
     double currentLatitude,currentLongitude;
    private String MemID;
    private String DSSID;
    private String preganat;
    private String Name;

    private String GeoLevel7;
    private String GeoLevel7Name;
    private String VillCode;
    private String VillName;
    private String CompoundCode;
    private String CompoundName;
    private String HHNO;
    private String HHHead;
    private String MSlNo;
    private String BDate;
    private String Age;
    private String Sex;
    private String LmpDt;
    private String FaName;
    private String MoName;





    //Disabled Back/Home key
    //-----------------------
    @Override
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME)
        { return false; }
        else { return true;  }
    }

    String VariableID;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    private List<Member_DataModel> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    static String TableName;

    Bundle IDbundle;
    Spinner spnLocation;
    Spinner spnVillage;
    Spinner spnCompound;
    Spinner spnHousehold;

    ImageButton btnSearch;
    EditText txtSearch;


    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    RelativeLayout secBari;
    static String HHID ;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            setContentView(R.layout.member_list);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            C = new Connection(this);
            g = Global.getInstance();
            STARTTIME = g.CurrentTime24();

            DEVICEID = MySharedPreferences.getValue(this, "deviceid");
            ENTRYUSER = MySharedPreferences.getValue(this, "userid");



            TableName = "Member_Allinfo";
            TextView lblHeading = (TextView) findViewById(R.id.lblHeading);
            ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
            cmdBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog.Builder adb = new AlertDialog.Builder(Member_list.this);
                    adb.setTitle("Close");
                    adb.setMessage("Do you want to close this form[Yes/No]?");
                    adb.setNegativeButton("No", null);
                    adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }});
                    adb.show();
                }});

            txtSearch = (EditText)findViewById(R.id.txtSearch);
            btnSearch = (ImageButton) findViewById(R.id.btnSearch);

            btnSearch.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PageRefresh();

                }});



            IDbundle = getIntent().getExtras();
            MemID    = IDbundle.getString("MemID");
            GeoLevel7 =IDbundle.getString("GeoLevel7");
            GeoLevel7Name =IDbundle.getString("GeoLevel7Name");
            VillCode =IDbundle.getString ("VillCode");
            VillName =IDbundle.getString("VillName");
            CompoundCode =IDbundle.getString("CompoundCode");
            CompoundName =IDbundle.getString("CompoundName");
            HHNO =IDbundle.getString("HHNO");
            HHHead =IDbundle.getString("HHHead");
            MSlNo =IDbundle.getString("MSlNo");
            Name =IDbundle.getString("Name");
            HHHead =IDbundle.getString("HHHead");
            DSSID =IDbundle.getString ("DSSID");
            preganat =IDbundle.getString ("Pstat");
            BDate =IDbundle.getString ("BDate");
            Age =IDbundle.getString ("Age");
            Sex =IDbundle.getString ("Sex");
            FaName =IDbundle.getString("FaName");
            MoName =IDbundle.getString("MoName");

            spnLocation = (Spinner)findViewById(R.id.spnLocation);
            spnVillage = (Spinner)findViewById(R.id.spnVillage);
            spnCompound = (Spinner)findViewById(R.id.spnCompound);
            spnHousehold = (Spinner)findViewById(R.id.spnHousehold);


            spnLocation.setAdapter(C.getArrayAdapter("SELECT DISTINCT GeoLevel7 || '-' || GeoLevel7Name FROM Member_Allinfo"));
            spnVillage.setAdapter(C.getArrayAdapter("SELECT '' UNION SELECT DISTINCT VillID || '-' || VillName FROM Member_Allinfo " +
                    "WHERE GeoLevel7 = '" + spnLocation.getSelectedItem().toString().split("-")[0] + "'"));
            spnCompound.setAdapter(C.getArrayAdapter("SELECT '' UNION SELECT DISTINCT CompoundID || '-' || CompoundName FROM Member_Allinfo " +
                    "WHERE VillID = '" + spnVillage.getSelectedItem().toString().split("-")[0] + "'"));
            spnHousehold.setAdapter(C.getArrayAdapter("SELECT '' UNION SELECT DISTINCT HHID || '-' || HHHead FROM Member_Allinfo " +
                    "WHERE CompoundID = '" + spnCompound.getSelectedItem().toString().split("-")[0] + "'"
            ));





            spnLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedLocation = spnLocation.getSelectedItem().toString().split("-")[0];
                    spnVillage.setAdapter(C.getArrayAdapter(
                            "SELECT '' UNION SELECT DISTINCT VillID || '-' || VillName FROM Member_Allinfo " +
                                    "WHERE GeoLevel7 = '" + selectedLocation + "'"
                    ));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });


            spnVillage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String selectedVillage = spnVillage.getSelectedItem().toString().split("-")[0];


                    spnCompound.setAdapter(C.getArrayAdapter(
                            "SELECT '' UNION SELECT DISTINCT CompoundID || '-' || CompoundName FROM Member_Allinfo " +
                                    "WHERE VillID = '" + selectedVillage + "'"
                    ));

                    String query1 = "SELECT * FROM Member_Allinfo WHERE VillID='" + selectedVillage + "'";
                    List<Member_DataModel> members = C.fetchMembers(query1); // Implement this method in Connection class
                    dataList.clear();
                    dataList.addAll(members);
                    mAdapter.notifyDataSetChanged();


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });



            spnCompound.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (spnCompound.getSelectedItem() != null && position != 0) {
                        String selectedCompound = spnCompound.getSelectedItem().toString().split("-")[0];

                        // Fetch and set adapter for spnHousehold
                        ArrayAdapter<String> householdAdapter = C.getArrayAdapter(
                                "SELECT '' UNION SELECT DISTINCT HHID || '-' || HHHead FROM Member_Allinfo " +
                                        "WHERE CompoundID = '" + selectedCompound + "'"
                        );
                        spnHousehold.setAdapter(householdAdapter);

                        // Update the dataList dynamically based on selectedCompound
                        String query = "SELECT * FROM Member_Allinfo WHERE CompoundID = '" + selectedCompound + "'";
                        List<Member_DataModel> updatedMembers = C.fetchMembers(query); // Implement this method in the Connection class
                        dataList.clear(); // Clear the existing list
                        dataList.addAll(updatedMembers); // Add the new data
                        mAdapter.notifyDataSetChanged(); // Notify the adapter to refresh the list view or RecyclerView
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });

            spnHousehold.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (spnHousehold.getSelectedItem() != null && position != 0) {
                    String selectedHousehold = spnHousehold.getSelectedItem().toString().split("-")[0];



                    // Update the dataList dynamically based on selectedHousehold
                    String query2 = "SELECT * FROM Member_Allinfo WHERE HHID='" + selectedHousehold + "'";
                    List<Member_DataModel> updatedMember = C.fetchMembers(query2);

                    dataList.clear();
                    dataList.addAll(updatedMember);
                    mAdapter.notifyDataSetChanged();
                }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });





           // txtSearch = (EditText)findViewById(R.id.txtSearch);

            recyclerView = (RecyclerView)findViewById(R.id.recyclerViewMembers);
            mAdapter = new DataAdapter(dataList);
            recyclerView.setItemViewCacheSize(20);
            recyclerView.setDrawingCacheEnabled(true);
            recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);


           // DataSearch(txtSearch.getText().toString());
           // DataSearch();

        }
        catch(Exception  e)
        {
            Connection.MessageBox(Member_list.this, e.getMessage());
            return;
        }
    }

    private void PageRefresh()
    {
        final ProgressDialog progDailog = ProgressDialog.show(Member_list.this, "", "Please Wait . . .", true);

        new Thread() {
            public void run() {
                try {


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            DataSearch(HHHead);

                            progDailog.dismiss();
                        }
                    });
                } catch (Exception e) {

                }
                progDailog.dismiss();
            }
        }.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
      //  tmpBariNo = "";
      //  DataSearch();
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        } else {
           // DataSearch( );
         //   DataSearch(txtSearch.getText().toString());
        }
    }

    private void DataSearch(String HHHead)
    {
        try
        {
            Member_DataModel d = new Member_DataModel();


            String SQL = "SELECT MemID, DSSID,Pstat, Name,HHHead, BDate, Age,Sex,LmpDt, MoName, FaName " +
                    "FROM Member_Allinfo " +
                    "WHERE VillID = '" + spnVillage.getSelectedItem().toString().split("-")[0] + "' " +
                    "AND (HHHead like('"+ txtSearch.getText().toString() +"%') or HHHead like('%"+ txtSearch.getText().toString() +"%'))\n" +
                    "AND Active = '1'";



            List<Member_DataModel> data = d.SelectAll(this, SQL);
            dataList.clear();

            dataList.addAll(data);
            try {
                mAdapter.notifyDataSetChanged();
                // Update heading
             //    lblHeading.setText("Member List (Total: " + dataList.size() + ")");
            }catch ( Exception ex){
                Connection.MessageBox(Member_list.this,ex.getMessage());
            }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Member_list.this, e.getMessage());
            return;
        }
    }





    public class DataAdapter  extends RecyclerView.Adapter<Member_list.DataAdapter.ViewHolder> {
        private List<Member_DataModel> dataList;

        public class ViewHolder extends RecyclerView.ViewHolder {
              LinearLayout secMemberDetail;
              TextView MemID, DSSID,preganat, Name, HHHead, Age,Sex, LmpDt, BDate, MoName, FaName;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                secMemberDetail = (LinearLayout) findViewById(R.id.secMemberDetail);
                MemID=(TextView)itemView.findViewById(R.id.MemberID);
                DSSID=(TextView)itemView.findViewById(R.id.DSSID);
                preganat=(TextView)itemView.findViewById(R.id.preganat);
                Name =(TextView)itemView.findViewById(R.id.Name);
                HHHead =(TextView)itemView.findViewById(R.id.HHHead);
                Sex = (TextView)itemView.findViewById(R.id.MemberSex);
                LmpDt =(TextView)itemView.findViewById(R.id.LmpDt);
                BDate = (TextView)itemView.findViewById(R.id.BDate);
                MoName = (TextView)itemView.findViewById(R.id.MoName);
                FaName = (TextView)itemView.findViewById(R.id.FaName);
            }
        }

        public DataAdapter(List<Member_DataModel> datalist) {

            this.dataList = datalist;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_row, parent, false);
            return new ViewHolder(view);
        }




        // Updated code-
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Member_DataModel member = dataList.get(position);
            holder.DSSID.setText("DSSID: " + member.getDSSID());
            holder.Name.setText(member.getName());
            holder.preganat.setText(member.getPstat() != null && !member.getPstat().equals("NULL") ? member.getPstat() : "");
            holder.HHHead.setText(member.getHHHead() != null && !member.getHHHead().equals("NULL") ? member.getHHHead() : "");
            holder.MoName.setText(member.getMoName() != null && !member.getMoName().equals("NULL") ? member.getMoName() : "");
            holder.FaName.setText(member.getFaName() != null && !member.getFaName().equals("NULL") ? member.getFaName() : "");

            // Handle Preganat and LmpDt display logic
            String preganatValue = member.getPstat(); // Assuming Pstat holds the pregnant status
            if ("41".equals(preganatValue)) {
                holder.preganat.setText("Pregnant"); // Display 'Pregnant' instead of 41
                holder.preganat.setVisibility(View.VISIBLE);

                // Display LmpDt with proper formatting if needed
                String lmprawDate = member.getLmpDt();
                if (lmprawDate != null && !lmprawDate.isEmpty()) {
                    try {
                        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                        String formattedDate = outputFormat.format(inputFormat.parse(lmprawDate));

                        // Combine "LMP" and formattedDate with bold styling for "LMP"
                        String displayText = " LMP   :           " + formattedDate;
                        SpannableString spannable = new SpannableString(displayText);
                        spannable.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


                        holder.LmpDt.setText(spannable);
                    } catch (ParseException e) {
                        holder.LmpDt.setText(lmprawDate); // Fallback to raw date if parsing fails
                    }
                } else {
                    holder.LmpDt.setText(""); // Set empty if no date is provided
                }
                holder.LmpDt.setVisibility(View.VISIBLE);
            } else {
                // Hide both preganat and LmpDt if the condition is not met
                holder.preganat.setVisibility(View.GONE);
                holder.LmpDt.setVisibility(View.GONE);
            }

            // Convert Sex value
            String sexValue = member.getSex();
            if ("1".equals(sexValue)) {
                holder.Sex.setText("Male");
            } else if ("2".equals(sexValue)) {
                holder.Sex.setText("Female");
            } else {
                holder.Sex.setText(""); // Set empty if no valid value
            }

            // Convert date format from yyyy-mm-dd to dd/mm/yyyy
            String rawDate = member.getBDate();
            if (rawDate != null && !rawDate.isEmpty()) {
                try {
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    String formattedDate = outputFormat.format(inputFormat.parse(rawDate));
                    holder.BDate.setText(formattedDate);
                } catch (ParseException e) {
                    holder.BDate.setText(rawDate); // Fallback to raw date if parsing fails
                }
            } else {
                holder.BDate.setText(""); // Set empty if no date is provided
            }


        }

        public int getItemCount() {
            return dataList.size();
        }

    }

    public class DividerItemDecoration extends RecyclerView.ItemDecoration {
        private final int[] ATTRS = new int[]{
                android.R.attr.listDivider
        };
        public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
        public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
        private Drawable mDivider;
        private int mOrientation;
        public DividerItemDecoration(Context context, int orientation) {
            final TypedArray a = context.obtainStyledAttributes(ATTRS);
            mDivider = a.getDrawable(0);
            a.recycle();
            setOrientation(orientation);
        }
        public void setOrientation(int orientation) {
            if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
                throw new IllegalArgumentException("invalid orientation");
            }
            mOrientation = orientation;
        }
        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                drawVertical(c, parent);
            } else {
                drawHorizontal(c, parent);
            }
        }
        public void drawVertical(Canvas c, RecyclerView parent) {
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
        public void drawHorizontal(Canvas c, RecyclerView parent) {
            final int top = parent.getPaddingTop();
            final int bottom = parent.getHeight() - parent.getPaddingBottom();
            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int left = child.getRight() + params.rightMargin;
                final int right = left + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            } else {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            }
        }
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private GestureDetector gestureDetector;
        private ClickListener clickListener;
        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }
        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }
        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
        interface ClickListener {
            void onClick(View view, int position);
            void onLongClick(View view, int position);
        }
    }

}