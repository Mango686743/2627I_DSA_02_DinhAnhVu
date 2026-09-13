## Bài 5: COS226, Midterm f24, 4 (Xác minh Weighted Quick-Union)

**Câu hỏi:** Biểu diễn `parent-link` trong hình có thể là của cấu trúc dữ liệu Weighted Quick-Union hay không?

**Đáp án:** **KHÔNG**.

**Giải thích chi tiết (Phân tích mâu thuẫn kích thước cây):**

Dựa vào mảng `parent[]`, ta có thể vẽ lại cấu trúc cây như sau:
* Nút gốc (root) tối cao là `5`.
* `5` có hai con trực tiếp là `7` và `0`.
* Cây con gốc `7` có kích thước là 2 (gồm 7, 9).
* Cây con gốc `0` có kích thước là 7 (gồm 0, 2, 4, 3, 6, 1, 8).

Theo tính chất của thuật toán Weighted Quick-Union (WQU):
1. Lệnh `union(p, q)` chỉ thao tác nối trực tiếp giữa các **nút gốc**.
2. Khi một nút (ví dụ nút 0) đã trỏ vào một nút cha (nút 5), nó không còn là gốc nữa. Bất kỳ lệnh `union` nào gọi tới tập hợp của 0 lúc này sẽ tìm lên gốc mới là 5 để nối.
   $
   ightarrow$ Do đó, **toàn bộ cây con bên dưới nút 0 bắt buộc phải được gộp xong xuôi TRƯỚC KHI gốc 0 gộp với gốc 5**.

Ta xét tại thời điểm diễn ra thao tác `union` cuối cùng giữa tập hợp chứa 0 và tập hợp chứa 5:
* Kích thước của gốc 0 lúc này là tổng số đỉnh của toàn bộ nhánh con bên dưới nó: $size(0) = 7$.
* Kích thước của gốc 5 lúc này bằng chính nó cộng với nhánh con 7 (đã gộp trước đó) hoặc chỉ có một mình nó. Tóm lại, kích thước tối đa của gốc 5 là: $size(5) \le 3$.
* Khi gộp hai gốc này lại, thuật toán WQU bắt buộc gốc của cây nhỏ hơn phải trỏ vào gốc của cây lớn hơn. Vì $size(5) < size(0)$ ($3 < 7$), **nút 5 phải trỏ vào nút 0**.
* Tuy nhiên, trên mảng được cho lại thể hiện `parent[0] = 5`, tức là cây lớn trỏ vào cây nhỏ. Điều này vi phạm nghiêm trọng luật ưu tiên trọng số của WQU.

=> Kết luận: Cấu trúc này không thể được tạo ra bởi thuật toán Weighted Quick-Union.