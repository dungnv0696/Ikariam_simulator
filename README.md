Xây dựng ứng dụng hỗ trợ tấn công cho game Ikariam đánh BỘ
1) Mục tiêu: ứng dụng cho phép người chơi giả lập được các thao tác tấn công, tăng quân, rút quân, kích hoạt lò, kích hoạt Colossus khi chơi game. Trước khi tấn công một nhà đối phương trong game Ikariam, người chơi sẽ sử dụng ứng dụng này để lường trước được các thiệt hại của mình.
2) Thuật ngữ:
a) Kích lò: là hành động kích hoạt tính năng đặc biệt của game. Một khi phe tấn công hoặc phòng thủ kích hoạt lò thì tất cả các đơn vị chiến đấu đều tăng thêm một lượng giáp và tăng thêm một lượng phần trăm sức tấn công. Thời gian hiệu lực: 1 ngày. Thời gian tối thiểu giữa 2 lần kích hoạt lò: có các giá trị khác nhau gồm 7 ngày, 3 ngày 12 giờ, 2 ngày 8 giờ, 1 ngày 6 giờ. Giá trị này tùy thuộc vào điều kiện của người muốn kích hoạt
Có các mức lò khác nhau và hiệu ứng cũng khác nhau.
Lò mức 1	Tăng 0 giáp và 10% sức tấn công
Lò mức 2	Tăng 1 giáp và 10% sức tấn công
Lò mức 3	Tăng 1 giáp và 15% sức tấn công
Lò mức 4	Tăng 2 giáp và 15% sức tấn công
Lò mức 5	Tăng 2 giáp và 20% sức tấn công

b) Kích hoạt Colossus: là hành động kích hoạt tính năng đặc biệt của game. Chỉ có tác dụng với bên phòng thủ, chỉ tác dụng khi hai bên đã đánh nhau ít nhất một hiệp và chỉ có tác dụng khi người kích hoạt là người chủ của nhà bị tấn công. Khi bên phòng thủ đã kích hoạt thì quân đội đối phương sẽ bị mất tích một số quân nhất định trong một khoảng thời gian nhất định. Thời gian hiệu lực: ngay lập tức. Thời gian tối thiểu giữa 2 lần kích hoạt lò: có các giá trị khác nhau gồm 3 ngày, 1 ngày 12 giờ, 1 ngày, 18 giờ. Giá trị này tùy thuộc vào điều kiện của người muốn kích hoạt
Colossus mức 1	10% quân địch mất tích, thời gian tan rã 4h30m
Colossus mức 2	20% quân địch mất tích, thời gian tan rã 5h
Colossus mức 3	30% quân địch mất tích, thời gian tan rã 5h30m
Colossus mức 4	50% quân địch mất tích, thời gian tan rã 6h
Colossus mức 5	100% quân địch mất tích, thời gian tan rã 7h
c) Các vị trí tấn công:
Một số loại quân chỉ đứng ở một vị trí nhất định, một số quân có thể đứng ở tối đa hai vị trí khác nhau. Nếu nhiều đơn vị có thể xếp trong 1 vị trí thì sẽ phải bố trí theo độ ưu tiên.
Đây là danh sách các vị trí trống có thể đặt quân. Số lượng các ô và số quân có trong một ô tùy thuộc vào cấp độ của nhà Town Hall. Chẳng hạn ở hình dưới đây là số ô khi nhà Town Hall cấp 23.

Chi tiết đọc ở: http://ikariam.wikia.com/wiki/Land_battle

