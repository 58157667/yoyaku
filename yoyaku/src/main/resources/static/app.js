async function submitReservation() {

    const name =
        document.getElementById("name").value.trim();

    const email =
        document.getElementById("email").value.trim();

    const phone =
        document.getElementById("phone").value.trim();

    const reserveDate =
        document.getElementById("date").value;

    const reserveTime =
        document.getElementById("time").value;

    const service =
        document.getElementById("service").value;
const emailRegex =
    /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // 必填检查
    if (!name) {
        alert("名前は必須です");
        return;
    }

    if (!email) {
        alert("メールは必須です");
        return;
    }

if (!emailRegex.test(email)) {

    alert("メール形式が正しくありません");

    return;
}
    if (!phone) {
        alert("電話番号は必須です");
        return;
    }
 // 日付
    if (!reserveDate) {
        alert("日付は必須です");
        return;
    }

    // 時間
    if (!reserveTime) {
        alert("時間は必須です");
        return;
    }

    const data = {
        name,
        email,
        phone,
        reserveDate,
        reserveTime,
        service
    };

    try {

        const response = await fetch(
            "http://localhost:8080/api/reservations",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(data)
            }
        );

        const result = await response.text();

        alert(result);

    } catch (error) {

        console.error(error);

        alert("サーバーエラー");
    }
}