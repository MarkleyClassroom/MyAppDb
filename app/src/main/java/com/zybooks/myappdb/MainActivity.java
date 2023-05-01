package com.zybooks.myappdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore firestoredb;
    public static final String TAG = "DB DAta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firestoredb = FirebaseFirestore.getInstance();
//        Map<String, Object> user = new HashMap<>();
//        user.put("first", "jd");
//        user.put("last", "markley");
//        user.put("age", 12);
//
//        firestoredb.collection("teachers")
//                .add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_LONG).show();
//                    }
//                });

//        firestoredb.collection("teachers")
//                .whereLessThan("age", 21)
//                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                    List<DocumentSnapshot> snapshotList = queryDocumentSnapshots.getDocuments();
//                    for (DocumentSnapshot ss: snapshotList){
//                        Log.d(TAG, "First: " + ss.toString());
////                        Log.d(TAG, "Data: " + ss.getData());
////                        Log.d(TAG, "Id: " + ss.getId());
////                        Log.d(TAG, "First: " + ss.get("first"));
//                    }
//
//            }
//        });

        firestoredb.collection("teachers")
                .document("21" )
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        Log.d("data", documentSnapshot.getData().toString());
                        Log.d("data", documentSnapshot.get("first").toString());
                        Double age = documentSnapshot.getDouble("age");
                        System.out.println(age);
                    }
                });

    }
}