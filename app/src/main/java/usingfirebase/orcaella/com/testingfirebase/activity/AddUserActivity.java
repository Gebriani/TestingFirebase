package usingfirebase.orcaella.com.testingfirebase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import usingfirebase.orcaella.com.testingfirebase.R;
import usingfirebase.orcaella.com.testingfirebase.model.UserModel;

/**
 * Created by gebriani on 20/04/16.
 */
public class AddUserActivity extends BaseActivity implements View.OnClickListener{

    private EditText fullname_editText;
    private EditText email_editText;
    private EditText phone_editText;
    private Spinner jenisKelamin_spinner;
    private Button send_button;
    private String genderValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        fullname_editText = (EditText) findViewById(R.id.add_user_fullname);
        email_editText = (EditText) findViewById(R.id.add_user_email);
        phone_editText =(EditText) findViewById(R.id.add_user_phone);
        jenisKelamin_spinner = (Spinner) findViewById(R.id.add_user_spinner_gender);
        send_button = (Button) findViewById(R.id.add_user_button_send);

        send_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_user_button_send:
                if(validateGender()){
                    UserModel userModel = new UserModel();
                    userModel.setEmail(email_editText.getText().toString());
                    userModel.setFullname(fullname_editText.getText().toString());
                    userModel.setPhone(phone_editText.getText().toString());
                    userModel.setGender(genderValue);
                    mRefChildUser.push().setValue(userModel);
                    startActivity(new Intent(this,MainActivity.class));
                }
                break;
        }
    }

    private boolean validateGender() {
        String[] genders = getResources().getStringArray(R.array.gender_arrays);
        genderValue = jenisKelamin_spinner.getSelectedItem().toString().substring(0, 1).toLowerCase() + jenisKelamin_spinner.getSelectedItem().toString().substring(1);
        if (genderValue.equalsIgnoreCase(genders[0])) {
            return false;
        } else {
            return true;
        }
    }
}