Chú ý: để đơn giản, giả sử rằng nếu không có đầu bếp thì sau mỗi hiệp quân đội sẽ bị mất 25% sĩ khí. Nếu có 1 đầu bếp thì sau mỗi hiệp, sĩ khí sẽ khôi phục được 2%. Ngoài ra giả sử rằng không bên nào có bác sĩ.
d) Garrison Limit:
Với quân đội trú trong thành, nếu số quân là giới hạn (nhỏ hơn mức Garrison Limit) thì khi bị tấn công, quân địch sẽ phải công phá tường trước.
Nếu số quân trú trong thành lớn hơn mức Garrison Limit, quân địch sẽ tấn công trực tiếp với quân đồn trú. Mỗi hiệp đánh nhau, quân đồn trú sẽ chết dần và nếu đến lúc quân đồn trú ít hơn mức Garrison Limit thì quân địch sẽ công phá tường.
Chi tiết của Garrison Limit: 
http://ikariam.wikia.com/wiki/Garrison_limit
e) Nâng cấp công, giáp:
Đa số đơn vị (trừ Spartan, đầu bếp, bác sĩ, tàu tender) đều có thể nâng cấp tối đa lên thêm 3 đơn vị công và 3 đơn vị thủ. Chi tiết xem ở:
http://ikariam.wikia.com/wiki/Building:Workshop/Unit
SV cần xác định sức công giáp của từng loại quân ở Ikariam (trên mạng Internet).
f) Tác động công phá:
Có một số luật ngầm định không được ghi trong Ikariam như sau
Khi tấn công vào quân đội không tường thì sức công phá của Ram, Bắn đá và pháo ngang nhau và sức công phá đó đều bằng Ram.
Khi pháo bắn vào robot thì sức công phá của pháo đạt được mức như bình thường.
Khi quân tấn công gặp tường thì lực lượng xạ thủ (SC), bắn cung, ném đá không tấn công vào tường. 
Khi quân phòng thủ có tường thì lực lượng xạ thủ, bắn cung, ném đá (của bên phòng thủ) vẫn tấn công bên địch.
g) Thời gian chuyển quân:
Thời gian giữa 2 hiệp đấu là 15 phút. Thời gian di chuyển (bằng thuyền) từ đảo này (ví dụ: 50:50) sang đảo bên cạnh (ví dụ: 50:51) là 20m. Nếu các đảo có tọa độ càng xa nhau thì thời gian càng lâu (chẳng hạn từ 50:50 đến 51:51 sẽ là 20*sqrt(2)).
Thời gian di chuyển từ một nhà sang nhà khác cùng đảo là tùy thuộc vào từng loại quân. Chẳng hạn: Hop, kiếm, xạ thủ, ném lao, ném đá là 10m. Robot, pháo, ram, bắn đá, bác sĩ là 15m. Bong bóng là 30m còn máy bay là 7m30s.
Nếu một đạo quân di chuyển sang nhà khác có nhiều loại quân khác nhau thì thời gian di chuyển bằng thời gian đi của loại quân đi chậm nhất.
Khi một đạo quân sắp đánh hiệp tiếp theo, mà người chơi bấm rút quân. Thì đạo quân đó sẽ tiếp tục đánh nốt hiệp cuối rồi tan rã. Thời gian tan rã bằng 1 giờ cộng với thời gian quay về từ nơi tấn công đến nơi xuất phát.
3) Minh họa cuộc tấn công bộ:
a) Trận 1: bên tấn công chưa nâng cấp đầy đủ cho Ram (Ram thiếu giáp 3). Các quân khác đều đã nâng cấp đầy đủ. Bên phòng thủ đã nâng cấp hết cho quân.
Ban đầu bên tấn công gửi 105 SC, 675 kiếm, 421 Hop, 90 robot, 60 máy bay, 30 ram, 23 bắn đá, 30 pháo, 10 đầu bếp.
Bên phòng thủ có 176 súng, 350 kiếm, 350 Hop, 171 máy bay, 10 bong bóng, 30 ram, 36 pháo, 30 đầu bếp.
Tường của bên phòng thủ là tường 26.
Hiệp này pháo của bên tấn công đã bắn 27% cơ số đạn, máy bay đã bắn 12% cơ số đạn, số máu còn lại của 22 máy bay kia là 86%. Sĩ khí tụt mất 5%
Hiệp này súng của bên phòng thủ đã bắn 13% cơ số đạn, pháo đã bắn 22% cơ số đạn, máy bay đã bắn 6% cơ số đạn và số máu còn lại của 36 máy bay kia là 96%. Sĩ khí của bên phòng thủ là 100%.
Khối tường bị phá một phần còn 27% máu.
===================================================
Sang hiệp hai:
Hiệp này bên tấn công đã kích hoạt lò cấp 5.
 
