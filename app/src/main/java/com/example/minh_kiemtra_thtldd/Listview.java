package com.example.minh_kiemtra_thtldd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class Listview extends AppCompatActivity {



    ArrayList<Product> listProduct;
    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;
    Button mdelete;
    Button mprofile_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
         mdelete = findViewById(R.id.delete);
         mprofile_listview = findViewById(R.id.profile_listview);

        mprofile_listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Listview.this,Profile.class);
                startActivity(intent);
            }
        });

        //Khoi tao ListProduct
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Cơn mưa ngang qua", "Sơn Tùng MTP" ));
        listProduct.add(new Product(2, "Hoa hải đường", "Jack"));
        listProduct.add(new Product(3, "Như những phút ban đầu", "Hoài Lâm"));
        listProduct.add(new Product(4, "Nàng Thơ", "Hoàng Dũng"));
        listProduct.add(new Product(5, "Hoa Nở Không Màu", "Hoài Lâm"));
        listProduct.add(new Product(6, "Khu tao sống", "Karik feat Wowy"));
        listProduct.add(new Product(7, "Đôi mắt người xưa", "Quang lê"));
        listProduct.add(new Product(8, "Chuyện Hoa sim", "Đan Nguyên"));

        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter((ListAdapter) productListViewAdapter);


        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
                Toast.makeText(Listview.this, product.name, Toast.LENGTH_LONG).show();
            }
        });


        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listProduct.size() > 0) {
                    //Xoá phần tử đầu tiên của danh sách
                    int productpost = 0;
                    listProduct.remove(productpost);
                    //Thông báo cho ListView biết dữ liệu đã thay đổi (cập nhật, xoá ...)
                    productListViewAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    //Model phần tử dữ liệu hiện
    class Product {
        String name;
        String singer;
        int productID;

        public Product(int productID, String name, String singer) {
            this.name = name;
            this.singer = singer;
            this.productID = productID;
        }
    }

    class ProductListViewAdapter extends BaseAdapter {

        //Dữ liệu liên kết bởi Adapter là một mảng các sản phẩm
        final ArrayList<Product> listProduct;

        ProductListViewAdapter(ArrayList<Product> listProduct) {
            this.listProduct = listProduct;
        }

        @Override
        public int getCount() {
            //Trả về tổng số phần tử, nó được gọi bởi ListView
            return listProduct.size();
        }

        @Override
        public Object getItem(int position) {
            //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
            //có chỉ số position trong listProduct
            return listProduct.get(position);
        }

        @Override
        public long getItemId(int position) {
            //Trả về một ID của phần
            return listProduct.get(position).productID;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
            //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
            //Nếu null cần tạo mới

            View viewProduct;
            if (convertView == null) {
                viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
            } else viewProduct = convertView;

            //Bind sữ liệu phần tử vào View
            Product product = (Product) getItem(position);
//            ((TextView) viewProduct.findViewById(R.id.idproduct)).setText(String.format("ID = %d", product.productID));
            ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("Hot song : %s", product.name));
            ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("%s", product.singer));


            return viewProduct;
        }
    }

}