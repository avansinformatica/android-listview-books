package nl.avans.android.booklistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static nl.avans.android.booklistview.MainActivity.EXTRA_BOOK;

public class BookDetailActivity extends AppCompatActivity {

    private TextView textAuthor;
    private TextView textTitle;
    private TextView textLongDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        textAuthor = (TextView) findViewById(R.id.textAuthor);
        textTitle = (TextView) findViewById(R.id.textTitle);
        textLongDescription = (TextView) findViewById(R.id.textLongDescription);

        Bundle extras = getIntent().getExtras();

//        textAuthor.setText(extras.getString(EXTRA_AUTHOR));
//        textTitle.setText(extras.getString(EXTRA_TITLE));
//        textLongDescription.setText(extras.getString(EXTRA_LONG_DESCRIPTION));

        Book b = (Book) extras.getSerializable(EXTRA_BOOK);
        textAuthor.setText(b.getAuthor());
        textTitle.setText(b.getTitle());
        textLongDescription.setText(b.getLongDescription());
    }
}