Hiệp HAI, pháo của bên tấn công đã bắn 53% cơ số đạn, máy bay đã bắn 29% cơ số đạn, số máu còn lại của 20 máy bay kia là 86%. Do quân phòng thủ đã xông trận nên súng của xạ thủ đã bắn được 22%. Sĩ khí tiếp tục tụt thêm 5% nữa.
Hiệp HAI, súng của bên phòng thủ đã bắn 27% cơ số đạn, pháo đã bắn 44% cơ số đạn, máy bay đã bắn 12% cơ số đạn và số máu còn lại của 20 máy bay kia là 76%.
Khối tường bị phá một phần còn 85% máu.
===================================================
Sang hiệp ba:
Ở hiệp này, bên tấn công gửi thêm 116 máy bay.
 
Hiệp BA, pháo của bên tấn công đã bắn 80% cơ số đạn, máy bay 1 nhóm đã bắn 4% cơ số đạn và còn 89% máu, một nhóm thì đã bắn 37% số đạn và còn 80% máu. Xạ thủ đã bắn được lượt tiếp theo và còn 56% số đạn. Sĩ khí tiếp tục tụt thêm 5% nữa.
Hiệp BA, súng của bên phòng thủ còn 60% cơ số đạn, pháo còn 33% cơ số đạn, máy bay còn 82% cơ số đạn và số máu còn lại của 18 máy bay kia là 73%.
===================================================
Sang hiệp bốn:
Ở hiệp này do tường đã bị phá hoàn toàn nên quân hai cánh tràn ra đánh nhau.
 
Hiệp BỐN, pháo của bên tấn công đã bắn hết cơ số đạn, bắn đá đã tham chiến và bắn 5% cơ số đạn, máy bay đã bắn 13% cơ số đạn và còn 88% máu. Xạ thủ đã bắn được lượt tiếp theo và còn 33% số đạn. Những kiếm tham chiến thì mất 11% máu. Sĩ khí tiếp tục tụt thêm 5% nữa. Máu của Hop tham chiến thì còn 80%. Máu của robot tham chiến thì nhóm 13 con còn 81% máu, nhóm còn lại còn 78% máu. Hop cũng chết quá nhiều, không đủ lấp đầy hàng đầu tiên nên robot đã xuất hiện.
Ở đây, những máy bay ập đến của bên tấn công đã thay thế hoàn toàn máy bay cũ, những máy bay mới này còn nhiều máu và còn nhiều cơ số đạn.
Hiệp BỐN, súng của bên phòng thủ còn 47% cơ số đạn, pháo còn 11% cơ số đạn, máy bay còn 77% cơ số đạn và số máu còn lại của 12 máy bay kia là 75%. Kiếm ở bên tham chiến thì còn 99% máu. Nhóm 2 hop (đã chết 13 Hop) thì còn 69% máu.
Ở đây, do số Hop đã chết quá nhiều, không đủ lấp đầy hàng đầu tiên nên kiếm đã xuất hiện ở hàng đầu.
===================================================
Sang hiệp năm:
 
Hiệp NĂM, bắn đá còn 79% cơ số đạn, máy bay còn 78% cơ số đạn và còn 83% máu. Xạ thủ đã bắn được lượt tiếp theo và còn 11% số đạn. Những kiếm tham chiến thì không bị mất máu. Sĩ khí tiếp tục tụt thêm 5% nữa. Máu của Hop tham chiến thì còn 78%. Máu của robot tham chiến thì nhóm 13 con còn 89% máu, nhóm còn lại còn 83% máu. Chú ý rằng nhóm robot có sự thay đổi luân phiên, nhóm robot ở hiệp 4 đã được thay ngay lập tức bằng nhóm robot khác. (Ikariam tự động thay)
Hiệp NĂM, súng của bên phòng thủ còn 47% cơ số đạn (không kịp bắn đã chết), pháo còn 0% cơ số đạn (kịp bắn), máy bay còn 71% cơ số đạn và số máu còn lại của 10 máy bay kia là 73%. 
===================================================
Sang hiệp sáu:
 
