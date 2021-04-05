package com.example.acdemo.ac.view;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.acdemo.R;
import com.example.acdemo.ac.communication.Constants;
import com.example.acdemo.ac.model.Courses;
import com.example.acdemo.ac.model.CoursesList;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ScrHomeCertificationCourseDetails extends AppCompatActivity implements View.OnClickListener {
    private Button bt_course_completed;
    private static final String TAG = "PdfCreatorActivity";
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;

    private File pdfFile;
    private PdfPCell cell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_scr_certification_course_details);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        initUi();
      }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }

    public void initUi()
    {
        bt_course_completed=findViewById(R.id.bt_course_completed);
        bt_course_completed.setOnClickListener(this);
    }


    private void showGenerateCertificateDialog() {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_course_completd);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button bt_generate_certificate = dialog.findViewById(R.id.bt_generate_certificate);
        bt_generate_certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    createPdfWrapper();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    private void createPdfWrapper() throws FileNotFoundException, DocumentException {

        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
                    showMessageOKCancel("You need to allow access to Storage",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                                REQUEST_CODE_ASK_PERMISSIONS);
                                    }
                                }
                            });
                    return;
                }
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        } else {
            createPdf();
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void createPdf() throws FileNotFoundException, DocumentException {

        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/Documents");
        if (!docsFolder.exists()) {
            docsFolder.mkdir();
            // Toast.makeText(this, "created pdf", Toast.LENGTH_LONG).show();
            Log.i(TAG, "Created a new directory for PDF");
        }

        String pdfname = "Course Certificate.pdf";
        pdfFile = new File(docsFolder.getAbsolutePath(), pdfname);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(pdfFile), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        OutputStream output = new FileOutputStream(pdfFile);


        Rectangle layout = new Rectangle(PageSize.A4);
        layout.setBorderColor(BaseColor.DARK_GRAY);  //Border color
        layout.setBorderWidth(20);      //Border width
        layout.setBorder(Rectangle.BOX);  //Border on 4 sides


        Document document = new Document(layout);


        Font title = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.NORMAL, BaseColor.BLACK);
        Font description = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.NORMAL, BaseColor.BLACK);
        Font date = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.NORMAL, BaseColor.BLACK);
        Font small_bold = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD|Font.UNDERLINE, BaseColor.BLACK);

        String logo_url ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6cAOD_PfQy-Neg3wxmK8nFeCoDqqnHUiAxg&usqp=CAU";
        Image logo = null;
        try {
            logo = Image.getInstance(logo_url);
            Log.d("TAG", "logo" + logo);
        } catch (IOException e) {
            e.printStackTrace();
        }



        String ac_logo_url ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6cAOD_PfQy-Neg3wxmK8nFeCoDqqnHUiAxg&usqp=CAU";
        Image ac_logo = null;
        try {
            ac_logo = Image.getInstance(ac_logo_url);
            Log.d("TAG", "logo" + ac_logo);
        } catch (IOException e) {
            e.printStackTrace();
        }


/*

        PdfPTable ac_logo_table = new PdfPTable(1);
        ac_logo_table.setSpacingAfter(30);
        ac_logo_table.setWidthPercentage(100);
        PdfPCell ac_cell_logo = new PdfPCell(ac_logo);
        ac_cell_logo.setBorder(Rectangle.NO_BORDER);
        ac_cell_logo.setFixedHeight(100);
        ac_cell_logo.setHorizontalAlignment(Element.ALIGN_LEFT);
        ac_logo_table.addCell(ac_cell_logo);
*/

        PdfPTable space_table=new PdfPTable(1);
        space_table.setWidthPercentage(150);
        PdfPCell spaceCell1 = new PdfPCell(new Phrase());
        spaceCell1.setFixedHeight(80);
        spaceCell1.setBorder(Rectangle.NO_BORDER);
        spaceCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        space_table.addCell(spaceCell1);

        PdfPTable logo_table = new PdfPTable(1);
        logo_table.setSpacingAfter(30);
        logo_table.setWidthPercentage(100);
        PdfPCell cell_logo = new PdfPCell(logo);
        cell_logo.setBorder(Rectangle.NO_BORDER);
        cell_logo.setFixedHeight(100);
        cell_logo.setHorizontalAlignment(Element.ALIGN_CENTER);
        logo_table.addCell(cell_logo);


        Paragraph certificate_title = new Paragraph("CERTIFICATE OF COMPLETION",title);
        certificate_title.setAlignment(Paragraph.ALIGN_CENTER);
        certificate_title.setSpacingAfter(30);


        Paragraph certificate_date = new Paragraph("Date : 21-08-2021",date);
        certificate_date.setAlignment(Paragraph.ALIGN_LEFT);
        certificate_date.setSpacingAfter(30);


        Paragraph certificate_description = new Paragraph("This is to certify that Cecelia Joseph sucessfully completed the Android Development online course of study offered by Corporate Institute of Management-Test Institute.");
        certificate_description.setAlignment(Paragraph.ALIGN_CENTER);
        certificate_description.setSpacingAfter(60);


        PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell(new Phrase("Test Intitue Admin",small_bold));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPaddingBottom(10);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell.setPhrase(new Phrase("Asish Sharma",small_bold));
        table.addCell(cell);


        PdfPTable table1= new PdfPTable(2);
        PdfPCell cell1= new PdfPCell(new Phrase("Instructor",date));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(cell1);
        cell1.setPhrase(new Phrase("Principal",date));
        table1.addCell(cell1);

        PdfWriter.getInstance(document, output);
        document.open();
       // document.add(ac_logo_table);
        document.add(space_table);
        document.add(logo_table);
        document.add(certificate_title);
        document.add(certificate_date);
        document.add(certificate_description);
        document.add(table);
        document.add(table1);
        document.close();

    }



    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case  R.id.bt_course_completed:
                showGenerateCertificateDialog();
                break;
        }
    }
}