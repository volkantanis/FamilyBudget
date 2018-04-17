package pro.tanis.familybudget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FireStore {





    private static FirebaseFirestore mFirestore;

    public void AddFire(final Context context, String category, String subCategory,
                        String description, Integer priceMonthly, Integer priceYearly){

        Map<String,Object> dataToAdd = new HashMap<>();
        dataToAdd.put("Category",category);
        dataToAdd.put("Sub Category",subCategory);
        dataToAdd.put("Description",description);
        dataToAdd.put("Monthly Price",priceMonthly);
        dataToAdd.put("Yearly Price",priceYearly);

        mFirestore = FirebaseFirestore.getInstance();

        mFirestore.collection("Expenses").document().set(dataToAdd).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(context ,"Error : " + e.getMessage(),Toast.LENGTH_SHORT).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                Toast.makeText(context ,"Successful",Toast.LENGTH_SHORT).show();

            }
        });




    }



}