Hiệp SÁU, bắn đá còn 79% cơ số đạn (không kịp bắn thì đối phương ở phía trước đã chết hết), máy bay còn 70% cơ số đạn và còn 83% máu. Xạ thủ còn 11% số đạn (không kịp bắn thì đối phương đã chết hết). Những kiếm tham chiến thì không bị mất máu. Sĩ khí tiếp tục tụt thêm 5% nữa. Máu của Hop tham chiến thì còn 78%. Máu của robot tham chiến thì nhóm 13 con (ngoài cùng tay phải) còn 89% máu, các nhóm còn lại còn 79% máu. 
Hiệp SÁU, súng của bên phòng thủ còn 47% cơ số đạn (không kịp bắn đã chết), máy bay còn 65% cơ số đạn và số máu còn lại của 10 máy bay kia là 63%. 
===================================================
Sang hiệp bảy:
 
Hiệp BẢY, bắn đá còn 79% cơ số đạn (không kịp bắn thì đối phương ở phía trước đã chết hết), máy bay còn 61% cơ số đạn và còn 81% máu. Xạ thủ còn 11% số đạn (không kịp bắn thì đối phương đã chết hết). Những kiếm tham chiến thì không bị mất máu. Sĩ khí tiếp tục tụt thêm 5% nữa. Máu của Hop tham chiến thì còn 78%. Máu của robot tham chiến đều còn 83%. 
Hiệp BẢY, súng của bên phòng thủ còn 47% cơ số đạn (không kịp bắn đã chết), máy bay còn 60% cơ số đạn và số máu còn lại của nhóm 1 máy bay kia là 93%. Số máu của nhóm 4 máy bay là 58%.
Do bên phòng thủ không còn quân bộ (trừ pháo) nên số quân còn lại bị mất tích trong 4h tiếp theo.
Đến đây thì phe tấn công đã chiến thắng.
b) Trận 2: 
Ban đầu quân địch đến tấn công
 
Quân phòng thủ có 505 Hop, 988 kiếm, 517 súng, 60 pháo, 100 máy bay, 30 đầu bếp. Tường của bên phòng thủ là tường 19.
Hiệp MỘT: 
Quân địch có lò cấp 5, phía tấn công không có lò.
 Bên tấn công: máy bay bắn 3% số đạn, máu còn 89%. Máu các ô robot lần lượt là: 93, 93, 81,81,81, 93, 95%. 
Bên phòng thủ: tường còn 45% máu. Súng đã bắn 5% đạn. Pháo còn 87% cơ số đạn. Máy bay bắn 10% đạn, máu còn 77%.
Sắp sang hiệp hai thì bên tấn công gửi 1357 Hop đến nữa.
===================================================
Sang hiệp hai:
 
Bên tấn công: máu của các ô Hop lần lượt là 91, 91, 98, 98, 98, 91, 91%. Đạn của máy bay còn 95%, máu máy bay còn 89%.
Lúc sắp sang hiệp 3 thì bên tấn công đã gửi đến 59 pháo. Đám pháo này sẽ tham chiến ở hiệp 3. Bên tấn công đã gửi 90 bong bóng đến. Đám đó sẽ tham chiến ở hiệp 5.
Bên phòng thủ: máu của máy bay là: 80%, đạn còn 71%. Đạn của súng còn 91%. Đạn của pháo còn 73%. Tường còn 37% máu.
===================================================
Sang hiệp ba:
Pháo của bên tấn công đã tham chiến.
 Bên tấn công: đạn của pháo còn 86%. Máy bay còn 92% đạn, máu còn 88%. Các ô Hop còn lần lượt (từ trái qua): 90, 90, 98, 98, 98, 90, 91%.
Bên phòng thủ: đạn của pháo còn 60%. Máy bay còn 70% đạn, 62% máu. Tường ở ô cuối cùng thì có 84% máu. Súng còn 86% đạn.
===================================================
Sang hiệp bốn:
 
Bên tấn công: đạn của pháo còn 73%. Máy bay còn 90% đạn, máu còn 87%. Súng bên tấn công còn 72%. Các ô Hop còn lần lượt (từ trái qua): 87, 82, 93, 93, 93, 87, 86%.
Bên phòng thủ: đạn của pháo còn 47%. Máy bay còn 64% đạn, 0% máu. Các ô Hop còn lại lần lượt (từ trái sang): 97, 100, 97, 97, 100, 97%. Súng còn 82% đạn.
===================================================
Sang hiệp năm:
 
