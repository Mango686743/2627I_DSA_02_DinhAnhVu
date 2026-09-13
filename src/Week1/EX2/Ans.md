## Bài 2: COS226, Midterm f22 (Union-Find)

**Giả thiết:** Khởi tạo cấu trúc dữ liệu union-find với $n$ phần tử. Chuỗi thao tác thực hiện: `union(0, 1)`, `union(0, 2)`, ..., `union(0, n-1)`.

**Trả lời:**

**a) Cấu trúc dữ liệu thu được chứa tổng cộng bao nhiêu thành phần liên thông?**
* **Đáp án:** 1 thành phần liên thông.
* *Giải thích:* Xuyên suốt chuỗi thao tác, tất cả $n$ phần tử đã được gộp lại với nhau vào chung một tập hợp duy nhất.

**b) Cài đặt Quick-Find: Số lần cập nhật mảng (ký hiệu $\sim$)**
* **Đáp án:** $\sim rac{1}{2}n^2$ lần.
* *Giải thích:* Với thao tác `union(0, i)`, thuật toán phải duyệt toàn bộ mảng để đổi ID của các phần tử đang chung nhóm với 0 sang ID của i. Lần lượt số lượng phần tử bị cập nhật mảng (đổi ID) trong mỗi bước là $1, 2, 3, \dots, n-1$. Tổng số lần lặp là một cấp số cộng: $1 + 2 + \dots + (n-1) = rac{n(n-1)}{2} \sim rac{1}{2}n^2$.

**c) Cài đặt Quick-Union: Số lần truy cập mảng của find(0) (ký hiệu $\Theta$)**
* **Đáp án:** $\Theta(n)$ lần.
* *Giải thích:* Theo cơ chế Quick-Union thuần, `union(0, i)` sẽ luôn gán cha của gốc chứa 0 thành gốc chứa `i`. Sau chuỗi thao tác, cấu trúc cây bị suy biến thành một đường thẳng đứng: $0
  ightarrow 1
  ightarrow 2
  ightarrow \dots
  ightarrow n-1$. Nút 0 nằm ở vị trí sâu nhất. Do đó, `find(0)` phải truy xuất ngược lên $n$ lần để tìm tới gốc thực sự là $n-1$.

**d) Cài đặt Weighted Quick-Union: Số lần truy cập mảng của find(0) (ký hiệu $\Theta$)**
* **Đáp án:** $\Theta(1)$ lần.
* *Giải thích:* Với cơ chế ưu tiên trọng số (kích thước), cây lớn hơn sẽ giữ vai trò làm gốc. Ở thao tác đầu tiên `union(0, 1)`, hai cây có cùng kích thước 1, theo luật của đề bài thì `parent[1]` bị thay đổi thành `0`. Lúc này nút 0 trở thành gốc với kích thước là 2. Từ `union(0, 2)` trở đi, gốc 0 luôn có kích thước lớn hơn các nút độc lập còn lại, nên các nút $2, 3, \dots, n-1$ lần lượt bị gắn trực tiếp thành nút con của 0. Khi gọi `find(0)`, vì 0 đã là gốc ngay từ đầu nên chỉ tốn hằng số thao tác $\Theta(1)$.