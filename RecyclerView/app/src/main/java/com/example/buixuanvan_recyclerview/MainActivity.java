package com.example.buixuanvan_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerDanhSach;
    private MyAdapter adapter;
    private final List<ItemModel> danhSach = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerDanhSach = findViewById(R.id.recycler_danh_sach);

        // === chọn 1 trong 2 để tạo khác biệt ===
        // 1) Danh sách dọc:
        recyclerDanhSach.setLayoutManager(new LinearLayoutManager(this));

        // Dữ liệu mẫu (tạm dùng icon mặc định)
        danhSach.add(new ItemModel(
                "Android",
                "Android là hệ điều hành mã nguồn mở được phát triển bởi Google, "
                        + "chủ yếu dành cho các thiết bị di động như điện thoại và máy tính bảng. "
                        + "Nó hỗ trợ hàng triệu ứng dụng trên Google Play Store và được viết chủ yếu bằng ngôn ngữ Java và Kotlin.",
                R.drawable.android_logo));

        danhSach.add(new ItemModel(
                "RecyclerView",
                "RecyclerView là thành phần mạnh mẽ để hiển thị danh sách dữ liệu lớn trong Android. "
                        + "Nó được tối ưu hóa so với ListView, sử dụng ViewHolder để tái sử dụng view, "
                        + "giúp tiết kiệm bộ nhớ và tăng hiệu suất hiển thị. "
                        + "Lập trình viên có thể tùy biến layout theo hướng dọc, ngang, lưới hoặc dạng thẻ.",
                R.drawable.recyclerview_icon));

        danhSach.add(new ItemModel(
                "CardView",
                "CardView là một container dạng thẻ có bo góc và đổ bóng, giúp giao diện trở nên nổi khối, tinh tế hơn. "
                        + "Khi kết hợp cùng RecyclerView, nó thường được dùng để hiển thị thông tin sản phẩm, danh bạ hoặc bài viết. "
                        + "CardView cũng hỗ trợ bo tròn ảnh và tạo hiệu ứng Material Design.",
                R.drawable.cardview_icon));

        danhSach.add(new ItemModel(
                "Intent",
                "Intent được dùng để chuyển dữ liệu hoặc điều hướng giữa các Activity trong ứng dụng Android. "
                        + "Ngoài ra, Intent còn được dùng để gửi yêu cầu tới các ứng dụng khác, "
                        + "ví dụ như mở trình duyệt, gửi email hoặc chia sẻ nội dung qua mạng xã hội.",
                R.drawable.intent_icon));

        danhSach.add(new ItemModel(
                "Fragment",
                "Fragment là một phần nhỏ có thể tái sử dụng của giao diện trong Activity. "
                        + "Mỗi Fragment có vòng đời riêng, có thể thêm hoặc thay thế linh hoạt trong khi Activity đang chạy. "
                        + "Nó thường được dùng để xây dựng giao diện linh hoạt trên nhiều kích thước màn hình, như điện thoại và máy tính bảng.",
                R.drawable.fragment_icon));

        danhSach.add(new ItemModel(
                "Service",
                "Service là thành phần chạy nền trong Android, "
                        + "cho phép thực hiện các tác vụ dài như phát nhạc, tải dữ liệu, hoặc đồng bộ hóa mà không cần giao diện người dùng. "
                        + "Service có thể hoạt động độc lập hoặc được điều khiển bởi Activity thông qua Intent.",
                R.drawable.service_icon));

        danhSach.add(new ItemModel(
                "BroadcastReceiver",
                "BroadcastReceiver dùng để nhận và xử lý các sự kiện (broadcast) từ hệ thống hoặc ứng dụng khác. "
                        + "Ví dụ: khi thiết bị khởi động, thay đổi kết nối mạng, hoặc nhận tin nhắn SMS. "
                        + "Lập trình viên có thể tạo broadcast tùy chỉnh để giao tiếp giữa các thành phần trong app.",
                R.drawable.broadcast_icon));

        danhSach.add(new ItemModel(
                "ContentProvider",
                "ContentProvider cho phép chia sẻ dữ liệu giữa các ứng dụng trong Android một cách an toàn. "
                        + "Nó sử dụng URI để truy cập dữ liệu (giống như đường dẫn trong web). "
                        + "Thường được dùng khi ứng dụng cần chia sẻ dữ liệu người dùng như danh bạ, hình ảnh, hoặc video.",
                R.drawable.contentprovider_icon));


        adapter = new MyAdapter(this, danhSach, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemModel item) {
                // Click cả item -> Toast
                Toast.makeText(MainActivity.this, "Bạn chọn: " + item.getTieuDe(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSubActionClick(ItemModel item) {
                // Click nút "Chi tiết" -> mở trang chi tiết
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra("tieu_de", item.getTieuDe());
                i.putExtra("mo_ta", item.getMoTa());
                i.putExtra("img", item.getImageResId());
                startActivity(i);
            }
        });

        recyclerDanhSach.setAdapter(adapter);
    }
}
