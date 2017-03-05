package nl.avans.android.booklistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public final String TAG = this.getClass().getSimpleName();

    public final static String EXTRA_AUTHOR = "AUTHOR";
    public final static String EXTRA_TITLE = "TITLE";
    public final static String EXTRA_LONG_DESCRIPTION = "LONG_DESCRIPTION";
    public final static String EXTRA_BOOK = "BOOK";

    private ListView listViewBooks;
//    private ArrayAdapter<Book> bookArrayAdapter;
    private BaseAdapter bookAdapter;
    private ArrayList<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Book book;
        for(int i = 0; i < 40; i++) {
            book = new Book();
            book.setTitle("De ontdekking van de hemel");
            book.setAuthor("Harry Mulisch");
            book.setShortDescription("Een heel goed boek");
            book.setLongDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras cursus quis tellus non imperdiet. Integer ullamcorper nisl sed nibh vehicula consectetur. Aenean commodo erat id metus lacinia auctor. Morbi eget tellus accumsan, blandit velit vel, bibendum nunc. Maecenas eu metus justo. Duis tincidunt suscipit tellus in elementum. Sed a eros at lacus egestas pretium. Nulla iaculis auctor mauris vitae rutrum. Fusce at mi nec orci blandit molestie. Pellentesque commodo scelerisque dui sit amet convallis. Fusce nec fringilla sem, nec malesuada eros. Sed ut diam quis felis bibendum facilisis. Morbi vestibulum risus quis porttitor tempor. Proin fermentum, orci vel blandit aliquet, lectus augue varius arcu, id pulvinar nisl neque in purus. Morbi sed posuere eros.");
            books.add(book);

            book = new Book();
            book.setTitle("Bonita Avenue");
            book.setAuthor("Peter Buwalda");
            book.setShortDescription("Een heel goed boek");
            book.setLongDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras cursus quis tellus non imperdiet. Integer ullamcorper nisl sed nibh vehicula consectetur. Aenean commodo erat id metus lacinia auctor. Morbi eget tellus accumsan, blandit velit vel, bibendum nunc. Maecenas eu metus justo. Duis tincidunt suscipit tellus in elementum. Sed a eros at lacus egestas pretium. Nulla iaculis auctor mauris vitae rutrum. Fusce at mi nec orci blandit molestie. Pellentesque commodo scelerisque dui sit amet convallis. Fusce nec fringilla sem, nec malesuada eros. Sed ut diam quis felis bibendum facilisis. Morbi vestibulum risus quis porttitor tempor. Proin fermentum, orci vel blandit aliquet, lectus augue varius arcu, id pulvinar nisl neque in purus. Morbi sed posuere eros.");
            books.add(book);

            book = new Book();
            book.setTitle("Cesarion");
            book.setAuthor("Tommy Wieringa");
            book.setShortDescription("Een heel goed boek");
            book.setLongDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras cursus quis tellus non imperdiet. Integer ullamcorper nisl sed nibh vehicula consectetur. Aenean commodo erat id metus lacinia auctor. Morbi eget tellus accumsan, blandit velit vel, bibendum nunc. Maecenas eu metus justo. Duis tincidunt suscipit tellus in elementum. Sed a eros at lacus egestas pretium. Nulla iaculis auctor mauris vitae rutrum. Fusce at mi nec orci blandit molestie. Pellentesque commodo scelerisque dui sit amet convallis. Fusce nec fringilla sem, nec malesuada eros. Sed ut diam quis felis bibendum facilisis. Morbi vestibulum risus quis porttitor tempor. Proin fermentum, orci vel blandit aliquet, lectus augue varius arcu, id pulvinar nisl neque in purus. Morbi sed posuere eros.");
            books.add(book);

            book = new Book();
            book.setTitle("Het Diner");
            book.setAuthor("Herman Koch");
            book.setShortDescription("Een heel goed boek");
            book.setLongDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras cursus quis tellus non imperdiet. Integer ullamcorper nisl sed nibh vehicula consectetur. Aenean commodo erat id metus lacinia auctor. Morbi eget tellus accumsan, blandit velit vel, bibendum nunc. Maecenas eu metus justo. Duis tincidunt suscipit tellus in elementum. Sed a eros at lacus egestas pretium. Nulla iaculis auctor mauris vitae rutrum. Fusce at mi nec orci blandit molestie. Pellentesque commodo scelerisque dui sit amet convallis. Fusce nec fringilla sem, nec malesuada eros. Sed ut diam quis felis bibendum facilisis. Morbi vestibulum risus quis porttitor tempor. Proin fermentum, orci vel blandit aliquet, lectus augue varius arcu, id pulvinar nisl neque in purus. Morbi sed posuere eros.");
            books.add(book);
        }

        listViewBooks = (ListView) findViewById(R.id.listViewBooks);

//        bookArrayAdapter = new ArrayAdapter<Book>(this, android.R.layout.simple_list_item_1, books);
//        listViewBooks.setAdapter(bookArrayAdapter);
//        bookArrayAdapter.notifyDataSetChanged();

        bookAdapter = new BookAdapter(this, getLayoutInflater(), books);
        listViewBooks.setAdapter(bookAdapter);
        bookAdapter.notifyDataSetChanged();

        listViewBooks.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "Item " + position + " is geselecteerd");

        Book b = books.get(position);
        Intent intent = new Intent(getApplicationContext(), BookDetailActivity.class);

//        intent.putExtra(EXTRA_TITLE, b.getTitle());
//        intent.putExtra(EXTRA_AUTHOR, b.getAuthor());
//        intent.putExtra(EXTRA_LONG_DESCRIPTION, b.getLongDescription());

        intent.putExtra(EXTRA_BOOK, b);
        startActivity(intent);
    }
}
