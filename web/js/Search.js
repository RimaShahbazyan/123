searchRequest("");
function searchRequest(text) {
    let xhr = new XMLHttpRequest ();
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const data = JSON.parse(this.response);
            let html = "";
            for (let item of data) {
                 html += "<tr>" +
                    `<td> ${item.id}</td>` +
                    `<td> ${item.name}</td>` +
                    "</tr>";
            }
            document.getElementById ("table").innerHTML = html;
        } else {
            document.getElementById ("table").innerText = this.status.toString ();
        }

    };
    xhr.open ("POST", "http://localhost:8010/Search");
    xhr.send (document.getElementById ("search").value);
}
document.getElementById("search").addEventListener("keyup",searchRequest);