Bên tấn công: đạn của pháo còn 59%. Súng bên tấn công còn 44%. Các ô Hop còn lần lượt (từ trái qua): 85, 84, 94, 94, 92, 85, 87%. Bong bóng còn 89% cơ số đạn. Máu của các ô kiếm đều còn là: 89%
Bên phòng thủ: đạn của pháo còn 44%. Các ô Hop còn lại lần lượt (từ trái sang): 97, 100, 97, 97, 100, 97, 99%. Súng còn 82% đạn. Máu của các ô kiếm đều còn 99%.
===================================================
Sang hiệp sáu:
 
Bên tấn công: đạn của pháo còn 46%. Súng bên tấn công còn 17%. Các ô Hop còn lần lượt (từ trái qua): 86, 86, 93, 93, 92, 86, 87%. Bong bóng còn 78% cơ số đạn. Máu của các ô kiếm đều còn là: 89%
Bên phòng thủ: đạn của pháo còn 42%. Các ô Hop còn lại lần lượt (từ trái sang): 12, 94, 93, 93, 95, 95%. Súng còn 73% đạn. Máu của các ô kiếm đều còn 94%.
===================================================
Sang hiệp bảy:
c) Trận 3:
Bên tấn công gửi bong bóng đi trước. Còn một đội Hop, kiếm, bắn đá, ram, máy bay, đầu bếp đi sau. Như vậy đội bong bóng sẽ tham chiến vào hiệp 2.
Cả hai bên đều đã nâng đầy đủ công giáp cho quân đội. Bên phòng thủ có lò. Bên tấn công không có lò. Tường 28.
 
Bên tấn công: Máu của các Hop là 100%. Pháo đã bắn 33% cơ số đạn, bắn đá đã dùng 4% đạn.
Bên phòng thủ: phần tường bị tổn hại, thì số máu còn 47%. Ném đá đã dùng 20% cơ số đạn.
===================================================
Sang hiệp hai:
Bên tấn công: Máu của các Hop thì trừ ô chính giữa là 99%, còn các ô khác là 100%. Pháo còn 33% cơ số đạn, bắn đá đã dùng 8% đạn. Xạ thủ đã bắn 29% cơ số đạn. Bong bóng đã bắn 50% số đạn.
Bên phòng thủ: phần tường bị tổn hại nhiều nhất, thì số máu còn 15%. Hai phần tường còn lại số máu là 89%. Ném đá đã dùng 40% cơ số đạn.
Các ô ram lần lượt có số máu là: 47%, 47%, 47%, 58%.

===================================================
Sang hiệp ba:
 

Bên tấn công: Máu của các Hop thì các ô lần lượt là 99, 100, 100, 100, 100, 99, 99%. Pháo các ô đa số đã bắn hết cơ số đạn, bắn đá bị thay bằng pháo. Xạ thủ chưa kịp bắn thì quân địch đã chết hết. Bong bóng đã bắn 85% số đạn.
Bên phòng thủ: ném đá chưa kịp bắn đã chết. Bên phòng thủ do chỉ còn mỗi đầu bếp nên quân bị tan rã (phải 4h sau mới tập hợp được).
d) Trận 4:
Hiệp một: 
Cả hai bên đều không có lò. Bên phòng thủ tường 1. Bên tấn công đã cố ý sắp xếp sao cho bong bóng vào được hiệp 2.
Do tường quá thấp nên pháo bên tấn công mới bắn 1 lượt đã phá hủy hết tường và diệt sạch hàng sau của đối phương.
Pháo bên tấn công đã bắn 13%. Máu của các ô Hop đều là 100%.
Bên phòng thủ thì bắn đá đã kịp bắn 20% số đạn trước khi chết
 
======================================
Sang hiệp 2:
Bên tấn công pháo đã bắn 22% cơ số đạn. Xạ thủ chưa kịp bắn. Bong bóng đã bắn 25% cơ số đạn. 	
 
