date = new Date();

year = date.getFullYear();
month = date.getMonth() + 1;
day = date.getDate();

document.getElementById("go-today").innerHTML = year + "년 " + month + "월 " + day + "일";

