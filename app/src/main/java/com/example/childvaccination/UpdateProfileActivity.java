package com.example.childvaccination;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class UpdateProfileActivity extends AppCompatActivity {
    private EditText editTextUpdateName,editTextUpdateDob,editTextUpdateMobile;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
    private ProgressBar progressBar;
    private FirebaseAuth authProfile;
    private DatePickerDialog picker;
    TextView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        getSupportActionBar().setTitle("Vaccination Centers");
        c1 = findViewById(R.id.center1);
        c2 = findViewById(R.id.center2);
        c3 = findViewById(R.id.center3);
        c4 = findViewById(R.id.center4);
        c5 = findViewById(R.id.center5);
        c6 = findViewById(R.id.center6);
        c7 = findViewById(R.id.center7);
        c8 = findViewById(R.id.center8);
        c9 = findViewById(R.id.center9);
        c10 = findViewById(R.id.center10);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?q=sree+seva+hospital+sata&biw=1536&bih=754&sxsrf=APwXEdcOhowgNs-bXBlCn-9on-hSIAR3fQ%3A1681779997931&ei=He09ZJ60OPrz4-EPho-xiA4&ved=0ahUKEwjetvfanrL-AhX6-TgGHYZHDOEQ4dUDCA8&uact=5&oq=sree+seva+hospital+sata&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzINCC4QDRCABBDHARCvATIICAAQigUQhgMyCAgAEIoFEIYDMhgILhANEIAEEMcBEK8BENwEEN0EEOAEGAI6BwgjEOoCECc6DQguEI8BEOoCELQCGAE6DQgAEI8BEOoCELQCGAE6BAgjECc6CAgAEIoFEJECOg0ILhCKBRDHARCvARBDOgsIABCABBCxAxCDAToNCAAQigUQsQMQgwEQQzoRCC4QgwEQxwEQsQMQ0QMQgAQ6CwguEIAEELEDEIMBOgcIABCKBRBDOggILhCABBCxAzoLCAAQigUQsQMQgwE6CwguEIAEELEDENQCOgUIABCABDoKCC4QgAQQFBCHAjoICAAQgAQQsQM6EwguEIAEELEDENwEEN4EEOAEGAI6EwguEIAEELEDENwEEN0EEOAEGAI6CAguELEDEIAEOhMILhCxAxCABBDcBBDeBBDgBBgCOhMILhCxAxCABBDcBBDdBBDgBBgCOgUILhCABDoOCC4QgAQQsQMQxwEQrwE6DgguEIAEELEDEMcBENEDOhgILhCKBRDHARCvARBDENwEEN4EEOAEGAI6GAguEIoFEMcBEK8BEEMQ3AQQ3QQQ4AQYAjoNCC4QgAQQsQMQ1AIQCjoKCC4QgAQQsQMQCjoGCAAQChADOg0IABCABBCxAxCDARAKOgsILhCABBDHARCvAToYCC4QgAQQsQMQ1AIQChDcBBDeBBDgBBgCOggILhCABBDUAjoHCC4QgAQQCjoQCC4QgAQQ3AQQ3gQQ4AQYAjoHCAAQgAQQCjoQCC4QgAQQ3AQQ3QQQ4AQYAjoGCAAQFhAeOgkIABAWEB4QiwM6CAgAEBYQHhAPOgsIABCKBRCGAxCLAzoHCAAQDRCABDoWCC4QDRCABBDHARCvARCLAxCmAxCoAzoWCC4QDRCABBDHARCvARCLAxCoAxCmAzoYCC4QDRCABBDHARCvARDcBBDeBBDgBBgCSgQIQRgAUABY-O8BYIWJAmgBcAB4BIABwgOIAaM1kgEIMi0yNi4wLjGYAQCgAQGwARS4AQLAAQHaAQYIARABGAraAQYIAhABGBQ&sclient=gws-wiz-serp");
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?sxsrf=APwXEdewQ7fte4N_vrpc__TP00UCBhlDtQ:1681780147864&q=datta+bal+rugnalaya+satara&spell=1&sa=X&ved=2ahUKEwib4bain7L-AhW17zgGHRF4DpEQBSgAegQIBxAB&biw=1536&bih=754&dpr=1.25");
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?q=shree+kamakshi+nursing+home&biw=1536&bih=754&sxsrf=APwXEdf1bmCHxZ6zwCYLv0t_CJvEAYQAGQ%3A1681780323946&ei=Y-49ZPaYOZieseMPx7yg4AY&gs_ssp=eJwFwUsKgCAUAEDaBp2gjZvW_sDfEbqFynsqopESePxm9oMmynlYoo5sXra5iy0ZQAeFIKNHBGsdWxGEFt6i1DEog-I-Zx4ApPrm68yF9G_M0hPJT4MfLRga7Q&oq=shree+kamakshi&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQARgAMgsILhCABBDHARCvATILCC4QgAQQxwEQrwEyCggAEIAEEBQQhwIyBQgAEIAEMgsILhCvARDHARCABDIFCC4QgAQyCggAEIAEEBQQhwIyBQgAEIAEMgUIABCABDILCC4QgAQQxwEQrwEyFgguEIAEEMcBEK8BENwEEN0EEOAEGAI6BwgjEOoCECc6DQguEI8BEOoCELQCGAE6DQgAEI8BEOoCELQCGAE6EwguEI8BEMcBENEDEOoCELQCGAE6BAgjECc6BwguEIoFEEM6BwgAEIoFEEM6CAgAEIoFEJECOg4ILhCKBRDHARCvARCRAjoLCAAQgAQQsQMQgwE6BAguECc6DQguEIoFEMcBEK8BEEM6CwgAEIoFEJECEIsDOh8ILhCKBRCxAxCDARDJAxDHARDRAxBDEIsDEKgDENIDOgoIABCKBRBDEIsDOhAILhCKBRBDEIsDEKEDEKgDOhYILhCKBRDHARCvARBDEIsDEKYDEKgDOhQILhCABBCxAxCLAxCoAxCaAxCbAzoTCAAQigUQsQMQgwEQyQMQQxCLAzoWCC4QigUQxwEQrwEQQxCLAxCoAxCmAzoRCAAQgAQQsQMQgwEQyQMQiwM6FAguEIAEELEDENQCEIsDEKgDEJoDOggILhCxAxCABDoICAAQgAQQsQM6EAguEIAEEBQQhwIQxwEQrwE6GwguEIAEEBQQhwIQxwEQrwEQ3AQQ3gQQ4AQYAjoWCC4QgAQQxwEQrwEQ3AQQ3gQQ4AQYAkoECEEYAFD7BVj3NmDXRGgBcAB4AIABlgOIAdYbkgEIMi0xMy4wLjGYAQCgAQGwARS4AQLAAQHaAQYIARABGAraAQYIAhABGBQ&sclient=gws-wiz-serp");
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?q=yashwant+nehru+hospital+satara&biw=1536&bih=754&sxsrf=APwXEdcJg64VRezoemZMAlRhFZZtQ8GzhQ%3A1681780151560&ei=t-09ZKzqIejm4-EPurex2Ag&oq=yashwant+neheru+hospita&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgAMgcIIRCgARAKMgcIIRCgARAKMgcIIRCgARAKMgcIIRCgARAKMgUIIRCSAzIFCCEQkgMyBQghEJIDMgUIIRCSAzIFCCEQkgMyBQghEJIDOgcIIxDqAhAnOg0IABCPARDqAhC0AhgBOg0ILhCPARDqAhC0AhgBOgQIIxAnOg4ILhCKBRDHARCvARCRAjoICAAQigUQkQI6EQguEIMBEMcBELEDENEDEIAEOgsIABCABBCxAxCDAToRCC4QgAQQsQMQgwEQxwEQ0QM6CAguEIAEELEDOg0ILhCKBRDHARCvARBDOgcILhCKBRBDOgcIABCKBRBDOhMILhCKBRCxAxCDARDHARDRAxBDOgsILhCDARCxAxCABDoSCC4QigUQQxDcBBDeBBDgBBgCOg4ILhCABBCxAxDHARDRAzoLCC4QgAQQsQMQgwE6CgguEBQQhwIQgAQ6BQguEIAEOg4ILhCABBCxAxCDARDUAjoLCC4QgAQQxwEQrwE6CAguEIoFELEDOhgILhCKBRDHARCvARBDENwEEN4EEOAEGAI6CwguEIAEELEDENQCOgsILhDUAhCxAxCABDoHCC4QgAQQCjoQCC4QgAQQsQMQgwEQ1AIQCjoNCC4QgAQQxwEQrwEQCjoNCC4QgAQQsQMQ1AIQCjoZCC4QigUQxwEQrwEQkQIQ3AQQ3gQQ4AQYAjoKCC4QgAQQFBCHAjoFCAAQgAQ6FQguEBQQhwIQgAQQ3AQQ3gQQ4AQYAjoHCAAQgAQQCjoQCC4QgAQQFBCHAhDHARCvAToKCC4QDRCxAxCABDoHCAAQDRCABDoVCC4QDRCxAxCABBDcBBDeBBDfBBgCOgcILhANEIAEOg0ILhANEIAEEMcBEK8BOhIILhANEIAEENwEEN4EEOAEGAJKBAhBGABQrAdYsH1gopYBaANwAHgAgAGwAogBuy-SAQYyLTI0LjGYAQCgAQGwARTAAQHaAQYIARABGAraAQYIAhABGBQ&sclient=gws-wiz-serp");
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?q=patil+hospita+pvt+ltd+koregaon+satara&biw=1536&bih=754&sxsrf=APwXEde3JZAN_x9h2Ds3WSPPg7TGyBhiiQ%3A1681780429391&ei=ze49ZPLJF7qfseMP2PqWyAQ&ved=0ahUKEwiy5NWooLL-AhW6T2wGHVi9BUkQ4dUDCA8&uact=5&oq=patil+hospita+pvt+ltd+koregaon+satara&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIHCCEQoAEQCjIHCCEQoAEQCjIHCCEQoAEQCjoNCC4QxwEQrwEQ6gIQJzoHCCMQ6gIQJzoNCAAQjwEQ6gIQtAIYAToNCC4QjwEQ6gIQtAIYAToECCMQJzoICAAQigUQkQI6CwgAEIAEELEDEIMBOgUILhCABDoQCAAQgAQQFBCHAhCxAxCDAToHCC4QigUQQzoHCAAQigUQQzoICC4QsQMQgAQ6FwguEIoFEMcBEK8BEJECEIsDEKYDEKgDOgoIABCKBRBDEIsDOg0IABCKBRCxAxBDEIsDOg0IABCKBRDJAxBDEIsDOgsIABCKBRCSAxCLAzoZCC4QgAQQFBCHAhDHARCvARCLAxCmAxCoAzoLCAAQgAQQsQMQiwM6DggAEIoFELEDEIMBEIsDOhYILhCKBRDHARCvARBDEIsDEKgDEKYDOggIABCABBCLAzoaCC4QgwEQrwEQxwEQsQMQgAQQiwMQpgMQqAM6GQguEIAEEBQQhwIQxwEQrwEQiwMQqAMQpgM6EQguEIAEELEDEIsDEJgDEKgDOhYILhCKBRDHARCvARBDEIsDEKYDEKgDOgUIABCABDoLCAAQigUQkQIQiwM6FAguEIAEEMcBEK8BEIsDEKYDEKgDOhcILhCKBRDHARCvARCRAhCLAxCoAxCmAzoUCC4QgAQQxwEQrwEQiwMQqAMQpgM6BwgAEA0QgAQ6DQguEA0QgAQQxwEQrwE6CgghEBYQHhAdEAo6CAghEBYQHhAdOgQIIRAVOgYIIRAVEAo6BAghEApKBAhBGABQ_wdYi40BYI-TAWgBcAB4AIAB-AKIAalHkgEGMi0zNS4ymAEAoAEBsAEUuAECwAEB2gEGCAEQARgK&sclient=gws-wiz-serp");
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?q=lahoti+childrens+hospital+karad&biw=1536&bih=754&sxsrf=APwXEdfsN3d_PbfbdESETfHkZ7VTaGrVQA%3A1681780520732&ei=KO89ZMutLJycseMPj_OvoAI&ved=0ahUKEwjL4ZzUoLL-AhUcTmwGHY_5CyQQ4dUDCA8&uact=5&oq=lahoti+childrens+hospital+karad&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIFCAAQogQyBQgAEKIEMgUIABCiBDIFCAAQogQyBQgAEKIEOgcIIxDqAhAnOg0ILhDHARCvARDqAhAnOg0IABCPARDqAhC0AhgBOgQIIxAnOg4ILhCKBRDHARDRAxCRAjoOCC4QigUQxwEQrwEQkQI6EQguEIAEELEDEIMBEMcBENEDOgsIABCKBRCxAxCDAToLCAAQgAQQsQMQgwE6BwgAEIoFEEM6DQguEMcBENEDEIoFEEM6DgguEIAEELEDEMcBENEDOgoILhCKBRCxAxBDOg0ILhCKBRDHARCvARBDOhAILhCABBAUEIcCEMcBEK8BOg0ILhCKBRDHARDRAxBDOgoIABCKBRCxAxBDOgUILhCABDoICC4QsQMQigU6EwguEIAEEBQQhwIQsQMQxwEQrwE6CwguEIAEEMcBEK8BOgoIABCABBAUEIcCOgUIABCABDoYCC4QigUQxwEQ0QMQQxDcBBDeBBDgBBgCOggIABAWEB4QDzoGCAAQFhAeOgoIABAWEB4QDxAKOhAILhCABBDcBBDeBBDgBBgCOggIABCKBRCGAzoHCCEQoAEQCjoFCCEQoAE6BAghEBU6BgghEBUQCjoICCEQFhAeEB1KBAhBGABQoAdYsG1gn3FoAXAAeAGAAaoFiAGtQJIBCjItMjcuMi4xLjGYAQCgAQGwARTAAQHaAQYIARABGAraAQYIAhABGBQ&sclient=gws-wiz-serp");
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?sxsrf=APwXEddnwPv6aCpUDS9UOfdQXBIHgsj1fw:1681780676362&q=utkarsha+maternity+children%27s+hospital+karad&spell=1&sa=X&ved=2ahUKEwjq1beeobL-AhXHVmwGHVGcDDoQBSgAegQIBRAB&biw=1536&bih=754&dpr=1.25");
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?q=dr.gawade+children+hospital+phaltan&biw=1536&bih=754&sxsrf=APwXEdfVql4ePEXJip3WwCTZsQCCCGHSVg%3A1681780679112&ei=x-89ZPG7BpyYseMPnPqZkAg&ved=0ahUKEwixu9-fobL-AhUcTGwGHRx9BoIQ4dUDCA8&uact=5&oq=dr.gawade+children+hospital+phaltan&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzoHCCMQ6gIQJzoNCC4QxwEQrwEQ6gIQJzoNCC4QjwEQ6gIQtAIYAToNCAAQjwEQ6gIQtAIYAToECCMQJzoHCC4QigUQQzoICAAQigUQkQI6DgguEIoFEMcBEK8BEJECOg0IABCKBRCxAxCDARAKOgcIABCKBRBDOhEILhCABBCxAxCDARDHARDRAzoICAAQgAQQsQM6CggAEIAEEBQQhwI6CwguEIAEELEDEIMBOhAILhCABBAUEIcCELEDEIMBOgUILhCABDoFCAAQgAQ6CwguEIAEEMcBENEDOgsILhCABBDHARCvAToQCC4QgAQQ3AQQ3gQQ4AQYAjoECAAQHjoGCAAQCBAeOggIIRAWEB4QHToFCAAQogQ6BwghEKABEApKBAhBGABQ9gZY8IgBYK2XAWgDcAB4AIABiAKIAbM_kgEGMC40LjMzmAEAoAEBsAEUwAEB2gEGCAEQARgK2gEGCAIQARgU&sclient=gws-wiz-serp");
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?q=chirayu+childres+hospital+baramati&biw=1536&bih=754&sxsrf=APwXEdcVsaJG54npbg1AKCu_Sesig9UaKg%3A1681780741060&ei=BfA9ZImtA7aLseMPicW-4As&ved=0ahUKEwjJw6S9obL-AhW2RWwGHYmiD7wQ4dUDCA8&uact=5&oq=chirayu+childres+hospital+baramati&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIHCAAQDRCABDINCC4QDRCABBDHARCvAToHCCMQ6gIQJzoNCC4QxwEQrwEQ6gIQJzoNCAAQjwEQ6gIQtAIYAToTCC4QjwEQxwEQ0QMQ6gIQtAIYAToNCC4QjwEQ6gIQtAIYAToECCMQJzoICAAQigUQkQI6DgguEIoFEMcBEK8BEJECOgsIABCKBRCxAxCDAToICAAQgAQQsQM6CwgAEIAEELEDEIMBOhEILhCABBCxAxCDARDHARDRAzoHCAAQigUQQzoKCC4QigUQ1AIQQzoNCC4QigUQxwEQ0QMQQzoLCAAQigUQkQIQiwM6CggAEIoFEEMQiwM6EwguEIoFENQCEEMQiwMQqAMQpAM6FgguEIoFEMcBENEDEEMQiwMQqAMQ0gM6CggAEIoFELEDEEM6FgguEIoFELEDEEMQiwMQqAMQmAMQmgM6DQgAEIoFELEDEEMQiwM6CwgAEIAEEJIDEIsDOhAIABCKBRCxAxDJAxBDEIsDOgsIABCKBRCSAxCLAzoKCC4QigUQsQMQQzoRCC4QsQMQgAQQiwMQmgMQqAM6EAguEIoFEEMQiwMQqAMQmgM6CwgAEIAEELEDEIsDOhUILhCKBRCxAxBDENwEEN4EEN8EGAI6FAguEK8BEMcBEIAEEIsDEKYDEKgDOhAILhCABBAKEIsDEKgDEJ4DOhQILhCABBDHARCvARCLAxCmAxCoAzoRCC4QgAQQiwMQmAMQmgMQqAM6FgguEIoFEMcBEK8BEEMQiwMQpgMQqAM6CAgAEIAEEIsDOhQILhCABBDHARCvARCLAxCoAxCmAzoXCC4QrwEQxwEQigUQkQIQiwMQpgMQqAM6FwguEIoFEMcBEK8BEJECEIsDEKYDEKgDOhEILhCABBCLAxCoAxCYAxCaAzoFCAAQgAQ6CwguEIAEEMcBEK8BOgsILhCvARDHARCABDoKCAAQgAQQFBCHAjoNCC4QDRCvARDHARCABDoYCC4QDRCABBDHARCvARDcBBDeBBDgBBgCOgYIABAWEB5KBAhBGABQnQhYz8ABYIHIAWgBcAB4AIABpAOIAYhDkgEIMi0zMC4zLjGYAQCgAQGwARS4AQLAAQHaAQYIARABGAraAQYIAhABGBQ&sclient=gws-wiz-serp");
            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/search?q=meheta+hospital+baramati&biw=1536&bih=754&sxsrf=APwXEdcwBrOvCBn2PGtX-n5uEKxC1ZhHyQ%3A1681780801470&ei=QfA9ZIOTHJTXseMP2qaU2Ag&ved=0ahUKEwjDt4vaobL-AhWUa2wGHVoTBYsQ4dUDCA8&uact=5&oq=meheta+hospital+baramati&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzINCC4QDRCABBDHARCvATIHCAAQDRCABDIHCAAQDRCABDIICAAQigUQhgMyCAgAEIoFEIYDMggIABCKBRCGAzIICAAQigUQhgMyCAgAEIoFEIYDMhgILhANEIAEEMcBEK8BENwEEN4EEOAEGAI6BwgjEOoCECc6DQguEMcBEK8BEOoCECc6DQgAEI8BEOoCELQCGAE6DQguEI8BEOoCELQCGAE6BAgjECc6DgguEIoFEMcBEK8BEJECOgsIABCABBCxAxCDAToRCC4QgAQQsQMQgwEQxwEQ0QM6CwgAEIoFELEDEIMBOgQILhAnOg0ILhCKBRDHARCvARBDOgcIABCKBRBDOgcILhCKBRBDOhAIABCABBAUEIcCELEDEIMBOg0ILhDcBBDeBBDfBBgCOggIABCABBCxAzoYCC4QigUQxwEQrwEQQxDcBBDeBBDgBBgCOg0ILhCvARDHARCKBRBDOggIABCKBRCRAjoKCAAQgAQQFBCHAjoLCAAQgAQQsQMQyQM6CAguELEDEIAEOhgILhCvARDHARCKBRBDENwEEN4EEOAEGAI6BQgAEIAEOg0ILhCABBDHARCvARAKOgcIABCABBAKOgcILhCABBAKOgoIABCABBCxAxAKOg0ILhCABBDHARDRAxAKOg0ILhCvARDHARCABBAKOg4ILhCvARDHARCKBRCRAjoNCC4QDRCvARDHARCABDoGCAAQFhAeOggIABAIEB4QDUoECEEYAFCrBljNSmDmUmgBcAB4AIABrQKIAaotkgEGMi0yMy4xmAEAoAEBsAEUwAEB2gEGCAEQARgK2gEGCAIQARgU&sclient=gws-wiz-serp");
            }
        });
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}