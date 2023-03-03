package dk.stbn.bouncylibdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;
    TextView t;
    static int tæller = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate blev kaldt "+tæller);
        tæller++;
        //Bouncy Castle


        X500NameBuilder nameBuilder = new X500NameBuilder();
        nameBuilder.addRDN(BCStyle.PSEUDONYM, "xyz");
        nameBuilder.addRDN(BCStyle.E, "e@example.com");
        X500Name name = nameBuilder.build();

        System.out.println(name);

        //Gui
        t = findViewById(R.id.mintekst);
        t.setText("Navnet var: "+name);
        b= findViewById(R.id.minknap);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == b) {
            System.out.println("der blev trykket på knappen");
        }
    }
}